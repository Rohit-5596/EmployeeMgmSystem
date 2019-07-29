package com.cg.ems.dao;
import com.cg.ems.dto.Employee;
import com.cg.ems.exception.*;
import java.util.*;

public interface EmployeeDao {

	public int addEmp(Employee Emp) throws EmployeeException;
	public ArrayList<Employee> getAllEmp();
	public Employee deleteEmp(int empId);
	public Employee getEmpById(int empId);
	public Employee updateEmp(int empId,Employee updatedEmp);
	public int[] calculateAge(int empId);

	
}
