package ru.bazhanov.identification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.bazhanov.identification.dao.UserDAO;
import ru.bazhanov.identification.dao.UserDAOImpl;
import ru.bazhanov.identification.dto.UserDTO;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.repository.PersonRepository;

import java.util.List;

@SpringBootTest
public class UserDAOImplTests {
    @Autowired
    private PersonRepository personRepository;
    private UserDAO userDao = new UserDAOImpl();


    @Test
    public void test_that_detUserDTO_is_working(){
        Person person =  personRepository.findAll().get(0);
        UserDTO userDTO = userDao.getUserDTO(person);
        Assertions.assertEquals("ROLE_ADMIN", userDTO.getRole());
    }
    @Test
    public void test_that_detListUserDTO_is_working(){
        List<Person> personList =  personRepository.findAll();
        List<UserDTO> userDTOList = userDao.getListUserDTO(personList);
        Assertions.assertEquals(personList.size(), userDTOList.size());
        Assertions.assertEquals(personList.get(0).getName(), userDTOList.get(0).getPersonName());
        Assertions.assertEquals("ROLE_ADMIN", userDTOList.get(0).getRole());
    }
}
