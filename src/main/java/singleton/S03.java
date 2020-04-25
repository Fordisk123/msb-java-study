package singleton;


//DCL (Double Check Lock) 不加volatile有可能拿到半初始化的对象
public class S03 {
    private static S03 INSTANCE;
    public int m;

    private S03() {
        m = 100;
    };

    public static S03 getInstance() {
        if (INSTANCE == null){
            synchronized (S03.class){
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new S03();
                }
            }
        }
        return INSTANCE;
    }


    public static void main(String[] args) throws InterruptedException {
        for(int i =0 ; i < 100000 ; i++){
            new Thread(() -> {
                System.out.println(getInstance().m);
//                if(getInstance().m == 0){
//                    System.out.println("Get a half init obj");
//                }
            } , String.valueOf(i)).start();
        }

        Thread.sleep(10000);
    }


}
