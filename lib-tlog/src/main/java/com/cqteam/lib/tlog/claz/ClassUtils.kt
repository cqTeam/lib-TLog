package com.cqteam.lib.tlog.claz

import android.util.Log
import com.cqteam.lib.tlog.Common

/**
 * Author： 洪亮
 * Time： 2021/10/29 - 3:35 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
object ClassUtils {

    private var packageNames: Array<out String>? = null

    /**
     *  定位，并且点击可跳转
     */
    fun getClass(): List<String> {
        val array = arrayListOf<String>()
        for (stackTraceElement in Thread.currentThread().stackTrace) {
            when {
                stackTraceElement.className.contains(Common.PackageName) -> {
                    array.add(stackTraceElement.toString())
//                    Log.e("classZZ", stackTraceElement.toString())
                }
                packageNames != null -> {
                    packageNames!!.map { packageName ->
                        if (stackTraceElement.className.contains(packageName)) {
                            array.add(stackTraceElement.toString())
//                            Log.e("classZZ", stackTraceElement.toString())
                        }
                    }
                }
            }
        }

        return array.reversed()
    }

    /**
     *  设置需要展示的日志包名
     */
    fun setPackageNames(packageNames: Array<out String>) {
        this.packageNames = packageNames
    }


}