package com.cg.ems.dto;
import java.time.*;

public class Employee {

	
	private int empId;
	private String empName;
	private float empSal;
	private LocalDate empDOB;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getEmpSal() {
		return empSal;
	}
	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}
	public LocalDate getEmpDOB() {
		return empDOB;
	}
	public void setEmpDOB(LocalDate empDOB) {
		this.empDOB = empDOB;
	}
	public Employee() {
		super();
	}
	public Employee(int empId, String empName, float empSal, LocalDate empDOB) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empDOB = empDOB;
	}
	public Employee(int empId, String empName, float empSal) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", empDOB=" + empDOB + "]";
	}
	
	
	
	
}
