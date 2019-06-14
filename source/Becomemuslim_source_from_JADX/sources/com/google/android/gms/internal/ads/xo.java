package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;
import java.util.List;

public final class xo extends abq<xo, C8307a> implements acz {
    private static volatile adj<xo> zzakh;
    private static final xo zzdlt = new xo();
    private int zzdlq;
    private int zzdlr;
    private abv<C8309b> zzdls = abq.m42177m();

    /* renamed from: com.google.android.gms.internal.ads.xo$a */
    public static final class C8307a extends C8211a<xo, C8307a> implements acz {
        private C8307a() {
            super(xo.zzdlt);
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.xo$b */
    public static final class C8309b extends abq<C8309b, C8308a> implements acz {
        private static volatile adj<C8309b> zzakh;
        private static final C8309b zzdlx = new C8309b();
        private int zzdlj;
        private xf zzdlu;
        private int zzdlv;
        private int zzdlw;

        /* renamed from: com.google.android.gms.internal.ads.xo$b$a */
        public static final class C8308a extends C8211a<C8309b, C8308a> implements acz {
            private C8308a() {
                super(C8309b.zzdlx);
            }
        }

        static {
            abq.m42174a(C8309b.class, zzdlx);
        }

        private C8309b() {
        }

        /* renamed from: a */
        protected final Object mo6835a(int i, Object obj, Object obj2) {
            switch (xp.f16091a[i - 1]) {
                case 1:
                    return new C8309b();
                case 2:
                    return new C8308a();
                case 3:
                    Object[] objArr = new Object[]{"zzdlu", "zzdlv", "zzdlw", "zzdlj"};
                    return abq.m42172a(zzdlx, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", objArr);
                case 4:
                    return zzdlx;
                case 5:
                    Object obj3 = zzakh;
                    if (obj3 == null) {
                        synchronized (C8309b.class) {
                            obj3 = zzakh;
                            if (obj3 == null) {
                                obj3 = new C6757b(zzdlx);
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
        public final boolean m43738a() {
            return this.zzdlu != null;
        }

        /* renamed from: b */
        public final xf m43739b() {
            return this.zzdlu == null ? xf.m43702e() : this.zzdlu;
        }

        /* renamed from: c */
        public final xi m43740c() {
            xi a = xi.m31229a(this.zzdlv);
            return a == null ? xi.UNRECOGNIZED : a;
        }

        /* renamed from: d */
        public final int m43741d() {
            return this.zzdlw;
        }

        /* renamed from: e */
        public final yb m43742e() {
            yb a = yb.m31232a(this.zzdlj);
            return a == null ? yb.UNRECOGNIZED : a;
        }
    }

    static {
        abq.m42174a(xo.class, zzdlt);
    }

    private xo() {
    }

    /* renamed from: a */
    public static xo m43743a(byte[] bArr) {
        return (xo) abq.m42170a(zzdlt, bArr);
    }

    /* renamed from: a */
    public final int m43745a() {
        return this.zzdlr;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (xp.f16091a[i - 1]) {
            case 1:
                return new xo();
            case 2:
                return new C8307a();
            case 3:
                Object[] objArr = new Object[]{"zzdlq", "zzdlr", "zzdls", C8309b.class};
                return abq.m42172a(zzdlt, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0003\u0000\u0001\u0000\u0001\u000b\u0002\u001b", objArr);
            case 4:
                return zzdlt;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (xo.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdlt);
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
    public final List<C8309b> m43747b() {
        return this.zzdls;
    }

    /* renamed from: c */
    public final int m43748c() {
        return this.zzdls.size();
    }
}
