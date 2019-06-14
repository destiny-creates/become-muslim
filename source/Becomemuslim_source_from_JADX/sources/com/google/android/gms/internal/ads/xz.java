package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class xz extends abq<xz, C8316a> implements acz {
    private static volatile adj<xz> zzakh;
    private static final xz zzdmj = new xz();
    private String zzdmh = "";
    private xk zzdmi;

    /* renamed from: com.google.android.gms.internal.ads.xz$a */
    public static final class C8316a extends C8211a<xz, C8316a> implements acz {
        private C8316a() {
            super(xz.zzdmj);
        }
    }

    static {
        abq.m42174a(xz.class, zzdmj);
    }

    private xz() {
    }

    /* renamed from: a */
    public static xz m43802a(aai aai) {
        return (xz) abq.m42167a(zzdmj, aai);
    }

    /* renamed from: c */
    public static xz m43803c() {
        return zzdmj;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (ya.f16096a[i - 1]) {
            case 1:
                return new xz();
            case 2:
                return new C8316a();
            case 3:
                Object[] objArr = new Object[]{"zzdmh", "zzdmi"};
                return abq.m42172a(zzdmj, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\t", objArr);
            case 4:
                return zzdmj;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (xz.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdmj);
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
    public final String m43806a() {
        return this.zzdmh;
    }

    /* renamed from: b */
    public final xk m43807b() {
        return this.zzdmi == null ? xk.m43708c() : this.zzdmi;
    }
}
