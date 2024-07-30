package com.example.lms.studentLMS.Services;

import com.example.lms.studentLMS.Models.Author;
import com.example.lms.studentLMS.Models.Book;
import com.example.lms.studentLMS.Repositories.AuthorRepository;
import com.example.lms.studentLMS.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public String addBook(Book book){
         book = bookRepository.save(book);
         return "Book has been save to the DB with Book Id "+ book.getBookId();
    }


    public String associateBookAndCard(Integer bookId, Integer authorId) throws Exception{
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isEmpty()){
            throw new Exception("Entered book Id is invalid");
        }

        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if(optionalAuthor.isEmpty()){
            throw new Exception("Entered author id is invalid");
        }

        Book book = optionalBook.get();
        Author author = optionalAuthor.get();

        book.setAuthor(author);
        author.setNoOfBooks(author.getNoOfBooks()+1);

        bookRepository.save(book);
        authorRepository.save(author);

        return "Book and author has been associated";


    }
}
