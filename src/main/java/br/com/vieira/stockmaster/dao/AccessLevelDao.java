package br.com.vieira.stockmaster.dao;

import java.util.List;

import br.com.vieira.stockmaster.model.AccessLevel;

public interface AccessLevelDao {

	/* Only Read - List and Search */
	List<AccessLevel> listAccessLevel();

	List<AccessLevel> listByNameAccessLevel(String accessLevel);

	AccessLevel searchByCodeAccessLevel(Integer code);

	/* Create - Update - Delete */
	AccessLevel createAccessLevel(AccessLevel accessLevel);

	AccessLevel updateAccessLevel(AccessLevel accessLevel);

	AccessLevel deleteAccessLevel(Integer id);
}
