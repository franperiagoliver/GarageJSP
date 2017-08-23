package com.everis.alicante.becajava.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.alicante.becajava.domain.Booking;
import com.everis.alicante.becajava.garage.controller.ControladorGaraje;
import com.everis.alicante.becajava.garage.controller.ControladorGarajeImpl;

public class BookingByDateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ControladorGaraje controladorGaraje = new ControladorGarajeImpl();
		
		String filtroFecha = req.getParameter("filtroFecha");
		
		if (filtroFecha.equals("filtroFecha")) {
			
			String fechaInicio=(String)req.getParameter("fechaInicio");
			String fechaFinal=(String)req.getParameter("fechaFin");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
			try {
				Date fecIni = (Date) formatter.parse(fechaInicio);
				Date fecFin = (Date) formatter.parse(fechaFinal);
				List<Booking> reservas = controladorGaraje.listarReservasByFecha(fecIni, fecFin);
				req.setAttribute("reservas", reservas);
				RequestDispatcher dispatcher = req.getRequestDispatcher("booking/listadoReservas.jsp");
				dispatcher.forward(req, resp);
				
			} catch (ParseException e) {

				e.printStackTrace();
			}
			
		}
	}

}
