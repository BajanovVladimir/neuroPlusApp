package ru.bazhanov.identification.dao;

import ru.bazhanov.identification.dto.UserDTO;
import ru.bazhanov.identification.model.Person;

import java.util.List;


public interface UserDao {
      UserDTO getUserDTO(Person person);
      List<UserDTO> getListUserDTO(List<Person> personList);
}
