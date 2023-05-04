package com.example.currency.service

import android.util.Log
import com.example.currency.model.Currency
import org.jsoup.Jsoup
import org.jsoup.select.Elements

class CurrencyService {

    val url = "https://www.tcmb.gov.tr/kurlar/today.xml"

    companion object{
        var date : String? = null
    }

    fun getCurrencies() : List<Currency>{
        val arr = mutableListOf<Currency>()

        val doc = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get()

        date = doc.select("Tarih_Date").attr("Tarih")

        val currencyData : Elements = doc.getElementsByTag("Currency")

        for (currency in currencyData){
            val name = currency.getElementsByTag("Isim").text()
            val currencyName = currency.getElementsByTag("CurrencyName").text()
            val forexBuying = currency.getElementsByTag("ForexBuying").text()
            val forexSelling = currency.getElementsByTag("ForexSelling").text()
            val banknoteBuying = currency.getElementsByTag("BanknoteBuying").text()
            val banknoteSelling = currency.getElementsByTag("BanknoteSelling").text()
            val currencyCode = currency.attr("CurrencyCode")

            val currency = Currency(name,currencyName, forexBuying, forexSelling, banknoteBuying, banknoteSelling, currencyCode)
            arr.add(currency)
        }

        return arr
    }

}