package com.testetgid.teste.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testetgid.teste.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByCnpj(String cnpj);
}
