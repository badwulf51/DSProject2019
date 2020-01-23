package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMISetup {

	// Adapted from 'ds wk6 RMI FileServer'
	public static void main(String[] args) throws Exception {

		// Setup interface
		DatabaseOption db = new DatabaseOptionImpl();

		// Setup RMI with poer 1099
		LocateRegistry.createRegistry(1099);

		// Add interface to RMI
		Naming.rebind("databaseOption", db);

		// Output that the RMI service has started
		System.out.println("RMI server started...");

		// Generate testing table
		DatabaseOptionImpl.createTables();
	}

}
