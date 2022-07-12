package com.chainsys.miniproject.entry;


import com.chainsys.miniproject.ui.AppointmentUi;
import com.chainsys.miniproject.ui.DoctorUi;
import com.chainsys.miniproject.ui.EmployeeUi;

public class Startup {
	public static void main(String args[]) {
		
		loadMenu();}

	private static void loadMenu() {
		System.out.println("Enter Menu : 1 is EmployeeMenu, 2 is Doctor Menu, 3 is Appointment Menu ");
		java.util.Scanner sc = new java.util.Scanner(System.in);
      try {
		int call = sc.nextInt();
		switch (call) {
		case 1:
			loadEmployeeMenu();
			break;
		case 2:
			loadDoctorMenu();
			break;
		case 3:
			loadAppointmentMenu();
			break;
		}
      }finally {
    	  sc.close();
      }
	}

	private static void loadEmployeeMenu() {
		System.out.println(
				"Enter Employee Method : 1=addEmployee, 2=getEmployeeById ,3=upadateEmployee ,4=getAllEmployee,5=getEmployeeFirstName,6=getEmployeeSalary,7=deleteEmployee");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
		int call = sc.nextInt();
		
		switch (call) {
		case 1:
			EmployeeUi.addNewEmployee();
			break;

		case 2:
			EmployeeUi.getEmployeeById();
			break;
		case 3:
			EmployeeUi.updateNewEmployee();
			break;
		
		case 4:
			EmployeeUi.getAllEmployee();
			break;
		case 5:
			EmployeeUi.updateEmployeeFirstName();
			break;
		case 6:
			EmployeeUi.updateEmployeeSalary();
		case 7:
			EmployeeUi.deleteEmployee();
			break;
		}
		}finally {
			sc.close();
		}
	}

	private static void loadDoctorMenu() {
		System.out.println(
				"Enter Doctor Method : 1=addNewDoctor ,2=getDoctorById ,3=updateNewDoctor ,4=getAllDoctors, 5=deleteDoctorById  6=updateDoctorName");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
		int call = sc.nextInt();
		switch (call) {
		case 1:
			DoctorUi.addNewDoctor();
			break;
		case 2:
			DoctorUi.getDoctorById();
			break;
		case 3:
			DoctorUi.updateDoctor();
			break;
		case 4:
			DoctorUi.getAllDoctorDetails();
			break;
		case 5:
			DoctorUi.deleteDoctor();
			break;
		case 6:
			DoctorUi.updateDoctorFirstName();
			break;
		}
		}finally {
			sc.close();
		}
	}

	private static void loadAppointmentMenu() {
		System.out.println(
				"Enter Method : 1=addNewAppointment ,2=updateAppointments ,3=deleteAppointmentById ,4=getappointmentsById ,5=getAllAppointments");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
		int call = sc.nextInt();
		switch (call) {
		case 1:
			AppointmentUi.addNewAppointments();
			break;
		case 2:
			AppointmentUi.updateAppointment();
			break;
		case 3:
			AppointmentUi.deleteAppointment();
			break;
		case 4:
			AppointmentUi.getAppointmentById();
			break;
		case 5:
			AppointmentUi.getAllAppointmentDetails();;
			break;
		}
		}finally {
			sc.close();
		}
	}

}
