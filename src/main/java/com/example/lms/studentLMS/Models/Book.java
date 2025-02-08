package com.example.lms.studentLMS.Models;

import com.example.lms.studentLMS.Enum.Genre; //importing the enum
import jakarta.persistence.*;  //importing the JPApi for the entity connection to the DB
import lombok.AllArgsConstructor; // creates a constructor with all args using lombok dependency
import lombok.Getter;     // creates all field getters using lombok  dependency
import lombok.NoArgsConstructor;  // creates a constructor with no args using lombok dependency
import lombok.Setter;  // creates all field setters using  lombok dependency

@Entity // used to make the current class as a table in the db
@Table //used to define the table name here it is default so Book table
@AllArgsConstructor // creates a constructor with all args using lombok dependency
@NoArgsConstructor  // creates a constructor with no args using lombok dependency
@Getter    // creates all field getters using lombok  dependency
@Setter   // creates all field setters using  lombok dependency

/*
This is the representation of the book entity
means book table in the database
 */
public class Book {
    @Id //set the current field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String bookName;

    private Integer noOfPages;

    private boolean isIssued;
    //let us assume each book has only 1 copy


    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    //this is a child for the author
    //hence book will always depend  on an author
    @JoinColumn
    //we have to use Many to One Mapping here
    @ManyToOne
    private Author author;
}
