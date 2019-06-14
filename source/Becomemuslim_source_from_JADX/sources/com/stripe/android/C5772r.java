package com.stripe.android;

import android.content.Context;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.stripe.android.p285b.C5722b;
import com.stripe.android.p285b.C7157c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: StripeNetworkUtils */
/* renamed from: com.stripe.android.r */
public class C5772r {

    /* compiled from: StripeNetworkUtils */
    /* renamed from: com.stripe.android.r$a */
    interface C5771a {
        /* renamed from: a */
        String m24404a();

        /* renamed from: b */
        String m24405b();
    }

    /* renamed from: a */
    static Map<String, Object> m24407a(Context context, C7157c c7157c) {
        return C5772r.m24409a(null, context, c7157c);
    }

    /* renamed from: a */
    private static Map<String, Object> m24409a(C5771a c5771a, Context context, C7157c c7157c) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap2.put("number", C5775u.m24416a(c7157c.m33227g()));
        hashMap2.put("cvc", C5775u.m24416a(c7157c.m33229i()));
        hashMap2.put("exp_month", c7157c.m33230j());
        hashMap2.put("exp_year", c7157c.m33231k());
        hashMap2.put("name", C5775u.m24416a(c7157c.m33232l()));
        hashMap2.put("currency", C5775u.m24416a(c7157c.m33239s()));
        hashMap2.put("address_line1", C5775u.m24416a(c7157c.m33233m()));
        hashMap2.put("address_line2", C5775u.m24416a(c7157c.m33234n()));
        hashMap2.put("address_city", C5775u.m24416a(c7157c.m33235o()));
        hashMap2.put("address_zip", C5775u.m24416a(c7157c.m33236p()));
        hashMap2.put("address_state", C5775u.m24416a(c7157c.m33237q()));
        hashMap2.put("address_country", C5775u.m24416a(c7157c.m33238r()));
        C5772r.m24411a(hashMap2);
        hashMap.put("product_usage", c7157c.m33228h());
        hashMap.put("card", hashMap2);
        C5772r.m24410a(c5771a, context, hashMap);
        return hashMap;
    }

    /* renamed from: a */
    static Map<String, Object> m24406a(Context context, C5722b c5722b) {
        return C5772r.m24408a(null, context, c5722b);
    }

    /* renamed from: a */
    public static void m24411a(Map<String, Object> map) {
        Iterator it = new HashSet(map.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (map.get(str) == null) {
                map.remove(str);
            }
            if ((map.get(str) instanceof CharSequence) && TextUtils.isEmpty((CharSequence) map.get(str))) {
                map.remove(str);
            }
            if (map.get(str) instanceof Map) {
                C5772r.m24411a((Map) map.get(str));
            }
        }
    }

    /* renamed from: a */
    static void m24410a(C5771a c5771a, Context context, Map<String, Object> map) {
        String string;
        if (c5771a == null) {
            string = Secure.getString(context.getContentResolver(), "android_id");
        } else {
            string = c5771a.m24404a();
        }
        if (!C5775u.m24419b(string)) {
            String d = C5775u.m24421d(string);
            if (c5771a == null) {
                c5771a = new StringBuilder();
                c5771a.append(context.getApplicationContext().getPackageName());
                c5771a.append(string);
                c5771a = c5771a.toString();
            } else {
                context = new StringBuilder();
                context.append(c5771a.m24405b());
                context.append(string);
                c5771a = context.toString();
            }
            c5771a = C5775u.m24421d(c5771a);
            if (C5775u.m24419b(d) == null) {
                map.put("guid", d);
            }
            if (C5775u.m24419b(c5771a) == null) {
                map.put("muid", c5771a);
            }
        }
    }

    /* renamed from: a */
    private static Map<String, Object> m24408a(C5771a c5771a, Context context, C5722b c5722b) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap2.put(UserDataStore.COUNTRY, c5722b.m24192e());
        hashMap2.put("currency", c5722b.m24193f());
        hashMap2.put("account_number", c5722b.m24187a());
        hashMap2.put("routing_number", C5775u.m24416a(c5722b.m24196i()));
        hashMap2.put("account_holder_name", C5775u.m24416a(c5722b.m24189b()));
        hashMap2.put("account_holder_type", C5775u.m24416a(c5722b.m24190c()));
        C5772r.m24411a(hashMap2);
        hashMap.put("bank_account", hashMap2);
        C5772r.m24410a(c5771a, context, hashMap);
        return hashMap;
    }
}
