package ie.gmit.sw.car;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

// Path
@WebServlet("/CarDelete")
public class CarDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CarDeleteServlet() {
		super();
	}

	// Get request function
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Create jersey client
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Rest-Server/webapi/car/delete");
		webResource.type("application/json").delete(ClientResponse.class,
				request.getParameter("id"));

		// Send user to cars page
		response.sendRedirect("/Web-Client/Cars");
	}
}
