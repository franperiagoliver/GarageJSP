package com.everis.alicante.becajava.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.alicante.becajava.domain.Booking;
import com.everis.alicante.becajava.domain.Client;
import com.everis.alicante.becajava.domain.Vehicle;
import com.everis.alicante.becajava.garage.controller.ControladorGaraje;
import com.everis.alicante.becajava.garage.controller.ControladorGarajeImpl;

public class BookingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ControladorGaraje controladorGaraje = new ControladorGarajeImpl();
		
		if (req.getAttribute("idBooking")!=null) {
			Integer idBooking = Integer.valueOf(req.getParameter("idBooking"));
			Booking booking = controladorGaraje.listarReservasById(idBooking);
			
			String name = req.getParameter("name");
			String surname = req.getParameter("surname");
			String nif = req.getParameter("nif");
			String tlf = req.getParameter("tlf");
			String plate = req.getParameter("plate");
			String vehicleModel = req.getParameter("vehicleModel");
			
			booking.getClient().setName(name);
			booking.getClient().setSurname(surname);
			booking.getClient().setNif(nif);
			booking.getClient().setTelephone(tlf);
			booking.getVehicle().setVehicleplate(plate);
			booking.getVehicle().setVehiclemodel(vehicleModel);

			Boolean actualizacionOk = controladorGaraje.actualizarReserva(booking);
			
			if(actualizacionOk) {
				
				resp.sendRedirect("menu.jsp");
				
			}
			
		} else {
			String name = req.getParameter("name");
			String surname = req.getParameter("surname");
			String nif = req.getParameter("nif");
			String tlf = req.getParameter("tlf");
			String plate = req.getParameter("plate");
			String vehicleModel = req.getParameter("vehicleModel");

			Vehicle vehicle = new Vehicle();
			vehicle.setVehiclemodel(vehicleModel);
			vehicle.setVehicleplate(plate);

			Set<Vehicle> vehicles = new HashSet<>();
			vehicles.add(vehicle);

			Client client = new Client();
			client.setName(name);
			client.setSurname(surname);
			client.setNif(nif);
			client.setTelephone(tlf);
			client.setVehicles(vehicles);

			vehicle.setClient(client);

			ControladorGaraje controladorGaraje1 = new ControladorGarajeImpl();
			controladorGaraje1.reservarPlaza(client, vehicle);

			resp.sendRedirect("menu.jsp");

			String reservasFechas = req.getParameter("reservasFechas");
		}
	}
	
	
	
}
