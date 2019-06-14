package com.google.android.gms.internal.p213l;

import com.google.android.gms.common.internal.C2872v;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.l.bi */
final class bi implements Runnable {
    /* renamed from: a */
    private final bh f16972a;
    /* renamed from: b */
    private final int f16973b;
    /* renamed from: c */
    private final Throwable f16974c;
    /* renamed from: d */
    private final byte[] f16975d;
    /* renamed from: e */
    private final String f16976e;
    /* renamed from: f */
    private final Map<String, List<String>> f16977f;

    private bi(String str, bh bhVar, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        C2872v.a(bhVar);
        this.f16972a = bhVar;
        this.f16973b = i;
        this.f16974c = th;
        this.f16975d = bArr;
        this.f16976e = str;
        this.f16977f = map;
    }

    public final void run() {
        this.f16972a.mo4763a(this.f16976e, this.f16973b, this.f16974c, this.f16975d, this.f16977f);
    }
}
