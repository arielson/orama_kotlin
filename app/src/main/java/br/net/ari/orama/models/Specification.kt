package br.net.ari.orama.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class Specification protected constructor(`in`: Parcel) : Parcelable {
    var fund_main_strategy_name: String?
    var fund_suitability_profile: FundSuitabilityProfile? = null
    var fund_risk_profile: FundRiskProfile? = null
    var fund_main_strategy_explanation: String?
    var fund_type: String?
    var fund_class: String?
    var fund_macro_strategy: FundMacroStrategy? = null
    var fund_class_anbima: String?
    var fund_main_strategy: FundMainStrategy? = null
    var is_qualified: Boolean
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(fund_main_strategy_name)
        dest.writeString(fund_main_strategy_explanation)
        dest.writeString(fund_type)
        dest.writeString(fund_class)
        dest.writeString(fund_class_anbima)
        dest.writeByte((if (is_qualified) 1 else 0).toByte())
    }

    companion object {
        @JvmField val CREATOR: Creator<Specification?> = object : Creator<Specification?> {
            override fun createFromParcel(`in`: Parcel): Specification? {
                return Specification(`in`)
            }

            override fun newArray(size: Int): Array<Specification?> {
                return arrayOfNulls(size)
            }
        }
    }

    init {
        fund_main_strategy_name = `in`.readString()
        fund_main_strategy_explanation = `in`.readString()
        fund_type = `in`.readString()
        fund_class = `in`.readString()
        fund_class_anbima = `in`.readString()
        is_qualified = `in`.readByte().toInt() != 0
    }
}