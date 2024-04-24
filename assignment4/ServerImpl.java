import java.rmi.*;
import java.rmi.server.*;
import java.time.LocalTime;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf{
    private LocalTime currTime;

    public ServerImpl(LocalTime currTime) throws RemoteException{
        this.currTime = currTime;
    }

    public LocalTime getTime() throws RemoteException{
        return currTime;
    }

    public void adjustTime(LocalTime localTime,long timeDiff) throws RemoteException{
        this.currTime = localTime.plusNanos(timeDiff);
    }

}