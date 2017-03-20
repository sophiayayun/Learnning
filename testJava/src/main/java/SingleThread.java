/**
 * Created by dengyayun on 17/3/20.
 */
public class SingleThread implements Runnable {

    public String name;

    public SingleThread(String name) {
        this.name = name;
    }

    public void run(){
        for(int i = 0; i<5;i++){
            for (long k=0; k<1000000; k++) {
                System.out.println(this.name + " : " + i);
            }
        }

    }

    public static void main(String[] args) {
        SingleThread s1 = new SingleThread("李四");
        SingleThread s2 = new SingleThread("阿三");
        SingleThread s3 = new SingleThread("王五");

        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        Thread t3 = new Thread(s3);

        t1.start();
        t2.start();
        t3.start();

//        t1.run();
//        t2.run();
//        t3.run();
    }
}
