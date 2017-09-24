package services.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Sort;
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
					employee.setId(generateId());
					DB.getEmployeeDao().save(employee);
					return DB.getEmployeeDao().findAll(new Sort(Sort.Direction.ASC, "firstName"));
				} catch (IOException e) {
					e.printStackTrace();
					return DB.getEmployeeDao().findAll(new Sort(Sort.Direction.ASC, "firstName"));
				}
			} else {
				return DB.getEmployeeDao().findAll(new Sort(Sort.Direction.ASC, "firstName"));
			}
		} else {
			return DB.getEmployeeDao().findAll(new Sort(Sort.Direction.ASC, "firstName"));
		}
	}
	
	private String generateId() {
		String generateNewId = "EMP" + (int) (Math.floor(Math.random() * (Math.floor(99999999) - Math.ceil(11111111)) + Math.ceil(11111111)));
		Employee checkIdExists = DB.getEmployeeDao().findById(generateNewId, new Sort(Sort.Direction.ASC, "firstName"));
		if(checkIdExists != null) {
			return generateId();
		} else {
			return generateNewId;
		}
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String readAll() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(DB.getEmployeeDao().findAll(new Sort(Sort.Direction.ASC, "firstName")));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return Helper.EMP_ERROR.value();
		}
	}
	
	@RequestMapping(value = "/employees/update", method = RequestMethod.PUT)
	public List<Employee> update(@RequestBody String payload) {
		if(payload != null) {
			if(payload.trim().length() != 0) {
				ObjectMapper objectMapper = new ObjectMapper();
				try {
					Employee employeeModified = objectMapper.readValue(payload, Employee.class);
					Employee employee = DB.getEmployeeDao().findById(employeeModified.getId(), new Sort(Sort.Direction.ASC, "firstName"));
					if(employee != null) {
						employee.setFirstName(employeeModified.getFirstName());
						employee.setLastName(employeeModified.getLastName());
						employee.setGender(employeeModified.getGender());
						employee.setEmailAddress(employeeModified.getEmailAddress());
						DB.getEmployeeDao().save(employee);
						return DB.getEmployeeDao().findAll(new Sort(Sort.Direction.ASC, "firstName"));
					} else {
						//return Helper.EMP_ERROR_NO_DATA.value();
						return DB.getEmployeeDao().findAll(new Sort(Sort.Direction.ASC, "firstName"));
					}
				} catch (IOException e) {
					e.printStackTrace();
					//return Helper.EMP_ERROR.value();
					return DB.getEmployeeDao().findAll(new Sort(Sort.Direction.ASC, "firstName"));
				}
			} else {
				//return Helper.EMP_ERROR_PARAMETERS.value();
				return DB.getEmployeeDao().findAll(new Sort(Sort.Direction.ASC, "firstName"));
			}
		} else {
			//return Helper.EMP_ERROR_PARAMETERS.value();
			return DB.getEmployeeDao().findAll(new Sort(Sort.Direction.ASC, "firstName"));
		}
	}
	
	@RequestMapping(value = "/employees/delete/{id}", method = RequestMethod.GET)
	public List<Employee> delete(@PathVariable("id") String id) {
		if(id != null) {
			if(id.trim().length() != 0) {
				Employee employee = DB.getEmployeeDao().findById(id, new Sort(Sort.Direction.ASC, "firstName"));
				//List<Employee> employees = DB.getEmployeeDao().findByAny(id, null, null, null, null);
				if(employee != null) {
					DB.getEmployeeDao().delete(employee);
					return DB.getEmployeeDao().findAll(new Sort(Sort.Direction.ASC, "firstName"));
				} else {
					return DB.getEmployeeDao().findAll(new Sort(Sort.Direction.ASC, "firstName"));
				}
			} else {
				return DB.getEmployeeDao().findAll(new Sort(Sort.Direction.ASC, "firstName"));
			}
		} else {
			return DB.getEmployeeDao().findAll(new Sort(Sort.Direction.ASC, "firstName"));
		}
	}
	
}
