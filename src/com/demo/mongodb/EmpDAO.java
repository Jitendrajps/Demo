package com.demo.mongodb;

import java.util.List;

public interface EmpDAO {

	public void save(List<EmployeeDetails> empDetailsList);
	
	public void printAllDocuments(List<EmployeeDetails> empDetailsList);
		
	public void update(List<EmployeeDetails> empDetailsList);
	
	public void deleteDocuments(List<EmployeeDetails> empDetailsList);
}
