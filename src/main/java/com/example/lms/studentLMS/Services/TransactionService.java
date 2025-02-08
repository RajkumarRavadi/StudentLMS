package com.example.lms.studentLMS.Services;

import com.example.lms.studentLMS.Enum.TransactionStatus;
import com.example.lms.studentLMS.Models.Book;
import com.example.lms.studentLMS.Models.LibraryCard;
import com.example.lms.studentLMS.Models.Transactions;
import com.example.lms.studentLMS.Repositories.BookRepository;
import com.example.lms.studentLMS.Repositories.CardRepository;
import com.example.lms.studentLMS.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TransactionService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public String issueBook(int cardId, int bookId)throws Exception {

        //get book entity from bookId
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isEmpty()){
            throw new Exception("Invalid book id: " + bookId + "not exists");
        }

        Optional<LibraryCard> optionalLibraryCard = cardRepository.findById(cardId);
        if(optionalLibraryCard.isEmpty()){
            throw new Exception("The card with cardId : "+cardId+ " not exits");
        }

        Book book = optionalBook.get();
        LibraryCard card = optionalLibraryCard.get();

        //FAILURE: If the book is already issued
        if(book.isIssued()){
            throw new Exception("Book is already existed");
        }

        //FAILURE: If the card reached the max number of books limit
        if(card.getNoOfBooksIssued()==3){
            throw new Exception("Card has reached it's limit to take books");
        }

        //create a tnx entity
        Transactions transaction = new Transactions();

        //SUCCESS
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        //Set fk entities
        transaction.setBook(book);

        //Set book to isIssued
        transaction.setCard(card);

        //set noOfBooksIssued+1
        card.setNoOfBooksIssued(card.getNoOfBooksIssued()+1);

        transaction = transactionRepository.save(transaction);
        bookRepository.save(book);
        cardRepository.save(card);

        return "The transaction with transactionID"+ transaction.getTransactionId()+ "is save to the DB";


    }
}
