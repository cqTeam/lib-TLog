package com.cqteam.lib.tlog

import com.cqteam.lib.tlog.claz.ClassUtils

/**
 * Author： 洪亮
 * Time： 2021/10/29 - 10:58 AM
 * Email：281332545@qq.com
 * <p>
 * 描述：
 */

// kotlin 中 class 等同于 java 的 public final class
class TLogConfig(
    private val globTag: String,
    private val isFormatJson: Boolean,
    private val isShowThreadInfo: Boolean,
) {

    fun getGlobTag(): String {
        return globTag
    }

    fun getIsFormatJson(): Boolean {
        return isFormatJson
    }

    fun getIsShowThreadInfo(): Boolean {
        return isShowThreadInfo
    }

    /* 静态内部类 */
    class Builder {

        // 全局 Log tag
        private var globTag: String? = null

        // true：输出的json进行了格式化； false：输出的json不进行格式化
        private var isFormatJson: Boolean = false

        // true：输出线程信息；false：不输出线程消息
        private var isShowThreadInfo: Boolean = false

        /**
         *  设置全局 Tag
         */
        fun tag(globTag: String): Builder {
            this.globTag = globTag
            return this
        }

        /**
         *  是否格式化Json字符串
         *  @param boolean false 不格式； true 格式化； 默认为 false
         */
        fun formatJson(boolean: Boolean = false): Builder {
            isFormatJson = boolean
            return this
        }

        /**
         *  配置是否显示线程信息
         */
        fun showThreadInfo(boolean: Boolean = false): Builder {
            isShowThreadInfo = boolean
            return this
        }

        /**
         *  设置需要定位的 PackageName
         */
        fun setPackageNames(vararg packageNames: String): Builder {
            ClassUtils.setPackageNames(packageNames)
            return this
        }

        /**
         *  创建 TLog
         */
        fun build(): TLogConfig {
            if (globTag == null) {
                globTag = Common.TLogTag
            }
            return TLogConfig(globTag!!,isFormatJson,isShowThreadInfo)
        }
    }
}
