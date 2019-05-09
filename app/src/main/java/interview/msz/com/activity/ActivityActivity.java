package interview.msz.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.msz.com.baseActivity.BaseActivity;

/**
 * Created by MaShiZhao on 2018/5/15.
 * 生命周期
 */
public class ActivityActivity extends BaseActivity
{



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("生命周期");

        String contentString = "activity中 onResume  执行完 才会显示出画面 所以前一页面的onStop才执行 \n" +
                "同理返回上一个页面时 只有当前一个页面显示出画面 后一个页面才执行stop \n\n" +
                ".002  interview.msz.com.thread.ThreadActivity onStart\n" +
                ".006  interview.msz.com.thread.ThreadActivity onResume\n" +
                ":17.672  interview.msz.com.thread.ThreadActivity onPause\n" +
                ":17.728  interview.msz.com.baseActivity.CodeActivity onStart\n" +
                ":17.732  interview.msz.com.baseActivity.CodeActivity  onResume\n" +
                ":18.318  interview.msz.com.thread.ThreadActivity onStop\n" +
                ":43.931  interview.msz.com.baseActivity.CodeActivity onPause\n" +
                ":43.954  interview.msz.com.thread.ThreadActivity onRestart\n" +
                ":43.955  interview.msz.com.thread.ThreadActivity onStart\n" +
                ":43.956  interview.msz.com.thread.ThreadActivity onResume\n" +
                ":44.435  interview.msz.com.baseActivity.CodeActivity onStop\n" +
                ":44.436  interview.msz.com.baseActivity.CodeActivity onDestroy\n" +
                "\n\n\n" +
                "service" +
                "onCreat()\t创建服务\n" +
                "onStartCommand()\t开始服务\n" +
                "onDestroy()\t销毁服务\n" +
                "onBind()\t绑定服务\n" +
                "onUnbind()\t解绑服务\n\n" +
                "1.在整个生命周期内，只有startCommand()能被多次调用。其他方法只能被调用一次。（即只能绑定和解绑一次。）\n" +
                "2.绑定后没有解绑，无法使用stopService()将其停止。\n" +
                "3.如果已经onCreate()，那么startService()将只调用startCommand()。\n" +
                "4.如果是以bindService开启，那么使用unbindService时就会自动调用onDestroy销毁。\n" +
                "5.service在启动并且bind的情况下，如果在没有解绑的前提下使用stopService是无法停止服务的\n" +
                "6.startService开启的Service，调用者退出后Service仍然存在； \n" +
                "BindService开启的Service，调用者退出后，Service随着调用者销毁。" ;


        String contentString2 = "1. dialog 显示不会执行onPause 界面可见所以不执行 \n" +
                "2. 重用activity 执行 onNewIntent \n "+
                "3. android:configChanges属性，一般认为有以下几点：\n" +
                "\r\r1、不设置Activity的android:configChanges时，切屏会重新调用各个生命周期，切横屏时会执行一次，切竖屏时会执行两次\n" +
                "\n" +
                "\r\r2、设置Activity的android:configChanges=\"orientation\"时，切屏还是会重新调用各个生命周期，切横、竖屏时只会执行一次\n" +
                "\n" +
                "\r\r3、设置Activity的android:configChanges=\"orientation|keyboardHidden|screenSize\"时，切屏不会重新调用各个生命周期，只会执行onConfigurationChanged方法\n";

        setContentTextView(contentString+"\n\n\n"+contentString2);


    }
}
