package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class vy extends abq<vy, C8291a> implements acz {
    private static volatile adj<vy> zzakh;
    private static final vy zzdiy = new vy();
    private int zzdit;

    /* renamed from: com.google.android.gms.internal.ads.vy$a */
    public static final class C8291a extends C8211a<vy, C8291a> implements acz {
        private C8291a() {
            super(vy.zzdiy);
        }
    }

    static {
        abq.m42174a(vy.class, zzdiy);
    }

    private vy() {
    }

    /* renamed from: b */
    public static vy m43575b() {
        return zzdiy;
    }

    /* renamed from: a */
    public final int m43577a() {
        return this.zzdit;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (vz.f16075a[i - 1]) {
            case 1:
                return new vy();
            case 2:
                return new C8291a();
            case 3:
                Object[] objArr = new Object[]{"zzdit"};
                return abq.m42172a(zzdiy, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0000\u0000\u0001\u000b", objArr);
            case 4:
                return zzdiy;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (vy.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdiy);
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
