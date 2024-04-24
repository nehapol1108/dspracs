import java.time.LocalTime;
import java.rmi.*;

public interface ServerIntf extends Remote{
    public LocalTime getTime() throws RemoteException;
    public void adjustTime(LocalTime localTime,long timeDiff) throws RemoteException;
}