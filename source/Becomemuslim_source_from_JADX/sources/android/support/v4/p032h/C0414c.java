package android.support.v4.p032h;

import java.util.Locale;

/* compiled from: TextDirectionHeuristicsCompat */
/* renamed from: android.support.v4.h.c */
public final class C0414c {
    /* renamed from: a */
    public static final C0412b f1068a = new C4460e(null, false);
    /* renamed from: b */
    public static final C0412b f1069b = new C4460e(null, true);
    /* renamed from: c */
    public static final C0412b f1070c = new C4460e(C3201b.f8250a, false);
    /* renamed from: d */
    public static final C0412b f1071d = new C4460e(C3201b.f8250a, true);
    /* renamed from: e */
    public static final C0412b f1072e = new C4460e(C3200a.f8247a, false);
    /* renamed from: f */
    public static final C0412b f1073f = C4461f.f11912a;

    /* compiled from: TextDirectionHeuristicsCompat */
    /* renamed from: android.support.v4.h.c$c */
    private interface C0413c {
        /* renamed from: a */
        int mo228a(CharSequence charSequence, int i, int i2);
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    /* renamed from: android.support.v4.h.c$a */
    private static class C3200a implements C0413c {
        /* renamed from: a */
        static final C3200a f8247a = new C3200a(true);
        /* renamed from: b */
        static final C3200a f8248b = new C3200a(false);
        /* renamed from: c */
        private final boolean f8249c;

        /* renamed from: a */
        public int mo228a(CharSequence charSequence, int i, int i2) {
            i2 += i;
            Object obj = null;
            while (i < i2) {
                switch (C0414c.m1219a(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (this.f8249c) {
                            return 0;
                        }
                        break;
                    case 1:
                        if (!this.f8249c) {
                            return 1;
                        }
                        break;
                    default:
                        continue;
                }
                obj = 1;
                i++;
            }
            return obj != null ? this.f8249c : 2;
        }

        private C3200a(boolean z) {
            this.f8249c = z;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    /* renamed from: android.support.v4.h.c$b */
    private static class C3201b implements C0413c {
        /* renamed from: a */
        static final C3201b f8250a = new C3201b();

        /* renamed from: a */
        public int mo228a(CharSequence charSequence, int i, int i2) {
            i2 += i;
            int i3 = 2;
            while (i < i2 && i3 == 2) {
                i3 = C0414c.m1220b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i3;
        }

        private C3201b() {
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    /* renamed from: android.support.v4.h.c$d */
    private static abstract class C3202d implements C0412b {
        /* renamed from: a */
        private final C0413c f8251a;

        /* renamed from: a */
        protected abstract boolean mo2681a();

        C3202d(C0413c c0413c) {
            this.f8251a = c0413c;
        }

        /* renamed from: a */
        public boolean mo229a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            } else if (this.f8251a == null) {
                return mo2681a();
            } else {
                return m9677b(charSequence, i, i2);
            }
        }

        /* renamed from: b */
        private boolean m9677b(CharSequence charSequence, int i, int i2) {
            switch (this.f8251a.mo228a(charSequence, i, i2)) {
                case null:
                    return true;
                case 1:
                    return null;
                default:
                    return mo2681a();
            }
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    /* renamed from: android.support.v4.h.c$e */
    private static class C4460e extends C3202d {
        /* renamed from: a */
        private final boolean f11911a;

        C4460e(C0413c c0413c, boolean z) {
            super(c0413c);
            this.f11911a = z;
        }

        /* renamed from: a */
        protected boolean mo2681a() {
            return this.f11911a;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    /* renamed from: android.support.v4.h.c$f */
    private static class C4461f extends C3202d {
        /* renamed from: a */
        static final C4461f f11912a = new C4461f();

        C4461f() {
            super(null);
        }

        /* renamed from: a */
        protected boolean mo2681a() {
            return C0415d.m1221a(Locale.getDefault()) == 1;
        }
    }

    /* renamed from: a */
    static int m1219a(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    static int m1220b(int r0) {
        /*
        switch(r0) {
            case 0: goto L_0x000a;
            case 1: goto L_0x0008;
            case 2: goto L_0x0008;
            default: goto L_0x0003;
        };
    L_0x0003:
        switch(r0) {
            case 14: goto L_0x000a;
            case 15: goto L_0x000a;
            case 16: goto L_0x0008;
            case 17: goto L_0x0008;
            default: goto L_0x0006;
        };
    L_0x0006:
        r0 = 2;
        return r0;
    L_0x0008:
        r0 = 0;
        return r0;
    L_0x000a:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.h.c.b(int):int");
    }
}
