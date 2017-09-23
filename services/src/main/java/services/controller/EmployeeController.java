package services.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import services.dao.DB;
import services.common.Helper;
import services.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@RequestMapping(value = "/employees/create", method = RequestMethod.POST)
	public List<Employee> create(@RequestBody String payload) {
		if(payload != null) {
			if(payload.trim().length() != 0) {
				ObjectMapper objectMapper = new ObjectMapper();
				try {
					Employee employee = objectMapper.readValue(payload, Employee.class);
					DB.getEmployeeDao().save(employee);
					return DB.getEmployeeDao().findAll();
				} catch (IOException e) {
					e.printStackTrace();
					return DB.getEmployeeDao().findAll();
				}
			} else {
				return DB.getEmployeeDao().findAll();
			}
		} else {
			return DB.getEmployeeDao().findAll();
		}
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String readAll() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(DB.getEmployeeDao().findAll());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return Helper.EMP_ERROR.value();
		}
	}
	
	@RequestMapping(value = "/employees/update", method = RequestMethod.PUT)
	public String update(@RequestBody String payload) {
		if(payload != null) {
			if(payload.trim().length() != 0) {
				ObjectMapper objectMapper = new ObjectMapper();
				try {
					Employee employeeModified = objectMapper.readValue(payload, Employee.class);
					Employee employee = DB.getEmployeeDao().findById(employeeModified.getId());
					if(employee != null) {
						employee.setFirstName(employeeModified.getFirstName());
						employee.setLastName(employeeModified.getLastName());
						employee.setGender(employeeModified.getGender());
						employee.setEmailAddress(employeeModified.getEmailAddress());
						DB.getEmployeeDao().save(employee);
						return Helper.EMP_SUCCESS_UPDATE.value();
					} else {
						return Helper.EMP_ERROR_NO_DATA.value();
					}
				} catch (IOException e) {
					e.printStackTrace();
					return Helper.EMP_ERROR.value();
				}
			} else {
				return Helper.EMP_ERROR_PARAMETERS.value();
			}
		} else {
			return Helper.EMP_ERROR_PARAMETERS.value();
		}
	}
	
	@RequestMapping(value = "/employees/delete/{id}", method = RequestMethod.GET)
	public List<Employee> delete(@PathVariable("id") String id) {
		if(id != null) {
			if(id.trim().length() != 0) {
				List<Employee> employees = DB.getEmployeeDao().findByAny(id, null, null, null, null);
				if(employees != null) {
					DB.getEmployeeDao().delete(employees.get(0));
					return DB.getEmployeeDao().findAll();
				} else {
					return DB.getEmployeeDao().findAll();
				}
			} else {
				return DB.getEmployeeDao().findAll();
			}
		} else {
			return DB.getEmployeeDao().findAll();
		}
	}
	
}
