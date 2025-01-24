package ru.bazhanov.web.identification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.bazhanov.identification.dao.UserDao;
import ru.bazhanov.identification.dao.UserDaoImpl;
import ru.bazhanov.identification.dto.UserDTO;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.model.User;
import ru.bazhanov.identification.repository.PersonRepository;
import ru.bazhanov.identification.service.user.UserService;

import java.util.List;

@Controller
@RequestMapping("/userDelete")
public class UserDeleteViewController {

    @Autowired
    private UserService userService;
    @Autowired
    private PersonRepository personRepository;
    private final UserDao userDao = new UserDaoImpl();

    @GetMapping
    public ModelAndView showUserDeleteView(@RequestParam(value = "userId") int userId){
        Person person = personRepository.findByUser(userService.findUserById(userId));
        UserDTO userDTO = new UserDaoImpl().getUserDTO(person);
        ModelAndView mv = new ModelAndView("/users/userDeleteView");
        mv.addObject("userDTO", userDTO);
        return mv;
    }

    @RequestMapping
    public ModelAndView deleteUser(@RequestParam(value = "userId") int userId){
        userService.deleteUser(userId);
        ModelAndView mv = new ModelAndView("redirect:/users");
        return mv;
    }
}
