package com.wysiwyg.temanolga.ui.login

import android.content.Context
import com.wysiwyg.temanolga.data.network.FirebaseApi
import com.wysiwyg.temanolga.utilities.ConnectionUtil

class LoginPresenter(private val view: LoginView) {

    fun login(ctx: Context?, email: String, password: String) {
        if (!ConnectionUtil.isOnline(ctx)) {
            view.hideLoading()
            view.showNoConnection()
        } else {
            view.showLoading()
            FirebaseApi.login(email, password, this)
        }
    }

    fun loginSuccess() {
        view.hideLoading()
        view.startActivity()
    }

    fun loginFailed() {
        view.hideLoading()
        view.showWrong()
    }
}