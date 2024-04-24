import java.rmi.*;

public class AddServer{
    public static void main(String args[]){
        try{
            AddServerImpl addServerImpl = new AddServerImpl();
            Naming.rebind("Server",addServerImpl);
            System.out.println("Server running");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}