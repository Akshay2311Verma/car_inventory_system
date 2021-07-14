package carinventorydao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import carinventorymapper.CarInventoryMapper;
import carinventorypojo.CarInventoryPojoClass;

public class CarInventoryDAO {

	@Autowired
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void saveData(CarInventoryPojoClass pojo)
	{
		String insertQuery = "insert into used_car_catalog values('"+pojo.getMake()+"', '"+pojo.getModel()+"', "+pojo.getYear()+", "+pojo.getSalesprice()+")";
		template.update(insertQuery);
	}
	
	public List<CarInventoryPojoClass> fetchData()
	{
		List<CarInventoryPojoClass> list = template.query("Select * from used_car_catalog", new CarInventoryMapper());
		return list;
		
	}
	
}
