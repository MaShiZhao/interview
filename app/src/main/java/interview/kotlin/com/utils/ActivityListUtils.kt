package interview.kotlin.com.utils

import java.util.Arrays

import interview.kotlin.com.activity.ActivityActivity
import interview.kotlin.com.activity.AidlActivity
import interview.kotlin.com.activity.Apk
import interview.kotlin.com.activity.DataStructureActivity
import interview.kotlin.com.activity.DesignPatternActivity
import interview.kotlin.com.activity.DrawableActivity
import interview.kotlin.com.activity.GCActivity
import interview.kotlin.com.activity.HashMapActivity
import interview.kotlin.com.activity.HttpActivity
import interview.kotlin.com.activity.NounActivity
import interview.kotlin.com.activity.OtherActivity
import interview.kotlin.com.activity.ReactNativeActivity
import interview.kotlin.com.activity.SystemActivity
import interview.kotlin.com.activity.VersionActivity
import interview.kotlin.com.activity.ViewActivity
import interview.kotlin.com.activity.XmlActivity
import interview.kotlin.com.aidl.BinderActivity
import interview.kotlin.com.all.AllActivity
import interview.kotlin.com.count.CountActivity
import interview.kotlin.com.interview.MainBean
import interview.kotlin.com.optimization.BatteryActivity
import interview.kotlin.com.optimization.MemoryOptimizationActivity
import interview.kotlin.com.sourcecode.GlideActivity
import interview.kotlin.com.sourcecode.OkhttpActivity
import interview.kotlin.com.start.StartAppActivity
import interview.kotlin.com.thread.AsyncTaskActivity
import interview.kotlin.com.thread.ThreadActivity
import interview.kotlin.com.thread.ThreadAndProcessActivity
import interview.kotlin.com.thread.ThreadExecutorActivity
import interview.kotlin.com.touch.TouchActivity

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * ActivityListUtils
 *
 *
 * 所有的activityList列表
 *
 * @author MaShiZhao
 * @version 1.0
 *
 *
 * Ver 1.0, 2019-05-10, MaShiZhao, Create file
 */
object ActivityListUtils {

    val ACTIVITY_LIST: MutableList<MainBean> = Arrays.asList(
            MainBean("汇总", AllActivity::class.java),
            MainBean("线程", ThreadActivity::class.java),
            MainBean("应用启动", StartAppActivity::class.java),
            MainBean("进程和线程区别", ThreadAndProcessActivity::class.java),
            MainBean("线程池", ThreadExecutorActivity::class.java),
            MainBean("名词释义", NounActivity::class.java),
            MainBean("底层架构", SystemActivity::class.java),
            MainBean("AIDL", AidlActivity::class.java),
            MainBean("Binder", BinderActivity::class.java),
            MainBean("内存优化", MemoryOptimizationActivity::class.java),
            MainBean("电量优化", BatteryActivity::class.java),
            MainBean("http", HttpActivity::class.java),
            MainBean("View", ViewActivity::class.java),
            MainBean("XML 解析", XmlActivity::class.java),
            MainBean("GC", GCActivity::class.java),
            MainBean("hash", HashMapActivity::class.java),
            MainBean("touch", TouchActivity::class.java),
            MainBean("AsyncTask", AsyncTaskActivity::class.java),
            MainBean("Version", VersionActivity::class.java),
            MainBean("OkHttp", OkhttpActivity::class.java),
            MainBean("Glide", GlideActivity::class.java),
            MainBean("ReactNative", ReactNativeActivity::class.java),
            MainBean("APK", Apk::class.java),
            MainBean("算法", CountActivity::class.java),
            MainBean("数据机构", DataStructureActivity::class.java),
            MainBean("设计模式", DesignPatternActivity::class.java),
            MainBean("drawable", DrawableActivity::class.java),
            MainBean("生命周期", ActivityActivity::class.java),
            MainBean("随手记", OtherActivity::class.java))


    val ALL_ACTIVITY_LIST: MutableList<MainBean> = Arrays.asList(
            MainBean("java基础面试知识点", ""),
            MainBean("java中==和equals和hashCode的区别", "https://www.2cto.com/kf/201804/740402.html"),
            MainBean("Object类的equal和hashCode方法重写，为什么?", "https://www.jianshu.com/p/55626bec6b89"),
            MainBean("int、char、long各占多少字节数", "https://blog.csdn.net/qq_31615049/article/details/80574551"),
            MainBean("Int与Integer的区别", "https://www.cnblogs.com/bigdata-stone/p/10560759.html"),
            MainBean("Java 多态", "https://www.runoob.com/java/java-polymorphism.html"),
            MainBean("Java 多态机制", "https://blog.csdn.net/github_37130188/article/details/89931885"),
            MainBean("String、StringBuffer、StringBuilder区别", "https://blog.csdn.net/cxfjava/article/details/82882481"),
            MainBean("单例模式", "https://blog.csdn.net/mnb65482/article/details/80458571"),
            MainBean("内部类", "https://blog.csdn.net/yy471101598/article/details/88990500"),
            MainBean("匿名内部类", "https://blog.csdn.net/hellocsz/article/details/81974251"),
            MainBean("闭包", "https://blog.csdn.net/yztbydh/article/details/76270708#java%E4%B8%AD%E7%9A%84%E9%97%AD%E5%8C%85"),
            MainBean("JAVA 内部类与闭包", "https://blog.csdn.net/weixin_30273763/article/details/99046921"),
            MainBean("抽象类和接口区别", "https://www.cnblogs.com/catluo/p/10803970.html"),
            MainBean("抽象类的意义", "https://blog.csdn.net/qdh186/article/details/79704852"),
            MainBean("接口意义", "https://blog.csdn.net/Caide3/article/details/68490883"),
            MainBean("Java泛型中extends和super的区别", "https://blog.csdn.net/qq_40395278/article/details/88603655"),
            MainBean("父类的静态方法能否被子类重写", "https://www.jianshu.com/p/15e21428d884"),
            MainBean("说说进程和线程的区别", "https://www.cnblogs.com/zhehan54/p/6130030.html"),
            MainBean("final,finally,finalize有什么区别", "https://blog.csdn.net/happy_coding_life/article/details/80588316"),
            MainBean("序列化", "https://www.jianshu.com/p/7298f0c559dc"),
            MainBean("Serializable 和 Parcelable", "https://blog.csdn.net/hacker_crazy/article/details/80840868"),
            MainBean("如何将一个Java对象序列化到文件里 ", "https://www.jianshu.com/p/cb970e5cd5b8"),
            MainBean("静态  被继承？ 被重写？以及原因？", "https://www.jianshu.com/p/2ddaff2d4591"),
            MainBean("静态内部类的设计意图", "https://blog.csdn.net/github_37130188/article/details/94589793"),
            MainBean("kotlin 理解", "https://www.cnblogs.com/bluestorm/p/8965649.html"),
            MainBean("string 转换成 integer的方式及原理", "https://www.jianshu.com/p/9eebb4f2ccb1"),
            MainBean("java深入源码级的面试题", ""),
            MainBean("java深入源码级的面试题", ""),
            MainBean("java深入源码级的面试题", ""),
            MainBean("Java堆、栈和方法区", "https://blog.csdn.net/dpengwang/article/details/81530296"),
            MainBean("JVM常见垃圾回收算法与Java堆 新生代、老年代", "https://blog.csdn.net/weixin_28760063/article/details/81271611"),
            MainBean("GC Roots", "https://blog.csdn.net/KyleYang2016/article/details/79459050"),
            MainBean("StackOverflowError OutOfMemoryError", "https://blog.csdn.net/zc375039901/article/details/79179465"),
            MainBean("Java 内存管理", "https://www.cnblogs.com/lyf906522290/p/8350756.html"),
            MainBean("堆和栈在内存中的区别是什么", "https://blog.csdn.net/qq_34803821/article/details/87717205"),
            MainBean("讲一下常见编码方式", "https://www.jianshu.com/p/54a3b6988368"),
            MainBean("静态代理、动态代理", "https://blog.csdn.net/asd051377305/article/details/80490432"),
            MainBean("深入理解Java中异常体系", "https://blog.csdn.net/zhanaolu4821/article/details/81012382#commentBox"),
            MainBean("解析与分派", "https://blog.csdn.net/u011080472/article/details/51334288"),
            MainBean("反射", "https://www.jianshu.com/p/9be58ee20dee"),
            MainBean("注解", "https://blog.csdn.net/zhenliangit0918/article/details/81427994"),
            MainBean("依赖注入", "https://www.cnblogs.com/universal/p/10415462.html"),
            MainBean("泛型理解", "https://www.jianshu.com/p/6ec45a6da9ba"),
            MainBean("String 源码", "https://www.cnblogs.com/xiaoxi/p/6036701.html"),
            MainBean("String 不可变", "https://blog.csdn.net/jiahao1186/article/details/81150912"),
            MainBean("数据结构", ""),
            MainBean("数据结构", ""),
            MainBean("数据结构", ""),
            MainBean("常用数据结构简介", "https://blog.csdn.net/TING9423/article/details/88785033"),
            MainBean("并发集合了解哪些？", "https://blog.csdn.net/u010942020/article/details/73610121"),
            MainBean("java的集合以及集合之间的继承关系", "https://blog.csdn.net/github_37130188/article/details/95110737"),
            MainBean("Java常见的容器类及其区别", "https://blog.csdn.net/qq_37465368/article/details/80854672"),
            MainBean("ConcurrentHashMap的实现原理", "https://www.cnblogs.com/technologykai/articles/10966606.html"),
            MainBean("HashMap与ArrayMap(和SparseArray)的比较与选择", "https://www.cnblogs.com/yibutian/p/9626251.html"),
            MainBean("HashSet与HashMap的区别", "https://www.cnblogs.com/codercui/p/6841730.html"),
            MainBean("二叉树的深度优先和广度优先遍历", "https://blog.csdn.net/XTAOTWO/article/details/83625586"),
            MainBean("堆", "https://www.jianshu.com/p/6b526aa481b1"),
            MainBean("堆 二叉树", "https://blog.csdn.net/lifei128/article/details/82392940"),
            MainBean("B+树 红黑树", "https://www.cnblogs.com/myseries/p/10662710.html"),
            MainBean("图", "https://blog.csdn.net/zhaozigu123/article/details/79283616"),
            MainBean("深拷贝和浅拷贝", "https://www.cnblogs.com/shakinghead/p/7651502.html"),
            MainBean("手写链表逆序代码", "https://blog.csdn.net/yubing1015/article/details/92786307"),
            MainBean("判断单链表成环与否", "https://blog.csdn.net/wxgxgp/article/details/82528999"),
            MainBean("合并多个单有序链表", "https://blog.csdn.net/github_37130188/article/details/99492588"),
            MainBean("线程、多线程和线程池", ""),
            MainBean("线程、多线程和线程池", ""),
            MainBean("线程、多线程和线程池", ""),
            MainBean("启动线程方式", "https://www.cnblogs.com/xiufengchen/p/10655846.html"),
            MainBean("runnable和callable区别", "https://www.iteye.com/blog/uule-1488270"),
            MainBean("start run 区别", "https://blog.csdn.net/weixin_43258908/article/details/89228353"),
            MainBean("线程与进程的区别？", "https://www.cnblogs.com/mrwuzs/p/7976607.html"),
            MainBean("某个方法允许并发访问线程的个数", "https://www.jianshu.com/p/9a831edfdf25"),
            MainBean("Java中wait和sleep方法的区别", "https://www.cnblogs.com/loren-Yang/p/7538482.html"),
            MainBean("线程阻塞", "https://www.jianshu.com/p/b1aea12e62fd"),
            MainBean("线程终止 3种", "https://www.cnblogs.com/liyutian/p/10196044.html"),
            MainBean("线程同步的7种方法", "https://blog.csdn.net/scgyus/article/details/79499650"),
            MainBean("Java中如何保证线程安全性\n", "https://blog.csdn.net/u013412772/article/details/80109727"),
            MainBean("Java多线程处理List数据", "https://www.cnblogs.com/huangdabing/p/9251598.html"),
            MainBean("Java 中对象的生命周期", "https://www.jianshu.com/p/780f4c133c52"),
            MainBean("synchronized的四种用法", "https://www.cnblogs.com/lukelook/p/9946065.html"),
            MainBean("synchronized 原理", "https://www.cnblogs.com/wuzhenzhao/p/10250801.html"),
            MainBean("synchronized和synchronized static", "https://blog.csdn.net/qianyiyiding/article/details/77926888"),
            MainBean("同一个类里面两个synchronized方法，两个线程同时访问的问题", "https://blog.csdn.net/niusi1288/article/details/76143276"),
            MainBean("volatile 基础介绍", "https://www.jianshu.com/p/ccfe24b63d87"),
            MainBean("volatile synchronized 区别", "https://blog.csdn.net/huideveloper/article/details/80632111"),
            MainBean("synchronized Lock 区别", "https://www.cnblogs.com/iyyy/p/7993788.html"),
            MainBean("ReentrantLock的内部实现", "https://www.cnblogs.com/huangqingshi/p/10507618.html"),
            MainBean("死锁的四个必要条件和解决办法", "https://blog.csdn.net/guaiguaihenguai/article/details/80303835"),
            MainBean("数据结构", "https://www.cnblogs.com/mseddl/p/11633405.html"),
            MainBean("线程池 ", "https://www.cnblogs.com/lsw9/p/9066528.html"),
            MainBean("多线程理解", "https://www.cnblogs.com/q964024886/p/10763934.html"),
            MainBean("Java 多线程文件读写操作怎么保证并发安全", "https://www.jianshu.com/p/89cad15fff31"),
            MainBean("断点续传。。", "https://www.cnblogs.com/dabai56/p/11221387.html"),
            MainBean("Android基础知识点", ""),
            MainBean("Android基础知识点", ""),
            MainBean("Android基础知识点", ""),
            MainBean("四大组件", "https://blog.csdn.net/qq_33344311/article/details/79828299"),
            MainBean("ContentProvider", "https://www.jianshu.com/p/5e13d1fec9c9"),
            MainBean("ContentProvider、ContentResolver、ContentObserver 之间", "https://www.jianshu.com/p/4e3785fe37cf"),
            MainBean("广播", "https://www.jianshu.com/p/7b44d983c01a"),
            MainBean("横竖屏切换，生命周期", "https://www.jianshu.com/p/8c40829905ec"),
            MainBean("activity fragment 生命周期", "https://blog.csdn.net/github_37130188/article/details/89199363"),
            MainBean("两个Activity之间跳转", "https://blog.csdn.net/mangshidai/article/details/80961081"),
            MainBean("Activity的四种启动模式和应用场景", "https://blog.csdn.net/suyimin2010/article/details/85916525"),
            MainBean("Android状态保存与恢复流程", "https://www.jianshu.com/p/58579627f70a"),
            MainBean("Fragment 在各种情况下的生命周期", "https://blog.csdn.net/ya1139569539/article/details/78192112"),
            MainBean("startActivityForResult在FragmentActivity和Fragment中的异同\n", "https://blog.csdn.net/barryhappy/article/details/53229238"),
            MainBean("fragment之间传递数据的方式\n", "https://blog.csdn.net/github_37130188/article/details/89222533"),
            MainBean("Activity与Service", "https://www.jianshu.com/p/64f7cff35e5f"),
            MainBean("AlertDialog,popupWindow,Activity", "https://blog.csdn.net/wenxustqiang/article/details/79758165"),
            MainBean("context ", "https://www.cnblogs.com/ganchuanpu/p/6445251.html"),
            MainBean("SurfaceView ", "https://www.cnblogs.com/aademeng/articles/10927468.html"),
            MainBean("图片库对比", "https://www.jianshu.com/p/44a4ee648ab4"),
            MainBean("getExternalStorageDirectory getExternalFilesDir getExternalCacheDir", "https://blog.csdn.net/nugongahou110/article/details/48154859"),
            MainBean("RxJava", "https://www.jianshu.com/p/e1c48a00951a"),
            MainBean("ARouter原理剖析", "https://www.jianshu.com/p/8098961bd30c"),
            MainBean("LruCache", "https://www.jianshu.com/p/b49a111147ee"),
            MainBean("图片加载原理", "https://www.jianshu.com/p/0f307486e87f"),
            MainBean("网络和安全机制", ""),
            MainBean("网络和安全机制", ""),
            MainBean("网络和安全机制", ""),
            MainBean("网络框架对比", "https://blog.csdn.net/lzhang616/article/details/54601987"),
            MainBean("OkHttp 网络缓存", "https://blog.csdn.net/weixin_40255793/article/details/81018358"),
            MainBean("从网络加载一个10M的图片，说下注意事项", "https://blog.csdn.net/github_37130188/article/details/89442013"),
            MainBean("TCP的三次握手与四次挥手", "https://blog.csdn.net/qq_38950316/article/details/81087809"),
            MainBean("TCP UDP", "https://www.cnblogs.com/liangyc/p/11628208.html"),
            MainBean("http http2.0 https", "https://www.cnblogs.com/heluan/p/8620312.html"),
            MainBean("http 请求头", "https://www.cnblogs.com/ldq2016/p/9055933.html"),
            MainBean("详解HTTPS是如何确保安全性的？", "https://blog.csdn.net/liuchaoxuan/article/details/81878219"),
            MainBean("https 加密算法", "https://blog.csdn.net/github_37130188/article/details/89463137"),
            MainBean("数字证书", "https://www.cnblogs.com/funny11/p/6978908.html"),
            MainBean("WebSocket", "https://blog.csdn.net/github_37130188/article/details/89463183"),
            MainBean("socket http", "https://www.cnblogs.com/zhangqing979797/p/10553974.html"),
            MainBean("签名", "https://blog.csdn.net/niyingxunzong/article/details/79977580#%E4%B8%80%E6%A6%82%E8%BF%B0"),
            MainBean("App 是如何沙箱化", "https://blog.csdn.net/ljheee/article/details/53191397"),
            MainBean("Android应用程序权限机制的源代码分析", "https://blog.csdn.net/gan303/article/details/50669035"),
            MainBean("四种权限", "https://blog.csdn.net/self_study/article/details/50074781"),
            MainBean("权限源码", "https://blog.csdn.net/gan303/article/details/50669035 "),
            MainBean("数据库", ""),
            MainBean("数据库", ""),
            MainBean("数据库", ""),
            MainBean("开源数据库对比", "https://blog.csdn.net/qq_32365567/article/details/89532828"),
            MainBean("数据库迁移", "https://blog.csdn.net/zytygq/article/details/80139881"),
            MainBean("优化数据库", "https://www.cnblogs.com/wytiger/p/10730596.html"),
            MainBean("算法", ""),
            MainBean("排序算法", "https://www.cnblogs.com/guoyaohua/p/8600214.html"),
            MainBean("快速", "https://blog.csdn.net/shujuelin/article/details/82423852"),
            MainBean("堆算法", "https://www.cnblogs.com/MOBIN/p/5374217.html"),
            MainBean("阿里员工", "https://www.cnblogs.com/mataoblogs/p/10713954.html"),
            MainBean("GC算法", "https://www.jianshu.com/p/3fc4450e1bbd"),
            MainBean("bitmap计算公式", "https://blog.csdn.net/qq_30993595/article/details/84109226"),
            MainBean("插件化、模块化、组件化、热修复、增量更新、Gradle", ""),
            MainBean("插件化、模块化、组件化、热修复、增量更新、Gradle", ""),
            MainBean("插件化、模块化、组件化、热修复、增量更新、Gradle", ""),
            MainBean("Android热修复原理解析", "https://www.jianshu.com/p/e179fcc97666"),
            MainBean("全面插件化RePlugin流程与源码解析", "https://www.jianshu.com/p/18530be5dcdd"),
            MainBean("AS编译流程", "https://www.jianshu.com/p/4b655aca4f47"),
            MainBean("APK解压内容", "https://blog.csdn.net/qu213/article/details/9629883"),
            MainBean("设计模式", ""),
            MainBean("设计模式", ""),
            MainBean("设计模式", ""),
            MainBean("设计模式", "https://www.cnblogs.com/wanglijun/p/10927310.html"),
            MainBean("生产者/消费者模式", "https://www.jianshu.com/p/de683751dcef"),
            MainBean("适配器模式，装饰者模式，外观模式的异同", "https://blog.csdn.net/github_37130188/article/details/89762810"),
            MainBean("EventBus的使用及原理解析", "https://www.jianshu.com/p/56540e07416a"),
            MainBean("状态机", "https://www.jianshu.com/p/8def04b34b3c"),
            MainBean("Binder", "https://blog.csdn.net/github_37130188/article/details/89788478"),
            MainBean("性能优化", ""),
            MainBean("性能优化", ""),
            MainBean("性能优化", ""),
            MainBean("性能优化", "https://blog.csdn.net/zhangbijun1230/article/details/79449725"),
            MainBean("AS Profile ", "https://blog.csdn.net/Double2hao/article/details/78784758"),
            MainBean("Java多线程引发的性能问题以及调优策略", "https://blog.csdn.net/luofenghan/article/details/78596950#%E9%81%BF%E5%85%8D%E5%90%8C%E6%AD%A5"),
            MainBean("APP启动优化", "https://blog.csdn.net/yuanguozhengjust/article/details/80052066"),
            MainBean("自定义View", "https://www.jianshu.com/p/9862cddca1b3"),
            MainBean("ListView和RecycleView", "https://blog.csdn.net/chehec2010/article/details/83899001"),
            MainBean("NDK JNI ", "https://www.jianshu.com/p/87ce6f565d37"),
            MainBean("ART", "https://blog.csdn.net/github_37130188/article/details/89577492"),
            MainBean("安装流程", "https://blog.csdn.net/github_37130188/article/details/89577635"),
            MainBean("保活APP", "https://blog.csdn.net/byeweiyang/article/details/80124770"),
            MainBean("Android Version 适配", "https://www.jianshu.com/p/310c69bdacef"),
            MainBean("Version 10.0", "https://blog.csdn.net/weixin_40611659/article/details/95174124"),
            MainBean("Framework", ""),
            MainBean("Framework", ""),
            MainBean("Framework", ""),
            MainBean("PMS", "https://www.jianshu.com/p/cb0555d62b9c"),
            MainBean("WMS", "http://liuwangshu.cn/framework/wm/1-windowmanager.html"),
            MainBean("窗口添加view", "https://blog.csdn.net/sxj159753/article/details/92445660"),
            MainBean("怎么保证并发安全", "cad15fff31"),
            MainBean("怎么保证并发安全", "cad15fff31"),
            MainBean("怎么保证并发安全", "cad15fff31")

    )
}
