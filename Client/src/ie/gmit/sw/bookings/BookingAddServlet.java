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

import ie.gmit.sw.car.Car;
import ie.gmit.sw.customer.Customer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

// Path
@WebServlet("/BookingsAdd")
public class BookingAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookingAddServlet() {
		super();
	}

	// Get request function
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Create jersey client
		Client client = Client.create();

		// Gson used to serialize and deserialize Java objects to JSON
		Gson gson = new Gson();

		// Links to api json data
		WebResource wrCu = client.resource("http://localhost:8080/Rest-Server/webapi/customer/get");
		WebResource wrCa = client.resource("http://localhost:8080/Rest-Server/webapi/car/get");

		// Take in data
		String rCu = wrCu.accept(MediaType.APPLICATION_JSON).get(String.class);
		String rCa = wrCa.accept(MediaType.APPLICATION_JSON).get(String.class);

		// Create the data type
		Type listTypeCu = new TypeToken<ArrayList<Car>>() {
		}.getType();
		Type listTypeCa = new TypeToken<ArrayList<Customer>>() {
		}.getType();

		// Create objects of the data
		List<Customer> customers = gson.fromJson(rCu, listTypeCa);
		List<Car> cars = gson.fromJson(rCa, listTypeCu);

		// Assign data a variable that can be used in JSP pages
		request.setAttribute("customers", customers);
		request.setAttribute("cars", cars);

		// Send user to specific JSP file
		request.getRequestDispatcher("/WEB-INF/BookingsAdd.jsp").forward(request, response);
	}

	// Post request function
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get params sent from jsp page
		String carID = request.getParameter("carID");
		String sDate = request.getParameter("sdate");
		String eDate = request.getParameter("edate");
		String custID = request.getParameter("custID");

		// Create jersey client
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Rest-Server/webapi/booking/post");
		String input = carID + " " + sDate + " " + eDate + " " + custID;
		webResource.type("application/json").post(ClientResponse.class, input);

		// Send user to Bookings page
		response.sendRedirect("/Web-Client/Bookings");
	}

}
