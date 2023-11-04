package com.javafee.company.mycrm.controller;

import com.javafee.company.mycrm.controller.dto.ClientDto;
import com.javafee.company.mycrm.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class ClientController implements ClientApi {
    private final ClientService clientService;
    @Override
    public ResponseEntity<ClientDto> createClient(ClientDto clientDto) {
        clientService.save(clientDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteClient(Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<ClientDto>> filterClient(String name, String surname, String nationality, Double wageFrom, Double wageTo, Integer ageFrom, Integer ageTo, String companyName) {
        return ResponseEntity.ok(clientService.filter(name, surname, nationality, wageFrom, wageTo, ageFrom, ageTo));
    }
    @Override
    public ResponseEntity<ClientDto> updateClient(Long id, ClientDto clientDto) {
        clientService.update(clientDto, id);
        return ResponseEntity.ok(clientDto);
    }

    @Override
    public ResponseEntity<List<ClientDto>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }
}
