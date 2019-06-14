package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class wm extends abq<wm, C8297a> implements acz {
    private static volatile adj<wm> zzakh;
    private static final wm zzdjo = new wm();
    private ws zzdjl;
    private wi zzdjm;
    private int zzdjn;

    /* renamed from: com.google.android.gms.internal.ads.wm$a */
    public static final class C8297a extends C8211a<wm, C8297a> implements acz {
        private C8297a() {
            super(wm.zzdjo);
        }
    }

    static {
        abq.m42174a(wm.class, zzdjo);
    }

    private wm() {
    }

    /* renamed from: d */
    public static wm m43615d() {
        return zzdjo;
    }

    /* renamed from: a */
    public final ws m43617a() {
        return this.zzdjl == null ? ws.m43658d() : this.zzdjl;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (wn.f16081a[i - 1]) {
            case 1:
                return new wm();
            case 2:
                return new C8297a();
            case 3:
                Object[] objArr = new Object[]{"zzdjl", "zzdjm", "zzdjn"};
                return abq.m42172a(zzdjo, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", objArr);
            case 4:
                return zzdjo;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (wm.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdjo);
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
    public final wi m43619b() {
        return this.zzdjm == null ? wi.m43607b() : this.zzdjm;
    }

    /* renamed from: c */
    public final wg m43620c() {
        wg a = wg.m31217a(this.zzdjn);
        return a == null ? wg.UNRECOGNIZED : a;
    }
}
