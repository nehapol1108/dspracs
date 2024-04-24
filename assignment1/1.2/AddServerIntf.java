import java.rmi.*;

public interface AddServerIntf extends Remote{
    public double addition(double a1,double a2) throws RemoteException;
}