package ru.bazhanov.project.clients.service;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.bazhanov.project.clients.dto.ClientDTO;
import ru.bazhanov.project.contacts.service.ContactsService;
import ru.bazhanov.project.model.Client;
import ru.bazhanov.project.model.Contact;
import ru.bazhanov.project.repository.ClientRepository;
import ru.bazhanov.project.repository.ContactRepository;


import java.util.LinkedList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientsService{

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ContactRepository contactRepository;

    @Override
    public Client save(ClientDTO clientDTO) {
        if(clientDTO.getSurname() == null || clientDTO.getName() == null || clientDTO.getDateOfBirthday() == null){
            return null;
        } else{
            Client newClient = clientRepository.save(new Client(clientDTO.getSurname(), clientDTO.getName(), clientDTO.getDateOfBirthday()));
            Contact newContact = new Contact();
            newContact.setName(clientDTO.getContactName());
            newContact.setPhone(clientDTO.getPhone());
            newContact.setClient(newClient);
            newClient.getContactSet().add(newContact);
            contactRepository.save(newContact);
            return newClient;
        }
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll(Sort.by(Sort.Order.asc("surname")));
    }

    @Override
    public List<Client> getCurrentClients() {
        return null;
    }

    @Override
    public Boolean deleteById() {
        return null;
    }

    @Override
    public Client getById() {
        return null;
    }
}
