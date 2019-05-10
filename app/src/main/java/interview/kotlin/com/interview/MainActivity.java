package interview.kotlin.com.interview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import interview.kotlin.com.aidl.BinderActivity;
import interview.kotlin.com.count.CountActivity;
import interview.kotlin.com.optimization.MemoryOptimizationActivity;
import interview.kotlin.com.sourcecode.OkhttpActivity;
import interview.kotlin.com.thread.AsyncTaskActivity;
import interview.kotlin.com.thread.ThreadActivity;
import interview.kotlin.com.thread.ThreadAndProcessActivity;
import interview.kotlin.com.thread.ThreadExecutorActivity;
import interview.kotlin.com.touch.TouchActivity;
import interview.kotlin.com.activity.ActivityActivity;
import interview.kotlin.com.activity.AidlActivity;
import interview.kotlin.com.activity.Apk;
import interview.kotlin.com.activity.DataStructureActivity;
import interview.kotlin.com.activity.DesignPatternActivity;
import interview.kotlin.com.activity.DrawableActivity;
import interview.kotlin.com.activity.GCActivity;
import interview.kotlin.com.activity.HashMapActivity;
import interview.kotlin.com.activity.HttpActivity;
import interview.kotlin.com.activity.NounActivity;
import interview.kotlin.com.activity.OtherActivity;
import interview.kotlin.com.activity.ReactNativeActivity;
import interview.kotlin.com.activity.SystemActivity;
import interview.kotlin.com.activity.VersionActivity;
import interview.kotlin.com.activity.ViewActivity;
import interview.kotlin.com.activity.XmlActivity;
import interview.kotlin.com.optimization.BatteryActivity;
import interview.kotlin.com.sourcecode.GlideActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView myRecyclerView;
    private MainAdapter mainAdapter;
    private List<MainBean> data = new ArrayList<>();
    private TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
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
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(mainAdapter);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }


}
