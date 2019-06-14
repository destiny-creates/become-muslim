package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class xu extends abq<xu, C8314a> implements acz {
    private static volatile adj<xu> zzakh;
    private static final xu zzdme = new xu();
    private String zzdmd = "";

    /* renamed from: com.google.android.gms.internal.ads.xu$a */
    public static final class C8314a extends C8211a<xu, C8314a> implements acz {
        private C8314a() {
            super(xu.zzdme);
        }
    }

    static {
        abq.m42174a(xu.class, zzdme);
    }

    private xu() {
    }

    /* renamed from: a */
    public static xu m43785a(aai aai) {
        return (xu) abq.m42167a(zzdme, aai);
    }

    /* renamed from: b */
    public static xu m43786b() {
        return zzdme;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (xv.f16094a[i - 1]) {
            case 1:
                return new xu();
            case 2:
                return new C8314a();
            case 3:
                Object[] objArr = new Object[]{"zzdmd"};
                return abq.m42172a(zzdme, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0000\u0000\u0001Ȉ", objArr);
            case 4:
                return zzdme;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (xu.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdme);
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
    public final String m43789a() {
        return this.zzdmd;
    }
}
