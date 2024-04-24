import java.rmi.*; 
import java.rmi.server.*;


public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf{
    public AddServerImpl() throws RemoteException{

    }
    public double addition(double a1,double a2) throws RemoteException{
        return a1+a2;
    }
}
