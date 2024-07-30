package com.example.lms.studentLMS.Services;

import com.example.lms.studentLMS.Models.Author;
import com.example.lms.studentLMS.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service


public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public String addAuthor(Author author){
        author = authorRepository.save(author);
        return "Author has been save to the DB " + author.getAuthorId();
    }

    public Author findAuthorById(Integer authorId) throws Exception{
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if(optionalAuthor.isEmpty()){
            throw new Exception("Invalid author Id");
        }

        return optionalAuthor.get();
    }
}