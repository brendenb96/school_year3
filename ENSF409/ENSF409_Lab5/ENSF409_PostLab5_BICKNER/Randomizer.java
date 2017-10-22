
public class Randomizer implements Runnable {

RandomC runnable_class;

    public void run(){
        try {
            runnable_class.add();
			Thread.sleep(1);
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    }
    Randomizer(RandomC resource){
		this.runnable_class = resource;
	}
    public static void main(String[] args){
        RandomC r1 = new RandomC();
        
        Thread t1 = new Thread(new Randomizer(r1));
        Thread t2 = new Thread(new Randomizer(r1));
        Thread t3 = new Thread(new Randomizer(r1));
        Thread t4 = new Thread(new Randomizer(r1));
        Thread t5 = new Thread(new Randomizer(r1));
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        boolean keepRunning = true;

        while(keepRunning){
            keepRunning = t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive() || t5.isAlive();
        };
        System.out.println("The sum of the random numbers is: "+r1.sum);
    }
}