package ie.gmit.sw;

import java.rmi.*;
import java.sql.SQLException;
import java.util.List;

// Crud interface used for RMI interaction
public interface DatabaseOption extends Remote {

	public void Connect() throws RemoteException, ClassNotFoundException, SQLException;

	public void Create(String sql) throws RemoteException, SQLException;

	public List<Object> ReadCustomers(String sql) throws RemoteException, SQLException;

	public List<Object> ReadCar(String sql) throws RemoteException, SQLException;

	public List<Object> ReadBookings(String sql) throws RemoteException, SQLException;

	public void Update(String sql) throws RemoteException, SQLException;

	public void Delete(String sql) throws RemoteException, SQLException;

	public void Close() throws RemoteException, SQLException;

}
