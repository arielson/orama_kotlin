package br.net.ari.orama.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import br.net.ari.orama.models.Benchmark
import br.net.ari.orama.models.Fees
import br.net.ari.orama.models.FundManager
import br.net.ari.orama.models.FundSituation
import br.net.ari.orama.models.Operability
import br.net.ari.orama.models.Profitabilities

class Fund protected constructor(`in`: Parcel) : Parcelable {
    var initial_date: String?
    var performance_audios: List<Any>? = null
    var fees: Fees?
    var is_simple: Boolean
    var description_seo: String?
    var operability: Operability?
    var full_name: String?
    var opening_date: Any? = null
    var id: Int
    var is_closed: Boolean
    var simple_name: String?
    var target_fund: Any? = null
    var documents: List<Document>? = null
    var specification: Specification?
    var quota_date: String?
    var tax_classification: String?
    var cnpj: String?
    var description: Description?
    var performance_videos: List<Any>? = null
    var is_active: Boolean
    var benchmark: Benchmark?
    var orama_standard: Boolean
    var slug: String?
    var fund_situation: FundSituation?
    var volatility_12m: String?
    var strategy_video: Any? = null
    var insurance_company_code: Any? = null
    var profitabilities: Profitabilities?
    var closed_to_capture_explanation: String?
    var closing_date: Any? = null
    var show_detailed_review: Boolean
    var net_patrimony_12m: String?
    var is_closed_to_capture: Boolean
    var fund_manager: FundManager?
    var esg_seal: Boolean
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(initial_date)
        dest.writeByte((if (is_simple) 1 else 0).toByte())
        dest.writeString(description_seo)
        dest.writeString(full_name)
        dest.writeInt(id)
        dest.writeByte((if (is_closed) 1 else 0).toByte())
        dest.writeString(simple_name)
        dest.writeString(quota_date)
        dest.writeString(tax_classification)
        dest.writeString(cnpj)
        dest.writeByte((if (is_active) 1 else 0).toByte())
        dest.writeByte((if (orama_standard) 1 else 0).toByte())
        dest.writeString(slug)
        dest.writeString(volatility_12m)
        dest.writeString(closed_to_capture_explanation)
        dest.writeByte((if (show_detailed_review) 1 else 0).toByte())
        dest.writeString(net_patrimony_12m)
        dest.writeByte((if (is_closed_to_capture) 1 else 0).toByte())
        dest.writeByte((if (esg_seal) 1 else 0).toByte())
        dest.writeParcelable(fund_manager, flags)
        dest.writeParcelable(fees, flags)
        dest.writeParcelable(operability, flags)
        dest.writeParcelable(fund_situation, flags)
        dest.writeParcelable(profitabilities, flags)
        dest.writeParcelable(benchmark, flags)
        dest.writeParcelable(specification, flags)
        dest.writeParcelable(description, flags)
    }

    companion object {
        @JvmField val CREATOR: Creator<Fund?> = object : Creator<Fund?> {
            override fun createFromParcel(`in`: Parcel): Fund? {
                return Fund(`in`)
            }

            override fun newArray(size: Int): Array<Fund?> {
                return arrayOfNulls(size)
            }
        }
    }

    init {
        initial_date = `in`.readString()
        is_simple = `in`.readByte().toInt() != 0
        description_seo = `in`.readString()
        full_name = `in`.readString()
        id = `in`.readInt()
        is_closed = `in`.readByte().toInt() != 0
        simple_name = `in`.readString()
        quota_date = `in`.readString()
        tax_classification = `in`.readString()
        cnpj = `in`.readString()
        is_active = `in`.readByte().toInt() != 0
        orama_standard = `in`.readByte().toInt() != 0
        slug = `in`.readString()
        volatility_12m = `in`.readString()
        closed_to_capture_explanation = `in`.readString()
        show_detailed_review = `in`.readByte().toInt() != 0
        net_patrimony_12m = `in`.readString()
        is_closed_to_capture = `in`.readByte().toInt() != 0
        esg_seal = `in`.readByte().toInt() != 0
        fund_manager = `in`.readParcelable(FundManager::class.java.classLoader)
        fees = `in`.readParcelable(Fees::class.java.classLoader)
        operability = `in`.readParcelable(Operability::class.java.classLoader)
        fund_situation = `in`.readParcelable(FundSituation::class.java.classLoader)
        profitabilities = `in`.readParcelable(Profitabilities::class.java.classLoader)
        benchmark = `in`.readParcelable(Benchmark::class.java.classLoader)
        specification = `in`.readParcelable(Specification::class.java.classLoader)
        description = `in`.readParcelable(Description::class.java.classLoader)
    }
}