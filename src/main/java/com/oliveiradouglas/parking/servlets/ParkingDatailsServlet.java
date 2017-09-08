package com.oliveiradouglas.parking.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.oliveiradouglas.parking.dao.ParkingDAO;
import com.oliveiradouglas.parking.models.Parking;
import com.oliveiradouglas.parking.models.Vehicle;

@WebServlet(urlPatterns = "/parkings")
public class ParkingDatailsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		try {
			Vehicle vehicle = new Vehicle();
			vehicle.setPlate(req.getParameter("vehiclePlate").replace("-", ""));

			ParkingDAO dao  = new ParkingDAO();
			Parking parking = dao.findByVehiclePlate(vehicle); 
			
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			
			if (parking != null) {				
				JSONObject json = new JSONObject(parking.getVehicle());
				resp.getWriter().write(json.toString());
			} else {
				resp.getWriter().write("{}");
			}
		} catch (SQLException e) {
			resp.getWriter().write("{}");
		}
	}
}
