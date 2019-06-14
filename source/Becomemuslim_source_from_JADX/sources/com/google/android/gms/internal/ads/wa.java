package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class wa extends abq<wa, C8292a> implements acz {
    private static volatile adj<wa> zzakh;
    private static final wa zzdiz = new wa();
    private int zzdih;
    private aai zzdip = aai.f14132a;

    /* renamed from: com.google.android.gms.internal.ads.wa$a */
    public static final class C8292a extends C8211a<wa, C8292a> implements acz {
        private C8292a() {
            super(wa.zzdiz);
        }

        /* renamed from: a */
        public final C8292a m43579a(int i) {
            m42161b();
            ((wa) this.a).m43584b(0);
            return this;
        }

        /* renamed from: a */
        public final C8292a m43580a(aai aai) {
            m42161b();
            ((wa) this.a).m43585b(aai);
            return this;
        }
    }

    static {
        abq.m42174a(wa.class, zzdiz);
    }

    private wa() {
    }

    /* renamed from: a */
    public static wa m43581a(aai aai) {
        return (wa) abq.m42167a(zzdiz, aai);
    }

    /* renamed from: b */
    private final void m43584b(int i) {
        this.zzdih = i;
    }

    /* renamed from: b */
    private final void m43585b(aai aai) {
        if (aai != null) {
            this.zzdip = aai;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: c */
    public static C8292a m43586c() {
        return (C8292a) ((C8211a) zzdiz.mo6835a(C4918e.f14226e, null, null));
    }

    /* renamed from: a */
    public final int m43588a() {
        return this.zzdih;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (wb.f16076a[i - 1]) {
            case 1:
                return new wa();
            case 2:
                return new C8292a();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdip"};
                return abq.m42172a(zzdiz, "\u0000\u0002\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u000b\u0003\n", objArr);
            case 4:
                return zzdiz;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (wa.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdiz);
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
    public final aai m43590b() {
        return this.zzdip;
    }
}
