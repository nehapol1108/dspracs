import java.rmi.*;
import java.rmi.server.*;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf{
    public AddServerImpl() throws RemoteException{

    }
    public double addition(double n1,double n2) throws RemoteException{
        return n1+n2;
    }
    public double subtraction(double n1,double n2) throws RemoteException{
        return n1-n2;
    }
    public double multiplication(double n1,double n2) throws RemoteException{
        return n1*n2;
    }
    public double division(double n1,double n2) throws RemoteException{
        if(n2==0){
            System.out.println("division by zero not allowed");
            return 0;
        }
        return n1/n2;
    }
    public double powerOf2(double n1) throws RemoteException{
        return Math.pow(2,n1);
    }
    public double milesToKm(double miles) throws RemoteException{
        return miles * 1.609344;
    }
    public double celToFar(double cel) throws RemoteException{
        double res = ((9/5.0)*cel) + 32;
        return res;
    }
    public String compare2String(String s1,String s2) throws RemoteException{
        int minLenth = Math.min(s1.length(),s2.length());
        for(int i=0;i<minLenth;i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1!=c2){
                return (c1>c2)?s1:s2;
            }
        }
        return (s1.length()>s2.length())?s1:s2;
    }
    public String echoServer(String name) throws RemoteException{
        return "Hello "+ name;
    }
    public int countVowels(String name) throws RemoteException{
        int count=0;
        for(int i=0;i<name.length();i++){
            char curr = name.charAt(i);
            if(curr=='a' || curr=='e' || curr=='i' || curr=='o' || curr=='u' || curr=='A' ||  curr=='E' || curr=='I' || curr=='O' || curr=='U' ){
                count++;
            }
        }
        return count;
    }
    public double factorial(double n1) throws RemoteException{
        double fact = 1;
        for(int i=1;i<=n1;i++){
            fact = fact*i;
        }
        return fact;
    }
}