package ru.bazhanov.web.identification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.bazhanov.identification.dao.UserDao;
import ru.bazhanov.identification.dao.UserDaoImpl;
import ru.bazhanov.identification.dto.UserDTO;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.model.User;
import ru.bazhanov.identification.repository.PersonRepository;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private PersonRepository personRepository;
    private final UserDao userDao = new UserDaoImpl();

    @GetMapping
    public ModelAndView showUsersView() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = ( principal instanceof User)? ((User) principal):new User();
        Person personUser = personRepository.findByUser(user);
        List<UserDTO> allPersonsUser = userDao.getListUserDTO(personRepository.findAll());
        ModelAndView mv = new ModelAndView("users/usersView");
        mv.addObject("personName", personUser.getName());
        mv.addObject("listPersons", allPersonsUser);
        return  mv;
    }

}
