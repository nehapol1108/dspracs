import java.rmi.*;
import java.rmi.server.*;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf{
    public AddServerImpl() throws RemoteException{

    }
    public double powerMath(double a1) throws RemoteException{
        double power = Math.pow(2,a1);
        return power;
    }
}