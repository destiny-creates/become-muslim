package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class wq extends abq<wq, C8299a> implements acz {
    private static volatile adj<wq> zzakh;
    private static final wq zzdjt = new wq();
    private int zzdih;
    private wm zzdjj;
    private aai zzdjr = aai.f14132a;
    private aai zzdjs = aai.f14132a;

    /* renamed from: com.google.android.gms.internal.ads.wq$a */
    public static final class C8299a extends C8211a<wq, C8299a> implements acz {
        private C8299a() {
            super(wq.zzdjt);
        }

        /* renamed from: a */
        public final C8299a m43637a(int i) {
            m42161b();
            ((wq) this.a).m43646b(0);
            return this;
        }

        /* renamed from: a */
        public final C8299a m43638a(aai aai) {
            m42161b();
            ((wq) this.a).m43647b(aai);
            return this;
        }

        /* renamed from: a */
        public final C8299a m43639a(wm wmVar) {
            m42161b();
            ((wq) this.a).m43642a(wmVar);
            return this;
        }

        /* renamed from: b */
        public final C8299a m43640b(aai aai) {
            m42161b();
            ((wq) this.a).m43649c(aai);
            return this;
        }
    }

    static {
        abq.m42174a(wq.class, zzdjt);
    }

    private wq() {
    }

    /* renamed from: a */
    public static wq m43641a(aai aai) {
        return (wq) abq.m42167a(zzdjt, aai);
    }

    /* renamed from: a */
    private final void m43642a(wm wmVar) {
        if (wmVar != null) {
            this.zzdjj = wmVar;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: b */
    private final void m43646b(int i) {
        this.zzdih = i;
    }

    /* renamed from: b */
    private final void m43647b(aai aai) {
        if (aai != null) {
            this.zzdjr = aai;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: c */
    private final void m43649c(aai aai) {
        if (aai != null) {
            this.zzdjs = aai;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: e */
    public static C8299a m43650e() {
        return (C8299a) ((C8211a) zzdjt.mo6835a(C4918e.f14226e, null, null));
    }

    /* renamed from: f */
    public static wq m43651f() {
        return zzdjt;
    }

    /* renamed from: a */
    public final int m43653a() {
        return this.zzdih;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (wr.f16083a[i - 1]) {
            case 1:
                return new wq();
            case 2:
                return new C8299a();
            case 3:
                Object[] objArr = new Object[]{"zzdih", "zzdjj", "zzdjr", "zzdjs"};
                return abq.m42172a(zzdjt, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", objArr);
            case 4:
                return zzdjt;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (wq.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdjt);
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
    public final wm m43655b() {
        return this.zzdjj == null ? wm.m43615d() : this.zzdjj;
    }

    /* renamed from: c */
    public final aai m43656c() {
        return this.zzdjr;
    }

    /* renamed from: d */
    public final aai m43657d() {
        return this.zzdjs;
    }
}
