package com.oliveiradouglas.parking.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oliveiradouglas.parking.model.ParkingControl;
import com.oliveiradouglas.src.Breadcrumb;

@WebServlet(urlPatterns = "/vehicles")
public class VehicleListingServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Breadcrumb> breadcrumbs = new ArrayList<>();
		breadcrumbs.add(new Breadcrumb("#", "vehicles", true));
		req.setAttribute("breadcrumbList", breadcrumbs);
		req.setAttribute("vehicles", new ArrayList<ParkingControl>());
		req.setAttribute("activeMenu", "vehicles");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/vehicle/index.jsp");
		dispatcher.forward(req, resp);
	}
}
