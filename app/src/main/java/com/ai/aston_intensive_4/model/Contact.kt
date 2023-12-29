package com.ai.aston_intensive_4.model

import android.os.Parcel
import android.os.Parcelable
import com.ai.aston_intensive_4.R

data class Contact(
    val id: Int,
    val photoUrl: String? = "android.resource://com.ai.aston_intensive_4/" + R.drawable.incognito,
    val firstName: String? = "First name",
    val lastName: String? = "Last name",
    val phone: String? = "Phone"
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(photoUrl)
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

