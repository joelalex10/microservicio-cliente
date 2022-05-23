package com.example.clientes.bl;

import com.example.clientes.dto.AddressDto;
import com.example.clientes.dto.ClientDto;
import com.example.clientes.entity.Address;
import com.example.clientes.entity.Client;
import com.example.clientes.repository.AddressRepository;
import com.example.clientes.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AddressBl {
    private AddressRepository addressRepository;
    private static Logger LOGGER = LoggerFactory.getLogger(ClientBl.class);

    @Autowired
    public AddressBl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressDto> findAllAddress() {
        LOGGER.info("DATABASE: Iniciando consulta para obtener la lista de direcciones");
        List<Address> addressList = (List<Address>) this.addressRepository.findAll();
        List<AddressDto> addressDtoList =addressList.stream().map(address -> new AddressDto(
                address.getAddressId(),
                address.getAddress(),
                address.getPostalCode())
        ).collect(Collectors.toList());

        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener el listado de direcciones {}", addressDtoList);
        return addressDtoList;
    }
    public Address insertNewAddress(AddressDto addressDto){
        Address address = new Address();
        address.setAddress(addressDto.getAddress());
        address.setPostalCode(addressDto.getPostalCode());
        address.setStatus(1);

        Address newAddress =this.addressRepository.save(address);
        return newAddress;

    }

}
