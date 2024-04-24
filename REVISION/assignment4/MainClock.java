import java.rmi.*;
import java.time.LocalTime;
import java.rmi.registry.*;

public class MainClock{
    public static void main(String[] args) {
        try {
            LocalTime localTime = LocalTime.parse("07:00:00",AppConstants.formatter);
            System.out.println("Local time is  : " + AppConstants.formatter.format(localTime));

            Registry registry1 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_1,AppConstants.SERVER_PORT_1);
            ServerIntf s1 = (ServerIntf) registry1.lookup(ServerImpl.class.getSimpleName());
            LocalTime ST1 = s1.getTime();
            System.out.println("SERVER 1 CONNECTION DONE ");
            System.out.println(AppConstants.formatter.format(ST1));

            Registry registry2 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_2,AppConstants.SERVER_PORT_2);
            ServerIntf s2 = (ServerIntf) registry2.lookup(ServerImpl.class.getSimpleName());
            LocalTime ST2 = s2.getTime();
            System.out.println("SERVER 2 CONNECTION DONE ");
            System.out.println(AppConstants.formatter.format(ST2));

            Registry registry3 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_3,AppConstants.SERVER_PORT_3);
            ServerIntf s3 = (ServerIntf) registry3.lookup(ServerImpl.class.getSimpleName());
            LocalTime ST3 = s3.getTime();
            System.out.println("SERVER 3 CONNECTION DONE ");
            System.out.println(AppConstants.formatter.format(ST3));


            long nanoLocal = localTime.toNanoOfDay();
            long timeDiff1 = ST1.toNanoOfDay() - nanoLocal;
            long timeDiff2 = ST2.toNanoOfDay() - nanoLocal;
            long timeDiff3 = ST3.toNanoOfDay() - nanoLocal;
            long avgDiff = (timeDiff1 + timeDiff2 + timeDiff3)/4;

            s1.adjustTime(localTime, avgDiff);
            s2.adjustTime(localTime, avgDiff);
            s3.adjustTime(localTime, avgDiff);
            localTime = localTime.plusNanos(avgDiff);

            System.out.println("localtime : " + AppConstants.formatter.format(localTime));
            System.out.println("server 1 time : " + AppConstants.formatter.format(s1.getTime()));
            System.out.println("server 2 time : " + AppConstants.formatter.format(s2.getTime()));
            System.out.println("server 3 time : " + AppConstants.formatter.format(s3.getTime()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
