package disorder;

public class Disorder {
    private static int x =0 , y = 0;
    private static int a = 0 , b = 0;
//    private volatile static int x =0 , y = 0;
//    private volatile static int a = 0 , b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for(;;){
            i++;
            x = 0 ; y = 0;
            a = 0; b = 0;
            Thread one = new Thread(new Runnable() {
                public void run() {
                    a = 1;
                    x = b;
                }
            });

            Thread other = new Thread(new Runnable() {
                public void run() {
                    b = 1;
                    y = a;
                }
            });

            one.start();other.start();
            one.join();other.join();

            if(x == 0 && y == 0){
                System.out.println(String.format("第%d次 出现 x = %d , y = %d" , i , x , y));
                break;
            }

        }

    }
}













//第1539253次 出现 x = 0 , y = 0
