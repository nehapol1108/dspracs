import mpi.*;
import java.util.*;

public class ArrMul{
    public static void main(String [] args){
        MPI.Init(args);

        int size = MPI.COMM_WORLD.Size();
        int rank = MPI.COMM_WORLD.Rank();

        int unitsize = 5;
        int total_size = size*unitsize;
        int root = 0;
        int send_buffer[] = new int[total_size];
        int recieve_buffer[] = new int[unitsize];
        int new_recieve_buffer[] = new int[size];

        Scanner sc = new Scanner(System.in);
        if(root==rank){
            for(int i=0;i<total_size;i++){
                send_buffer[i] = i+1;
            }
            System.out.println("Following is the Input array : ");
            for(int i=0;i<total_size;i++){
                System.out.println(send_buffer[i]);
            }
        }

        MPI.COMM_WORLD.Scatter(send_buffer,0,unitsize,MPI.INT,recieve_buffer,0,unitsize,MPI.INT,root);

        for(int i=1;i<unitsize;i++){
            recieve_buffer[0] *= recieve_buffer[i];
        }
        MPI.COMM_WORLD.Gather(recieve_buffer,0,1,MPI.INT,new_recieve_buffer,0,1,MPI.INT,root);

        System.out.println("Intermediate process " + rank + " result : "+recieve_buffer[0]);
        if(root==rank){
            int total_mul = 1;
            for(int i=0;i<size;i++){
                total_mul *= new_recieve_buffer[i];
            }
            System.out.println("Total multiplication = " + total_mul);
        }
        MPI.Finalize();
    }
}

//export MPJ_HOME=path till mpj
// export PATH=$MPJ_HOME/bin:$PATH
// javac -cp $MPJ_HOME/lib/mpj.jar ArrMul.java
// $MPJ_HOME/bin/mpjrun.sh -np 2 ArrMul

























//export MPJ_HOME=path till mpj
//export PATH=$MPJ_HOME/bin:$PATH
//javac -cp $MPJ_HOME/lib/mpj.jar Arrmul.java
//$MPJ_HOME/bin/mpjrun.sh -np 2 Arrmul




// export MPJ_HOME=path till mpj
//export PATH= $MPJ_HOME/bin:$PATH
// javac -cp $MPJ_HOME/lib/mpj.jar Arrmul.java
//$MPJ_HOME/bin/mpjrun.sh -np 2 Arrmul