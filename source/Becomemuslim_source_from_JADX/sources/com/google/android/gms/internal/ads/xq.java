package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import com.google.android.gms.internal.ads.abq.C6757b;
import com.google.android.gms.internal.ads.abq.C8211a;

public final class xq extends abq<xq, C8310a> implements acz {
    private static volatile adj<xq> zzakh;
    private static final xq zzdlz = new xq();
    private int zzdlq;
    private int zzdlr;
    private abv<C8312b> zzdly = abq.m42177m();

    /* renamed from: com.google.android.gms.internal.ads.xq$a */
    public static final class C8310a extends C8211a<xq, C8310a> implements acz {
        private C8310a() {
            super(xq.zzdlz);
        }

        /* renamed from: a */
        public final C8310a m43749a(int i) {
            m42161b();
            ((xq) this.a).m43771b(i);
            return this;
        }

        /* renamed from: a */
        public final C8310a m43750a(C8312b c8312b) {
            m42161b();
            ((xq) this.a).m43767a(c8312b);
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.xq$b */
    public static final class C8312b extends abq<C8312b, C8311a> implements acz {
        private static volatile adj<C8312b> zzakh;
        private static final C8312b zzdma = new C8312b();
        private String zzdks = "";
        private int zzdlj;
        private int zzdlv;
        private int zzdlw;

        /* renamed from: com.google.android.gms.internal.ads.xq$b$a */
        public static final class C8311a extends C8211a<C8312b, C8311a> implements acz {
            private C8311a() {
                super(C8312b.zzdma);
            }

            /* renamed from: a */
            public final C8311a m43751a(int i) {
                m42161b();
                ((C8312b) this.a).m43764b(i);
                return this;
            }

            /* renamed from: a */
            public final C8311a m43752a(xi xiVar) {
                m42161b();
                ((C8312b) this.a).m43756a(xiVar);
                return this;
            }

            /* renamed from: a */
            public final C8311a m43753a(yb ybVar) {
                m42161b();
                ((C8312b) this.a).m43761a(ybVar);
                return this;
            }

            /* renamed from: a */
            public final C8311a m43754a(String str) {
                m42161b();
                ((C8312b) this.a).m43762a(str);
                return this;
            }
        }

        static {
            abq.m42174a(C8312b.class, zzdma);
        }

        private C8312b() {
        }

        /* renamed from: a */
        public static C8311a m43755a() {
            return (C8311a) ((C8211a) zzdma.mo6835a(C4918e.f14226e, null, null));
        }

        /* renamed from: a */
        private final void m43756a(xi xiVar) {
            if (xiVar != null) {
                this.zzdlv = xiVar.mo3849a();
                return;
            }
            throw new NullPointerException();
        }

        /* renamed from: a */
        private final void m43761a(yb ybVar) {
            if (ybVar != null) {
                this.zzdlj = ybVar.mo3849a();
                return;
            }
            throw new NullPointerException();
        }

        /* renamed from: a */
        private final void m43762a(String str) {
            if (str != null) {
                this.zzdks = str;
                return;
            }
            throw new NullPointerException();
        }

        /* renamed from: b */
        private final void m43764b(int i) {
            this.zzdlw = i;
        }

        /* renamed from: a */
        protected final Object mo6835a(int i, Object obj, Object obj2) {
            switch (xr.f16092a[i - 1]) {
                case 1:
                    return new C8312b();
                case 2:
                    return new C8311a();
                case 3:
                    Object[] objArr = new Object[]{"zzdks", "zzdlv", "zzdlw", "zzdlj"};
                    return abq.m42172a(zzdma, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", objArr);
                case 4:
                    return zzdma;
                case 5:
                    Object obj3 = zzakh;
                    if (obj3 == null) {
                        synchronized (C8312b.class) {
                            obj3 = zzakh;
                            if (obj3 == null) {
                                obj3 = new C6757b(zzdma);
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
    }

    static {
        abq.m42174a(xq.class, zzdlz);
    }

    private xq() {
    }

    /* renamed from: a */
    public static C8310a m43766a() {
        return (C8310a) ((C8211a) zzdlz.mo6835a(C4918e.f14226e, null, null));
    }

    /* renamed from: a */
    private final void m43767a(C8312b c8312b) {
        if (c8312b != null) {
            if (!this.zzdly.mo3614a()) {
                abv abv = this.zzdly;
                int size = abv.size();
                this.zzdly = abv.mo6027a(size == 0 ? 10 : size << 1);
            }
            this.zzdly.add(c8312b);
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: b */
    private final void m43771b(int i) {
        this.zzdlr = i;
    }

    /* renamed from: a */
    protected final Object mo6835a(int i, Object obj, Object obj2) {
        switch (xr.f16092a[i - 1]) {
            case 1:
                return new xq();
            case 2:
                return new C8310a();
            case 3:
                Object[] objArr = new Object[]{"zzdlq", "zzdlr", "zzdly", C8312b.class};
                return abq.m42172a(zzdlz, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0003\u0000\u0001\u0000\u0001\u000b\u0002\u001b", objArr);
            case 4:
                return zzdlz;
            case 5:
                Object obj3 = zzakh;
                if (obj3 == null) {
                    synchronized (xq.class) {
                        obj3 = zzakh;
                        if (obj3 == null) {
                            obj3 = new C6757b(zzdlz);
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
}
