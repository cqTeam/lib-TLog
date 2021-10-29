package com.cqteam.lib.tlog.claz

/**
 * Author： 洪亮
 * Time： 2021/10/29 - 3:35 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
object ClassUtils {
    /**
     *  定位，并且点击可跳转
     */
    fun getClass(): String{
        val stackTraceInfo = Thread.currentThread().stackTrace[4]
        return "(${stackTraceInfo.fileName}:${stackTraceInfo.lineNumber})"
    }
}