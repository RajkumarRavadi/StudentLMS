package com.example.lms.studentLMS.Models;

import com.example.lms.studentLMS.Enum.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String bookName;

    private Integer noOfPages;

    private String authorName;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    //this is a child for the author
    @JoinColumn
    //we have to use Many to One Mapping here
    @ManyToOne
    private Author author;
}
