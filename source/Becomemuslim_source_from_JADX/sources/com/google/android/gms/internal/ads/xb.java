package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class xb extends abq<xb, C8302a> implements acz {
    private static volatile adj<xb> zzakh;
    private static final xb zzdko = new xb();
    private int zzdir;
    private xd zzdkm;

    /* renamed from: com.google.android.gms.internal.ads.xb$a */
    public static final class C8302a extends C8211a<xb, C8302a> implements acz {
        private C8302a() {
            super(xb.zzdko);
        }
    }

    static {
        abq.m42174a(xb.class, zzdko);
    }

    private xb() {
    }

    /* renamed from: a */
    public static xb m43681a(aai aai) {
        return (xb) abq.m42167a(zzdko, aai);
    }

    /* renamed from: c */
    public static xb m43682c() {
        return zzdko;
    }

    /* renamed from: a */
    public final xd m43684a() {
        return this.zzdkm == null ? xd.m43687c() : this.zzdkm;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (xc.f16086a[i - 1]) {
            case 1:
                return new xb();
            case 2:
                return new C8302a();
            case 3:
                Object[] objArr = new Object[]{"zzdkm", "zzdir"};
                return abq.m42172a(zzdko, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b", objArr);
            case 4:
                return zzdko;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (xb.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdko);
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
    public final int m43686b() {
        return this.zzdir;
    }
}
