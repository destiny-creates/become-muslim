package com.google.android.gms.p185e;

import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ct;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.e.bn */
public final class bn extends aq {
    /* renamed from: a */
    private static final String f11638a = C4992a.f16270l.toString();

    public bn() {
        super(f11638a, new String[0]);
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return false;
    }

    /* renamed from: a */
    public final ct mo2506a(Map<String, ct> map) {
        map = Locale.getDefault();
        if (map == null) {
            return eu.m8736g();
        }
        map = map.getLanguage();
        if (map == null) {
            return eu.m8736g();
        }
        return eu.m8716a(map.toLowerCase());
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Set mo2513c() {
        return super.mo2513c();
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ String mo2512b() {
        return super.mo2512b();
    }
}
