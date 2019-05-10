package interview.kotlin.com.touch;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by MaShiZhao on 2018/4/17.
 */
public class TouchLayout extends FrameLayout
{
    public static final String TAG = "MSZ_TOUCH";

    public TouchLayout(@NonNull Context context)
    {
        super(context);
    }

    public TouchLayout(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
    }

    public TouchLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    public TouchLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        Boolean b = super.onInterceptTouchEvent(ev);
        Log.d(TAG, "TouchLayout onInterceptTouchEvent   " + b);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        Boolean b = super.onTouchEvent(event);
        Log.d(TAG, "TouchLayout onTouchEvent " + event.getAction());
        return true;
    }

}
