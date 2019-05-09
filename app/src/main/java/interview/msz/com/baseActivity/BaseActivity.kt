package interview.msz.com.baseActivity

import android.annotation.TargetApi
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets

import interview.msz.com.interview.R
import interview.msz.com.thread.ThreadActivity

/**
 * Created by MaShiZhao on 2018/3/26.
 */
open class BaseActivity : AppCompatActivity() {

    lateinit var contentTextView: TextView;
    internal var toolbar: Toolbar? = null
    internal var showMenu: Boolean? = null


    private var code: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        contentTextView = findViewById(R.id.content) as TextView

        toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        showMenu = true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        if (showMenu!!) {
            val menuInflater = menuInflater
            menuInflater.inflate(R.menu.main, menu)
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.title_code -> if (!TextUtils.isEmpty(code)) {
                if (code!!.toLowerCase().startsWith("http") && code!!.length < 100) {
                    val intent = Intent()
                    intent.action = "android.intent.action.VIEW"
                    val content_url = Uri.parse(code)
                    intent.data = content_url
                    startActivity(intent)
                } else {
                    CodeActivity.startActivity(this@BaseActivity, code)
                }

            }

            android.R.id.home ->

                finish()

            else -> {
            }
        }
        return true
    }


    //设置标题
    fun setTitle(title: String) {
        if (toolbar != null) {
            toolbar!!.title = title
            setSupportActionBar(toolbar)
        }
    }

    //设置内容
    fun setContentTextView(contentSt: String) {
        contentTextView.text = contentSt
    }

    //设置是否显示源码
    fun setShowMenu(showMenu: Boolean?) {
        this.showMenu = showMenu
        supportInvalidateOptionsMenu()
    }

    //跳转
    open fun gotoActivity(content: String?) {
        code = content
        if (content != null) {
            contentTextView.text = code
        }
    }


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.d(TAG, localClassName + "onCreate")
    }


    override fun onResume() {
        super.onResume()
        Log.d(TAG, localClassName + "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, localClassName + "onPause")
    }


    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, localClassName + "onRestart")

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, localClassName + "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, localClassName + "onStop")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, localClassName + "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d(TAG, localClassName + "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, localClassName + "onSaveInstanceState")
    }


    /**
     * StandardCharsets.UTF_8 只有在 19以上才有
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    protected fun setContent() {
        val sb = StringBuilder()
        lateinit var br: BufferedReader
        try {
            val `is` = assets.open("code/ActivityActivity.java")
            br = BufferedReader(InputStreamReader(`is`, StandardCharsets.UTF_8))
            var line: String? = null;
            while ({ line = br.readLine(); line }() != null) {
                sb.append(line).append('\n')
            }
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this@BaseActivity, e.toString(), Toast.LENGTH_SHORT).show()
        } finally {
            if (br != null) {
                try {
                    br.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
            setContentTextView(sb.toString())
        }
    }

    companion object {

        val TAG = BaseActivity::class.java.getSimpleName()
    }
}
