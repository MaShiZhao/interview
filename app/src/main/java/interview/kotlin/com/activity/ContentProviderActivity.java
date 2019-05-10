package interview.kotlin.com.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.baseActivity.BaseActivity;

/**
 * Created by MaShiZhao on 2018/5/15.
 */
public class ContentProviderActivity extends BaseActivity
{


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("Content Provider");

        String contentString = "Android为常见的一些数据提供了默认的ContentProvider（包括音频、视频、图片和通讯录等）。 所以我们可以在其他应用程通过那些ContentProvider获取这些数据.\n\n" +
                "1. onCreate() 默认执行在主线程，别做耗时操作，query() 也最好异步执行 \n" +
                "2. 上面的 4 个增删改查操作都可能会被多个线程并发访问，因此需要注意线程安全\n" +
                "\n";

        setContentTextView(contentString);

        String contentString2 = "\n" +
                "public class MyContentProvider extends ContentProvider {\n" +
                "    private final static int CONTACT = 1;\n" +
                "\n" +
                "    private static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);\n" +
                "    static {\n" +
                "        uriMatcher.addURI(\"com.cj.mycontentprovider\",\"contact\",CONTACT);\n" +
                "    }\n" +
                "\n" +
                "    private MyDBHelp dbHelp;\n" +
                "\n" +
                "    @Override\n" +
                "    public int delete(Uri uri, String selection, String[] selectionArgs) {\n" +
                "        int id =0;\n" +
                "        if(uriMatcher.match(uri) == CONTACT){\n" +
                "            SQLiteDatabase database = dbHelp.getWritableDatabase();\n" +
                "            id= database.delete(\"contact\", selection, selectionArgs);\n" +
                "            contentResolver.notifyChange(uri,null);\n" +
                "        }\n" +
                "       return id;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public String getType(Uri uri) {\n" +
                "        // TODO: Implement this to handle requests for the MIME type of the data\n" +
                "        // at the given URI.\n" +
                "        throw new UnsupportedOperationException(\"Not yet implemented\");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public Uri insert(Uri uri, ContentValues values) {\n" +
                "        Uri u = null;\n" +
                "        if(uriMatcher.match(uri) == CONTACT){\n" +
                "            SQLiteDatabase database = dbHelp.getWritableDatabase();\n" +
                "\n" +
                "            long d = database.insert(\"contact\", \"_id\", values);\n" +
                "            u = ContentUris.withAppendedId(uri,d);\n" +
                "            contentResolver.notifyChange(u,null);\n" +
                "        }\n" +
                "        return u;\n" +
                "\n" +
                "    }\n" +
                "    private ContentResolver contentResolver;\n" +
                "    @Override\n" +
                "    public boolean onCreate() {\n" +
                "        Context context = getContext();\n" +
                "        contentResolver = context.getContentResolver();\n" +
                "        dbHelp = new MyDBHelp(context,\"contact.db\",null,1);\n" +
                "        return true;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public Cursor query(Uri uri, String[] projection, String selection,\n" +
                "                        String[] selectionArgs, String sortOrder) {\n" +
                "        Cursor cursor = null;\n" +
                "        if(uriMatcher.match(uri) == CONTACT){\n" +
                "            SQLiteDatabase database = dbHelp.getReadableDatabase();\n" +
                "            cursor = database.query(\"contact\", projection, selection, selectionArgs, null, null, sortOrder);\n" +
                "            cursor.setNotificationUri(contentResolver,uri);\n" +
                "        }\n" +
                "        return cursor;\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public int update(Uri uri, ContentValues values, String selection,\n" +
                "                      String[] selectionArgs) {\n" +
                "        // TODO: Implement this to handle requests to update one or more rows.\n" +
                "        throw new UnsupportedOperationException(\"Not yet implemented\");\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     *\n" +
                "     */\n" +
                "    private static  class MyDBHelp extends SQLiteOpenHelper{\n" +
                "\n" +
                "        public MyDBHelp(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {\n" +
                "            super(context, name, factory, version);\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public void onCreate(SQLiteDatabase db) {\n" +
                "            String sql = \"create table contact(_id integer primary key autoincrement,\" +\n" +
                "                    \"name text not null,number text not null);\";\n" +
                "            db.execSQL(sql);\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {\n" +
                "            onCreate(db);\n" +
                "\n" +
                "        }\n" +
                "    }\n" +
                "}";


        String contentString3 = " resolver = getContentResolver();\n" +
                "        cursor = resolver.query(Uri.parse(\"content://com.cj.mycontentprovider/contact\"), null, null,\n" +
                "                null, null);\n\n" +
                "" +
                "   resolver.delete(Uri.parse(\"content://com.cj.mycontentprovider/contact\"),\n" +
                "                null,null);";
        gotoActivity(contentString2 + "\n\n\n" + contentString3);


    }
}
