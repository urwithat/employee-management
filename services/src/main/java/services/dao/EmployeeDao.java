package services.dao;

import java.util.List;
import services.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EmployeeDao extends MongoRepository<Employee, String> {

	public Employee findById(String id);
	
	@Query("{$and :["
			+ "?#{[0] == null ? { $where : 'true'} : { 'id' : { $regex: [0], $options: 'i' } } }, "
			+ "?#{[1] == null ? { $where : 'true'} : { 'firstName' : { $regex: [1], $options: 'i' } } }, "
			+ "?#{[2] == null ? { $where : 'true'} : { 'lastName' : { $regex: [2], $options: 'i' } } }, "
			+ "?#{[3] == null ? { $where : 'true'} : { 'gender' : { $regex: [3], $options: 'i' } } }, "
			+ "?#{[4] == null ? { $where : 'true'} : { 'emailAddress' : { $regex: [4], $options: 'i' } } }"
			+ "]}")
	public List<Employee> findByAny(String id, String firstName, String lastName, String gender, String emailAddress);
	
	@Query("{$or :["
			+ "?#{[0] == null ? { $where : 'true'} : { 'id' : { $regex: [0], $options: 'i' } } }, "
			+ "?#{[0] == null ? { $where : 'true'} : { 'firstName' : { $regex: [0], $options: 'i' } } }, "
			+ "?#{[0] == null ? { $where : 'true'} : { 'lastName' : { $regex: [0], $options: 'i' } } }, "
			+ "?#{[0] == null ? { $where : 'true'} : { 'gender' : { $regex: [0], $options: 'i' } } }, "
			+ "?#{[0] == null ? { $where : 'true'} : { 'emailAddress' : { $regex: [0], $options: 'i' } } }"
			+ "]}")
	public List<Employee> findByAnyInAny(String term);
	
}