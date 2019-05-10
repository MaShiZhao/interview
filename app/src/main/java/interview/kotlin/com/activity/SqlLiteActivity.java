package interview.kotlin.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.baseActivity.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/10.
 */
public class SqlLiteActivity extends BaseActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("数据库");

        String contentS = "SQLite数据库比较重要的代码：（1）建立SQLiteOpenHelper对象；（2）调用getWritableDatabase（）来建立SQLite数据库。\n\n"+
"1）建立SQLiteOpenHelper对象\n" +
                "\n" +
                "复制代码\n" +
                "    /**\n" +
                "     * Create a helper object to create, open, and/or manage a database.\n" +
                "     * The database is not actually created or opened until one of\n" +
                "     * {@link #getWritableDatabase} or {@link #getReadableDatabase} is called.*/\n" +
                "    public SQLiteOpenHelper(Context context, String name, CursorFactory factory, int version,\n" +
                "            DatabaseErrorHandler errorHandler) {\n" +
                "        if (version < 1) throw new IllegalArgumentException(\"Version must be >= 1, was \" + version);\n" +
                "\n" +
                "        mContext = context;\n" +
                "        mName = name;\n" +
                "        mFactory = factory;\n" +
                "        mNewVersion = version;\n" +
                "        mErrorHandler = errorHandler;\n" +
                "    }\n" +
                "复制代码\n" +
                "　　从注释中就可以看出，该构造函数只是建立SQLiteOpenHelper对象，以及进行了一些变量的初始化动作，所以正真创建SQLite数据库地方不是在这里，而是在getWritableDatabase() 或者 getReadableDatabase()中实现的。接下来看这两个函数是如何创建SQLite数据库的。\n" +
                "\n" +
                "　　（2）调用getWritableDatabase（）函数\n" +
                "\n" +
                "复制代码\n" +
                "    /**\n" +
                "     * Create and/or open a database that will be used for reading and writing.\n" +
                "     * The first time this is called, the database will be opened and\n" +
                "     * {@link #onCreate}, {@link #onUpgrade} and/or {@link #onOpen} will be\n" +
                "     * called.\n" +
                "     *\n" +
                "     * <p>Once opened successfully, the database is cached, so you can\n" +
                "     * call this method every time you need to write to the database.\n" +
                "     * (Make sure to call {@link #close} when you no longer need the database.)\n" +
                "     * Errors such as bad permissions or a full disk may cause this method\n" +
                "     * to fail, but future attempts may succeed if the problem is fixed.</p>\n" +
                "     *\n" +
                "     * <p class=\"caution\">Database upgrade may take a long time, you\n" +
                "     * should not call this method from the application main thread, including\n" +
                "     * from {@link android.contentTextView.ContentProvider#onCreate ContentProvider.onCreate()}.\n" +
                "     **/\n" +
                "    public SQLiteDatabase getWritableDatabase() {\n" +
                "        synchronized (this) {\n" +
                "            return getDatabaseLocked(true);\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * Create and/or open a database.  This will be the same object returned by\n" +
                "     * {@link #getWritableDatabase} unless some problem, such as a full disk,\n" +
                "     * requires the database to be opened read-only.  In that case, a read-only\n" +
                "     * database object will be returned.  If the problem is fixed, a future call\n" +
                "     * to {@link #getWritableDatabase} may succeed, in which case the read-only\n" +
                "     * database object will be closed and the read/write object will be returned\n" +
                "     * in the future.\n" +
                "     *\n" +
                "     * <p class=\"caution\">Like {@link #getWritableDatabase}, this method may\n" +
                "     * take a long time to return, so you should not call it from the\n" +
                "     * application main thread, including from\n" +
                "     * {@link android.contentTextView.ContentProvider#onCreate ContentProvider.onCreate()}.\n" +
                "     **/\n" +
                "    public SQLiteDatabase getReadableDatabase() {\n" +
                "        synchronized (this) {\n" +
                "            return getDatabaseLocked(false);\n" +
                "        }\n" +
                "    }\n" +
                "复制代码\n" +
                "　　getWritableDatabase() & getReadableDatabase()函数中都是调用getDatabaseLocked()函数，仅仅是传的参数不同，这两个函数的功能基本上是相同的。注释中也举例说明了当磁盘满了是两者间的区别。下面接着看getDatabaseLocked()中的内容。"
                +"　其中DEBUG_STRICT_READONLY变量默认为False，所以正常建立的数据库都是Readable & Writable。所以上面新建数据库代码主要可以分为三个部分：\n" +
                "\n" +
                "　　1.如果mDataBase不为空，并且处于打开状态时，直接返回，所以多次调用getWritableDatabase()或getReadableDatabase()和只调用一次的效果是一样的。\n" +
                "\n" +
                "　　2.如果mDataBase为空，则调用mContext.openOrCreateDatabase()来创建数据库。\n" +
                "\n" +
                "　　3.当数据库版本信息发生变化时，做相应的升/降版本处理。\n" +
                "\n" +
                "　　其中SQLiteDatabase db = SQLiteDatabase.openDatabase(f.getPath(), factory, flags, errorHandler);应该是正真建立数据库的地方。\n" +
                "\n"

                ;
        String contentS2 = "一：OrmLite\n" +
                "简述: 优点： 1.轻量级；2.使用简单，易上手；3.封装完善；4.文档全面。" +
                "\n缺点：1.基于反射，效率较低（本人还没有觉得效率低）；2.缺少中文翻译文档\n" +
                "\n" +
                "jar包 地址：http://ormlite.com/releases/\n" +
                "\n" +
                "集成方法：把jar包复制到as的libs文件夹下，并且引用jar包即可" +
                "\n" + "\n" + "\n" +
                "二：LitePal\n" +
                "简述:暂无\n" +
                "\n" +
                "git 地址：https://github.com/LitePalFramework/LitePal\n" +
                "\n" +
                "集成方法：compile ‘org.litepal.android:core:1.5.0’\n" +
                "\n" +
                "用于学习的相关博客：\n" +
                "\n" + "\n" + "\n" +
                "三：GreenDao3.2\n" +
                "简述:其优点还包括以下几点:1.存取速度快; 2.支持数据库加密; 3.轻量级; 4.激活实体; 5.支持缓存; 6.代码自动生成" +
                "\n\n" +
                "效率很高，插入和更新的速度是sqlite的2倍，加载实体的速度是ormlite的4.5倍，目前git上一直在做更新维护，start数量为9000多。\n" +
                "\n\n\n" +
                "四：DBFlow\n" +
                "简述:其优点还包括以下几点:1.存取速度快; 2.支持数据库加密; 3.轻量级; 4.激活实体; 5.支持缓存; 6.代码自动生成\n" +
                "\n" +
                "\n" +
                "\n" +
                "五：Realm\n" +
                "简述: \n" +
                "1.易用：Ream 不是在SQLite基础上的ORM，它有自己的数据查询引擎。并且十分容易使用。 \n" +
                "2.快速：由于它是完全重新开始开发的数据库实现，所以它比任何的ORM速度都快很多，甚至比SLite速度都要快。 \n" +
                "3.跨平台：Realm 支持 iOS & OS X (Objective‑C & Swift) & Android。我们可以在这些平台上共享Realm数据库文件，并且上层逻辑可以不用任何改动的情况下实现移植。 \n" +
                "4.高级：Ream支持加密，格式化查询，易于移植，支持JSON，流式api，数据变更通知等高级特性 \n" +
                "5.可视化";


        setContentTextView(contentS + "\n\n\n" + contentS2);
    }
}
