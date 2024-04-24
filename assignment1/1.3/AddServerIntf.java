import java.rmi.*;

public interface AddServerIntf extends Remote{
    public double powerMath(double a1) throws RemoteException;
}