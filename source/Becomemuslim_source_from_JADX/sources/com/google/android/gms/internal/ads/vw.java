package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class vw extends abq<vw, C8290a> implements acz {
    private static volatile adj<vw> zzakh;
    private static final vw zzdix = new vw();
    private int zzdir;
    private vy zzdiv;

    /* renamed from: com.google.android.gms.internal.ads.vw$a */
    public static final class C8290a extends C8211a<vw, C8290a> implements acz {
        private C8290a() {
            super(vw.zzdix);
        }
    }

    static {
        abq.m42174a(vw.class, zzdix);
    }

    private vw() {
    }

    /* renamed from: a */
    public static vw m43570a(aai aai) {
        return (vw) abq.m42167a(zzdix, aai);
    }

    /* renamed from: a */
    public final vy m43572a() {
        return this.zzdiv == null ? vy.m43575b() : this.zzdiv;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (vx.f16074a[i - 1]) {
            case 1:
                return new vw();
            case 2:
                return new C8290a();
            case 3:
                Object[] objArr = new Object[]{"zzdiv", "zzdir"};
                return abq.m42172a(zzdix, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b", objArr);
            case 4:
                return zzdix;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (vw.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdix);
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
    public final int m43574b() {
        return this.zzdir;
    }
}
