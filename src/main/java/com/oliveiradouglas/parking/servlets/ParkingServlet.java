package com.oliveiradouglas.parking.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.oliveiradouglas.parking.dao.ParkingDAO;
import com.oliveiradouglas.parking.dao.VehicleDAO;
import com.oliveiradouglas.parking.models.Color;
import com.oliveiradouglas.parking.models.Parking;
import com.oliveiradouglas.parking.models.Vehicle;
import com.oliveiradouglas.parking.src.Alert;

@WebServlet(urlPatterns = "/parkings")
public class ParkingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		try {
			Vehicle vehicle = new Vehicle();
			vehicle.setPlate(req.getParameter("vehiclePlate"));

			ParkingDAO dao  = new ParkingDAO();
			Parking parking = dao.findByVehiclePlate(vehicle); 
			
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			
			if (parking != null) {				
				JSONObject json = new JSONObject(parking);
				resp.getWriter().write(json.toString());
			} else {
				resp.getWriter().write("{}");
			}
		} catch (Exception e) {
			resp.getWriter().write("{}");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		Vehicle vehicle = new Vehicle();
		String vehicleId = req.getParameter("id");
		
		HttpSession session = req.getSession();
		
		if (vehicleId != null && !vehicleId.isEmpty()) {
			vehicle.setId(Integer.parseInt(vehicleId));
		} else {
			vehicle.setPlate(req.getParameter("vehicle_plate"));
			vehicle.setBrand(req.getParameter("brand"));
			vehicle.setModel(req.getParameter("model"));
			vehicle.setType(req.getParameter("type"));
			
			Color color = new Color();
			color.setId(Integer.parseInt(req.getParameter("color")));
			vehicle.setColor(color);
			
			try {
				VehicleDAO vehicleDAO = new VehicleDAO();
				vehicleDAO.insert(vehicle);				
			} catch (SQLException e) {
				session.setAttribute("alert", new Alert("Erro ao cadastrar o veiculo!", Alert.ERROR));
				resp.sendRedirect("vehicles");
			}
		}
		
		Parking parking = new Parking();
		parking.setNotes(req.getParameter("notes"));
		parking.setEntry(LocalDateTime.now());
		parking.setVehicle(vehicle);
		
		try {			
			ParkingDAO dao = new ParkingDAO();
			dao.insert(parking);
		} catch (SQLException e) {
			session.setAttribute("alert", new Alert("Erro ao registrar a entrada de veiculo!", Alert.ERROR));
			resp.sendRedirect("vehicles");
		}
		
		session.setAttribute("alert", new Alert("Entrada registrada com sucesso!", Alert.SUCCESS));
		resp.sendRedirect("vehicles");
	}
}
