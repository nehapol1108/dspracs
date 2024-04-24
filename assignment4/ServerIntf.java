import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;

public interface ServerIntf extends Remote{
    LocalTime getTime() throws RemoteException;
    void adjustTime(LocalTime localTime,long timeDiff) throws RemoteException;
}


//TERMINAL 1
// javac *.java
//rmiregistry

//terminal 2
//java Clock_One

//terminal 3
//java Clock_Two

//terminal 4
//java Clock_Three

//terminal 5
//java MainClock