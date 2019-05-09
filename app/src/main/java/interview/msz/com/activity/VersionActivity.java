package interview.msz.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.msz.com.baseActivity.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/18.
 */
public class VersionActivity extends BaseActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("Version 变迁");

        String cs = " Android 4.4 KitKat 巧克力\n" +
                "\n" +
                "界面变得更加现代化，同时也使得低端机焕发新生，Android 4.4带来了很多性能上的提升，512MB RAM的老古董也能很好地运行KitKat，进一步扩展了Android市场占有率。\n" +
                "\n" +
                " \n" +
                "\n" +
                "Android 5.0／5.1 Lollipop 棒棒糖\n" +
                "\n" +
                "采用谷歌“Material Design”设计哲学，视觉效果更加扁平化，更加多姿多彩，并且动画过渡效果也使得其更加迷人。谷歌把原来的Dalvik虚拟机全部换成了ART模式，因为少了重新编译这个步骤，APP的运行速度上相比之前还是所提升的。\n" +
                "\n" +
                " \n" +
                "\n1、谷歌将为Android的语音服务Google Now加入一个名为OK Google Everywhere的全新功能。\n" +
                "2、Android 5.0可能还会加入更多的健身功能，考虑到谷歌在发布了Android Wear，后者与智能手表及谷歌眼镜等可穿戴设备的协作应该会成为下个版本的重点功能。\n" +
                "3、整合碎片化 \n" +
                "4、传言Google将在Android5.0中，禁止厂商进行深度定制。\n" +
                "5、数据迁移 \n" +
                "6、独立平板 \n" +
                "7、功能按键 \n" +
                "8、接口风格" +
                "Android 6.0 Marshmallow 棉花糖\n" +
                "\n" +
                "加入了APP关联间的联动、Android Pay、Fingerprint Support三个重要的改变，其中Fingerprint Support增加了对指纹的识别API，谷歌开始在自建官方的指纹识别支持，力求Android统一方案变得更安全。\n" +
                "\n" +
                "1.App Permissions（软件权限管理）。 \n" +
                "2.Chrome Custom Tabs（网页体验提升）。\n" +
                "3.App Links（APP关联）。 \n" +
                "4.Android Pay（安卓支付）。\n" +
                "5.Fingerprint Support（指纹支持）。 \n" +
                "6.Power & Change（电量管理 ）。" +
                "\n" +
                " \n" +
                "\n" +
                "Android 7.0 Nougat 牛轧糖\n" +
                "\n" +
                "加入了多任务分屏功能，谷歌从底层上实现多任务分屏操作更多的是增强应用的兼容性，引入了JIT编译器，APP的安装速度将比目前的安卓6.0提升最多75％，而最关键一点是所占用的空间同时减少50％，也引入了全新的VulkanAPI 图形处理器API，可以大幅减少系统动画对CPU的占用。\n" +
                "\n" +
                " \n" +
                "\n" +
                "Android 8.0 Oreo 奥利奥\n" +
                "\n" +
                "APP的启动速度比Android 7.0快2倍，后台续航监控最大化限制不常用后台应用的活跃度，加入了分屏画中画模式，比起7.0变得变得更加自由和灵活。通知栏下拉之后变为彩色的背景通知，同时一些应用可以在系统中自己调用背景颜色。\n" +
                "\n" +
                " ";
        setContentTextView(cs);

    }
}
