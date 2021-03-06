package com.wysiwyg.temanolga.ui.profile

import android.content.Context
import com.wysiwyg.temanolga.data.network.FirebaseApi
import com.wysiwyg.temanolga.data.model.Event
import com.wysiwyg.temanolga.data.model.User
import com.wysiwyg.temanolga.utilities.ConnectionUtil
import com.wysiwyg.temanolga.utilities.ConnectionUtil.isOnline

class ProfilePresenter(private val view: ProfileView) {

    fun getUser(ctx: Context?, user: MutableList<User>) {
        view.showLoading()
        FirebaseApi.getCurrentUserData(user, this)

        if (!ConnectionUtil.isOnline(ctx)) {
            view.hideLoading()
            view.showNoConnection()
        }
    }

    fun getUserSuccess(user: MutableList<User>) {
        view.hideLoading()
        view.showUserData(user)
    }

    fun getUserEvent(events: MutableList<Event>) {
        view.showEventLoading()
        FirebaseApi.getUserEventData(events, this)
    }

    fun getUserEventSuccess(events: MutableList<Event>) {
        view.hideEventLoading()
        try {
            if (events.size == 0) {
                view.showEmptyEvent()
            } else {
                view.showEventData()
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    fun logoutPrompt() {
        view.showLogout()
    }

    fun logOut(ctx: Context?) {
        if (isOnline(ctx)) {
            FirebaseApi.logOut()
            view.doLogOut()
        } else {
            view.showLogoutError()
        }
    }
}