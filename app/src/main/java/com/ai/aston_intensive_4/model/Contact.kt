package com.ai.aston_intensive_4.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes

data class Contact(
    val id: Int,
    @DrawableRes val photo: Int,
    val firstName: String?,
    val lastName: String?,
    val phone: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(photo)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(phone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Contact> {
        override fun createFromParcel(parcel: Parcel): Contact {
            return Contact(parcel)
        }

        override fun newArray(size: Int): Array<Contact?> {
            return arrayOfNulls(size)
        }
    }
}

