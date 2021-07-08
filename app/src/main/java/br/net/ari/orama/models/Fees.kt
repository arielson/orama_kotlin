package br.net.ari.orama.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class Fees protected constructor(`in`: Parcel) : Parcelable {
    var maximum_administration_fee: String?
    var anticipated_retrieval_fee_value: String?
    var administration_fee: String?
    var anticipated_retrieval_fee: String?
    var performance_fee: String?
    var has_anticipated_retrieval: Boolean
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(maximum_administration_fee)
        dest.writeString(anticipated_retrieval_fee_value)
        dest.writeString(administration_fee)
        dest.writeString(anticipated_retrieval_fee)
        dest.writeString(performance_fee)
        dest.writeByte((if (has_anticipated_retrieval) 1 else 0).toByte())
    }

    companion object {
        @JvmField val CREATOR: Creator<Fees?> = object : Creator<Fees?> {
            override fun createFromParcel(`in`: Parcel): Fees? {
                return Fees(`in`)
            }

            override fun newArray(size: Int): Array<Fees?> {
                return arrayOfNulls(size)
            }
        }
    }

    init {
        maximum_administration_fee = `in`.readString()
        anticipated_retrieval_fee_value = `in`.readString()
        administration_fee = `in`.readString()
        anticipated_retrieval_fee = `in`.readString()
        performance_fee = `in`.readString()
        has_anticipated_retrieval = `in`.readByte().toInt() != 0
    }
}