package com.chainsys.miniproject.pojo;

import java.util.Date;

public class Appointments {
         
    private int app_id;  
    private Date app_date ;      
    private int doctor_id;     
    private String  patient_name ;
    private float fees_collected ;
    
    public int getApp_id() {
        return app_id;
    }
    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }
    public Date getApp_date() {
        return app_date;
    }
    public void setApp_date(Date app_date) {
        this.app_date = app_date;
    }
    public int getDoctor_id() {
        return doctor_id;
    }
    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }
    public String getPatient_name() {
        return patient_name;
    }
    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }
    public float getFees_collected() {
        return fees_collected;
    }
    public void setFees_collected(float fees_collected) {
    	this.fees_collected=fees_collected;
    }
    
	}


