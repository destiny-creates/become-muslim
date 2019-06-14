package com.google.android.gms.internal.p210i;

import android.content.Context;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.common.util.C4376h;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.cw */
public final class cw {
    /* renamed from: a */
    private final Context f16463a;
    /* renamed from: b */
    private final dg f16464b;
    /* renamed from: c */
    private final C2895e f16465c;
    /* renamed from: d */
    private String f16466d;
    /* renamed from: e */
    private Map<String, Object> f16467e;
    /* renamed from: f */
    private final Map<String, Object> f16468f;

    public cw(Context context) {
        this(context, new HashMap(), new dg(context), C4376h.d());
    }

    private cw(Context context, Map<String, Object> map, dg dgVar, C2895e c2895e) {
        this.f16466d = null;
        this.f16467e = new HashMap();
        this.f16463a = context;
        this.f16465c = c2895e;
        this.f16464b = dgVar;
        this.f16468f = map;
    }

    /* renamed from: a */
    public final void m20397a(String str) {
        this.f16466d = str;
    }
}
