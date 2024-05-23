package br.com.vieira.stockmaster.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.vieira.stockmaster.model.StockMovement;

public class StockMovementMapper implements RowMapper<StockMovement> {

	@Override
	public StockMovement mapRow(ResultSet rs, int rowNum) throws SQLException {
		StockMovement stockMovement = new StockMovement();
		stockMovement.setId(rs.getLong("stock_movement_id"));
		stockMovement.setMovementType(rs.getString("movement_type"));
		stockMovement.setQuantity(rs.getLong("quantity"));
		stockMovement.setMovementDate(rs.getTimestamp("movement_date"));
		stockMovement.setDescription(rs.getString("description"));
		stockMovement.setCategory(rs.getLong("category_id"), rs.getString("category"));
		stockMovement.setAccessLevel(rs.getInt("access_level_id_fk"), rs.getString("access_level"));
		stockMovement.setSupplier(rs.getLong("supplier_id"), rs.getString("supplier_name"), rs.getString("tax_id"),
				rs.getString("email"));
		stockMovement.setUser(rs.getLong("user_id"), rs.getString("user_name"), rs.getString("user_email"));
		return stockMovement;
	}
}
