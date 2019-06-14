package com.google.android.exoplayer2.p163k;

import android.net.Uri;
import com.google.android.exoplayer2.p163k.C4251s.C2508c;
import com.google.android.exoplayer2.p164l.C2541v;
import java.io.Closeable;
import java.io.InputStream;

/* compiled from: ParsingLoadable */
/* renamed from: com.google.android.exoplayer2.k.u */
public final class C4253u<T> implements C2508c {
    /* renamed from: a */
    public final C2501j f11218a;
    /* renamed from: b */
    public final int f11219b;
    /* renamed from: c */
    private final C2498g f11220c;
    /* renamed from: d */
    private final C2513a<? extends T> f11221d;
    /* renamed from: e */
    private volatile T f11222e;
    /* renamed from: f */
    private volatile boolean f11223f;
    /* renamed from: g */
    private volatile long f11224g;

    /* compiled from: ParsingLoadable */
    /* renamed from: com.google.android.exoplayer2.k.u$a */
    public interface C2513a<T> {
        /* renamed from: b */
        T mo2245b(Uri uri, InputStream inputStream);
    }

    public C4253u(C2498g c2498g, Uri uri, int i, C2513a<? extends T> c2513a) {
        this(c2498g, new C2501j(uri, 1), i, (C2513a) c2513a);
    }

    public C4253u(C2498g c2498g, C2501j c2501j, int i, C2513a<? extends T> c2513a) {
        this.f11220c = c2498g;
        this.f11218a = c2501j;
        this.f11219b = i;
        this.f11221d = c2513a;
    }

    /* renamed from: d */
    public final T m13808d() {
        return this.f11222e;
    }

    /* renamed from: e */
    public long m13809e() {
        return this.f11224g;
    }

    /* renamed from: a */
    public final void mo2282a() {
        this.f11223f = true;
    }

    /* renamed from: b */
    public final boolean mo2283b() {
        return this.f11223f;
    }

    /* renamed from: c */
    public final void mo2284c() {
        Closeable c2500i = new C2500i(this.f11220c, this.f11218a);
        try {
            c2500i.m6955b();
            this.f11222e = this.f11221d.mo2245b(this.f11220c.mo2269a(), c2500i);
        } finally {
            this.f11224g = c2500i.m6954a();
            C2541v.m7175a(c2500i);
        }
    }
}
