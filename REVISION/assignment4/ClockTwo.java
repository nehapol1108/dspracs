import java.rmi.*;
import java.time.LocalTime;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClockTwo{
    public static void main(String[] args) {
        try {
            ServerIntf s2 = new ServerImpl(LocalTime.parse("07:00:00",AppConstants.formatter));
            Registry registry2 = LocateRegistry.createRegistry(AppConstants.SERVER_PORT_2);
            registry2.rebind(ServerImpl.class.getSimpleName(),s2);
            System.out.println(String.format("Server 2 established on port " + AppConstants.SERVER_PORT_2));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}