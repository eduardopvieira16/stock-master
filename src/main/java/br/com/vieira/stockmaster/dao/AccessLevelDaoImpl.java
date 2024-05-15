package br.com.vieira.stockmaster.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.vieira.stockmaster.mapper.AccessLevelMapper;
import br.com.vieira.stockmaster.model.AccessLevel;

@Repository
public class AccessLevelDaoImpl implements AccessLevelDao {

    private final JdbcTemplate jdbcTemplate;

    public AccessLevelDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<AccessLevel> listAccessLevel() {
        String listAll = "SELECT * FROM access_level ORDER BY access_level_id asc";
        return jdbcTemplate.query(listAll, new AccessLevelMapper());
    }

    @Override
    public List<AccessLevel> listByNameAccessLevel(String accessLevel) {
        String listByName = "SELECT * FROM access_level WHERE access_level LIKE ?";
        return jdbcTemplate.query(listByName, new AccessLevelMapper(), "%" + accessLevel + "%");
    }

    @Override
    public AccessLevel searchByCodeAccessLevel(Integer id) {
        String searchByCode = "SELECT * FROM access_level WHERE access_level_id = ?";
        return jdbcTemplate.queryForObject(searchByCode, new AccessLevelMapper(), id);
    }

    @Override
    public AccessLevel createAccessLevel(AccessLevel accessLevel) {
        String createAccess = "INSERT INTO access_level (access_level) VALUES (?)";
        jdbcTemplate.update(createAccess, accessLevel.getLevel());
        return accessLevel;
    }

    @Override
    public AccessLevel updateAccessLevel(AccessLevel accessLevel) {
        String updateAccess = "UPDATE access_level SET access_level = ? WHERE access_level_id = ?";
        jdbcTemplate.update(updateAccess, accessLevel.getLevel(), accessLevel.getId());
        return accessLevel;
    }

    @Override
    public AccessLevel deleteAccessLevel(Integer id) {
        String deleteAccess = "SELECT * FROM access_level WHERE access_level_id = ?";
        AccessLevel toDelete = jdbcTemplate.queryForObject(deleteAccess, new AccessLevelMapper(), id);
        if (toDelete != null) {
            String deleteSql = "DELETE FROM access_level WHERE access_level_id = ?";
            jdbcTemplate.update(deleteSql, id);
            return toDelete;
        }
        return null;
    }
}
