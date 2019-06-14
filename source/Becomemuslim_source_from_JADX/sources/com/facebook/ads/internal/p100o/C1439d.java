package com.facebook.ads.internal.p100o;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.util.Locale;

/* renamed from: com.facebook.ads.internal.o.d */
public class C1439d {
    /* renamed from: a */
    public static String m5085a() {
        if (TextUtils.isEmpty(AdInternalSettings.getUrlPrefix())) {
            return "https://graph.facebook.com/network_ads_common";
        }
        return String.format("https://graph.%s.facebook.com/network_ads_common", new Object[]{AdInternalSettings.getUrlPrefix()});
    }

    /* renamed from: a */
    public static String m5086a(Context context) {
        String format = TextUtils.isEmpty(AdInternalSettings.getUrlPrefix()) ? "https://www.facebook.com/adnw_logging/" : String.format(Locale.US, "https://www.%s.facebook.com/adnw_logging/", new Object[]{AdInternalSettings.getUrlPrefix()});
        CharSequence v = C1405a.m4841v(context);
        return TextUtils.isEmpty(v) ? format : format.replace("www", v);
    }
}
