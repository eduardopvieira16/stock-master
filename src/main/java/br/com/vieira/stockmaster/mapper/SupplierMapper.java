package br.com.vieira.stockmaster.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.vieira.stockmaster.model.Supplier;

public class SupplierMapper implements RowMapper<Supplier> {

	@Override
	public Supplier mapRow(ResultSet rs, int rowNum) throws SQLException {
		Supplier supplier = new Supplier();
		supplier.setId(rs.getLong("supplier_id"));
		supplier.setSupplier(rs.getString("supplier_name"));
		supplier.setTaxId(rs.getString("tax_id"));
		supplier.setEmail(rs.getString("email"));
		supplier.setPhone(rs.getString("phone"));
		supplier.setCelPhone(rs.getString("cel_phone"));
		supplier.setCep(rs.getString("cep"));
		supplier.setAddress(rs.getString("address"));
		supplier.setNumberAddress(rs.getString("number"));
		supplier.setNeighborhood(rs.getString("neighborhood"));
		supplier.setCity(rs.getString("city"));
		supplier.setUf(rs.getString("uf"));
		return supplier;

	}

}
