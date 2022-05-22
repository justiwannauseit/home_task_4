package STUB.controller;

import STUB.dao.User;
import STUB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable long id) {
        return userRepository.getById(id);
    }

    @GetMapping("/get/all")
    public List<User> getAllUser() {
        return userRepository.getAllUsers();
    }

    @GetMapping("/add/random")
    public User addRandom() {
        return userRepository.add(User.createRandomUser());
    }

}
