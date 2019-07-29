package com.cg.ems.dao;
import com.cg.ems.dao.*;
import com.cg.ems.dto.Employee;
import com.cg.ems.exception.*;
import com.cg.ems.util.DBUtil;
import com.cg.ems.util.MyStringDateUtil;

import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.time.*;
import java.time.Period;

public class EmployeeDaoImpl implements EmployeeDao,QueryMapper {

	
	Connection con=null;
	Statement st=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	int dataInserted=0;
	
	@Override
	public Employee getEmpById(int empId)  {
		
		Employee emp=null;
		try {
			con=DBUtil.getCon();
			System.out.println("con="+con);
				pst=con.prepareStatement(QueryMapper.EMP_SEL_BYID);
				pst.setInt(1, empId);
				rs=pst.executeQuery();
				
				while(rs.next()) {
				 emp=new Employee(rs.getInt("emp_id"),rs.getString("emp_name"),rs.getFloat("emp_sal"));
				}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return emp;
	
	}
		



	@Override
	public int addEmp(Employee emp) throws EmployeeException {
		
		
		java.sql.Date sqlDOB=MyStringDateUtil.fromLocalToSqlDate(emp.getEmpDOB());
			con=DBUtil.getCon();
			System.out.println("con="+con);
			try {
				pst=con.prepareStatement(QueryMapper.EMP_INSERT_QRY);
				pst.setInt(1, emp.getEmpId());
				pst.setString(2, emp.getEmpName());
				pst.setFloat(3, emp.getEmpSal());
				pst.setDate(4, sqlDOB);
				dataInserted=pst.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		return 0;
	}

	@Override
	public ArrayList<Employee> getAllEmp() {
		ArrayList<Employee> list=new ArrayList<Employee>();
		try {
		con=DBUtil.getCon();
		System.out.println("con="+con);
			st=con.createStatement();
			rs=st.executeQuery(QueryMapper.EMP_SELECTALL);
			Employee emp=null;
			while(rs.next()) {
				list.add(new Employee(rs.getInt("emp_id"),rs.getString("emp_name"),rs.getFloat("emp_sal")));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Employee deleteEmp(int empId) {
		
	
		try {
			Employee emp=null;
			con=DBUtil.getCon();
			pst=con.prepareStatement(QueryMapper.EMP_DEL_QRY);
			pst.setInt(1, empId);
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee updateEmp(int empId, Employee updatedEmp) {
		
		return null;
	}




	@Override
	public int[] calculateAge(int empId) {
		int a[]=new int[3];
		try {
			con=DBUtil.getCon();
			System.out.println("con="+con);
				pst=con.prepareStatement(QueryMapper.EMP_SEL_BYID);
				pst.setInt(1, empId);
				rs=pst.executeQuery();
				while(rs.next()) {
				Period diff=MyStringDateUtil.fromSqlToLocalDate(rs.getDate("emp_DOB")).until(LocalDate.now());
				a[0]=diff.getDays();
				a[1]=diff.getMonths();
				a[2]=diff.getYears();
				}
				
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
		return a;
	}

	
	

	
}
