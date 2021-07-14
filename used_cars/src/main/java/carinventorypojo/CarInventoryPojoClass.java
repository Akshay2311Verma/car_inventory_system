package carinventorypojo;

public class CarInventoryPojoClass {
	
		
	private String make;
	private String model;
	private int year;
	private int salesprice;
	
	
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getSalesprice() {
		return salesprice;
	}
	
	public void setSalesprice(int salesprice) {
		this.salesprice = salesprice;
	}

	@Override
	public String toString() {
		return "make=" + make + ", model=" + model + ", year=" + year + ", salesprice="
				+ salesprice;
	}
	
}
