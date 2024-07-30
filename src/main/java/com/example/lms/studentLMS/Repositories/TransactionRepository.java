package com.example.lms.studentLMS.Repositories;

import com.example.lms.studentLMS.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions, String> {

}
