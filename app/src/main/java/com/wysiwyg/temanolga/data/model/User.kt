package com.wysiwyg.temanolga.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    var userId: String? = null,
    var fullName: String? = null,
    var email: String? = null,
    var accountType: String? = null,
    var sportPreferred: String? = null,
    var city: String? = null,
    var imgPath: String? = null,
    var tokenId: String? = null
) : Parcelable
