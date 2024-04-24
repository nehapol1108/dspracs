import java.rmi.*;

public interface AddServerIntf extends Remote{
    double addition(double n1,double n2) throws RemoteException;
    double subtraction(double n1,double n2) throws RemoteException;
    double multiplication(double n1,double n2) throws RemoteException;
    double division(double n1,double n2) throws RemoteException;
    double powerOf2(double n1) throws RemoteException;
    double milesToKm(double miles) throws RemoteException;
    double celToFar(double cel) throws RemoteException;
    String compare2String(String s1,String s2) throws RemoteException;
    String echoServer(String name) throws RemoteException;
    int countVowels(String s1) throws RemoteException;
    double factorial(double n1) throws RemoteException;
}

//Terminal 1 
// javac *.java
//rmic AddServerImpl

//rmiregistry

//java AddServer

//java AddClient