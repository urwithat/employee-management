package services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Document(collection = "employee")
@TypeAlias("employee")
@JsonDeserialize(as = Employee.class)
public class Employee {

	@Id
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("emailAddress")
	private String emailAddress;
	
	public Employee() {
        super();
    }
	
	public Employee(String id, String firstName, String lastName, 
			String gender, String emailAddress) {
		this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }
	
    @Override
    public String toString() {
        return String.format(
                "{id='%s', firstName='%s', lastName='%s',"
                + " gender='%s', emailAddress='%s'}", id, firstName, 
                lastName, gender, emailAddress);
    }
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
}
