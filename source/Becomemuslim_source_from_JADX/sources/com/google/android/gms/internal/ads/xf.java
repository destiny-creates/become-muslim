package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class xf extends abq<xf, C8304a> implements acz {
    private static volatile adj<xf> zzakh;
    private static final xf zzdkv = new xf();
    private String zzdks = "";
    private aai zzdkt = aai.f14132a;
    private int zzdku;

    /* renamed from: com.google.android.gms.internal.ads.xf$b */
    public enum C6771b implements abt {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        /* renamed from: g */
        private static final abu<C6771b> f24370g = null;
        /* renamed from: h */
        private final int f24372h;

        static {
            f24370g = new xh();
        }

        private C6771b(int i) {
            this.f24372h = i;
        }

        /* renamed from: a */
        public static C6771b m31226a(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_KEYMATERIAL;
                case 1:
                    return SYMMETRIC;
                case 2:
                    return ASYMMETRIC_PRIVATE;
                case 3:
                    return ASYMMETRIC_PUBLIC;
                case 4:
                    return REMOTE;
                default:
                    return null;
            }
        }

        /* renamed from: a */
        public final int mo3849a() {
            if (this != UNRECOGNIZED) {
                return this.f24372h;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.xf$a */
    public static final class C8304a extends C8211a<xf, C8304a> implements acz {
        private C8304a() {
            super(xf.zzdkv);
        }

        /* renamed from: a */
        public final C8304a m43692a(aai aai) {
            m42161b();
            ((xf) this.a).m43695a(aai);
            return this;
        }

        /* renamed from: a */
        public final C8304a m43693a(C6771b c6771b) {
            m42161b();
            ((xf) this.a).m43696a(c6771b);
            return this;
        }

        /* renamed from: a */
        public final C8304a m43694a(String str) {
            m42161b();
            ((xf) this.a).m43700a(str);
            return this;
        }
    }

    static {
        abq.m42174a(xf.class, zzdkv);
    }

    private xf() {
    }

    /* renamed from: a */
    private final void m43695a(aai aai) {
        if (aai != null) {
            this.zzdkt = aai;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    private final void m43696a(C6771b c6771b) {
        if (c6771b != null) {
            this.zzdku = c6771b.mo3849a();
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    private final void m43700a(String str) {
        if (str != null) {
            this.zzdks = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: d */
    public static C8304a m43701d() {
        return (C8304a) ((C8211a) zzdkv.mo6835a(C4918e.f14226e, null, null));
    }

    /* renamed from: e */
    public static xf m43702e() {
        return zzdkv;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (xg.f16088a[i - 1]) {
            case 1:
                return new xf();
            case 2:
                return new C8304a();
            case 3:
                Object[] objArr = new Object[]{"zzdks", "zzdkt", "zzdku"};
                return abq.m42172a(zzdkv, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", objArr);
            case 4:
                return zzdkv;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (xf.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdkv);
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
    public final String m43705a() {
        return this.zzdks;
    }

    /* renamed from: b */
    public final aai m43706b() {
        return this.zzdkt;
    }

    /* renamed from: c */
    public final C6771b m43707c() {
        C6771b a = C6771b.m31226a(this.zzdku);
        return a == null ? C6771b.UNRECOGNIZED : a;
    }
}
