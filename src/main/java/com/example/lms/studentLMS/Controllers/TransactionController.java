package com.example.lms.studentLMS.Controllers;

import com.example.lms.studentLMS.Services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transactions")

public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PutMapping("issueBook")
    public ResponseEntity<?> issueBook(@RequestParam("cardId") Integer cardId,
                                    @RequestParam("bookId") Integer bookId){
        try {
            String result = transactionService.issueBook(cardId, bookId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
