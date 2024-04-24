import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;

public class Clock_Three{
    public static void main(String[] args){
        try {
            ServerIntf s3 = new ServerImpl(LocalTime.parse("06:55:00" , AppConstants.formatter));
            Registry registry3 = LocateRegistry.createRegistry(AppConstants.SERVER_PORT_3);
            registry3.rebind(ServerImpl.class.getSimpleName(),s3);
            System.out.println(String.format("Server 3 started on port  : " + (AppConstants.SERVER_PORT_3)));
        } catch (Exception e) {
           System.out.println(e);
        }
        
        
    }
}