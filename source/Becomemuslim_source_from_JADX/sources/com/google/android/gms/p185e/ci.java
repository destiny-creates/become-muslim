package com.google.android.gms.p185e;

import com.google.android.gms.internal.p210i.ct;
import java.util.Map;

/* renamed from: com.google.android.gms.e.ci */
abstract class ci extends cq {
    public ci(String str) {
        super(str);
    }

    /* renamed from: a */
    protected abstract boolean mo3469a(et etVar, et etVar2, Map<String, ct> map);

    /* renamed from: a */
    protected final boolean mo3298a(ct ctVar, ct ctVar2, Map<String, ct> map) {
        et b = eu.m8720b(ctVar);
        et b2 = eu.m8720b(ctVar2);
        if (b != eu.m8730e()) {
            if (b2 != eu.m8730e()) {
                return mo3469a(b, b2, (Map) map);
            }
        }
        return null;
    }
}
