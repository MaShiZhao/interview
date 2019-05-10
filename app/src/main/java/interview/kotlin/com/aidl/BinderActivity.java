package interview.kotlin.com.aidl;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.baseActivity.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/10.
 */
public class BinderActivity extends BaseActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        String contentS = "首先需要注册服务端，只有注册了服务端，客户端才有通讯的目标，服务端通过 ServiceManager 注册服务，注册的过程就是向 Binder 驱动的全局链表 binder_procs 中插入服务端的信息（binder_proc 结构体，每个 binder_proc 结构体中都有 todo 任务队列），然后向 ServiceManager 的 svcinfo 列表中缓存一下注册的服务。\n" +
                "\n" +
                "有了服务端，客户端就可以跟服务端通讯了，通讯之前需要先获取到服务，拿到服务的代理，也可以理解为引用。比如下面的代码：\n" +
                "\n" +
                "//获取WindowManager服务引用\n" +
                "WindowManager wm = (WindowManager)getSystemService(getApplication().WINDOW_SERVICE);\n" +
                "1\n" +
                "2\n" +
                "获取服务端的方式就是通过 ServiceManager 向 svcinfo 列表中查询一下返回服务端的代理，svcinfo 列表就是所有已注册服务的通讯录，保存了所有注册的服务信息。\n" +
                "\n" +
                "有了服务端的引用我们就可以向服务端发送请求了，通过 BinderProxy 将我们的请求参数发送给 ServiceManager，通过共享内存的方式使用内核方法 copy_from_user() 将我们的参数先拷贝到内核空间，这时我们的客户端进入等待状态，然后 Binder 驱动向服务端的 todo 队列里面插入一条事务，执行完之后把执行结果通过 copy_to_user() 将内核的结果拷贝到用户空间（这里只是执行了拷贝命令，并没有拷贝数据，binder只进行一次拷贝），唤醒等待的客户端并把结果响应回来，这样就完成了一次通讯。";

        setContentTextView(contentS);

        gotoActivity("https://blog.csdn.net/freekiteyu/article/details/70082302");
    }
}
