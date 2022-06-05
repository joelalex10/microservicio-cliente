package com.example.clientes.repository;

import com.example.clientes.dto.ClientDetailsDto;
import com.example.clientes.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ClientRepository  extends PagingAndSortingRepository<Client, Integer> {

    @Query(value = "select new com.example.clientes.dto.ClientDetailsDto(a.clientId, a.name, a.lastname, a.email, a.phone, b.address) " +
            "from Client a, Address b " +
            "where a.addressId=b.addressId " +
            "and a.status=1 ")
    public List<ClientDetailsDto> findAllClientsDeatils();
}
