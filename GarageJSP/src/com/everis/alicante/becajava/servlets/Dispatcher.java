package com.everis.alicante.becajava.servlets;

import java.io.IOException;
import java.sql.Date;
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
			RequestDispatcher dispatcher = req.getRequestDispatcher("parkingplace/listadoPlazas.jsp");
			dispatcher.forward(req, resp);
			break;
		case 2:
			List<Parkingplace> plazasOcupadas = controlador.listarPlazasOcupadas();
			req.setAttribute("plazas", plazasOcupadas);
			RequestDispatcher dispatcher2 = req.getRequestDispatcher("parkingplace/listadoPlazasOcupadas.jsp");
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
			RequestDispatcher dispatcher3 = req.getRequestDispatcher("booking/altaReserva.jsp");
			dispatcher3.forward(req, resp);
			break;
		case 4:
			List<Client> clientes = controlador.listarClientes();
			req.setAttribute("clientes", clientes);
			RequestDispatcher dispatcher4 = req.getRequestDispatcher("client/listadoClientes.jsp");
			dispatcher4.forward(req, resp);
			break;
		case 5:
			List<Booking> reservas = controlador.listarReservas();
			req.setAttribute("reservas", reservas);
			RequestDispatcher dispatcher5 = req.getRequestDispatcher("booking/listadoReservas.jsp");
			dispatcher5.forward(req, resp);
			break;
		case 6:
			List<Vehicle> vehiculos = controlador.listarVehiculos();
			req.setAttribute("vehiculos", vehiculos);
			RequestDispatcher dispatcher6 = req.getRequestDispatcher("vehicle/listadoVehiculos.jsp");
			dispatcher6.forward(req, resp);
			break;
		case 7:
//			List<Booking> reservasFecha = controlador.listarReservasByFecha();
//			req.setAttribute("reservasFecha", reservasFecha);
			resp.sendRedirect("booking/formularioFechasReservas.jsp");
			break;
		case 8:
			req.setAttribute("reserva", controlador.listarReservasById(Integer.valueOf(req.getParameter("id"))));
			RequestDispatcher dispatcher8 = req.getRequestDispatcher("booking/modificarReserva.jsp");
			dispatcher8.forward(req, resp);
			break;
		case 9:
			req.setAttribute("cliente", controlador.listarClientesById(Integer.valueOf(req.getParameter("id"))));
			RequestDispatcher dispatcher9 = req.getRequestDispatcher("client/modificarCliente.jsp");
			dispatcher9.forward(req, resp);
			break;
		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
