package br.com.vieira.stockmaster.service;

import java.util.List;

import br.com.vieira.stockmaster.model.User;

public interface UserService {

	/* Only Read - List and Search */
	List<User> listAll();

	List<User> listByName(String user);

	User searchByCode(Integer id);

	/* Create - Update - Delete */
	User saveUser(User user);

	User deleteUser(Integer id);
}
