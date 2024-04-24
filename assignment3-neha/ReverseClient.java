import org.omg.PortableServer.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import ReverseModule.*;
import java.io.*;

public class ReverseClient {
    public static void main(String []args){
        Reverse rvr = null;
        try {
            ORB orb = ORB.init(args,null);
            org.omg.CORBA.Object objref = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objref);

            System.out.println("Enter string to reverse : ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();

            rvr = ReverseHelper.narrow(ncRef.resolve_str("Reverse"));
            System.out.println(rvr.reverse_string(str));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


// idlj -fall ReverseModule.idl
// javac *.java ReverseModule/*.java 
// orbd -ORBInitialPort 1056&
// java ReverseServer -ORBInitialPort 1056&

//terminal 2 
//java ReverseClient -ORBInitalPort 1056 -ORBInitialHost localhost