package com.cg.ems.service;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public interface EmployeeService {

	
	public int addEmp(Employee Emp) throws EmployeeException;
	public ArrayList<Employee> getAllEmp();
	public Employee deleteEmp(int empId);
	public Employee getEmpById(int empId);
	public Employee updateEmp(int empId,Employee updatedEmp);
	public int[] calculateAge(int empId);
	
	public boolean validateEmpId(int empId) throws EmployeeException;
	public boolean validateEmpName(String empName) throws EmployeeException;
	
}
