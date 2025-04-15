package ru.bazhanov.web.identification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.bazhanov.identification.dao.UserDAO;
import ru.bazhanov.identification.dao.UserDAOImpl;
import ru.bazhanov.identification.dto.UserDTO;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.service.user.UserService;
import java.util.List;


@Controller
@RequestMapping("/users")
public class UsersViewController {

    @Autowired
    private UserService userService;
    private final UserDAO userDao = new UserDAOImpl();

    @GetMapping
    public ModelAndView showUsersView() {
        Person personUser = userService.getPersonOfCurrentUser();
        List<UserDTO> allPersonsUser = userDao.getListUserDTO(userService.getAllPersonsOfUsers());
        ModelAndView mv = new ModelAndView("users/usersView");
        mv.addObject("personName", personUser.getName());
        mv.addObject("listPersons", allPersonsUser);
        return  mv;
    }

}
