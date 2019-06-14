package com.google.android.gms.internal.ads;

public abstract class aar {
    /* renamed from: f */
    private static volatile boolean f14140f = true;
    /* renamed from: a */
    int f14141a;
    /* renamed from: b */
    int f14142b;
    /* renamed from: c */
    aau f14143c;
    /* renamed from: d */
    private int f14144d;
    /* renamed from: e */
    private boolean f14145e;

    private aar() {
        this.f14142b = 100;
        this.f14144d = Integer.MAX_VALUE;
        this.f14145e = false;
    }

    /* renamed from: a */
    public static long m17852a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    /* renamed from: a */
    static aar m17853a(byte[] bArr, int i, int i2, boolean z) {
        aar aat = new aat(bArr, i, i2, z, null);
        try {
            aat.mo3622c(i2);
            return aat;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: f */
    public static int m17854f(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    /* renamed from: a */
    public abstract int mo3617a();

    /* renamed from: a */
    public abstract void mo3618a(int i);

    /* renamed from: b */
    public abstract double mo3619b();

    /* renamed from: b */
    public abstract boolean mo3620b(int i);

    /* renamed from: c */
    public abstract float mo3621c();

    /* renamed from: c */
    public abstract int mo3622c(int i);

    /* renamed from: d */
    public abstract long mo3623d();

    /* renamed from: d */
    public abstract void mo3624d(int i);

    /* renamed from: e */
    public abstract long mo3625e();

    /* renamed from: e */
    public abstract void mo3626e(int i);

    /* renamed from: f */
    public abstract int mo3627f();

    /* renamed from: g */
    public abstract long mo3628g();

    /* renamed from: h */
    public abstract int mo3629h();

    /* renamed from: i */
    public abstract boolean mo3630i();

    /* renamed from: j */
    public abstract String mo3631j();

    /* renamed from: k */
    public abstract String mo3632k();

    /* renamed from: l */
    public abstract aai mo3633l();

    /* renamed from: m */
    public abstract int mo3634m();

    /* renamed from: n */
    public abstract int mo3635n();

    /* renamed from: o */
    public abstract int mo3636o();

    /* renamed from: p */
    public abstract long mo3637p();

    /* renamed from: q */
    public abstract int mo3638q();

    /* renamed from: r */
    public abstract long mo3639r();

    /* renamed from: s */
    abstract long mo3640s();

    /* renamed from: t */
    public abstract boolean mo3641t();

    /* renamed from: u */
    public abstract int mo3642u();
}
