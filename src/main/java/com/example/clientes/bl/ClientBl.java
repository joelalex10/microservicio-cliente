package com.example.clientes.bl;

import com.example.clientes.dto.ClientDto;
import com.example.clientes.entity.Client;
import com.example.clientes.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Service
public class ClientBl {
    private ClientRepository clientRepository;
    private static Logger LOGGER = LoggerFactory.getLogger(ClientBl.class);

    @Autowired
    public ClientBl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public List<ClientDto> findAllClients() {
        LOGGER.info("DATABASE: Iniciando consulta para obtener la lista de clientes");
        List<Client> clientList = (List<Client>) this.clientRepository.findAll();
        List<ClientDto> clientDtoList =clientList.stream().map(client -> new ClientDto(
                client.getClientId(),
                client.getName(),
                client.getLastname(),
                client.getEmail(),
                client.getPhone(),
                client.getAddressId())
        ).collect(Collectors.toList());

        LOGGER.info("DATABASE-SUCCESS: Consulta exitosa para obtener el listado de clientes {}", clientDtoList);
        return clientDtoList;
    }
    public Client insertNewClient(ClientDto clientDto){
        Client client=new Client();
        client.setName(clientDto.getName());
        client.setLastname(clientDto.getLastname());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        client.setAddressId(clientDto.getAddressId());
        client.setStatus(1);

        Client newClient =this.clientRepository.save(client);
        return newClient;

    }
}
