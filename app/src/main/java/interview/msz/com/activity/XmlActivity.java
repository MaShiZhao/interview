package interview.msz.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.msz.com.baseActivity.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/13.
 */
public class XmlActivity extends BaseActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle("Xml");

        String contentS = "2.1 SAX\n" +
                "SAX(Simple API for XML) 使用流式处理的方式，它并不记录所读内容的相关信息。\n" +
                "\n" +
                "它是一种以事件为驱动的XML API，解析速度快，占用内存少。使用回调函数来实现。\n" +
                "\n" +
                "缺点是不能倒退。\n" +
                "\n" +
                "2.2 DOM\n" +
                "DOM(Document Object Model) 是一种用于XML文档的对象模型，可用于直接访问 XML 文档的各个部分。\n" +
                "\n" +
                "它是一次性全部将内容加载在内存中，生成一个树状结构,它没有涉及回调和复杂的状态管理。\n" +
                "\n" +
                "缺点是加载大文档时效率低下。\n" +
                "\n" +
                "2.3 PULL\n" +
                "Pull 内置于 Android 系统中。也是官方解析布局文件所使用的方式。\n" +
                "\n" +
                "Pull 与 SAX 有点类似，都提供了类似的事件，如开始元素和结束元素。\n" +
                "\n" +
                "不同的是，SAX 的事件驱动是回调相应方法，需要提供回调的方法，而后在 SAX 内部自动调用相应的方法。\n" +
                "\n" +
                "而Pull解析器并没有强制要求提供触发的方法。因为他触发的事件不是一个方法，而是一个数字。它使用方便，效率高。";


        String contentS2 = "1. 新建 ContentHanlder 类继承 DefaultHandler 类，并重写父类的五个方法\n" +
                "\n" +
                "startDocument(): 开始解析XML时调用 \n" +
                "startElement(): 开始解析某个结点时调用 \n" +
                "characters(): 在获取节点内容时调用 \n" +
                "endElement(): 在完成解析某个结点时调用 \n" +
                "endDocument(): 在完成整个XML解析的时候调用\n" +
                "\n" +
                "2.创建函数 parseXMLWithSAX \n" +
                "3.调用函数 parseXMLWithSAX 解析 XML\n" +
                "\n" +
                "2. Pull 方式解析\n" +
                "PULL解析器的运行方式和SAX类似，都是基于事件的模式。不同的是，在PULL解析过程中返回的是数字，且我们需要自己获取产生的事件然后做相应的操作，而不像SAX那样由处理器触发一种事件的方法，执行我们的代码。 " +
                "读取到xml的声明返回 START_DOCUMENT; \n" +
                "读取到xml的开始标签返回 START_TAG \n" +
                "读取到xml的文本返回 TEXT \n" +
                "读取到xml的结束标签返回 END_TAG \n" +
                "读取到xml的结束返回 END_DOCUMENT" +
                "3. DOM方式解析\n" +
                "DOM，即对象文档模型，它是将整个XML文档载入内存(所以效率较低，不推荐使用)，每一个节点当做一个对象，结合代码分析。" +
                "但是对于特别大的文档，解析和加载整个文档将会很耗资源。 当然，如果XML文件的内容比较小，采用DOM是可行的。 \n" +
                "工作原理：使用DOM对XML文件进行操作时，首先要解析文件，将文件分为独立的元素、属性和注释等，然后以节点树的形式在内存中对XML文件进行表示，就可以通过节点树访问文档的内容，并根据需要修改文档。";

        String contentS3 = "SAX是一个用于处理XML事件驱动的“推”模型， \n" +
                "优点是一种解析速度快并且占用内存少的xml解析器，它需要哪些数据再加载和解析哪些内容。 \n" +
                "缺点是它不会记录标签的关系，而要让你的应用程序自己处理，这样就增加了你程序的负担。\n" +
                "\n" +
                "DOM是一种文档对象模型，DOM可以以一种独立于平台和语言的方式访问和修改一个文档的内容和结构。 \n" +
                "**优点：**Dom技术使得用户页面可以动态地变化，如可以动态地显示或隐藏一个元素，改变它们的属性，增加一个元素等，Dom技术使得页面的交互性大大地增强。 \n" +
                "缺点：是DOM解析XML文件时，会将XML文件的所有内容以文档树方式存放在内存中。\n" +
                "\n" +
                "Pull解析和Sax解析很相似,Pull解析和Sax解析不一样的地方是pull读取xml文件后触发相应的事件调用方法返回的是数字，还有pull**可以在程序中控制想解析到哪里就可以停止解析。**\n" +
                "\n" +
                "DOM方式最直观和容易理解，但是只适合XML文档较小的时候使用，而SAX方式更适合在移动终端系统中使用，因为相比DOM占用内存少，适合处理比较大的XML文档，最后的Pull方式使用场合和SAX类似，但是更适合需要提前结束XML文档解析的场合。";

        setContentTextView(contentS + "\n\n\n" + contentS2 + "\n\n\n" + contentS3);

        gotoActivity("https://blog.csdn.net/WILLMAX_007/article/details/51416963");

    }
}
