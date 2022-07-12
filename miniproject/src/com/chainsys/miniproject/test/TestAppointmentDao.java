package com.chainsys.miniproject.test;


import java.util.Calendar;

import java.util.Iterator;
import java.util.List;
import com.chainsys.miniproject.dao.AppointmentDao;
import com.chainsys.miniproject.pojo.Appointments;
import java.util.Date;


public class TestAppointmentDao {
	public static void testInsertAppointment() {
        
        Appointments newdoc=new Appointments();
        newdoc.setApp_id(105);
        Calendar c1= Calendar.getInstance();
        Date date= c1.getTime();
        newdoc.setApp_date(date);
        newdoc.setDoctor_id(101);
        newdoc.setPatient_name("97659675421l");
        newdoc.setFees_collected(900);
        int result =AppointmentDao.insertAppointment(newdoc);
        System.out.println(result);
      
  }
	public static void testUpdateDoctor() {
	    Appointments oldDoc=AppointmentDao.getAppointmentById(104);
	    System.out.println(oldDoc.getApp_id()+" "+oldDoc.getPatient_name()+" "+oldDoc.getDoctor_id());
	    Appointments newdoc=new Appointments();
        newdoc.setApp_id(105);
        Calendar c1= Calendar.getInstance();
        Date date= c1.getTime();
        newdoc.setApp_date(date);
        newdoc.setDoctor_id(101);
        newdoc.setPatient_name("97659675421l");
        newdoc.setFees_collected(900);
	    int result =AppointmentDao.updateAppointment(oldDoc);
	    System.out.println(result);
	}
	public static void testDeleteAppointment() {
		int result =AppointmentDao.deleteAppointment(105);
		System.out.println(result);
	}
	
		public static void testGetAllAppointments() {
			List<Appointments> alldoc = AppointmentDao.getAllAppointments();
			Iterator<Appointments> docIterator =alldoc.iterator();
			while(docIterator.hasNext()) {
				Appointments doc =docIterator.next();
				System.out.println(doc.getApp_id()+" "+doc.getPatient_name()+" "+doc.getDoctor_id());
			}
		}
	
	public static void testAppointmentGetById() {
		Appointments doc =AppointmentDao.getAppointmentById(103);
		System.out.println(doc.getDoctor_id()+" " +doc.getPatient_name()+" "+doc.getDoctor_id());
	}

}
