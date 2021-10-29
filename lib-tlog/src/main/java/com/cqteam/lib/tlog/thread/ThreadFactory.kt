package com.cqteam.lib.tlog.thread

/**
 * Author： 洪亮
 * Time： 2021/10/29 - 3:02 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
class ThreadFactory(
    private val thread: Thread
) {

    fun printThreadInfo(): String {
        return StringBuffer("======Thread======")
            .append("\n").append("name:${thread.name}")
            .append("\n").append("id:${thread.id}")
            .append("\n").append("priority:${thread.priority}")
            .append("\n").append("groupName:${thread.threadGroup?.name}")
            .toString()
    }
}