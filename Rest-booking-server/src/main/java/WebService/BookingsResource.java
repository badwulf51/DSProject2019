package WebService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;

import ie.gmit.sw.DatabaseOption;

// Path
@Path("booking")
public class BookingsResource {

	// RMI settings
	private String service = "/databaseOption";
	private String address = "localhost:1099";

	// This function displays all bookings in the database
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBookings()
			throws RemoteException, MalformedURLException, NotBoundException, SQLException, ClassNotFoundException {

		// Connect to RMI and setup crud interface
		DatabaseOption db = (DatabaseOption) Naming.lookup("rmi://" + address + service);

		// Connect to database
		db.Connect();

		// Get all data in bookings and add to list object
		List<Object> rs = db.ReadBookings("SELECT * FROM BOOKINGS");

		// Disconnect to database
		db.Close();

		// GSON import used to serialize and deserialize Java objects to JSON
		Gson gson = new Gson();

		// Set to string
		String jsonResp = gson.toJson(rs);

		// Return webpage with json data from RMI
		return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
	}

	// This function is used to add bookings to the database through the /post
	// webpage
	@POST
	@Path("/post")
	@Consumes("application/json")
	public void postBooking(String input)
			throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, SQLException {

		// Separate incoming data into individual strings
		String[] splited = input.split("\\s+");

		// Connect to RMI and setup crud interface
		DatabaseOption db = (DatabaseOption) Naming.lookup("rmi://" + address + service);

		// Connect to database
		db.Connect();

		// Create a new row in the bookings table
		db.Create(
				"INSERT INTO BOOKINGS (CUSTOMERID, CARID, DATESTART, DATEEND, FIRST, SECOND, NUMBER, REG, YEAR, MAKE, COST ) VALUES ('"
						+ splited[0] + "', '" + splited[7] + "', '" + splited[5] + "', '" + splited[6] + "', '"
						+ splited[8] + "', '" + splited[9] + "', '" + splited[10] + "', '" + splited[2] + "', '"
						+ splited[3] + "', '" + splited[1] + "', '" + splited[4] + "')");

		// Disconnect to database
		db.Close();
	}

	// This function is used to get one object in the database
	@GET
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBookingbyID(@PathParam(value = "id") int id)
			throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, SQLException {

		// Connect to RMI and setup crud interface
		DatabaseOption db = (DatabaseOption) Naming.lookup("rmi://" + address + service);

		// Connect to database
		db.Connect();

		// Get specific booking by its unique id
		List<Object> rs = db.ReadBookings("SELECT * FROM BOOKINGS WHERE id=" + id);

		// Disconnect to database
		db.Close();

		// GSON import used to serialize and deserialize Java objects to JSON
		Gson gson = new Gson();

		// Set to string
		String jsonResp = gson.toJson(rs);

		// Return webpage with json data from RMI
		return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
	}

	// This function is used to update a row in the bookings table
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void putBooking(String input)
			throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, SQLException {

		// Separate incoming data into individual strings
		String[] splited = input.split("\\s+");

		// Connect to RMI and setup crud interface
		DatabaseOption db = (DatabaseOption) Naming.lookup("rmi://" + address + service);

		// Connect to database
		db.Connect();

		// Update the bookings table
		db.Update("UPDATE BOOKINGS SET CUSTOMERID='" + splited[3] + "', CARID='" + splited[7] + "', DATESTART='"
				+ splited[1] + "', DATEEND='" + splited[2] + "', FIRST='" + splited[4] + "', SECOND='" + splited[5]
				+ "', NUMBER='" + splited[6] + "', REG='" + splited[8] + "', YEAR='" + splited[9] + "', MAKE='"
				+ splited[10] + "', COST='" + splited[11] + "' WHERE id='" + splited[0] + "'");

		// Update the customer table
		db.Update("UPDATE CUSTOMERS SET FIRST='" + splited[4] + "', SECOND='" + splited[5] + "', NUMBER='" + splited[6]
				+ "' WHERE id='" + splited[3] + "'");

		// Update the cars table
		db.Update("UPDATE CARS SET reg='" + splited[8] + "', YEAR='" + splited[9] + "', MAKE='" + splited[10]
				+ "', COST='" + splited[11] + "' WHERE id='" + splited[7] + "'");

		// Disconnect to database
		db.Close();
	}

	// This function is used to delete data from the bookings table
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public void delBooking(String id)
			throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, SQLException {

		// Separate incoming data into individual strings
		String[] splited = id.split("\\s+");

		// Connect to RMI and setup crud interface
		DatabaseOption db = (DatabaseOption) Naming.lookup("rmi://" + address + service);

		// Connect to database
		db.Connect();

		// Delete the bookings table
		db.Delete("DELETE FROM BOOKINGS WHERE id='" + splited[0] + "'");

		db.Close();
	}

}
