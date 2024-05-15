package br.com.vieira.stockmaster.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.vieira.stockmaster.dao.UserDao;
import br.com.vieira.stockmaster.model.User;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> listAll() {
		return userDao.listUser();
	}

	@Override
	public List<User> listByName(String user) {
		return userDao.listByNameUser(user);
	}

	@Override
	public User searchByCode(Integer id) {
		return userDao.searchByCodeUser(id);
	}

	@Override
	public User saveUser(User user) {
		if (user.getId() == null) {
			return userDao.createUser(user);
		} else {
			return userDao.updateUser(user);
		}
	}

	@Override
	public User deleteUser(Integer id) {
		return userDao.deleteUser(id);
	}
}
