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
    public List<AccessLevel> listAllAccessLevels() {
        try {
        	return accessLevelService.listAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(path = "/list/name/{access_level}")
    public List<AccessLevel> listByNameAccessLevels(@PathVariable("access_level") String accessLevel) {
        try {
        	return accessLevelService.listByName(accessLevel);
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }

    @GetMapping(path = "/search/{id}")
    public AccessLevel searchByCodeLevel(@PathVariable("id") Integer id) {
        try {
        	return accessLevelService.searchByCode(id);
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }

    @PostMapping
    public AccessLevel saveAccessLevel(@RequestBody AccessLevel accessLevel) {
        try {
        	return accessLevelService.saveAccess(accessLevel);
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public AccessLevel deleteAccessLevel(@PathVariable("id") Integer id) {
        try {
        	return accessLevelService.deleteAccessLevel(id);
        } catch (Exception e) {
            e.printStackTrace();
        	return null;
        }
    }
}
