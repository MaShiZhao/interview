package interview.msz.com.touch;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.msz.com.baseActivity.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/17.
 */
//public class TouchActivity extends AppCompatActivity
//{
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState )
//    {
//        super.onCreate(savedInstanceState);
//
//
//        setContentView(R.layout.activity_touch);
//    }
//}

public class TouchActivity extends BaseActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);

        setTitle("Touch");

        String contentS ="所有的Touch事件都封装到MotionEvent里面\n" +
                "事件处理包括三种情况，分别为：传递—-dispatchTouchEvent()函数、拦截——onInterceptTouchEvent()函数、消费—-onTouchEvent()函数和OnTouchListener\n" +
                "事件类型分为ACTION_DOWN, ACTION_UP, ACTION_MOVE, ACTION_POINTER_DOWN, ACTION_POINTER_UP, ACTION_CANCEL等，每个事件都是以ACTION_DOWN开始ACTION_UP结束\n" +
                "Android事件传递流程：\n" +
                "\n" +
                "事件都是从Activity.dispatchTouchEvent()开始传递\n" +
                "事件由父View传递给子View，ViewGroup可以通过onInterceptTouchEvent()方法对事件拦截，停止其向子view传递\n" +
                "如果事件从上往下传递过程中一直没有被停止，且最底层子View没有消费事件，事件会反向往上传递，这时父View(ViewGroup)可以进行消费，如果还是没有被消费的话，最后会到Activity的onTouchEvent()函数。\n" +
                "如果View没有对ACTION_DOWN进行消费，之后的其他事件不会传递过来，也就是说ACTION_DOWN必须返回true，之后的事件才会传递进来\n" +
                "OnTouchListener优先于onTouchEvent()对事件进行消费";

        setContentTextView(contentS);

     }
}
