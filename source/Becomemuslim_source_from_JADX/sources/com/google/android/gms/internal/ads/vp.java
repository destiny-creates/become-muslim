package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class vp extends abq<vp, C8287a> implements acz {
    private static volatile adj<vp> zzakh;
    private static final vp zzdis = new vp();
    private vr zzdio;
    private int zzdir;

    /* renamed from: com.google.android.gms.internal.ads.vp$a */
    public static final class C8287a extends C8211a<vp, C8287a> implements acz {
        private C8287a() {
            super(vp.zzdis);
        }
    }

    static {
        abq.m42174a(vp.class, zzdis);
    }

    private vp() {
    }

    /* renamed from: a */
    public static vp m43544a(aai aai) {
        return (vp) abq.m42167a(zzdis, aai);
    }

    /* renamed from: c */
    public static vp m43545c() {
        return zzdis;
    }

    /* renamed from: a */
    public final vr m43547a() {
        return this.zzdio == null ? vr.m43550b() : this.zzdio;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (vq.f16071a[i - 1]) {
            case 1:
                return new vp();
            case 2:
                return new C8287a();
            case 3:
                Object[] objArr = new Object[]{"zzdio", "zzdir"};
                return abq.m42172a(zzdis, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b", objArr);
            case 4:
                return zzdis;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (vp.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdis);
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
    public final int m43549b() {
        return this.zzdir;
    }
}
