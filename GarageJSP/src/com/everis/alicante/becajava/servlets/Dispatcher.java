package com.everis.alicante.becajava.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
import com.everis.alicante.becajava.domain.Parkingplace;
import com.everis.alicante.becajava.domain.Vehicle;
import com.everis.alicante.becajava.garage.controller.ControladorGaraje;
import com.everis.alicante.becajava.garage.controller.ControladorGarajeImpl;

public class Dispatcher extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int option = Integer.parseInt(req.getParameter("option"));

		System.out.println("##option" + option);

		ControladorGaraje controlador = new ControladorGarajeImpl();

		switch (option) {
		case 1:
			List<Parkingplace> plazas = controlador.listarPlazasLibres();
			req.setAttribute("plazas", plazas);
			RequestDispatcher dispatcher = req.getRequestDispatcher("listadoPlazas.jsp");
			dispatcher.forward(req, resp);
			break;
		case 2:
			List<Parkingplace> plazasOcupadas = controlador.listarPlazasOcupadas();
			req.setAttribute("plazas", plazasOcupadas);
			RequestDispatcher dispatcher2 = req.getRequestDispatcher("listadoPlazasOcupadas.jsp");
			dispatcher2.forward(req, resp);
			break;
		case 3:
			List<Parkingplace> plazasLibres = controlador.listarPlazasLibres();
			List<String> coches = new ArrayList<>();
			coches.add("ABARTH");
			coches.add("ALFA ROMEO");
			coches.add("Aston Martin".toUpperCase());
			coches.add("Audi".toUpperCase());
			coches.add("Bentley".toUpperCase());
			coches.add("BMW");
			coches.add("Cadillac".toUpperCase());
			coches.add("Tata".toUpperCase());
			coches.add("Volvo".toUpperCase());
			coches.add("Seat".toUpperCase());
			coches.add("Mercedes".toUpperCase());
			req.setAttribute("coches", coches);

			req.setAttribute("plazas", plazasLibres);
			RequestDispatcher dispatcher3 = req.getRequestDispatcher("altaReserva.jsp");
			dispatcher3.forward(req, resp);
			break;
		case 4:
			List<Client> clientes = controlador.listarClientes();
			req.setAttribute("clientes", clientes);
			RequestDispatcher dispatcher4 = req.getRequestDispatcher("listadoClientes.jsp");
			dispatcher4.forward(req, resp);
			break;
		case 5:
			List<Booking> reservas = controlador.listarReservas();
			req.setAttribute("reservas", reservas);
			RequestDispatcher dispatcher5 = req.getRequestDispatcher("listadoReservas.jsp");
			dispatcher5.forward(req, resp);
			break;
		case 6:
			List<Vehicle> vehiculos = controlador.listarVehiculos();
			req.setAttribute("vehiculos", vehiculos);
			RequestDispatcher dispatcher6 = req.getRequestDispatcher("listadoVehiculos.jsp");
			dispatcher6.forward(req, resp);
			break;
		case 7:
			List<Booking> reservasFecha = controlador.listarReservasByFecha();
			req.setAttribute("reservasFecha", reservasFecha);
			RequestDispatcher dispatcher7 = req.getRequestDispatcher("formularioFechasReservas.jsp");
			dispatcher7.forward(req, resp);
			break;
		case 8:
			req.setAttribute("reserva", controlador.listarReservasById(Integer.valueOf(req.getParameter("id"))));
			RequestDispatcher dispatcher8 = req.getRequestDispatcher("modificarReserva.jsp");
			dispatcher8.forward(req, resp);
			break;
		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ControladorGaraje controladorGaraje = new ControladorGarajeImpl();
		Integer idBooking = Integer.valueOf(req.getParameter("idBooking"));
		
		if(req.getAttribute("idBooking")== null) {
			
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
