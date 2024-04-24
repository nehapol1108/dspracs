import mpi.*;

public class ArrMul {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);
        int size = MPI.COMM_WORLD.Size();
        int rank = MPI.COMM_WORLD.Rank();
        int unitsize = 5;
        int root=0;
        int totalSize = unitsize*size;
        int send_buffer[] = new int[totalSize];
        int rb[] = new int[unitsize];
        int nrb[] = new int[size];
        if(root==rank){
            for(int i=0;i<totalSize;i++){
                System.out.println(i);
                send_buffer[i] = i;
            }
        }
        MPI.COMM_WORLD.Scatter(send_buffer,0,unitsize,MPI.INT,rb,0,unitsize,MPI.INT,root);
        for(int i=1;i<unitsize;i++){
            rb[0]*=rb[i];
        }
        System.out.println(rank + " result " + rb[0]);
        MPI.COMM_WORLD.Gather(rb,0,1,MPI.INT,nrb,0,1,MPI.INT,root);
        if(root==rank){
            int total = 0;
            for(int i=0;i<size;i++){
                total*=nrb[i];
            }
            System.out.println(total);
        }

        MPI.Finalize();
    }
}


// export MPJ_HOME=path till mpj
//export PATH= $MPJ_HOME/bin:$PATH
// javac -cp $MPJ_HOME/lib/mpj.jar ArrMul.java
// $MPJ_HOME/bin/mpjrun.sh -np 2 ArrMul