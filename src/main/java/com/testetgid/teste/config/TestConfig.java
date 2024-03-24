package com.testetgid.teste.config;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.testetgid.teste.Repositories.ClientRepository;
import com.testetgid.teste.Repositories.CompanyRepository;
import com.testetgid.teste.entities.Client;
import com.testetgid.teste.entities.Company;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {

        // Empresas
        Company company_one = new Company(1, "1326276321", new BigDecimal("10000.50"), 1.50);
        Company company_two = new Company(2,"1223456789",  new BigDecimal("5500.50"), 2.75);
        Company company_three = new Company(3, "34578128",  new BigDecimal("3766.50"), 0.5);

        // Clientes
        Client client_one = new Client(1, "João", "314878877", "joaovitordlg23101@gmail.com");
        Client client_two = new Client(2, "Jorge", "1234567891", "bielmoura170@gmail.com");
        Client client_three = new Client(3,"Carlos", "878474878", "teste@teste.com");

        companyRepository.saveAll(Arrays.asList(company_one, company_two, company_three));
        clientRepository.saveAll(Arrays.asList(client_one, client_two, client_three));

    }

}
