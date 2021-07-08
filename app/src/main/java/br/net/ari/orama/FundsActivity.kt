package br.net.ari.orama

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import br.net.ari.orama.adapters.FoundAdapter
import br.net.ari.orama.core.Constants
import br.net.ari.orama.core.Utilities
import br.net.ari.orama.models.Fund
import br.net.ari.orama.viewmodels.FoundsViewModel


class FundsActivity : AppCompatActivity() {
    private var foundsViewModel: FoundsViewModel? = null
    private var listViewFounds: ListView? = null
    private var swipeRefreshFunds: SwipeRefreshLayout? = null
    var relativeLayoutLoading: RelativeLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funds)
        listViewFounds = findViewById(R.id.listViewFunds)
        swipeRefreshFunds = findViewById(R.id.swipeRefreshFunds)
        relativeLayoutLoading = findViewById(R.id.relativeLayoutLoading)
        swipeRefreshFunds?.setOnRefreshListener { reloadFunds() }
        foundsViewModel = ViewModelProvider(this).get(FoundsViewModel::class.java)
        foundsViewModel!!.getMessage().observe(this, { message: String ->
            if (message.isNotEmpty()) {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                foundsViewModel!!.clearMessage()
            }
            relativeLayoutLoading?.visibility = View.GONE
        })
        loadFunds()
    }

    private fun loadFunds() {
        if (Utilities.IsNetworkAvailable(this)) {
            foundsViewModel!!.getFunds().observe(this,
                { funds: List<Fund>? ->
                    listViewFounds?.adapter = funds?.let { FoundAdapter(this, it) }
                    relativeLayoutLoading!!.visibility = View.GONE
                    listViewFounds?.setOnItemClickListener { _, view, position, _ ->
                        val item = funds!![position]
                        val intent = Intent()
                        val bundle = Bundle()
                        bundle.putParcelable(Constants.Fund, item)
                        intent.putExtras(bundle)
                        intent.setClass(view.context, FundDetailsActivity::class.java)
                        startActivity(intent)
                    }
                    swipeRefreshFunds!!.isRefreshing = false
                })
        }
    }

    private fun reloadFunds() {
        foundsViewModel!!.clearFunds()
        loadFunds()
    }
}