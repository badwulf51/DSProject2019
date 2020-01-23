package ie.gmit.sw;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.h2.jdbc.JdbcSQLException;

public class DatabaseOptionImpl extends UnicastRemoteObject implements DatabaseOption {

	// Serializable Id
	private static final long serialVersionUID = 1L;

	// Connection settings
	private Connection conn = null;

	// Null constructor
	public DatabaseOptionImpl() throws RemoteException {
		super();
	}

	public void Connect() throws ClassNotFoundException, SQLException {

		Class.forName("org.h2.Driver");

		this.conn = DriverManager.getConnection("jdbc:h2:~/DSProject", "", "");
		
		// Output task
		System.out.println("User Connecting...");

	}

	public void Create(String sql) throws SQLException {

		// Setup statement with connection
		Statement stmt = this.conn.createStatement();

		// Run sql statement
		stmt.execute(sql);

		// Output task
		System.out.println("User Creating...");
	}

	// Function used for reading customers from database
	public List<Object> ReadCustomers(String sql) throws SQLException {

		ResultSet rs = null;

		ArrayList<Object> list = new ArrayList<>();

		Statement stmt = this.conn.createStatement();

		rs = stmt.executeQuery(sql);

		while (rs.next()) {

			Customer c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));

			list.add(c);
		}

		// Output task
		System.out.println("User Reading Customers...");

		return list;
	}

	// Function used for reading cars from database
	public List<Object> ReadCar(String sql) throws SQLException {

		ResultSet rs = null;

		ArrayList<Object> list = new ArrayList<>();

		Statement stmt = this.conn.createStatement();

		rs = stmt.executeQuery(sql);

		while (rs.next()) {

			Car c = new Car(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getDouble(5));

			list.add(c);
		}

		// Output task
		System.out.println("User Reading Cars...");

		return list;
	}

	// function used to read bookings from database
	public List<Object> ReadBookings(String sql) throws SQLException {

		ResultSet rs = null;

		ArrayList<Object> list = new ArrayList<>();

		Statement stmt = this.conn.createStatement();

		rs = stmt.executeQuery(sql);

		while (rs.next()) {

			Bookings b = new Bookings(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11),
					rs.getDouble(12));

			list.add(b);
		}

		// Output task
		System.out.println("User Reading Bookings...");

		return list;
	}

	public void Update(String sql) throws SQLException {

		// Setup statement with connection
		Statement stmt = this.conn.createStatement();

		// Run sql statement
		stmt.execute(sql);

		// Output task
		System.out.println("User Updating...");

	}

	public void Delete(String sql) throws SQLException {

		// Setup statement with connection
		Statement stmt = this.conn.createStatement();

		// Run sql statement
		stmt.execute(sql);

		// Output task
		System.out.println("User Deleting...");
	}

	public void Close() throws SQLException {

		// Close database connection
		this.conn.close();
		
		// Output task
		System.out.println("User Disconnecting...");

	}

	public static void createTables() throws SQLException {

		// Connection setup
		Connection connSet = DriverManager.getConnection("jdbc:h2:~/DSProject", "", "");

		// Setup tables
		CreateCustomersTable(connSet);
		CreateCarsTable(connSet);
		CreateBookingsTable(connSet);

	}

	private static void CreateCustomersTable(Connection connTest) throws SQLException {

		// Setup table creation
		Statement stmt = connTest.createStatement();
		String sql;

		try {
			// Drop table
			sql = "DROP TABLE CUSTOMERS";
			stmt.execute(sql);

			// Create table
			sql = "CREATE TABLE CUSTOMERS (" + "`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "FIRST VARCHAR(255) NOT NULL," + "SECOND VARCHAR(255) NOT NULL," + "NUMBER VARCHAR(255) NOT NULL"
					+ ");";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO CUSTOMERS (FIRST, SECOND, NUMBER) VALUES ('Cian', 'Gannon', '1234567')";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO CUSTOMERS (FIRST, SECOND, NUMBER) VALUES ('John', 'Jameson', '6574321')";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO CUSTOMERS (FIRST, SECOND, NUMBER) VALUES ('Anna', 'Smith', '9999999')";
			stmt.execute(sql);

		} catch (JdbcSQLException e) {
			// Create table
			sql = "CREATE TABLE CUSTOMERS (" + "`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "FIRST VARCHAR(255) NOT NULL," + "SECOND VARCHAR(255) NOT NULL," + "NUMBER VARCHAR(255) NOT NULL"
					+ ");";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO CUSTOMERS (FIRST, SECOND, NUMBER) VALUES ('Cian', 'Gannon', '1234567')";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO CUSTOMERS (FIRST, SECOND, NUMBER) VALUES ('John', 'Jameson', '6574321')";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO CUSTOMERS (FIRST, SECOND, NUMBER) VALUES ('Anna', 'Smith', '9999999')";
			stmt.execute(sql);
		}
	}

	private static void CreateCarsTable(Connection connTest) throws SQLException {

		// Setup table creation
		Statement stmt = connTest.createStatement();
		String sql;

		try {
			// Drop table
			sql = "DROP TABLE CARS";
			stmt.execute(sql);

			// Create table
			sql = "CREATE TABLE CARS (" + "`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY," + "REG VARCHAR(255) NOT NULL,"
					+ "YEAR INT NOT NULL," + "MAKE VARCHAR(255) NOT NULL," + "COST DOUBLE NOT NULL" + ");";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO CARS (REG, YEAR, MAKE, COST) VALUES ('07-GA-5633', '2007', 'Ford', '249.99')";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO CARS (REG, YEAR, MAKE, COST) VALUES ('14-D-4626', '2014', 'Volkswagen', '499.99')";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO CARS (REG, YEAR, MAKE, COST) VALUES ('14-D-4627', '2014', 'Volkswagen', '499.99')";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO CARS (REG, YEAR, MAKE, COST) VALUES ('17-L-2418', '2017', 'Toyota', '649.99')";
			stmt.execute(sql);

		} catch (JdbcSQLException e) {

			sql = "CREATE TABLE CARS (" + "`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY," + "REG VARCHAR(255) NOT NULL,"
					+ "YEAR INT NOT NULL," + "MAKE VARCHAR(255) NOT NULL," + "COST DOUBLE NOT NULL" + ");";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO CARS (REG, YEAR, MAKE, COST) VALUES ('07-GA-5633', '2007', 'Ford', '249.99')";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO CARS (REG, YEAR, MAKE, COST) VALUES ('14-D-4626', '2014', 'Volkswagen', '499.99')";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO CARS (REG, YEAR, MAKE, COST) VALUES ('14-D-4627', '2014', 'Volkswagen', '499.99')";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO CARS (REG, YEAR, MAKE, COST) VALUES ('17-L-2418', '2017', 'Toyota', '649.99')";
			stmt.execute(sql);
		}
	}

	private static void CreateBookingsTable(Connection connTest) throws SQLException {

		// Setup table creation
		Statement stmt = connTest.createStatement();
		String sql;

		try {
			// Drop table
			sql = "DROP TABLE BOOKINGS";
			stmt.execute(sql);

			// Create table
			sql = "CREATE TABLE BOOKINGS (" + "`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "CUSTOMERID INT NOT NULL," + "CARID INT NOT NULL," + "DATESTART VARCHAR(255) NOT NULL,"
					+ "DATEEND VARCHAR(255) NOT NULL," + "FIRST VARCHAR(255) NOT NULL,"
					+ "SECOND VARCHAR(255) NOT NULL," + "NUMBER VARCHAR(255) NOT NULL," + "REG VARCHAR(255) NOT NULL,"
					+ "YEAR INT NOT NULL," + "MAKE VARCHAR(255) NOT NULL," + "COST DOUBLE NOT NULL" + ");";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO BOOKINGS (CUSTOMERID, CARID, DATESTART, DATEEND, FIRST, SECOND, NUMBER, REG, YEAR, MAKE, COST ) VALUES ('1', '1', '2018-11-28', '2018-12-03', 'Cian', 'Gannon', '1234567', '07-GA-5633', '2007', 'Ford', '249.99')";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO BOOKINGS (CUSTOMERID, CARID, DATESTART, DATEEND, FIRST, SECOND, NUMBER, REG, YEAR, MAKE, COST ) VALUES ('2', '2', '2018-11-30', '2018-12-07', 'John', 'Jameson', '6574321', '14-D-4626', '2014', 'Volkswagen', '499.99')";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO BOOKINGS (CUSTOMERID, CARID, DATESTART, DATEEND, FIRST, SECOND, NUMBER, REG, YEAR, MAKE, COST ) VALUES ('3', '4', '2018-11-03', '2018-12-06', 'Anna', 'Smith', '9999999', '17-L-2418', '2017', 'Toyota', '649.99')";
			stmt.execute(sql);
		} catch (JdbcSQLException e) {
			// Create table
			sql = "CREATE TABLE BOOKINGS (" + "`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "CUSTOMERID INT NOT NULL," + "CARID INT NOT NULL," + "DATESTART VARCHAR(255) NOT NULL,"
					+ "DATEEND VARCHAR(255) NOT NULL," + "FIRST VARCHAR(255) NOT NULL,"
					+ "SECOND VARCHAR(255) NOT NULL," + "NUMBER VARCHAR(255) NOT NULL," + "REG VARCHAR(255) NOT NULL,"
					+ "YEAR INT NOT NULL," + "MAKE VARCHAR(255) NOT NULL," + "COST DOUBLE NOT NULL" + ");";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO BOOKINGS (CUSTOMERID, CARID, DATESTART, DATEEND, FIRST, SECOND, NUMBER, REG, YEAR, MAKE, COST ) VALUES ('1', '1', '2018-11-28', '2018-12-03', 'Cian', 'Gannon', '1234567', '07-GA-5633', '2007', 'Ford', '249.99')";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO BOOKINGS (CUSTOMERID, CARID, DATESTART, DATEEND, FIRST, SECOND, NUMBER, REG, YEAR, MAKE, COST ) VALUES ('2', '2', '2018-11-30', '2018-12-07', 'John', 'Jameson', '6574321', '14-D-4626', '2014', 'Volkswagen', '499.99')";
			stmt.execute(sql);

			// Insert data into table
			sql = "INSERT INTO BOOKINGS (CUSTOMERID, CARID, DATESTART, DATEEND, FIRST, SECOND, NUMBER, REG, YEAR, MAKE, COST ) VALUES ('3', '4', '2018-11-03', '2018-12-06', 'Anna', 'Smith', '9999999', '17-L-2418', '2017', 'Toyota', '649.99')";
			stmt.execute(sql);
		}
	}
}
