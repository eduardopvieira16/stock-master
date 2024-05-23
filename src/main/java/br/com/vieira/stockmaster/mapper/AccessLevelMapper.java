package br.com.vieira.stockmaster.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.vieira.stockmaster.model.AccessLevel;

public class AccessLevelMapper implements RowMapper<AccessLevel> {

    @Override
    public AccessLevel mapRow(ResultSet rs, int rowNum) throws SQLException {
        AccessLevel accessLevel = new AccessLevel();
        accessLevel.setId(rs.getInt("access_level_id"));
        accessLevel.setLevel(rs.getString("access_level"));
        return accessLevel;
    }
}
