package com.google.android.gms.common.api;

import android.support.v4.util.C3211a;
import android.text.TextUtils;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2781a.C2779d;
import com.google.android.gms.common.api.internal.cg;
import com.google.android.gms.common.internal.C2872v;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.common.api.c */
public class C2783c extends Exception {
    /* renamed from: a */
    private final C3211a<cg<?>, C4775b> f7104a;

    public C2783c(C3211a<cg<?>, C4775b> c3211a) {
        this.f7104a = c3211a;
    }

    /* renamed from: a */
    public C4775b m7937a(C2787e<? extends C2779d> c2787e) {
        c2787e = c2787e.m7951g();
        C2872v.m8391b(this.f7104a.get(c2787e) != null, "The given API was not part of the availability request.");
        return (C4775b) this.f7104a.get(c2787e);
    }

    /* renamed from: a */
    public final C3211a<cg<?>, C4775b> m7936a() {
        return this.f7104a;
    }

    public String getMessage() {
        Iterable arrayList = new ArrayList();
        Object obj = 1;
        for (cg cgVar : this.f7104a.keySet()) {
            C4775b c4775b = (C4775b) this.f7104a.get(cgVar);
            if (c4775b.m16826b()) {
                obj = null;
            }
            String a = cgVar.m8031a();
            String valueOf = String.valueOf(c4775b);
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(a).length() + 2) + String.valueOf(valueOf).length());
            stringBuilder.append(a);
            stringBuilder.append(": ");
            stringBuilder.append(valueOf);
            arrayList.add(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (obj != null) {
            stringBuilder2.append("None of the queried APIs are available. ");
        } else {
            stringBuilder2.append("Some of the queried APIs are unavailable. ");
        }
        stringBuilder2.append(TextUtils.join("; ", arrayList));
        return stringBuilder2.toString();
    }
}
