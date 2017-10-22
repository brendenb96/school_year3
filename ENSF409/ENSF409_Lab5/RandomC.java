import java.util.Random;
public class RandomC {

    volatile int sum;

    public RandomC(){
        sum = 0;
    }
    public synchronized void add(){
        Random r = new Random();
        int rand_num = r.nextInt((100 - 1) + 1) + 1;
        System.out.println("A random number is: " + rand_num);
        sum += rand_num;
    }

}