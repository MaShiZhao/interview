package interview.kotlin.com.start;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/3/26.
 */
public class StartAppActivity extends BaseActivity {
    private TextView textView;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setTitle("应用启动流程");
//
        string = "  应用启动流程 ";

        setContentTextView(string);

        gotoActivity("https://blog.csdn.net/blueangle17/article/details/74725922");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

}
