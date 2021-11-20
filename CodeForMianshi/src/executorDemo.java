import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 9953
 * @date 2021/11/10 - 12:23
 */

public class executorDemo {
    public static void main(String[] args) {
    /*    liftOff lo=new liftOff();
        liftOff lo1=new liftOff();

        Thread t=new Thread(lo);
        Thread t1=new Thread(lo1);

        t.start();
        t1.start();*/

        ExecutorService exec= Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            exec.execute(new liftOff());
        }
        exec.shutdown();

    }
}

class liftOff implements Runnable{
    protected int countDown=10;
    private static int taskCount=0;
    private final int id=taskCount++;

    public liftOff(){}

    public liftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"liftoff")+"), ";
    }

    @Override
    public void run() {
        while(countDown-- >0){
            System.out.println(status());
            Thread.yield();
        }
    }
}
