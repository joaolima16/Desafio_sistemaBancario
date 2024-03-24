package com.testetgid.teste.resources;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testetgid.teste.Service.EmailService;
import com.testetgid.teste.entities.Transaction;
import com.testetgid.teste.usecases.ClientUseCase;
import com.testetgid.teste.usecases.TransactionUseCase;

@RestController
@RequestMapping(value = "/client")
public class ClientResource {

    @Autowired
    ClientUseCase clientUseCase;

    @Autowired
    TransactionUseCase transactionUseCase;

    @Autowired
    EmailService emailService;

    @PostMapping("/deposit")
    public ResponseEntity depositClient(@RequestParam String cpf, @RequestParam String cnpj,
            @RequestParam BigDecimal value) {
        Transaction transaction = clientUseCase.deposit(cpf, cnpj, value);

        return ResponseEntity.ok().body(transaction);

    }

    @PostMapping("/withdraw")
    public ResponseEntity withdrawClient(@RequestParam String cpf, @RequestParam String cnpj,
            @RequestParam BigDecimal value) {
        Transaction transaction = clientUseCase.withdraw(cpf, cnpj, value);
        return ResponseEntity.ok().body(transaction);
    }

}
