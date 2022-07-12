package com.chainsys.miniproject.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.chainsys.miniproject.dao.EmployeeDao;
import com.chainsys.miniproject.pojo.Employee;

public class TestEmployeeDao {
	public static void testGetAllEmployees() {
		List<Employee> allEmployees = EmployeeDao.getAllEmployee();
		Iterator<Employee> empIterator =allEmployees.iterator();
		while(empIterator.hasNext()) {
			Employee emp =empIterator.next();
			System.out.println(emp.getEmployee_id()+" "+emp.getFirst_name()+" "+emp.getSalary());
		}
	}
public static void testGetEmployeeById() {
	Employee emp =EmployeeDao.getEmployeeById(126);
	System.out.println(emp.getEmployee_id()+" " +emp.getFirst_name()+" "+emp.getSalary());
}
public static void testInsertEmployee() {
	Employee newemp = new Employee();
	newemp.setEmployee_id(300);
	newemp.setFirst_name("Ana");
	newemp.setLast_name("Rose");
	newemp.setEmail("ana23@gmail.com");
	Calendar c1 = Calendar.getInstance();
	java.util.Date newDate = c1.getTime();
	newemp.setHire_date(newDate);
	newemp.setJob_id("IT_PROG");
	newemp.setSalary(27000);
	int result = EmployeeDao.insertEmployee(newemp);
	System.out.println(result);
}
public static void testUpdateEmployee() {
    Employee oldEmp=EmployeeDao.getEmployeeById(125);
    System.out.println(oldEmp.getEmployee_id()+" "+oldEmp.getFirst_name()+" "+oldEmp.getSalary());
    oldEmp.setFirst_name("roopa");
    oldEmp.setLast_name("shri");
    oldEmp.setEmail("xyz@gmail.com");
    Calendar c1=Calendar.getInstance();
    java.util.Date newDate=c1.getTime();
     oldEmp.setHire_date(newDate);
     oldEmp.setJob_id("IT_PROG");
     oldEmp.setSalary(500000);
    int result =EmployeeDao.updateEmployee(oldEmp);
    System.out.println(result);
}
public static void testUpdateFirstName() {
	int result = EmployeeDao.updateEmployeeFirstName(124,"Kevin");
	System.out.println(result);
}
public static void testupdateEmployeeSalary() {
	int result = EmployeeDao.updateEmployeeSalary(124, 1000.0f);
	System.out.println(result);
}
public static void testDeleteEmployee() {
	int result =EmployeeDao.deleteEmployee(126);
	System.out.println(result);
}
}

	
