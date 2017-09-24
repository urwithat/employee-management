package services.controller;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import services.dao.DB;
import services.model.Employee;

@RestController
@RequestMapping("/api")
public class SearchController {

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Employee> read(@RequestParam(value = "id", required = false) String id, 
			@RequestParam(value = "firstName", required = false) String firstName, 
			@RequestParam(value = "lastName", required = false) String lastName, 
			@RequestParam(value = "gender", required = false) String gender, 
			@RequestParam(value = "emailAddress", required = false) String emailAddress) {
		return DB.getEmployeeDao().findByAny(id, firstName, lastName, gender, emailAddress, new Sort(Sort.Direction.ASC, "firstName"));
	}
	
	@RequestMapping(value = "/search/id/{id}", method = RequestMethod.GET)
	public Employee readById(@PathVariable("id") String id) {
		return DB.getEmployeeDao().findById(id, new Sort(Sort.Direction.ASC, "firstName"));
	}
	
	@RequestMapping(value = "/search/term/{term}", method = RequestMethod.GET)
	public List<Employee> readAll(@PathVariable("term") String term) {
		return DB.getEmployeeDao().findByAnyInAny(term, new Sort(Sort.Direction.ASC, "firstName"));
	}
	
}