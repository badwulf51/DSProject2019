package ie.gmit.sw.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

// Path
@WebServlet("/Customers")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CustomerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Create jersey client
		Client client = Client.create();
		
		// Link to api json data
		WebResource wr = client.resource("http://localhost:8080/Rest-Server/webapi/customer/get");
		
		// Take in data
		String r = wr.accept(MediaType.APPLICATION_JSON).get(String.class);
		
		// Gson used to serialize and deserialize Java objects to JSON
		Gson gson=new Gson();
		
		// Create the data type
		Type listType = new TypeToken<ArrayList<Customer>>(){}.getType();
		
		// Create object of the data
		List<Customer> customers = gson.fromJson(r, listType);

		// Assign data a variable that can be used in JSP page
        request.setAttribute("customers", customers);
        
        // Send user to specific JSP file
        request.getRequestDispatcher("/WEB-INF/Customers.jsp").forward(request, response);
	}
	
}
