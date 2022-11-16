package com.example.networkdemo.data.model.edplogin

import android.os.Parcel
import android.os.Parcelable

class ParcelableStore(): Parcelable {
    constructor(parcel: Parcel) : this() {

    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<ParcelableStore> {
        override fun createFromParcel(parcel: Parcel): ParcelableStore {
            return ParcelableStore(parcel)
        }

        override fun newArray(size: Int): Array<ParcelableStore?> {
            return arrayOfNulls(size)
        }
    }
}