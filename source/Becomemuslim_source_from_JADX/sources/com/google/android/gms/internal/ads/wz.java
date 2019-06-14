package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class wz extends abq<wz, C8301a> implements acz {
    private static volatile adj<wz> zzakh;
    private static final wz zzdkn = new wz();
    private int zzdih;
    private aai zzdip = aai.f14132a;
    private xd zzdkm;

    /* renamed from: com.google.android.gms.internal.ads.wz$a */
    public static final class C8301a extends C8211a<wz, C8301a> implements acz {
        private C8301a() {
            super(wz.zzdkn);
        }

        /* renamed from: a */
        public final C8301a m43664a(int i) {
            m42161b();
            ((wz) this.a).m43672b(0);
            return this;
        }

        /* renamed from: a */
        public final C8301a m43665a(aai aai) {
            m42161b();
            ((wz) this.a).m43673b(aai);
            return this;
        }

        /* renamed from: a */
        public final C8301a m43666a(xd xdVar) {
            m42161b();
            ((wz) this.a).m43671a(xdVar);
            return this;
        }
    }

    static {
        abq.m42174a(wz.class, zzdkn);
    }

    private wz() {
    }

    /* renamed from: a */
    public static wz m43667a(aai aai) {
        return (wz) abq.m42167a(zzdkn, aai);
    }

    /* renamed from: a */
    private final void m43671a(xd xdVar) {
        if (xdVar != null) {
            this.zzdkm = xdVar;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: b */
    private final void m43672b(int i) {
        this.zzdih = i;
    }

    /* renamed from: b */
    private final void m43673b(aai aai) {
        if (aai != null) {
            this.zzdip = aai;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: d */
    public static C8301a m43674d() {
        return (C8301a) ((C8211a) zzdkn.mo6835a(C4918e.f14226e, null, null));
    }

    /* renamed from: e */
    public static wz m43675e() {
        return zzdkn;
    }

    /* renamed from: a */
    public final int m43677a() {
        return this.zzdih;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (xa.f16085a[i - 1]) {
            case 1:
                return new wz();
            case 2:
                return new C8301a();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdkm", "zzdip"};
                return abq.m42172a(zzdkn, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", objArr);
            case 4:
                return zzdkn;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (wz.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdkn);
                            zzakh = obj3;
                        }
                    }
                }
                return obj3;
            case 6:
                return Byte.valueOf((byte) 1);
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    /* renamed from: b */
    public final xd m43679b() {
        return this.zzdkm == null ? xd.m43687c() : this.zzdkm;
    }

    /* renamed from: c */
    public final aai m43680c() {
        return this.zzdip;
    }
}
