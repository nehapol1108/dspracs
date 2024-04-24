import java.rmi.*;
import java.time.LocalTime;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClockOne{
    public static void main(String[] args) {
        try {
            ServerIntf s1 = new ServerImpl(LocalTime.parse("07:00:00",AppConstants.formatter));
            Registry registry1 = LocateRegistry.createRegistry(AppConstants.SERVER_PORT_1);
            registry1.rebind(ServerImpl.class.getSimpleName(),s1);
            System.out.println(String.format("Server 1 established on port " + AppConstants.SERVER_PORT_1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}