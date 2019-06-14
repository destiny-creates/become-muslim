package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.jh */
public abstract class jh {
    /* renamed from: n */
    protected volatile int f16793n = -1;

    /* renamed from: a */
    protected int mo4621a() {
        return 0;
    }

    /* renamed from: a */
    public abstract jh mo6147a(iy iyVar);

    /* renamed from: a */
    public void mo4622a(iz izVar) {
    }

    /* renamed from: d */
    public final int m21016d() {
        if (this.f16793n < 0) {
            m21017e();
        }
        return this.f16793n;
    }

    /* renamed from: e */
    public final int m21017e() {
        int a = mo4621a();
        this.f16793n = a;
        return a;
    }

    /* renamed from: a */
    public static final void m21010a(jh jhVar, byte[] bArr, int i, int i2) {
        try {
            iz a = iz.m20959a(bArr, 0, i2);
            jhVar.mo4622a(a);
            a.m20970a();
        } catch (jh jhVar2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", jhVar2);
        }
    }

    /* renamed from: a */
    public static final <T extends jh> T m21009a(T t, byte[] bArr) {
        return jh.m21011b(t, bArr, 0, bArr.length);
    }

    /* renamed from: b */
    private static final <T extends jh> T m21011b(T t, byte[] bArr, int i, int i2) {
        try {
            iy a = iy.m20932a(bArr, 0, i2);
            t.mo6147a(a);
            a.m20939a(0);
            return t;
        } catch (T t2) {
            throw t2;
        } catch (T t22) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", t22);
        }
    }

    public String toString() {
        return ji.m21018a(this);
    }

    /* renamed from: c */
    public jh mo4623c() {
        return (jh) super.clone();
    }

    public /* synthetic */ Object clone() {
        return mo4623c();
    }
}
