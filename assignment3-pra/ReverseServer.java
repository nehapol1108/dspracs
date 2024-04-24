import org.omg.CORBA.*;
import ReverseModule.*;
import org.omg.PortableServer.*;
import org.omg.CosNaming.*;


public class ReverseServer {
    public static void main(String[] args) {

        try {
            // step 1 create orb
            ORB orb = ORB.init(args, null);
            // step 2 rootpoa 

            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA")) ;
            rootPoa.the_POAManager().activate();

            // step 3 impl object 
            ReverseImpl reverseImpl = new ReverseImpl() ;
            org.omg.CORBA.Object h_ref = ReverseHelper.narrow(rootPoa.servant_to_reference(reverseImpl)); 


            // step 4 naming service 
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            // step 5
            NameComponent path[] = ncRef.to_name("Reverse");

            ncRef.rebind(path,h_ref);
            orb.run();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
