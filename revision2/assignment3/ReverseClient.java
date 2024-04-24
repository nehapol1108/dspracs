import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.CosNaming.*;
import ReverseModule.*;
import java.io.*;
import java.util.*;

public class ReverseClient{
    public static void main(String[] args) {
        Reverse rvr = null;
        try {
            ORB orb = ORB.init(args,null);

            org.omg.CORBA.Object obj_ref = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(obj_ref);
            System.out.println("Eneter string");
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String s = bf.readLine();

            rvr = ReverseHelper.narrow(ncRef.resolve_str("Reverse"));
            System.out.println(rvr.reverse_string(s));
        } catch (Exception e) {
           System.out.println(e);
        }
        
    }
}



// idlj -fall ReverseModule.idl
//javac *.java ReverseModule/*.java 
// orbd -ORBInitialPort 1056&
// java ReverseServer -ORBInitialPort 1056&


// second terinal
//ReverseClient -ORBInitialPort 1056 -ORBInitialHost localhost


// idlj -fall ReverseModule.idl
// javac *.java ReverseModule/*.java 
// orbd -ORBInitialPort 1056&
// java ReverseServer -ORBInitialPort 1056&

//terminal 2 
//java ReverseClient -ORBInitalPort 1056 -ORBInitialHost localhost