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
import com.chainsys.miniproject.dao.DoctorDao;
import com.chainsys.miniproject.pojo.Doctor;

/**
 * Servlet implementation class Doctors
 */
public class Doctors extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Doctors() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Doctor> allDoctor = DoctorDao.getAllDoctors();
		Iterator<Doctor> drIterator = allDoctor.iterator();
		while (drIterator.hasNext()) {
			Doctor dr = drIterator.next();
//			out.println(dr.getDoctor_id() + " " + dr.getDoctor_name() + " " + dr.getDob() + " " + dr.getSpeciality()
//			+ " " + dr.getCity() + " " + dr.getPhoneno() + " " + dr.getStandard_fees());
			out.println("<hr/>");

			out.println(dr.getDoctor_id() + "," + dr.getDoctor_name() + "," + dr.getDob() + "," + dr.getSpeciality()
					+ "," + dr.getCity() + "," + dr.getPhoneno() + "," + dr.getStandard_fees() + ",");

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
		String source ="AddNewDoctors";
		String message ="<h1>Error while"+source+ "</h1>";
		Doctor newdoctor = null;
		int result = 0;
		try {
			newdoctor = new Doctor();
			String id = request.getParameter("id");
			try {
				Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				message += "Error in Doctor id input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;
			}
			int Doctor_id = Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(Doctor_id);
			} catch (InvalidInputDataException err) {
				message += "Error in Doctor id input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;
			}
			newdoctor.setDoctor_id(Doctor_id);
//------------------------------------------------------------------------
			String Doctor_name = request.getParameter("name");
			try {
				Validator.checklengthOfString(Doctor_name);
			}catch (InvalidInputDataException err) {
				message += "Error in Doctor name input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;
			}
			try {
				Validator.checkStringOnly(Doctor_name);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
			}
			newdoctor.setDoctor_name(Doctor_name);
//---------------------------------------------------------------------------
			SimpleDateFormat s2 = new SimpleDateFormat("dd/MM/yyyy");
			String sDate = request.getParameter("dob");

			try {
				Validator.checkDateFormat(sDate);
			} catch (InvalidInputDataException err) {
				message += "Error in Doctor name input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;
			}
			Date date = null;
			try {
				
				date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);

			} catch (ParseException e) {

				e.printStackTrace();
			}
			newdoctor.setDob(date);
//-------------------------------------------------------------------------------		
			String City = request.getParameter("city");
			try {
				Validator.checkStringOnly(City);
			} catch (InvalidInputDataException err) {
				message += "Error in Employee id input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;
			}
			newdoctor.setCity(City);
//--------------------------------------------------------------------------------------
			String phno = request.getParameter("phno");
			long docPhNo = 0;
			try {
				Validator.checkPhoneNumer(phno);
			} catch (InvalidInputDataException err) {
				message += "Error in Doctor phno input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;
			}
			try {
				Validator.checkStringForParse(phno);
				docPhNo = Long.parseLong(phno);
			} catch (InvalidInputDataException err) {
				message += "Error in Doctor phno input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;

			}
			newdoctor.setPhoneno(docPhNo);
//---------------------------------------------------------------------
			String Speciality = request.getParameter("speciality");
			try {
				Validator.checkStringOnly(Speciality);
			} catch (InvalidInputDataException err) {
				message += "Error in Doctor speciality input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;
			}
			newdoctor.setSpeciality(Speciality);
//---------------------------------------------------------------------
			String fees = request.getParameter("standardfees");
			int st_fees = Integer.parseInt(fees);
			try {
				Validator.checkSalary(st_fees);
			} catch (InvalidInputDataException err) {
				message += "Error in Doctor standardfees input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;
			}
			newdoctor.setStandard_fees(st_fees);
			result = DoctorDao.insertDoctor(newdoctor);
			System.out.println(result + " Added Successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
		out.println("<div> Add New Doctor: " + result + "</div>");

	}
}
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String source ="UpdateDoctors";
		String message ="<h1>Error while"+source+ "</h1>";
		int result = 0;
		try {
		Doctor newdoc = new Doctor();
		String id =  request.getParameter("id");
		try {
		Validator.checkStringForParse(id);
		} catch (InvalidInputDataException err) {
			message += "Error in Doctor id input </p>";
			String errorPage =ExceptionManager.handleException(err, source, message);
			out.print(errorPage);
		//	err.printStackTrace();
			return;
		}
		int docId = Integer.parseInt(id);
		newdoc.setDoctor_id(Integer.parseInt(id));
		try {
		Validator.CheckNumberForGreaterThanZero(docId);
		} catch (InvalidInputDataException err) {
			message += "Error in Doctor id input </p>";
			String errorPage =ExceptionManager.handleException(err, source, message);
			out.print(errorPage);
		//	err.printStackTrace();
			return;
		}
		Doctor doc = DoctorDao.getDoctorById(docId);
		if (doc == null) {
		System.out.println("Doctor Doesn't Exist For Id " + docId);
		return;
		}
		newdoc.setDoctor_id(docId);
		
		String name =  request.getParameter("name");
		try {
		Validator.checkStringOnly(name);
		} catch (InvalidInputDataException err) {
			message += "Error in Doctor name input </p>";
			String errorPage =ExceptionManager.handleException(err, source, message);
			out.print(errorPage);
		//	err.printStackTrace();
			return;
		}
//---------------------------------------------------------------------
		newdoc.setDoctor_name(name);
		Calendar c1 = Calendar.getInstance();
		java.util.Date newDate = new java.util.Date();
		newdoc.setDob(newDate);
//--------------------------------------------------------------------
		System.out.println("Enter Update Speciality :");
		String sp =  request.getParameter("speciality");
		try {
		Validator.checkStringOnly(sp);
		} catch (InvalidInputDataException err) {
			message += "Error in Doctor speciality input </p>";
			String errorPage =ExceptionManager.handleException(err, source, message);
			out.print(errorPage);
		//	err.printStackTrace();
			return;
		}
		newdoc.setSpeciality(sp);
		// newdoc.setSpeciality(sc.nextLine());
		System.out.println("Enter Update City :");
		String cy =  request.getParameter("city");
		try {
		Validator.checkStringOnly(cy);
		} catch (InvalidInputDataException err) {
		err.printStackTrace();
		return;
		}
		newdoc.setCity(cy);
//---------------------------------------------------------------------------
		System.out.println("Enter doctor phone number");
        String phno = request.getParameter("phno");
        long docPhNo = 0;
        try {
            Validator.checkPhoneNumer(phno);
        } catch (InvalidInputDataException err) {
			message += "Error in Doctor phno input </p>";
			String errorPage =ExceptionManager.handleException(err, source, message);
			out.print(errorPage);
		//	err.printStackTrace();
			return;
        }
        try {
            Validator.checkStringForParse(phno);
            docPhNo = Long.parseLong(phno);
        } catch (InvalidInputDataException err) {
			message += "Error in Doctor phno input </p>";
			String errorPage =ExceptionManager.handleException(err, source, message);
			out.print(errorPage);
		//	err.printStackTrace();
			return;

        }
        newdoc.setPhoneno(docPhNo);
//------------------------------------------------------------------------------------
        String fees = request.getParameter("standardfees");
		int st_fees = Integer.parseInt(fees);
		try {
			Validator.checkSalary(st_fees);
		} catch (InvalidInputDataException err) {
			message += "Error in Doctor salary input </p>";
			String errorPage =ExceptionManager.handleException(err, source, message);
			out.print(errorPage);
		//	err.printStackTrace();
			return;
		}
		newdoc.setStandard_fees(st_fees);
		 result = DoctorDao.updateDoctor(newdoc);
		System.out.println(result);
		System.out.println(result + " Updated Successfully");
	}catch(Exception e) {
		e.printStackTrace();
	}
	out.println("<div> Update New Doctor: " + result + "</div>");
}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			String source ="DeleteDoctors";
			String message ="<h1>Error while"+source+ "</h1>";
			int result = 0;
		try {
			Doctor newdoc = new Doctor();
			String id = request.getParameter("doctor_id");
			try {
				Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				message += "Error in Doctor id input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;			}
			int docId = Integer.parseInt(id);
			newdoc.setDoctor_id(Integer.parseInt(id));
			try {
				Validator.CheckNumberForGreaterThanZero(docId);
			} catch (InvalidInputDataException err) {
				message += "Error in Doctor id input </p>";
				String errorPage =ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
			//	err.printStackTrace();
				return;
			}
			Doctor doc = DoctorDao.getDoctorById(docId);

			if (doc == null) {
				System.out.println("Doctor Doesn't Exist For Id " + docId);
				return;
			}
			newdoc.setDoctor_id(docId);
			result = DoctorDao.deleteDoctor(Integer.parseInt(id));
			System.out.println(result);
			System.out.println(result + " Deleted Successfully");
		}catch(Exception e) {
			e.printStackTrace();
			out.println("<div> Delete Doctor: " + result + "</div>");
		}
	}
}
