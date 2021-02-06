//Interface file
import java.rmi.*;

public interface Sort extends Remote {


	public String sorting(int a[]) throws RemoteException;
}