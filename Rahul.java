import java.util.*;
class Philosopher implements Runnable {
   
   private Object leftFork;
    private Object rightFork;
 
    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }
   
    private void doAction(String action) throws InterruptedException {
        System.out.println(
          Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 10000)));
    }



 
    @Override
    public void run() {
        try {
            while (true) {
                 
                // thinking
                doAction( ": Thinking"+"\n    O   \n"+
                                       "   /|\\ \n"+
                                       "   /|\\ \n");
                 
   

                synchronized (leftFork) {
                  doAction( ": Picked up left fork"+"\n      #  \n"+
                                                    "    O |  \n"+
                                                      "   /|\\| \n"+
                                                     "   /|\\ \n");
                    
                    synchronized (rightFork) {
                        // eating
                        doAction( ": Picked up right fork-eating"+"\n  #   #  \n"+
                                                    "  | O |  \n"+
                                                      "  |/|\\| \n"+
                                                     "   /|\\ \n"+
                                                       "  TASTY :)"           );
                        
                        doAction( ": Put down right fork"+"\n      #  \n"+
                                                    "    O |  \n"+
                                                      "   /|\\| \n"+
                                                     "   /|\\ \n"); 
                        
                    }
                     
                    // Back to thinking
                    doAction( ": Put down left fork .Back to Thiniking"+"\n    O   \n"+
                                       "   /|\\ \n"+
                                       "   /|\\ \n");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
 class Rahul {
 
    public static void main(String[] args) throws Exception {
     
         
        String h = "                           Dining Philosophers problem!";
        System.err.println(h);
        System.out.println("\n");   
        System.out.println("enter numbers of philosophers");
      Scanner obj=new Scanner(System.in);
      int n=obj.nextInt();

         Philosopher[] philosophers = new Philosopher[n];
        Object[] forks = new Object[philosophers.length];
 
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }
 
        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];
 
            if (i == philosophers.length - 1) {
                 
                // The last philosopher picks up the right fork first
                philosophers[i] = new Philosopher(rightFork, leftFork); 
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }
             
            Thread t 
              = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}
