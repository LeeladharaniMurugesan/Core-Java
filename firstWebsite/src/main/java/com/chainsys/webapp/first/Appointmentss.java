package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.miniproject.commonutil.ExceptionManager;
import com.chainsys.miniproject.commonutil.InvalidInputDataException;
import com.chainsys.miniproject.commonutil.Validator;
import com.chainsys.miniproject.dao.AppointmentDao;
import com.chainsys.miniproject.pojo.Appointments;
import com.chainsys.miniproject.pojo.Doctor;

/**
 * Servlet implementation class Appointmentss
 */
public class Appointmentss extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Appointmentss() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		List<Appointments> allAppointments = AppointmentDao.getAllAppointments();
		Iterator<Appointments> apIterator = allAppointments.iterator();
		while (apIterator.hasNext()) {
			Appointments ap = apIterator.next();
			out.println("<hr/>");
			out.println(ap.getApp_id() + " ," + ap.getApp_date() + " ," + ap.getDoctor_id() + ", "
					+ ap.getPatient_name() + " ," + ap.getFees_collected());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String submitValue = request.getParameter("submit");
		System.out.println(submitValue);
		if (submitValue.equals("UPDATE")) {
			doPut(request, response);
		} else if (submitValue.equals("DELETE")) {
			doDelete(request, response);
		} else if (submitValue.equals("ADD")) {
		Appointments app = new Appointments();
		String source ="AddAppointments";
		String message ="<h1>Error while"+source+ "</h1>";
		int result = 0;
		try {
			app = new Appointments();
			String id = request.getParameter("app_id");
			try {
				Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				message += "Error in app id input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;		
			}
			int apId = Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(apId);
			} catch (InvalidInputDataException err) {
				message += "Error in Doctor id input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;		
			}
			app.setApp_id(apId);
//---------------------------------------------------------------------------------------------
			Calendar c1 = Calendar.getInstance();
			java.util.Date newDate = c1.getTime();
			app.setApp_date(newDate);
//----------------------------------------------------------------------------------------------
			String doc_id = request.getParameter("doctor_id");
			try {
				Validator.checkStringForParse(doc_id);
			} catch (InvalidInputDataException err) {
				message += "Error in Doctor doctor id input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;		
			}
			int apId1 = Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(apId1);
			} catch (InvalidInputDataException err) {
				message += "Error in Doctor id input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;		

			}
			app.setDoctor_id(Integer.parseInt(doc_id));
//------------------------------------------------------------------------------------
			String name = request.getParameter("patient_name");

			try {
				Validator.checkStringOnly(name);
			} catch (InvalidInputDataException err) {
				message += "Error in patient name input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;		

			}
			app.setPatient_name(name);
//--------------------------------------------------------------------------------------
			String fees = request.getParameter("fees_collected");
			float fs = Float.parseFloat(fees);
			try {
				Validator.Checkfees(fs);
			} catch (InvalidInputDataException err) {
				message += "Error in patient name input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;		

			}
			app.setFees_collected(fs);
			result = AppointmentDao.insertAppointment(app);
			System.out.println(result);
			System.out.println(result + " Added Successfully");
			out.println("<div> Add New Appointments: " + result + "</div>");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String source ="UpdateAppointments";
		String message ="<h1>Error while"+source+ "</h1>";
			int result = 0;
			try {
				Appointments newap = new Appointments();
				System.out.println("Enter Appointment_id :");
				String id = request.getParameter("id");
				try {
					Validator.checkStringForParse(id);
				} catch (InvalidInputDataException err) {
					message += "Error in app id input </p>";
					String errorPage =ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
				//	err.printStackTrace();
					return;		
				}
				int apId = Integer.parseInt(id);
				try {
					Validator.CheckNumberForGreaterThanZero(apId);
				} catch (InvalidInputDataException err) {
					message += "Error in app id input </p>";
					String errorPage =ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
				//	err.printStackTrace();
					return;	
				}
				newap.setApp_id(apId);

				Calendar c1 = Calendar.getInstance();
				java.util.Date newDate = new java.util.Date();
				newap.setApp_date(newDate);
				System.out.println("Enter Update Doctor_Id :");
				String id1 = request.getParameter("doctor_id");
				try {
					Validator.checkStringForParse(id1);
				} catch (InvalidInputDataException err) {
					message += "Error in doctor id input </p>";
					String errorPage =ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
				//	err.printStackTrace();
					return;	
				}
				int docId = Integer.parseInt(id1);
				try {
					Validator.CheckNumberForGreaterThanZero(docId);
				} catch (InvalidInputDataException err) {
					message += "Error in doctor id input </p>";
					String errorPage =ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
				//	err.printStackTrace();
					return;	
				}
				newap.setDoctor_id(docId);
				System.out.println("Enter Update Patient Name :");
				String name = request.getParameter("patient_name");
				try {
					Validator.checkStringOnly(name);
				} catch (InvalidInputDataException err) {
					message += "Error in patient name input </p>";
					String errorPage =ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
				//	err.printStackTrace();
					return;	
				}
				newap.setPatient_name(name);
				System.out.println("Enter fees collected:");
				String fe = request.getParameter("fees_collected");
				try {
					Validator.checkStringForParse(fe);
				} catch (InvalidInputDataException err) {
					message += "Error in fees collected input </p>";
					String errorPage =ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
				//	err.printStackTrace();
					return;	
				}

				float fees = Float.parseFloat(fe);

				try {
					Validator.Checkfees(fees);
				} catch (InvalidInputDataException err) {
					message += "Error in fees collected input </p>";
					String errorPage =ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
				//	err.printStackTrace();
					return;	

				}
				newap.setFees_collected(fees);
				result = AppointmentDao.updateAppointment(newap);
				System.out.println(result);

			} catch (Exception e) {
				e.printStackTrace();
			}
			out.println("<div> Update New Appointments: " + result + "</div>");
		}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String source ="DeleteAppointments";
		String message ="<h1>Error while"+source+ "</h1>";
		int result = 0;
		Appointments newap = new Appointments();
		try {
			String id = request.getParameter("app_id");
			try {
				Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				message += "Error in app id  input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;	
			}
			int apId = Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(apId);
			} catch (InvalidInputDataException err) {
				message += "Error in  app id input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;	
			}
			newap.setApp_id(apId);
			result = AppointmentDao.deleteAppointment(Integer.parseInt(id));
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("<div> Delete  Appointments: " + result + "</div>");
	}
}
