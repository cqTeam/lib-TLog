package com.cqteam.lib.tlog

import android.util.Log
import com.cqteam.lib.tlog.handle.DefaultTLogHandle
import com.cqteam.lib.tlog.handle.TLogHandle

/**
 * Author： 洪亮
 * Time： 2021/10/29 - 3:50 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
class TLog {

    companion object {

        private var tLogHandle: TLogHandle
        private var globalTag: String = Common.TLogTag
        private var isDebug: Boolean = true

        init {
            tLogHandle = DefaultTLogHandle(isFormatJson = false, isShowThreadInfo = false)
        }

        fun addConfig(tLogConfig: TLogConfig) {
            tLogHandle = DefaultTLogHandle(isFormatJson = tLogConfig.getIsFormatJson(), isShowThreadInfo = tLogConfig.getIsShowThreadInfo())
            globalTag = tLogConfig.getGlobTag()
            isDebug = tLogConfig.getIsDebug()
        }

        fun i(msg: String, tag: String = globalTag) {
            if (isDebug) Log.i(tag, tLogHandle.i(msg))
        }

        fun d(msg: String, tag: String = globalTag) {
            if (isDebug) Log.d(tag, tLogHandle.d(msg))
        }

        fun w(msg: String, tag: String = globalTag) {
            if (isDebug) Log.w(tag, tLogHandle.w(msg))
        }

        fun e(msg: String, tag: String = globalTag) {
            if (isDebug) Log.e(tag, tLogHandle.e(msg))
        }

    }

}