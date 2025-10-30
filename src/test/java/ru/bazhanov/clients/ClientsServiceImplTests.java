package ru.bazhanov.clients;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.bazhanov.project.clients.dto.ClientDTO;
import ru.bazhanov.project.clients.service.ClientsService;
import ru.bazhanov.project.model.Client;
import java.time.LocalDate;

@SpringBootTest
public class ClientsServiceImplTests {
    @Autowired
    ClientsService clientService;

    @Test
    public void test_that_client_save(){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName("Иван");
        clientDTO.setSurname("Иванов");
        clientDTO.setDateOfBirthday(LocalDate.of(2010,8,23));
        clientDTO.setContactName("Мама");
        clientDTO.setPhone("+79000000000");
        int clientListSize = clientService.getAllClients().size();
        Client saveClient = clientService.save(clientDTO);

        Assertions.assertEquals(clientListSize+1,clientService.getAllClients().size());
        Assertions.assertEquals("Иван",saveClient.getName() );
        Assertions.assertEquals(1,saveClient.getContactSet().size());
    }

    @Test
    public void test_that_client_is_NULL(){
        ClientDTO clientDTO = new ClientDTO();
        int clientListSize = clientService.getAllClients().size();
        Client saveClient = clientService.save(clientDTO);

        Assertions.assertEquals(clientListSize,clientService.getAllClients().size());
        Assertions.assertNull(saveClient);
    }
}
