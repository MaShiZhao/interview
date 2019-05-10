package interview.kotlin.com.sourcecode;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/18.
 */
public class OkhttpActivity extends BaseActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("Okhttp");


        String contentString ="Request、Response和Call。\nRequest\n" +
                "每一个HTTP请求包含一个URL、一个方法（GET或POST或其他）、一些HTTP头。请求还可能包含一个特定内容类型的数据类的主体部分。\n" +
                "\n" +
                "Response\n" +
                "响应是对请求的回复，包含状态码、HTTP头和主体部分。\n" +
                "\n" +
                "Call\n" +
                "OkHttp使用Call抽象出一个满足请求的模型，尽管中间可能会有多个请求或响应。执行Call有两种方式，同步或异步\n\n" +
                "OkHttp的底层是通过Java的Socket发送HTTP请求与接受响应的(这也好理解，HTTP就是基于TCP协议的)，但是OkHttp实现了连接池的概念，即对于同一主机的多个请求，其实可以公用一个Socket连接，而不是每次发送完HTTP请求就关闭底层的Socket，这样就实现了连接池的概念。而OkHttp对Socket的读写操作使用的OkIo库进行了一层封装。";
        setContentTextView(contentString);

        gotoActivity("https://blog.csdn.net/mwq384807683/article/details/71173442?locationNum=8&fps=1");
    }
}
