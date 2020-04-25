package singleton;

public class S01 {
    private static final S01 INSTANCE = new S01();

    private S01() {};

    public static S01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i =0 ; i < 1000 ; i++){
            new Thread(() -> {
                System.out.println(getInstance().hashCode());
            } , String.valueOf(i)).start();
        }

        Thread.sleep(10000);
    }
}
