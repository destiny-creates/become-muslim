package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class xw extends abq<xw, C8315a> implements acz {
    private static volatile adj<xw> zzakh;
    private static final xw zzdmg = new xw();
    private int zzdih;
    private xz zzdmf;

    /* renamed from: com.google.android.gms.internal.ads.xw$a */
    public static final class C8315a extends C8211a<xw, C8315a> implements acz {
        private C8315a() {
            super(xw.zzdmg);
        }

        /* renamed from: a */
        public final C8315a m43790a(int i) {
            m42161b();
            ((xw) this.a).m43796b(0);
            return this;
        }

        /* renamed from: a */
        public final C8315a m43791a(xz xzVar) {
            m42161b();
            ((xw) this.a).m43795a(xzVar);
            return this;
        }
    }

    static {
        abq.m42174a(xw.class, zzdmg);
    }

    private xw() {
    }

    /* renamed from: a */
    public static xw m43792a(aai aai) {
        return (xw) abq.m42167a(zzdmg, aai);
    }

    /* renamed from: a */
    private final void m43795a(xz xzVar) {
        if (xzVar != null) {
            this.zzdmf = xzVar;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: b */
    private final void m43796b(int i) {
        this.zzdih = i;
    }

    /* renamed from: c */
    public static C8315a m43797c() {
        return (C8315a) ((C8211a) zzdmg.mo6835a(C4918e.f14226e, null, null));
    }

    /* renamed from: a */
    public final int m43799a() {
        return this.zzdih;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (xy.f16095a[i - 1]) {
            case 1:
                return new xw();
            case 2:
                return new C8315a();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdmf"};
                return abq.m42172a(zzdmg, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t", objArr);
            case 4:
                return zzdmg;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (xw.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdmg);
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
    public final xz m43801b() {
        return this.zzdmf == null ? xz.m43803c() : this.zzdmf;
    }
}
