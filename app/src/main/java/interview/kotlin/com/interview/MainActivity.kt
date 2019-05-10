package interview.kotlin.com.interview

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager

import interview.kotlin.com.utils.ActivityListUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    private var myRecyclerView: RecyclerView? = null
    private var mainAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainAdapter = MainAdapter(this@MainActivity, ActivityListUtils.ACTIVITY_LIST)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.adapter = mainAdapter

    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }


}
