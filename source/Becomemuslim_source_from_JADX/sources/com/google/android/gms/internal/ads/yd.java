package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;
import java.util.List;

public final class yd extends abq<yd, C8317a> implements acz {
    private static volatile adj<yd> zzakh;
    private static final yd zzdmt = new yd();
    private int zzdlq;
    private String zzdmr = "";
    private abv<xm> zzdms = abq.m42177m();

    /* renamed from: com.google.android.gms.internal.ads.yd$a */
    public static final class C8317a extends C8211a<yd, C8317a> implements acz {
        private C8317a() {
            super(yd.zzdmt);
        }

        /* renamed from: a */
        public final C8317a m43808a(xm xmVar) {
            m42161b();
            ((yd) this.a).m43810a(xmVar);
            return this;
        }

        /* renamed from: a */
        public final C8317a m43809a(String str) {
            m42161b();
            ((yd) this.a).m43813a(str);
            return this;
        }
    }

    static {
        abq.m42174a(yd.class, zzdmt);
    }

    private yd() {
    }

    /* renamed from: a */
    private final void m43810a(xm xmVar) {
        if (xmVar != null) {
            if (!this.zzdms.mo3614a()) {
                abv abv = this.zzdms;
                int size = abv.size();
                this.zzdms = abv.mo6027a(size == 0 ? 10 : size << 1);
            }
            this.zzdms.add(xmVar);
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    private final void m43813a(String str) {
        if (str != null) {
            this.zzdmr = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: b */
    public static C8317a m43814b() {
        return (C8317a) ((C8211a) zzdmt.mo6835a(C4918e.f14226e, null, null));
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (ye.f16097a[i - 1]) {
            case 1:
                return new yd();
            case 2:
                return new C8317a();
            case 3:
                Object[] objArr = new Object[]{"zzdlq", "zzdmr", "zzdms", xm.class};
                return abq.m42172a(zzdmt, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", objArr);
            case 4:
                return zzdmt;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (yd.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdmt);
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

    /* renamed from: a */
    public final List<xm> m43817a() {
        return this.zzdms;
    }
}
