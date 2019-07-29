package com.cg.ems.service;
import com.cg.ems.dao.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.regex.Pattern;


import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDao empDao=null;
	public  EmployeeServiceImpl() 
	{
		empDao=new EmployeeDaoImpl();
	}

	@Override
	public int addEmp(Employee emp) throws EmployeeException {
		
		return empDao.addEmp(emp);
	}

	@Override
	public ArrayList<Employee> getAllEmp() {
		
		return empDao.getAllEmp();
	}

	@Override
	public Employee deleteEmp(int empId) {
		
		return empDao.deleteEmp(empId);
	}

	@Override
	public Employee getEmpById(int empId) {
		
		return empDao.getEmpById(empId);
	}

	@Override
	public Employee updateEmp(int empId, Employee updatedEmp) {
		// TODO Auto-generated method stub
		return empDao.updateEmp(empId, updatedEmp);
	}

	@Override
	public boolean validateEmpId(int empId) throws EmployeeException {
		
		String empIdData=new Integer(empId).toString();
		String empIdPattern="[0-9]{6}";
		if(Pattern.matches(empIdPattern,empIdData))
		{
			return true;
		}
		else {
			throw new EmployeeException("Invalid EmpId, Should Have only 6 digits");
		}
		
	}

	@Override
	public boolean validateEmpName(String empName)throws EmployeeException {
		
		String empNamePattern="[A-Z][a-z]+";
		if(Pattern.matches(empNamePattern,empName))
		{
			return true;
		}
		else {
			throw new EmployeeException("Invalid Name, Should start with capital letter");
		}
		
	}

	@Override
	public int[] calculateAge(int empId) {
		
	
		return empDao.calculateAge(empId);
	}
	

	
}
