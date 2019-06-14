package com.google.android.p133a;

import android.graphics.SurfaceTexture;
import android.media.CamcorderProfile;
import android.view.View;
import java.util.Set;
import java.util.SortedSet;

/* compiled from: CameraViewImpl */
/* renamed from: com.google.android.a.f */
abstract class C2200f {
    /* renamed from: f */
    protected final C2199a f5246f;
    /* renamed from: g */
    protected final C2205i f5247g;

    /* compiled from: CameraViewImpl */
    /* renamed from: com.google.android.a.f$a */
    interface C2199a {
        /* renamed from: a */
        void mo2094a();

        /* renamed from: a */
        void mo2095a(String str);

        /* renamed from: a */
        void mo2096a(byte[] bArr);

        /* renamed from: a */
        void mo2097a(byte[] bArr, int i, int i2, int i3);

        /* renamed from: b */
        void mo2098b();

        /* renamed from: c */
        void mo2099c();
    }

    /* renamed from: a */
    abstract SortedSet<C2210k> mo2059a(C2186a c2186a);

    /* renamed from: a */
    abstract void mo2060a(float f);

    /* renamed from: a */
    abstract void mo2061a(int i);

    /* renamed from: a */
    public abstract void mo2062a(SurfaceTexture surfaceTexture);

    /* renamed from: a */
    abstract void mo2063a(C2210k c2210k);

    /* renamed from: a */
    abstract void mo2064a(boolean z);

    /* renamed from: a */
    abstract boolean mo2065a();

    /* renamed from: a */
    abstract boolean mo2066a(String str, int i, int i2, boolean z, CamcorderProfile camcorderProfile);

    /* renamed from: b */
    abstract void mo2067b();

    /* renamed from: b */
    abstract void mo2068b(float f);

    /* renamed from: b */
    abstract void mo2069b(int i);

    /* renamed from: b */
    abstract void mo2070b(boolean z);

    /* renamed from: b */
    abstract boolean mo2071b(C2186a c2186a);

    /* renamed from: c */
    abstract void mo2072c(int i);

    /* renamed from: d */
    public abstract void mo2073d();

    /* renamed from: d */
    abstract void mo2074d(int i);

    /* renamed from: e */
    public abstract void mo2075e();

    /* renamed from: f */
    abstract boolean mo2076f();

    /* renamed from: g */
    abstract int mo2077g();

    /* renamed from: h */
    abstract int mo2078h();

    /* renamed from: i */
    abstract Set<C2186a> mo2079i();

    /* renamed from: j */
    abstract C2210k mo2080j();

    /* renamed from: k */
    abstract C2186a mo2081k();

    /* renamed from: l */
    abstract boolean mo2082l();

    /* renamed from: m */
    abstract int mo2083m();

    /* renamed from: n */
    abstract float mo2084n();

    /* renamed from: o */
    abstract float mo2085o();

    /* renamed from: p */
    abstract int mo2086p();

    /* renamed from: q */
    abstract boolean mo2087q();

    /* renamed from: r */
    abstract void mo2088r();

    /* renamed from: t */
    abstract void mo2089t();

    /* renamed from: u */
    public abstract C2210k mo2090u();

    C2200f(C2199a c2199a, C2205i c2205i) {
        this.f5246f = c2199a;
        this.f5247g = c2205i;
    }

    /* renamed from: C */
    View m6041C() {
        return this.f5247g.mo2102b();
    }
}
