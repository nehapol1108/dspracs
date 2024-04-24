import java.rmi.*;
import java.util.*;

public class AddClient{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        try{
            String serverUrl = "rmi://"+args[0]+"/Server";
            AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup(serverUrl);
            System.out.println("Enter the number :");
            double a1 = sc.nextDouble();
            double power = addServerIntf.powerMath(a1);
            System.out.println("Power is : "+ power);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}