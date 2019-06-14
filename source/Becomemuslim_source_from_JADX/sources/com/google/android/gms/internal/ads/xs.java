package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class xs extends abq<xs, C8313a> implements acz {
    private static volatile adj<xs> zzakh;
    private static final xs zzdmc = new xs();
    private int zzdih;
    private xu zzdmb;

    /* renamed from: com.google.android.gms.internal.ads.xs$a */
    public static final class C8313a extends C8211a<xs, C8313a> implements acz {
        private C8313a() {
            super(xs.zzdmc);
        }

        /* renamed from: a */
        public final C8313a m43773a(int i) {
            m42161b();
            ((xs) this.a).m43779b(0);
            return this;
        }

        /* renamed from: a */
        public final C8313a m43774a(xu xuVar) {
            m42161b();
            ((xs) this.a).m43778a(xuVar);
            return this;
        }
    }

    static {
        abq.m42174a(xs.class, zzdmc);
    }

    private xs() {
    }

    /* renamed from: a */
    public static xs m43775a(aai aai) {
        return (xs) abq.m42167a(zzdmc, aai);
    }

    /* renamed from: a */
    private final void m43778a(xu xuVar) {
        if (xuVar != null) {
            this.zzdmb = xuVar;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: b */
    private final void m43779b(int i) {
        this.zzdih = i;
    }

    /* renamed from: c */
    public static C8313a m43780c() {
        return (C8313a) ((C8211a) zzdmc.mo6835a(C4918e.f14226e, null, null));
    }

    /* renamed from: a */
    public final int m43782a() {
        return this.zzdih;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (xt.f16093a[i - 1]) {
            case 1:
                return new xs();
            case 2:
                return new C8313a();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdmb"};
                return abq.m42172a(zzdmc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t", objArr);
            case 4:
                return zzdmc;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (xs.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdmc);
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
    public final xu m43784b() {
        return this.zzdmb == null ? xu.m43786b() : this.zzdmb;
    }
}
