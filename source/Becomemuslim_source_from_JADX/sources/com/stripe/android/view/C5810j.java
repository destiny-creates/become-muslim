package com.stripe.android.view;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/* compiled from: PaymentUtils */
/* renamed from: com.stripe.android.view.j */
public class C5810j {
    /* renamed from: a */
    static String m24516a(long j, Currency currency, String str) {
        if (j == 0) {
            return str;
        }
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getCurrencyInstance();
        DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol(currency.getSymbol(Locale.getDefault()));
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        return C5810j.m24515a((double) j, currency);
    }

    /* renamed from: a */
    static String m24515a(double d, Currency currency) {
        d /= Math.pow(10.0d, (double) currency.getDefaultFractionDigits());
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        DecimalFormat decimalFormat = (DecimalFormat) currencyInstance;
        DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol(currency.getSymbol(Locale.getDefault()));
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        return currencyInstance.format(d);
    }
}
