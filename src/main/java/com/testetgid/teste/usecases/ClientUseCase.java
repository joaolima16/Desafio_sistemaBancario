package com.testetgid.teste.usecases;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testetgid.teste.Repositories.ClientRepository;
import com.testetgid.teste.entities.Client;
import com.testetgid.teste.entities.Company;
import com.testetgid.teste.entities.Transaction;

@Service
public class ClientUseCase {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TransactionUseCase transactionUseCase;

    @Autowired
    private CompanyUseCase companyUseCase;

    public Transaction deposit(String cpf, String cnpj, BigDecimal value) {

        Client client = findByCpf(cpf);
        Company company = companyUseCase.findByCnpj(cnpj);
        BigDecimal rate = new BigDecimal(company.getRate());
        BigDecimal newValue = value.add(rate);

        BigDecimal newBalance = newValue.add(company.getBalance());
        Company newCompany = companyUseCase.updateBalance(company.getId(), newBalance);

        Transaction transaction = transactionUseCase.addTransaction(newCompany, client, newValue, "Deposito");

        return transaction;
    }

    public Transaction withdraw(String cpf, String cnpj, BigDecimal value) {
        Client client = findByCpf(cpf);
        Company company = companyUseCase.findByCnpj(cnpj);
        BigDecimal rate = new BigDecimal(company.getRate());
        BigDecimal newValue = value.add(rate);
        boolean validBalance = companyUseCase.verifyBalanceCompany(newValue, company.getBalance());

        if (validBalance == false) {
            throw new RuntimeException("Não foi possível realizar o saque");
        }
        BigDecimal newBalance = company.getBalance().subtract(newValue);

        Company newCompany = companyUseCase.updateBalance(company.getId(), newBalance);

        Transaction transaction = transactionUseCase.addTransaction(newCompany, client, newValue, "Saque");

        return transaction;

    }

    public Client findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}
