package com.example.clientes.controller;

import com.example.clientes.bl.AddressBl;
import com.example.clientes.bl.ClientBl;
import com.example.clientes.dto.AddressDto;
import com.example.clientes.dto.ClientDto;
import com.example.clientes.entity.Address;
import com.example.clientes.entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/api/address")
public class AddressController {
    private static Logger LOGGER = LoggerFactory.getLogger(ClientBl.class);

    private AddressBl addressBl;

    @Autowired
    public AddressController(AddressBl addressBl) {
        this.addressBl = addressBl;
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllAddress() {
        //LOGGER.info("Invocando al servicio REST para obtener el listado de autores con KEY: {}", key);
        List<AddressDto> addressAllList = addressBl.findAllAddress();
        LOGGER.info("Invocacion exitosa para obtener el listado de autores {}", addressAllList);
        return new ResponseEntity<>(addressAllList, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postClients(@RequestBody AddressDto addressDto) {
        Address address = this.addressBl.insertNewAddress(addressDto);
        if(Objects.nonNull(address)){
            return new ResponseEntity<>(address, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("NO SE PUEDO REALIZAR OPERACION",
                    HttpStatus.BAD_REQUEST);
        }
    }
}
