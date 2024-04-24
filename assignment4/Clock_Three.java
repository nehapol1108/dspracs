import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.time.LocalTime;

public class Clock_Three{
    public static void main(String [] args){
        ServerIntf sc = new ServerImpl(LocalTime.parse("07:00:00",AppConstants.formatter));
        Registry registry3 = LocateRegistry.createRegistry(AppConstants.SERVER_PORT_3);
        registry3.rebind(ServerImpl.class.getSimpleName(),sc);
        System.out.println(String.format("Server 3 started on port : " + AppConstants.SERVER_PORT_3));
    }
}