package com.example.clientes.repository;

import com.example.clientes.entity.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository  extends PagingAndSortingRepository<Client, Integer> {
}
