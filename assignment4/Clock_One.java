import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.time.LocalTime;

public class Clock_One{
    public static void main(String [] args){

        try {
            ServerIntf sf = new ServerImpl(LocalTime.parse("07:00:00",AppConstants.formatter));
            Registry registry1 = LocateRegistry.createRegistry(AppConstants.SERVER_PORT_1);
            registry1.rebind(ServerImpl.class.getSimpleName(),sf);
            System.out.println(String.format("Server started on port " + AppConstants.SERVER_PORT_1));
        } catch (Exception e) {
           System.out.println(e);
        }
    }
}
