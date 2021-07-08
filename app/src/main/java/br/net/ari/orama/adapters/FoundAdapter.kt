package br.net.ari.orama.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import br.net.ari.orama.R
import br.net.ari.orama.core.Utilities
import br.net.ari.orama.models.Fund
import com.squareup.picasso.Picasso
import java.util.*

class FoundAdapter(fragment: FragmentActivity?, private var mLista: List<Fund>) : BaseAdapter() {
    private val mInflater: LayoutInflater
            = fragment?.baseContext?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int {
        return mLista.size
    }

    override fun getItem(arg0: Int): Any {
        return mLista[arg0]
    }

    override fun getItemId(arg0: Int): Long {
        return arg0.toLong()
    }

    override fun getView(position: Int, rowView: View?, parent: ViewGroup): View? {
        var convertView = rowView
        val holder: ViewHolder
        val item: Fund = mLista[position]
        if (convertView  == null) {
            holder = ViewHolder()
            convertView = mInflater.inflate(R.layout.cardview_found, parent, false)
            holder.textViewSimpleName = convertView.findViewById(R.id.textViewSimpleName)
            holder.linearLayoutColor = convertView.findViewById(R.id.linearLayoutColor)
            holder.imageViewLogo = convertView.findViewById(R.id.imageViewLogo)
            holder.textViewAdministrationFee =
                convertView.findViewById(R.id.textViewAdministrationFee)
            holder.textViewMinimumInitialApplicationAmount =
                convertView.findViewById(R.id.textViewMinimumInitialApplicationAmount)
            convertView.tag = holder
        } else holder = convertView.tag as ViewHolder
        holder.textViewSimpleName!!.text = item.simple_name
        val rnd = Random()
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        holder.linearLayoutColor!!.setBackgroundColor(color)
        Picasso.get().load(Utilities.ServiceUrl + item.fund_manager?.logo)
            .placeholder(R.mipmap.ic_launcher).into(holder.imageViewLogo)
        holder.textViewAdministrationFee!!.text =
            String.format("%s %% (12M)", item.fees?.administration_fee)
        holder.textViewMinimumInitialApplicationAmount!!.text =
            String.format("R$ %s", item.operability?.minimum_initial_application_amount)

        return convertView
    }

    private class ViewHolder {
        var textViewSimpleName: TextView? = null
        var linearLayoutColor: LinearLayout? = null
        var imageViewLogo: ImageView? = null
        var textViewAdministrationFee: TextView? = null
        var textViewMinimumInitialApplicationAmount: TextView? = null
    }
}