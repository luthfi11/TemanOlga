package com.wysiwyg.temanolga.ui.editprofile

interface EditProfileView {
    fun showLoading()
    fun hideLoading()
    fun showProfile()
    fun successUpdate()
    fun showEmailUsed()
    fun showFailUpdate()
    fun showProgress(value: Double)
    fun showUpdatedPhoto(imgPath: String)
    fun showNoConnection()
}