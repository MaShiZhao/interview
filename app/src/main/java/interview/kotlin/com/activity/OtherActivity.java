package interview.kotlin.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.baseActivity.BaseActivity;

/**
 * Created by MaShiZhao on 2018/5/15.
 */

public class OtherActivity extends BaseActivity
{


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("杂七杂八");

        String contentString = "1)静态注册：在AndroidManifest.xml注册，android不能自动销毁广播接收器，也就是说当应用程序关闭后，还是会接收广播。 \n" +
                "2)动态注册：在代码中通过registerReceiver()手工注册.当程序关闭时,该接收器也会随之销毁。当然，也可手工调用unregisterReceiver()进行销毁。\n" +
                "" +
                "多个具当前已经注册且有效的BroadcastReceiver接收有序广播时，是按照先后顺序接收的，先后顺序判定标准遵循为：将当前系统中所有有效的动态注册和静态注册的BroadcastReceiver按照priority属性值从大到小排序，对于具有相同的priority的动态广播和静态广播，动态广播会排在前面。" +
                "" +
                "而Android O执行了更为严格的限制。\n" +
                "\n" +
                "1.动态注册的receiver，可接收任何显式和隐式广播。\n" +
                "\n" +
                "2.targetSdkVersion为Android O（API level 26）及以上的应用，静态注册的receiver将不能收到隐式广播，但可以收到显式广播。下面例子说明\n\n" +
                "android monitors hprof文件 \n" +
                "include  重复定义相同布局 \n" +
                "Merge  减少层级 \n" +
                "ViewStub  需要显示隐藏 \n\n" +
                "bit就是位，也叫比特位，是计算机表示数据最小的单位。\n" +
                "byte就是字节，1byte=8bit，1byte就是1B；\n" +
                "1KB=1024B\b" +
                "一个中文汉字占两个字节的空间。 一个英文字母(不分大小写)占一个字节的空间\n" +
                "ASCII码：一个英文字母（不分大小写）占一个字节的空间，一个中文汉字占两个字节的空间。一个二进制数字序列，在计算机中作为一个数字单元，一般为8位二进制数，换算为十进制。最小值0，最大值255。如一个ASCII码就是一个字节。\n" +
                "UTF-8编码：一个英文字符等于一个字节，一个中文（含繁体）等于三个字节。中文标点占三个字节，英文标点占一个字节\n" +
                "Unicode编码：一个英文等于两个字节，一个中文（含繁体）等于两个字节。中文标点占两个字节，英文标点占两个字节\n" +
                "\n\n\n" +
                "addJavaScriptInterface / shouldOverrideUrlLoading(WebViewClient) /  onJsPrompt (WebChromeClient)    " +
                "\n\n\n" +
                "java Dalvik 虚拟机不同 https://blog.csdn.net/tby_huier/article/details/51384981 \n" +
                "Java虚拟机运行的是Java字节码，而Dalvik虚拟机运行的则是其专有的文件格式DEX（Dalvik Executable）。\n" +
                "在Java SE程序中的Java类会被编译成一个或者多个字节码文件（.class）然后打包到JAR文件，而后Java虚拟机会从相应的CLASS文件和JAR文 件中获取相应的字节码；Android应用虽然也是使用Java语言进行编程，但是在编译成CLASS文件后，还会通过一个工具（dx）将应用所有的 CLASS文件转换成一个DEX文件，而后Dalvik虚拟机会从其中读取指令和数据。\n" +
                "  java虚拟机和Dalvik虚拟机的区别：\n" +
                "\n" +
                " \tjava虚拟机\tDalvik虚拟机\n" +
                " \tjava虚拟机基于栈。 基于栈的机器必须使用指令来载入和操作栈上数据，所需指令更多更多\tdalvik虚拟机是基于寄存器的\n" +
                " \tjava虚拟机运行的是java字节码。（java类会被编译成一个或多个字节码.class文件，打包到.jar文件中，java虚拟机从相应的.class文件和.jar文件中获取相应的字节码）\n" +
                " \n" +
                "\n" +
                "Dalvik运行的是自定义的.dex字节码格式。（java类被编译成.class文件后，会通过一个dx工具将所有的.class文件转换成一个.dex文件，然后dalvik虚拟机会从其中读取指令和数据）\n" +
                " \t \t常量池已被修改为只使用32位的索引，以 简化解释器。dalvik的堆和栈的参数可以通过-Xms和-Xmx更改\n" +
                " \t \t一个应用，一个虚拟机实例，一个进程（所有android应用的线程都是对应一个linux线程，都运行在自己的沙盒中，不同的应用在不同的进程中运行。每个android dalvik应用程序都被赋予了一个独立的linux PID(app_*)）\n\n\n" +
                "" +
                "standard \n" +
                "singleTop适合接收通知启动的内容显示页面。例如，某个新闻客户端的新闻内容页面，如果收到10个新闻推送，每次都打开一个新闻内容页面是很烦人的。\n" +
                "\n" +
                "singleTask适合作为程序入口点。例如浏览器的主界面。不管从多少个应用启动浏览器，只会启动主界面一次，其余情况都会走onNewIntent，并且会清空主界面上面的其他页面。之前打开过的页面，打开之前的页面就ok，不再新建。\n" +
                "\n" +
                "singleInstance适合需要与程序分离开的页面。例如闹铃提醒，将闹铃提醒与闹铃设置分离。singleInstance不要用于中间页面，如果用于中间页面，跳转会有问题，比如：A -> B (singleInstance) -> C，完全退出后，在此启动，首先打开的是B。" +
                "\n\n\n" +
                "" +
                "View中的onDraw()方法的canvas的来由\n" +
                "我们知道view被绘制，最终都是被ViewRootImpl调用的，在ViewRootImpl的drawSoftware中\n" +
                "代码中mView.draw(canvas)就是调用的View中的onDraw方法，这里看到canvas是通过mSurface.lockCanvas获取到的，" +
                "        canvas = mSurface.lockCanvas(dirty);\n " +
                "然后在找到Surface中的lockCanvas方法：" +
                "        mLockedObject = nativeLockCanvas(mNativeObject, mCanvas, inOutDirty);\n" +
                "返回的mCanvas在追溯一下被赋值的地方，发现是在内部类HwuiContext中得到的\n" +
                "Canvas lockCanvas(int width, int height) {\n" +
                "    if (mCanvas != null) {\n" +
                "        throw new IllegalStateException(\"Surface was already locked!\");\n" +
                "    }\n" +
                "    mCanvas = mRenderNode.start(width, height);\n" +
                "    return mCanvas;\n" +
                "}\n" +
                "然后找到start方法：\n" +
                "public DisplayListCanvas start(int width, int height) {\n" +
                "    DisplayListCanvas canvas = DisplayListCanvas.obtain(this);\n" +
                "    canvas.setViewport(width, height);\n" +
                "    // The dirty rect should always be null for a display list\n" +
                "    canvas.onPreDraw(null);\n" +
                "    return canvas;\n" +
                "}" +
                "\n\n\n" +
                "" +
                "   ";

        setContentTextView(contentString);


    }


}
