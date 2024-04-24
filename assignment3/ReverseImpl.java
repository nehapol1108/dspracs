import ReverseModule.*;

public class ReverseImpl extends ReversePOA{
    public ReverseImpl(){
        super();
        System.out.println("Remote Object instantiated");
    }

    public String reverse_string(String s){
        StringBuffer str = new StringBuffer(s);
        str.reverse();
        return "Server sends" + str;
    }
}

// idlj -fall ReverseModule.idl
// javac *.java ReverseModule/*.java
// orbd -ORBInitialPort 1056&
// java ReverseServer -ORBInitialPort 1056& 

//terminal 2
// java ReverseClient -ORBInitialPort 1056 -ORBInitialHost localhost


