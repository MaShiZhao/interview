package interview.kotlin.com.touch;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/17.
 *
 */

//public class TouchView extends android.support.v7.widget.AppCompatButton
//{
//    public static final String TAG ="MSZ_TOUCH";
//    public TouchView(Context context)
//    {
//        super(context);
//    }
//
//    public TouchView(Context context, AttributeSet attrs)
//    {
//        super(context, attrs);
//    }
//
//    public TouchView(Context context, AttributeSet attrs, int defStyleAttr)
//    {
//        super(context, attrs, defStyleAttr);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event)
//    {
//        Boolean b = super.onTouchEvent(event);
//        Log.d(TAG, "TouchView onTouchEvent " + event.getAction());
//        return false;
//    }
//
//}

public class TouchView extends BaseActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle("Touch");

        String contentS = "\n" +
                "        String contentS4 = \"基础知识：\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"所有的Touch事件都封装到MotionEvent里面\\n\" +\n" +
                "                \"事件处理包括三种情况，分别为：传递—-dispatchTouchEvent()函数、拦截——onInterceptTouchEvent()函数、消费—-onTouchEvent()函数和OnTouchListener\\n\" +\n" +
                "                \"事件类型分为ACTION_DOWN, ACTION_UP, ACTION_MOVE, ACTION_POINTER_DOWN, ACTION_POINTER_UP, ACTION_CANCEL等，每个事件都是以ACTION_DOWN开始ACTION_UP结束\\n\" +\n" +
                "                \"Android事件传递流程：\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"事件都是从Activity.dispatchTouchEvent()开始传递\\n\" +\n" +
                "                \"事件由父View传递给子View，ViewGroup可以通过onInterceptTouchEvent()方法对事件拦截，停止其向子view传递\\n\" +\n" +
                "                \"如果事件从上往下传递过程中一直没有被停止，且最底层子View没有消费事件，事件会反向往上传递，这时父View(ViewGroup)可以进行消费，如果还是没有被消费的话，最后会到Activity的onTouchEvent()函数。\\n\" +\n" +
                "                \"如果View没有对ACTION_DOWN进行消费，之后的其他事件不会传递过来，也就是说ACTION_DOWN必须返回true，之后的事件才会传递进来\\n\" +\n" +
                "                \"OnTouchListener优先于onTouchEvent()对事件进行消费\";\n";

        String contentS1 = "由于onInterceptTouchEvent()的机制比较复杂，上面的说明写的也比较复杂，总结一下，基本的规则是：\n" +
                "\n" +
                "1. down事件首先会传递到onInterceptTouchEvent()方法；\n" +
                "\n" +
                "2. 如果该ViewGroup的onInterceptTouchEvent()在接收到down事件处理完成之后return false，那么后续的move, up等事件将继续会先传递给该ViewGroup，之后才和down事件一样传递给最终的目标view的onTouchEvent()处理；\n" +
                "\n" +
                "3. 如果该ViewGroup的onInterceptTouchEvent()在接收到down事件处理完成之后return true，那么后续的move, up等事件将不再传递给onInterceptTouchEvent()，而是和down事件一样传递给该ViewGroup的onTouchEvent()处理，注意，目标view将接收不到任何事件；\n" +
                "\n" +
                "4. 如果最终需要处理事件的view的onTouchEvent()返回了false，那么该事件将被传递至其上一层次的view的onTouchEvent()处理；\n" +
                "\n" +
                "5. 如果最终需要处理事件的view 的onTouchEvent()返回了true，那么后续事件将可以继续传递给该view的onTouchEvent()处理。";


        setContentTextView(contentS + "\n\n\n" + contentS1);

        gotoActivity("https://www.cnblogs.com/CVstyle/p/6388060.html");

        AsyncTask asyncTask = new AsyncTask()
        {
            @Override
            protected Object doInBackground(Object[] params)
            {
                return null;
            }
        };
        asyncTask.execute();


    }
}
