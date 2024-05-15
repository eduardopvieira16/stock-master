package br.com.vieira.stockmaster.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.vieira.stockmaster.dao.AccessLevelDao;
import br.com.vieira.stockmaster.model.AccessLevel;

@Service
public class AccessLevelServiceImpl implements AccessLevelService {

    private final AccessLevelDao accessLevelDao;

    public AccessLevelServiceImpl(AccessLevelDao accessLevelDao) {
        this.accessLevelDao = accessLevelDao;
    }

    @Override
    public List<AccessLevel> listAll() {
        return accessLevelDao.listAccessLevel();
    }

    @Override
    public List<AccessLevel> listByName(String accessLevel) {
        return accessLevelDao.listByNameAccessLevel(accessLevel);
    }

    @Override
    public AccessLevel searchByCode(Integer code) {
        return accessLevelDao.searchByCodeAccessLevel(code);
    }

    @Override
    public AccessLevel saveAccess(AccessLevel accessLevel) {
        if (accessLevel.getId() == null) {
            return accessLevelDao.createAccessLevel(accessLevel);
        } else {
            return accessLevelDao.updateAccessLevel(accessLevel);
        }
    }

    @Override
    public AccessLevel deleteAccessLevel(Integer id) {
        return accessLevelDao.deleteAccessLevel(id);
    }
}
