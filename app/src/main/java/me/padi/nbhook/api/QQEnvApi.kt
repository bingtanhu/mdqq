package me.padi.nbhook.api

import com.highcapable.kavaref.KavaRef.Companion.asResolver
import com.tencent.mobileqq.app.QQAppInterface
import com.tencent.qphone.base.remote.ToServiceMsg
import mqq.manager.Manager

/**
 * QQ环境相关Api
 */
object QQEnvApi {
    lateinit var sQApi: QQAppInterface

    fun getCurrentUin(): String = sQApi.currentAccountUin

    fun getCurrentNickName(): String = sQApi.currentNickname

    fun exit(needPCActive: Boolean) {
        sQApi.asResolver().firstMethod { name = "exit" }.invoke(needPCActive)
    }

    fun getManager(type: Int): Manager = sQApi.getManager(type)

    /**
     * 获取MessageFacade
     * 需要注意的是，MessageFacade 在QQNT时已废弃并下沉混淆
     */
    fun getMessageFacade(): Any = sQApi.asResolver().firstMethod { name = "getMessageFacade" }.invoke() as Any

    fun isLogin(): Boolean = sQApi.isLogin()

    fun logout(bool: Boolean) = sQApi.logout(bool)

    fun setAutoLogin(mode: Boolean) = sQApi.setAutoLogin(mode)

    fun sendToService(toServiceMsg: ToServiceMsg) = sQApi.sendToService(toServiceMsg)
}