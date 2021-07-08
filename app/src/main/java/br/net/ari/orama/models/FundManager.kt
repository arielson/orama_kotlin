package br.net.ari.orama.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class FundManager protected constructor(`in`: Parcel) : Parcelable {
    var description: String?
    var id: Int
    var full_name: String?
    var logo: String?
    var slug: String?
    var name: String?
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(description)
        dest.writeInt(id)
        dest.writeString(full_name)
        dest.writeString(logo)
        dest.writeString(slug)
        dest.writeString(name)
    }

    companion object {
        @JvmField val CREATOR: Creator<FundManager?> = object : Creator<FundManager?> {
            override fun createFromParcel(`in`: Parcel): FundManager? {
                return FundManager(`in`)
            }

            override fun newArray(size: Int): Array<FundManager?> {
                return arrayOfNulls(size)
            }
        }
    }

    init {
        description = `in`.readString()
        id = `in`.readInt()
        full_name = `in`.readString()
        logo = `in`.readString()
        slug = `in`.readString()
        name = `in`.readString()
    }
}