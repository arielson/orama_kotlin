package br.net.ari.orama.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class Description protected constructor(`in`: Parcel) : Parcelable {
    var objective: String?
    var movie_url: Any? = null
    var target_audience: String?
    var strengths: String?
    var strategy: String?
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(objective)
        dest.writeString(target_audience)
        dest.writeString(strengths)
        dest.writeString(strategy)
    }

    companion object {
        @JvmField val CREATOR: Creator<Description?> = object : Creator<Description?> {
            override fun createFromParcel(`in`: Parcel): Description? {
                return Description(`in`)
            }

            override fun newArray(size: Int): Array<Description?> {
                return arrayOfNulls(size)
            }
        }
    }

    init {
        objective = `in`.readString()
        target_audience = `in`.readString()
        strengths = `in`.readString()
        strategy = `in`.readString()
    }
}