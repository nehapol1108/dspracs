import java.time.LocalTime;
import java.rmi.*;
import java.rmi.server.*;

public interface ServerIntf extends Remote{
    LocalTime getTime() throws RemoteException;
    void adjustTime(LocalTime localTime,long timeDiff) throws RemoteException;

}