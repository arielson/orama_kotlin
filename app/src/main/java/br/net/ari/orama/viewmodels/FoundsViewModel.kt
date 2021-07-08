package br.net.ari.orama.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.net.ari.orama.core.Utilities.Service
import br.net.ari.orama.models.Fund
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.stream.Collectors

class FoundsViewModel : ViewModel() {
    private var message: MutableLiveData<String>? = null
    fun getMessage(): MutableLiveData<String> {
        if (message == null) message = MutableLiveData()
        return message as MutableLiveData<String>
    }

    fun clearMessage() {
        if (message == null) message = MutableLiveData()
        message!!.postValue("")
    }

    private var funds: MutableLiveData<List<Fund>?>? = null
    fun getFunds(): LiveData<List<Fund>?> {
        if (funds == null) {
            funds = MutableLiveData()
            loadFunds()
        }
        return funds!!
    }

    private fun loadFunds() {
        Service()!!.GetFundos("fund_detail_full")!!.enqueue(object : Callback<List<Fund>?> {
            override fun onResponse(call: Call<List<Fund>?>, response: Response<List<Fund>?>) {
                if (response.isSuccessful) {
                    var items = response.body()!!
                    items = items.stream().filter { fund: Fund -> fund.is_active }
                        .collect(Collectors.toList())
                    funds!!.postValue(items)
                } else {
                    try {
                        assert(response.errorBody() != null)
                        message!!.postValue("Ocorreu um erro na requisição. Tente novamente mais tarde.")
                        Log.d("Founds", response.errorBody()!!.string())
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<List<Fund>?>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun clearFunds() {
        if (funds != null) funds = MutableLiveData()
        loadFunds()
    }
}
