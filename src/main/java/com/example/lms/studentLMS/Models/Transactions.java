package com.example.lms.studentLMS.Models;

import com.example.lms.studentLMS.Enum.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @CreationTimestamp
    private Date issueDate;
    private Date returnDate;

    private Integer fineAmt;


    @JoinColumn
    @ManyToOne
    private LibraryCard card;

    @JoinColumn
    @ManyToOne
    private Book book;



}
