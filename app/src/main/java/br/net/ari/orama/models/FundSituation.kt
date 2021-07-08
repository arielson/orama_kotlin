package br.net.ari.orama.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class FundSituation protected constructor(`in`: Parcel) : Parcelable {
    var code: String?
    var name: String?
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(code)
        dest.writeString(name)
    }

    companion object {
        @JvmField val CREATOR: Creator<FundSituation?> = object : Creator<FundSituation?> {
            override fun createFromParcel(`in`: Parcel): FundSituation? {
                return FundSituation(`in`)
            }

            override fun newArray(size: Int): Array<FundSituation?> {
                return arrayOfNulls(size)
            }
        }
    }

    init {
        code = `in`.readString()
        name = `in`.readString()
    }
}