package com.p064b.p065a.p068c;

import com.p064b.p065a.p068c.p069a.p070a.C1007a;
import com.p064b.p065a.p068c.p069a.p070a.C1008b;
import com.p064b.p065a.p068c.p069a.p070a.C1009c;
import com.p064b.p065a.p068c.p069a.p070a.C1010d;
import com.p064b.p065a.p068c.p069a.p070a.C1011e;
import com.p064b.p065a.p068c.p069a.p070a.C1013f;
import com.p064b.p065a.p068c.p069a.p070a.C1013f.C1012a;
import io.p347a.p348a.p349a.C6514c;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: NativeCrashWriter */
/* renamed from: com.b.a.c.w */
class C1065w {
    /* renamed from: a */
    private static final C1011e f2963a = new C1011e("", "", 0);
    /* renamed from: b */
    private static final C1064j[] f2964b = new C1064j[0];
    /* renamed from: c */
    private static final C3440m[] f2965c = new C3440m[0];
    /* renamed from: d */
    private static final C3435g[] f2966d = new C3435g[0];
    /* renamed from: e */
    private static final C3430b[] f2967e = new C3430b[0];
    /* renamed from: f */
    private static final C3431c[] f2968f = new C3431c[0];

    /* compiled from: NativeCrashWriter */
    /* renamed from: com.b.a.c.w$j */
    private static abstract class C1064j {
        /* renamed from: a */
        private final int f2961a;
        /* renamed from: b */
        private final C1064j[] f2962b;

        /* renamed from: a */
        public int mo758a() {
            return 0;
        }

        /* renamed from: a */
        public void mo759a(C1022e c1022e) {
        }

        public C1064j(int i, C1064j... c1064jArr) {
            this.f2961a = i;
            if (c1064jArr == null) {
                c1064jArr = C1065w.f2964b;
            }
            this.f2962b = c1064jArr;
        }

        /* renamed from: b */
        public int mo761b() {
            int c = m3675c();
            return (c + C1022e.m3525l(c)) + C1022e.m3524j(this.f2961a);
        }

        /* renamed from: c */
        public int m3675c() {
            int a = mo758a();
            for (C1064j b : this.f2962b) {
                a += b.mo761b();
            }
            return a;
        }

        /* renamed from: b */
        public void mo760b(C1022e c1022e) {
            c1022e.m3548g(this.f2961a, 2);
            c1022e.m3550k(m3675c());
            mo759a(c1022e);
            for (C1064j b : this.f2962b) {
                b.mo760b(c1022e);
            }
        }
    }

    /* compiled from: NativeCrashWriter */
    /* renamed from: com.b.a.c.w$a */
    private static final class C3429a extends C1064j {
        public C3429a(C3434f c3434f, C3438k c3438k) {
            super(3, c3434f, c3438k);
        }
    }

    /* compiled from: NativeCrashWriter */
    /* renamed from: com.b.a.c.w$b */
    private static final class C3430b extends C1064j {
        /* renamed from: a */
        private final long f9129a;
        /* renamed from: b */
        private final long f9130b;
        /* renamed from: c */
        private final String f9131c;
        /* renamed from: d */
        private final String f9132d;

        public C3430b(C1007a c1007a) {
            super(4, new C1064j[0]);
            this.f9129a = c1007a.f2817a;
            this.f9130b = c1007a.f2818b;
            this.f9131c = c1007a.f2819c;
            this.f9132d = c1007a.f2820d;
        }

        /* renamed from: a */
        public int mo758a() {
            int b = C1022e.m3510b(1, this.f9129a);
            return ((C1022e.m3511b(3, C1017b.m3494a(this.f9131c)) + b) + C1022e.m3510b(2, this.f9130b)) + C1022e.m3511b(4, C1017b.m3494a(this.f9132d));
        }

        /* renamed from: a */
        public void mo759a(C1022e c1022e) {
            c1022e.m3532a(1, this.f9129a);
            c1022e.m3532a(2, this.f9130b);
            c1022e.m3533a(3, C1017b.m3494a(this.f9131c));
            c1022e.m3533a(4, C1017b.m3494a(this.f9132d));
        }
    }

    /* compiled from: NativeCrashWriter */
    /* renamed from: com.b.a.c.w$c */
    private static final class C3431c extends C1064j {
        /* renamed from: a */
        private final String f9133a;
        /* renamed from: b */
        private final String f9134b;

        public C3431c(C1008b c1008b) {
            super(2, new C1064j[0]);
            this.f9133a = c1008b.f2821a;
            this.f9134b = c1008b.f2822b;
        }

        /* renamed from: a */
        public int mo758a() {
            return C1022e.m3511b(1, C1017b.m3494a(this.f9133a)) + C1022e.m3511b(2, C1017b.m3494a(this.f9134b == null ? "" : this.f9134b));
        }

        /* renamed from: a */
        public void mo759a(C1022e c1022e) {
            c1022e.m3533a(1, C1017b.m3494a(this.f9133a));
            c1022e.m3533a(2, C1017b.m3494a(this.f9134b == null ? "" : this.f9134b));
        }
    }

    /* compiled from: NativeCrashWriter */
    /* renamed from: com.b.a.c.w$d */
    private static final class C3432d extends C1064j {
        /* renamed from: a */
        private final float f9135a;
        /* renamed from: b */
        private final int f9136b;
        /* renamed from: c */
        private final boolean f9137c;
        /* renamed from: d */
        private final int f9138d;
        /* renamed from: e */
        private final long f9139e;
        /* renamed from: f */
        private final long f9140f;

        public C3432d(float f, int i, boolean z, int i2, long j, long j2) {
            super(5, new C1064j[0]);
            this.f9135a = f;
            this.f9136b = i;
            this.f9137c = z;
            this.f9138d = i2;
            this.f9139e = j;
            this.f9140f = j2;
        }

        /* renamed from: a */
        public int mo758a() {
            return (((((C1022e.m3509b(1, this.f9135a) + 0) + C1022e.m3521f(2, this.f9136b)) + C1022e.m3512b(3, this.f9137c)) + C1022e.m3516d(4, this.f9138d)) + C1022e.m3510b(5, this.f9139e)) + C1022e.m3510b(6, this.f9140f);
        }

        /* renamed from: a */
        public void mo759a(C1022e c1022e) {
            c1022e.m3530a(1, this.f9135a);
            c1022e.m3544c(2, this.f9136b);
            c1022e.m3534a(3, this.f9137c);
            c1022e.m3531a(4, this.f9138d);
            c1022e.m3532a(5, this.f9139e);
            c1022e.m3532a(6, this.f9140f);
        }
    }

    /* compiled from: NativeCrashWriter */
    /* renamed from: com.b.a.c.w$e */
    private static final class C3433e extends C1064j {
        /* renamed from: a */
        private final long f9141a;
        /* renamed from: b */
        private final String f9142b;

        public C3433e(long j, String str, C1064j... c1064jArr) {
            super(10, c1064jArr);
            this.f9141a = j;
            this.f9142b = str;
        }

        /* renamed from: a */
        public int mo758a() {
            return C1022e.m3510b(1, this.f9141a) + C1022e.m3511b(2, C1017b.m3494a(this.f9142b));
        }

        /* renamed from: a */
        public void mo759a(C1022e c1022e) {
            c1022e.m3532a(1, this.f9141a);
            c1022e.m3533a(2, C1017b.m3494a(this.f9142b));
        }
    }

    /* compiled from: NativeCrashWriter */
    /* renamed from: com.b.a.c.w$f */
    private static final class C3434f extends C1064j {
        public C3434f(C3439l c3439l, C3438k c3438k, C3438k c3438k2) {
            super(1, c3438k, c3439l, c3438k2);
        }
    }

    /* compiled from: NativeCrashWriter */
    /* renamed from: com.b.a.c.w$g */
    private static final class C3435g extends C1064j {
        /* renamed from: a */
        private final long f9143a;
        /* renamed from: b */
        private final String f9144b;
        /* renamed from: c */
        private final String f9145c;
        /* renamed from: d */
        private final long f9146d;
        /* renamed from: e */
        private final int f9147e;

        public C3435g(C1012a c1012a) {
            super(3, new C1064j[0]);
            this.f9143a = c1012a.f2840a;
            this.f9144b = c1012a.f2841b;
            this.f9145c = c1012a.f2842c;
            this.f9146d = c1012a.f2843d;
            this.f9147e = c1012a.f2844e;
        }

        /* renamed from: a */
        public int mo758a() {
            return (((C1022e.m3510b(1, this.f9143a) + C1022e.m3511b(2, C1017b.m3494a(this.f9144b))) + C1022e.m3511b(3, C1017b.m3494a(this.f9145c))) + C1022e.m3510b(4, this.f9146d)) + C1022e.m3516d(5, this.f9147e);
        }

        /* renamed from: a */
        public void mo759a(C1022e c1022e) {
            c1022e.m3532a(1, this.f9143a);
            c1022e.m3533a(2, C1017b.m3494a(this.f9144b));
            c1022e.m3533a(3, C1017b.m3494a(this.f9145c));
            c1022e.m3532a(4, this.f9146d);
            c1022e.m3531a(5, this.f9147e);
        }
    }

    /* compiled from: NativeCrashWriter */
    /* renamed from: com.b.a.c.w$h */
    private static final class C3436h extends C1064j {
        /* renamed from: a */
        C1017b f9148a;

        public C3436h(C1017b c1017b) {
            super(6, new C1064j[0]);
            this.f9148a = c1017b;
        }

        /* renamed from: a */
        public int mo758a() {
            return C1022e.m3511b(1, this.f9148a);
        }

        /* renamed from: a */
        public void mo759a(C1022e c1022e) {
            c1022e.m3533a(1, this.f9148a);
        }
    }

    /* compiled from: NativeCrashWriter */
    /* renamed from: com.b.a.c.w$i */
    private static final class C3437i extends C1064j {
        /* renamed from: b */
        public void mo760b(C1022e c1022e) {
        }

        public C3437i() {
            super(0, new C1064j[0]);
        }
    }

    /* compiled from: NativeCrashWriter */
    /* renamed from: com.b.a.c.w$k */
    private static final class C3438k extends C1064j {
        /* renamed from: a */
        private final C1064j[] f9149a;

        public C3438k(C1064j... c1064jArr) {
            super(0, new C1064j[0]);
            this.f9149a = c1064jArr;
        }

        /* renamed from: b */
        public void mo760b(C1022e c1022e) {
            for (C1064j b : this.f9149a) {
                b.mo760b(c1022e);
            }
        }

        /* renamed from: b */
        public int mo761b() {
            int i = 0;
            for (C1064j b : this.f9149a) {
                i += b.mo761b();
            }
            return i;
        }
    }

    /* compiled from: NativeCrashWriter */
    /* renamed from: com.b.a.c.w$l */
    private static final class C3439l extends C1064j {
        /* renamed from: a */
        private final String f9150a;
        /* renamed from: b */
        private final String f9151b;
        /* renamed from: c */
        private final long f9152c;

        public C3439l(C1011e c1011e) {
            super(3, new C1064j[0]);
            this.f9150a = c1011e.f2837a;
            this.f9151b = c1011e.f2838b;
            this.f9152c = c1011e.f2839c;
        }

        /* renamed from: a */
        public int mo758a() {
            return (C1022e.m3511b(1, C1017b.m3494a(this.f9150a)) + C1022e.m3511b(2, C1017b.m3494a(this.f9151b))) + C1022e.m3510b(3, this.f9152c);
        }

        /* renamed from: a */
        public void mo759a(C1022e c1022e) {
            c1022e.m3533a(1, C1017b.m3494a(this.f9150a));
            c1022e.m3533a(2, C1017b.m3494a(this.f9151b));
            c1022e.m3532a(3, this.f9152c);
        }
    }

    /* compiled from: NativeCrashWriter */
    /* renamed from: com.b.a.c.w$m */
    private static final class C3440m extends C1064j {
        /* renamed from: a */
        private final String f9153a;
        /* renamed from: b */
        private final int f9154b;

        public C3440m(C1013f c1013f, C3438k c3438k) {
            super(1, c3438k);
            this.f9153a = c1013f.f2845a;
            this.f9154b = c1013f.f2846b;
        }

        /* renamed from: a */
        public int mo758a() {
            return C1022e.m3516d(2, this.f9154b) + (m11006d() ? C1022e.m3511b(1, C1017b.m3494a(this.f9153a)) : 0);
        }

        /* renamed from: a */
        public void mo759a(C1022e c1022e) {
            if (m11006d()) {
                c1022e.m3533a(1, C1017b.m3494a(this.f9153a));
            }
            c1022e.m3531a(2, this.f9154b);
        }

        /* renamed from: d */
        private boolean m11006d() {
            return this.f9153a != null && this.f9153a.length() > 0;
        }
    }

    /* renamed from: a */
    private static C3433e m3677a(C1010d c1010d, C1062t c1062t, Map<String, String> map) {
        C3429a c3429a = new C3429a(new C3434f(new C3439l(c1010d.f2832b != null ? c1010d.f2832b : f2963a), C1065w.m3681a(c1010d.f2833c), C1065w.m3678a(c1010d.f2834d)), C1065w.m3679a(C1065w.m3683a(c1010d.f2835e, map)));
        map = C1065w.m3676a(c1010d.f2836f);
        C1017b a = c1062t.m3657a();
        if (a == null) {
            C6514c.h().a("CrashlyticsCore", "No log data to include with this event.");
        }
        c1062t.m3661b();
        c1062t = a != null ? new C3436h(a) : new C3437i();
        return new C3433e(c1010d.f2831a, "ndk-crash", c3429a, map, c1062t);
    }

    /* renamed from: a */
    private static C1008b[] m3683a(C1008b[] c1008bArr, Map<String, String> map) {
        Map treeMap = new TreeMap(map);
        if (c1008bArr != null) {
            for (C1008b c1008b : c1008bArr) {
                treeMap.put(c1008b.f2821a, c1008b.f2822b);
            }
        }
        Entry[] entryArr = (Entry[]) treeMap.entrySet().toArray(new Entry[treeMap.size()]);
        C1008b[] c1008bArr2 = new C1008b[entryArr.length];
        for (map = null; map < c1008bArr2.length; map++) {
            c1008bArr2[map] = new C1008b((String) entryArr[map].getKey(), (String) entryArr[map].getValue());
        }
        return c1008bArr2;
    }

    /* renamed from: a */
    private static C3432d m3676a(C1009c c1009c) {
        return new C3432d(((float) c1009c.f2828f) / 100.0f, c1009c.f2829g, c1009c.f2830h, c1009c.f2823a, c1009c.f2824b - c1009c.f2826d, c1009c.f2825c - c1009c.f2827e);
    }

    /* renamed from: a */
    private static C3438k m3681a(C1013f[] c1013fArr) {
        C1064j[] c1064jArr = c1013fArr != null ? new C3440m[c1013fArr.length] : f2965c;
        for (int i = 0; i < c1064jArr.length; i++) {
            C1013f c1013f = c1013fArr[i];
            c1064jArr[i] = new C3440m(c1013f, C1065w.m3680a(c1013f.f2847c));
        }
        return new C3438k(c1064jArr);
    }

    /* renamed from: a */
    private static C3438k m3680a(C1012a[] c1012aArr) {
        C1064j[] c1064jArr = c1012aArr != null ? new C3435g[c1012aArr.length] : f2966d;
        for (int i = 0; i < c1064jArr.length; i++) {
            c1064jArr[i] = new C3435g(c1012aArr[i]);
        }
        return new C3438k(c1064jArr);
    }

    /* renamed from: a */
    private static C3438k m3678a(C1007a[] c1007aArr) {
        C1064j[] c1064jArr = c1007aArr != null ? new C3430b[c1007aArr.length] : f2967e;
        for (int i = 0; i < c1064jArr.length; i++) {
            c1064jArr[i] = new C3430b(c1007aArr[i]);
        }
        return new C3438k(c1064jArr);
    }

    /* renamed from: a */
    private static C3438k m3679a(C1008b[] c1008bArr) {
        C1064j[] c1064jArr = c1008bArr != null ? new C3431c[c1008bArr.length] : f2968f;
        for (int i = 0; i < c1064jArr.length; i++) {
            c1064jArr[i] = new C3431c(c1008bArr[i]);
        }
        return new C3438k(c1064jArr);
    }

    /* renamed from: a */
    public static void m3682a(C1010d c1010d, C1062t c1062t, Map<String, String> map, C1022e c1022e) {
        C1065w.m3677a(c1010d, c1062t, map).mo760b(c1022e);
    }
}
