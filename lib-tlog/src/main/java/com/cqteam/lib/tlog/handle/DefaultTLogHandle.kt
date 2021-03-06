package com.cqteam.lib.tlog.handle

import com.cqteam.lib.tlog.claz.ClassUtils
import com.cqteam.lib.tlog.json.JsonFactory
import com.cqteam.lib.tlog.thread.ThreadFactory

/**
 * Author： 洪亮
 * Time： 2021/10/29 - 3:31 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
class DefaultTLogHandle(
    private val isFormatJson: Boolean,
    private val isShowThreadInfo: Boolean,
): TLogHandle {
    override fun i(msg: String): String {
      return handle(msg)
    }

    override fun d(msg: String): String {
        return handle(msg)
    }

    override fun w(msg: String): String {
        return handle(msg)
    }

    override fun e(msg: String): String {
        return handle(msg)
    }

    private fun handle(msg: String): String {
        val stringBuffer = StringBuilder("日志内容")
        stringBuffer.append("\n").append("======class======")
        ClassUtils.getClass().forEach {
            stringBuffer.append("\n").append(it)
        }
        if (isShowThreadInfo) stringBuffer.append("\n").append(ThreadFactory(Thread.currentThread()).printThreadInfo())
        stringBuffer.append("\n").append("===========================================================start=======================================================================")
        if (isFormatJson) stringBuffer.append("\n").append(JsonFactory(msg).printJson()) else stringBuffer.append("\n").append(msg)
        stringBuffer.append("\n").append("============================================================end========================================================================")
        return stringBuffer.toString()
    }

}