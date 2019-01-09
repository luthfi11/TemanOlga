package com.wysiwyg.temanolga.presenters

import android.content.Context
import com.wysiwyg.temanolga.api.FirebaseApi
import com.wysiwyg.temanolga.models.Event
import com.wysiwyg.temanolga.utils.ConnectionUtil
import com.wysiwyg.temanolga.views.EditEventView

class EditEventPresenter(private val view: EditEventView) {

    fun getDetail() {
        view.showDetail()
    }

    fun updateEvent(ctx: Context?, eventId: String, event: Event) {
        if (!ConnectionUtil.isOnline(ctx)) {
            view.hideLoading()
            view.showNoConnection()
        } else {
            view.showLoading()
            FirebaseApi.editEvent(this, eventId, event)
        }
    }

    fun updateSuccess() {
        view.hideLoading()
        view.showSuccessUpdate()
    }

    fun updateFailed() {
        view.hideLoading()
        view.showFailedUpdate()
    }
}