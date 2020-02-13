package com.ust.invoice.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.invoice.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAllByUserIdAndActive(Long userId, boolean active);
    
    Optional<Client> findByIdAndActive(Long userId, boolean active);
}