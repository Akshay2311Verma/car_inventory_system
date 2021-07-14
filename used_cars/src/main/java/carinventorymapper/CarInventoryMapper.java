package carinventorymapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import carinventorypojo.CarInventoryPojoClass;

public class CarInventoryMapper implements RowMapper<CarInventoryPojoClass> {

	public CarInventoryPojoClass mapRow(ResultSet rs, int rowNum) throws SQLException {
		CarInventoryPojoClass carpojo = new CarInventoryPojoClass();
		carpojo.setMake(rs.getString("make"));
		carpojo.setModel(rs.getString("model"));
		carpojo.setYear(rs.getInt("year"));
		carpojo.setSalesprice(rs.getInt("sales_price"));
		return carpojo;
	}

	
}
