import java.rmi.*;
import java.rmi.server.*;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf{
    public AddServerImpl() throws RemoteException{

    }
    public double celToFar(double cel) throws RemoteException{
        double far = ((9/5.0)*cel) + 32;
        return far;
    }
    public double milesToKm(double miles) throws RemoteException{
        double km = miles * 1.609344;
        return km;
    }
    public String echoServer(String name) throws RemoteException{
        String result = "Hello "+ name;
        return result;
    }
    public String compare2String(String s1,String s2) throws RemoteException{
        int minLength = Math.min(s1.length(),s2.length());
        for(int i=0;i<minLength;i++){
            char currS1 = s1.charAt(i);
            char currS2 = s2.charAt(i);

            if(currS1!=currS2){
                return currS1 > currS2 ? s1:s2;
            }
        }

        return s1.length()>s2.length() ? s1:s2;

        //inbuilt method 
        // int compare = s1.compareTo(s2);
        // if(compare>0){
        //     return s1;
        // }else{
        //     return s2;
        // }
        // return s1;
 
    }
    public int countVowel(String name) throws RemoteException{
        int count=0;
        for(int i=0;i<name.length();i++){
            char curr = name.charAt(i);
            if(curr=='a' || curr=='e' || curr=='i' || curr=='o' || curr=='u' || curr=='A' ||  curr=='E' || curr=='I' || curr=='O' || curr=='U' ){
                count++;
            }
        }
        return count;
    }
    public int getFactorial(int number) throws RemoteException{
        int fact = 1;
        for(int i=1;i<=number;i++){
            fact = fact*i;
        }
        return fact;
    }
}