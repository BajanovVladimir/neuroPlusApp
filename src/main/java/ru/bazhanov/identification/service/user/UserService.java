package ru.bazhanov.identification.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.bazhanov.identification.dto.UserDTO;
import ru.bazhanov.identification.model.User;


import java.util.List;

public interface UserService extends UserDetailsService {
    Boolean save(UserDTO registrationDto);
    User findUserById(Integer userId);
    boolean deleteUser(Integer userId);

    List<User> allUsers();
}
