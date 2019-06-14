package com.google.android.gms.internal.p210i;

import com.google.android.gms.internal.p210i.fk.C4996e;
import com.google.android.gms.internal.p210i.fk.C7817b;
import com.google.android.gms.internal.p210i.fk.C8218a;
import java.util.List;

/* renamed from: com.google.android.gms.internal.i.bc */
public final class bc {

    /* renamed from: com.google.android.gms.internal.i.bc$a */
    public static final class C8327a extends fk<C8327a, C8326a> implements gv {
        private static final C8327a zznv = new C8327a();
        private static volatile hd<C8327a> zznw;
        private int zznr;
        private int zzns = 1;
        private int zznt;
        private int zznu;

        /* renamed from: com.google.android.gms.internal.i.bc$a$b */
        public enum C6789b implements fn {
            NO_CACHE(1),
            PRIVATE(2),
            PUBLIC(3);
            
            /* renamed from: d */
            private static final fo<C6789b> f24443d = null;
            /* renamed from: e */
            private final int f24445e;

            /* renamed from: a */
            public final int mo4414a() {
                return this.f24445e;
            }

            /* renamed from: a */
            public static C6789b m31312a(int i) {
                switch (i) {
                    case 1:
                        return NO_CACHE;
                    case 2:
                        return PRIVATE;
                    case 3:
                        return PUBLIC;
                    default:
                        return 0;
                }
            }

            /* renamed from: b */
            public static fp m31313b() {
                return cn.f24459a;
            }

            private C6789b(int i) {
                this.f24445e = i;
            }

            static {
                f24443d = new cm();
            }
        }

        /* renamed from: com.google.android.gms.internal.i.bc$a$a */
        public static final class C8326a extends C8218a<C8327a, C8326a> implements gv {
            private C8326a() {
                super(C8327a.zznv);
            }
        }

        private C8327a() {
        }

        /* renamed from: a */
        protected final Object mo6849a(int i, Object obj, Object obj2) {
            switch (ca.f16450a[i - 1]) {
                case 1:
                    return new C8327a();
                case 2:
                    return new C8326a();
                case 3:
                    i = new Object[]{"zznr", "zzns", C6789b.m31313b(), "zznt", "zznu"};
                    return fk.m42484a((gt) zznv, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\u0004\u0001\u0003\u0004\u0002", (Object[]) i);
                case 4:
                    return zznv;
                case 5:
                    i = zznw;
                    if (i == 0) {
                        synchronized (C8327a.class) {
                            i = zznw;
                            if (i == 0) {
                                i = new C7817b(zznv);
                                zznw = i;
                            }
                        }
                    }
                    return i;
                case 6:
                    return Byte.valueOf((byte) 1);
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* renamed from: a */
        public static hd<C8327a> m43847a() {
            return (hd) zznv.mo6849a(C4996e.f16609g, null, null);
        }

        static {
            fk.m42486a(C8327a.class, zznv);
        }
    }

    /* renamed from: com.google.android.gms.internal.i.bc$b */
    public static final class C8329b extends fk<C8329b, C8328a> implements gv {
        private static volatile hd<C8329b> zznw;
        private static final C8329b zzoj = new C8329b();
        private int zznr;
        private fq zzod = fk.m42488s();
        private int zzoe;
        private int zzof;
        private boolean zzog;
        private boolean zzoh;
        private byte zzoi = (byte) 2;

        /* renamed from: com.google.android.gms.internal.i.bc$b$a */
        public static final class C8328a extends C8218a<C8329b, C8328a> implements gv {
            private C8328a() {
                super(C8329b.zzoj);
            }
        }

        private C8329b() {
        }

        /* renamed from: a */
        public final List<Integer> m43853a() {
            return this.zzod;
        }

        /* renamed from: a */
        protected final Object mo6849a(int i, Object obj, Object obj2) {
            obj2 = null;
            switch (ca.f16450a[i - 1]) {
                case 1:
                    return new C8329b();
                case 2:
                    return new C8328a();
                case 3:
                    i = new Object[]{"zznr", "zzoh", "zzoe", "zzod", "zzof", "zzog"};
                    return fk.m42484a((gt) zzoj, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0001\u0001\u0001\u0007\u0003\u0002Ԅ\u0000\u0003\u0016\u0004\u0004\u0001\u0006\u0007\u0002", (Object[]) i);
                case 4:
                    return zzoj;
                case 5:
                    i = zznw;
                    if (i == 0) {
                        synchronized (C8329b.class) {
                            i = zznw;
                            if (i == 0) {
                                i = new C7817b(zzoj);
                                zznw = i;
                            }
                        }
                    }
                    return i;
                case 6:
                    return Byte.valueOf(this.zzoi);
                case 7:
                    if (obj != null) {
                        obj2 = true;
                    }
                    this.zzoi = (byte) obj2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* renamed from: b */
        public static hd<C8329b> m43850b() {
            return (hd) zzoj.mo6849a(C4996e.f16609g, null, null);
        }

        static {
            fk.m42486a(C8329b.class, zzoj);
        }
    }

    /* renamed from: com.google.android.gms.internal.i.bc$c */
    public static final class C8331c extends fk<C8331c, C8330a> implements gv {
        private static volatile hd<C8331c> zznw;
        private static final C8331c zzop = new C8331c();
        private int zznr;
        private String zzok = "";
        private long zzol;
        private long zzom = 2147483647L;
        private boolean zzon;
        private long zzoo;

        /* renamed from: com.google.android.gms.internal.i.bc$c$a */
        public static final class C8330a extends C8218a<C8331c, C8330a> implements gv {
            private C8330a() {
                super(C8331c.zzop);
            }
        }

        private C8331c() {
        }

        /* renamed from: a */
        public final boolean m43857a() {
            return (this.zznr & 1) != 0;
        }

        /* renamed from: b */
        public final String m43858b() {
            return this.zzok;
        }

        /* renamed from: c */
        public final long m43859c() {
            return this.zzol;
        }

        /* renamed from: d */
        public final long m43860d() {
            return this.zzom;
        }

        /* renamed from: e */
        public final boolean m43861e() {
            return this.zzon;
        }

        /* renamed from: f */
        public final long m43862f() {
            return this.zzoo;
        }

        /* renamed from: a */
        protected final Object mo6849a(int i, Object obj, Object obj2) {
            switch (ca.f16450a[i - 1]) {
                case 1:
                    return new C8331c();
                case 2:
                    return new C8330a();
                case 3:
                    i = new Object[]{"zznr", "zzok", "zzol", "zzom", "zzon", "zzoo"};
                    return fk.m42484a((gt) zzop, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\u0002\u0002\u0004\u0007\u0003\u0005\u0002\u0004", (Object[]) i);
                case 4:
                    return zzop;
                case 5:
                    i = zznw;
                    if (i == 0) {
                        synchronized (C8331c.class) {
                            i = zznw;
                            if (i == 0) {
                                i = new C7817b(zzop);
                                zznw = i;
                            }
                        }
                    }
                    return i;
                case 6:
                    return Byte.valueOf((byte) 1);
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* renamed from: g */
        public static hd<C8331c> m43854g() {
            return (hd) zzop.mo6849a(C4996e.f16609g, null, null);
        }

        static {
            fk.m42486a(C8331c.class, zzop);
        }
    }

    /* renamed from: com.google.android.gms.internal.i.bc$d */
    public static final class C8333d extends fk<C8333d, C8332a> implements gv {
        private static volatile hd<C8333d> zznw;
        private static final C8333d zzos = new C8333d();
        private int zznr;
        private byte zzoi = (byte) 2;
        private int zzoq;
        private int zzor;

        /* renamed from: com.google.android.gms.internal.i.bc$d$a */
        public static final class C8332a extends C8218a<C8333d, C8332a> implements gv {
            private C8332a() {
                super(C8333d.zzos);
            }
        }

        private C8333d() {
        }

        /* renamed from: a */
        public final int m43865a() {
            return this.zzoq;
        }

        /* renamed from: b */
        public final int m43867b() {
            return this.zzor;
        }

        /* renamed from: a */
        protected final Object mo6849a(int i, Object obj, Object obj2) {
            obj2 = null;
            switch (ca.f16450a[i - 1]) {
                case 1:
                    return new C8333d();
                case 2:
                    return new C8332a();
                case 3:
                    i = new Object[]{"zznr", "zzoq", "zzor"};
                    return fk.m42484a((gt) zzos, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԅ\u0000\u0002Ԅ\u0001", (Object[]) i);
                case 4:
                    return zzos;
                case 5:
                    i = zznw;
                    if (i == 0) {
                        synchronized (C8333d.class) {
                            i = zznw;
                            if (i == 0) {
                                i = new C7817b(zzos);
                                zznw = i;
                            }
                        }
                    }
                    return i;
                case 6:
                    return Byte.valueOf(this.zzoi);
                case 7:
                    if (obj != null) {
                        obj2 = true;
                    }
                    this.zzoi = (byte) obj2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* renamed from: c */
        public static hd<C8333d> m43863c() {
            return (hd) zzos.mo6849a(C4996e.f16609g, null, null);
        }

        static {
            fk.m42486a(C8333d.class, zzos);
        }
    }

    /* renamed from: com.google.android.gms.internal.i.bc$e */
    public static final class C8335e extends fk<C8335e, C8334a> implements gv {
        private static volatile hd<C8335e> zznw;
        private static final C8335e zzpd = new C8335e();
        private fq zzot = fk.m42488s();
        private fq zzou = fk.m42488s();
        private fq zzov = fk.m42488s();
        private fq zzow = fk.m42488s();
        private fq zzox = fk.m42488s();
        private fq zzoy = fk.m42488s();
        private fq zzoz = fk.m42488s();
        private fq zzpa = fk.m42488s();
        private fq zzpb = fk.m42488s();
        private fq zzpc = fk.m42488s();

        /* renamed from: com.google.android.gms.internal.i.bc$e$a */
        public static final class C8334a extends C8218a<C8335e, C8334a> implements gv {
            private C8334a() {
                super(C8335e.zzpd);
            }
        }

        private C8335e() {
        }

        /* renamed from: a */
        public final List<Integer> m43871a() {
            return this.zzot;
        }

        /* renamed from: b */
        public final List<Integer> m43872b() {
            return this.zzou;
        }

        /* renamed from: c */
        public final List<Integer> m43873c() {
            return this.zzov;
        }

        /* renamed from: d */
        public final List<Integer> m43874d() {
            return this.zzow;
        }

        /* renamed from: e */
        public final List<Integer> m43875e() {
            return this.zzox;
        }

        /* renamed from: f */
        public final List<Integer> m43876f() {
            return this.zzoy;
        }

        /* renamed from: g */
        public final List<Integer> m43877g() {
            return this.zzoz;
        }

        /* renamed from: h */
        public final List<Integer> m43878h() {
            return this.zzpa;
        }

        /* renamed from: i */
        public final List<Integer> m43879i() {
            return this.zzpb;
        }

        /* renamed from: j */
        public final List<Integer> m43880j() {
            return this.zzpc;
        }

        /* renamed from: a */
        protected final Object mo6849a(int i, Object obj, Object obj2) {
            switch (ca.f16450a[i - 1]) {
                case 1:
                    return new C8335e();
                case 2:
                    return new C8334a();
                case 3:
                    i = new Object[]{"zzot", "zzou", "zzov", "zzow", "zzox", "zzoy", "zzoz", "zzpa", "zzpb", "zzpc"};
                    return fk.m42484a((gt) zzpd, "\u0001\n\u0000\u0000\u0001\n\n\u0000\n\u0000\u0001\u0016\u0002\u0016\u0003\u0016\u0004\u0016\u0005\u0016\u0006\u0016\u0007\u0016\b\u0016\t\u0016\n\u0016", (Object[]) i);
                case 4:
                    return zzpd;
                case 5:
                    i = zznw;
                    if (i == 0) {
                        synchronized (C8335e.class) {
                            i = zznw;
                            if (i == 0) {
                                i = new C7817b(zzpd);
                                zznw = i;
                            }
                        }
                    }
                    return i;
                case 6:
                    return Byte.valueOf((byte) 1);
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* renamed from: k */
        public static hd<C8335e> m43868k() {
            return (hd) zzpd.mo6849a(C4996e.f16609g, null, null);
        }

        static {
            fk.m42486a(C8335e.class, zzpd);
        }
    }
}
