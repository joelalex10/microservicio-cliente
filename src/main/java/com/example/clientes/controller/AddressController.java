package com.example.clientes.controller;

import com.example.clientes.bl.AddressBl;
import com.example.clientes.bl.ClientBl;
import com.example.clientes.dto.AddressDto;
import com.example.clientes.entity.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
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

    @RequestMapping(path = "/{idAddress}",method = RequestMethod.GET)
    public ResponseEntity<?> getAddressById(@PathVariable("idAddress") Integer id) {
        AddressDto addressDto = this.addressBl.findAddressById(id);
        if(Objects.nonNull(addressDto)){
            return new ResponseEntity<>(addressDto, HttpStatus.OK);
        }else{

            return new ResponseEntity<>("NO SE ENCONTRO DIRECCION", HttpStatus.BAD_REQUEST);
        }

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
    @RequestMapping(path = "/{idAddress}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClient(@PathVariable("idAddress") Integer id) {
        boolean result = this.addressBl.deleteAddress(id);
        if(result){
            return new ResponseEntity<>("SE ELIMINO DIRECCION CORRECTAMENTE",
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<>("NO SE ENCONTRO DIRECCION",
                    HttpStatus.BAD_REQUEST);
        }
    }
}
