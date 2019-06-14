package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class vj extends abq<vj, C8284a> implements acz {
    private static volatile adj<vj> zzakh;
    private static final vj zzdik = new vj();
    private int zzdih;
    private vn zzdii;
    private wz zzdij;

    /* renamed from: com.google.android.gms.internal.ads.vj$a */
    public static final class C8284a extends C8211a<vj, C8284a> implements acz {
        private C8284a() {
            super(vj.zzdik);
        }

        /* renamed from: a */
        public final C8284a m43506a(int i) {
            m42161b();
            ((vj) this.a).m43515b(i);
            return this;
        }

        /* renamed from: a */
        public final C8284a m43507a(vn vnVar) {
            m42161b();
            ((vj) this.a).m43513a(vnVar);
            return this;
        }

        /* renamed from: a */
        public final C8284a m43508a(wz wzVar) {
            m42161b();
            ((vj) this.a).m43514a(wzVar);
            return this;
        }
    }

    static {
        abq.m42174a(vj.class, zzdik);
    }

    private vj() {
    }

    /* renamed from: a */
    public static vj m43509a(aai aai) {
        return (vj) abq.m42167a(zzdik, aai);
    }

    /* renamed from: a */
    private final void m43513a(vn vnVar) {
        if (vnVar != null) {
            this.zzdii = vnVar;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    private final void m43514a(wz wzVar) {
        if (wzVar != null) {
            this.zzdij = wzVar;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: b */
    private final void m43515b(int i) {
        this.zzdih = i;
    }

    /* renamed from: d */
    public static C8284a m43516d() {
        return (C8284a) ((C8211a) zzdik.mo6835a(C4918e.f14226e, null, null));
    }

    /* renamed from: a */
    public final int m43518a() {
        return this.zzdih;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (vk.f16068a[i - 1]) {
            case 1:
                return new vj();
            case 2:
                return new C8284a();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdii", "zzdij"};
                return abq.m42172a(zzdik, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", objArr);
            case 4:
                return zzdik;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (vj.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdik);
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
    public final vn m43520b() {
        return this.zzdii == null ? vn.m43538e() : this.zzdii;
    }

    /* renamed from: c */
    public final wz m43521c() {
        return this.zzdij == null ? wz.m43675e() : this.zzdij;
    }
}
