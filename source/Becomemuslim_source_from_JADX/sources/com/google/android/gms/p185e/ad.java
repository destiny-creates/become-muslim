package com.google.android.gms.p185e;

import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ab;
import com.google.android.gms.internal.p210i.ct;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.e.ad */
final class ad extends es {
    /* renamed from: a */
    private static final String f13255a = C4992a.f16235C.toString();
    /* renamed from: b */
    private static final String f13256b = ab.f16296K.toString();
    /* renamed from: c */
    private static final String f13257c = ab.f16320h.toString();
    /* renamed from: d */
    private final C2934c f13258d;

    public ad(C2934c c2934c) {
        super(f13255a, f13256b);
        this.f13258d = c2934c;
    }

    /* renamed from: b */
    public final void mo3297b(Map<String, ct> map) {
        ct ctVar = (ct) map.get(f13256b);
        if (ctVar != null) {
            if (ctVar != eu.m8718a()) {
                Object f = eu.m8734f(ctVar);
                if (f instanceof List) {
                    for (Object next : (List) f) {
                        if (next instanceof Map) {
                            this.f13258d.m8617a((Map) next);
                        }
                    }
                }
            }
        }
        ct ctVar2 = (ct) map.get(f13257c);
        if (ctVar2 != null) {
            if (ctVar2 != eu.m8718a()) {
                String a = eu.m8719a(ctVar2);
                if (a != eu.m8735f()) {
                    this.f13258d.m8614a(a);
                }
            }
        }
    }
}
