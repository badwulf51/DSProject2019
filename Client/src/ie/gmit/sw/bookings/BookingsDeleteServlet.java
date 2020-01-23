package ie.gmit.sw.bookings;

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
@WebServlet("/BookingsDelete")
public class BookingsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookingsDeleteServlet() {
		super();
	}

	// Get request function
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get the id of the objects to delete
		String del = request.getParameter("id") + " " + request.getParameter("cusid");

		// Create jersey client
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Rest-Server/webapi/booking/delete");
		webResource.type("application/json").delete(ClientResponse.class, del);

		// Send user to Bookings page
		response.sendRedirect("/Web-Client/Bookings");
	}
}
