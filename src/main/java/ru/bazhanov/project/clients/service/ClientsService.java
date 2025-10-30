package ru.bazhanov.project.clients.service;

import ru.bazhanov.project.clients.dto.ClientDTO;
import ru.bazhanov.project.model.Client;

import java.util.List;

public interface ClientsService {
    Client save(ClientDTO clientDTO);
    List<Client> getAllClients();
    List<Client> getCurrentClients();
    Boolean deleteById();
    Client getById();
}
