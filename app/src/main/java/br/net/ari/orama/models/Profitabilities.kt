package br.net.ari.orama.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class Profitabilities protected constructor(`in`: Parcel) : Parcelable {
    var m60: String?
    var m48: String?
    var m24: String?
    var m36: String?
    var month: String?
    var m12: String?
    var year: String?
    var day: String?
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(m60)
        dest.writeString(m48)
        dest.writeString(m24)
        dest.writeString(m36)
        dest.writeString(month)
        dest.writeString(m12)
        dest.writeString(year)
        dest.writeString(day)
    }

    companion object {
        @JvmField val CREATOR: Creator<Profitabilities?> = object : Creator<Profitabilities?> {
            override fun createFromParcel(`in`: Parcel): Profitabilities? {
                return Profitabilities(`in`)
            }

            override fun newArray(size: Int): Array<Profitabilities?> {
                return arrayOfNulls(size)
            }
        }
    }

    init {
        m60 = `in`.readString()
        m48 = `in`.readString()
        m24 = `in`.readString()
        m36 = `in`.readString()
        month = `in`.readString()
        m12 = `in`.readString()
        year = `in`.readString()
        day = `in`.readString()
    }
}