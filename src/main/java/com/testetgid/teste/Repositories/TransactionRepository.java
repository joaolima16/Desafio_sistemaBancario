package com.testetgid.teste.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testetgid.teste.entities.Transaction;

public interface TransactionRepository extends JpaRepository <Transaction, Long>{
  
}
