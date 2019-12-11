package interview.kotlin.com.all

import android.os.*
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import interview.kotlin.com.interview.MainAdapter
import interview.kotlin.com.interview.R

import interview.kotlin.com.utils.ActivityListUtils
import kotlinx.android.synthetic.main.activity_main.*

class AllActivity : AppCompatActivity() {
    //    private var myRecyclerView: RecyclerView? = null
    private var mainAdapter: AllAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainAdapter = AllAdapter(this@AllActivity, ActivityListUtils.ALL_ACTIVITY_LIST)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        myRecyclerView.adapter = mainAdapter

    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }




}
