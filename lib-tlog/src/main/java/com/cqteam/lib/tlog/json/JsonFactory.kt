package com.cqteam.lib.tlog.json

import android.util.Log
import com.cqteam.lib.tlog.Common
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * Author： 洪亮
 * Time： 2021/10/29 - 2:58 PM
 * Email：281332545@qq.com
 * <p>
 * 描述： Json工厂
 */
class JsonFactory(
    private val msg: String
) {
    fun printJson(): String {
        var message: String
        try {
            message = when {
                msg.startsWith("{") -> {
                    JSONObject(msg).toString(4)
                }
                msg.startsWith("[") -> {
                    JSONArray(msg).toString(4)
                }
                else -> {
                    msg
                }
            }
        } catch (e: JSONException) {
            Log.e(Common.TLogExceptionTag,e.printStackTrace().toString())
            message = msg
        }

        return message
    }
}