package com.oliveiradouglas.parking.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oliveiradouglas.parking.dao.ParkingDAO;

@WebServlet(urlPatterns = "/parkings/{id}")
public class ParkingDatailsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		try {
			String id = req.getParameter("id");

			ParkingDAO dao = new ParkingDAO();
			req.setAttribute("parking", dao.findById(Integer.parseInt(id)));
			
			resp.getWriter().write("sucesso");
		} catch (SQLException e) {
			resp.getWriter().write("erro");
		}
	}
}
