package interview.kotlin.com.optimization;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.baseActivity.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/10.
 */
public class MemoryOptimizationActivity extends BaseActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("内存优化");

        String contentS0 ="内存原理" +
                "\n\n\n" +
                "java的内存分为堆内存和栈内存\n" +
                "栈内存stack 是指程序进入一个方法时，会为这个方法单独分配一块私属存储空间，" +
                "用于存储这个方法内部的局部变量，当这个方法结束时，分配给这个方法的栈会释放" +
                "，这个栈中的变量也将随之释放。" +
                "LIFO 不是final修饰的方法，该方法中基本变量( int, short, long, byte, float, double, boolean, char)和对象句柄 \n" +
                "注意：并没有String基本类型(String池)、在栈内存的数据的大小及生存周期是必须确定的、其优点是寄存速度快、栈数据可以共享、缺点是数据固定、不够灵活。" +
                "\n" +
                "\n" +
                "堆heap 是与栈作用不同的内存，一般用于存放不放在当前方法栈中的那些数据，" +
                "例如，使用new创建的对象都放在堆里，所以，它不会随方法的结束而消失。" +
                "方法中的局部变量使用final修饰后，放在堆中，而不是栈中。\n" +
                "堆内存用来存放所有new 创建的对象和 数组的数据和final修饰的方法\n\n\n";
        String contentS = " 1. 单例 context \n" +
                "2. 静态变量 activity fragment 的使用 \n " +
                "3. 非静态内部类导致内存泄露\n  " +
                "4. 未取消注册或回调导致内存泄露\n  广播 " +
                "5. 涉及异步 线程 属性动画 Timer和TimerTask 等需要取消 \n" +
                "6. 资源未关闭或释放导致内存泄露  IO、File流或者Sqlite、Cursor \n" +
                "7. WebView  \n" +
                "8. 集合中的对象未清理造成内存泄露  \n";
        String contentS2 = " 单例导致内存泄露\n" +
                "单例模式在Android开发中会经常用到，但是如果使用不当就会导致内存泄露。因为单例的静态特性使得它的生命周期同应用的生命周期一样长，如果一个对象已经没有用处了，但是单例还持有它的引用，那么在整个应用程序的生命周期它都不能正常被回收，从而导致内存泄露。\n" +
                "\n" +
                "public class AppSettings {\n" +
                "\n" +
                "    private static AppSettings sInstance;\n" +
                "    private Context mContext;\n" +
                "\n" +
                "    private AppSettings(Context context) {\n" +
                "        this.mContext = context;\n" +
                "    }\n" +
                "\n" +
                "    public static AppSettings getInstance(Context context) {\n" +
                "        if (sInstance == null) {\n" +
                "            sInstance = new AppSettings(context);\n" +
                "        }\n" +
                "        return sInstance;\n" +
                "    }\n" +
                "}\n" +
                "像上面代码中这样的单例，如果我们在调用getInstance(Context context)方法的时候传入的context参数是Activity、Service等上下文，就会导致内存泄露。\n" +
                "\n" +
                "以Activity为例，当我们启动一个Activity，并调用getInstance(Context context)方法去获取AppSettings的单例，传入Activity.this作为context，这样AppSettings类的单例sInstance就持有了Activity的引用，当我们退出Activity时，该Activity就没有用了，但是因为sIntance作为静态单例（在应用程序的整个生命周期中存在）会继续持有这个Activity的引用，导致这个Activity对象无法被回收释放，这就造成了内存泄露。\n" +
                "\n" +
                "为了避免这样单例导致内存泄露，我们可以将context参数改为全局的上下文：\n" +
                "\n" +
                "private AppSettings(Context context) {\n" +
                "    this.mContext = context.getApplicationContext();\n" +
                "}\n" +
                "全局的上下文Application Context就是应用程序的上下文，和单例的生命周期一样长，这样就避免了内存泄漏。\n" +
                "\n" +
                "单例模式对应应用程序的生命周期，所以我们在构造单例的时候尽量避免使用Activity的上下文，而是使用Application的上下文。\n" +
                "\n" +
                "静态变量导致内存泄露\n" +
                "静态变量存储在方法区，它的生命周期从类加载开始，到整个进程结束。一旦静态变量初始化后，它所持有的引用只有等到进程结束才会释放。\n" +
                "\n" +
                "比如下面这样的情况，在Activity中为了避免重复的创建info，将sInfo作为静态变量：\n" +
                "\n" +
                "public class MainActivity extends AppCompatActivity {\n" +
                "\n" +
                "    private static Info sInfo;\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        if (sInfo != null) {\n" +
                "            sInfo = new Info(this);\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "class Info {\n" +
                "    public Info(Activity activity) {\n" +
                "    }\n" +
                "}\n" +
                "Info作为Activity的静态成员，并且持有Activity的引用，但是sInfo作为静态变量，生命周期肯定比Activity长。所以当Activity退出后，sInfo仍然引用了Activity，Activity不能被回收，这就导致了内存泄露。\n" +
                "\n" +
                "在Android开发中，静态持有很多时候都有可能因为其使用的生命周期不一致而导致内存泄露，所以我们在新建静态持有的变量的时候需要多考虑一下各个成员之间的引用关系，并且尽量少地使用静态持有的变量，以避免发生内存泄露。当然，我们也可以在适当的时候讲静态量重置为null，使其不再持有引用，这样也可以避免内存泄露。\n" +
                "\n" +
                "非静态内部类导致内存泄露\n" +
                "非静态内部类（包括匿名内部类）默认就会持有外部类的引用，当非静态内部类对象的生命周期比外部类对象的生命周期长时，就会导致内存泄露。\n" +
                "\n" +
                "非静态内部类导致的内存泄露在Android开发中有一种典型的场景就是使用Handler，很多开发者在使用Handler是这样写的：\n" +
                "\n" +
                "public class MainActivity extends AppCompatActivity {\n" +
                "    \n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        start();\n" +
                "    }\n" +
                "\n" +
                "    private void start() {\n" +
                "        Message msg = Message.obtain();\n" +
                "        msg.what = 1;\n" +
                "        mHandler.sendMessage(msg);\n" +
                "    }\n" +
                "\n" +
                "    private Handler mHandler = new Handler() {\n" +
                "        @Override\n" +
                "        public void handleMessage(Message msg) {\n" +
                "            if (msg.what == 1) {\n" +
                "                // 做相应逻辑\n" +
                "            }\n" +
                "        }\n" +
                "    };\n" +
                "}\n" +
                "也许有人会说，mHandler并未作为静态变量持有Activity引用，生命周期可能不会比Activity长，应该不一定会导致内存泄露呢，显然不是这样的！\n" +
                "\n" +
                "熟悉Handler消息机制的都知道，mHandler会作为成员变量保存在发送的消息msg中，即msg持有mHandler的引用，而mHandler是Activity的非静态内部类实例，即mHandler持有Activity的引用，那么我们就可以理解为msg间接持有Activity的引用。msg被发送后先放到消息队列MessageQueue中，然后等待Looper的轮询处理（MessageQueue和Looper都是与线程相关联的，MessageQueue是Looper引用的成员变量，而Looper是保存在ThreadLocal中的）。那么当Activity退出后，msg可能仍然存在于消息对列MessageQueue中未处理或者正在处理，那么这样就会导致Activity无法被回收，以致发生Activity的内存泄露。\n" +
                "\n" +
                "通常在Android开发中如果要使用内部类，但又要规避内存泄露，一般都会采用静态内部类+弱引用的方式。\n" +
                "\n" +
                "public class MainActivity extends AppCompatActivity {\n" +
                "\n" +
                "    private Handler mHandler;\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        mHandler = new MyHandler(this);\n" +
                "        start();\n" +
                "    }\n" +
                "\n" +
                "    private void start() {\n" +
                "        Message msg = Message.obtain();\n" +
                "        msg.what = 1;\n" +
                "        mHandler.sendMessage(msg);\n" +
                "    }\n" +
                "\n" +
                "    private static class MyHandler extends Handler {\n" +
                "\n" +
                "        private WeakReference<MainActivity> activityWeakReference;\n" +
                "\n" +
                "        public MyHandler(MainActivity activity) {\n" +
                "            activityWeakReference = new WeakReference<>(activity);\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public void handleMessage(Message msg) {\n" +
                "            MainActivity activity = activityWeakReference.get();\n" +
                "            if (activity != null) {\n" +
                "                if (msg.what == 1) {\n" +
                "                    // 做相应逻辑\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "mHandler通过弱引用的方式持有Activity，当GC执行垃圾回收时，遇到Activity就会回收并释放所占据的内存单元。这样就不会发生内存泄露了。\n" +
                "\n" +
                "上面的做法确实避免了Activity导致的内存泄露，发送的msg不再已经没有持有Activity的引用了，但是msg还是有可能存在消息队列MessageQueue中，所以更好的是在Activity销毁时就将mHandler的回调和发送的消息给移除掉。\n" +
                "\n" +
                "@Override\n" +
                "protected void onDestroy() {\n" +
                "    super.onDestroy();\n" +
                "    mHandler.removeCallbacksAndMessages(null);\n" +
                "}\n" +
                "非静态内部类造成内存泄露还有一种情况就是使用Thread或者AsyncTask。\n" +
                "\n" +
                "比如在Activity中直接new一个子线程Thread：\n" +
                "\n" +
                "public class MainActivity extends AppCompatActivity {\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        new Thread(new Runnable() {\n" +
                "            @Override\n" +
                "            public void run() {\n" +
                "                // 模拟相应耗时逻辑\n" +
                "                try {\n" +
                "                    Thread.sleep(2000);\n" +
                "                } catch (InterruptedException e) {\n" +
                "                    e.printStackTrace();\n" +
                "                }\n" +
                "            }\n" +
                "        }).start();\n" +
                "    }\n" +
                "}\n" +
                "或者直接新建AsyncTask异步任务：\n" +
                "\n" +
                "public class MainActivity extends AppCompatActivity {\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        new AsyncTask<Void, Void, Void>() {\n" +
                "            @Override\n" +
                "            protected Void doInBackground(Void... params) {\n" +
                "                // 模拟相应耗时逻辑\n" +
                "                try {\n" +
                "                    Thread.sleep(2000);\n" +
                "                } catch (InterruptedException e) {\n" +
                "                    e.printStackTrace();\n" +
                "                }\n" +
                "                return null;\n" +
                "            }\n" +
                "        }.execute();\n" +
                "    }\n" +
                "}\n" +
                "很多初学者都会像上面这样新建线程和异步任务，殊不知这样的写法非常地不友好，这种方式新建的子线程Thread和AsyncTask都是匿名内部类对象，默认就隐式的持有外部Activity的引用，导致Activity内存泄露。要避免内存泄露的话还是需要像上面Handler一样使用静态内部类+弱应用的方式（代码就不列了，参考上面Hanlder的正确写法）。\n" +
                "\n" +
                "未取消注册或回调导致内存泄露\n" +
                "比如我们在Activity中注册广播，如果在Activity销毁后不取消注册，那么这个刚播会一直存在系统中，同上面所说的非静态内部类一样持有Activity引用，导致内存泄露。因此注册广播后在Activity销毁后一定要取消注册。\n" +
                "\n" +
                "public class MainActivity extends AppCompatActivity {\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        this.registerReceiver(mReceiver, new IntentFilter());\n" +
                "    }\n" +
                "\n" +
                "    private BroadcastReceiver mReceiver = new BroadcastReceiver() {\n" +
                "        @Override\n" +
                "        public void onReceive(Context context, Intent intent) {\n" +
                "            // 接收到广播需要做的逻辑\n" +
                "        }\n" +
                "    };\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onDestroy() {\n" +
                "        super.onDestroy();\n" +
                "        this.unregisterReceiver(mReceiver);\n" +
                "    }\n" +
                "}\n" +
                "在注册观察则模式的时候，如果不及时取消也会造成内存泄露。比如使用Retrofit+RxJava注册网络请求的观察者回调，同样作为匿名内部类持有外部引用，所以需要记得在不用或者销毁的时候取消注册。\n" +
                "\n" +
                "Timer和TimerTask导致内存泄露\n" +
                "Timer和TimerTask在Android中通常会被用来做一些计时或循环任务，比如实现无限轮播的ViewPager：\n" +
                "\n" +
                "public class MainActivity extends AppCompatActivity {\n" +
                "\n" +
                "    private ViewPager mViewPager;\n" +
                "    private PagerAdapter mAdapter;\n" +
                "    private Timer mTimer;\n" +
                "    private TimerTask mTimerTask;\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        init();\n" +
                "        mTimer.schedule(mTimerTask, 3000, 3000);\n" +
                "    }\n" +
                "\n" +
                "    private void init() {\n" +
                "        mViewPager = (ViewPager) findViewById(R.id.view_pager);\n" +
                "        mAdapter = new ViewPagerAdapter();\n" +
                "        mViewPager.setAdapter(mAdapter);\n" +
                "\n" +
                "        mTimer = new Timer();\n" +
                "        mTimerTask = new TimerTask() {\n" +
                "            @Override\n" +
                "            public void run() {\n" +
                "                MainActivity.this.runOnUiThread(new Runnable() {\n" +
                "                    @Override\n" +
                "                    public void run() {\n" +
                "                        loopViewpager();\n" +
                "                    }\n" +
                "                });\n" +
                "            }\n" +
                "        };\n" +
                "    }\n" +
                "\n" +
                "    private void loopViewpager() {\n" +
                "        if (mAdapter.getCount() > 0) {\n" +
                "            int curPos = mViewPager.getCurrentItem();\n" +
                "            curPos = (++curPos) % mAdapter.getCount();\n" +
                "            mViewPager.setCurrentItem(curPos);\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    private void stopLoopViewPager() {\n" +
                "        if (mTimer != null) {\n" +
                "            mTimer.cancel();\n" +
                "            mTimer.purge();\n" +
                "            mTimer = null;\n" +
                "        }\n" +
                "        if (mTimerTask != null) {\n" +
                "            mTimerTask.cancel();\n" +
                "            mTimerTask = null;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onDestroy() {\n" +
                "        super.onDestroy();\n" +
                "        stopLoopViewPager();\n" +
                "    }\n" +
                "}\n" +
                "当我们Activity销毁的时，有可能Timer还在继续等待执行TimerTask，它持有Activity的引用不能被回收，因此当我们Activity销毁的时候要立即cancel掉Timer和TimerTask，以避免发生内存泄漏。\n" +
                "\n" +
                "集合中的对象未清理造成内存泄露\n" +
                "这个比较好理解，如果一个对象放入到ArrayList、HashMap等集合中，这个集合就会持有该对象的引用。当我们不再需要这个对象时，也并没有将它从集合中移除，这样只要集合还在使用（而此对象已经无用了），这个对象就造成了内存泄露。并且如果集合被静态引用的话，集合里面那些没有用的对象更会造成内存泄露了。所以在使用集合时要及时将不用的对象从集合remove，或者clear集合，以避免内存泄漏。\n" +
                " if (nameList != null){\n" +
                "            nameList.clear();\n" +
                "            nameList = null;\n" +
                "        }\n" +
                "        if (list != null){\n" +
                "            list.clear();\n" +
                "            list = null;\n" +
                "        }" +
                "\n" +
                "资源未关闭或释放导致内存泄露\n" +
                "在使用IO、File流或者Sqlite、Cursor等资源时要及时关闭。这些资源在进行读写操作时通常都使用了缓冲，如果及时不关闭，这些缓冲对象就会一直被占用而得不到释放，以致发生内存泄露。因此我们在不需要使用它们的时候就及时关闭，以便缓冲能及时得到释放，从而避免内存泄露。\n" +
                "\n" +
                "属性动画造成内存泄露\n" +
                "动画同样是一个耗时任务，比如在Activity中启动了属性动画（ObjectAnimator），但是在销毁的时候，没有调用cancle方法，虽然我们看不到动画了，但是这个动画依然会不断地播放下去，动画引用所在的控件，所在的控件引用Activity，这就造成Activity无法正常释放。因此同样要在Activity销毁的时候cancel掉属性动画，避免发生内存泄漏。\n" +
                "\n" +
                "@Override\n" +
                "protected void onDestroy() {\n" +
                "    super.onDestroy();\n" +
                "    mAnimator.cancel();\n" +
                "}\n" +
                "WebView造成内存泄露\n" +
                "关于WebView的内存泄露，因为WebView在加载网页后会长期占用内存而不能被释放，因此我们在Activity销毁后要调用它的destory()方法来销毁它以释放内存。\n" +
                "\n" +
                "另外在查阅WebView内存泄露相关资料时看到这种情况：\n" +
                "\n" +
                "Webview下面的Callback持有Activity引用，造成Webview内存无法释放，即使是调用了Webview.destory()等方法都无法解决问题（Android5.1之后）。\n" +
                "\n" +
                "最终的解决方案是：在销毁WebView之前需要先将WebView从父容器中移除，然后在销毁WebView。详细分析过程请参考这篇文章：WebView内存泄漏解决方法。\n" +
                "\n" +
                "@Override\n" +
                "protected void onDestroy() {\n" +
                "    super.onDestroy();\n" +
                "    // 先从父控件中移除WebView\n" +
                "    mWebViewContainer.removeView(mWebView);\n" +
                "    mWebView.stopLoading();\n" +
                "    mWebView.getSettings().setJavaScriptEnabled(false);\n" +
                "    mWebView.clearHistory();\n" +
                "    mWebView.removeAllViews();\n" +
                "    mWebView.destroy();\n" +
                "}\n" +
                "总结\n" +
                "内存泄露在Android内存优化是一个比较重要的一个方面，很多时候程序中发生了内存泄露我们不一定就能注意到，所有在编码的过程要养成良好的习惯。总结下来只要做到以下这几点就能避免大多数情况的内存泄漏：\n" +
                "\n" +
                "构造单例的时候尽量别用Activity的引用；\n" +
                "静态引用时注意应用对象的置空或者少用静态引用；\n" +
                "使用静态内部类+软引用代替非静态内部类；\n" +
                "及时取消广播或者观察者注册；\n" +
                "耗时任务、属性动画在Activity销毁时记得cancel；\n" +
                "文件流、Cursor等资源及时关闭；\n" +
                "Activity销毁时WebView的移除和销毁。\n" +
                "\n" +
                "作者：xiaoyanger\n" +
                "链接：https://www.jianshu.com/p/ab4a7e353076\n" +
                "來源：简书\n" +
                "著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。 ";

        String contentS3 = "下面我们逐条来分析Android内存优化的关键点。\n" +
                "\n" +
                "1、万恶的static\n" +
                "\n" +
                "static是个好东西，声明赋值调用就是那么的简单方便，但是伴随而来的还有性能问题。由于static声明变量的生命周期其实是和APP的生命周期一 样的，有点类似与Application。如果大量的使用的话，就会占据内存空间不释放，积少成多也会造成内存的不断开销，直至挂掉。static的合理 使用一般用来修饰基本数据类型或者轻量级对象，尽量避免修复集合或者大对象，常用作修饰全局配置项、工具类方法、内部类。\n" +
                "\n" +
                "2、无关引用\n" +
                "\n" +
                "很多情况下，我们需求用到传递引用，但是我们无法确保引用传递出去后能否及时的回收。比如比较有代表性的Context泄漏，很多情况下当Activity 结束掉后，由于仍被其他的对象指向导致一直迟迟不能回收，这就造成了内存泄漏。这时可以考虑第三条建议。\n" +
                "\n" +
                "3、善用SoftReference/WeakReference/LruCache\n" +
                "\n" +
                "Java、Android中有没有这样一种机制呢，当内存吃紧或者GC扫过的情况下，就能及时把一些内存占用给释放掉，从而分配给需要分配的地方。答案是 肯定的，java为我们提供了两个解决方案。如果对内存的开销比较关注的APP，可以考虑使用WeakReference，当GC回收扫过这块内存区域时 就会回收；如果不是那么关注的话，可以使用SoftReference，它会在内存申请不足的情况下自动释放，同样也能解决OOM问题。同时 Android自3.0以后也推出了LruCache类，使用LRU算法就释放内存，一样的能解决OOM，如果兼容3.0一下的版本，请导入v4包。关于 第二条的无关引用的问题，我们传参可以考虑使用WeakReference包装一下。\n" +
                "\n" +
                "4、谨慎handler\n" +
                "\n" +
                "在处理异步操作的时候，handler + thread是个不错的选择。但是相信在使用handler的时候，大家都会遇到警告的情形，这个就是lint为开发者的提醒。handler运行于UI 线程，不断处理来自MessageQueue的消息，如果handler还有消息需要处理但是Activity页面已经结束的情况下，Activity的 引用其实并不会被回收，这就造成了内存泄漏。解决方案，一是在Activity的onDestroy方法中调用\n" +
                "\n" +
                "handler.removeCallbacksAndMessages(null);取消所有的消息的处理，包括待处理的消息；二是声明handler的内部类为static。\n" +
                "\n" +
                "5、Bitmap终极杀手\n" +
                "Bitmap的不当处理极可能造成OOM，绝大多数情况都是因这个原因出现的。Bitamp位图是Android中当之无愧的胖小子，所以在操作的时候当 然是十分的小心了。由于Dalivk并不会主动的去回收，需要开发者在Bitmap不被使用的时候recycle掉。使用的过程中，及时释放是非常重要 的。同时如果需求允许，也可以去BItmap进行一定的缩放，通过BitmapFactory.Options的inSampleSize属性进行控制。 如果仅仅只想获得Bitmap的属性，其实并不需要根据BItmap的像素去分配内存，只需在解析读取Bmp的时候使用 BitmapFactory.Options的inJustDecodeBounds属性。最后建议大家在加载网络图片的时候，使用软引用或者弱引用并进 行本地缓存，推荐使用android-universal-imageloader或者xUtils，牛人出品，必属精品。前几天在讲《自定义控件（三） 继承控件》的时候，也整理一个，大家可以去Github下载看看。\n" +
                "\n" +
                "6、Cursor和I/O流及时关闭\n" +
                "在查询SQLite数据库时，会返回一个Cursor，当查询完毕后，及时关闭，这样就可以把查询的结果集及时给回收掉。\n" +
                "\n" +
                "I/O流操作完毕，读写结束，记得关闭。\n" +
                "\n" +
                "\n" +
                "\n" +
                "7、ListView和GridView的item缓存\n" +
                "对于移动设备，尤其硬件参差不齐的android生态，页面的绘制其实是很耗时的，findViewById也是蛮慢的。所以不重用View，在有列表的时候就尤为显著了，经常会出现滑动很卡的现象。具体参照历史文章《说说ViewHolder的另一种写法》\n" +
                "\n" +
                "\n" +
                "8、页面背景和图片加载\n" +
                "\n" +
                "在布局和代码中设置背景和图片的时候，如果是纯色，尽量使用color；如果是规则图形，尽量使用shape画图；如果稍微复杂点，可以使用9patch图；如果不能使用9patch的情况下，针对几种主流分辨率的机型进行切图。\n" +
                "\n" +
                "\n" +
                "9、BroadCastReceiver、Service\n" +
                "\n" +
                "绑定广播和服务，一定要记得在不需要的时候给解绑。\n" +
                "\n" +
                "10、线程\n" +
                "\n" +
                "线程不再需要继续执行的时候要记得及时关闭，开启线程数量不易过多，一般和自己机器内核数一样最好，推荐开启线程的时候，使用线程池。\n" +
                "\n" +
                "11、String/StringBuffer\n" +
                "\n" +
                "当有较多的字符创需要拼接的时候，推荐使用StringBuffer。";

        setContentTextView(contentS0+"\n\n"+contentS + "\n\n\n" + contentS2 + "\n\n\n" + contentS3);

        gotoActivity("https://blog.csdn.net/qq_23191031/article/details/63685756");

    }
}
