package br.net.ari.orama.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class Benchmark protected constructor(`in`: Parcel) : Parcelable {
    var id: Int
    var name: String?
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(name)
    }

    companion object {
        @JvmField val CREATOR: Creator<Benchmark?> = object : Creator<Benchmark?> {
            override fun createFromParcel(`in`: Parcel): Benchmark? {
                return Benchmark(`in`)
            }

            override fun newArray(size: Int): Array<Benchmark?> {
                return arrayOfNulls(size)
            }
        }
    }

    init {
        id = `in`.readInt()
        name = `in`.readString()
    }
}