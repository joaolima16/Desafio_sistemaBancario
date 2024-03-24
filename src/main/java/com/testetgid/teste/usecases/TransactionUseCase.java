package com.testetgid.teste.usecases;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testetgid.teste.Repositories.TransactionRepository;
import com.testetgid.teste.Service.EmailService;
import com.testetgid.teste.entities.Client;
import com.testetgid.teste.entities.Company;
import com.testetgid.teste.entities.Transaction;

@Service
public class TransactionUseCase {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    EmailService emailService;

    public Transaction addTransaction(Company company, Client client, BigDecimal valueTransaction, String method) {
        
        Transaction transaction = new Transaction();
        transaction.setId_client(client.getId());
        transaction.setId_company(company.getId());
        transaction.setValueTransaction(valueTransaction);
        transaction.setMethod(method);
        transactionRepository.save(transaction);
        
        emailService.sendEmail(client.getEmail(), company.getCnpj(), method, valueTransaction);
        
        return transaction;
    }
}
