package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class vt extends abq<vt, C8289a> implements acz {
    private static volatile adj<vt> zzakh;
    private static final vt zzdiw = new vt();
    private int zzdih;
    private aai zzdip = aai.f14132a;
    private vy zzdiv;

    /* renamed from: com.google.android.gms.internal.ads.vt$a */
    public static final class C8289a extends C8211a<vt, C8289a> implements acz {
        private C8289a() {
            super(vt.zzdiw);
        }

        /* renamed from: a */
        public final C8289a m43554a(int i) {
            m42161b();
            ((vt) this.a).m43562b(0);
            return this;
        }

        /* renamed from: a */
        public final C8289a m43555a(aai aai) {
            m42161b();
            ((vt) this.a).m43563b(aai);
            return this;
        }

        /* renamed from: a */
        public final C8289a m43556a(vy vyVar) {
            m42161b();
            ((vt) this.a).m43561a(vyVar);
            return this;
        }
    }

    static {
        abq.m42174a(vt.class, zzdiw);
    }

    private vt() {
    }

    /* renamed from: a */
    public static vt m43557a(aai aai) {
        return (vt) abq.m42167a(zzdiw, aai);
    }

    /* renamed from: a */
    private final void m43561a(vy vyVar) {
        if (vyVar != null) {
            this.zzdiv = vyVar;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: b */
    private final void m43562b(int i) {
        this.zzdih = i;
    }

    /* renamed from: b */
    private final void m43563b(aai aai) {
        if (aai != null) {
            this.zzdip = aai;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: d */
    public static C8289a m43564d() {
        return (C8289a) ((C8211a) zzdiw.mo6835a(C4918e.f14226e, null, null));
    }

    /* renamed from: a */
    public final int m43566a() {
        return this.zzdih;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (vu.f16073a[i - 1]) {
            case 1:
                return new vt();
            case 2:
                return new C8289a();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdiv", "zzdip"};
                return abq.m42172a(zzdiw, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", objArr);
            case 4:
                return zzdiw;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (vt.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdiw);
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
    public final vy m43568b() {
        return this.zzdiv == null ? vy.m43575b() : this.zzdiv;
    }

    /* renamed from: c */
    public final aai m43569c() {
        return this.zzdip;
    }
}
