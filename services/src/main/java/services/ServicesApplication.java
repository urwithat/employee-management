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
		DB.getEmployeeDao().save(new Employee("EMP56221935", "First Name 01", "Last Name 01", "male", "user01@employer.com"));
		DB.getEmployeeDao().save(new Employee("EMP56222335", "First Name 02", "Last Name 02", "female", "user02@employer.com"));
		DB.getEmployeeDao().save(new Employee("EMP56224535", "First Name 03", "Last Name 03", "male", "user03@employer.com"));
		DB.getEmployeeDao().save(new Employee("EMP56562190", "First Name 04", "Last Name 04", "male", "user04@employer.com"));
		DB.getEmployeeDao().save(new Employee("EMP50289935", "First Name 01", "Last Name 01", "male", "user01@employer.com"));
		DB.getEmployeeDao().save(new Employee("EMP56221935", "First Name 02", "Last Name 02", "female", "user02@employer.com"));
		DB.getEmployeeDao().save(new Employee("EMP56221935", "First Name 03", "Last Name 03", "male", "user03@employer.com"));
		DB.getEmployeeDao().save(new Employee("EMP56227735", "First Name 04", "Last Name 04", "male", "user04@employer.com"));
		DB.getEmployeeDao().save(new Employee("EMP50221935", "First Name 05", "Last Name 05", "female", "user05@employer.com"));
		DB.getEmployeeDao().save(new Employee("EMP56221935", "First Name 06", "Last Name 06", "female", "user06@employer.com"));
		DB.getEmployeeDao().save(new Employee("EMP06221975", "First Name 07", "Last Name 07", "female", "user07@employer.com"));
		DB.getEmployeeDao().save(new Employee("EMP50221935", "First Name 08", "Last Name 08", "male", "user08@employer.com"));
		DB.getEmployeeDao().save(new Employee("EMP56021935", "First Name 09", "Last Name 09", "female", "user09@employer.com"));
		DB.getEmployeeDao().save(new Employee("EMP50021935", "First Name 10", "Last Name 10", "male", "user10@employer.com"));
		
		
	}
	
	
}
