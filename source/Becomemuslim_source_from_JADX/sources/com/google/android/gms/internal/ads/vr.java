package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class vr extends abq<vr, C8288a> implements acz {
    private static volatile adj<vr> zzakh;
    private static final vr zzdiu = new vr();
    private int zzdit;

    /* renamed from: com.google.android.gms.internal.ads.vr$a */
    public static final class C8288a extends C8211a<vr, C8288a> implements acz {
        private C8288a() {
            super(vr.zzdiu);
        }
    }

    static {
        abq.m42174a(vr.class, zzdiu);
    }

    private vr() {
    }

    /* renamed from: b */
    public static vr m43550b() {
        return zzdiu;
    }

    /* renamed from: a */
    public final int m43552a() {
        return this.zzdit;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (vs.f16072a[i - 1]) {
            case 1:
                return new vr();
            case 2:
                return new C8288a();
            case 3:
                Object[] objArr = new Object[]{"zzdit"};
                return abq.m42172a(zzdiu, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0000\u0000\u0001\u000b", objArr);
            case 4:
                return zzdiu;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (vr.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdiu);
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
