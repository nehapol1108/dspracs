import ReverseModule.*;


public class ReverseImpl extends ReversePOA {

    public ReverseImpl(){
        super() ;
        System.out.println("Remote Object Creation");
    }
    
    public String reverse_string(String s){
        StringBuffer str = new StringBuffer(s);
        str.reverse();
        return "Server Sends "+ str ;
    }
}
