package com.cqteam.tlog

import android.app.Application
import com.cqteam.lib.tlog.TLog
import com.cqteam.lib.tlog.TLogConfig

/**
 * Author： 洪亮
 * Time： 2021/10/29 - 3:48 PM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        TLog.addConfig(
            TLogConfig.Builder().isDebug(true).formatJson(true).showThreadInfo(true).setPackageNames("com.cqteam.tlog").build()
        )
    }
}