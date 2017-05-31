package com.oliveiradouglas.parking.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oliveiradouglas.src.Breadcrumb;
import com.oliveiradouglas.src.MessagesHelper;

@WebServlet(urlPatterns="/settings")
public class SettingController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Breadcrumb> breadcrumbs = new ArrayList<>();
		breadcrumbs.add(new Breadcrumb("#", MessagesHelper.getMessage("settings", req.getLocale()), true));
		req.setAttribute("breadcrumbList", breadcrumbs);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/setting/index.jsp");
		dispatcher.forward(req, resp);
	}
}
