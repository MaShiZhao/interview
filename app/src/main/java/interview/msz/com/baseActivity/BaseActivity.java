package interview.msz.com.baseActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import interview.msz.com.interview.R;
import interview.msz.com.thread.ThreadActivity;

/**
 * Created by MaShiZhao on 2018/3/26.
 */
public class BaseActivity extends AppCompatActivity {

    public static final String TAG = BaseActivity.class.getSimpleName();

    protected TextView contentTextView;
    Toolbar toolbar;
    Boolean showMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        contentTextView = (TextView) findViewById(R.id.content);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        showMenu = true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (showMenu) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.main, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }


    private String code = "";

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.title_code:
                if (!TextUtils.isEmpty(code)) {
                    if (code.toLowerCase().startsWith("http") && code.length() < 100) {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(code);
                        intent.setData(content_url);
                        startActivity(intent);
                    } else {
                        CodeActivity.startActivity(BaseActivity.this, code);
                    }

                }
                break;

            case android.R.id.home:

                finish();

            default:
                break;
        }
        return true;
    }


    //设置标题
    public void setTitle(String title) {
        if (toolbar != null) {
            toolbar.setTitle(title);
            setSupportActionBar(toolbar);
        }
    }

    //设置内容
    public void setContentTextView(String contentSt) {
        contentTextView.setText(contentSt);
    }

    //设置是否显示源码
    public void setShowMenu(Boolean showMenu) {
        this.showMenu = showMenu;
        supportInvalidateOptionsMenu();
    }

    //跳转
    public void gotoActivity(String content) {
        code = content;
        if (content != null) {
            contentTextView.setText(code);
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.d(TAG, getLocalClassName() + "onCreate");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, getLocalClassName() + "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, getLocalClassName() + "onPause");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, getLocalClassName() + "onRestart");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, getLocalClassName() + "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, getLocalClassName() + "onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, getLocalClassName() + "onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(TAG, getLocalClassName() + "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, getLocalClassName() + "onSaveInstanceState");
    }


    /**
     * StandardCharsets.UTF_8 只有在 19以上才有
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    protected void setContent() {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            InputStream is = getAssets().open("code/ActivityActivity.java");
            br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
                sb.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(BaseActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            setContentTextView(sb.toString());
        }
    }
}
