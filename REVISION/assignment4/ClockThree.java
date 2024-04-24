import java.rmi.*;
import java.time.LocalTime;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClockThree{
    public static void main(String[] args) {
        try {
            ServerIntf s3 = new ServerImpl(LocalTime.parse("07:00:00",AppConstants.formatter));
            Registry registry3 = LocateRegistry.createRegistry(AppConstants.SERVER_PORT_3);
            registry3.rebind(ServerImpl.class.getSimpleName(),s3);
            System.out.println(String.format("Server 3 established on port " + AppConstants.SERVER_PORT_3));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}