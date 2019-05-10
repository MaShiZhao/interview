package interview.kotlin.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/12.
 */
public class ViewActivity extends BaseActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle("自定义View");

        String contentS = "即onMeasure()、onLayout()和onDraw()\n\n\n" +
                "一. onMeasure()\n " +
                "measure()方法接收两个参数，widthMeasureSpec和heightMeasureSpec，这两个值分别用于确定视图的宽度和高度的规格和大小。\n\n" +
                "1. EXACTLY\n" +
                "\n" +
                "表示父视图希望子视图的大小应该是由specSize的值来决定的，系统默认会按照这个规则来设置子视图的大小，开发人员当然也可以按照自己的意愿设置成任意的大小。\n" +
                "\n" +
                "2. AT_MOST\n" +
                "\n" +
                "表示子视图最多只能是specSize中指定的大小，开发人员应该尽可能小得去设置这个视图，并且保证不会超过specSize。系统默认会按照这个规则来设置子视图的大小，开发人员当然也可以按照自己的意愿设置成任意的大小。\n" +
                "\n" +
                "3. UNSPECIFIED\n" +
                "\n" +
                "表示开发人员可以将视图按照自己的意愿设置成任意的大小，没有任何限制。这种情况比较少见，不太会用到。\n" +
                "\n" +
                "performTraversals()方法可以发现如下代码：\n" +
                "\n" +
                "[java] view plain copy\n" +
                "childWidthMeasureSpec = getRootMeasureSpec(desiredWindowWidth, lp.width);  \n" +
                "childHeightMeasureSpec = getRootMeasureSpec(desiredWindowHeight, lp.height);  \n" +
                "View的measure()方法里面的代码吧，如下所示：\n" +
                "\n" +
                "[java] view plain copy\n" +
                "public final void measure(int widthMeasureSpec, int heightMeasureSpec) {  \n" +
                "    if ((mPrivateFlags & FORCE_LAYOUT) == FORCE_LAYOUT ||  \n" +
                "            widthMeasureSpec != mOldWidthMeasureSpec ||  \n" +
                "            heightMeasureSpec != mOldHeightMeasureSpec) {  \n" +
                "        mPrivateFlags &= ~MEASURED_DIMENSION_SET;  \n" +
                "        if (ViewDebug.TRACE_HIERARCHY) {  \n" +
                "            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.ON_MEASURE);  \n" +
                "        }  \n" +
                "        onMeasure(widthMeasureSpec, heightMeasureSpec);  \n" +
                "        if ((mPrivateFlags & MEASURED_DIMENSION_SET) != MEASURED_DIMENSION_SET) {  \n" +
                "            throw new IllegalStateException(\"onMeasure() did not set the\"  \n" +
                "                    + \" measured dimension by calling\"  \n" +
                "                    + \" setMeasuredDimension()\");  \n" +
                "        }  \n" +
                "        mPrivateFlags |= LAYOUT_REQUIRED;  \n" +
                "    }  \n" +
                "    mOldWidthMeasureSpec = widthMeasureSpec;  \n" +
                "    mOldHeightMeasureSpec = heightMeasureSpec;  \n" +
                "}  \n" +
                "注意观察，measure()这个方法是final的，因此我们无法在子类中去重写这个方法，说明Android是不允许我们改变View的measure框架的。然后在第9行调用了onMeasure()方法，这里才是真正去测量并设置View大小的地方，默认会调用getDefaultSize()方法来获取视图的大小"
                +
                "public static int getDefaultSize(int size, int measureSpec) {  \n" +
                "    int result = size;  \n" +
                "    int specMode = MeasureSpec.getMode(measureSpec);  \n" +
                "    int specSize = MeasureSpec.getSize(measureSpec);  \n" +
                "    switch (specMode) {  \n" +
                "    case MeasureSpec.UNSPECIFIED:  \n" +
                "        result = size;  \n" +
                "        break;  \n" +
                "    case MeasureSpec.AT_MOST:  \n" +
                "    case MeasureSpec.EXACTLY:  \n" +
                "        result = specSize;  \n" +
                "        break;  \n" +
                "    }  \n" +
                "    return result;  \n" +
                "}  " +
                "getChildMeasureSpec()方法来去计算子视图的MeasureSpec" +
                "在setMeasuredDimension()方法调用之后，我们才能使用getMeasuredWidth()和getMeasuredHeight()来获取视图测量出的宽高，以此之前调用这两个方法得到的值都会是0。\n" +
                "\n" +
                "\n" +
                "\n" +
                "由此可见，视图大小的控制是由父视图、布局文件、以及视图本身共同完成的，父视图会提供给子视图参考的大小，而开发人员可以在XML文件中指定视图的大小，然后视图本身会对最终的大小进行拍板。" +
                "\n" +
                "二. onLayout() \n" +
                "measure过程结束后，视图的大小就已经测量好了，接下来就是layout的过程了。\n" +
                "ViewRoot的performTraversals()方法会在measure结束后继续执行，并调用View的layout()方法来执行此过程，如下所示：\n" +
                "\n" +
                "[java] view plain copy\n" +
                "host.layout(0, 0, host.mMeasuredWidth, host.mMeasuredHeight);  \n" +
                "layout 中存在个onLayout()方法 ，ViewGroup中的onLayout()方法竟然是一个抽象方法，这就意味着所有ViewGroup的子类都必须重写这个方法。\n" +
                "三. onDraw() \n" +
                "public void draw(Canvas canvas) {  \n" +
                "    if (ViewDebug.TRACE_HIERARCHY) {  \n" +
                "        ViewDebug.trace(this, ViewDebug.HierarchyTraceType.DRAW);  \n" +
                "    }  \n" +
                "    final int privateFlags = mPrivateFlags;  \n" +
                "    final boolean dirtyOpaque = (privateFlags & DIRTY_MASK) == DIRTY_OPAQUE &&  \n" +
                "            (mAttachInfo == null || !mAttachInfo.mIgnoreDirtyState);  \n" +
                "    mPrivateFlags = (privateFlags & ~DIRTY_MASK) | DRAWN;  \n" +
                "    // Step 1, draw the background, if needed  \n" +
                "    int saveCount;  \n" +
                "    if (!dirtyOpaque) {  \n" +
                "        final Drawable background = mBGDrawable;  \n" +
                "        if (background != null) {  \n" +
                "            final int scrollX = mScrollX;  \n" +
                "            final int scrollY = mScrollY;  \n" +
                "            if (mBackgroundSizeChanged) {  \n" +
                "                background.setBounds(0, 0,  mRight - mLeft, mBottom - mTop);  \n" +
                "                mBackgroundSizeChanged = false;  \n" +
                "            }  \n" +
                "            if ((scrollX | scrollY) == 0) {  \n" +
                "                background.draw(canvas);  \n" +
                "            } else {  \n" +
                "                canvas.translate(scrollX, scrollY);  \n" +
                "                background.draw(canvas);  \n" +
                "                canvas.translate(-scrollX, -scrollY);  \n" +
                "            }  \n" +
                "        }  \n" +
                "    }  \n" +
                "    final int viewFlags = mViewFlags;  \n" +
                "    boolean horizontalEdges = (viewFlags & FADING_EDGE_HORIZONTAL) != 0;  \n" +
                "    boolean verticalEdges = (viewFlags & FADING_EDGE_VERTICAL) != 0;  \n" +
                "    if (!verticalEdges && !horizontalEdges) {  \n" +
                "        // Step 3, draw the contentTextView  \n" +
                "        if (!dirtyOpaque) onDraw(canvas);  \n" +
                "        // Step 4, draw the children  \n" +
                "        dispatchDraw(canvas);  \n" +
                "        // Step 6, draw decorations (scrollbars)  \n" +
                "        onDrawScrollBars(canvas);  \n" +
                "        // we're done...  \n" +
                "        return;  \n" +
                "    }  \n" +
                "}  \n" +
                "1.对视图的背景进行绘制\n" +
                "2. 5. 跳过的 \n" +
                "3.内容，子类实现 \n" +
                "4.children  对当前视图的所有子视图进行绘制 \n" +
                "6.decorations scrollView 有的隐藏了 \n";

        String contentS2 = " 1.enabled 是否可用 对应 onTouch \n\n" +
                "2. pressed  对应drawableStateChanged \n\n" +
                "view 的 invalidate 重汇 \n" +
                "1. 是否重汇  显示 动画 \n" +
                "2. view 添加标记位  view parent 不为空 就执行ViewParent的invalidateChild()方法 \n " +
                "3. 最后还是通过 sendEmptyMessage 发送消息 接收到消息 执行 performTraversals() \n" +
                "，invalidate()方法虽然最终会调用到performTraversals()方法中，但这时measure和layout流程是不会重新执行的，因为视图没有强制重新测量的标志位，而且大小也没有发生过变化，所以这时只有draw流程可以得到执行。而如果你希望视图的绘制流程可以完完整整地重新走一遍，就不能使用invalidate()方法，而应该调用requestLayout()了 ";

        String contentS3 = "LayoutInflater inflate \n\n\n" +
                " 第一个参数，就是我们要填充的xml文件\n" +
                "\n" +
                "第二个参数，这个要和第三个参数有关系，大家慢慢看。若是第三个参数为true，那么第二个参数的意义是，从第一个参数填充成的view对象的父控件；若是第三个参数为false，那么第二个参数的意义是，\n" +
                "\n" +
                "可以为第一个参数生成的view对象的根布局提供一系LayoutParams参数的控件。\n" +
                "\n" +
                "第三个参数，从第一个参数填充成的view对象是否要附着到第二个参数指定的空间上作为子控件。\n" +
                "总结: 第三个跟第二个有关系 设置为true 只有第二个参数不为空才生效 设置为true 就不需要我们手动在添加一次 " +
                "设置为false 就需要我们手动添加" +
                "第二个参数是 设置父布局 " +
                "\n" +
                "view.inflate 也是调用到 LayoutInflater inflate  都是调用 inflate 方法 " +
                "1.先通过XmlResourceParser 解析 resourceId 成 xmlParser" +
                "2.createViewFromTag() AttributeSet  创建root布局" +
                "3. 设置temp View 的layout params " +
                "3.rInflateChildren(parser, temp, attrs, true); 初始化 子控件\n  ";

        String contentS4 = "include 根容器id与include id必须相同\n" +
                "<merge>标签 标签竟然会是一个Activity，里面有一个LinearLayout对象。 一般在最外层使用 \n" +
                "viewStub android:layout属性\n" +
                "加载包含的layout布局文件；\n" +
                "android:inflatedId属性\n" +
                "重写包含的layout布局文件的根容器id；\n" +
                "inflate()方法\n" +
                "与setVisible(int)方法作用类似，都可以使内容得以显示，只是inflate()会返回一个View对象，避免了额外使用findViewById()方法获取layout视图对象。\n" +
                "\n" +
                "SurfaceView 支持OpenGL ES库，2D和3D的效果都可以实现。创建SurfaceView的时候需要实现SurfaceHolder.Callback接口，它可以用来监听SurfaceView的状态，比如：SurfaceView的改变 、SurfaceView的创建 、SurfaceView 销毁等，我们可以在相应的方法中做一些比如初始化的操作或者清空的操作等等。" +
                "总的归纳起来SurfaceView和View不同之处有：\n" +
                "\n" +
                "1. SurfaceView允许其他线程更新视图对象(执行绘制方法)而View不允许这么做，它只允许UI线程更新视图对象。\n" +
                "\n" +
                "2. SurfaceView是放在其他最底层的视图层次中，所有其他视图层都在它上面，所以在它之上可以添加一些层，而且它不能是透明的。\n" +
                "\n" +
                "3. 它执行动画的效率比View高，而且你可以控制帧数。\n" +
                "\n" +
                "4. SurfaceView在绘图时使用l了双缓冲机制，而View没有。\n";

        setContentTextView(contentS + "\n\n\n" + contentS2 + "\n\n\n" + contentS3 + "\n\n\n"+contentS4);

    }

}
