package interview.kotlin.com.activity;

import android.os.Bundle;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/2.
 */
public class SystemActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

      String  string = " 第一、操作系统层（OS）\n" +
              "\n" +
              "第二、各种库（Libraries）和Android 运行环境（RunTime）\n" +
              "\n" +
              "第三、应用程序框架（Application Framework）\n" +
              "\n" +
              "第四、应用程序（Application） \n"

        ;

        setTitle("Android OS 体系架构");
        setContentTextView(string);
        gotoActivity("https://blog.csdn.net/itluochen/article/details/52583442");

    }

}
