package com.example.lms.studentLMS.Controllers;

import com.example.lms.studentLMS.Models.Author;
import com.example.lms.studentLMS.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling author-related API requests.
 */
@RestController
@RequestMapping("author") // Base URL for this controller
public class AuthorController {

    private final AuthorService authorService;

    // Constructor-based dependency injection (recommended over field injection)
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * API endpoint to add a new author.
     * @param author The author object received in the request body.
     * @return A success message.
     */
    @PostMapping("add")
    public String addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    /**
     * API endpoint to find an author by their ID.
     * @param authorId The ID of the author (received as a request parameter).
     * @return ResponseEntity containing the author data if found, otherwise an error message.
     */
    @GetMapping("findAuthorById")
    public ResponseEntity<?> findAuthorById(@RequestParam("id") Integer authorId) {
        try {
            Author authorResponse = authorService.findAuthorById(authorId);
            return ResponseEntity.ok(authorResponse); // Returns HTTP 200 OK with the author data
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); // Returns HTTP 400 with an error message
        }
    }
}
