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

import br.com.vieira.stockmaster.model.AccessLevel;
import br.com.vieira.stockmaster.service.AccessLevelService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/v1/access-level")
public class AccessLevelRestController {

    private final AccessLevelService accessLevelService;

    public AccessLevelRestController(AccessLevelService accessLevelService) {
        this.accessLevelService = accessLevelService;
    }

    @GetMapping(path = "/list/all")
    public ResponseEntity<List<AccessLevel>> listAllAccessLevels() {
        try {
            List<AccessLevel> accessLevels = accessLevelService.listAll();
            return new ResponseEntity<>(accessLevels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/list/name/{access_level}")
    public ResponseEntity<List<AccessLevel>> listByNameAccessLevels(@PathVariable("access_level") String accessLevel) {
        try {
            List<AccessLevel> accessLevels = accessLevelService.listByName(accessLevel);
            return new ResponseEntity<>(accessLevels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/search/{id}")
    public ResponseEntity<AccessLevel> searchByCodeLevel(@PathVariable("id") Integer id) {
        try {
            AccessLevel accessLevel = accessLevelService.searchByCode(id);
            return new ResponseEntity<>(accessLevel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<AccessLevel> saveAccessLevel(@RequestBody AccessLevel accessLevel) {
        try {
            AccessLevel savedAccessLevel = accessLevelService.saveAccess(accessLevel);
            return new ResponseEntity<>(savedAccessLevel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteAccessLevel(@PathVariable("id") Integer id) {
        try {
            accessLevelService.deleteAccessLevel(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
