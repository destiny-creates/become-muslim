package com.google.android.gms.p185e;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ab;
import com.google.android.gms.internal.p210i.ct;
import java.util.Map;

/* renamed from: com.google.android.gms.e.ez */
final class ez extends aq {
    /* renamed from: a */
    private static final String f11719a = C4992a.f16278t.toString();
    /* renamed from: b */
    private static final String f11720b = ab.f16321i.toString();
    /* renamed from: c */
    private static final String f11721c = ab.f16322j.toString();
    /* renamed from: d */
    private final Context f11722d;

    public ez(Context context) {
        super(f11719a, f11721c);
        this.f11722d = context;
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return true;
    }

    /* renamed from: a */
    public final ct mo2506a(Map<String, ct> map) {
        ct ctVar = (ct) map.get(f11721c);
        if (ctVar == null) {
            return eu.m8736g();
        }
        String a = eu.m8719a(ctVar);
        ct ctVar2 = (ct) map.get(f11720b);
        String a2 = ctVar2 != null ? eu.m8719a(ctVar2) : null;
        Context context = this.f11722d;
        String str = (String) bf.f7467a.get(a);
        if (str == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            str = sharedPreferences != null ? sharedPreferences.getString(a, "") : "";
            bf.f7467a.put(a, str);
        }
        Object a3 = bf.m8572a(str, a2);
        return a3 != null ? eu.m8716a(a3) : eu.m8736g();
    }
}
