
import java.util.*;

public class TokenRing{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes you want in the ring");
        int n = sc.nextInt();
        System.out.println("Ring formed is as below : ");
        for(int i=0;i<n;i++){
            System.out.println(i + " ");
        }
        System.out.println("0");
        int token = 0;
        int choice = 0;
        try{    
            do{
                System.out.println("Enter the sender");
                int sender = sc.nextInt();
    
                System.out.println("Enter the reciever");
                int reciever = sc.nextInt();
    
                System.out.println("Enter the data to be sent");
                int data = sc.nextInt();
    
                System.out.println("Token passing");

                for(int i=token;i!=sender;i=(i+1)%n){
                    System.out.println(" "+ i + "->");
                }

                System.out.println(" "+ sender);
                System.out.println("sender " + sender + " sending data "+ data );

                for(int i=sender;i!=reciever ; i = (i+1)%n){
                    System.out.println("Data" +data+ " forwarded by " + i);
                }

                System.out.println("reciever " +  reciever + " recieved the data "+ data);
                token = sender;
                System.out.println("Do you want to send data ? press 1 else 0 : ");
                choice = sc.nextInt();
    
            }while(choice==1);

        }catch(Exception e){
            System.out.println(e);
        }
       
    }
}


//for running
// javac TokenRing.java
// java TokenRing