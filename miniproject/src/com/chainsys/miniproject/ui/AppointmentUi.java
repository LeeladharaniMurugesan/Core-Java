package com.chainsys.miniproject.ui;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.chainsys.miniproject.commonutil.InvalidInputDataException;
import com.chainsys.miniproject.commonutil.Validator;
import com.chainsys.miniproject.dao.*;
import com.chainsys.miniproject.pojo.*;

public class AppointmentUi {

	public static void addNewAppointments() {

		Scanner sc = new Scanner(System.in);
		Appointments app = new Appointments();

		System.out.println("Enter the Appointment id:");
		String id = sc.nextLine();
		try {
			Validator.checkStringForParse(id);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
		}
		int apId = Integer.parseInt(id);
		try {
			Validator.CheckNumberForGreaterThanZero(apId);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
		}
		app.setApp_id(apId);
		Calendar c1 = Calendar.getInstance();
		java.util.Date newDate = c1.getTime();
		app.setApp_date(newDate);
		System.out.println("Enter Doctor id:");
		String doc_id = sc.nextLine();
		try {
			Validator.checkStringForParse(doc_id);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();

		}
		int apId1 = Integer.parseInt(id);
		try {
			Validator.CheckNumberForGreaterThanZero(apId1);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();

		}
		app.setDoctor_id(Integer.parseInt(doc_id));
		System.out.println("Enter patient Name:");
		String name = sc.nextLine();
		try {
			Validator.checkStringOnly(name);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();

		}
		app.setPatient_name(name);
		System.out.println("Enter fees collected:");
		int fees = sc.nextInt();
		try {
			Validator.Checkfees(fees);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();

		}
		app.setFees_collected(fees);
		float result = AppointmentDao.insertAppointment(app);
		System.out.println(result + "row inserted");
		sc.close();
	}

	public static void updateAppointment() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
			Appointments newap = new Appointments();
			System.out.println("Enter Appointment_id :");
			String id = sc.nextLine();
			try {
				Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			int apId = Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(apId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newap.setApp_id(apId);

			Calendar c1 = Calendar.getInstance();
			java.util.Date newDate = new java.util.Date();
			newap.setApp_date(newDate);
			System.out.println("Enter Update Doctor_Id :");
			String id1 = sc.nextLine();
			try {
				Validator.checkStringForParse(id1);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			int docId = Integer.parseInt(id1);
			try {
				Validator.CheckNumberForGreaterThanZero(docId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newap.setDoctor_id(docId);
			System.out.println("Enter Update Patient Name :");
			String name = sc.nextLine();
			try {
				Validator.checkStringOnly(name);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newap.setPatient_name(name);
			System.out.println("Enter fees collected:");
			String fe =sc.nextLine();
			try {
			Validator.checkStringForParse(fe);
			}catch(InvalidInputDataException err) {
				err.printStackTrace();
			}

			float fees = Float.parseFloat(fe);
			
			try {
				Validator.Checkfees(fees);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();

			}
			newap.setFees_collected(fees);

			int result = AppointmentDao.updateAppointment(newap);
			System.out.println(result);
		} finally {
			sc.close();
		}
	}

	public static void deleteAppointment() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
			Appointments newap = new Appointments();
			System.out.println("Enter Appointment_id :");
			String id = sc.nextLine();
			try {
				Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			int apId = Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(apId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newap.setApp_id(apId);
			int result = AppointmentDao.deleteAppointment(Integer.parseInt(id));
			System.out.println(result);
		} finally {
			sc.close();
		}
	}

	public static void getAppointmentById() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
			Appointments newap = new Appointments();
			System.out.println("Enter Appointment_id :");
			String id = sc.nextLine();
			try {
				Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			int apId = Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(apId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newap.setApp_id(apId);
			Appointments result = AppointmentDao.getAppointmentById(Integer.parseInt(id));
			System.out.println(result.getApp_id() + " " + result.getApp_date() + " " + result.getDoctor_id() + " "
					+ result.getPatient_name() + " " + result.getFees_collected());
		} finally {
			sc.close();
		}
	}

	public static void getAllAppointmentDetails() {
		List<Appointments> allAppointments = AppointmentDao.getAllAppointments();
		Iterator<Appointments> apIterator = allAppointments.iterator();
		while (apIterator.hasNext()) {
			Appointments ap = apIterator.next();
			System.out.println(ap.getApp_id() + " " + ap.getApp_date() + " " + ap.getDoctor_id() + " "
					+ ap.getPatient_name() + " " + ap.getFees_collected());
		}
	}

}
