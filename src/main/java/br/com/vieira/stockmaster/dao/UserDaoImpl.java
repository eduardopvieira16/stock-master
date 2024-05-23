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
		String listAll = "SELECT u.user_id,\n"
				+ "  u.user_name,\n"
				+ "  u.user_email,\n"
				+ "  u.user_password,\n"
				+ "  al.access_level_id,\n"
				+ "  al.access_level\n"
				+ "FROM users u\n"
				+ "  LEFT JOIN access_level al ON u.access_level_id_fk = al.access_level_id\n"
				+ "ORDER BY u.user_id ASC";
		return jdbcTemplate.query(listAll, new UserMapper());
	}

	@Override
	public List<User> listByNameUser(String user) {
		String listByName = "SELECT u.user_id,\n"
				+ "  u.user_name,\n"
				+ "  u.user_email,\n"
				+ "  u.user_password,\n"
				+ "  al.access_level_id,\n"
				+ "  al.access_level\n"
				+ "FROM users u\n"
				+ "  LEFT JOIN access_level al ON u.access_level_id_fk = al.access_level_id\n"
				+ "WHERE user_name LIKE ?";
		return jdbcTemplate.query(listByName, new UserMapper(), "%" + user + "%");
	}

	@Override
	public User searchByCodeUser(Integer id) {
		String searchByCode = "SELECT u.user_id,\n"
				+ "  u.user_name,\n"
				+ "  u.user_email,\n"
				+ "  u.user_password,\n"
				+ "  al.access_level_id,\n"
				+ "  al.access_level\n"
				+ "FROM users u\n"
				+ "  LEFT JOIN access_level al ON u.access_level_id_fk = al.access_level_id\n"
				+ "WHERE user_id = ?";
		return jdbcTemplate.queryForObject(searchByCode, new UserMapper(), id);
	}

	@Override
	public User createUser(User user) {
		String createUser = "INSERT INTO users (\n"
				+ "    access_level_id_fk,\n"
				+ "    user_name,\n"
				+ "    user_email,\n"
				+ "    user_password\n"
				+ "  )\n"
				+ "VALUES(?, ?, ?, ?)";
		Integer accessLevelIdFk = user.getAccessLevel().getId();
		jdbcTemplate.update(createUser, accessLevelIdFk, user.getName(), user.getEmail(), user.getPassword());
		return user;
	}

	@Override
	public User updateUser(User user) {
		String updateUser = "UPDATE users\n"
				+ "SET access_level_id_fk = ?,\n"
				+ "  user_name = ?,\n"
				+ "  user_email = ?,\n"
				+ "  user_password = ?\n"
				+ "WHERE user_id = ?";
		Integer accessLevelIdFk = user.getAccessLevel().getId();
		jdbcTemplate.update(updateUser, accessLevelIdFk, user.getName(), user.getEmail(), user.getPassword(),
				user.getId());
		return user;
	}

	@Override
	public User deleteUser(Integer id) {
		String selectUser = "SELECT u.user_id,\n"
				+ "  u.user_name,\n"
				+ "  u.user_email,\n"
				+ "  u.user_password,\n"
				+ "  al.access_level_id,\n"
				+ "  al.access_level\n"
				+ "FROM users u\n"
				+ "  LEFT JOIN access_level al ON u.access_level_id_fk = al.access_level_id\n"
				+ "WHERE user_id = ?";
		User toDelete = jdbcTemplate.queryForObject(selectUser, new UserMapper(), id);
		if (toDelete != null) {
			String deleteUser = "DELETE FROM users\n"
					+ "WHERE user_id = ?";
			jdbcTemplate.update(deleteUser, id);
			return toDelete;
		}
		return null;
	}
}
