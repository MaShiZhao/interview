package interview.kotlin.com.thread;

import android.os.Bundle;
import android.widget.TextView;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/3/26.
 */
public class ThreadAndProcessActivity extends BaseActivity
{
    private TextView textView;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_thread);
//        textView = (TextView) findViewById(R.id.contentTextView);
//        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        string = "进程：每个app运行时前首先创建一个进程，该进程是由Zygote fork出来的，用于承载App上运行的各种Activity/Service等组件。 \n" +
                "进程对于上层应用来说是完全透明的，这也是google有意为之，让App程序都是运行在Android Runtime。大多数情况一个App就运行在一个进程中，除非在AndroidManifest.xml中配置Android:process属性，或通过native代码fork进程。\n" +
                "\n" +
                "线程：线程对应用来说非常常见，比如每次new Thread().start都会创建一个新的线程。该线程与App所在进程之间资源共享，从Linux角度来说进程与线程除了是否共享资源外，并没有本质的区别，都是一个task_struct结构体，在CPU看来进程或线程无非就是一段可执行的代码，CPU采用CFS调度算法，保证每个task都尽可能公平的享有CPU时间片。";

        String string2 = "简要总结下线程在Android的作用：\n" +
                "\n" +
                "（1）在Android中线程分主线程和子线程，主线程也被称为UI线程，用来处理各种和界面相关的事情， \n" +
                "例 ：界面的加载，Activity的生命周期这些都在主线程的范畴之内。\n" +
                "\n" +
                "（2）由于主线程比较特殊，因为本身主线程在处理界面上，用了大部分的消耗，所以主线程不能再处理过于耗时的操作（IO操作，网络请求，大量的数据操作），否则就会造成ANR现象（程序卡死）。";

        String string3 = "如果是以“：”开头的进程属于当前应用的私有进程，其他应用组件不可以和它跑到一个进程里，如果不是以“：”开头的进程属于全局的进程，其他的应用可以通过ShareUID可以和它跑到同一进程当中，我们知道Android系统会为每个应用分配一个唯一的UID，相同应用的UID的应用才能共享数据。";

        setTitle("thread and process");
        setContentTextView(string + "\n\n\n" + string2);

        String code = "";

        gotoActivity(code);

    }


}
