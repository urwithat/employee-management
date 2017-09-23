package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import services.model.Employee;
import services.dao.EmployeeDao;
import services.dao.DB;

@SpringBootApplication
public class ServicesApplication implements CommandLineRunner {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public static void main(String[] args) {
		SpringApplication.run(ServicesApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		DB.setEmployeeDao(employeeDao);
		
		// Clear Employees Data
		DB.getEmployeeDao().deleteAll();
		
		// Store Employees
//		DB.getEmployeeDao().save(new Employee("ABC024", "User1", "Admin", "male", "user1@gmail.com"));
//		DB.getEmployeeDao().save(new Employee("ABC048", "User2", "Developer", "female", "user2@gmail.com"));
//		DB.getEmployeeDao().save(new Employee("ABC060", "User3", "Architect", "male", "user3@gmail.com"));
//		DB.getEmployeeDao().save(new Employee("ABC082", "User4", "Tester", "male", "user4@gmail.com"));
//		DB.getEmployeeDao().save(new Employee("ABC204", "User5", "Manager", "female", "user5@gmail.com"));
//		DB.getEmployeeDao().save(new Employee("ABC226", "User6", "DevOps", "male", "user6@gmail.com"));
//		DB.getEmployeeDao().save(new Employee("ABC248", "User7", "Sys", "male", "user7@gmail.com"));
//		DB.getEmployeeDao().save(new Employee("ABC260", "User8", "User", "female", "user8@gmail.com"));
//		DB.getEmployeeDao().save(new Employee("ABC282", "User9", "Master", "male", "user9@gmail.com"));
//		DB.getEmployeeDao().save(new Employee("ABC304", "User10", "Super", "female", "user10@gmail.com"));
		
		
		
	}
	
	
}
