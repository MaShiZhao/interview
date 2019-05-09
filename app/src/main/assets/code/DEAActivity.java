package interview.msz.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.msz.com.baseActivity.BaseActivity;

/**
 * Created by MaShiZhao on 2018/5/15.
 */
public class DEAActivity extends BaseActivity
{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("DEA  Data Encryption Algorithm 数据加密算法");

        String contentString = " MD5是一个安全的散列算法 \n" +
                "：MD5以512位分组来处理输入的信息，且每一分组又被划分为16个32位子分组，经过了一系列的处理后，算法的输出由四个32位分组组成，" +
                "将这四个32位分组级联后将生成一个128位散列值。\n" +
                "使用的是hash算法，在计算过程中原文的部分信息是丢失了的。\n" +
                "16或者32的长度 计算出来的是固定长度的。通过高效碰撞有可能解密\n" +
                "MD5算法具有以下特点：\n" +
                "1、压缩性：任意长度的数据，算出的MD5值长度都是固定的。\n" +
                "2、容易计算：从原数据计算出MD5值很容易。\n" +
                "3、抗修改性：对原数据进行任何改动，哪怕只修改1个字节，所得到的MD5值都有很大区别。\n" +
                "4、强抗碰撞：已知原数据和其MD5值，想找到一个具有相同MD5值的数据（即伪造数据）是非常困难的。";

        String contentString2 = " SHA是一个安全的散列算法 \n" +
                "SHA-1，SHA-224 和 SHA-256 适用于长度不超过 2^64 二进制位的消息。SHA-384 和 SHA-512 适用于长度不超过 2^128 二进制位的消息。\n" +
                "1对于长度小于 2^64 位的消息，SHA1 会产生一个 160 位的消息摘要。\n\n" +
                "" +
                "SHA-1 和 MD5 彼此很相似。相应的，他们的强度和其他特性也是相似，但还有以下几点不同：\n" +
                "\n" +
                "对强行攻击的安全性\n" +
                "\n" +
                "最显著和最重要的区别是 SHA-1 摘要比 MD5 摘要长 32 位。使用强行技术，产生任何一个报文使其摘要等于给定报摘要的难度对 MD5 是 2^128 数量级的操作，而对 SHA-1 则是 2^160 数量级的操作。这样，SHA-1 对强行攻击有更大的强度。\n" +
                "\n" +
                "对密码分析的安全性\n" +
                "\n" +
                "由于 MD5 的设计，易受密码分析的攻击，SHA-1 显得不易受这样的攻击。\n" +
                "\n" +
                "速度\n" +
                "\n" +
                "在相同的硬件上，SHA-1 的运行速度比 MD5 慢。"
               ;


        String contentString3 = "对称加密算法\n" +
                "1. DES (DES全称为Data Encryption Standard，即数据加密标准)\n" +
                "是一种使用密钥加密的块算法 \n" +
                "\n" +
                "单密钥算法,是信息的发送方采用密钥A进行数据加密,信息的接收方采用同一个密钥A进行数据解密.\n" +
                "\n" +
                "缺点:由于采用同一个密钥进行加密解密,在多用户的情况下,密钥保管的安全性是一个问题.\n" +
                "\n" +
                "2. AES （Advanced Encryption Standard，即 高级加密标准），又称Rijndael加密法\n" +
                "严格地说，AES和Rijndael加密法并不完全一样（虽然在实际应用中二者可以互换），因为Rijndael加密法可以支持更大范围的区块和密钥长度：AES的区块长度固定为128 比特，密钥长度则可以是128，192或256比特；而Rijndael使用的密钥和区块长度可以是32位的整数倍，以128位为下限，256比特为上限。加密过程中使用的密钥是由Rijndael密钥生成方案产生。\n" +
                "\n" +
                "AES是美国国家标准技术研究所NIST旨在取代DES的21世纪的加密标准。\n" +
                "\n" +
                "AES_128_GCM 更安全 \n" +
                "AES_128_CBC \n" +
                "…";

        String contentString4 =" 非对称加密算法\n" +
                "1. RSA 非对称加密 （接口使用）\n" +
                "RSA是目前最有影响力的公钥加密算法，它能够抵抗到目前为止已知的绝大多数密码攻击，已被ISO推荐为公钥数据加密标准。\n" +
                "RSA的安全性是基于极其困难的大整数的分解（两个素数的乘积）\n\n " +
                "2. DSA\n" +
                "基于整数有限域离散对数难题\n" +
                "一般用于数字签名和认证\n" +
                "在DSA数字签名和认证中，发送者使用自己的私钥对文件或消息进行签名，接受者收到消息后使用发送者的公钥 \n" +
                "来验证签名的真实性。\n" +
                "DSA只是一种算法，和RSA不同之处在于它不能用作加密和解密，也不能进行密钥交换， \n" +
                "只用于签名,它比RSA要快很多.\n" +
                "" +
                "3.ECC（Elliptic Curves Cryptography）\n" +
                "基于椭圆曲线算法。\n" +
                "ECC 与 RSA 相比，有以下的优点： \n" +
                "相同密钥长度下，安全性能更高，如160位ECC已经与1024位RSA、DSA有相同的安全强度。\n" +
                "计算量小，处理速度快，在私钥的处理速度上（解密和签名），ECC远 比RSA、DSA快得多。\n" +
                "存储空间占用小 ECC的密钥尺寸和系统参数与RSA、DSA相比要小得多， 所以占用的存储空间小得多。\n" +
                "带宽要求低使得ECC具有广泛得应用前景。\n" +
                "这使得ECC 取代RSA成为可能。(不知道谁说的)" +
                "\n\n" +
                "4. Diffie-Hellman\n" +
                "Diffie-Hellman:一种确保共享KEY安全穿越不安全网络的方法 采用DH算法后，Premaster secret不需要传递，双方只要交换各自的参数，就可以算出这个随机数。" +
                "https中使用";

        setContentTextView(contentString + "\n\n\n" + contentString2+ "\n\n\n" + contentString3+ "\n\n\n" + contentString4);


    }
}
