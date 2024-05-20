package br.com.vieira.stockmaster.dao;

import java.util.List;

import br.com.vieira.stockmaster.model.User;

public interface UserDao {

	/* Only Read - List and Search */
	List<User> listUser();

	List<User> listByNameUser(String user);

	User searchByCodeUser(Integer id);

	/* Create - Update - Delete */
	User createUser(User user);

	User updateUser(User user);

	User deleteUser(Integer id);
}
