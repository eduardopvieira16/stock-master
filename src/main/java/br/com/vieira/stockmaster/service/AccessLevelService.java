package br.com.vieira.stockmaster.service;

import java.util.List;

import br.com.vieira.stockmaster.model.AccessLevel;

public interface AccessLevelService {
	/* Only Read - List and Search */
	List<AccessLevel> listAll();
	List<AccessLevel> listByName(String accessLevel);
	AccessLevel searchByCode(Integer code);
	/* Create - Update - Delete */
	AccessLevel saveAccess(AccessLevel accessLevel);
	AccessLevel deleteAccessLevel(Integer id);
}
