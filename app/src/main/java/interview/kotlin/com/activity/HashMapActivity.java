package interview.kotlin.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/16.
 */

public class HashMapActivity extends BaseActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("HashMap");

        String contentS = "\n" +
                "HashMap的工作原理\n" +
                "HashMap基于hashing原理，我们通过put()和get()方法储存和获取对象。当我们将键值对传递给put()方法时，它调用键对象的hashCode()方法来计算hashcode，让后找到bucket位置来储存值对象。当获取对象时，通过键对象的equals()方法找到正确的键值对，然后返回值对象。HashMap使用链表来解决碰撞问题，当发生碰撞了，对象将会储存在链表的下一个节点中。 HashMap在每个链表节点中储存键值对对象。\n" +
                "\n" +
                "当两个不同的键对象的hashcode相同时会发生什么？ 它们会储存在同一个bucket位置的链表中。键对象的equals()方法用来找到键值对。\n" +
                "\n" +
                "因为HashMap的好处非常多，我曾经在电子商务的应用中使用HashMap作为缓存。因为金融领域非常多的运用Java，也出于性能的考虑，我们会经常用到HashMap和ConcurrentHashMap";

        String contentS2 = "\n" +
                "在覆盖equals方法的时候，你必须要遵守它的通用约定。下面是约定的内容，来自Object的规范[JavaSE6] \n" +
                "自反性。对于任何非null的引用值x，x.equals(x)必须返回true。\n" +
                "对称性。对于任何非null的引用值x和y，当且仅当y.equals(x)返回true时，x.equals(y)必须返回true\n" +
                "传递性。对于任何非null的引用值x、y和z，如果x.equals(y)返回true，并且y.equals(z)也返回true，那么x.equals(z)也必须返回true。\n" +
                "一致性。对于任何非null的引用值x和y，只要equals的比较操作在对象中所用的信息没有被修改，多次调用该x.equals(y)就会一直地返回true，或者一致地返回false。";


        String contentS3 = "HashSet和HashMap的区别\n" +
                "*HashMap*\t*HashSet*\n" +
                "HashMap实现了Map接口\tHashSet实现了Set接口\n" +
                "HashMap储存键值对\tHashSet仅仅存储对象\n" +
                "使用put()方法将元素放入map中\t使用add()方法将元素放入set中\n" +
                "HashMap中使用键对象来计算hashcode值\tHashSet使用成员对象来计算hashcode值，对于两个对象来说hashcode可能相同，所以equals()方法用来判断对象的相等性，如果两个对象不同的话，那么返回false\n" +
                "HashMap比较快，因为是使用唯一的键来获取对象\tHashSet较HashMap来说比较慢\n\n\n" +
                "HashMap和Hashtable的区别\n" +
                "HashMap和Hashtable都实现了Map接口，但决定用哪一个之前先要弄清楚它们之间的分别。主要的区别有：线程安全性，同步(synchronization)，以及速度。\n" +
                "\n" +
                "HashMap几乎可以等价于Hashtable，除了HashMap是非synchronized的，并可以接受null(HashMap可以接受为null的键值(key)和值(value)，而Hashtable则不行)。\n" +
                "HashMap是非synchronized，而Hashtable是synchronized，这意味着Hashtable是线程安全的，多个线程可以共享一个Hashtable；而如果没有正确的同步的话，多个线程是不能共享HashMap的。Java 5提供了ConcurrentHashMap，它是HashTable的替代，比HashTable的扩展性更好。\n" +
                "另一个区别是HashMap的迭代器(Iterator)是fail-fast迭代器，而Hashtable的enumerator迭代器不是fail-fast的。所以当有其它线程改变了HashMap的结构（增加或者移除元素），将会抛出ConcurrentModificationException，但迭代器本身的remove()方法移除元素则不会抛出ConcurrentModificationException异常。但这并不是一个一定发生的行为，要看JVM。这条同样也是Enumeration和Iterator的区别。\n" +
                "由于Hashtable是线程安全的也是synchronized，所以在单线程环境下它比HashMap要慢。如果你不需要同步，只需要单一线程，那么使用HashMap性能要好过Hashtable。\n" +
                "HashMap不能保证随着时间的推移Map中的元素次序是不变的。" +
                "\n\n\n";

        String contentS4 = "死循环transfer  put 丢失数据\n" +
                "ConcurrentHashMap \n" +
                "1.6 Segment数组和HashEntry数组组成。\n" +
                "jdk1.8 table数组＋单向链表＋红黑树 synchronized node \n";

        String contentS5 = "indexFor\n 初始化容量为2的次幂 二进制与操作效率快 避免空间浪费 节省空间";

        setContentTextView(contentS + "\n\n\n" + contentS2 + "\n\n\n" + contentS3 + "\n\n\n" + contentS4 + "\n\n\n" + contentS5);

        gotoActivity("http://www.importnew.com/7099.html");
        gotoActivity("http://www.importnew.com/23610.html");

    }
}
