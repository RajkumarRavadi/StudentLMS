package com.example.lms.studentLMS.Models;

import com.example.lms.studentLMS.Enum.CardStatus;
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
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;

    private Integer noOfBooksIssued;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    /**/
    //Now we are adding the FK to here to the child table
    //This has to be written in the child class

    @JoinColumn // which is use to add the PK of the Parent table to the child table
    @OneToOne // this is for the mapping purpose
    private Student student; // this refers the entity that we connected.


}
