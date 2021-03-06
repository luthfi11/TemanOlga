package com.wysiwyg.temanolga.ui.userdetail

import com.wysiwyg.temanolga.data.model.User

interface UserDetailView {
    fun showUserData(user: List<User>)
    fun showEventData()
    fun showLoading()
    fun hideLoading()
    fun showEventLoading()
    fun hideEventLoading()
    fun showEmptyPost()
    fun showNoConnection()
}