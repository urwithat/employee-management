package services.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import services.dao.DB;
import services.model.Employee;

@RestController
@RequestMapping("/api")
public class ExcelController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json")
	public List<Employee> upload(@RequestParam("file") MultipartFile file) {
		List<Employee> employees = new ArrayList<Employee>();
		if (!file.isEmpty()) {
			 try {
				InputStream stream = file.getInputStream();
				XSSFWorkbook workbook = new XSSFWorkbook(stream);
				XSSFSheet sheet = workbook.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();
		        while (rowIterator.hasNext()) {
		        	Row nextRow = rowIterator.next();
			        if (nextRow.getRowNum() != 0) {
			        	Iterator<Cell> cellIterator = nextRow.cellIterator();
			        	Employee employee = new Employee();
			        	while (cellIterator.hasNext()) {
			        		Cell cell = cellIterator.next();
			        		switch (cell.getColumnIndex()) {
			        			case 0:
			        				employee.setId(cell.getStringCellValue());
			        	    		break;
			        	    	case 1:
			        	    		employee.setFirstName(cell.getStringCellValue());
			        	    		break;
			        	    	case 2:
			        	    		employee.setLastName(cell.getStringCellValue());
			        	    		break;
			        	    	case 3:
			        	    		employee.setGender(cell.getStringCellValue());
			        	    		break;
			        	    	case 4:
			        	    		employee.setEmailAddress(cell.getStringCellValue());
			        	    		break;
			        		}
			        	}
			        	employees.add(employee);
			        }
		        }
		        DB.getEmployeeDao().save(employees);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return DB.getEmployeeDao().findAll();
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(HttpServletResponse response) {
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		XSSFSheet sheet = workbook.createSheet("Employees");
		int rownum = 0;
		Row row = sheet.createRow(rownum);
		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("First Name");
		row.createCell(2).setCellValue("LastName");
		row.createCell(3).setCellValue("Gender");
		row.createCell(4).setCellValue("Email Address");
		for (Employee employee : DB.getEmployeeDao().findAll())
		{
			row = sheet.createRow(++rownum);
			row.createCell(0).setCellValue(employee.getId());
			row.createCell(1).setCellValue(employee.getFirstName());
			row.createCell(2).setCellValue(employee.getLastName());
			row.createCell(3).setCellValue(employee.getGender());
			row.createCell(4).setCellValue(employee.getEmailAddress());
		}
		try {
			response.setHeader("Content-disposition", "attachment; filename=employees.xlsx");
			workbook.write(response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
