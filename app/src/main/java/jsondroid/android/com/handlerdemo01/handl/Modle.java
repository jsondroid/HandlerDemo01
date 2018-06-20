package jsondroid.android.com.handlerdemo01.handl;

/**
 * Created by wenbaohe on 2018/6/19.
 */

public class Modle {

    private static Imodle imodle;

    public Modle(Imodle imodle) {
        this.imodle = imodle;
    }

    private static class MyThread implements Runnable {
        private int count;

        public MyThread(int count) {
            this.count = count;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /**将结果切换到主线程中*/
            MainHandler.getInstance().runInMainThread(new Runnable() {
                @Override
                public void run() {
                    imodle.callback(count);
                }
            });
        }
    }



    public void handl(int count) {
        new Thread(new MyThread(count)).start();
    }


}
