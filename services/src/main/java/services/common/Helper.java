package services.common;

public enum Helper {
	EMP_SUCCESS_ADD("{'status': 'Successfully added the employee'}"),
	EMP_SUCCESS_DELETE("{'status': 'Employee record has been deleted'}"),
	EMP_SUCCESS_UPDATE("{'status': 'Employee record has been updated'}"),
	EMP_ERROR("{'status': 'Unable to process your request at this moment'}"),
	EMP_ERROR_PARAMETERS("{'status': 'Kindly Provided all mandatory parameters'}"),
	EMP_ERROR_NO_DATA("{'status': 'No data found'}"),
	EMP_ERROR_READ("{'status': 'Unable to find Employee'}"),
	;
	
	private String value;
	
	Helper(String value) {
		this.value = value;
	}
	
	public String value() {
        return value;
    }
}
