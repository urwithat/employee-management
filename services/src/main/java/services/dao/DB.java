package services.dao;

import org.springframework.beans.factory.annotation.Autowired;

public class DB {

	@Autowired
	private static EmployeeDao employeeDao;
	
	public static EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public static void setEmployeeDao(EmployeeDao employeeDao) {
    	DB.employeeDao = employeeDao;
    }
    
}
