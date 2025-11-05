import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String sayHello() throws RemoteException;
    String sayHi() throws RemoteException;
    String sum(int x, int y) throws RemoteException;
}
