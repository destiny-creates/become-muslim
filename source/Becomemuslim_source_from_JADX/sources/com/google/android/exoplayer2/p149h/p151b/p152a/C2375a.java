package com.google.android.exoplayer2.p149h.p151b.p152a;

import java.util.Collections;
import java.util.List;

/* compiled from: AdaptationSet */
/* renamed from: com.google.android.exoplayer2.h.b.a.a */
public class C2375a {
    /* renamed from: a */
    public final int f5830a;
    /* renamed from: b */
    public final int f5831b;
    /* renamed from: c */
    public final List<C2382g> f5832c;
    /* renamed from: d */
    public final List<C2378d> f5833d;
    /* renamed from: e */
    public final List<C2378d> f5834e;

    public C2375a(int i, int i2, List<C2382g> list, List<C2378d> list2, List<C2378d> list3) {
        this.f5830a = i;
        this.f5831b = i2;
        this.f5832c = Collections.unmodifiableList(list);
        if (list2 == null) {
            i = Collections.emptyList();
        } else {
            i = Collections.unmodifiableList(list2);
        }
        this.f5833d = i;
        if (list3 == null) {
            i = Collections.emptyList();
        } else {
            i = Collections.unmodifiableList(list3);
        }
        this.f5834e = i;
    }
}
