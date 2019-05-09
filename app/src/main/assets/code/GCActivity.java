package interview.msz.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.msz.com.baseActivity.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/16.
 */
public class GCActivity extends BaseActivity
{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("GC垃圾回收机制");


        String contentS = "1.年轻代(Young generation) 分Eden 和 Survivor（From,To）\n" +
                "2.成熟代(Tenured generation)\n" +
                "3.永久带(permanent generation)\n" +
                "年轻带采用 “Copy and Sweep” 的方式管理内存，对象不是直接被回收而是活着的对象被Copy到活的区域，死的对象留在了死的区域。第一轮追踪完之后活着的对象会被Copy到Survivor区域。而”死区“会被清零（Sweep），留在这里的对象也被一并清空了。\n" +
                "\n" +
                "如果一个对象多次被Copy的话，会进入到成熟代，这个地方采用新的回收算法\"Mark and Sweep\"， 一轮追踪之后活着的对象会被标记，随后JVM扫描整个堆，完成剩余对象（没有被标记的对象）的回收。\n" +
                "\n" +
                "永久带一般存放类的信息，不会被回收。\n" +
                "1.新创建一个对象，默认是分在Eden区域，当Eden区域内存不够的时候，会触发一次Min\n" +
                "or GC(新生代回收)，这次回收将存活的对象放到Survivor A区域，然后新的对象继续放在Eden区域\n" +
                "\n" +
                "2.再创建一个新的对象，要是Eden区域又不够了，再次触发Minor GC，这个时候会把Eden区域的存活对象以及\n" +
                "Survivor A区域的存活的对象移动到Survivor B区域，然后清空Eden区域以及Survivor A区域\n" +
                "\n" +
                "3.如果继续有新的对象创建，不断触发Minor GC，有些对象就会不断在Survivor A区域以及Survivor B区域\n" +
                "来回移动，但移动次数超过15次后，这些对象就会被移动到老年代区域\n" +
                "\n" +
                "4.如果新的对象在Minor GC后还是放不下，就直接放到老年代\n" +
                "\n" +
                "5.如果Survivor区域放不下该对象，这直接放到老年代\n" +
                "\n" +
                "6.如果老年代也满了，就会触发一次Full GC(major gc)\n" +
                "\n" +
                "1.对于新生代区域采用复制算法，因为新生代中每次垃圾回收都要回收大部分对象，" +
                "\n" +
                "那么也就意味着复制次数比较少，因此采用复制算法更高效\n" +
                "\n" +
                "2.而老年代区域的特点是每次回收都只能回收很少的对象，一般使用的是标记整理或者标记清除算法\n" +
                "\n\n" +
                "1.标记清除算法(Mark-Sweep)\n" +
                "\n" +
                "2.复制算法(Copying)\n" +
                "\n" +
                "3.标记整理算法(Mark-Compact)\n" +
                "\n" +
                "4.分代回收算法"
                ;


        setContentTextView(contentS);

        gotoActivity("https://www.jianshu.com/p/4b6adee12682");

    }



}
