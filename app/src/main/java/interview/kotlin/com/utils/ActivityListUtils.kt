package interview.kotlin.com.utils

import java.util.Arrays

import interview.kotlin.com.activity.ActivityActivity
import interview.kotlin.com.activity.AidlActivity
import interview.kotlin.com.activity.Apk
import interview.kotlin.com.activity.DataStructureActivity
import interview.kotlin.com.activity.DesignPatternActivity
import interview.kotlin.com.activity.DrawableActivity
import interview.kotlin.com.activity.GCActivity
import interview.kotlin.com.activity.HashMapActivity
import interview.kotlin.com.activity.HttpActivity
import interview.kotlin.com.activity.NounActivity
import interview.kotlin.com.activity.OtherActivity
import interview.kotlin.com.activity.ReactNativeActivity
import interview.kotlin.com.activity.SystemActivity
import interview.kotlin.com.activity.VersionActivity
import interview.kotlin.com.activity.ViewActivity
import interview.kotlin.com.activity.XmlActivity
import interview.kotlin.com.aidl.BinderActivity
import interview.kotlin.com.count.CountActivity
import interview.kotlin.com.interview.MainBean
import interview.kotlin.com.optimization.BatteryActivity
import interview.kotlin.com.optimization.MemoryOptimizationActivity
import interview.kotlin.com.sourcecode.GlideActivity
import interview.kotlin.com.sourcecode.OkhttpActivity
import interview.kotlin.com.thread.AsyncTaskActivity
import interview.kotlin.com.thread.ThreadActivity
import interview.kotlin.com.thread.ThreadAndProcessActivity
import interview.kotlin.com.thread.ThreadExecutorActivity
import interview.kotlin.com.touch.TouchActivity

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * ActivityListUtils
 *
 *
 * 所有的activityList列表
 *
 * @author MaShiZhao
 * @version 1.0
 *
 *
 * Ver 1.0, 2019-05-10, MaShiZhao, Create file
 */
object ActivityListUtils {

    val ACTIVITY_LIST: MutableList<MainBean> = Arrays.asList(
            MainBean("线程", ThreadActivity::class.java),
            MainBean("进程和线程区别", ThreadAndProcessActivity::class.java),
            MainBean("线程池", ThreadExecutorActivity::class.java),
            MainBean("名词释义", NounActivity::class.java),
            MainBean("底层架构", SystemActivity::class.java),
            MainBean("AIDL", AidlActivity::class.java),
            MainBean("Binder", BinderActivity::class.java),
            MainBean("内存优化", MemoryOptimizationActivity::class.java),
            MainBean("电量优化", BatteryActivity::class.java),
            MainBean("http", HttpActivity::class.java),
            MainBean("View", ViewActivity::class.java),
            MainBean("XML 解析", XmlActivity::class.java),
            MainBean("GC", GCActivity::class.java),
            MainBean("hash", HashMapActivity::class.java),
            MainBean("touch", TouchActivity::class.java),
            MainBean("AsyncTask", AsyncTaskActivity::class.java),
            MainBean("Version", VersionActivity::class.java),
            MainBean("OkHttp", OkhttpActivity::class.java),
            MainBean("Glide", GlideActivity::class.java),
            MainBean("ReactNative", ReactNativeActivity::class.java),
            MainBean("APK", Apk::class.java),
            MainBean("算法", CountActivity::class.java),
            MainBean("数据机构", DataStructureActivity::class.java),
            MainBean("设计模式", DesignPatternActivity::class.java),
            MainBean("drawable", DrawableActivity::class.java),
            MainBean("生命周期", ActivityActivity::class.java),
            MainBean("随手记", OtherActivity::class.java))
}
