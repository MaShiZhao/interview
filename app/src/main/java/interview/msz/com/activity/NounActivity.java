package interview.msz.com.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import interview.msz.com.baseActivity.BaseActivity;

/**
 * Created by MaShiZhao on 2018/3/26.
 */
public class NounActivity extends BaseActivity
{
    private TextView textView;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        string = "ANR application not responding \n " +
                "在Android中，活动管理器和窗口管理器这两个系统服务负责监视应用程序的响应，当用户操作的在5s内应用程序没能做出反应，BroadcastReceiver在10秒内没有执行完毕，就会出现应用程序无响应对话框，这既是ANR。\n"+
                "IPC inter proscess commnication \n " +
                " IPC是 Inter-Proscess Communication的缩写,含义为进程间的通讯或者跨进程通讯,是指两个进程之间进行数据交换的过程。。\n"+
                "onSaveInstanceState的调用遵循一个重要原则，即当系统“未经你许可”时销毁了你的activity，" +
                "则onSaveInstanceState会被系统调用，这是系统的责任，因为它必须要提供一个机会让你保存你的数据，" +
                "主动finish activity 时，不会调用该方法。另外，onSaveInstanceState()会在onPause()或onStop()之后执行，" +
                "onRestoreInstanceState()会在onStart()和onResume()之间执行。" +
                "onPause –>onSaveInstanceState–>onStop–>onDestory–>" +
                "onCreate(切换屏幕后重新创建Activity时调用的onCreate方法)" +
                "–>onStart–>onRestoryInstanceState–>onResume。\n\n\n"  +
                "AIDL    Android Interface Define Language \n" +
                "Eden 缅甸园 \n"+
                "survivor 幸存者 \n"+
                "Young generation  old generation  permanent generation\n"+
                "aapt the Android Asset Packaing Tool\n"

                 ;


        setTitle("名词");
        setContentTextView(string);

     }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        Log.d("TAG","onSaveInstanceState");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("TAG","pause");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("TAG","onRestoreInstanceState ");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("TAG","resume");
    }
}
