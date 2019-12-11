package interview.kotlin.com.application;

import android.app.Application;
import android.util.Log;

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * MyApplication
 * <p>
 * Description
 *
 * @author MaShiZhao
 * @version 1.0
 * <p>
 * Ver 1.0, 2019-10-23, MaShiZhao, Create file
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Application","oncreate");
    }
}
