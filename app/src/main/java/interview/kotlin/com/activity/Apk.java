package interview.kotlin.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/5/7.
 */
public class Apk extends BaseActivity
{


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("Apk编译过程");

        String contentS = "1. 打包资源文件，生成R.java文件\n" +
                "打包资源的工具是aapt（The Android Asset Packaing Tool）(E:\\Documents\\Android\\sdk\\build-tools\\25.0.0\\aapt.exe)。\n" +
                "\n" +
                "在这个过程中，项目中的AndroidManifest.xml文件和布局文件XML都会编译，然后生成相应的R.java，另外AndroidManifest.xml会被aapt编译成二进制。\n" +
                "\n" +
                "存放在APP的res目录下的资源，该类资源在APP打包前大多会被编译，变成二进制文件，并会为每个该类文件赋予一个resource id。对于该类资源的访问，应用层代码则是通过resource id进行访问的。Android应用在编译过程中aapt工具会对资源文件进行编译，并生成一个resource.arsc文件，resource.arsc文件相当于一个文件索引表，记录了很多跟资源相关的信息。\n" +
                "\n" +
                "2. 处理aidl文件，生成相应的Java文件\n" +
                "这一过程中使用到的工具是aidl（Android Interface Definition Language），即Android接口描述语言（E:\\Documents\\Android\\sdk\\build-tools\\25.0.0\\aidl.exe）。\n" +
                "\n" +
                "aidl工具解析接口定义文件然后生成相应的Java代码接口供程序调用。如果在项目没有使用到aidl文件，则可以跳过这一步。\n" +
                "\n" +
                "3. 编译项目源代码，生成class文件\n" +
                "项目中所有的Java代码，包括R.java和.aidl文件，都会变Java编译器（javac）编译成.class文件，生成的class文件位于工程中的bin/classes目录下。\n" +
                "\n" +
                "4. 转换所有的class文件，生成classes.dex文件\n" +
                "dx工具生成可供Android系统Dalvik虚拟机执行的classes.dex文件，该工具位于（E:\\Documents\\Android\\sdk\\build-tools\\25.0.0\\dx.bat）。\n" +
                "\n" +
                "任何第三方的libraries和.class文件都会被转换成.dex文件。dx工具的主要工作是将Java字节码转成成Dalvik字节码、压缩常量池、消除冗余信息等。\n" +
                "\n" +
                "5. 打包生成APK文件\n" +
                "所有没有编译的资源，如images、assets目录下资源（该类文件是一些原始文件，APP打包时并不会对其进行编译，而是直接打包到APP中，对于这一类资源文件的访问，应用层代码需要通过文件名对其进行访问）；编译过的资源和.dex文件都会被apkbuilder工具打包到最终的.apk文件中。\n" +
                "\n" +
                "打包的工具apkbuilder位于 android-sdk/tools目录下。apkbuilder为一个脚本文件，实际调用的是（E:\\Documents\\Android\\sdk\\tools\\lib）文件中的com.android.sdklib.build.ApkbuilderMain类。\n" +
                "\n" +
                "6. 对APK文件进行签名\n" +
                "一旦APK文件生成，它必须被签名才能被安装在设备上。\n" +
                "\n" +
                "在开发过程中，主要用到的就是两种签名的keystore。一种是用于调试的debug.keystore，它主要用于调试，在Eclipse或者Android Studio中直接run以后跑在手机上的就是使用的debug.keystore。\n" +
                "\n" +
                "另一种就是用于发布正式版本的keystore。\n" +
                "\n" +
                "7. 对签名后的APK文件进行对齐处理\n" +
                "如果你发布的apk是正式版的话，就必须对APK进行对齐处理，用到的工具是zipalign（E:\\Documents\\Android\\sdk\\build-tools\\25.0.0\\zipalign.exe）\n" +
                "\n" +
                "对齐的主要过程是将APK包中所有的资源文件距离文件起始偏移为4字节整数倍，这样通过内存映射访问apk文件时的速度会更快。对齐的作用就是减少运行时内存的使用。\n" +
                "\n"
                ;


        setContentTextView(contentS);

        gotoActivity("https://www.cnblogs.com/xunbu7/p/7345912.html");

    }

}
