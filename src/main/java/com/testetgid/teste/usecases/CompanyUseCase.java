package com.testetgid.teste.usecases;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testetgid.teste.Repositories.CompanyRepository;
import com.testetgid.teste.entities.Company;

@Service
public class CompanyUseCase {

    @Autowired
    CompanyRepository companyRepository;



    public Company findByCnpj(String cnpj) {
        return companyRepository.findByCnpj(cnpj).orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

    }

    public boolean verifyBalanceCompany(BigDecimal valueDeposit, BigDecimal valueCompany) {
        if (valueDeposit.compareTo(valueCompany) > 0) {
            return false;
        } else {
            return true;
        }
    }

    public Company updateBalance(long id, BigDecimal balance) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        company.setBalance(balance);
        companyRepository.save(company);
        return company;
    }
}
