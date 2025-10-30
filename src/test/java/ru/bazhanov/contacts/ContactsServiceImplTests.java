package ru.bazhanov.contacts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.bazhanov.project.contacts.service.ContactsService;
import ru.bazhanov.project.model.Contact;

@SpringBootTest
public class ContactsServiceImplTests {

    @Autowired
    private ContactsService contactsService;

    @Test
    public void test_that_contact_save(){
         Contact contact = new Contact();
         contact.setName("Client1");
         contact.setPhone("+79145647865");
         int size = contactsService.getAllContacts().size();
         Contact saveContact = contactsService.save(contact);
        Assertions.assertEquals(size+1,contactsService.getAllContacts().size());
        Assertions.assertEquals("Client1", saveContact.getName());
    }
}
