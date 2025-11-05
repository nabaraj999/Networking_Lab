
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class HelloImpl extends UnicastRemoteObject implements Hello {
    protected HelloImpl() throws RemoteException {
        super();
    }

    public String sayHello() {
        return "Hello from the remote object!";
    }

    public String sayHi() {
        return "Hi from the remote object!";
    }

    public String sum(int a, int b) {
        int temp = a + b;
        return "The sum of numbers are: " + temp;
    }
}