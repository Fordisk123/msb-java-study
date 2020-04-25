package singleton;

public class S02 {
    private static S02 INSTANCE;

    private S02() {};

    public static S02 getInstance() {
        if (INSTANCE == null){
            synchronized (S02.class){
                try{
                    Thread.sleep(1);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                INSTANCE = new S02();
            }
        }
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
