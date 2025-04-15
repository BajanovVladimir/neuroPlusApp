package ru.bazhanov.identification.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.bazhanov.identification.dto.UserDTO;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.model.Role;
import ru.bazhanov.identification.model.User;
import ru.bazhanov.identification.repository.PersonRepository;
import ru.bazhanov.identification.repository.RoleRepository;
import ru.bazhanov.identification.repository.UserRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PersonRepository personRepository;

    private final PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,PersonRepository personRepository,PasswordEncoder encoder ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.personRepository = personRepository;
        this.bCryptPasswordEncoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }


    public User findUserById(Integer userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElseThrow(RuntimeException::new);
    }
    public User findUserByLogin(String login)throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public Person getPersonOfCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = ( principal instanceof User)? ((User) principal):new User();
        return  personRepository.findByUser(user);
    }

    @Override
    public Person getPersonOfUser(User user) {
        return personRepository.findByUser(user);
    }

    @Override
    public List<Person> getAllPersonsOfUsers() {
        return personRepository.findAll();
    }


    public boolean deleteUser(Integer userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public Boolean save(UserDTO registrationDto) {
        User newUser = userRepository.findByLogin(registrationDto.getLogin());
        if(newUser != null){
            return false;
        }
        int roleId = Integer.parseInt(registrationDto.getRole());
        newUser = new User(registrationDto.getLogin(),bCryptPasswordEncoder.encode(registrationDto.getPassword()));
        Role role = roleRepository.findById(roleId).orElseThrow();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        newUser.setRoles(roles);
        User saveUser = userRepository.save(newUser);
        Person newPerson = new Person(registrationDto.getPersonName(), saveUser);
        personRepository.save(newPerson);
        return true;
    }
}
