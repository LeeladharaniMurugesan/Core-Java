package com.chainsys.miniproject.ui;


import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.chainsys.miniproject.commonutil.InvalidInputDataException;
import com.chainsys.miniproject.commonutil.Validator;
import com.chainsys.miniproject.dao.DoctorDao;
import com.chainsys.miniproject.pojo.Doctor;


	public class DoctorUi {		
		public static void addNewDoctor() {
			Scanner sc=new Scanner(System.in);
			Doctor newdoctor=new Doctor();
			System.out.println("Enter Doctor id");
			String id=sc.nextLine();
			try {
				Validator.checkStringForParse(id);
			}catch(InvalidInputDataException e) {
				e.printStackTrace();
			}
			int Doctor_id=Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(Doctor_id);
			}catch(InvalidInputDataException e) {
				e.printStackTrace();
			}
			newdoctor.setDoctor_id(Doctor_id);
//-------------------------------------------------------------------------
			System.out.println("Enter Doctor name");
			String Doctor_name=sc.nextLine();
			try {
				Validator.checklengthOfString(Doctor_name);
			}catch(InvalidInputDataException e) {
				e.printStackTrace();
			}
			try {
				Validator.checkStringOnly(Doctor_name);
			}catch(InvalidInputDataException e) {
				e.printStackTrace();
			}
			newdoctor.setDoctor_name(Doctor_name);
//---------------------------------------------------------------------------
			System.out.println("Enter dob");
			SimpleDateFormat s2 = new SimpleDateFormat("dd/MM/yyyy");
			String sDate=sc.nextLine();
			
			try {
				Validator.checkDateFormat(sDate);
			}catch(InvalidInputDataException e) {
				e.printStackTrace();
			}
				
			Date date =null;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
				
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			newdoctor.setDob(date);
//-------------------------------------------------------------------------------		
			System.out.println("Enter city");
			String City=sc.nextLine();
			try {
				Validator.checkStringOnly(City);
			}catch(InvalidInputDataException e) {
				e.printStackTrace();
			}
			newdoctor.setCity(City);
//--------------------------------------------------------------------------------------
			System.out.println("Enter doctor phone number");
	        String phno = sc.nextLine();
	        long docPhNo = 0;
	        try {
	            Validator.checkPhoneNumer(phno);
	        } catch (InvalidInputDataException err) {
	            err.printStackTrace();
	        }
	        try {
	            Validator.checkStringForParse(phno);
	            docPhNo = Long.parseLong(phno);
	        } catch (InvalidInputDataException err) {
	            err.printStackTrace();

	        }
	        newdoctor.setPhoneno(docPhNo);
//---------------------------------------------------------------------
			System.out.println("Enter Speciality");
			String Speciality=sc.nextLine();
			try {
				Validator.checkStringOnly(Speciality);
			}catch(InvalidInputDataException er) {
				er.printStackTrace();
			}
			newdoctor.setSpeciality(Speciality);
//---------------------------------------------------------------------
			System.out.println("Enter standard fees");
			String fees=sc.nextLine();
			int st_fees=Integer.parseInt(fees);
			try {
				Validator.checkSalary(st_fees);
			}catch(InvalidInputDataException er) {
				er.printStackTrace();
			}
			newdoctor.setStandard_fees(st_fees);
			int result =DoctorDao.insertDoctor(newdoctor);
			
			System.out.println(result);
			sc.close();}

		public static void updateDoctor() {
			java.util.Scanner sc = new java.util.Scanner(System.in);
			try {
			Doctor newdoc = new Doctor();
			System.out.println("Enter Doctor_Id :");
			String id = sc.nextLine();
			try {
			Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
			}
			int docId = Integer.parseInt(id);
			newdoc.setDoctor_id(Integer.parseInt(id));
			try {
			Validator.CheckNumberForGreaterThanZero(docId);
			} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
			}
			Doctor doc = DoctorDao.getDoctorById(docId);
			if (doc == null) {
			System.out.println("Doctor Doesn't Exist For Id " + docId);
			return;
			}
			newdoc.setDoctor_id(docId);
			System.out.println("Enter Update Name :");
			String name = sc.nextLine();
			try {
			Validator.checkStringOnly(name);
			} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
			}
			newdoc.setDoctor_name(name);
			Calendar c1 = Calendar.getInstance();
			java.util.Date newDate = new java.util.Date();
			newdoc.setDob(newDate);
			System.out.println("Enter Update Speciality :");
			String sp = sc.nextLine();
			try {
			Validator.checkStringOnly(sp);
			} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
			}
			newdoc.setSpeciality(sp);
			// newdoc.setSpeciality(sc.nextLine());
			System.out.println("Enter Update City :");
			String cy = sc.nextLine();
			try {
			Validator.checkStringOnly(cy);
			} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
			}
			newdoc.setCity(cy);
//---------------------------------------------------------------------------
			System.out.println("Enter doctor phone number");
	        String phno = sc.nextLine();
	        long docPhNo = 0;
	        try {
	            Validator.checkPhoneNumer(phno);
	        } catch (InvalidInputDataException err) {
	            err.printStackTrace();
	        }
	        try {
	            Validator.checkStringForParse(phno);
	            docPhNo = Long.parseLong(phno);
	        } catch (InvalidInputDataException err) {
	            err.printStackTrace();

	        }
	        newdoc.setPhoneno(docPhNo);
//------------------------------------------------------------------------------------
			System.out.println("Enter Update Standard_Fees :");
			float fees = sc.nextFloat();
			try {
			Validator.Checkfees(fees);
			} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
			}
			newdoc.setStandard_fees (fees);
			int result = DoctorDao.updateDoctor(newdoc);
			System.out.println(result);
			} finally {
			sc.close();
			}
			}
//---------------------------------------------------------------------------------------
			public static void updateDoctorFirstName() {
			java.util.Scanner sc = new java.util.Scanner(System.in);
			try {
			Doctor newdoc = new Doctor();
			System.out.println("Enter Doctor_Id :");
			String id = sc.nextLine();
			try {
			Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
			}
			int docId = Integer.parseInt(id);
			newdoc.setDoctor_id(Integer.parseInt(id));
			try {
			Validator.CheckNumberForGreaterThanZero(docId);
			} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
			}
			Doctor doc = DoctorDao.getDoctorById(docId);
			if (doc == null) {
			System.out.println("Doctor Doesn't Exist For Id " + docId);
			return;
			}
			newdoc.setDoctor_id(docId);
			System.out.println("Enter Update Name :");
			String name = sc.nextLine();
			try {
			Validator.checkStringForParse(name);
			} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
			}
			newdoc.setDoctor_name(name);
			int result = DoctorDao.updateDoctorName(Integer.parseInt(id), name);
			System.out.println(result);
			} finally {
			sc.close();
			}
			}
//-------------------------------------------------------------------------------------------
			public static void deleteDoctor() {
			java.util.Scanner sc = new java.util.Scanner(System.in);
			try {
			Doctor newdoc = new Doctor();
			System.out.println("Enter Doctor_Id :");
			String id = sc.nextLine();
			try {
			Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
			}
			int docId = Integer.parseInt(id);
			newdoc.setDoctor_id(Integer.parseInt(id));
			try {
			Validator.CheckNumberForGreaterThanZero(docId);
			} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
			}
			Doctor doc = DoctorDao.getDoctorById(docId);

			if (doc == null) {
			System.out.println("Doctor Doesn't Exist For Id " + docId);
			return;
			}
			newdoc.setDoctor_id(docId);
			int result = DoctorDao.deleteDoctor(Integer.parseInt(id));
			System.out.println(result);
			} finally {
			sc.close();
			}
			}

			public static void getDoctorById() {
			java.util.Scanner sc = new java.util.Scanner(System.in);
			try {
			Doctor newdoc = new Doctor();
			System.out.println("Enter Doctor_Id :");
			String id = sc.nextLine();
			try {
			Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
			}
			int docId = Integer.parseInt(id);
			newdoc.setDoctor_id(Integer.parseInt(id));
			try {
			Validator.CheckNumberForGreaterThanZero(docId);
			} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
			}
			Doctor doc = DoctorDao.getDoctorById(docId);
			if (doc == null) {
			System.out.println("Doctor Doesn't Exist For Id " + docId);
			return;
			}
			newdoc.setDoctor_id(docId);
			Doctor result = DoctorDao.getDoctorById(Integer.parseInt(id));
			System.out.println(result.getDoctor_id() + " " + result.getDoctor_name() + " " + result.getDob() + " "
			+ result.getSpeciality() + " " + result.getCity() + " " + result.getPhoneno() + " "
			+ result.getStandard_fees());
			} finally {
			sc.close();
			}
			}

			public static void getAllDoctorDetails() {
			List<Doctor> allDoctor = DoctorDao.getAllDoctors();
			Iterator<Doctor> drIterator = allDoctor.iterator();
			while (drIterator.hasNext()) {
			Doctor dr = drIterator.next();
			System.out.println(dr.getDoctor_id() + " " + dr.getDoctor_name() + " " + dr.getDob() + " " + dr.getSpeciality()
			+ " " + dr.getCity() + " " + dr.getPhoneno() + " " + dr.getStandard_fees());
			}
			}
}