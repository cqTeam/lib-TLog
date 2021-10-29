package com.cqteam.lib.tlog.handle

/**
 * Author： 洪亮
 * Time： 2021/10/29 - 3:29 PM
 * Email：281332545@qq.com
 * <p>
 * 描述： 日志处理接口
 */
interface TLogHandle {
    /**
     *  info
     */
    fun i(msg: String): String

    /**
     *  debug
     */
    fun d(msg: String): String

    /**
     *  warn
     */
    fun w(msg: String): String

    /**
     *  error
     */
    fun e(msg: String): String
}