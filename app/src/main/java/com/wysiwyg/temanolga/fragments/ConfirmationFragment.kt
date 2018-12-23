package com.wysiwyg.temanolga.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wysiwyg.temanolga.R
import com.wysiwyg.temanolga.adapters.NotificationAdapter
import com.wysiwyg.temanolga.models.Join
import com.wysiwyg.temanolga.presenters.NotificationPresenter
import com.wysiwyg.temanolga.views.NotificationView
import kotlinx.android.synthetic.main.fragment_notification.*

class ConfirmationFragment: Fragment(), NotificationView {
    private var presenter = NotificationPresenter(this)
    private lateinit var adapter: NotificationAdapter
    private var notif: MutableList<Join> = mutableListOf()

    override fun showLoading() {
        srl_notif?.isRefreshing = true
    }

    override fun hideLoading() {
        srl_notif?.isRefreshing = false
    }

    override fun showNotification() {
        adapter = NotificationAdapter(notif)
        adapter.notifyDataSetChanged()
        rv_notif?.layoutManager = LinearLayoutManager(context)
        rv_notif?.adapter = adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onResume() {
        super.onResume()
        presenter.getConfirm(notif)
        srl_notif.setOnRefreshListener { presenter.getConfirm(notif) }
    }
}