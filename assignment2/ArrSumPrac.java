import mpi.*;
import java.util.*;

public class ArrSumPrac{
    public static void main(String [] args) throws Exception{
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        
        int unitsize = 5, root=0;
        int total_size = size*unitsize;
        int send_buffer[] = new int[total_size];
        int recieve_buffer[] = new int[unitsize];
        int new_recieve_buffer[] = new int[size];
        if(root==rank){
            for(int i=0;i<total_size;i++){
                System.out.println("Element " + i + " added in sending buffer");
                send_buffer[i] = i;
            }
        }

        MPI.COMM_WORLD.Scatter(send_buffer,0,unitsize,MPI.INT,recieve_buffer,0,unitsize,MPI.INT,root);


        for(int i=1;i<unitsize;i++){
            recieve_buffer[0] += recieve_buffer[i];
        }

        System.out.println("Intermediate process " + rank + " contains sum "+ recieve_buffer[0]);
        MPI.COMM_WORLD.Gather(recieve_buffer,0,1,MPI.INT,new_recieve_buffer,0,1,MPI.INT,root);

        if(root==rank){
            int total_sum=0;
            for(int i=0;i<size;i++){
                total_sum += new_recieve_buffer[i];
            }
            System.out.println("Total sum : " + total_sum);
        }

        MPI.Finalize();
    }
}