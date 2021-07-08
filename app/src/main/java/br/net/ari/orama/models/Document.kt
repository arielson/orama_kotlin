package br.net.ari.orama.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class Document protected constructor(`in`: Parcel) : Parcelable {
    var position: Int
    var document_type: String?
    var name: String?
    var document_url: String?
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(position)
        dest.writeString(document_type)
        dest.writeString(name)
        dest.writeString(document_url)
    }

    companion object {
        @JvmField val CREATOR: Creator<Document?> = object : Creator<Document?> {
            override fun createFromParcel(`in`: Parcel): Document? {
                return Document(`in`)
            }

            override fun newArray(size: Int): Array<Document?> {
                return arrayOfNulls(size)
            }
        }
    }

    init {
        position = `in`.readInt()
        document_type = `in`.readString()
        name = `in`.readString()
        document_url = `in`.readString()
    }
}