package com.example.clientes.controller;

import com.example.clientes.bl.ClientBl;
import com.example.clientes.dto.ClientDto;
import com.example.clientes.entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/api/client")
public class ClientController {

    private static Logger LOGGER = LoggerFactory.getLogger(ClientBl.class);

    private ClientBl clientBl;

    @Autowired
    public ClientController(ClientBl clientBl) {
        this.clientBl = clientBl;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllClients() {
        //LOGGER.info("Invocando al servicio REST para obtener el listado de autores con KEY: {}", key);
        List<ClientDto> clientList = clientBl.findAllClients();
        LOGGER.info("Invocacion exitosa para obtener el listado de autores {}", clientList);
        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }
    @RequestMapping(path = "/{idClient}",method = RequestMethod.GET)
    public ResponseEntity<?> getClientById(@PathVariable("idClient") Integer id) {
        ClientDto clientDto =this.clientBl.findClientById(id);
        if(Objects.nonNull(clientDto)){
            return new ResponseEntity<>(clientDto, HttpStatus.OK);
        }else{

            return new ResponseEntity<>("NO SE ENCONTRO CLIENTE", HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postClients(@RequestBody ClientDto clientDto) {
        Client client = this.clientBl.insertNewClient(clientDto);
        if(Objects.nonNull(client)){
            return new ResponseEntity<>(client, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("NO SE PUEDO REALIZAR OPERACION",
                    HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(path = "/{idClient}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClient(@PathVariable("idClient") Integer id) {
        boolean result = this.clientBl.deleteClient(id);
        if(result){
            return new ResponseEntity<>("SE ELIMINO CLIENTE CORRECTAMENTE",
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<>("NO SE ENCONTRO CLIENTE",
                    HttpStatus.BAD_REQUEST);
        }
    }

}
