package com.oliveiradouglas.parking.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oliveiradouglas.parking.dao.ColorDAO;
import com.oliveiradouglas.parking.dao.ParkingDAO;
import com.oliveiradouglas.parking.dao.VehicleDAO;
import com.oliveiradouglas.parking.models.Color;
import com.oliveiradouglas.parking.models.Parking;
import com.oliveiradouglas.parking.models.Vehicle;
import com.oliveiradouglas.parking.src.Alert;
import com.oliveiradouglas.parking.src.Breadcrumb;

@WebServlet(urlPatterns = "/parkings")
public class ParkingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Breadcrumb> breadcrumbs = new ArrayList<>();
		breadcrumbs.add(new Breadcrumb("#", "vehicles", true));
		req.setAttribute("breadcrumbList", breadcrumbs);
		req.setAttribute("activeMenu", "vehicles");
		
		try {
			ParkingDAO dao = new ParkingDAO();
			req.setAttribute("parkings", dao.findAllParkedVehicles());
			
			ColorDAO colorDAO = new ColorDAO();
			req.setAttribute("colors", colorDAO.findAll());
		} catch (SQLException e) {
			req.setAttribute("alert", new Alert("Erro ao carregar a lista de veiculos estacionados", Alert.ERROR));
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/parking/index.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		Vehicle vehicle  = new Vehicle();
		String vehicleId = req.getParameter("vehicleId");
		
		HttpSession session = req.getSession();
		ParkingDAO dao 		= new ParkingDAO();
		
		if (vehicleId != null && !vehicleId.isEmpty()) {
			vehicle.setId(Integer.parseInt(vehicleId));
			
			try {
				if (dao.checkIfVehicleIsParked(vehicle)) {
					session.setAttribute("alert", new Alert("O veículo ja esta estacionado!", Alert.ERROR));
					resp.sendRedirect("parkings");
					return;
				}
			} catch (SQLException e) {
				session.setAttribute("alert", new Alert("Erro ao verificar se o veículo ja esta estacionado!", Alert.ERROR));
				resp.sendRedirect("parkings");
				return;
			}
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
				resp.sendRedirect("parkings");
				return;
			}
		}
		
		Parking parking = new Parking();
		parking.setNotes(req.getParameter("notes"));
		parking.setEntry(LocalDateTime.now());
		parking.setVehicle(vehicle);
		
		try {
			dao.insert(parking);
		} catch (SQLException e) {
			session.setAttribute("alert", new Alert("Erro ao registrar a entrada de veiculo!", Alert.ERROR));
			resp.sendRedirect("parkings");
			return;
		}
		
		session.setAttribute("alert", new Alert("Entrada registrada com sucesso!", Alert.SUCCESS));
		resp.sendRedirect("parkings");
	}

}
