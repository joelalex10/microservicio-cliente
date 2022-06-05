package com.example.clientes.bl;

import com.example.clientes.dto.AddressDto;
import com.example.clientes.entity.Address;
import com.example.clientes.entity.Client;
import com.example.clientes.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        List<AddressDto> addressDtoList =addressList.stream()
                .filter(
                        data ->  data.getStatus()==1
                ).map(
                        address -> new AddressDto(
                                address.getAddressId(),
                                address.getAddress(),
                                address.getPostalCode())
                ).collect(
                        Collectors.toList()
                );

        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener el listado de direcciones {}", addressDtoList);
        return addressDtoList;
    }
    public AddressDto findAddressById(Integer addressId){
        Optional<Address> optionalAddress= this.addressRepository.findById(addressId);
        if(optionalAddress.isPresent()){
            if(optionalAddress.get().getStatus()==1){
                AddressDto addressDto=new AddressDto();
                addressDto.setAddressId(optionalAddress.get().getAddressId());
                addressDto.setAddress(optionalAddress.get().getAddress());
                addressDto.setPostalCode(optionalAddress.get().getPostalCode());
                return addressDto;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
    public Address insertNewAddress(AddressDto addressDto){
        Address address = new Address();
        address.setAddress(addressDto.getAddress());
        address.setPostalCode(addressDto.getPostalCode());
        address.setStatus(1);

        Address newAddress =this.addressRepository.save(address);
        return newAddress;
    }
    public boolean deleteAddress(Integer addressId){
        Optional<Address> optionalAddress = this.addressRepository.findById(addressId);
        if(optionalAddress.isPresent()){
            Address address = optionalAddress.get();
            address.setStatus(0);
            this.addressRepository.save(address);
            return true;
        }else{
            return false;
        }
    }

    public Address updateAddress(Integer id,AddressDto addressDto) {
        Optional<Address> optionalAddress= this.addressRepository.findById(id);
        if(optionalAddress.isPresent()){
            Address address=optionalAddress.get();
            address.setAddress(addressDto.getAddress());
            address.setPostalCode(addressDto.getPostalCode());
            this.addressRepository.save(address);
            return address;
        }else{
            return null;
        }
    }
}
