import java.rmi.*;
import java.util.Scanner;
public class AddClient {
    public static void main(String args[]) { 
        Scanner sc = new Scanner(System.in);
        try {
            // Get reference to the remote object
            String addServerURL = "rmi://localhost/AddServer"; 
            AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup(addServerURL);
            // System.out.println("The first number is: " + args[1]); 
            // double d1 = Double.parseDouble(args[1]);
            // System.out.println("The second number is: " + args[2]);
            // double d2 = Double.parseDouble(args[2]);
            // Invoke remote method to add numbers
            System.out.println("Enter the first number : "); 
            double d1 = sc.nextDouble();
            System.out.println("Enter the second number : "); 
            double d2 = sc.nextDouble();

            System.out.println("The sum is: " + addServerIntf.add(d1, d2));
        } 
        catch (Exception e) { 
            System.out.println("Exception: "+ e);
        }
    }
}