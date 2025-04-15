package ru.bazhanov.project.clients.service;

import ru.bazhanov.project.model.Client;

import java.util.List;

public interface ClientsService {
    Boolean save();
    List<Client> getAllClients();
    List<Client> getCurrentClients();
    Boolean deleteById();
    Client getById();
}
