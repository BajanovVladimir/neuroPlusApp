package ru.bazhanov.project.contacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bazhanov.project.model.Contact;
import ru.bazhanov.project.repository.ContactRepository;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService{
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
