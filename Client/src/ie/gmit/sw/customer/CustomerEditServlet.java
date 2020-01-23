package ie.gmit.sw.customer;

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
@WebServlet("/CustomersEdit")
public class CustomerEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CustomerEditServlet() {
        super();
    }

    // Get request function
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Create jersey client
		Client client = Client.create();
		
		// Link to api json data
		WebResource wr = client.resource("http://localhost:8080/Rest-Server/webapi/customer/edit/" + request.getParameter("id"));
		
		// Take in data
		String r = wr.accept(MediaType.APPLICATION_JSON).get(String.class);
		
		// Gson used to serialize and deserialize Java objects to JSON
		Gson gson=new Gson();
		
		// Create the data type
		Type listType = new TypeToken<ArrayList<Customer>>(){}.getType();
		
		// Create object of the data
		List<Customer> customers = gson.fromJson(r, listType);

		// Assign data a variable that can be used in JSP pages
        request.setAttribute("customers", customers);
        
     // Send user to specific JSP file
        request.getRequestDispatcher("/WEB-INF/CustomerEdit.jsp").forward(request, response);
	}
	
	// Post request function
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get params sent from jsp page
		String id = request.getParameter("id");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String num = request.getParameter("num");
		
		// Create jersey client
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Rest-Server/webapi/customer/update");
		String input = id + " "+ fname + " " + lname + " " + num;
		webResource.type("application/json").put(ClientResponse.class, input);
		
		// Send user to Bookings page
		response.sendRedirect("/Web-Client/Customers");
	}
	
}
