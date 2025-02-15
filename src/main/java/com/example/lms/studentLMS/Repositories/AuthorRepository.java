package com.example.lms.studentLMS.Repositories;

import com.example.lms.studentLMS.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Author entity.
 * Extends JpaRepository to provide CRUD operations for Author.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    //here we are defining findAuthorByEmailId And FindAuthorByRatingsGraterThan methods
    //no need to implement the methods they will get implemented automatically by the JPA Query
    Author findAuthorByEmailId(String emailId);
    List<Author> findAuthorsByRatingsGreaterThan(Double ratings);
    // No need to write implementation code; Spring Data JPA provides default methods.


    //we can also use the native SQL queries if required
    @Query(nativeQuery = true, value = "select * from author emailId =: emailId")
    Author findAuthorInfo(String emailId);
}

