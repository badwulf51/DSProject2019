package ie.gmit.sw.car;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

// Path
@WebServlet("/CarAdd")
public class CarAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CarAddServlet() {
		super();
	}

	// Get request function
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Send user to specific JSP file
		request.getRequestDispatcher("/WEB-INF/CarAdd.jsp").forward(request, response);
	}

	// Post request function
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get params sent from jsp page
		String reg = request.getParameter("reg");
		String year = request.getParameter("year");
		String make = request.getParameter("make");
		String cost = request.getParameter("cost");

		// Create jersey client
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Rest-Server/webapi/car/post");
		String input = reg + " " + year + " " + make + " " + cost;
		webResource.type("application/json").post(ClientResponse.class, input);

		// Send user to Bookings page
		response.sendRedirect("/Web-Client/Cars");
	}

}
