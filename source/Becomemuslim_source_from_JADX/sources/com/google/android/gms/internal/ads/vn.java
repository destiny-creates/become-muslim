package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class vn extends abq<vn, C8286a> implements acz {
    private static volatile adj<vn> zzakh;
    private static final vn zzdiq = new vn();
    private int zzdih;
    private vr zzdio;
    private aai zzdip = aai.f14132a;

    /* renamed from: com.google.android.gms.internal.ads.vn$a */
    public static final class C8286a extends C8211a<vn, C8286a> implements acz {
        private C8286a() {
            super(vn.zzdiq);
        }

        /* renamed from: a */
        public final C8286a m43527a(int i) {
            m42161b();
            ((vn) this.a).m43535b(0);
            return this;
        }

        /* renamed from: a */
        public final C8286a m43528a(aai aai) {
            m42161b();
            ((vn) this.a).m43536b(aai);
            return this;
        }

        /* renamed from: a */
        public final C8286a m43529a(vr vrVar) {
            m42161b();
            ((vn) this.a).m43534a(vrVar);
            return this;
        }
    }

    static {
        abq.m42174a(vn.class, zzdiq);
    }

    private vn() {
    }

    /* renamed from: a */
    public static vn m43530a(aai aai) {
        return (vn) abq.m42167a(zzdiq, aai);
    }

    /* renamed from: a */
    private final void m43534a(vr vrVar) {
        if (vrVar != null) {
            this.zzdio = vrVar;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: b */
    private final void m43535b(int i) {
        this.zzdih = i;
    }

    /* renamed from: b */
    private final void m43536b(aai aai) {
        if (aai != null) {
            this.zzdip = aai;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: d */
    public static C8286a m43537d() {
        return (C8286a) ((C8211a) zzdiq.mo6835a(C4918e.f14226e, null, null));
    }

    /* renamed from: e */
    public static vn m43538e() {
        return zzdiq;
    }

    /* renamed from: a */
    public final int m43540a() {
        return this.zzdih;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (vo.f16070a[i - 1]) {
            case 1:
                return new vn();
            case 2:
                return new C8286a();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdio", "zzdip"};
                return abq.m42172a(zzdiq, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", objArr);
            case 4:
                return zzdiq;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (vn.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdiq);
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
    public final vr m43542b() {
        return this.zzdio == null ? vr.m43550b() : this.zzdio;
    }

    /* renamed from: c */
    public final aai m43543c() {
        return this.zzdip;
    }
}
