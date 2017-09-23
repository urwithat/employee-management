package services.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import services.dao.DB;
import services.common.Helper;
import services.model.Employee;

@RestController
@RequestMapping("/api")
public class SearchController {

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String read(@RequestParam(value = "id", required = false) String id, 
			@RequestParam(value = "firstName", required = false) String firstName, 
			@RequestParam(value = "lastName", required = false) String lastName, 
			@RequestParam(value = "gender", required = false) String gender, 
			@RequestParam(value = "emailAddress", required = false) String emailAddress) {
		
		List<Employee> employees = DB.getEmployeeDao().findByAny(id, firstName, lastName, gender, emailAddress);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(employees);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return Helper.EMP_ERROR.value();
		}
	}
	
	@RequestMapping(value = "/search/term/{term}", method = RequestMethod.GET)
	public String readAll(@PathVariable("term") String term) {
		//DB.getEmployeeDao().
		List<Employee> employees = DB.getEmployeeDao().findByAnyInAny(term);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(employees);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return Helper.EMP_ERROR.value();
		}
	}
	
}