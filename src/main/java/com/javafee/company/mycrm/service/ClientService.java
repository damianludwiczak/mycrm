package com.javafee.company.mycrm.service;

import com.javafee.company.mycrm.controller.dto.ClientDto;
import com.javafee.company.mycrm.repository.domain.Client;
import com.javafee.company.mycrm.repository.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public void save(ClientDto clientDto) {
        clientRepository.save(fromClientDtoToClient(clientDto));
    }

    public void update(ClientDto clientDto, Long id) {
        clientRepository.findById(id).orElseThrow();
        clientRepository.save(fromClientDtoToClient(clientDto));
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
    public List<ClientDto> filter(String name, String surname, String nationality, Double wageFrom, Double wageTo,
                                  Integer ageFrom, Integer ageTo) {
        List<Client> clientList = clientRepository.findByCriteria(
                                            name, surname, nationality, wageFrom, wageTo, ageFrom, ageTo);
        List<ClientDto> clientDtoList = new ArrayList<>();
        for (Client client : clientList)
            clientDtoList.add(fromClientTocClientDto(client));
        return clientDtoList;
    }

    public List<ClientDto> findAll() {
        List<ClientDto> clientDtoList = new ArrayList<>();
        List<Client> clientList = clientRepository.findAll();
        for (Client client : clientList)
            clientDtoList.add(fromClientTocClientDto(client));
        return clientDtoList;
    }

    private Client fromClientDtoToClient (ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setSurname(clientDto.getSurname());
        client.setNationality(clientDto.getNationality());
        client.setWage(clientDto.getWage());
        client.setAge(clientDto.getAge());
        return client;
    }

    private ClientDto fromClientTocClientDto (Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setSurname(client.getSurname());
        clientDto.setNationality(client.getNationality());
        clientDto.setWage(client.getWage());
        clientDto.setAge(client.getAge());
        return clientDto;
    }
}
