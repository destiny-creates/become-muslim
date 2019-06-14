package com.google.android.gms.p185e;

import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ab;
import com.google.android.gms.internal.p210i.ct;
import java.util.Map;

/* renamed from: com.google.android.gms.e.w */
final class C4403w extends aq {
    /* renamed from: a */
    private static final String f11749a = C4992a.f16265g.toString();
    /* renamed from: b */
    private static final String f11750b = ab.f16286A.toString();
    /* renamed from: c */
    private static final String f11751c = ab.f16323k.toString();
    /* renamed from: d */
    private final C2934c f11752d;

    public C4403w(C2934c c2934c) {
        super(f11749a, f11750b);
        this.f11752d = c2934c;
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return false;
    }

    /* renamed from: a */
    public final ct mo2506a(Map<String, ct> map) {
        Object b = this.f11752d.m8618b(eu.m8719a((ct) map.get(f11750b)));
        if (b != null) {
            return eu.m8716a(b);
        }
        ct ctVar = (ct) map.get(f11751c);
        if (ctVar != null) {
            return ctVar;
        }
        return eu.m8736g();
    }
}
