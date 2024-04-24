
import java.util.*;
public class TokenRing {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the ring");
        int n = sc.nextInt();
        System.out.println("RING IS AS FOLLOWS : ");
        for(int i=0;i<n;i++){
            System.out.println(i);
        }
        System.out.println("0");
        int token=0;
        int choice = 0;

        try {
            do{
                System.out.println("Enter sender");
                int sender = sc.nextInt();

                System.out.println("Enter reciever");
                int reciever = sc.nextInt();

                System.out.println("Enter data");
                int data = sc.nextInt();

                System.out.println("Token passing");
                for(int i=token;i!=sender;i=(i+1)%n){
                    System.out.println("Token passing from " + i + "->" + (i+1));
                }
                System.out.println("Token is with " + reciever);

                System.out.println("sender passing data");
                for(int i=sender;i!=reciever;i=(i+1)%n){
                    System.out.println("sender passing data  "+ data +" from " + i + "->" + (i+1));
                }
                System.out.println("Recieved data by " + reciever);
                token = sender;
                System.out.println("press 1 to continue and 0 to exit");
                choice  = sc.nextInt();

            }while(choice==1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
