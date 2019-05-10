package interview.kotlin.com.thread;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/18.
 */
public class AsyncTaskActivity extends BaseActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle("AsyncTask");

        String contentS ="Android中的工作者线程主要有AsyncTask、IntentService、HandlerThread，它们本质上都是对线程或线程池的封装。\n\n" +
                "AsyncTask是对Handler与线程池的封装。使用它的方便之处在于能够更新用户界面，当然这里更新用户界面的操作还是在主线程中完成的，但是由于AsyncTask内部包含一个Handler，所以可以发送消息给主线程让它更新UI。另外，AsyncTask内还包含了一个线程池。使用线程池的主要原因是避免不必要的创建及销毁线程的开销。通过使用线程池，我们可以实现维护固定数量的线程，不管有多少任务，我们都始终让线程池中的线程轮番上阵，这样就避免了不必要的开销。\n\n" +
                "Java并发编程：Callable、Future和FutureTask。‘";

        setContentTextView(contentS);

        gotoActivity("https://blog.csdn.net/google_huchun/article/details/65630850");
    }
}
