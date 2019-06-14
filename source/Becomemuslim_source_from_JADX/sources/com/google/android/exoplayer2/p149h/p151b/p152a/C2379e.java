package com.google.android.exoplayer2.p149h.p151b.p152a;

import java.util.Collections;
import java.util.List;

/* compiled from: Period */
/* renamed from: com.google.android.exoplayer2.h.b.a.e */
public class C2379e {
    /* renamed from: a */
    public final String f5856a;
    /* renamed from: b */
    public final long f5857b;
    /* renamed from: c */
    public final List<C2375a> f5858c;

    public C2379e(String str, long j, List<C2375a> list) {
        this.f5856a = str;
        this.f5857b = j;
        this.f5858c = Collections.unmodifiableList(list);
    }

    /* renamed from: a */
    public int m6572a(int i) {
        int size = this.f5858c.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C2375a) this.f5858c.get(i2)).f5831b == i) {
                return i2;
            }
        }
        return -1;
    }
}
