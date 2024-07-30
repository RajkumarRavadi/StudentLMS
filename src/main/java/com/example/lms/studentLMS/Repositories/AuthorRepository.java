package com.example.lms.studentLMS.Repositories;


import com.example.lms.studentLMS.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
