import ReverseModule.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.CosNaming.*;
import java.io.*;
public class ReverseClient {
    public static void main(String [] args){
        Reverse rvr = null;
        try {
            ORB orb = ORB.Init(args,null);
            org.omg.CORBA.Object obj_ref = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(obj_ref);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter string");
            String str = br.readLine();

            rvr = ReverseHelper.narrow(ncRef.resolve_str("Reverse"));
            System.out.println(rvr.reverse_string(str));
        } catch (Exception e) {
           System.out.println(e);
        }
    }
}
