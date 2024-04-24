import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.time.LocalTime;

public class MainClock{
    public static void main(String [] args) throws Exception {

        try {
            LocalTime localTime = LocalTime.parse("07:00:00",AppConstants.formatter);
        System.out.println("Local time  : " + AppConstants.formatter.format(localTime));

        //server 1 connection
        Registry registry1 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_1,AppConstants.SERVER_PORT_1);
        ServerIntf s1 = (ServerIntf) registry1.lookup(ServerImpl.class.getSimpleName());
        LocalTime Server_Time_1 = s1.getTime();
        System.out.println("Server 1 connection established");
        System.out.println("Server 1 time : " + AppConstants.formatter.format(Server_Time_1));



        //server 2 connection
        Registry registry2 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_2,AppConstants.SERVER_PORT_2);
        ServerIntf s2 = (ServerIntf) registry2.lookup(ServerImpl.class.getSimpleName());
        LocalTime Server_Time_2 = s2.getTime();
        System.out.println("Server 2 connection established");
        System.out.println("Server 2 time : " + AppConstants.formatter.format(Server_Time_2));

        //server 3 connection
        Registry registry3 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_3,AppConstants.SERVER_PORT_3);
        ServerIntf s3 = (ServerIntf) registry3.lookup(ServerImpl.class.getSimpleName());
        LocalTime Server_Time_3 = s3.getTime();
        System.out.println("Server 3 connection established");
        System.out.println("Server 3 time : " + AppConstants.formatter.format(Server_Time_3));

        //converting time to nano
        long nanoLocalTime = localTime.toNanoOfDay();
        long diffserver1 = Server_Time_1.toNanoOfDay() - nanoLocalTime;
        long diffserver2 = Server_Time_2.toNanoOfDay() - nanoLocalTime;
        long diffserver3 = Server_Time_3.toNanoOfDay() - nanoLocalTime;

        long avgDiff = (diffserver1+diffserver2+diffserver3)/4;
        
        //adjusting time
        localTime = localTime.plusNanos(avgDiff);
        s1.adjustTime(localTime, avgDiff);
        s2.adjustTime(localTime, avgDiff);
        s3.adjustTime(localTime, avgDiff);

        System.out.println("Updated time of the clock");
        System.out.println("Local time  : " + AppConstants.formatter.format(localTime));
        System.out.println("Server 1 time : " + AppConstants.formatter.format(s1.getTime()));
        System.out.println("Server 2 time : " + AppConstants.formatter.format(s2.getTime()));
        System.out.println("Server 3 time : " + AppConstants.formatter.format(s3.getTime()));
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
}