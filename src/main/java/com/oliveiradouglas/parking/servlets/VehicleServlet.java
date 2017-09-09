package com.oliveiradouglas.parking.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.oliveiradouglas.parking.dao.VehicleDAO;
import com.oliveiradouglas.parking.models.Vehicle;

@WebServlet(urlPatterns = "/vehicles")
public class VehicleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		try {
			Vehicle vehicle = new Vehicle();
			vehicle.setPlate(req.getParameter("vehiclePlate"));

			VehicleDAO dao  = new VehicleDAO();
			vehicle = dao.findByPlate(vehicle); 
			
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			
			if (vehicle != null) {				
				JSONObject json = new JSONObject(vehicle);
				resp.getWriter().write(json.toString());
			} else {
				resp.getWriter().write("{}");
			}
		} catch (Exception e) {
			resp.getWriter().write("{}");
		}
	}
}
