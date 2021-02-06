import java.rmi.*;
import java.rmi.server.*;
import java.util.Arrays;

public class RMIServer extends UnicastRemoteObject implements Sort{
	
	public RMIServer() throws RemoteException{
		super();
	}

	public String sorting(int [] arr) throws  RemoteException{
		Arrays.sort(arr);
		return Arrays.toString(arr);
	}
	

	public static void main(String args[]) throws Exception{
		RMIServer server =new RMIServer();
		System.out.println("RMI Server is running");
		Naming.rebind("sortServer",server);
	}


}