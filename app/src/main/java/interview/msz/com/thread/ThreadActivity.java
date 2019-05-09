package interview.msz.com.thread;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import interview.msz.com.baseActivity.BaseActivity;

/**
 * Created by MaShiZhao on 2018/3/26.
 */
public class ThreadActivity extends BaseActivity {
    private TextView textView;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("handler message message queues  looper");
//
//        string = "Looper  mylooper = Looper.mylooper();获取当前线程的looper；\n" +
//                "MessageQueue  messageQueue =   myLooper.mQueue();  \n 获取当前的message queue\n" +
//                "messageQueue.enqueueMessage(msg,uptimemills); " +
//                " \n 消息队列 插入消息\n" +
//                "//获取到msg 去进行判断是否存在 callback  \n" +
//                "public void dispatchMessage(Message msg) {\n   " +
//                " if (msg.callback != null) {\n        handleCallback(msg);\n    } else {\n        if (mCallback != null) {\n            if (mCallback.handleMessage(msg)) {\n                return;\n            }\n        }\n        handleMessage(msg);\n    }\n}\n" +
//                "\n" +
//                "Looper.MainLooper() 获取的是主线程的Looper \n" +
//                "\n" +
//                "handler是个处理接收message 和 runable \n" +
//                "message queue 是消息队列管理messages,\n" +
//                "mQueue 是通过mlooper.mQueue 获取的  \n" +
//                "mLooper 是管理每条线程的里的message queue ，获取looper.MainLooper 还是myLooper; //看具体使用情况\n" +
//                "\n" +
//                "\n" +
//                "  Looper是每条线程里的Message Queue的管家。Android没有Global的Message Queue，而Android会自动替主线程(UI线程)建立Message Queue，但在子线程里并没有建立Message Queue。所以调用Looper.getMainLooper()得到的主线程的Looper不为NULL，但调用Looper.myLooper() 得到当前线程的Looper就有可能为NULL。对于子线程使用Looper，API Doc提供了正确的使用方法：这个Message机制的大概流程：\n" +
//                "    1. 在Looper.loop()方法运行开始后，循环地按照接收顺序取出Message Queue里面的非NULL的Message。\n" +
//                "    2. 一开始Message Queue里面的Message都是NULL的。当Handler.sendMessage(Message)到Message Queue，该函数里面设置了那个Message对象的target属性是当前的Handler对象。随后Looper取出了那个Message，则调用 该Message的target指向的Hander的dispatchMessage函数对Message进行处理。在dispatchMessage方法里，如何处理Message则由用户指定，三个判断，优先级从高到低：\n" +
//                "    1) Message里面的Callback，一个实现了Runnable接口的对象，其中run函数做处理工作；\n" +
//                "    2) Handler里面的mCallback指向的一个实现了Callback接口的对象，由其handleMessage进行处理；\n" +
//                "    3) 处理消息Handler对象对应的类继承并实现了其中handleMessage函数，通过这个实现的handleMessage函数处理消息。" +
//                "" +
//                "\n\n" +
//                "线程的两种写法 1. extends  2.Runnable" +
//                "start run 的区别 " +
//                "　1） start：\n" +
//                "　　用start方法来启动线程，真正实现了多线程运行，这时无需等待run方法体代码执行完毕而直接继续执行下面的代码。通过调用Thread类的start()方法来启动一个线程，这时此线程处于就绪（可运行）状态，并没有运行，一旦得到cpu时间片，就开始执行run()方法，这里方法 run()称为线程体，它包含了要执行的这个线程的内容，Run方法运行结束，此线程随即终止。\n" +
//                "　　2） run：\n" +
//                "　　run()方法只是类的一个普通方法而已，如果直接调用Run方法，程序中依然只有主线程这一个线程，其程序执行路径还是只有一条，还是要顺序执行，还是要等待run方法体执行完毕后才可继续执行下面的代码，这样就没有达到写线程的目的。总结：调用start方法方可启动线程，而run方法只是thread的一个普通方法调用，还是在主线程里执行。这两个方法应该都比较熟悉，把需要并行处理的代码放在run()方法中，start()方法启动线程将自动调用 run()方法，这是由jvm的内存机制规定的。并且run()方法必须是public访问权限，返回值类型为void.。";
//
//
//        String contentS = "线程包括以下这几个状态：创建(new)、就绪(runnable)、运行(running)、阻塞(blocked)、time waiting、waiting、消亡（dead）。\n" +
//                "\n" +
//                "1. 新建(new)：新创建了一个线程对象。\n" +
//                "\n" +
//                "2. 可运行(runnable)：线程对象创建后，其他线程(比如main线程）调用了该对象的start()方法。该状态的线程位于可运行线程池中，等待被线程调度选中，获取cpu 的使用权 。\n" +
//                "\n" +
//                "3. 运行(running)：可运行状态(runnable)的线程获得了cpu 时间片（timeslice） ，执行程序代码。\n" +
//                "\n" +
//                "4. 阻塞(block)：阻塞状态是指线程因为某种原因放弃了cpu 使用权，也即让出了cpu timeslice，暂时停止运行。直到线程进入可运行(runnable)状态，才有机会再次获得cpu timeslice 转到运行(running)状态。阻塞的情况分三种： \n" +
//                "\n" +
//                "(一). 等待阻塞：运行(running)的线程执行o.wait()方法，JVM会把该线程放入等待队列(waitting queue)中。\n" +
//                "\n" +
//                "(二). 同步阻塞：运行(running)的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入锁池(lock pool)中。\n" +
//                "\n" +
//                "(三). 其他阻塞：运行(running)的线程执行Thread.sleep(long ms)或t.join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入可运行(runnable)状态。\n" +
//                "\n" +
//                "5. 死亡(dead)：线程run()、main() 方法执行结束，或者因异常退出了run()方法，则该线程结束生命周期。死亡的线程不可再次复生。\n" +
//                "\n";
//
//        String contentS1 = "sleep() 和 wait() 的区别就是  \n" +
//                "最主要是sleep方法没有释放锁，而wait方法释放了锁，使得其他线程可以使用同步控制块或者方法(锁代码块和方法锁)。  \n" +
//                "wait，notify和notifyAll只能在同步控制方法或者同步控制块里面使用，而sleep可以在任何地方使用(使用范围)  \n" +
//                "sleep必须捕获异常，而wait，notify和notifyAll不需要捕获异常  \n" +
//                "sleep方法属于Thread类中方法，表示让一个线程进入睡眠状态，等待一定的时间之后，自动醒来进入到可运行状态，不会马上进入运行状态，因为线程调度机制恢复线程的运行也需要时间，一个线程对象调用了sleep方法之后，并不会释放他所持有的所有对象锁，所以也就不会影响其他进程对象的运行。但在sleep的过程中过程中有可能被其他对象调用它的interrupt(),产生InterruptedException异常，如果你的程序不捕获这个异常，线程就会异常终止，进入TERMINATED状态，如果你的程序捕获了这个异常，那么程序就会继续执行catch语句块(可能还有finally语句块)以及以后的代码。  \n" +
//                "注意sleep()方法是一个静态方法，也就是说他只对当前对象有效，通过t.sleep()让t对象进入sleep，这样的做法是错误的，它只会是使当前线程被sleep 而不是t线程  \n" +
//                " wait属于Object的成员方法，一旦一个对象调用了wait方法，必须要采用notify()和notifyAll()方法唤醒该进程;如果线程拥有某个或某些对象的同步锁，那么在调用了wait()后，这个线程就会释放它持有的所有同步资源，而不限于这个被调用了wait()方法的对象。wait()方法也同样会在wait的过程中有可能被其他对象调用interrupt()方法而产生  \n";
//
//        String contentS2="yield join 区别" +
//                "yield方法  \n" +
//                "\n" +
//                "暂停当前正在执行的线程对象。  \n" +
//                "\n" +
//                "yield()方法是停止当前线程，让同等优先权的线程或更高优先级的线程有执行的机会。如果没有的话，那么yield()方法将不会起作用，并且由可执行状态后马上又被执行。   \n" +
//                "\n" +
//                "join方法是用于在某一个线程的执行过程中调用另一个线程执行，等到被调用的线程执行结束后，再继续执行当前线程。如：t.join();//主要用于等待t线程运行结束，若无此句，main则会执行完毕，导致结果不可预测。 \n " +
//                "\n" +
//                "    但是wait()和sleep()都可以通过interrupt()方法打断线程的暂停状态，从而使线程立刻抛出InterruptedException（但不建议使用该方法）。";
//
//        setContentTextView(string + "\n\n\n" + contentS + "\n\n\n" + contentS1+ "\n\n\n" + contentS2);
//
//        String code = "package com.example.liuwangshu.moonmessenger;\n" +
//                "\n" +
//                "import android.contentTextView.ComponentName;\n" +
//                "import android.contentTextView.Context;\n" +
//                "import android.contentTextView.Intent;\n" +
//                "import android.contentTextView.ServiceConnection;\n" +
//                "import android.os.Handler;\n" +
//                "import android.os.IBinder;\n" +
//                "import android.os.Message;\n" +
//                "import android.os.Messenger;\n" +
//                "import android.os.RemoteException;\n" +
//                "import android.support.v7.app.AppCompatActivity;\n" +
//                "import android.os.Bundle;\n" +
//                "import android.util.Log;\n" +
//                "\n" +
//                "public class MessengerActivity extends AppCompatActivity {\n" +
//                "    private Messenger mMessenger;\n" +
//                "    @Override\n" +
//                "    protected void onCreate(Bundle savedInstanceState) {\n" +
//                "        super.onCreate(savedInstanceState);\n" +
//                "        setContentView(R.layout.activity_messenger);\n" +
//                "        Intent intent=new Intent(MessengerActivity.this,MessengerService.class);\n" +
//                "        bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE);\n" +
//                "    }\n" +
//                "    private Handler mHandler = new Handler() {\n" +
//                "        @Override\n" +
//                "        public void handleMessage(Message msg) {\n" +
//                "            switch (msg.what){\n" +
//                "                case MessengerService.MSG_FROMCLIENT:\n" +
//                "                    Log.i(MessengerService.TAG, \"客户端收到的信息-------\" + msg.getData().get(\"rep\"));\n" +
//                "                    break;\n" +
//                "            }\n" +
//                "        }\n" +
//                "    };\n" +
//                "\n" +
//                "\n" +
//                "private ServiceConnection mServiceConnection=new ServiceConnection() {\n" +
//                "    @Override\n" +
//                "    public void onServiceConnected(ComponentName name, IBinder service) {\n" +
//                "        mMessenger=new Messenger(service);\n" +
//                "        Message mMessage=Message.obtain(null,MessengerService.MSG_FROMCLIENT);\n" +
//                "        Bundle mBundle=new Bundle();\n" +
//                "        mBundle.putString(\"msg\", \"这里是客户端，收到了嘛服务端\");\n" +
//                "        mMessage.setData(mBundle);\n" +
//                "        //将Messenger传递给服务端\n" +
//                "        mMessage.replyTo=new Messenger(mHandler);\n" +
//                "        try {\n" +
//                "            mMessenger.send(mMessage);\n" +
//                "        } catch (RemoteException e) {\n" +
//                "            e.printStackTrace();\n" +
//                "        }\n" +
//                "    }\n" +
//                "\n" +
//                "    @Override\n" +
//                "    public void onServiceDisconnected(ComponentName name) {\n" +
//                "\n" +
//                "    }\n" +
//                "};\n" +
//                "    @Override\n" +
//                "    protected void onDestroy() {\n" +
//                "        super.onDestroy();\n" +
//                "        unbindService(mServiceConnection);\n" +
//                "\n" +
//                "    }\n" +
//                "}\n";
//
//
//        String code2 = "package com.example.liuwangshu.moonmessenger;\n" +
//                "\n" +
//                "import android.app.Service;\n" +
//                "import android.contentTextView.Intent;\n" +
//                "import android.os.Bundle;\n" +
//                "import android.os.Handler;\n" +
//                "import android.os.IBinder;\n" +
//                "import android.os.Message;\n" +
//                "import android.os.Messenger;\n" +
//                "import android.os.RemoteException;\n" +
//                "import android.util.Log;\n" +
//                "\n" +
//                "public class MessengerService extends Service {\n" +
//                "    public static final String TAG = \"MoonMessenger\";\n" +
//                "    public static final int MSG_FROMCLIENT=1000;\n" +
//                "\n" +
//                "    private Handler mHandler = new Handler() {\n" +
//                "        @Override\n" +
//                "        public void handleMessage(Message msg) {\n" +
//                "            switch (msg.what) {\n" +
//                "                case MSG_FROMCLIENT:\n" +
//                "                    Log.i(TAG,\"服务端收到的信息-------\"+msg.getData().get(\"msg\"));\n" +
//                "                    //得到客户端传来的Messenger对象\n" +
//                "                    Messenger mMessenger=msg.replyTo;\n" +
//                "                    Message mMessage=Message.obtain(null,MessengerService.MSG_FROMCLIENT);\n" +
//                "                    Bundle mBundle=new Bundle();\n" +
//                "                    mBundle.putString(\"rep\",\"这里是服务端，我们收到信息了\");\n" +
//                "                    mMessage.setData(mBundle);\n" +
//                "                    try {\n" +
//                "                        mMessenger.send(mMessage);\n" +
//                "                    } catch (RemoteException e) {\n" +
//                "                        e.printStackTrace();\n" +
//                "                    }\n" +
//                "                    break;\n" +
//                "            }\n" +
//                "        }\n" +
//                "    };\n" +
//                "\n" +
//                "    @Override\n" +
//                "    public IBinder onBind(Intent intent) {\n" +
//                "        Messenger mMessenger=new Messenger(mHandler);\n" +
//                "        return mMessenger.getBinder();\n" +
//                "    }\n" +
//                "}\n";

        setContent();
//        gotoActivity("");
    }


}
