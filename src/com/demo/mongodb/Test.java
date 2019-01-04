package com.demo.mongodb;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.DBCollection;

public class Test {
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAOImpl();
	
		List<EmployeeDetails> listData = new ArrayList<EmployeeDetails>();
		
		EmployeeDetails details = new EmployeeDetails();
		details.setEmpID(1);
		details.setEmpName("Sumit kumar");
		details.setEmpSalary(30000.00);
		
		EmployeeDetails details1 = new EmployeeDetails();
		details1.setEmpID(2);
		details1.setEmpName("rajendra kumar");
		details1.setEmpSalary(30500.00);
		
		EmployeeDetails details2 = new EmployeeDetails();
		details2.setEmpID(3);
		details2.setEmpName("konica kumari");
		details2.setEmpSalary(40000.00);
		listData.add(details);
		listData.add(details1);
		listData.add(details2);
		
		dao.save(listData);
		dao.printAllDocuments(listData);
		dao.update(listData);
		dao.deleteDocuments(listData);
	}

}
