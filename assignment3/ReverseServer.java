import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.CosNaming.*;
import ReverseModule.*;

public class ReverseServer{
    public static void main(String [] args){

        try {
            ORB orb = ORB.init(args,null);

            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();

            ReverseImpl reverseImpl = new ReverseImpl();
            org.omg.CORBA.Object h_ref = ReverseHelper.narrow(rootPoa.servant_to_reference(reverseImpl));

            org.omg.CORBA.Object Objref = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(Objref);

            NameComponent path[] = ncRef.to_name("Reverse");
            ncRef.rebind(path,h_ref);

            orb.run();


        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}