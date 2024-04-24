import java.rmi.*;

public interface AddServerIntf extends Remote{
    public double celToFar(double cel) throws RemoteException;
    public double milesToKm(double miles) throws RemoteException;
    public String echoServer(String name) throws RemoteException;
    public String compare2String(String s1,String s2) throws RemoteException;
    public int countVowel(String name) throws RemoteException;
    public int getFactorial(int number) throws RemoteException;
}