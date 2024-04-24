import java.rmi.*;
import java.util.*;
public class AddClient {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        try{
            String serverAddUrl = "rmi://"+args[0]+"/Server";
            AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup(serverAddUrl);

            System.out.println("Enter the first number : "); 
            double d1 = sc.nextDouble();
            System.out.println("Enter the second number : "); 
            double d2 = sc.nextDouble();

            System.out.println("addition is : "+addServerIntf.addition(d1,d2));
        }catch(Exception e){
            System.out.println(e);
        }
    }

}