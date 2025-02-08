package com.example.lms.studentLMS.Repositories;

import com.example.lms.studentLMS.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Author entity.
 * Extends JpaRepository to provide CRUD operations for Author.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    // No need to write implementation code; Spring Data JPA provides default methods.
}
