package ru.bazhanov.identification.dao;
import ru.bazhanov.identification.dto.UserDTO;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.model.Role;

import java.util.LinkedList;
import java.util.List;


public class UserDAOImpl implements UserDAO {

    @Override
    public UserDTO getUserDTO(Person person ) {
        List<Role> userRoleList= person.getUser().getRoles().stream().toList();
        String userRole = userRoleList.get(0).getName();
        UserDTO userDTO = new UserDTO(person.getUser().getId(),person.getName(), person.getUser().getLogin(), person.getUser().getPassword(), userRole);
        return userDTO;
    }

    @Override
    public List<UserDTO> getListUserDTO(List<Person> personList) {
        List<UserDTO> userDTOList = new LinkedList<>();
        for (Person person:personList) {
            userDTOList.add(getUserDTO(person));
        }
        return userDTOList;
    }
}
