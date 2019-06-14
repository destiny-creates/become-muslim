package com.google.android.gms.p185e;

import android.content.Context;
import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ab;
import com.google.android.gms.internal.p210i.ct;
import java.util.Map;

/* renamed from: com.google.android.gms.e.be */
final class be extends aq {
    /* renamed from: a */
    private static final String f11629a = C4992a.f16283y.toString();
    /* renamed from: b */
    private static final String f11630b = ab.f16321i.toString();
    /* renamed from: c */
    private final Context f11631c;

    public be(Context context) {
        super(f11629a, new String[0]);
        this.f11631c = context;
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return true;
    }

    /* renamed from: a */
    public final ct mo2506a(Map<String, ct> map) {
        Object a = bf.m8571a(this.f11631c, ((ct) map.get(f11630b)) != null ? eu.m8719a((ct) map.get(f11630b)) : null);
        return a != null ? eu.m8716a(a) : eu.m8736g();
    }
}
