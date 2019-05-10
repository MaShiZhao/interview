package interview.kotlin.com.sourcecode;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/18.
 */
public class GlideActivity extends BaseActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("Glide");

        String contentString = "" +
                "1、图片占用内存回收及时，能减少因内存不足造成的崩溃，生命周期和Activity/Fragment一致。 \n" +
                "2、默认Bitmap格式是RGB_565，减少内存资源占用。 Picasso采用的ARGB-8888 \n" +
                "3、glide占用的内存要小一些。缓存的更ImageView的尺寸相同 \n" +
                "4、图片显示效果为渐变，更加平滑。 \n" +
                "5、支持 Gif、WebP、缩略图" +
                "\n\n" +
                "1.Glide.with()方法就完成了，它的主要作用是根据with的参数类型，创建一个RequestManager对象，在RequestManager的构造方法中，会调用Glide.get方法，在这个方法里会初始化线程池、缓存、Engin对象和Glide对象，" +
                "2.load() Glide.buildStreamModelLoader和Glide.buildFileDescriptorModelLoader去创建了两个ModelLoader，用于后续的图片加载，其中Glide.buildStreamModelLoader返回的是StreamStringLoader 返回了一个DrawableTypeRequest对象。 ，最后返回的是一个DrawRequestBuilder对象。" +
                "3. 判断是否是主线程 进行into 加载 drawableRequestBuilder into (imageView) " +
                "4.bitmapImageViewTag glideDrawableImageView asBitmap 是bitmapImageViewTarget 否 就是GlideDrawableImageViewTarget " +
                "5.GenericRequestBuilder类中into(Target)  方法中调用了 request对象的begin方法  model是否为null，model其实就是加载的资源，这里就是url，如果url无效，则调用了onException方法  GenericRequest中的begin方法中，如果url有效，且在into之前没有调用override()方法指定宽高，则会调用target的getSize参数" +
                "\n" +
                "with：创建RequestManager，并根据传入参数，初始化好对应的生命周期\n" +
                "load：用于初始化好图片下载、图片解析、图片转换的各个对象，用于后续流程\n" +
                "into：在线程池中去执行EngineRunnale的run方法，用HttpURLConnection下载图片、用BitmapFactory.decodeStream完成解码、然后把Bitmap转换成可统一展示的GlideBitmapDrawable、最后通过Handler发消息，在主线程中给ImageView设置图片" ;


        setContentTextView(contentString+"http://www.lightskystreet.com/2015/10/12/glide_source_analysis/");

        gotoActivity("https://blog.csdn.net/luofen521/article/details/71213440");


    }
}
