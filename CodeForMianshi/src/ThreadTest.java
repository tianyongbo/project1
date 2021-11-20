/**
 * @author 9953
 * @date 2021/11/8 - 20:32
 */
public class ThreadTest {
    public static void main(String[] args) {
        ttest tt1 = new ttest();
        tesst2 tt2 = new tesst2();

        Thread t1 = new Thread(tt1);
        Thread t2 = new Thread(tt2);

        System.out.println(Thread.currentThread().getName());
        
        
        t1.start();
        t2.start();


    }
}

class ttest implements Runnable {

    @Override
    public void run() {
        while (true){

            show();
            System.out.println(Thread.currentThread().getName());
        }

    }

    private void show() {
        System.out.println("giao1");
    }
}

class tesst2 implements Runnable {

    @Override
    public void run() {
        while (true){

            show();
            System.out.println(Thread.currentThread().getName());
        }

    }

    private void show() {
        System.out.println("giao2");
    }
}
