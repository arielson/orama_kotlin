package br.net.ari.orama.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class Operability protected constructor(`in`: Parcel) : Parcelable {
    var has_operations_on_thursdays: Boolean
    var retrieval_liquidation_days_type: String?
    var application_quotation_days_type: String?
    var retrieval_quotation_days: Int
    var anticipated_retrieval_quotation_days_type: String?
    var anticipated_retrieval_quotation_days_str: String?
    var retrieval_quotation_days_type: String?
    var anticipated_retrieval_quotation_days: Int
    var has_operations_on_wednesdays: Boolean
    var minimum_balance_permanence: String?
    var has_operations_on_mondays: Boolean
    var has_grace_period: Boolean
    var application_time_limit: String?
    var retrieval_time_limit: String?
    var has_operations_on_fridays: Boolean
    var anticipate_retrieval_liquidation_days: Int
    var minimum_initial_application_amount: String?
    var anticipate_retrieval_liquidation_days_type: String?
    var retrieval_special_type: String?
    var anticipate_retrieval_liquidation_days_str: String?
    var application_quotation_days_str: String?
    var grace_period_in_days_str: Any? = null
    var retrieval_quotation_days_str: String?
    var grace_period_in_days: Int
    var retrieval_liquidation_days_str: String?
    var minimum_subsequent_retrieval_amount: String?
    var retrieval_direct: Boolean
    var retrieval_liquidation_days: Int
    var application_quotation_days: Int
    var max_balance_permanence: String?
    var maximum_initial_application_amount: String?
    var has_operations_on_tuesdays: Boolean
    var minimum_subsequent_application_amount: String?
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeByte((if (has_operations_on_thursdays) 1 else 0).toByte())
        dest.writeString(retrieval_liquidation_days_type)
        dest.writeString(application_quotation_days_type)
        dest.writeInt(retrieval_quotation_days)
        dest.writeString(anticipated_retrieval_quotation_days_type)
        dest.writeString(anticipated_retrieval_quotation_days_str)
        dest.writeString(retrieval_quotation_days_type)
        dest.writeInt(anticipated_retrieval_quotation_days)
        dest.writeByte((if (has_operations_on_wednesdays) 1 else 0).toByte())
        dest.writeString(minimum_balance_permanence)
        dest.writeByte((if (has_operations_on_mondays) 1 else 0).toByte())
        dest.writeByte((if (has_grace_period) 1 else 0).toByte())
        dest.writeString(application_time_limit)
        dest.writeString(retrieval_time_limit)
        dest.writeByte((if (has_operations_on_fridays) 1 else 0).toByte())
        dest.writeInt(anticipate_retrieval_liquidation_days)
        dest.writeString(minimum_initial_application_amount)
        dest.writeString(anticipate_retrieval_liquidation_days_type)
        dest.writeString(retrieval_special_type)
        dest.writeString(anticipate_retrieval_liquidation_days_str)
        dest.writeString(application_quotation_days_str)
        dest.writeString(retrieval_quotation_days_str)
        dest.writeInt(grace_period_in_days)
        dest.writeString(retrieval_liquidation_days_str)
        dest.writeString(minimum_subsequent_retrieval_amount)
        dest.writeByte((if (retrieval_direct) 1 else 0).toByte())
        dest.writeInt(retrieval_liquidation_days)
        dest.writeInt(application_quotation_days)
        dest.writeString(max_balance_permanence)
        dest.writeString(maximum_initial_application_amount)
        dest.writeByte((if (has_operations_on_tuesdays) 1 else 0).toByte())
        dest.writeString(minimum_subsequent_application_amount)
    }

    companion object {
        @JvmField val CREATOR: Creator<Operability?> = object : Creator<Operability?> {
            override fun createFromParcel(`in`: Parcel): Operability? {
                return Operability(`in`)
            }

            override fun newArray(size: Int): Array<Operability?> {
                return arrayOfNulls(size)
            }
        }
    }

    init {
        has_operations_on_thursdays = `in`.readByte().toInt() != 0
        retrieval_liquidation_days_type = `in`.readString()
        application_quotation_days_type = `in`.readString()
        retrieval_quotation_days = `in`.readInt()
        anticipated_retrieval_quotation_days_type = `in`.readString()
        anticipated_retrieval_quotation_days_str = `in`.readString()
        retrieval_quotation_days_type = `in`.readString()
        anticipated_retrieval_quotation_days = `in`.readInt()
        has_operations_on_wednesdays = `in`.readByte().toInt() != 0
        minimum_balance_permanence = `in`.readString()
        has_operations_on_mondays = `in`.readByte().toInt() != 0
        has_grace_period = `in`.readByte().toInt() != 0
        application_time_limit = `in`.readString()
        retrieval_time_limit = `in`.readString()
        has_operations_on_fridays = `in`.readByte().toInt() != 0
        anticipate_retrieval_liquidation_days = `in`.readInt()
        minimum_initial_application_amount = `in`.readString()
        anticipate_retrieval_liquidation_days_type = `in`.readString()
        retrieval_special_type = `in`.readString()
        anticipate_retrieval_liquidation_days_str = `in`.readString()
        application_quotation_days_str = `in`.readString()
        retrieval_quotation_days_str = `in`.readString()
        grace_period_in_days = `in`.readInt()
        retrieval_liquidation_days_str = `in`.readString()
        minimum_subsequent_retrieval_amount = `in`.readString()
        retrieval_direct = `in`.readByte().toInt() != 0
        retrieval_liquidation_days = `in`.readInt()
        application_quotation_days = `in`.readInt()
        max_balance_permanence = `in`.readString()
        maximum_initial_application_amount = `in`.readString()
        has_operations_on_tuesdays = `in`.readByte().toInt() != 0
        minimum_subsequent_application_amount = `in`.readString()
    }
}