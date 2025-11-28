package ru.bazhanov.project.clients.service;

import ru.bazhanov.project.clients.dto.ClientDTO;
import ru.bazhanov.project.model.Client;
import ru.bazhanov.project.model.Contact;

import java.util.List;

public interface ClientsService {
    Client save(ClientDTO clientDTO);
    List<Client> getAllClients();
    Client getById(int id);
    Boolean clientAddContact(Client client, Contact contact);

}
