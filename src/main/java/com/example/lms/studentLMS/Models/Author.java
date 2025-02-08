package com.example.lms.studentLMS.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author entity representing the "AuthorInfo" table in the database.
 */
@Entity
@Table(name = "AuthorInfo")
@Getter  // Generates getter methods for all fields using Lombok
@Setter  // Generates setter methods for all fields using Lombok
@AllArgsConstructor  // Generates a constructor with all fields as arguments
@NoArgsConstructor   // Generates a no-argument constructor
public class Author {

    @Id  // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing primary key
    private Integer authorId;  // Unique ID for each author

    private String authorName; // Name of the author

    private Integer age; // Age of the author

    private Integer noOfBooks; // Number of books written by the author

    private double ratings; // Average rating of the author

    private String emailId; // Email ID of the author for contact purposes
}
