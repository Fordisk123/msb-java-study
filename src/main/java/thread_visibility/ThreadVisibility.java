package thread_visibility;

public class ThreadVisibility {
//    private static /*volatile*/ boolean flag = true;
    private static volatile boolean flag = true;


    public static void main(String[] args) throws InterruptedException{
        new Thread(() -> {
            while (flag){
                //do smoething
            }
            System.out.println("end");
        }, "server").start();

        Thread.sleep(1000);

        flag = false;

    }
}
