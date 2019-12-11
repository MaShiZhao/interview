package interview.kotlin.com.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import interview.kotlin.com.aidl.AidlClientActivity;
import interview.kotlin.com.base.BaseActivity;
import okhttp3.OkHttpClient;

/**
 * Created by MaShiZhao on 2018/3/26.
 */
public class AidlActivity extends BaseActivity {
    private TextView textView;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        string = "AIDL 支持的数据类型\n" +
                "共 4 种：\n" +
                "\n" +
                "Java 的基本数据类型\n" +
                "List 和 Map \n" +
                "元素必须是 AIDL 支持的数据类型\n" +
                "Server 端具体的类里则必须是 ArrayList 或者 HashMap\n" +
                "其他 AIDL 生成的接口\n" +
                "实现 Parcelable 的实体\n" +
                "AIDL 如何编写\n" +
                "AIDL 的编写主要为以下三部分：\n" +
                "\n" +
                "创建 AIDL \n" +
                "创建要操作的实体类，实现 Parcelable 接口，以便序列化/反序列化\n" +
                "新建 aidl 文件夹，在其中创建接口 aidl 文件以及实体类的映射 aidl 文件\n" +
                "Make project ，生成 Binder 的 Java 文件\n" +
                "服务端 \n" +
                "创建 Service，在其中创建上面生成的 Binder 对象实例，实现接口定义的方法\n" +
                "在 onBind() 中返回\n" +
                "客户端 \n" +
                "实现 ServiceConnection 接口，在其中拿到 AIDL 类\n" +
                "bindService()\n" +
                "调用 AIDL 类中定义好的操作请求\n" +
                "AIDL 实例\n" +
                "下面以实例代码演示一个 AIDL 的编写。\n" +
                "\n" +
                "1.创建 AIDL\n" +
                "①创建要操作的实体类，实现 Parcelable 接口，以便序列化/反序列化\n" +
                "\n" +
                "\n" +
                "package net.sxkeji.shixinandroiddemo2.bean;\n" +
                "\n" +
                "import android.os.Parcel;\n" +
                "import android.os.Parcelable;\n" +
                "\n" +
                "public class Person implements Parcelable {\n" +
                "    private String mName;\n" +
                "\n" +
                "    public Person(String name) {\n" +
                "        mName = name;\n" +
                "    }\n" +
                "\n" +
                "    protected Person(Parcel in) {\n" +
                "        mName = in.readString();\n" +
                "    }\n" +
                "\n" +
                "    public static final Creator<Person> CREATOR = new Creator<Person>() {\n" +
                "        @Override\n" +
                "        public Person createFromParcel(Parcel in) {\n" +
                "            return new Person(in);\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public Person[] newArray(int size) {\n" +
                "            return new Person[size];\n" +
                "        }\n" +
                "    };\n" +
                "\n" +
                "    @Override\n" +
                "    public int describeContents() {\n" +
                "        return 0;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void writeToParcel(Parcel dest, int flags) {\n" +
                "        dest.writeString(mName);\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public String toString() {\n" +
                "        return \"Person{\" +\n" +
                "                \"mName='\" + mName + '\\'' +\n" +
                "                '}';\n" +
                "    }\n" +
                "实现 Parcelable 接口是为了后序跨进程通信时使用。\n" +
                "\n" +
                "关于 Parcelable 可以看我的这篇文章 Android 进阶6：两种序列化方式 Serializable 和 Parcelable。\n" +
                "\n" +
                "注意 实体类所在的包名。\n" +
                "\n" +
                "②新建 aidl 文件夹，在其中创建接口 aidl 文件以及实体类的映射 aidl 文件\n" +
                "\n" +
                "在 main 文件夹下新建 aidl 文件夹，使用的包名要和 java 文件夹的包名一致：\n" +
                "\n" +
                "shixiznhang\n" +
                "\n" +
                "先创建实体类的映射 aidl 文件，Person.aidl：\n" +
                "\n" +
                "// Person.aidl\n" +
                "package net.sxkeji.shixinandroiddemo2.bean;\n" +
                "\n" +
                "//还要和声明的实体类在一个包里\n" +
                "parcelable Person;\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "在其中声明映射的实体类名称与类型\n" +
                "\n" +
                "注意，这个 Person.aidl 的包名要和实体类包名一致。\n" +
                "\n" +
                "然后创建接口 aidl 文件，IMyAidl.aidl：\n" +
                "\n" +
                "// IMyAidl.aidl\n" +
                "package net.sxkeji.shixinandroiddemo2;\n" +
                "\n" +
                "// Declare any non-default types here with import statements\n" +
                "import net.sxkeji.shixinandroiddemo2.bean.Person;\n" +
                "\n" +
                "interface IMyAidl {\n" +
                "    /**\n" +
                "     * 除了基本数据类型，其他类型的参数都需要标上方向类型：in(输入), out(输出), inout(输入输出)\n" +
                "     */\n" +
                "    void addPerson(in Person person);\n" +
                "\n" +
                "    List<Person> getPersonList();\n" +
                "在接口 aidl 文件中定义将来要在跨进程进行的操作，上面的接口中定义了两个操作：\n" +
                "\n" +
                "addPerson: 添加 Person\n" +
                "getPersonList：获取 Person 列表\n" +
                "需要注意的是：\n" +
                "\n" +
                "非基本类型的数据需要导入，比如上面的 Person，需要导入它的全路径。 \n" +
                "这里的 Person 我理解的是 Person.aidl，然后通过 Person.aidl 又找到真正的实体 Person 类。\n" +
                "方法参数中，除了基本数据类型，其他类型的参数都需要标上方向类型 \n" +
                "in(输入), out(输出), inout(输入输出)\n" +
                "③Make Project ，生成 Binder 的 Java 文件\n" +
                "\n" +
                "AIDL 真正的强大之处就在这里，通过简单的定义 aidl 接口，然后编译，就会为我们生成复杂的 Java 文件。\n" +
                "\n" +
                "点击 Build -> Make Project，然后等待构建完成。\n" +
                "\n" +
                "然后就会在 build/generated/source/aidl/你的 flavor/ 下生成一个 Java 文件：\n" +
                "\n" +
                "shixinzhang\n" +
                "\n" +
                "现在我们有了跨进程 Client 和 Server 的通信媒介，接着就可以编写客户端和服务端代码了。\n" +
                "\n" +
                "我们先跑通整个过程，这个文件的内容下篇文章介绍。\n" +
                "\n" +
                "2.编写服务端代码\n" +
                "创建 Service，在其中创建上面生成的 Binder 对象实例，实现接口定义的方法；然后在 onBind() 中返回\n" +
                "\n" +
                "创建将来要运行在另一个进程的 Service，在其中实现了 AIDL 接口中定义的方法:\n" +
                "\n" +
                "public class MyAidlService extends Service {\n" +
                "    private final String TAG = this.getClass().getSimpleName();\n" +
                "\n" +
                "    private ArrayList<Person> mPersons;\n" +
                "\n" +
                "    /**\n" +
                "     * 创建生成的本地 Binder 对象，实现 AIDL 制定的方法\n" +
                "     */\n" +
                "    private IBinder mIBinder = new IMyAidl.Stub() {\n" +
                "\n" +
                "        @Override\n" +
                "        public void addPerson(Person person) throws RemoteException {\n" +
                "            mPersons.add(person);\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public List<Person> getPersonList() throws RemoteException {\n" +
                "            return mPersons;\n" +
                "        }\n" +
                "    };\n" +
                "\n" +
                "    /**\n" +
                "     * 客户端与服务端绑定时的回调，返回 mIBinder 后客户端就可以通过它远程调用服务端的方法，即实现了通讯\n" +
                "     * @param intent\n" +
                "     * @return\n" +
                "     */\n" +
                "    @Nullable\n" +
                "    @Override\n" +
                "    public IBinder onBind(Intent intent) {\n" +
                "        mPersons = new ArrayList<>();\n" +
                "        LogUtils.d(TAG, \"MyAidlService onBind\");\n" +
                "        return mIBinder;\n" +
                "    }\n" +
                "上面的代码中，创建的对象是一个 IMyAidl.Stub() ，它是一个 Binder，具体为什么是它我们下篇文章介绍。\n" +
                "\n" +
                "别忘记在 Manifest 文件中声明：\n" +
                "\n" +
                "<service\n" +
                "    android:name=\"net.sxkeji.shixinandroiddemo2.service.MyAidlService\"\n" +
                "    android:enabled=\"true\"\n" +
                "    android:exported=\"true\"\n" +
                "    android:process=\":aidl\"/>\n" +
                "服务端实现了接口，在 onBind() 中返回这个 Binder，客户端拿到就可以操作数据了。\n" +
                "\n" +
                "3.编写客户端代码\n" +
                "这里我们以一个 Activity 为客户端。\n" +
                "\n" +
                "①实现 ServiceConnection 接口，在其中拿到 AIDL 类\n" +
                "\n" +
                "private IMyAidl mAidl;\n" +
                "\n" +
                "private ServiceConnection mConnection = new ServiceConnection() {\n" +
                "    @Override\n" +
                "    public void onServiceConnected(ComponentName name, IBinder service) {\n" +
                "        //连接后拿到 Binder，转换成 AIDL，在不同进程会返回个代理\n" +
                "        mAidl = IMyAidl.Stub.asInterface(service);\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onServiceDisconnected(ComponentName name) {\n" +
                "        mAidl = null;\n" +
                "    }\n" +
                "};\n" +
                "在 Activity 中创建一个服务连接对象，在其中调用 IMyAidl.Stub.asInterface() 方法将 Binder 转为 AIDL 类。\n" +
                "\n" +
                "②接着绑定服务\n" +
                "\n" +
                "Intent intent1 = new Intent(getApplicationContext(), MyAidlService.class);\n" +
                "bindService(intent1, mConnection, BIND_AUTO_CREATE);\n" +
                "1\n" +
                "2\n" +
                "要执行 IPC，必须使用 bindService() 将应用绑定到服务上。\n" +
                "\n" +
                "注意：\n" +
                "\n" +
                "5.0 以后要求显式调用 Service，所以我们无法通过 action 或者 filter 的形式调用 Service，具体内容可以看这篇文章 Android 进阶：Service 的一些细节。\n" +
                "\n" +
                "③拿到 AIDL 类后，就可以调用 AIDL 类中定义好的操作，进行跨进程请求\n" +
                "\n" +
                "@OnClick(R.id.btn_add_person)\n" +
                "public void addPerson() {\n" +
                "    Random random = new Random();\n" +
                "    Person person = new Person(\"shixin\" + random.nextInt(10));\n" +
                "\n" +
                "    try {\n" +
                "        mAidl.addPerson(person);\n" +
                "        List<Person> personList = mAidl.getPersonList();\n" +
                "        mTvResult.setText(personList.toString());\n" +
                "    } catch (RemoteException e) {\n" +
                "        e.printStackTrace();\n" +
                "    }\n" +
                "}\n"
        ;

        setTitle("AIDL");
        setContentTextView(string);

        getContentTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(AidlActivity.this, AidlClientActivity.class));
            }
        });

        String codeString = "package interview.msz.com.aidl;\n" +
                "\n" +
                "import android.contentTextView.ComponentName;\n" +
                "import android.contentTextView.Intent;\n" +
                "import android.contentTextView.ServiceConnection;\n" +
                "import android.os.Bundle;\n" +
                "import android.os.IBinder;\n" +
                "import android.os.RemoteException;\n" +
                "import android.support.annotation.Nullable;\n" +
                "import android.support.v4.app.FragmentActivity;\n" +
                "import android.view.View;\n" +
                "import android.widget.Button;\n" +
                "import android.widget.TextView;\n" +
                "\n" +
                "import interview.msz.com.interview.R;\n" +
                "\n" +
                "/**\n" +
                " * Created by MaShiZhao on 2018/4/9.\n" +
                " */\n" +
                "public class AidlClientActivity extends FragmentActivity\n" +
                "{\n" +
                "\n" +
                "    private MyAidl myAidl;\n" +
                "\n" +
                "    private ServiceConnection serviceConnection = new ServiceConnection()\n" +
                "    {\n" +
                "        @Override\n" +
                "        public void onServiceConnected(ComponentName name, IBinder service)\n" +
                "        {\n" +
                "            myAidl = MyAidl.Stub.asInterface(service);\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public void onServiceDisconnected(ComponentName name)\n" +
                "        {\n" +
                "            myAidl = null;\n" +
                "        }\n" +
                "    };\n" +
                "\n" +
                "    private Button btn;\n" +
                "    private TextView contentTextView;\n" +
                "\n" +
                "    AidlBean aidlBean = new AidlBean(\"姓名\", \"简介\");\n" +
                "\n" +
                "    @Override\n" +
                "    public void onCreate(@Nullable Bundle savedInstanceState)\n" +
                "    {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "\n" +
                "        setContentView(R.layout.activity_aidl);\n" +
                "\n" +
                "        btn = (Button) findViewById(R.id.btn);\n" +
                "        contentTextView = (TextView) findViewById(R.id.receiver_content);\n" +
                "\n" +
                "        bindService(new Intent(AidlClientActivity.this, MyAidlService.class), serviceConnection, BIND_AUTO_CREATE);\n" +
                "\n" +
                "        btn.setOnClickListener(new View.OnClickListener()\n" +
                "        {\n" +
                "            @Override\n" +
                "            public void onClick(View v)\n" +
                "            {\n" +
                "                try\n" +
                "                {\n" +
                "                    myAidl.addPerson(aidlBean);\n" +
                "\n" +
                "                    contentTextView.setText(myAidl.getPersons().toString());\n" +
                "\n" +
                "                } catch (RemoteException e)\n" +
                "                {\n" +
                "                    e.printStackTrace();\n" +
                "                }\n" +
                "\n" +
                "            }\n" +
                "        });\n" +
                "    }\n" +
                "}\n";

        String codeString2 = "package interview.msz.com.aidl;\n" +
                "\n" +
                "import android.app.Service;\n" +
                "import android.contentTextView.Intent;\n" +
                "import android.os.IBinder;\n" +
                "import android.os.RemoteException;\n" +
                "import android.support.annotation.Nullable;\n" +
                "\n" +
                "import java.util.ArrayList;\n" +
                "import java.util.List;\n" +
                "\n" +
                "/**\n" +
                " * Created by MaShiZhao on 2018/4/9.\n" +
                " */\n" +
                "public class MyAidlService extends Service\n" +
                "{\n" +
                "\n" +
                "    private List<AidlBean> aidlBean;\n" +
                "\n" +
                "    /**\n" +
                "     * 客户端与服务端绑定时的回调，返回 mIBinder 后客户端就可以通过它远程调用服务端的方法，即实现了通讯\n" +
                "     * @param intent\n" +
                "     * @return\n" +
                "     */\n" +
                "    @Nullable\n" +
                "    @Override\n" +
                "    public IBinder onBind(Intent intent)\n" +
                "    {\n" +
                "        aidlBean = new ArrayList<>();\n" +
                "        return mIBinder;\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    /**\n" +
                "     * 创建生成的本地 Binder 对象，实现 AIDL 制定的方法\n" +
                "     */\n" +
                "    private IBinder mIBinder = new MyAidl.Stub()\n" +
                "    {\n" +
                "        @Override\n" +
                "        public void addPerson(AidlBean bean) throws RemoteException\n" +
                "        {\n" +
                "            if (aidlBean != null)\n" +
                "            {\n" +
                "                aidlBean.add(bean);\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public List<AidlBean> getPersons() throws RemoteException\n" +
                "        {\n" +
                "            return aidlBean;\n" +
                "        }\n" +
                "    };\n" +
                "\n" +
                "}\n";
        gotoActivity(codeString + "\n\n\n\n" + codeString2);

     }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("TAG", "onSaveInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "pause");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("TAG", "onRestoreInstanceState ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "resume");
    }
}
