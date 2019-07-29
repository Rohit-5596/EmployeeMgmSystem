package com.cg.ems.dao;

public interface QueryMapper {

	
	public static final String EMP_INSERT_QRY=
			"INSERT INTO emp_112081(emp_id,emp_name,emp_sal,emp_DOB) VALUES"
			+ "(?,?,?,?)";
	
	public static final String
	EMP_SELECTALL="SELECT * FROM EMP_112081";
	
	public static final
	String EMP_DEL_QRY="DELETE FROM emp_112081 where emp_id=? ";
	
	public static final
	String EMP_SEL_BYSALRANGE="SELECT * FROM emp_112081 where emp_sal>=? and emp_sal<=?";
	
	public static final String EMP_SEL_BYID="SELECT * FROM emp_112081 where emp_id=?";
	
	public static final String DOB_SEL_BYID="SELECT emp_DOB FROM emp_112081 where emp_id=?";
}
