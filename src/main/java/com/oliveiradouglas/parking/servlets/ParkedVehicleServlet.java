package com.oliveiradouglas.parking.servlets;

import java.io.IOException;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.oliveiradouglas.parking.dao.ParkingDAO;
import com.oliveiradouglas.parking.dao.SettingDAO;
import com.oliveiradouglas.parking.models.Parking;
import com.oliveiradouglas.parking.models.Setting;
import com.oliveiradouglas.parking.src.Alert;

@WebServlet(urlPatterns="/parked-vehicle")
public class ParkedVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		
		String parkingId = req.getParameter("id");
		
		try	{			
			ParkingDAO dao = new ParkingDAO();
			Parking parking = dao.findById(Integer.parseInt(parkingId));
			
			SettingDAO settingDAO = new SettingDAO();
			Setting setting = settingDAO.findSetting();
			
			JSONObject json = new JSONObject(parking);
			
			int permanence = (int) Math.ceil(Duration.between(parking.getEntry(), LocalDateTime.now()).toMinutes() / 60D);
			json.put("permanence", permanence);
			
			Double total = (permanence * setting.getOtherHoursValue()) + (setting.getFirstHourValue() - setting.getOtherHoursValue());
			NumberFormat nf = NumberFormat.getCurrencyInstance();
			json.put("total", nf.format(total));
			
			resp.getWriter().write(json.toString());
		} catch (Exception e) {
			resp.getWriter().write("{}");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String parkingId = req.getParameter("id");
		
		HttpSession session = req.getSession();
		if (parkingId == null || parkingId.isEmpty()) {
			session.setAttribute("alert", new Alert("Veiculo não informado!", Alert.ERROR));
			resp.sendRedirect("parkings");
			return;
		}
				
		try {
			ParkingDAO dao = new ParkingDAO();
			Parking parking = dao.findById(Integer.parseInt(parkingId));
			parking.giveLow();
			
			session.setAttribute("alert", new Alert("Saida registrada com sucesso!", Alert.SUCCESS));
		} catch (Exception e) {
			session.setAttribute("alert", new Alert("Erro ao registrar saida do veículo!", Alert.ERROR));
		}

		resp.sendRedirect("parkings");
	}
}
