package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class xm extends abq<xm, C8306a> implements acz {
    private static volatile adj<xm> zzakh;
    private static final xm zzdlp = new xm();
    private String zzdks = "";
    private String zzdll = "";
    private int zzdlm;
    private boolean zzdln;
    private String zzdlo = "";

    /* renamed from: com.google.android.gms.internal.ads.xm$a */
    public static final class C8306a extends C8211a<xm, C8306a> implements acz {
        private C8306a() {
            super(xm.zzdlp);
        }

        /* renamed from: a */
        public final C8306a m43713a(int i) {
            m42161b();
            ((xm) this.a).m43723b(0);
            return this;
        }

        /* renamed from: a */
        public final C8306a m43714a(String str) {
            m42161b();
            ((xm) this.a).m43721a(str);
            return this;
        }

        /* renamed from: a */
        public final C8306a m43715a(boolean z) {
            m42161b();
            ((xm) this.a).m43722a(true);
            return this;
        }

        /* renamed from: b */
        public final C8306a m43716b(String str) {
            m42161b();
            ((xm) this.a).m43725b(str);
            return this;
        }

        /* renamed from: c */
        public final C8306a m43717c(String str) {
            m42161b();
            ((xm) this.a).m43727c(str);
            return this;
        }
    }

    static {
        abq.m42174a(xm.class, zzdlp);
    }

    private xm() {
    }

    /* renamed from: a */
    private final void m43721a(String str) {
        if (str != null) {
            this.zzdll = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    private final void m43722a(boolean z) {
        this.zzdln = z;
    }

    /* renamed from: b */
    private final void m43723b(int i) {
        this.zzdlm = i;
    }

    /* renamed from: b */
    private final void m43725b(String str) {
        if (str != null) {
            this.zzdks = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: c */
    private final void m43727c(String str) {
        if (str != null) {
            this.zzdlo = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: f */
    public static C8306a m43728f() {
        return (C8306a) ((C8211a) zzdlp.mo6835a(C4918e.f14226e, null, null));
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (xn.f16090a[i - 1]) {
            case 1:
                return new xm();
            case 2:
                return new C8306a();
            case 3:
                Object[] objArr = new Object[]{"zzdll", "zzdks", "zzdlm", "zzdln", "zzdlo"};
                return abq.m42172a(zzdlp, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0006\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", objArr);
            case 4:
                return zzdlp;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (xm.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdlp);
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
    public final String m43731a() {
        return this.zzdll;
    }

    /* renamed from: b */
    public final String m43732b() {
        return this.zzdks;
    }

    /* renamed from: c */
    public final int m43733c() {
        return this.zzdlm;
    }

    /* renamed from: d */
    public final boolean m43734d() {
        return this.zzdln;
    }

    /* renamed from: e */
    public final String m43735e() {
        return this.zzdlo;
    }
}
