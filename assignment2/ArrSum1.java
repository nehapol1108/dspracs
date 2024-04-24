import mpi.* ;

public class ArrSum1 {
    public static void main(String[] args){
        try {
            MPI.Init(args,null);
            int rank = MPI.COMM_WORLD.Rank();
            int size = MPI.COMM_WORLD.Size();
            int root =0 , unitSize = 5 ;
            int total = unitSize* size;
            int send[] = new int[total];
            int intm[] = new int[unitSize];
            int recv[] = new int[size];
            if(rank==root){
                for(int i=0;i<total;i++){
                    send[i]=i ;
                }
            }
            MPI.COMM_WORLD.Scatter(send,0,unitSize,MPI.INT,intm,0,unitSize,MPI.INT,root);
            for(int i=1;i<unitSize;i++){
                intm[0]= intm[i];
            }
            MPI.COMM_WORLD.Scatter(intm,0,1,MPI.INT,recv,0,unitSize,MPI.INT,root);
            if(root==rank){
                int ans =0 ;
                for(int i=0;i<size;i++){
                    
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
