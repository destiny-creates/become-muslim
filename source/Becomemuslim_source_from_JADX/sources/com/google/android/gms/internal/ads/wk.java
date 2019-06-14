package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class wk extends abq<wk, C8296a> implements acz {
    private static volatile adj<wk> zzakh;
    private static final wk zzdjk = new wk();
    private wm zzdjj;

    /* renamed from: com.google.android.gms.internal.ads.wk$a */
    public static final class C8296a extends C8211a<wk, C8296a> implements acz {
        private C8296a() {
            super(wk.zzdjk);
        }
    }

    static {
        abq.m42174a(wk.class, zzdjk);
    }

    private wk() {
    }

    /* renamed from: a */
    public static wk m43611a(aai aai) {
        return (wk) abq.m42167a(zzdjk, aai);
    }

    /* renamed from: a */
    public final wm m43613a() {
        return this.zzdjj == null ? wm.m43615d() : this.zzdjj;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (wl.f16080a[i - 1]) {
            case 1:
                return new wk();
            case 2:
                return new C8296a();
            case 3:
                Object[] objArr = new Object[]{"zzdjj"};
                return abq.m42172a(zzdjk, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0000\u0000\u0001\t", objArr);
            case 4:
                return zzdjk;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (wk.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdjk);
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
