package interview.kotlin.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/13.
 */
public class DataStructureActivity extends BaseActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle("数据结构");

        String contentS = "\n" +
                "1、Collections\n" +
                "    API----This class consists exclusively of static methods that operate on or return collections. It contains polymorphic algorithms that operate on collections, \"wrappers\", which return a new collection backed by a specified collection, and a few other odds and ends.\n" +
                "\n" +
                "The methods of this class all throw a NullPointerException if the collections or class objects provided to them are null. \n" +
                "\n" +
                "2、List\n" +
                "    API----This class consists exclusively of static methods that operate on or return collections. It contains polymorphic algorithms that operate on collections, \"wrappers\", which return a new collection backed by a specified collection, and a few other odds and ends.\n" +
                "The methods of this class all throw a NullPointerException if the collections or class objects provided to them are null. \n" +
                "\n" +
                "List是有序的Collection，使用此接口能够精确的控制每个元素插入的位置。用户能够使用索引（元素在List中的位置，类似于数组下 >标）来访问List中的元素，这类似于Java的数组。\n" +
                "\n" +
                "3、Vector\n" +
                "     API----The Vector class implements a growable array of objects. Like an array, it contains components that can be accessed using an integer index. However, the size of aVector can grow or shrink as needed to accommodate adding and removing items after theVector has been created. \n" +
                "\n" +
                "基于数组（Array）的List，其实就是封装了数组所不具备的一些功能方便我们使用，所以它难易避免数组的限制，同时性能也不可能超越数组。所以，在可能的情况下，我们要多运用数组。另外很重要的一点就是Vector是线程同步的(sychronized)的，这也是Vector和ArrayList 的一个的重要区别。 \n" +
                "\n" +
                "\n" +
                "4、ArrayList\n" +
                "     API----Resizable-array implementation of the List interface. Implements all optional list operations, and permits all elements, includingnull. In addition to implementing theList interface, this class provides methods to manipulate the size of the array that is used internally to store the list. (This class is roughly equivalent toVector, except that it is unsynchronized.)\n" +
                "同Vector一样是一个基于数组上的链表，但是不同的是ArrayList不是同步的。所以在性能上要比Vector好一些，但是当运行到多线程环境中时，可需要自己在管理线程的同步问题。\n" +
                "\n" +
                "\n" +
                "5、LinkedList\n" +
                "     API----Linked list implementation of the List interface. Implements all optional list operations, and permits all elements (includingnull). In addition to implementing theList interface, the LinkedList class provides uniformly named methods toget, remove andinsert an element at the beginning and end of the list. These operations allow linked lists to be used as a stack,queue, ordouble-ended queue. \n" +
                "LinkedList不同于前面两种List，它不是基于数组的，所以不受数组性能的限制。 \n" +
                "它每一个节点（Node）都包含两方面的内容： \n" +
                "1.节点本身的数据（data）； \n" +
                "2.下一个节点的信息（nextNode）。 \n" +
                "所以当对LinkedList做添加，删除动作的时候就不用像基于数组的ArrayList一样，必须进行大量的数据移动。只要更改nextNode的相关信息就可以实现了，这是LinkedList的优势。\n" +
                "\n" +
                "List总结：\n" +
                "所有的List中只能容纳单个不同类型的对象组成的表，而不是Key－Value键值对。例如：[ tom,1,c ]\n" +
                "所有的List中可以有相同的元素，例如Vector中可以有 [ tom,koo,too,koo ]\n" +
                "所有的List中可以有null元素，例如[ tom,null,1 ]\n" +
                "     基于Array的List（Vector，ArrayList）适合查询，而LinkedList 适合添加，删除操作\n" +
                "1、Collections\n" +
                "    API----This class consists exclusively of static methods that operate on or return collections. It contains polymorphic algorithms that operate on collections, \"wrappers\", which return a new collection backed by a specified collection, and a few other odds and ends.\n" +
                "\n" +
                "The methods of this class all throw a NullPointerException if the collections or class objects provided to them are null. \n" +
                "\n" +
                "2、List\n" +
                "    API----This class consists exclusively of static methods that operate on or return collections. It contains polymorphic algorithms that operate on collections, \"wrappers\", which return a new collection backed by a specified collection, and a few other odds and ends.\n" +
                "The methods of this class all throw a NullPointerException if the collections or class objects provided to them are null. \n" +
                "\n" +
                "List是有序的Collection，使用此接口能够精确的控制每个元素插入的位置。用户能够使用索引（元素在List中的位置，类似于数组下 >标）来访问List中的元素，这类似于Java的数组。\n" +
                "\n" +
                "3、Vector\n" +
                "     API----The Vector class implements a growable array of objects. Like an array, it contains components that can be accessed using an integer index. However, the size of aVector can grow or shrink as needed to accommodate adding and removing items after theVector has been created. \n" +
                "\n" +
                "基于数组（Array）的List，其实就是封装了数组所不具备的一些功能方便我们使用，所以它难易避免数组的限制，同时性能也不可能超越数组。所以，在可能的情况下，我们要多运用数组。另外很重要的一点就是Vector是线程同步的(sychronized)的，这也是Vector和ArrayList 的一个的重要区别。 \n" +
                "\n" +
                "\n" +
                "4、ArrayList\n" +
                "     API----Resizable-array implementation of the List interface. Implements all optional list operations, and permits all elements, includingnull. In addition to implementing theList interface, this class provides methods to manipulate the size of the array that is used internally to store the list. (This class is roughly equivalent toVector, except that it is unsynchronized.)\n" +
                "同Vector一样是一个基于数组上的链表，但是不同的是ArrayList不是同步的。所以在性能上要比Vector好一些，但是当运行到多线程环境中时，可需要自己在管理线程的同步问题。\n" +
                "\n" +
                "\n" +
                "5、LinkedList\n" +
                "     API----Linked list implementation of the List interface. Implements all optional list operations, and permits all elements (includingnull). In addition to implementing theList interface, the LinkedList class provides uniformly named methods toget, remove andinsert an element at the beginning and end of the list. These operations allow linked lists to be used as a stack,queue, ordouble-ended queue. \n" +
                "LinkedList不同于前面两种List，它不是基于数组的，所以不受数组性能的限制。 \n" +
                "它每一个节点（Node）都包含两方面的内容： \n" +
                "1.节点本身的数据（data）； \n" +
                "2.下一个节点的信息（nextNode）。 \n" +
                "所以当对LinkedList做添加，删除动作的时候就不用像基于数组的ArrayList一样，必须进行大量的数据移动。只要更改nextNode的相关信息就可以实现了，这是LinkedList的优势。\n" +
                "\n" +
                "List总结：\n" +
                "所有的List中只能容纳单个不同类型的对象组成的表，而不是Key－Value键值对。例如：[ tom,1,c ]\n" +
                "所有的List中可以有相同的元素，例如Vector中可以有 [ tom,koo,too,koo ]\n" +
                "所有的List中可以有null元素，例如[ tom,null,1 ]\n" +
                "     基于Array的List（Vector，ArrayList）适合查询，而LinkedList 适合添加，删除操作\n" +
                "一、几个常用类的区别 \n" +
                "1．ArrayList: 元素单个，效率高，多用于查询 \n" +
                "2．Vector: 元素单个，线程安全，多用于查询 \n" +
                "3．LinkedList:元素单个，多用于插入和删除 \n" +
                "4．HashMap: 元素成对，元素可为空 \n" +
                "5．HashTable: 元素成对，线程安全，元素不可为空 \n" +
                "二、Vector、ArrayList和LinkedList \n" +
                "大多数情况下，从性能上来说ArrayList最好，但是当集合内的元素需要频繁插入、删除时LinkedList会有比较好的表现，但是它们三个性能都比不上数组，另外Vector是线程同步的。所以： \n" +
                "如果能用数组的时候(元素类型固定，数组长度固定)，请尽量使用数组来代替List； \n" +
                "如果没有频繁的删除插入操作，又不用考虑多线程问题，优先选择ArrayList； \n" +
                "如果在多线程条件下使用，可以考虑Vector； \n" +
                "如果需要频繁地删除插入，LinkedList就有了用武之地； \n" +
                "如果你什么都不知道，用ArrayList没错。 \n" +
                "三、Collections和Arrays \n" +
                "在 Java集合类框架里有两个类叫做Collections（注意，不是Collection！）和Arrays，这是JCF里面功能强大的工具，但初学者往往会忽视。按JCF文档的说法，这两个类提供了封装器实现（Wrapper Implementations）、数据结构算法和数组相关的应用。 \n" +
                "想必大家不会忘记上面谈到的“折半查找”、“排序”等经典算法吧，Collections类提供了丰富的静态方法帮助我们轻松完成这些在数据结构课上烦人的工作： \n" +
                "binarySearch：折半查找。 \n" +
                "sort：排序，这里是一种类似于快速排序的方法，效率仍然是O(n * log n)，但却是一种稳定的排序方法。 \n" +
                "reverse：将线性表进行逆序操作，这个可是从前数据结构的经典考题哦！ \n" +
                "rotate：以某个元素为轴心将线性表“旋转”。 \n" +
                "swap：交换一个线性表中两个元素的位置。 \n" +
                "…… \n" +
                "Collections还有一个重要功能就是“封装器”（Wrapper），它提供了一些方法可以把一个集合转换成一个特殊的集合，如下： \n" +
                "unmodifiableXXX：转换成只读集合，这里XXX代表六种基本集合接口：Collection、List、Map、Set、SortedMap和SortedSet。如果你对只读集合进行插入删除操作，将会抛出UnsupportedOperationException异常。 \n" +
                "synchronizedXXX：转换成同步集合。 \n" +
                "singleton：创建一个仅有一个元素的集合，这里singleton生成的是单元素Set， \n" +
                "singletonList和singletonMap分别生成单元素的List和Map。 \n" +
                "空集：由Collections的静态属性EMPTY_SET、EMPTY_LIST和EMPTY_MAP表示。 ";


        setContentTextView(contentS);

        gotoActivity("https://blog.csdn.net/u010947402/article/details/51878166");
        gotoActivity("https://blog.csdn.net/qq_29631809/article/details/72599708");


//        ValueAnimator
//        ObjectAnimator

    }
}
