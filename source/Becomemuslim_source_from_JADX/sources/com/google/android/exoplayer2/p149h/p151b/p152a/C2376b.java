package com.google.android.exoplayer2.p149h.p151b.p152a;

import android.net.Uri;
import com.google.android.exoplayer2.C2251b;
import java.util.Collections;
import java.util.List;

/* compiled from: DashManifest */
/* renamed from: com.google.android.exoplayer2.h.b.a.b */
public class C2376b {
    /* renamed from: a */
    public final long f5835a;
    /* renamed from: b */
    public final long f5836b;
    /* renamed from: c */
    public final long f5837c;
    /* renamed from: d */
    public final boolean f5838d;
    /* renamed from: e */
    public final long f5839e;
    /* renamed from: f */
    public final long f5840f;
    /* renamed from: g */
    public final long f5841g;
    /* renamed from: h */
    public final long f5842h;
    /* renamed from: i */
    public final C2386k f5843i;
    /* renamed from: j */
    public final Uri f5844j;
    /* renamed from: k */
    private final List<C2379e> f5845k;

    public C2376b(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, C2386k c2386k, Uri uri, List<C2379e> list) {
        this.f5835a = j;
        this.f5836b = j2;
        this.f5837c = j3;
        this.f5838d = z;
        this.f5839e = j4;
        this.f5840f = j5;
        this.f5841g = j6;
        this.f5842h = j7;
        this.f5843i = c2386k;
        this.f5844j = uri;
        r0.f5845k = list == null ? Collections.emptyList() : list;
    }

    /* renamed from: a */
    public final int m6568a() {
        return this.f5845k.size();
    }

    /* renamed from: a */
    public final C2379e m6569a(int i) {
        return (C2379e) this.f5845k.get(i);
    }

    /* renamed from: b */
    public final long m6570b(int i) {
        if (i != this.f5845k.size() - 1) {
            return ((C2379e) this.f5845k.get(i + 1)).f5857b - ((C2379e) this.f5845k.get(i)).f5857b;
        }
        if (this.f5836b == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.f5836b - ((C2379e) this.f5845k.get(i)).f5857b;
    }

    /* renamed from: c */
    public final long m6571c(int i) {
        return C2251b.m6222b(m6570b(i));
    }
}
