package com.cg.ems.ui;
import java.util.*;
import com.cg.ems.service.*;
import com.cg.ems.util.MyStringDateUtil;
import com.cg.ems.dto.*;

public class TestEmpMgmDemo {

	static Scanner sc=new Scanner(System.in);
	static EmployeeService empService=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		empService=new EmployeeServiceImpl();
		int choice;
		while(true)
		{
			System.out.println("What do u want to do");
			System.out.println("1:AddEmp\t\t2:Fetch all Emp\t\t3:Delete Emp\t\t4:Get Emp By Id\t\t "
					+ "5:enter DOB to know your age\t\t+6:exit");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:insertEmp();break;
			case 2:fetchAllEmp();break;
			case 3:deleteEmpById();break;
			case 4:getEmpById();break;
			case 5:getAgeByDOB();break;
			default: System.exit(1); 
			}
		}
		
		
	}
	private static void insertEmp() {
		System.out.println("Enter emp id");
		int eid=sc.nextInt();float esal=0;
		try {
		if(empService.validateEmpId(eid)) {
			System.out.println("Enter emp name");
			String enm=sc.next();
			if(empService.validateEmpName(enm)) {
			System.out.println("Enter emp sal");
			 esal=sc.nextFloat();
			 System.out.println("Enter emp DOB in dd-mm-yyyy");
			 String strDOB=sc.next();
			Employee ee=new Employee(eid,enm,esal);
			ee.setEmpDOB(MyStringDateUtil.fromStringToLocalDate(strDOB));
			int dataAdd=empService.addEmp(ee);
			if(dataAdd==1) {
				System.out.println("data inserted");
			}
		}
			else
			{
				System.out.println("error in insertion");	
			}
			
		}
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
		
		
	}
	private static void fetchAllEmp() {
		ArrayList<Employee> list=new ArrayList<Employee>();
		list=empService. getAllEmp();
		System.out.println("EMPID\t\t"+"EMPNAME\t\t"+"EMPSAL");
		for(Employee e1:list) {
			System.out.println(e1);
		}
	}
	private static void deleteEmpById() {
		
		System.out.println("Enter emp id to be deleted");
		int eid=sc.nextInt();
		empService.deleteEmp(eid);
	}
	
private static void getEmpById() {
		
		System.out.println("Enter emp id to be deleted");
		int eid=sc.nextInt();
		System.out.println(empService.getEmpById(eid));
		
	}
private static void getAgeByDOB() {
	
	 System.out.println("Enter emp id to know your age");
	 int eid=sc.nextInt();
	 int a[]=new int[3];
	 a=empService.calculateAge(eid);
	 System.out.println(a[0]+"days "+a[1]+"months "+a[2]+"years ");
}

}
