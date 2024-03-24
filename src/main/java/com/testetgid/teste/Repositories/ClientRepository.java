package com.testetgid.teste.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testetgid.teste.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByCpf(String cpf);
}
