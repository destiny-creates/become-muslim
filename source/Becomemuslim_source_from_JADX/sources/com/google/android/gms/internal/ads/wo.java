package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class wo extends abq<wo, C8298a> implements acz {
    private static volatile adj<wo> zzakh;
    private static final wo zzdjq = new wo();
    private int zzdih;
    private aai zzdip = aai.f14132a;
    private wq zzdjp;

    /* renamed from: com.google.android.gms.internal.ads.wo$a */
    public static final class C8298a extends C8211a<wo, C8298a> implements acz {
        private C8298a() {
            super(wo.zzdjq);
        }

        /* renamed from: a */
        public final C8298a m43621a(int i) {
            m42161b();
            ((wo) this.a).m43629b(0);
            return this;
        }

        /* renamed from: a */
        public final C8298a m43622a(aai aai) {
            m42161b();
            ((wo) this.a).m43630b(aai);
            return this;
        }

        /* renamed from: a */
        public final C8298a m43623a(wq wqVar) {
            m42161b();
            ((wo) this.a).m43628a(wqVar);
            return this;
        }
    }

    static {
        abq.m42174a(wo.class, zzdjq);
    }

    private wo() {
    }

    /* renamed from: a */
    public static wo m43624a(aai aai) {
        return (wo) abq.m42167a(zzdjq, aai);
    }

    /* renamed from: a */
    private final void m43628a(wq wqVar) {
        if (wqVar != null) {
            this.zzdjp = wqVar;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: b */
    private final void m43629b(int i) {
        this.zzdih = i;
    }

    /* renamed from: b */
    private final void m43630b(aai aai) {
        if (aai != null) {
            this.zzdip = aai;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: d */
    public static C8298a m43631d() {
        return (C8298a) ((C8211a) zzdjq.mo6835a(C4918e.f14226e, null, null));
    }

    /* renamed from: a */
    public final int m43633a() {
        return this.zzdih;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (wp.f16082a[i - 1]) {
            case 1:
                return new wo();
            case 2:
                return new C8298a();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdjp", "zzdip"};
                return abq.m42172a(zzdjq, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", objArr);
            case 4:
                return zzdjq;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (wo.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdjq);
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
    public final wq m43635b() {
        return this.zzdjp == null ? wq.m43651f() : this.zzdjp;
    }

    /* renamed from: c */
    public final aai m43636c() {
        return this.zzdip;
    }
}
