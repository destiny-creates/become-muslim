package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class xd extends abq<xd, C8303a> implements acz {
    private static volatile adj<xd> zzakh;
    private static final xd zzdkr = new xd();
    private int zzdkp;
    private int zzdkq;

    /* renamed from: com.google.android.gms.internal.ads.xd$a */
    public static final class C8303a extends C8211a<xd, C8303a> implements acz {
        private C8303a() {
            super(xd.zzdkr);
        }
    }

    static {
        abq.m42174a(xd.class, zzdkr);
    }

    private xd() {
    }

    /* renamed from: c */
    public static xd m43687c() {
        return zzdkr;
    }

    /* renamed from: a */
    public final wx m43689a() {
        wx a = wx.m31223a(this.zzdkp);
        return a == null ? wx.UNRECOGNIZED : a;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (xe.f16087a[i - 1]) {
            case 1:
                return new xd();
            case 2:
                return new C8303a();
            case 3:
                Object[] objArr = new Object[]{"zzdkp", "zzdkq"};
                return abq.m42172a(zzdkr, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\f\u0002\u000b", objArr);
            case 4:
                return zzdkr;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (xd.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdkr);
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
    public final int m43691b() {
        return this.zzdkq;
    }
}
