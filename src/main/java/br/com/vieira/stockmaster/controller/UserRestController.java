package br.com.vieira.stockmaster.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<User>> listAllAccessLevels() {
        try {
            List<User> users = userService.listAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/list/name/{user_name}")
    public ResponseEntity<List<User>> listByNameAccessLevels(@PathVariable("user_name") String user) {
        try {
            List<User> users = userService.listByName(user);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/search/{id}")
    public ResponseEntity<User> searchByCodeLevel(@PathVariable("id") Integer id) {
        try {
            User user = userService.searchByCode(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<User> saveAccessLevel(@RequestBody User user) {
        try {
            User savedAccessLevel = userService.saveUser(user);
            return new ResponseEntity<>(savedAccessLevel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteAccessLevel(@PathVariable("id") Integer id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
