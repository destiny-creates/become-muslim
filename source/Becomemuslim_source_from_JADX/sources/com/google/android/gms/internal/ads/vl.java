package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class vl extends abq<vl, C8285a> implements acz {
    private static volatile adj<vl> zzakh;
    private static final vl zzdin = new vl();
    private vp zzdil;
    private xb zzdim;

    /* renamed from: com.google.android.gms.internal.ads.vl$a */
    public static final class C8285a extends C8211a<vl, C8285a> implements acz {
        private C8285a() {
            super(vl.zzdin);
        }
    }

    static {
        abq.m42174a(vl.class, zzdin);
    }

    private vl() {
    }

    /* renamed from: a */
    public static vl m43522a(aai aai) {
        return (vl) abq.m42167a(zzdin, aai);
    }

    /* renamed from: a */
    public final vp m43524a() {
        return this.zzdil == null ? vp.m43545c() : this.zzdil;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (vm.f16069a[i - 1]) {
            case 1:
                return new vl();
            case 2:
                return new C8285a();
            case 3:
                Object[] objArr = new Object[]{"zzdil", "zzdim"};
                return abq.m42172a(zzdin, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\t\u0002\t", objArr);
            case 4:
                return zzdin;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (vl.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdin);
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
    public final xb m43526b() {
        return this.zzdim == null ? xb.m43682c() : this.zzdim;
    }
}
