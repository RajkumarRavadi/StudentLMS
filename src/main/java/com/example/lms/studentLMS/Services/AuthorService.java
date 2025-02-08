package com.example.lms.studentLMS.Services;

import com.example.lms.studentLMS.Models.Author;
import com.example.lms.studentLMS.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for handling business logic related to authors.
 */
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    // Constructor-based dependency injection (recommended over field injection)
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /**
     * Adds a new author to the database.
     * @param author The author object to be saved.
     * @return A success message with the author ID.
     */
    public String addAuthor(Author author) {
        author = authorRepository.save(author); // Saves the author to the database
        return "Author has been saved to the DB with ID: " + author.getAuthorId();
    }

    /**
     * Finds an author by their ID.
     * @param authorId The ID of the author to find.
     * @return The Author object if found.
     * @throws Exception if the author ID is invalid.
     */
    public Author findAuthorById(Integer authorId) throws Exception {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId); // Fetch author by ID

        // Check if author exists
        if (optionalAuthor.isEmpty()) {
            throw new Exception("Invalid author ID: " + authorId);
        }

        return optionalAuthor.get(); // Return the found author
    }
}
