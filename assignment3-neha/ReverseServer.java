import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;
import ReverseModule.*;

public class ReverseServer {
    public static void main(String [] args){
        try {
            ORB orb = ORB.init(args,null);

            POA poaRoot = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            poaRoot.the_POAManager().activate();

            ReverseImpl reverseImpl = new ReverseImpl();
            org.omg.CORBA.Object h_ref = ReverseHelper.narrow(poaRoot.servant_to_reference(reverseImpl));

            org.omg.CORBA.Object obj_ref = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(obj_ref);
            NameComponent path[] = ncRef.to_name("Reverse");

            ncRef.rebind(path,h_ref);
            orb.run();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
