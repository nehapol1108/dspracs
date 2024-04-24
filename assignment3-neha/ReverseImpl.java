import ReverseModule.*;

public class ReverseImpl extends ReversePOA {
    public ReverseImpl(){
        super();
        System.out.println("Object created");
    }
    public String reverse_string(String str){
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        return "Reverse string : "+ sb;
    }
}