import ReverseModule.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.CosNaming.*;
import java.io.*;

public class ReveseClient {
    public static void main(String[] args) {
        Reverse rvr = null ;
        try {
            ORB orb = ORB.init(args,null);
            org.omg.CORBA.Object ref = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(ref) ;
            System.out.println("Enter String="); 

		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		    String str = br.readLine();

            rvr  = ReverseHelper.narrow(ncRef.resolve_str("Reverse"));
            System.out.println("Reverse Strng is "+ rvr.reverse_string(str) );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
