package me.padi.nbhook.api

import com.highcapable.kavaref.KavaRef.Companion.asResolver

/**
 * 一些内部接口存在混淆不方便加入stub，因此无法推断类型
 * 此处封装一个不推断类型的api以供使用
 */
object QRoute {
    private val qroute = Class.forName("com.tencent.mobileqq.qroute.QRoute")

    fun api(cls: Class<*>): Any = qroute.asResolver().firstMethod {
        name = "api"
    }.invoke(cls) as Any
}