package com.everis.alicante.becajava.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.alicante.becajava.domain.Booking;
import com.everis.alicante.becajava.domain.Client;
import com.everis.alicante.becajava.garage.controller.ControladorGaraje;
import com.everis.alicante.becajava.garage.controller.ControladorGarajeImpl;

public class ClientServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mensaje = "";
		ControladorGaraje controladorGaraje = new ControladorGarajeImpl();
		Integer idClient = Integer.valueOf(req.getParameter("idClient"));

		if (req.getParameter("idClient") != null) {

			Client client = controladorGaraje.listarClientesById(idClient);

			String name = req.getParameter("name");
			String surname = req.getParameter("surname");
			String nif = req.getParameter("nif");
			String tlf = req.getParameter("tlf");

			client.setIdclient(idClient);
			client.setName(name);
			client.setSurname(surname);
			client.setNif(nif);
			client.setTelephone(tlf);

			Boolean actualizacionOk = controladorGaraje.actualizarCliente(client);

			if (actualizacionOk) {

				mensaje = "La actualización ha sido satisfactoria";
				req.setAttribute("mensaje", mensaje);
				req.setAttribute("ok", actualizacionOk);
				RequestDispatcher dispatcher = req.getRequestDispatcher("menu.jsp");
				dispatcher.forward(req, resp);

			}

		}
	}
}
