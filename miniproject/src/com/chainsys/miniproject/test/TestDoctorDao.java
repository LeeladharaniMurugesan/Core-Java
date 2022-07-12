package com.chainsys.miniproject.test;


import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import com.chainsys.miniproject.dao.DoctorDao;
import com.chainsys.miniproject.pojo.Doctor;
import java.util.Date;


public class TestDoctorDao {
	public static void testInsertDoctor() {
        
        Doctor newdoc=new Doctor();
        newdoc.setDoctor_id(105);
        newdoc.setDoctor_name("vanathi");
        Calendar c1= Calendar.getInstance();
        Date date= c1.getTime();
        newdoc.setDob(date);
        newdoc.setSpeciality("eye doctor");
        newdoc.setCity("Madurai");
        newdoc.setPhoneno(97659675421l);
        newdoc.setStandard_fees(900);
        int result =DoctorDao.insertDoctor(newdoc);
        System.out.println(result);
      
  }
	public static void testUpdateDoctor() {
	    Doctor oldDoc=DoctorDao.getDoctorById(104);
	    System.out.println(oldDoc.getDoctor_id()+" "+oldDoc.getDoctor_name()+" "+oldDoc.getStandard_fees());
	    oldDoc.setDoctor_name("harini");
	    Calendar c1=Calendar.getInstance();
	   java.util.Date newDate=c1.getTime();
	   	oldDoc.setDob(newDate);
	    oldDoc.setSpeciality("Eye Doctor");
	    oldDoc.setCity("salem");
	    oldDoc.setPhoneno(8979665646l);
	    oldDoc.setStandard_fees(800);
	    int result =DoctorDao.updateDoctor(oldDoc);
	    System.out.println(result);
	}
	public static void testUpdateDoctorName() {
		int result =DoctorDao.updateDoctorName(102,"kani");
		System.out.println(result);
	}
	public static void testDeleteDoctor() {
		int result =DoctorDao.deleteDoctor(105);
		System.out.println(result);
	}
	
		public static void testGetAllDoctors() {
			List<Doctor> alldoc = DoctorDao.getAllDoctors();
			Iterator<Doctor> docIterator =alldoc.iterator();
			while(docIterator.hasNext()) {
				Doctor doc =docIterator.next();
				System.out.println(doc.getDoctor_id()+" "+doc.getDoctor_name()+" "+doc.getStandard_fees());
			}
		}
	
	public static void testGetDoctorById() {
		Doctor doc =DoctorDao.getDoctorById(103);
		System.out.println(doc.getDoctor_id()+" " +doc.getDoctor_name()+" "+doc.getStandard_fees());
	}

}
