package expo.modules.localization;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import expo.p304a.C6006c;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class LocalizationModule extends C6006c {
    private WeakReference<Context> mContextRef;

    public String getName() {
        return "ExpoLocalization";
    }

    public LocalizationModule(Context context) {
        super(context);
        this.mContextRef = new WeakReference(context);
    }

    private final Context getApplicationContext() {
        Context context = (Context) this.mContextRef.get();
        return context != null ? context.getApplicationContext() : null;
    }

    public Map<String, Object> getConstants() {
        Map hashMap = new HashMap();
        Bundle bundledConstants = getBundledConstants();
        for (String str : bundledConstants.keySet()) {
            hashMap.put(str, bundledConstants.get(str));
        }
        return hashMap;
    }

    @C5996c
    public void getLocalizationAsync(C6009f c6009f) {
        c6009f.mo5137a(getBundledConstants());
    }

    private Bundle getBundledConstants() {
        Bundle bundle = new Bundle();
        ArrayList locales = getLocales();
        ArrayList localeNames = getLocaleNames(locales);
        boolean z = true;
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
            z = false;
        }
        bundle.putBoolean("isRTL", Boolean.valueOf(z).booleanValue());
        bundle.putString("locale", (String) localeNames.get(0));
        bundle.putStringArrayList("locales", localeNames);
        bundle.putString("timezone", TimeZone.getDefault().getID());
        bundle.putStringArrayList("isoCurrencyCodes", getISOCurrencyCodes());
        bundle.putString(UserDataStore.COUNTRY, ((Locale) locales.get(0)).getCountry());
        return bundle;
    }

    private ArrayList<String> getISOCurrencyCodes() {
        ArrayList<String> arrayList = new ArrayList();
        for (Currency currencyCode : Currency.getAvailableCurrencies()) {
            arrayList.add(currencyCode.getCurrencyCode());
        }
        return arrayList;
    }

    private ArrayList<Locale> getLocales() {
        ArrayList<Locale> arrayList = new ArrayList();
        Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
            Configuration configuration = applicationContext.getResources().getConfiguration();
            if (VERSION.SDK_INT >= 24) {
                LocaleList locales = configuration.getLocales();
                for (int i = 0; i < locales.size(); i++) {
                    arrayList.add(locales.get(i));
                }
            } else {
                arrayList.add(configuration.locale);
            }
        }
        return arrayList;
    }

    private ArrayList<String> getLocaleNames(ArrayList<Locale> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(toLocaleTag((Locale) arrayList.get(i)));
        }
        return arrayList2;
    }

    private String toLocaleTag(Locale locale) {
        locale = locale.toLanguageTag();
        return locale.matches("^(iw|in|ji).*") ? locale.replace("iw", "he").replace("in", "id").replace("ji", "yi") : locale;
    }
}
