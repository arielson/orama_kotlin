package br.net.ari.orama

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.net.ari.orama.core.Constants
import br.net.ari.orama.models.Fund

class FundDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fund_details)
        val b = this.intent.extras
        var fund: Fund? = null
        if (b != null) fund = b.getParcelable(Constants.Fund)
        if (fund != null) {
            val actionBar = supportActionBar
            actionBar?.setDisplayHomeAsUpEnabled(true)
            actionBar?.subtitle = fund.simple_name
            val textViewFullName = findViewById<TextView>(R.id.textViewFullName)
            textViewFullName.text = fund.full_name
            val textViewManager = findViewById<TextView>(R.id.textViewManager)
            textViewManager.text = fund.fund_manager!!.description
            val textViewObjective = findViewById<TextView>(R.id.textViewObjective)
            textViewObjective.text = fund.description!!.objective
            val textViewStrategy = findViewById<TextView>(R.id.textViewStrategy)
            textViewStrategy.text = fund.description!!.strategy
        } else finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}