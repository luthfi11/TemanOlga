package com.wysiwyg.temanolga.ui.eventdetail

import android.os.Bundle

interface EventDetailView {
    fun showLoading()
    fun hideLoading()
    fun showEventData()
    fun showMap(savedInstanceState: Bundle?, long: String?, lat: String?, title: String?)
    fun hideMap()
    fun showJoinError()
    fun showJoinMsg()
    fun showRequested(joinId: String)
    fun showJoined(joinId: String)
    fun showDefJoin()
    fun showRequestError()
    fun showCancelJoinError()
    fun showCancelJoin(joinId: String)
    fun showDeleteConfirm()
    fun showDeleteError()
    fun isOwnPost()
    fun isUserPost()
    fun disableJoin(slotType: String)
    fun afterDelete()
    fun showFull()
    fun showExpire(date: String)
    fun showNoConnection()
    fun showJoinedUser()
    fun showNoUser()
}