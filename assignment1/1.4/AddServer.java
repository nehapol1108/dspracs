import java.rmi.*;

public class AddServer{
    public static void main(String args[]){
        try {
            AddServerImpl addServerImpl = new AddServerImpl();
            Naming.rebind("AddServer",addServerImpl);
            System.out.println("Server started");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

//in first terminal compile the java code
// javac *.java
// rmic AddServerImpl

// 2nd terminal
//rmiregistry

//in second terminal
//java AddServer

//in third terminal
//java AddClient