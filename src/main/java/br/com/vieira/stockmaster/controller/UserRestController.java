package br.com.vieira.stockmaster.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vieira.stockmaster.model.User;
import br.com.vieira.stockmaster.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/v1/user")
public class UserRestController {
 
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/list/all")
    public List<User> listAllUsers() {
        try {
        	return userService.listAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(path = "/list/name/{user}")
    public List<User> listByNameUsers(@PathVariable("user") String user) {
        try {
        	return userService.listByName(user);
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }

    @GetMapping(path = "/search/{id}")
    public User searchByCodeUser(@PathVariable("id") Integer id) {
        try {
        	return userService.searchByCode(id);
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        try {
        	return userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public User deleteUser(@PathVariable("id") Integer id) {
        try {
        	return userService.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }
}
