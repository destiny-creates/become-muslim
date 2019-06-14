package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class wi extends abq<wi, C8295a> implements acz {
    private static volatile adj<wi> zzakh;
    private static final wi zzdji = new wi();
    private xk zzdjh;

    /* renamed from: com.google.android.gms.internal.ads.wi$a */
    public static final class C8295a extends C8211a<wi, C8295a> implements acz {
        private C8295a() {
            super(wi.zzdji);
        }
    }

    static {
        abq.m42174a(wi.class, zzdji);
    }

    private wi() {
    }

    /* renamed from: b */
    public static wi m43607b() {
        return zzdji;
    }

    /* renamed from: a */
    public final xk m43609a() {
        return this.zzdjh == null ? xk.m43708c() : this.zzdjh;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (wj.f16079a[i - 1]) {
            case 1:
                return new wi();
            case 2:
                return new C8295a();
            case 3:
                Object[] objArr = new Object[]{"zzdjh"};
                return abq.m42172a(zzdji, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0003\u0000\u0000\u0000\u0002\t", objArr);
            case 4:
                return zzdji;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (wi.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdji);
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
}
