package com.template.common.logger

import android.util.Log
import com.template.common.qualifier.IsDebug
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AndroidLogger @Inject constructor(
    @param:IsDebug private val isDebug: Boolean,
) : Logger {

    override fun d(tag: String, message: String, throwable: Throwable?) {
        if (!isDebug) return
        if (throwable != null) Log.d(tag, message, throwable) else Log.d(tag, message)
    }

    override fun i(tag: String, message: String, throwable: Throwable?) {
        if (throwable != null) Log.i(tag, message, throwable) else Log.i(tag, message)
    }

    override fun w(tag: String, message: String, throwable: Throwable?) {
        if (throwable != null) Log.w(tag, message, throwable) else Log.w(tag, message)
    }

    override fun e(tag: String, message: String, throwable: Throwable?) {
        if (throwable != null) Log.e(tag, message, throwable) else Log.e(tag, message)
    }
}
