import ReverseModule.*;

public class ReverseImpl extends ReversePOA{
    public ReverseImpl() {
        super();
        System.out.println("Created object");
    }
    public String reverse_string(String s){
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        return "Reverse string  " + sb;
    }
}
