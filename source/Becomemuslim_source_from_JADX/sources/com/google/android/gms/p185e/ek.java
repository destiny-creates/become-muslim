package com.google.android.gms.p185e;

import com.google.android.gms.internal.p210i.ct;
import java.util.Map;

/* renamed from: com.google.android.gms.e.ek */
abstract class ek extends cq {
    public ek(String str) {
        super(str);
    }

    /* renamed from: a */
    protected abstract boolean mo3468a(String str, String str2, Map<String, ct> map);

    /* renamed from: a */
    protected final boolean mo3298a(ct ctVar, ct ctVar2, Map<String, ct> map) {
        String a = eu.m8719a(ctVar);
        String a2 = eu.m8719a(ctVar2);
        if (a != eu.m8735f()) {
            if (a2 != eu.m8735f()) {
                return mo3468a(a, a2, (Map) map);
            }
        }
        return null;
    }
}
