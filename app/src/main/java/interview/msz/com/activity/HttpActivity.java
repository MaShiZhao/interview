package interview.msz.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.msz.com.baseActivity.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/11.
 */
public class HttpActivity extends BaseActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("Http Https");

        String contentS = "https是安全协议连接，在信息传输上更为保密和安全，而http则安全性较低，会发生信息泄露和被劫持篡改。\n" +
                "\n" +
                "http和https的区别\n" +
                "http使用的数据端口是80端口，而https使用的数据端口是443。\n" +
                "\n" +
                "http传输协议的不安全性是因为它作用于应用层，呈现在用户面前的信息可能与实际传输的信息不一致，而http传输协议则直接保护了传输层的数据。\n" +
                "\n" +
                "http无法对应用层的结果进行加密，而https则是在对传输中的数据进行加密，最后再应用层解密来呈现显示结果。\n" +
                "\n" +
                "https连接前需要下载数字证书来确认服务器的真实性，避免其它劫持者伪装服务器对客户机的信息进行劫持和篡改。";

        String contentS2 =
                "GET和POST长度的限制问题GET1.GET是通过URL提交数据，因此GET可提交的数据量就跟URL所能达到的最大长度有直接关系。" +
                        "\n 2.实际上HTTP协议对URL长度是没有限制的；限制URL长度大多数是浏览器或者服务器的配置参数POST 1.同样的，HTTP协议没有对POST进行任何限制，一般是受服务器配置限制或者内存大小。2.PHP下可以修改php.conf的postmaxsize来设置POST的大小。请求header的content-length问题如果有人恶意伪造content-length很大的包头，但实际上发送content-length很小的请求，这样服务器会一直干等，直到超时。当然服务器是可以通过设置来避免该问题的 " +
                        "\n GET和POST的安全性1.GET是通过URL方式请求，可以直接看到，明文传输。2.POST是通过请求header请求，可以开发者工具或者抓包可以看到，同样也是明文的。" +
                        "\n 3.GET请求会保存在浏览器历史纪录中，还可能会保存在Web的日志中。GET和POST对服务器的状态根据http的设计，大家在看到get的时候，都期望这个请求对服务器没有修改，看到post的时候，都认为这对服务器产生了修改。" +
                        "\n 4.GET幂等，POST不幂等幂等是指同一个请求方法执行多次和仅执行一次的效果完全相同。1.按照RFC规范，PUT，DELETE和安全方法都是幂等的。虽说是规范，但服务端实现是否幂等是无法确保的。2.引入幂等主要是为了处理同一个请求重复发送的情况，比如在请求响应前失去连接，如果方法是幂等的，就可以放心地重发一次请求。这也是浏览器在后退/刷新时遇到POST会给用户提示的原因：POST语义不是幂等的，重复请求可能会带来意想不到的后果。3.比如在微博这个场景里，GET的语义会被用在「看看我的Timeline上最新的20条微博」这样的场景，而POST的语义会被用在「发微博、评论、点赞」这样的场景中。";

        String content3 = "在TCP/IP协议中,TCP协议提供可靠的连接服务,采用三次握手建立一个连接.\n" +
                "第一次握手：建立连接时,客户端发送syn包(syn=j)到服务器,并进入SYN_SEND状态,等待服务器确认； \n" +
                "SYN：同步序列编号(Synchronize Sequence Numbers)\n" +
                "第二次握手：服务器收到syn包,必须确认客户的SYN（ack=j+1）,同时自己也发送一个SYN包（syn=k）,即SYN+ACK包,此时服务器进入SYN_RECV状态； \n" +
                "第三次握手：客户端收到服务器的SYN＋ACK包,向服务器发送确认包ACK(ack=k+1),此包发送完毕,客户端和服务器进入ESTABLISHED状态,完成三次握手.\n" +
                "完成三次握手,客户端与服务器开始传送数据\n\n\n" +
                "\n\n\n 四次挥手 " +
                "        （1）第一次挥手：Client发送一个FIN，用来关闭Client到Server的数据传送，Client进入FIN_WAIT_1状态。\n" +
                "        （2）第二次挥手：Server收到FIN后，发送一个ACK给Client，确认序号为收到序号+1（与SYN相同，一个FIN占用一个序号），Server进入CLOSE_WAIT状态。\n" +
                "        （3）第三次挥手：Server发送一个FIN，用来关闭Server到Client的数据传送，Server进入LAST_ACK状态。\n" +
                "        （4）第四次挥手：Client收到FIN后，Client进入TIME_WAIT状态，接着发送一个ACK给Server，确认序号为收到序号+1，Server进入CLOSED状态，完成四次挥手。";


        String content4 = "TCP   HTTP   UDP:\n" +
                "\n" +
                "都是通信协议，也就是通信时所遵守的规则，只有双方按照这个规则“说话”，对方才能理解或为之服务。\n" +
                "\n" +
                "TCP   HTTP   UDP三者的关系:\n" +
                "\n" +
                "TCP/IP是个协议组，可分为四个层次：应用层HTTP、传输层TCP、网络层IP、数据链路层Data-link、物理层physical。。\n" +
                "\n" +
                " 应用层—应用层是所有用户所面向的应用程序的统称。ICP/IP协议族在这一层面有着很多协议来支持不同的应用，" +
                "如我们进行万维网（WWW）访问用到了HTTP协议、文件传输用FTP协议、电子邮件发送用SMTP、域名的解析用DNS协议、" +
                " 远程登录用Telnet协议等等，都是属于TCP/IP应用层的.\n" +
                " 传输层—这一层的的功能主要是提供应用程序间的通信，TCP/IP协议族在这一层的协议有TCP和UDP。\n" +
                " 网络层—是TCP/IP协议族中非常关键的一层，主要定义了IP地址格式，从而能够使得不同应用类型的数据在Internet上通畅地传输，IP协议就是一个网络层协议。\n" +
                " 网络接口层(数据链路层)—这是TCP/IP软件的最低层，负责接收IP数据包并通过网络发送之，或者从网络上接收物理帧，抽出IP数据报，交给IP层。\n" +
                "\n。\n" +
                "\n" +
                "因此，HTTP本身就是一个协议，是从Web服务器传输超文本到本地浏览器的传送协议。\n" +
                "TCP支持的应用协议主要有：Telnet、FTP、SMTP等；UDP支持的应用层协议主要有：NFS（网络文件系统）、SNMP（简单网络管理协议）、DNS（主域名称系统）、TFTP（通用文件传输协议）" +
                "\n" +
                "OSI（Open Systems Interconnection Reference Model）的7层从上到下分别是 \n" +
                "\n" +
                "7 应用层 Application\n" +
                "6 表示层 Presentation\n" +
                "5 会话层 Session\n" +
                "4 传输层 Transport\n" +
                "3 网络层 Network\n" +
                "2 数据链路层 Data-link\n" +
                "1 物理层 Physical" +
                "socket: \n" +
                "\n" +
                "这是为了实现以上的通信过程而建立成来的通信管道，其真实的代表是客户端和服务器端的一个通信进程，双方进程通过socket进行通信，" +
                "而通信的规则采用指定的协议。socket只是一种连接模式，不是协议，tcp、udp，简单的说（虽然不准确）是两个最基本的协议," +
                "很多其它协议都是基于这两个协议如，http就是基于tcp的，.用socket可以创建tcp连接，也可以创建udp连接，这意味着，" +
                "用socket可以创建任何协议的连接，因为其它协议都是基于此的。" +
                "\n\n\n" +
                "TCP与UDP区别总结：\n" +
                "1、TCP面向连接（如打电话要先拨号建立连接）;UDP是无连接的，即发送数据之前不需要建立连接\n" +
                "2、TCP提供可靠的服务。也就是说，通过TCP连接传送的数据，无差错，不丢失，不重复，且按序到达;UDP尽最大努力交付，即不保   证可靠交付\n" +
                "3、TCP面向字节流，实际上是TCP把数据看成一连串无结构的字节流;UDP是面向报文的\n" +
                "  UDP没有拥塞控制，因此网络出现拥塞不会使源主机的发送速率降低（对实时应用很有用，如IP电话，实时视频会议等）\n" +
                "4、每一条TCP连接只能是点到点的;UDP支持一对一，一对多，多对一和多对多的交互通信\n" +
                "5、TCP首部开销20字节;UDP的首部开销小，只有8个字节\n" +
                "6、TCP的逻辑通信信道是全双工的可靠信道，UDP则是不可靠信道" +
                "";

        String content5 = "https 加密流程：" +
                "HTTPS的工作原理\n" +
                "\n" +
                "我们都知道HTTPS能够加密信息，以免敏感信息被第三方获取，所以很多银行网站或电子邮箱等等安全级别较高的服务都会采用HTTPS协议。\n" +
                "\n" +
                "1、客户端发起HTTPS请求\n" +
                "\n" +
                "这个没什么好说的，就是用户在浏览器里输入一个https网址，然后连接到server的443端口。\n" +
                "\n" +
                "2、服务端的配置\n" +
                "\n" +
                "采用HTTPS协议的服务器必须要有一套数字证书，可以自己制作，也可以向组织申请，区别就是自己颁发的证书需要客户端验证通过，才可以继续访问，而使用受信任的公司申请的证书则不会弹出提示页面(startssl就是个不错的选择，有1年的免费服务)。\n" +
                "\n" +
                "这套证书其实就是一对公钥和私钥，如果对公钥和私钥不太理解，可以想象成一把钥匙和一个锁头，只是全世界只有你一个人有这把钥匙，你可以把锁头给别人，别人可以用这个锁把重要的东西锁起来，然后发给你，因为只有你一个人有这把钥匙，所以只有你才能看到被这把锁锁起来的东西。\n" +
                "\n" +
                "3、传送证书\n" +
                "\n" +
                "这个证书其实就是公钥，只是包含了很多信息，如证书的颁发机构，过期时间等等。\n" +
                "\n" +
                "4、客户端解析证书\n" +
                "\n" +
                "这部分工作是有客户端的TLS来完成的，首先会验证公钥是否有效，比如颁发机构，过期时间等等，如果发现异常，则会弹出一个警告框，提示证书存在问题。\n" +
                "\n" +
                "如果证书没有问题，那么就生成一个随机值，然后用证书对该随机值进行加密，就好像上面说的，把随机值用锁头锁起来，这样除非有钥匙，不然看不到被锁住的内容。\n" +
                "\n" +
                "5、传送加密信息\n" +
                "\n" +
                "这部分传送的是用证书加密后的随机值，目的就是让服务端得到这个随机值，以后客户端和服务端的通信就可以通过这个随机值来进行加密解密了。\n" +
                "\n" +
                "6、服务段解密信息\n" +
                "\n" +
                "服务端用私钥解密后，得到了客户端传过来的随机值(私钥)，然后把内容通过该值进行对称加密，所谓对称加密就是，将信息和私钥通过某种算法混合在一起，这样除非知道私钥，不然无法获取内容，而正好客户端和服务端都知道这个私钥，所以只要加密算法够彪悍，私钥够复杂，数据就够安全。\n" +
                "\n" +
                "7、传输加密后的信息\n" +
                "\n" +
                "这部分信息是服务段用私钥加密后的信息，可以在客户端被还原。\n" +
                "\n" +
                "8、客户端解密信息\n" +
                "\n" +
                "客户端用之前生成的私钥解密服务段传过来的信息，于是获取了解密后的内容，整个过程第三方即使监听到了数据，也束手无策。" +
                "\n\n\n" +
                "https握手阶段" +
                "第一步，爱丽丝给出协议版本号、一个客户端生成的随机数（Client random），以及客户端支持的加密方法。\n" +
                "\n" +
                "第二步，鲍勃确认双方使用的加密方法，并给出数字证书、以及一个服务器生成的随机数（Server random）。\n" +
                "\n" +
                "第三步，爱丽丝确认数字证书有效，然后生成一个新的随机数（Premaster secret），并使用数字证书中的公钥，加密这个随机数，发给鲍勃。\n" +
                "\n" +
                "第四步，鲍勃使用自己的私钥，获取爱丽丝发来的随机数（即Premaster secret）。\n" +
                "\n" +
                "第五步，爱丽丝和鲍勃根据约定的加密方法，使用前面的三个随机数，生成\"对话密钥\"（session key），用来加密接下来的整个对话过程。" +
                "\n\n\n" +
                "https缺点" +
                "（1）、SSL证书需要钱，功能越强大的证书费用越高，个人网站、小网站没有必要一般不会用。\n" +
                "\n" +
                "（2）、SSL证书通常需要绑定IP，不能在同一IP上绑定多个域名，IPv4资源不可能支撑这个消耗（SSL有扩展可以部分解决这个问题，但是比较麻烦，而且要求浏览器、操作系统支持，Windows XP就不支持这个扩展，考虑到XP的装机量，这个特性几乎没用）。\n" +
                "\n" +
                "（3）、HTTPS连接缓存不如HTTP高效，大流量网站如非必要也不会采用，流量成本太高。\n" +
                "\n" +
                "（4）、HTTPS连接服务器端资源占用高很多，支持访客稍多的网站需要投入更大的成本，如果全部采用HTTPS，基于大部分计算资源闲置的假设的VPS的平均成本会上去。\n" +
                "\n" +
                "（5）、HTTPS协议握手阶段比较费时，对网站的相应速度有负面影响，如非必要，没有理由牺牲用户体验。\n" +
                "\n";
        setContentTextView(contentS + "\n\n\n" + contentS2 + "\n\n\n" + content3 + "\n\n\n" + content4 + "\n\n\n" + content5);


    }
}
