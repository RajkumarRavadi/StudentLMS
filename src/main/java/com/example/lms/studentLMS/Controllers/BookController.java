package com.example.lms.studentLMS.Controllers;

import com.example.lms.studentLMS.Models.Book;
import com.example.lms.studentLMS.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book")

public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("add")
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }


    @PutMapping("associateBookAndAuthor")
    public ResponseEntity associateBookAndAuthor(@RequestParam("bookId") Integer bookId,
                                                 @RequestParam("authorId") Integer authorId){
        try {
            String response = bookService.associateBookAndCard(bookId, authorId);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
