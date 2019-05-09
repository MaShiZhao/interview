package interview.msz.com.interview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interview.msz.com.activity.ActivityActivity;
import interview.msz.com.activity.AidlActivity;
import interview.msz.com.activity.Apk;
import interview.msz.com.activity.DataStructureActivity;
import interview.msz.com.activity.DesignPatternActivity;
import interview.msz.com.activity.DrawableActivity;
import interview.msz.com.activity.GCActivity;
import interview.msz.com.activity.HashMapActivity;
import interview.msz.com.activity.HttpActivity;
import interview.msz.com.activity.NounActivity;
import interview.msz.com.activity.OtherActivity;
import interview.msz.com.activity.ReactNativeActivity;
import interview.msz.com.activity.SystemActivity;
import interview.msz.com.activity.VersionActivity;
import interview.msz.com.activity.ViewActivity;
import interview.msz.com.activity.XmlActivity;
import interview.msz.com.aidl.BinderActivity;
import interview.msz.com.count.CountActivity;
import interview.msz.com.optimization.BatteryActivity;
import interview.msz.com.optimization.MemoryOptimizationActivity;
import interview.msz.com.sourcecode.GlideActivity;
import interview.msz.com.sourcecode.OkhttpActivity;
import interview.msz.com.thread.AsyncTaskActivity;
import interview.msz.com.thread.ThreadActivity;
import interview.msz.com.thread.ThreadAndProcessActivity;
import interview.msz.com.thread.ThreadExecutorActivity;
import interview.msz.com.touch.TouchActivity;

public class MainActivity extends AppCompatActivity
{
    public static final String TAG = "MSZ_TAG_MAIN";
    private RecyclerView myRecyclerView;
    private MainAdapter mainAdapter;
    private List<MainBean> data = new ArrayList<>();
    private TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv = (TextView) findViewById(R.id.txv);
        myRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long timestamp = 15130505768L*1000;
        final String format = sdf.format(new Date(timestamp));
        txv.setText(format);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        data.add(new MainBean("线程", ThreadActivity.class));
        data.add(new MainBean("进程和线程区别", ThreadAndProcessActivity.class));
        data.add(new MainBean("线程池", ThreadExecutorActivity.class));
        data.add(new MainBean("名词释义", NounActivity.class));
        data.add(new MainBean("底层架构", SystemActivity.class));
        data.add(new MainBean("AIDL", AidlActivity.class));
        data.add(new MainBean("Binder", BinderActivity.class));
        data.add(new MainBean("内存优化", MemoryOptimizationActivity.class));
        data.add(new MainBean("电量优化", BatteryActivity.class));
        data.add(new MainBean("http", HttpActivity.class));
        data.add(new MainBean("View", ViewActivity.class));
        data.add(new MainBean("XML 解析", XmlActivity.class));
        data.add(new MainBean("GC", GCActivity.class));
        data.add(new MainBean("hash", HashMapActivity.class));
        data.add(new MainBean("touch", TouchActivity.class));
        data.add(new MainBean("AsyncTask", AsyncTaskActivity.class));
        data.add(new MainBean("Version", VersionActivity.class));
        data.add(new MainBean("OkHttp", OkhttpActivity.class));
        data.add(new MainBean("Glide", GlideActivity.class));
        data.add(new MainBean("ReactNative", ReactNativeActivity.class));
        data.add(new MainBean("APK", Apk.class));
        data.add(new MainBean("算法", CountActivity.class));
        data.add(new MainBean("数据机构", DataStructureActivity.class));
        data.add(new MainBean("设计模式", DesignPatternActivity.class));
        data.add(new MainBean("drawable", DrawableActivity.class));
        data.add(new MainBean("生命周期", ActivityActivity.class));
        data.add(new MainBean("随手记", OtherActivity.class));

        mainAdapter = new MainAdapter(MainActivity.this, data);
        myRecyclerView.setAdapter(mainAdapter);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState)
    {
        super.onCreate(savedInstanceState, persistentState);
        Log.d(TAG, "onCreate");
    }


    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d(TAG, "onPause");
    }


    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(TAG, "onStop");
    }


    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
