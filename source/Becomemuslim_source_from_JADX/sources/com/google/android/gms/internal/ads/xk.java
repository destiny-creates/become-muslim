package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class xk extends abq<xk, C8305a> implements acz {
    private static volatile adj<xk> zzakh;
    private static final xk zzdlk = new xk();
    private String zzdks = "";
    private aai zzdkt = aai.f14132a;
    private int zzdlj;

    /* renamed from: com.google.android.gms.internal.ads.xk$a */
    public static final class C8305a extends C8211a<xk, C8305a> implements acz {
        private C8305a() {
            super(xk.zzdlk);
        }
    }

    static {
        abq.m42174a(xk.class, zzdlk);
    }

    private xk() {
    }

    /* renamed from: c */
    public static xk m43708c() {
        return zzdlk;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (xl.f16089a[i - 1]) {
            case 1:
                return new xk();
            case 2:
                return new C8305a();
            case 3:
                Object[] objArr = new Object[]{"zzdks", "zzdkt", "zzdlj"};
                return abq.m42172a(zzdlk, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", objArr);
            case 4:
                return zzdlk;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (xk.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdlk);
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
    public final String m43711a() {
        return this.zzdks;
    }

    /* renamed from: b */
    public final aai m43712b() {
        return this.zzdkt;
    }
}
