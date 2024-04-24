import java.util.*;

public class Bully {
    int max_processes;
    int coordinator;
    boolean processes[];

    public Bully(int max){
        max_processes=max;
        processes = new boolean[max_processes];
        coordinator = max;
        System.out.println("Creating processes.........");
        for(int i=0;i<max;i++){
            processes[i]=true;
            System.out.println("Process P"+ (i+1) +"  is created");
        }
        System.out.println("Process P" + coordinator + " is the Coordinator");
    } 

    public void displayProcess(){
        for(int i=0;i<max_processes;i++){
            if(processes[i]){
                System.out.println("Process P"+(i+1)+"  is up");
            }else{
                System.out.println("Process P"+(i+1)+"  is down");
            }
        }
        System.out.println("Process P" + coordinator + "is the Coordinator");
    }

    public void upProcess(int process_id){
        if(!processes[process_id-1]){
            processes[process_id-1]=true;
            System.out.println("Process P" + process_id + "is now up");
        }else{
            System.out.println("Process P" + process_id + "is already up");
        }
    }

    public void downProcess(int process_id){
        if(!processes[process_id-1]){ 
            System.out.println("Process P" + process_id + "is already down");
        }else{
            processes[process_id-1]=false;
            System.out.println("Process P" + process_id + "is now down");
        }
    }

    public void runElection(int process_id){
        coordinator = process_id;
        boolean keepGoing = true;
        for(int i=process_id; i<max_processes && keepGoing ;i++){
            System.out.println("Process P" + process_id + " is sending election msg to process P" + (i+1));

            if(processes[i]){
                keepGoing=false;
                runElection(i+1);
            }
        }
    }

    public static void main(String args[]){
        int max_processes = 0, process_id=0;
        Bully bully = null;
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Enter your choice");
            System.out.println("Enter 1 for Creating processes");
            System.out.println("Enter 2 for Displaying processes");
            System.out.println("Enter 3 for up a process");
            System.out.println("Enter 4 for down a process");
            System.out.println("Enter 5 for Election Run");
            System.out.println("Enter 6 for Exit");
            choice = sc.nextInt();
            switch(choice){
        
                case 1:
                    System.out.println("Enter number of processes to add");
                    max_processes = sc.nextInt();
                    bully = new Bully(max_processes);
                    break;
                case 2:
                    bully.displayProcess();
                    break;
                case 3:
                    System.out.println("Enter number of process id to up");
                    process_id = sc.nextInt();
                    bully.upProcess(process_id);
                    break;
                case 4:
                    System.out.println("Enter number of process id to down");
                    process_id = sc.nextInt();
                    bully.downProcess(process_id);
                    break;
                case 5:
                    System.out.println("Enter number of process id which will initiate the election");
                    process_id = sc.nextInt();
                    bully.runElection(process_id);
                    bully.displayProcess();
                    break;
                case 6:
                    System.exit(0);
                    break;   
                default:
                    System.out.println("Error in choosing . Try again");
                    break;
    
            }
        }
        
    }
}
