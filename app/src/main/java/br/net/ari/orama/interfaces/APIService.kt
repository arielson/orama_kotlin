package br.net.ari.orama.interfaces

import br.net.ari.orama.models.Fund
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("json/fund_detail_full.json")
    fun GetFundos(@Query("serializ er") tipo: String?): Call<List<Fund>?>?
}