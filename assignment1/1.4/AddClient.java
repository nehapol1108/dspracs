import java.rmi.*;
import java.util.*;

public class AddClient{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        try {
            String serverUrl = "rmi://localhost/AddServer";
            AddServerIntf addServerIntf = (AddServerIntf)Naming.lookup(serverUrl);
            System.out.println("Enter temp in degree : ");
            double cel = sc.nextDouble();
            System.out.println("temp in far : " + addServerIntf.celToFar(cel));

            System.out.println("Enter distance in miles : ");
            double miles = sc.nextDouble();
            System.out.println("distance in KM : " + addServerIntf.milesToKm(miles));
            sc.nextLine();
            System.out.println("Enter name : ");
            String name = sc.nextLine();
            System.out.println(addServerIntf.echoServer(name));

            System.out.println("Enter string 1 : ");
            String s1 = sc.nextLine();
            System.out.println("Enter string 2 : ");
            String s2 = sc.nextLine();
            System.out.println("comparison : " + addServerIntf.compare2String(s1,s2));

            System.out.println("Enter string to count vowel : ");
            String test = sc.nextLine();
            System.out.println(addServerIntf.countVowel(test));
            
            System.out.println("Enter integer to find factorial : ");
            int number = sc.nextInt();
            System.out.println(addServerIntf.getFactorial(number));


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}