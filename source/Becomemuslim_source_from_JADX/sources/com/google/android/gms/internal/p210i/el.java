package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.el */
public abstract class el {
    /* renamed from: a */
    int f16519a;
    /* renamed from: b */
    int f16520b;
    /* renamed from: c */
    eo f16521c;
    /* renamed from: d */
    private int f16522d;
    /* renamed from: e */
    private boolean f16523e;

    /* renamed from: a */
    public static el m20471a(byte[] bArr, int i, int i2) {
        return el.m20472a(bArr, i, i2, false);
    }

    /* renamed from: a */
    public abstract int mo4432a();

    /* renamed from: a */
    public abstract <T extends gt> T mo4433a(hd<T> hdVar, ew ewVar);

    /* renamed from: a */
    public abstract void mo4434a(int i);

    /* renamed from: b */
    public abstract double mo4435b();

    /* renamed from: b */
    public abstract boolean mo4436b(int i);

    /* renamed from: c */
    public abstract float mo4437c();

    /* renamed from: d */
    public abstract int mo4438d(int i);

    /* renamed from: d */
    public abstract long mo4439d();

    /* renamed from: e */
    public abstract long mo4440e();

    /* renamed from: e */
    public abstract void mo4441e(int i);

    /* renamed from: f */
    public abstract int mo4442f();

    /* renamed from: f */
    public abstract void mo4443f(int i);

    /* renamed from: g */
    public abstract long mo4444g();

    /* renamed from: h */
    public abstract int mo4445h();

    /* renamed from: i */
    public abstract boolean mo4446i();

    /* renamed from: j */
    public abstract String mo4447j();

    /* renamed from: k */
    public abstract String mo4448k();

    /* renamed from: l */
    public abstract dy mo4449l();

    /* renamed from: m */
    public abstract int mo4450m();

    /* renamed from: n */
    public abstract int mo4451n();

    /* renamed from: o */
    public abstract int mo4452o();

    /* renamed from: p */
    public abstract long mo4453p();

    /* renamed from: q */
    public abstract int mo4454q();

    /* renamed from: r */
    public abstract long mo4455r();

    /* renamed from: s */
    abstract long mo4456s();

    /* renamed from: t */
    public abstract boolean mo4457t();

    /* renamed from: u */
    public abstract int mo4458u();

    /* renamed from: a */
    static el m20472a(byte[] bArr, int i, int i2, boolean z) {
        en enVar = new en(bArr, i, i2, false);
        try {
            enVar.mo4438d(i2);
            return enVar;
        } catch (byte[] bArr2) {
            throw new IllegalArgumentException(bArr2);
        }
    }

    private el() {
        this.f16520b = 100;
        this.f16522d = Integer.MAX_VALUE;
        this.f16523e = false;
    }

    /* renamed from: c */
    public final int m20479c(int i) {
        if (i >= 0) {
            int i2 = this.f16520b;
            this.f16520b = i;
            return i2;
        }
        StringBuilder stringBuilder = new StringBuilder(47);
        stringBuilder.append("Recursion limit cannot be negative: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
