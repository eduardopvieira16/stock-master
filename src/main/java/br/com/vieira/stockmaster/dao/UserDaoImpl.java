package br.com.vieira.stockmaster.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.vieira.stockmaster.mapper.UserMapper;
import br.com.vieira.stockmaster.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private final JdbcTemplate jdbcTemplate;

	public UserDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<User> listUser() {
		String listAll = "SELECT * FROM users u LEFT JOIN access_level al ON u.access_level_id_fk = al.access_level_id ORDER BY u.user_id ASC";
		return jdbcTemplate.query(listAll, new UserMapper());
	}

	@Override
	public List<User> listByNameUser(String user) {
		String listByName = "SELECT * FROM users u LEFT JOIN access_level al ON u.access_level_id_fk = al.access_level_id WHERE user_name LIKE ?";
		return jdbcTemplate.query(listByName, new UserMapper(), "%" + user + "%");
	}

	@Override
	public User searchByCodeUser(Integer id) {
		String searchByCode = "SELECT * FROM users u LEFT JOIN access_level al ON u.access_level_id_fk = al.access_level_id WHERE user_id = ?";
		return jdbcTemplate.queryForObject(searchByCode, new UserMapper(), id);
	}

	@Override
	public User createUser(User user) {
		String createUser = "INSERT INTO users (access_level_id_fk, user_name, user_email, user_password) VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(createUser, user.getAccessLevel(), user.getName(), user.getEmail(), user.getPassword());
		return user;
	}

	@Override
	public User updateUser(User user) {
		String updateUser = "UPDATE users SET access_level_id_fk = ?, user_name = ?, user_email = ?, user_password = ? WHERE user_id = ?";
		jdbcTemplate.update(updateUser, user.getAccessLevel(), user.getName(), user.getEmail(), user.getPassword(),
				user.getId());
		return user;
	}

	@Override
	public User deleteUser(Integer id) {
		String selectUser = "SELECT * FROM users WHERE user_id = ?";
		User toDelete = jdbcTemplate.queryForObject(selectUser, new UserMapper(), id);
		if (toDelete != null) {
			String deleteUser = "DELETE FROM users WHERE user_id = ?";
			jdbcTemplate.update(deleteUser, id);
			return toDelete;
		}
		return null;
	}
}
