package Car_Inventory_System.used_cars;

import java.io.IOException;
//import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import carinventorydao.CarInventoryDAO;
import carinventorypojo.CarInventoryPojoClass;

public class CarInventoryMain 
{
	@Autowired
	private static ApplicationContext context;
	private static Scanner sc;
	private static CarInventoryDAO dao;

	
	public static void main( String[] args ) throws IOException
    {
    	System.out.println("Welcome to Mullet Joe's Gently Used Autos!");
    	sc = new Scanner(System.in);
    	System.out.println("Enter Command");
    	String input = sc.nextLine();
    	context = new ClassPathXmlApplicationContext("Beans.xml");
    	dao=(CarInventoryDAO) context.getBean("carinventorydao"); 
    	while(input != "Quit")
    	{
    		if(input.isEmpty())
    		{
    			break;
    		}
    		else {
    			switch(input)
    			{
    				case ("Add"):  	
    							System.out.println("Enter Company Name");
    							String make = sc.nextLine();
    							System.out.println("Enter Car Model");
    							String model = sc.nextLine(); 
    							System.out.println("Enter Model Year");
    							int year = sc.nextInt();
    							System.out.println("Enter Car Sales Price");
    							int salesPrice = sc.nextInt();
    							CarInventoryPojoClass pojo = new CarInventoryPojoClass();
    							pojo.setMake(make);
    							pojo.setModel(model);
    							pojo.setYear(year);
    							pojo.setSalesprice(salesPrice);
    							dao.saveData(pojo);
    							System.out.println("Data Saved Successfully");
    							input = "";
    							break;
    			
    				case "List": 	
    							List<CarInventoryPojoClass> carpojo = dao.fetchData();
    							carpojo.forEach(carDetails -> System.out.println(carDetails));
    							input = "";
            					break;
            					
    				default: 		
    							System.out.println("Invalid Command, PLease enter the Command Add,List");
            					System.out.println("Enter Command");
    							input = sc.nextLine();
            					
    			}
    			
    		}
    	}
    	System.out.println("Good Bye!");
    }
}
