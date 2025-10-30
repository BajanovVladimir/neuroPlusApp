package ru.bazhanov.project.contacts.service;

import ru.bazhanov.project.model.Contact;

import java.util.List;

public interface ContactsService {
    Contact save(Contact contact);
    List<Contact> getAllContacts();
}
