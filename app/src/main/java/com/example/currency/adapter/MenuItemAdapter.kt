package com.example.currency.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.currency.R
import com.example.currency.model.Currency

class MenuItemAdapter(private val context: Activity, private val list: List<Currency>) : ArrayAdapter<Currency>(context,
    R.layout.menu_item, list){

    private var currencyListFull = ArrayList<Currency>(list)

    fun imageUrl(code: String) : String = "https://www.tcmb.gov.tr/kurlar/kurlar_tr_dosyalar/images/$code.gif"


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.menu_item, null, true)

        val currency : Currency = list[position]
        val imgUrl = imageUrl(currency.currencyCode)

        val r_txt = rootView.findViewById<TextView>(R.id.menuCurrencyText)
        val r_img = rootView.findViewById<ImageView>(R.id.menuCurrencyImage)

        r_txt.text = currency.currencyName

        Glide.with(rootView).load(imgUrl).into(r_img)

        return rootView
    }

    /*
    override fun getFilter(): Filter {
        return nameFilter
    }

    private var nameFilter: Filter = object : Filter(){
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            var result : FilterResults = FilterResults()
            var suggestions : MutableList<Currency> = arrayListOf()

            if (constraint == null || constraint.isEmpty()){
                suggestions.addAll(currencyListFull)
            }else{
                var filterPattern : String = constraint.toString().trim()

                for (item in currencyListFull){
                    if(item.)
                }
            }
        }

        override fun publishResults(constraint: CharSequence?, result: FilterResults?) {
            TODO("Not yet implemented")
        }
    } */


}
/*
class StreetsAdapter(private val mContext: Context,
                     private val viewResourceId: Int,
                     private val items: ArrayList<Currency>) : ArrayAdapter<Currency?>(mContext, viewResourceId, items.toList()) {

    private val itemsAll = items.clone() as ArrayList<Currency>
    private var suggestions = ArrayList<Currency>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var v: View? = convertView
        if (v == null) {
            val vi = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            v = vi.inflate(viewResourceId, null)
        }
        val street: Currency? = items[position]
        if (street != null) {
            val streetTitle = v?.findViewById(R.id.menuCurrencyText) as TextView?
            streetTitle?.text = street.currencyName
        }
        return v!!
    }

    override fun getFilter(): Filter {
        return nameFilter
    }

    private var nameFilter: Filter = object : Filter() {
        override fun convertResultToString(resultValue: Any): String {
            return (resultValue as Currency).name
        }

        override fun performFiltering(constraint: CharSequence?): FilterResults {
            return if (constraint != null) {
                suggestions.clear()
                for (street in itemsAll) {
                    if (street.banknoteBuying.toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                        suggestions.add(street)
                    }
                }
                val filterResults = FilterResults()
                filterResults.values = suggestions
                filterResults.count = suggestions.size
                filterResults
            } else {
                FilterResults()
            }
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            val filteredList =  results?.values as ArrayList<Currency>?

            if (results != null && results.count > 0) {
                clear()
                for (c: Currency in filteredList ?: listOf<Currency>()) {
                    add(c)
                }
                notifyDataSetChanged()
            }
        }
    }
} */