package interview.kotlin.com.optimization;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.baseActivity.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/10.
 */
public class BatteryActivity extends BaseActivity
{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState   )
    {
        super.onCreate(savedInstanceState);
        setTitle("Battery");

        String contentS ="耗电原因具体有一下几个主要方面\n" +
                "http请求(GZIP压缩)\n" +
                "json数据解析(json解析效率主要是解析耗时)，大量的数据解析\n" +
                "3.数据库读写操作\n" +
                "4.SD卡读写操作\n" +
                "5.程序的执行的timer定时器（例如IM中的心跳包，用系统的Alarm优化）\n" +
                "6.网络切换（wifi会比手机的数据移动网络更加省电）";


        String contentS2 ="针对以上几个问题的优化方案\n" +
                "1.http请求可以采用gzip压缩减少传输过程中的数据量，app发起http请求和服务端返回的http请求数据都采用gzip压缩\n" +
                "2.json解析，网上有很多json解析的jar包，比较流行的有fast jackson，jackson，gson，目前我项目中用的是jackson，因为jackson解析效率相当高，基本是gson的十倍，当然是在大数据的情况下才能体现出差异，但是我用traceview跟了下jackson解析和android中的JsonObject解析的方法耗时发现jackson方法解析耗时少，同理可以推测jackson解析的方法耗时也应该是比较少的，既然方法耗时少了，那么从表面上看jackson的方法耗电也应该是最小的，不过jackson的jar比较大，gson的jar包很小而且使用接口方便，不过我还是推荐使用jackson，因为它可以动态解析bean，无论bean新增字段或者删除字段，jackson都能正常解析而不报错，目前位置其他的json解析jar貌似没有做到代码级别的动态，最多是使用注解，因此我还是推荐使用jackson\n" +
                "3.项目开发中对于数据库的操作我不推荐直接使用sqlite来写，这样的可维护性太差太差了，你想想，sqlite书关系型数据库，既然是关系型，那就会有比较复杂的数据表之间的关系，难道我们要对每一次的数据表操作都自己写sql语句吗？开发效率巨低！经过评估我们开发项目中用的是ormlite，两种考量：第一，我以前做j2ee开发，ormlite的接口很符合做j2ee的人上手；第二，ormlite网上有一个数据库加密的方法，如果后期对数据库加密就可直接挪过来用；但是问题来了，ormlite里面大量采用java反射来实现，所以从严格意义上考虑，函数执行耗时就上去了，耗电量也会增加，这时候我们就要对app端的数据库做比较严格系统的设计，就像设计服务器数据库一样（采用三范式，尽量优化数据表设计，避免冗余字段，避免冗余表），我个人不建议采用外键，每个数据表采用主键就够了，至于数据表之间的关系用代码来控制，如果app的数据表设计的比较优秀，那么采用ormlite就方便了，ormlite带来的好处将会大大超过因为它造成的一些性能，耗电问题，最大的好处就是数据库维护清晰明了\n" +
                "4.SD卡读写，尽量减少SD卡读写操作，包括SharedPreferences，能保存在内存中的尽量保存在内存中，不用害怕内存爆掉，内存绝对不会因为多存了几十个变量而溢出的，如果你需要保存到SD卡的数据很多那只能说你的App设计有问题，建议重新理下App的编码设计或者是功能设计\n" +
                "5.java语言中的timer是采用线程实现的，只要是手机不休眠就会一直跑，所以我们应该尽量采用系统那种Alarm来实现上述功能，例如心跳包，我见过网上的IM的SDK的心跳包基本都是采用系统闹钟加上广播实现的，而且timer和handler有一个弊端，在手机休眠的时候这两个的执行是被挂起的，当时候不休眠的时候它们才会继续计时执行，而系统那种即使在手机休眠的时候也会保持在指定时间点唤醒cpu执行操作，结束后再进入休眠，也就是说系统的alarm只有在计时到的那个时间点才会执行，而timer计时是在计时过程中一直跑，我看timer实现的源码是用while(true)循环来检测是否到时间点，没到就wait，并且continue\n" +
                "6.我问大神，大神说手机数据流量网比wifi更加耗电，因为手机数据流量会调用手机上面的一些硬件设备，从而唤醒cpu增加耗电，这个跟开启摄像头，开启gps是一样的，一设计调用硬件设备的绝对唤醒cpu，一唤醒cpu耗电绝对增加";

        String contentS3 = "top命令\n" +
                "在adb shell中使用top命令可以列出系统中的所有进程及其CPU使用率，当APP进程的CPU使用率超过1%的时候，都是耗电比较大的了，正常情况下应该处于0%的值，实际上应该是0点几。对于这个命令，我经常使用的是top -m 5，只要列出前5个使用率最高的进程就够了，一般只有前5个才会有超过%1的CPU占用率。当APP进程的CPU占用率一直低于1%的时候，或者你想定位问题所在的时候，下面更精细的方法可以帮你捕捉到问题的所在。\n" +
                "\n" +
                "DDMS工具Update Thread功能\n" +
                "当我们在DDMS工具中针对某个APP进程使用Update Thread功能的时候，会弹出一个窗口，这个窗口上显示了进程中所有线程的列表，还有CPU在其用户空间运行时间utime和系统空间运行时间stime，这个列表每隔几秒就会更新一次。我们要做的就是观察哪个线程的utime和stime的数据增长得快，增长得快表示这个线程占用了比较多的CPU资源，我们就可以具体查看是哪些代码在运行导致耗电高。一点经验：RenderThread增长得快一般是动画导致的。\n" +
                "\n" +
                "dumpsys batterystats";
        setContentTextView(contentS+"\n\n\n"+contentS2+"\n\n\n"+contentS3);

        gotoActivity("https://blog.csdn.net/lhd201006/article/details/50546847");
    }
}
