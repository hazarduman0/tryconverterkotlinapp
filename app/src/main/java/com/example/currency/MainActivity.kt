package com.example.currency

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.AdapterView
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.currency.adapter.MenuItemAdapter
import com.example.currency.model.Currency
import com.example.currency.service.CurrencyService
import com.example.currency.utils.extensions.formatForDisplay

class MainActivity : AppCompatActivity() {

    lateinit var autoComplete : AutoCompleteTextView
    lateinit var txtDate : TextView

    lateinit var frBuyImg: ImageView
    lateinit var frBuyShort: TextView
    lateinit var frBuyCurrency: TextView
    lateinit var frBuySymbol: TextView
    lateinit var frBuyAmount: TextView
    lateinit var frSellImg: ImageView
    lateinit var frSellShort: TextView
    lateinit var frSellCurrency: TextView
    lateinit var frSellSymbol: TextView
    lateinit var frSellAmount: TextView

    lateinit var bnBuyImg: ImageView
    lateinit var bnBuyShort: TextView
    lateinit var bnBuyCurrency: TextView
    lateinit var bnBuySymbol: TextView
    lateinit var bnBuyAmount: TextView
    lateinit var bnSellImg: ImageView
    lateinit var bnSellShort: TextView
    lateinit var bnSellCurrency: TextView
    lateinit var bnSellSymbol: TextView
    lateinit var bnSellAmount: TextView

    lateinit var currenciesList: List<Currency>

    var service = CurrencyService()

    var choosenIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        currenciesList = service.getCurrencies()

        initView()

        val adapter = MenuItemAdapter(this,currenciesList)
        autoComplete.setAdapter(adapter)

        val date = CurrencyService.date
        txtDate.text = "Date: $date"

        fillView(currenciesList[choosenIndex])

        autoComplete.setOnItemClickListener(itemClickListener)

    }

    fun initView() {
        autoComplete = findViewById(R.id.autoComplete)

        txtDate = findViewById(R.id.txtDate)

        frBuyImg = findViewById(R.id.frBuyImg)
        frBuyShort = findViewById(R.id.frBuyShort)
        frBuyCurrency = findViewById(R.id.frBuyCurrency)
        frBuySymbol = findViewById(R.id.frBuySymboll)
        frBuyAmount = findViewById(R.id.frBuyAmount)
        frSellImg = findViewById(R.id.frSellImg)
        frSellShort = findViewById(R.id.frSellShort)
        frSellCurrency = findViewById(R.id.frSellCurr)
        frSellSymbol = findViewById(R.id.frSellSymboll)
        frSellAmount = findViewById(R.id.frSellAmount)

        bnBuyImg = findViewById(R.id.bnBuyImg)
        bnBuyShort = findViewById(R.id.bnBuyShort)
        bnBuyCurrency = findViewById(R.id.bnBuyCurrency)
        bnBuySymbol = findViewById(R.id.bnBuySymboll)
        bnBuyAmount = findViewById(R.id.bnBuyAmount)
        bnSellImg = findViewById(R.id.bnSellImg)
        bnSellShort = findViewById(R.id.bnSellShort)
        bnSellCurrency = findViewById(R.id.bnSellCurr)
        bnSellSymbol = findViewById(R.id.bnSellSymboll)
        bnSellAmount = findViewById(R.id.bnSellAmount)

    }

    fun fillView(currency: Currency){
        Glide.with(this).load(imageUrl(currency.currencyCode)).into(frBuyImg)
        frBuyShort.text = currency.currencyCode
        frBuyCurrency.text = currency.currencyName
        frBuySymbol.text = currency.currencyCode.formatForDisplay()
        frBuyAmount.text = currency.forexBuying
        Glide.with(this).load(imageUrl(currency.currencyCode)).into(frSellImg)
        frSellShort.text = currency.currencyCode
        frSellCurrency.text = currency.currencyName
        frSellSymbol.text = currency.currencyCode.formatForDisplay()
        frSellAmount.text = currency.forexSelling

        Glide.with(this).load(imageUrl(currency.currencyCode)).into(bnBuyImg)
        bnBuyShort.text = currency.currencyCode
        bnBuyCurrency.text = currency.currencyName
        bnBuySymbol.text = currency.currencyCode.formatForDisplay()
        bnBuyAmount.text = currency.banknoteBuying
        Glide.with(this).load(imageUrl(currency.currencyCode)).into(bnSellImg)
        bnSellShort.text = currency.currencyCode
        bnSellCurrency.text = currency.currencyName
        bnSellSymbol.text = currency.currencyCode.formatForDisplay()
        bnSellAmount.text = currency.banknoteSelling
    }

    fun imageUrl(code: String) : String = "https://www.tcmb.gov.tr/kurlar/kurlar_tr_dosyalar/images/$code.gif"

    val itemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
        fillView(currenciesList[i])
        false
    }




}