package interview.kotlin.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/23.
 */
public class ReactNativeActivity extends BaseActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        String contentString ="android文件夹，就是一个可以用android studio打开的android项目。\n" +
                "ios文件夹，是一个可以用xcode打开的ios项目。\n" +
                "index.android.js，这是android的React Native入口文件。\n" +
                "index.ios.js，这是ios的React Native入口文件。\n" +
                "package.json，类似android studio的build.gradle，你依赖的库都写在里面。\n" +
                "node_module文件夹，你依赖的库下载下来都存放在里面，属于git的忽略文件，你要找的依赖库源码也在里面，包括React和React Native。\n" +
                "jscode文件夹，是自己创建的文件夹，用来存放自己写的js文件。\n" +
                "\n";


        String contentString2 ="1、Java层\n" +
                "\n" +
                "JavaScriptModule接口类定义通信方法，在ReactApplicationContext创建的时候存入注册表类JavaScriptModuleRegistry中，同时通过动态代理生成代理实例，并在代理拦截类JavaScriptModuleInvocationHandler中统一处理发向Javascript的所有通信请求。\n" +
                "\n" +
                "CatalystInstanceImpl类内部的ReactBridge具体实现与Javascript的通信请求，它是调用Bridge Jni 的出口。在ReactBridge被创建的时候会将JavaScriptModule信息表预先发给Javascript层用来生成映射表。\n" +
                "\n" +
                "2、C++层\n" +
                "\n" +
                "OnLoad是jni层的调用入口，注册了所有的native方法，其内部调用又都是通过CountableBridge来完成的，CountableBridge是Bridge的无实现子类，而在Bridge里面JSCExecutor才是真正的执行者。\n" +
                "\n" +
                "JSCExecutor将所有来自Java层的通信请求封装成Javascript执行语句，交给WebKit内核完成向Javascript层的调用。\n" +
                "\n" +
                "3、Javascript层\n" +
                "\n" +
                "BatchedBridge是Javascript层的调用入口，而其又是MessageQueue的伪装者。MessageQueue预先注册了所有能够接收通信请求的组件_callableModules ，同时也保存着来自Java层JavaScriptModule的两张映射表。\n" +
                "\n" +
                "接收通信请求时，先通过映射表确认具体请求信息，再确认Javascript组件是否可以被调用，最后通过apply方式完成执行。";

        setContentTextView(contentString+"\n\n\n"+contentString2);

//        gotoActivity("https://www.jianshu.com/p/bec040926db8");
        gotoActivity("https://reactnative.cn/docs/0.31/tutorial.html");


    }
}
