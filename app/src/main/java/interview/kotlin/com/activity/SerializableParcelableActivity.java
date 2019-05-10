package interview.kotlin.com.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/3/26.
 */
public class SerializableParcelableActivity extends BaseActivity
{
    private TextView textView;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        string = "Serializable  Parcelable \n " +
                "1、作用\n" +
                "\n" +
                "Serializable的作用是为了保存对象的属性到本地文件、数据库、网络流、rmi以方便数据传输，当然这种传输可以是程序内的也可以是两个程序间的。而Android的Parcelable的设计初衷是因为Serializable效率过慢，为了在程序内不同组件间以及不同Android程序间(AIDL)高效的传输数据而设计，这些数据仅在内存中存在，Parcelable是通过IBinder通信的消息的载体。\n" +
                "\n" +
                "从上面的设计上我们就可以看出优劣了。\n" +
                "\n" +
                " \n" +
                "\n" +
                "2、效率及选择\n" +
                "\n" +
                "Parcelable的性能比Serializable好，在内存开销方面较小，所以在内存间数据传输时推荐使用Parcelable，如activity间传输数据，而Serializable可将数据持久化方便保存，所以在需要保存或网络传输数据时选择Serializable，因为android不同版本Parcelable可能不同，所以不推荐使用Parcelable进行数据持久化\n" +
                "\n" +
                " \n" +
                "\n" +
                "3、编程实现\n" +
                "\n" +
                "对于Serializable，类只需要实现Serializable接口，并提供一个序列化版本id(serialVersionUID)即可。而Parcelable则需要实现writeToParcel、describeContents函数以及静态的CREATOR变量，实际上就是将如何打包和解包的工作自己来定义，而序列化的这些操作完全由底层实现。"

                 ;

        setTitle("序列化");
        setContentTextView(string);

        String codeS = "" +
                "transient 可以设置 serializable 某个属性不序列化" +
                "//序列化需要把对象转换成诸如FileOutputSream等输出流，再转成ObjectOutputSteam,然后调用相应方法序列化保存到文件。\n" +
                "    private void writeToCache(SerDemo banner) {\n" +
                "        FileOutputStream fos = null;\n" +
                "        ObjectOutput objectOutput = null;\n" +
                "        //判断sd卡是否存在\n" +
                "        if (Environment.getExternalStorageState()\n" +
                "                .equals(android.os.Environment.MEDIA_MOUNTED)) {\n" +
                "            //将指定WenkuBanner对象序列化到SD卡中\n" +
                "            try {\n" +
                "                //文件路径最好是灵活配置\n" +
                "                File file = new File(Environment.getExternalStorageDirectory() + \"/ldm\");\n" +
                "                fos = new FileOutputStream(file);\n" +
                "                objectOutput = new ObjectOutputStream(fos);\n" +
                "                if (objectOutput != null) {\n" +
                "                    objectOutput.writeObject(banner);\n" +
                "                }\n" +
                "            } catch (Exception e) {\n" +
                "                e.printStackTrace();\n" +
                "            } finally {\n" +
                "                try {\n" +
                "                    if (null != fos) {\n" +
                "                        fos.close();\n" +
                "                    }\n" +
                "                    if (null != objectOutput) {\n" +
                "                        objectOutput.close();\n" +
                "                    }\n" +
                "                } catch (IOException e) {\n" +
                "                    e.printStackTrace();\n" +
                "                }\n" +
                "            }\n" +
                "        } else {\n" +
                "            //提示SD卡不存在\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    //模拟把一个Java对象反序列化\n" +
                "    //反序列化需要把文件数据转换成诸如FileInputSream等输入流，再转成ObjectInputSteam,然后调用相应方法转成对象。\n" +
                "    private SerDemo readFromCache() {\n" +
                "        File file = null;\n" +
                "        FileInputStream fis = null;\n" +
                "        ObjectInputStream ois = null;\n" +
                "        SerDemo banner = null;\n" +
                "        if (Environment.getExternalStorageState()\n" +
                "                .equals(android.os.Environment.MEDIA_MOUNTED)) {\n" +
                "            //将指定WenkuBanner对象序列化到SD卡中\n" +
                "            try {\n" +
                "                //文件路径最好是灵活配置\n" +
                "                file = new File(Environment.getExternalStorageDirectory() + \"/ldm\");\n" +
                "                //这里还要判断文件是否存在\n" +
                "                fis = new FileInputStream(file);\n" +
                "                ois = new ObjectInputStream(fis);\n" +
                "                if (null != ois) {\n" +
                "                    //获取到WenkuBanner对象\n" +
                "                    banner = (SerDemo) ois.readObject();\n" +
                "                }\n" +
                "\n" +
                "            } catch (Exception e) {\n" +
                "                e.printStackTrace();\n" +
                "            } finally {\n" +
                "                try {\n" +
                "                    if (null != fis) {\n" +
                "                        fis.close();\n" +
                "                    }\n" +
                "                    if (null != ois) {\n" +
                "                        ois.close();\n" +
                "                    }\n" +
                "                } catch (IOException e) {\n" +
                "                    e.printStackTrace();\n" +
                "                }\n" +
                "            }\n" +
                "        } else {\n" +
                "            //提示SD卡不存在\n" +
                "        }\n" +
                "        return banner;\n" +
                "    }";
        String codeS2 = "public class ParcelDemo implements Parcelable {\n" +
                "    private String name;\n" +
                "    private int age;\n" +
                "    private String subjcet;\n" +
                "\n" +
                "    public ParcelDemo() {\n" +
                "    }\n" +
                "\n" +
                "    //从Parcel中获取变量的内容\n" +
                "    protected ParcelDemo(Parcel in) {\n" +
                "        this.name = in.readString();\n" +
                "        this.age = in.readInt();\n" +
                "        this.subjcet = in.readString();\n" +
                "    }\n" +
                "\n" +
                "    public static final Creator<ParcelDemo> CREATOR = new Creator<ParcelDemo>() {\n" +
                "        //反序列化方法，将writeToParcel方法写入的Parcel反序列成ParcelDemo\n" +
                "        @Override\n" +
                "        public ParcelDemo createFromParcel(Parcel in) {\n" +
                "            return new ParcelDemo(in);\n" +
                "        }\n" +
                "\n" +
                "        //这个方法是提供给其它类反序列化该类的数组时调用\n" +
                "        @Override\n" +
                "        public ParcelDemo[] newArray(int size) {\n" +
                "            return new ParcelDemo[size];\n" +
                "        }\n" +
                "    };\n" +
                "\n" +
                "    //接口内容描述 ，通常返回0即可\n" +
                "    @Override\n" +
                "    public int describeContents() {\n" +
                "        return 0;\n" +
                "    }\n" +
                "\n" +
                "    //实现序列化操作的方法，将类数据写到Parcel窗口中\n" +
                "    @Override\n" +
                "    public void writeToParcel(Parcel parcel, int i) {\n" +
                "        parcel.writeString(name);\n" +
                "        parcel.writeInt(age);\n" +
                "        parcel.writeString(subjcet);\n" +
                "    }\n" +
                "}";
        gotoActivity(codeS);

     }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        Log.d("TAG","onSaveInstanceState");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("TAG","pause");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("TAG","onRestoreInstanceState ");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("TAG","resume");
    }
}
