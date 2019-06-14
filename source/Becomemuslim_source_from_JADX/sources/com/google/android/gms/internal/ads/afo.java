package com.google.android.gms.internal.ads;

public abstract class afo {
    /* renamed from: Z */
    protected volatile int f14431Z = -1;

    /* renamed from: a */
    public static final <T extends afo> T m18386a(T t, byte[] bArr) {
        return m18387a(t, bArr, 0, bArr.length);
    }

    /* renamed from: a */
    private static final <T extends afo> T m18387a(T t, byte[] bArr, int i, int i2) {
        try {
            afe a = afe.m18320a(bArr, 0, i2);
            t.mo6026a(a);
            a.m18325a(0);
            return t;
        } catch (afn e) {
            throw e;
        } catch (Throwable e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    /* renamed from: a */
    public static final byte[] m18388a(afo afo) {
        byte[] bArr = new byte[afo.m18393d()];
        try {
            afg a = afg.m18347a(bArr, 0, bArr.length);
            afo.mo3804a(a);
            a.m18360a();
            return bArr;
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    /* renamed from: a */
    protected int mo3803a() {
        return 0;
    }

    /* renamed from: a */
    public abstract afo mo6026a(afe afe);

    /* renamed from: a */
    public void mo3804a(afg afg) {
    }

    /* renamed from: c */
    public afo mo3805c() {
        return (afo) super.clone();
    }

    public /* synthetic */ Object clone() {
        return mo3805c();
    }

    /* renamed from: d */
    public final int m18393d() {
        int a = mo3803a();
        this.f14431Z = a;
        return a;
    }

    public String toString() {
        return afp.m18394a(this);
    }
}
