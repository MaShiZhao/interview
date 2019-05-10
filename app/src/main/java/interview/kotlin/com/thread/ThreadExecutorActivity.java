package interview.kotlin.com.thread;

import android.os.Bundle;
import android.widget.TextView;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/3/26.
 */
public class ThreadExecutorActivity extends BaseActivity
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

        setTitle("线程池 thread pool");

        string = " \n" +
                "（1）复用线程池中的线程，避免因为线程的创建和销毁所带来的性能开销。\n" +
                "\n" +
                "（2）能够有效的控制线程池的最大并发数，避免大量的线程之间因互相抢占系统资源而导致的阻塞现象。\n" +
                "\n" +
                "（3）能够对线程进行简单的管理，并提供定时执行以及指定间隔循环执行等功能。\n" +
                "\n\n\n"+

                "    public ThreadPoolExecutor(int corePoolSize,\n" +
                "                              int maximumPoolSize,\n" +
                "                              long keepAliveTime,\n" +
                "                              TimeUnit unit,\n" +
                "                    BlockingQueue<Runnable> workQueue,\n" +
                "                          ThreadFactory threadFactory)\n"+
                "                          corePoolSize  核心线程数 maxmumPoolSize 最大核心数 \n"+
                "                          keepAliveTime  非核心线程保持时长  unit 时间单位 \n"+
                "                          workQueue 队列  threadFactory 线程工程 \n" +
                " CorePoolSize \n" +
                "线程的核心线程数。\n" +
                "\n" +
                "默认情况下，核心线程数会在线程中一直存活，即使它们处于闲置状态。\n" +
                "\n" +
                "如果将ThreadPoolExecutor的allowCoreThreadTimeOut属性设置为true，那么核心线程就会存在超时策略，这个时间间隔有keepAliveTime所决定，当等待时间超过keepAliveTime所指定的时长后，核心线程就会被停止。\n" +
                "\n" +
                "maximumPoolSize \n" +
                "线程池所能容纳的最大线程数。\n" +
                "\n" +
                "当活动线程数达到这个数值后，后续的新任务将会被阻塞。\n" +
                "\n" +
                "keepAliveTime \n" +
                "非核心线程闲置时的超时时长，超过这个时长，非核心线程就会被回收，当ThreadPoolExector的allowCoreThreadTimeOut属性设置为True时，keepAliveTime同样会作用于核心线程。\n" +
                "\n" +
                "unit \n" +
                "用于指定keepAliveTime参数的时间单位，这是一个枚举，常用的有TimeUnit.MILLISECONDS（毫秒）、TimeUnit.SECONDS(秒)以及TimeUnit.MINUTES(分钟)等。"+
                "workQueue \n" +
                "线程池中的任务队列，通过线程池execute方法提交的Runnable对象会存储在这个参数中。任务缓存队列及排队策略\n" +
                "\n" +
                "在前面我们多次提到了任务缓存队列，即workQueue，它用来存放等待执行的任务。\n" +
                "\n" +
                "workQueue的类型为BlockingQueue<Runnable>，通常可以取下面三种类型：\n" +
                "\n" +
                "1）ArrayBlockingQueue：基于数组的先进先出队列，此队列创建时必须指定大小；\n" +
                "\n" +
                "2）LinkedBlockingQueue：基于链表的先进先出队列，如果创建时没有指定此队列大小，则默认为Integer.MAX_VALUE；\n" +
                "\n" +
                "3）synchronousQueue：这个队列比较特殊，它不会保存提交的任务，而是将直接新建一个线程来执行新来的任务。\n" +
                "\n" +
                "这个任务队列是BlockQueue类型，属于阻塞队列，就是当队列为空的时候，此时取出任务的操作会被阻塞，等待任务加入队列中不为空的时候，才能进行取出操作，而在满队列的时候，添加操作同样被阻塞。\n" +
                "\n" +
                "当线程池的任务缓存队列已满并且线程池中的线程数目达到maximumPoolSize，如果还有任务到来就会采取任务拒绝策略，通常有以下四种策略：\n" +
                "ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。\n" +
                "ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。\n" +
                "ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）\n" +
                "ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务\n" +
                "\n"+

                "1.CacheThreadPool \n" +
                "//无核心线程,并且最大线程数为int的最大值.\n" +
                "//超时时间为60s\n" +
                "//队列为SynchronousQueue同步阻塞队列,队列中没有任何容量.只有在有需求的情况下,队列中才可以试着添加任务.\n" +
                "\n"+
                "2.ScheduledThreadPool\n " +
                "\n//核心线程数是固定的,非核心线程无限大,并且非核心线程数有10s的空闲存活时间\n"+
                "CacheThreadPool " +
                "\n"+
                "3.FixedThreadPool  \n" +
                "//核心线程数和最大线程数相同.\n" +
                "//无超时时间" +
                "\n"+
                "4.SingleThreadExecutor \n" +
                "//特点:\n" +
                "    //线程中只有一个核心线程\n" +
                "    //并且无超时时间"
                ;

        setContentTextView(string);

        String code = "https://blog.csdn.net/l540675759/article/details/62230562" +
                "\n\n" +
                "http://www.importnew.com/19011.html";

        gotoActivity(code);

    }


}
