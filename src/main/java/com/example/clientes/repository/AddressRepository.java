package com.example.clientes.repository;

import com.example.clientes.entity.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository  extends PagingAndSortingRepository<Address, Integer> {
}
