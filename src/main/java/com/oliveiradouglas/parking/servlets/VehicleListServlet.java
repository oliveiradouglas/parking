package com.oliveiradouglas.parking.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oliveiradouglas.parking.dao.ColorDAO;
import com.oliveiradouglas.parking.dao.ParkingDAO;
import com.oliveiradouglas.parking.src.Alert;
import com.oliveiradouglas.parking.src.Breadcrumb;

@WebServlet(urlPatterns = "/vehicles")
public class VehicleListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Breadcrumb> breadcrumbs = new ArrayList<>();
		breadcrumbs.add(new Breadcrumb("#", "vehicles", true));
		req.setAttribute("breadcrumbList", breadcrumbs);
		req.setAttribute("activeMenu", "vehicles");
		
		try {
			ParkingDAO dao = new ParkingDAO();
			req.setAttribute("parkings", dao.findAll());
			
			ColorDAO colorDAO = new ColorDAO();
			req.setAttribute("colors", colorDAO.findAll());
		} catch (SQLException e) {
			req.setAttribute("alert", new Alert("Erro ao carregar a lista de veiculos estacionados", Alert.ERROR));
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/vehicle/index.jsp");
		dispatcher.forward(req, resp);
	}
}
