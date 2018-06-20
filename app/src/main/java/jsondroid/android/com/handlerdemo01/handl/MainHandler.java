package jsondroid.android.com.handlerdemo01.handl;

import android.os.Handler;
import android.os.Looper;

/**
 * 主线程处理工具
 * 用于异步切换线程
 */
public class MainHandler {

    private final Handler mHandler;


    private MainHandler() {
        /**
         * Looper.getMainLooper() 表示在主线程下运行
         *
         * Looper.myLooper() 表示在当前线程
         *
         * */
        mHandler = new Handler(Looper.getMainLooper());
    }

    private static class HolderClass {
        private static final MainHandler instance = new MainHandler();
    }

    public static MainHandler getInstance() {
        return HolderClass.instance;
    }

    /**
     * 在主线程执行
     *
     * @param runnable
     */
    public void runInMainThread(Runnable runnable) {
        mHandler.post(runnable);
    }
}
