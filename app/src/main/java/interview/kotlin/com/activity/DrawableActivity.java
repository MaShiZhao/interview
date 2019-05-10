package interview.kotlin.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/5/14.
 */
public class DrawableActivity extends BaseActivity
{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("动画");

        String contentString ="逐帧动画(frame-by-frame animation)和补间动画(tweened animation)。逐帧动画的工作原理很简单，其实就是将一个完整的动画拆分成一张张单独的图片，然后再将它们连贯起来进行播放，类似于动画片的工作原理。补间动画则是可以对View进行一系列的动画操作，包括淡入淡出、缩放、平移、旋转四种。" +
                "属性动画是可以改变背景色的，并且可以不仅仅是绘制而是移动" +
                "\nObjectAnimator extends ValueAnimator extends Animator \n" +
                "AnimatorSet \n" +
                "after(Animator anim) ：将现有动画插入到传入的动画之后执行\n" +
                "after(long delay) ：将现有动画延迟指定毫秒后执行\n" +
                "before(Animator anim)： 将现有动画插入到传入的动画之前执行\n" +
                "with(Animator anim) ：将现有动画和传入的动画同时执行\n" +
                "\n" +
                "hdpi 480*800 \n" +
                "xhdpi 720*1280 \n" +
                "xxhdpi 1080*1920 \n" ;

//        ObjectAnimator objectAnimator =   ObjectAnimator.ofObject();
//        objectAnimator.start();
//        ValueAnimator valueAnimator =   ValueAnimator.ofObject();

        setContentTextView(contentString);

        gotoActivity("https://www.jianshu.com/p/2412d00a0ce4");


    }
}
