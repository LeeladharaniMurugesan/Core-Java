package com.chainsys.miniproject.ui;

import com.chainsys.miniproject.commonutil.InvalidInputDataException;
import com.chainsys.miniproject.commonutil.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.chainsys.miniproject.dao.EmployeeDao;
import com.chainsys.miniproject.pojo.Employee;

public class EmployeeUi {
	public static void addNewEmployee() {
		Scanner sc = new Scanner(System.in);
		Employee newemp = null;
		int result = 0;
		int employee_Id = 0;
		try {
			newemp = new Employee();
			
			System.out.println("Enter Employee Id: ");
			String id = sc.nextLine();
			try {
				Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			employee_Id = Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(employee_Id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
            newemp.setEmployee_id(employee_Id);
//--------------------------------------------------------------------------------------
			System.out.println("Enter Employee FirstName: ");
			String fname = sc.nextLine();
			try {
				Validator.checkStringOnly(fname);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			try {
				Validator.checklengthOfString(fname);
			}catch(InvalidInputDataException err) {
				err.printStackTrace();
			}
			
			newemp.setFirst_name(fname);
//--------------------------------------------------------------------------------------------
			System.out.println("Enter Employee lastName: ");
			String lname = sc.nextLine();
			try {
				Validator.checkStringOnly(fname);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			try {
				Validator.checklengthOfString(lname);
			}catch(InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setLast_name(lname);
			
//----------------------------------------------------------------------------------------------			
			System.out.println("Enter Employee Email: ");
			String email = sc.nextLine();
			try {
				Validator.checkingMail(email);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			newemp.setEmail(email);	
//-----------------------------------------------------------------------------------------------
			System.out.println("Enter Employee hire_date like \"dd/mm/yyyy\":");
			SimpleDateFormat hire_dateFormate = new SimpleDateFormat("dd/MM/yyyy");
			String emp_HireDate = sc.nextLine();
			// Date hire_date=hire_dateFormate.parse(emp_HireDate);
			
			try {
				Validator.checkDateFormat(emp_HireDate);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
			}
			Date newDate = null;
			try {
				newDate = hire_dateFormate.parse(emp_HireDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			newemp.setHire_date(newDate);
//------------------------------------------------------------------------
			System.out.println("Enter Employee JobId: ");
			String jobId = sc.nextLine();
			try {
				Validator.checkjobid(jobId);
			}catch(InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setJob_id(jobId);
//------------------------------------------------------------------------			
			System.out.println("Enter Employee Salary: ");
			String sal = sc.nextLine();
			try {
				Validator.checkStringForParse(sal);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
		     float salParse =Float.parseFloat(sal);
			try {
			Validator.checkSalary(salParse);
			}catch(InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setSalary(salParse);

			
			result = EmployeeDao.insertEmployee(newemp);
			System.out.println(result + " Added Successfully");
		} finally {
			sc.close();
		}
	}
//----------------------------------------------------------------------------
	public static void updateNewEmployee() {
		Scanner sc = new Scanner(System.in);
		Employee newemp = new Employee();
		int result = 0;
		try {

			System.out.println("Enter Employee Id: ");
			String id = sc.nextLine();
			// TODO - validate input String
			try {
				Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			int empId = Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
            newemp.setEmployee_id(empId);

 //--------------------------------------------------------------------------------------   
			System.out.println("Enter Employee FirstName: ");
			String fname = sc.nextLine();
			try {
				Validator.checkStringOnly(fname);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			try {
				Validator.checklengthOfString(fname);
			}catch(InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setFirst_name(fname);

//-------------------------------------------------------------------------------------			
			System.out.println("Enter Employee lastName: ");
			String lname = sc.nextLine();
			try {
				Validator.checkStringOnly(fname);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			try {
				Validator.checklengthOfString(lname);
			}catch(InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setLast_name(lname);

			
			System.out.println("Enter Employee Email: ");
			String email = sc.nextLine();
			try {
				Validator.checkingMail(email);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			newemp.setEmail(email);

			
			System.out.println("Enter Employee hire_date like \"dd/mm/yyyy\":");
			SimpleDateFormat hire_dateFormate = new SimpleDateFormat("dd/MM/yyyy");
			String emp_HireDate = sc.nextLine();
			// Date hire_date=hire_dateFormate.parse(emp_HireDate);
			
			try {
				Validator.checkDateFormat(emp_HireDate);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
			}
			Date newDate = null;
			try {
				newDate = hire_dateFormate.parse(emp_HireDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			newemp.setHire_date(newDate);
//--------------------------------------------------------------------------------
			System.out.println("Enter Employee JobId: ");
			String jobId = sc.nextLine();
			try {
				Validator.checkjobid(jobId);
			}catch(InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setJob_id(jobId);

//-------------------------------------------------------------------------------			
			System.out.println("Enter Employee Salary: ");
			String sal = sc.nextLine();
			try {
				Validator.checkStringForParse(sal);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			float salParse = Float.parseFloat(sal);
			try {
			Validator.checkSalary(salParse);
			}catch(InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setSalary(salParse);
	
			result = EmployeeDao.updateEmployee(newemp);
			System.out.println(result + " Updated Successfully");

		} finally {
			sc.close();
		}
	}
//------------------------------------------------------------------------------
	public static void updateEmployeeFirstName() {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		String id = null;
		String fname = null;
		System.out.println("Enter Employee Id: ");
	    id = sc.nextLine();
		
		try {
			Validator.checkStringForParse(id);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
		}
		int empId = Integer.parseInt(id);
		try {
			Validator.CheckNumberForGreaterThanZero(empId);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
		}
		Employee emp = EmployeeDao.getEmployeeById(empId);
		emp.setEmployee_id(empId);
	//------------------------------------------------------------------
		System.out.println("Enter Employee FirstName: ");
	    fname = sc.nextLine();
		try {
			Validator.checkStringOnly(fname);
		} catch (InvalidInputDataException e) {
			e.printStackTrace();
		}
		try {
			Validator.checklengthOfString(fname);
		}catch(InvalidInputDataException err) {
			err.printStackTrace();
		}
		sc.close();
		result = EmployeeDao.updateEmployeeFirstName(empId, fname);
		
	}

	public static void updateEmployeeSalary() {
		Scanner sc = new Scanner(System.in);
		int result =0 ;
		String id = null;
		String salary = null;
		System.out.println("Enter Employee Id: ");
		id = sc.nextLine();
		try {
			Validator.checkStringForParse(id);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
		}
		int empId = Integer.parseInt(id);
		try {
			Validator.CheckNumberForGreaterThanZero(empId);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
		}
		
//--------------------------------------------------------------------
		System.out.println("Enter Salary: ");
		salary = sc.nextLine();
		try {
			Validator.checkStringForParse(salary);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
		}
		float salParse = Float.parseFloat(salary);
		try {
		Validator.checkSalary(salParse);
		}catch(InvalidInputDataException err) {
			err.printStackTrace();
		}
		sc.close();
		result = EmployeeDao.updateEmployeeSalary(empId, salParse);
		
	}
//-------------------------------------------------------------------------------------
	public static void deleteEmployee() {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		String id = null;
		System.out.println("Enter Employee Id: ");
		id = sc.nextLine();
		try {
			Validator.checkStringForParse(id);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
		}
		int empId = Integer.parseInt(id);
		try {
			Validator.CheckNumberForGreaterThanZero(empId);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
		}
		sc.close();
		result = EmployeeDao.deleteEmployee(empId);
		System.out.println(result + " Deleted Successfully");
	}
//-----------------------------------------------------------------------------------
	public static void getEmployeeById() {
		Scanner sc = new Scanner(System.in);
		Employee result = new Employee();
	//	String id1 = null;
		System.out.println("Enter Employee Id: ");
		String id = sc.nextLine();
		try {
			Validator.checkStringForParse(id);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
		}
		int empId = Integer.parseInt(id);
		try {
			Validator.CheckNumberForGreaterThanZero(empId);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
		}

		result = EmployeeDao.getEmployeeById(empId);
		System.out.println("Employee id: " + result.getEmployee_id() + "\n" + "Employee first name: "
				+ result.getFirst_name() + "\n" + "Employee last name: " + result.getLast_name() + "\n"
				+ "Employee email: " + result.getEmail() + "\n" + "Employee hiredate: " + result.getHire_date() + "\n"
				+ "Employee job id: " + result.getJob_id() + "\n" + "Employee salary: " + result.getSalary() + "\n");
		sc.close();
	}
	// EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,HIRE_DATE,JOB_ID,SALARY

	public static void getAllEmployee() {
		List<Employee> allEmployees = EmployeeDao.getAllEmployee();
		Iterator<Employee> empIterator = allEmployees.iterator();
		while (empIterator.hasNext()) {
			Employee result = empIterator.next();
			System.out.println("Employee id: " + "\t" + "Employee first name: " + "\t" + "Employee last name: " + "\t"
					+ "Employee email: " + "\t" + "Employee hiredate: " + "\t" + "Employee job id: " + "\t"
					+ "Employee salary: " + "\t");
			System.out.println(
					"---------------------------------------------------------------------------------------------------");
			System.out.println(result.getEmployee_id() + "\t" + result.getFirst_name() + "\t" + result.getLast_name() + "\t"
					+ result.getEmail() + "\t" + result.getHire_date() + "\t" + result.getJob_id() + "\t"
					+ result.getSalary());
		}
	}

}
