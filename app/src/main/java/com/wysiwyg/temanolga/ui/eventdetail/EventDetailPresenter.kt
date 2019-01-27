package com.wysiwyg.temanolga.ui.eventdetail

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.wysiwyg.temanolga.data.network.FirebaseApi
import com.wysiwyg.temanolga.data.model.Event
import com.wysiwyg.temanolga.data.model.User
import com.wysiwyg.temanolga.utilities.ConnectionUtil

class EventDetailPresenter(private val view: EventDetailView) {

    fun getData(ctx: Context?, eventId: String, event: MutableList<Event>) {
        view.showLoading()
        FirebaseApi.getEventDetail(eventId, this, event)

        if (!ConnectionUtil.isOnline(ctx)) {
            view.hideLoading()
            view.showNoConnection()
        }
    }

    fun getDataSuccess() {
        view.hideLoading()
        view.showEventData()
    }

    fun getMap(savedInstanceState: Bundle?, long: String?, lat: String?, title: String?) {
        view.showMap(savedInstanceState, long, lat, title)
    }

    fun hideMap() {
        view.hideMap()
    }

    fun joinEvent(eventId: String?, postSender: String?) {
        FirebaseApi.joinEvent(this, eventId, postSender)
    }

    fun joinSuccess() {
        view.showJoinMsg()
    }

    fun checkPost(postSender: String?) {
        if (postSender == FirebaseApi.currentUser()) {
            view.isOwnPost()
        } else {
            view.isUserPost()
        }
    }

    fun checkAccType(slotType: String) {
        FirebaseApi.checkAccType(slotType, this)
    }

    fun disableJoin(slotType: String) {
        view.disableJoin(slotType)
    }

    fun checkJoin(eventId: String?) {
        FirebaseApi.checkJoin(this, eventId)
    }

    fun isRequested(joinId: String) {
        view.showRequested(joinId)
    }

    fun isJoin(joinId: String) {
        view.showJoined(joinId)
    }

    fun defaultJoin() {
        view.showDefJoin()
    }

    fun cancelConfirm(joinId: String) {
        view.showCancelJoin(joinId)
    }

    fun cancelRequest(eventId: String, joinId: String) {
        FirebaseApi.cancelRequest(eventId, joinId)
        view.showDefJoin()
    }

    fun cancelJoin(eventId: String, joinId: String) {
        FirebaseApi.cancelJoin(eventId, joinId)
        view.showDefJoin()
    }

    fun deleteConfirm() {
        view.showDeleteConfirm()
    }

    fun delete(eventId: String) {
        FirebaseApi.deletePost(eventId)
        view.afterDelete()
    }

    fun isFull(slotFill: Int?, slot: Int?) {
        if (slot != null && slotFill == slot) {
            view.showFull()
        }
    }

    fun isExpire(date: String) {
        view.showExpire(date)
    }

    fun joinedUser(eventId: String, user: MutableList<User?>) {
        FirebaseApi.getJoinedUser(eventId, user)
    }

    fun showJoinedUser(user: MutableList<User?>) {
        if (user.size == 0) {
            view.showNoUser()
        } else {
            view.showJoinedUser()
        }
    }
}