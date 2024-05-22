package br.com.vieira.stockmaster.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.vieira.stockmaster.model.StockMovement;

public class StockMovementMapper implements RowMapper<StockMovement> {

    @Override
    public StockMovement mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
