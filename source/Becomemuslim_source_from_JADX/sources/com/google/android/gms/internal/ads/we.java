package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class we extends abq<we, C8294a> implements acz {
    private static volatile adj<we> zzakh;
    private static final we zzdjb = new we();
    private int zzdih;
    private aai zzdip = aai.f14132a;

    /* renamed from: com.google.android.gms.internal.ads.we$a */
    public static final class C8294a extends C8211a<we, C8294a> implements acz {
        private C8294a() {
            super(we.zzdjb);
        }

        /* renamed from: a */
        public final C8294a m43595a(int i) {
            m42161b();
            ((we) this.a).m43600b(0);
            return this;
        }

        /* renamed from: a */
        public final C8294a m43596a(aai aai) {
            m42161b();
            ((we) this.a).m43601b(aai);
            return this;
        }
    }

    static {
        abq.m42174a(we.class, zzdjb);
    }

    private we() {
    }

    /* renamed from: a */
    public static we m43597a(aai aai) {
        return (we) abq.m42167a(zzdjb, aai);
    }

    /* renamed from: b */
    private final void m43600b(int i) {
        this.zzdih = i;
    }

    /* renamed from: b */
    private final void m43601b(aai aai) {
        if (aai != null) {
            this.zzdip = aai;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: c */
    public static C8294a m43602c() {
        return (C8294a) ((C8211a) zzdjb.mo6835a(C4918e.f14226e, null, null));
    }

    /* renamed from: a */
    public final int m43604a() {
        return this.zzdih;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (wf.f16078a[i - 1]) {
            case 1:
                return new we();
            case 2:
                return new C8294a();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdip"};
                return abq.m42172a(zzdjb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n", objArr);
            case 4:
                return zzdjb;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (we.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdjb);
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
    public final aai m43606b() {
        return this.zzdip;
    }
}
