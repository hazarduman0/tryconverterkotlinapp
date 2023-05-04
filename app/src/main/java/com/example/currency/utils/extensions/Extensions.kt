package com.example.currency.utils.extensions

import com.example.currency.utils.enums.CurrencyTypes

    fun String.formatForDisplay() : String {

        var str = ""

        when(this){
            CurrencyTypes.Types.USD.name -> str = "\$"
            CurrencyTypes.Types.AUD.name -> str =  "\$"
            CurrencyTypes.Types.DKK.name -> str =  "kr"
            CurrencyTypes.Types.EUR.name -> str =  "€"
            CurrencyTypes.Types.GBP.name -> str =  "£"
            CurrencyTypes.Types.CHF.name -> str =  "Fr"
            CurrencyTypes.Types.SEK.name -> str =  "kr"
            CurrencyTypes.Types.CAD.name -> str =  "\$"
            CurrencyTypes.Types.KWD.name -> str =  "KD"
            CurrencyTypes.Types.NOK.name -> str =  "kr"
            CurrencyTypes.Types.SAR.name -> str =  "SR"
            CurrencyTypes.Types.JPY.name -> str =  "¥"
            CurrencyTypes.Types.BGN.name -> str =  "лв"
            CurrencyTypes.Types.RON.name -> str =  "RON"
            CurrencyTypes.Types.RUB.name -> str =  "₽"
            CurrencyTypes.Types.IRR.name -> str =  "IR"
            CurrencyTypes.Types.CNY.name -> str =  "¥"
            CurrencyTypes.Types.PKR.name -> str =  "Re"
            CurrencyTypes.Types.QAR.name -> str =  "QR"
            CurrencyTypes.Types.KRW.name -> str =  "₩"
            CurrencyTypes.Types.AZN.name -> str =  "₼"
            CurrencyTypes.Types.AED.name -> str =  "DH"
            else -> str =  ""
        }
        return str
    }


