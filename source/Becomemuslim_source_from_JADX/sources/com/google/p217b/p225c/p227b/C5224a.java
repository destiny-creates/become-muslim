package com.google.p217b.p225c.p227b;

import com.google.p217b.C5316s;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5202b;
import com.google.p217b.p222b.C5206g;
import com.google.p217b.p222b.C5207i;
import com.google.p217b.p222b.p223a.C5194a;
import com.google.p217b.p222b.p223a.C5195b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: Detector */
/* renamed from: com.google.b.c.b.a */
public final class C5224a {
    /* renamed from: a */
    private final C5202b f17635a;
    /* renamed from: b */
    private final C5195b f17636b;

    /* compiled from: Detector */
    /* renamed from: com.google.b.c.b.a$a */
    private static final class C5222a {
        /* renamed from: a */
        private final C5316s f17632a;
        /* renamed from: b */
        private final C5316s f17633b;
        /* renamed from: c */
        private final int f17634c;

        private C5222a(C5316s c5316s, C5316s c5316s2, int i) {
            this.f17632a = c5316s;
            this.f17633b = c5316s2;
            this.f17634c = i;
        }

        /* renamed from: a */
        C5316s m22089a() {
            return this.f17632a;
        }

        /* renamed from: b */
        C5316s m22090b() {
            return this.f17633b;
        }

        /* renamed from: c */
        int m22091c() {
            return this.f17634c;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f17632a);
            stringBuilder.append("/");
            stringBuilder.append(this.f17633b);
            stringBuilder.append('/');
            stringBuilder.append(this.f17634c);
            return stringBuilder.toString();
        }
    }

    /* compiled from: Detector */
    /* renamed from: com.google.b.c.b.a$b */
    private static final class C5223b implements Serializable, Comparator<C5222a> {
        private C5223b() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m22092a((C5222a) obj, (C5222a) obj2);
        }

        /* renamed from: a */
        public int m22092a(C5222a c5222a, C5222a c5222a2) {
            return c5222a.m22091c() - c5222a2.m22091c();
        }
    }

    public C5224a(C5202b c5202b) {
        this.f17635a = c5202b;
        this.f17636b = new C5195b(c5202b);
    }

    /* renamed from: a */
    public C5206g m22100a() {
        C5316s[] a = this.f17636b.m21951a();
        C5316s c5316s = a[0];
        C5316s c5316s2 = a[1];
        C5316s c5316s3 = a[2];
        C5316s c5316s4 = a[3];
        List arrayList = new ArrayList(4);
        arrayList.add(m22099b(c5316s, c5316s2));
        arrayList.add(m22099b(c5316s, c5316s3));
        arrayList.add(m22099b(c5316s2, c5316s4));
        arrayList.add(m22099b(c5316s3, c5316s4));
        C52211 c52211 = null;
        Collections.sort(arrayList, new C5223b());
        C5222a c5222a = (C5222a) arrayList.get(0);
        C5222a c5222a2 = (C5222a) arrayList.get(1);
        Map hashMap = new HashMap();
        C5224a.m22097a(hashMap, c5222a.m22089a());
        C5224a.m22097a(hashMap, c5222a.m22090b());
        C5224a.m22097a(hashMap, c5222a2.m22089a());
        C5224a.m22097a(hashMap, c5222a2.m22090b());
        C5316s c5316s5 = null;
        C5316s c5316s6 = c5316s5;
        for (Entry entry : hashMap.entrySet()) {
            C5316s c5316s7 = (C5316s) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                c5316s5 = c5316s7;
            } else if (c52211 == null) {
                c52211 = c5316s7;
            } else {
                c5316s6 = c5316s7;
            }
        }
        if (c52211 == null || c5316s5 == null || c5316s6 == null) {
            throw C6894l.m32349a();
        }
        C5202b a2;
        C5316s c5316s8;
        C5316s[] c5316sArr = new C5316s[]{c52211, c5316s5, c5316s6};
        C5316s.m22581a(c5316sArr);
        c5316s6 = c5316sArr[0];
        C5316s c5316s9 = c5316sArr[1];
        C5316s c5316s10 = c5316sArr[2];
        C5316s c5316s11 = !hashMap.containsKey(c5316s) ? c5316s : !hashMap.containsKey(c5316s2) ? c5316s2 : !hashMap.containsKey(c5316s3) ? c5316s3 : c5316s4;
        int c = m22099b(c5316s10, c5316s11).m22091c();
        int c2 = m22099b(c5316s6, c5316s11).m22091c();
        if ((c & 1) == 1) {
            c++;
        }
        int i = c + 2;
        if ((c2 & 1) == 1) {
            c2++;
        }
        int i2 = c2 + 2;
        if (i * 4 < i2 * 7) {
            if (i2 * 4 < i * 7) {
                c5316s4 = m22095a(c5316s9, c5316s6, c5316s10, c5316s11, Math.min(i2, i));
                if (c5316s4 == null) {
                    c5316s4 = c5316s11;
                }
                c2 = Math.max(m22099b(c5316s10, c5316s4).m22091c(), m22099b(c5316s6, c5316s4).m22091c()) + 1;
                if ((c2 & 1) == 1) {
                    c2++;
                }
                int i3 = c2;
                a2 = C5224a.m22094a(r7.f17635a, c5316s10, c5316s9, c5316s6, c5316s4, i3, i3);
                c5316s8 = c5316s10;
                return new C5206g(a2, new C5316s[]{c5316s8, c5316s9, c5316s6, c5316s4});
            }
        }
        c5316s8 = c5316s10;
        c5316s4 = m22096a(c5316s9, c5316s6, c5316s10, c5316s11, i, i2);
        if (c5316s4 == null) {
            c5316s4 = c5316s11;
        }
        c2 = m22099b(c5316s8, c5316s4).m22091c();
        int c3 = m22099b(c5316s6, c5316s4).m22091c();
        if ((c2 & 1) == 1) {
            c2++;
        }
        int i4 = c2;
        if ((c3 & 1) == 1) {
            c3++;
        }
        a2 = C5224a.m22094a(r7.f17635a, c5316s8, c5316s9, c5316s6, c5316s4, i4, c3);
        return new C5206g(a2, new C5316s[]{c5316s8, c5316s9, c5316s6, c5316s4});
    }

    /* renamed from: a */
    private C5316s m22096a(C5316s c5316s, C5316s c5316s2, C5316s c5316s3, C5316s c5316s4, int i, int i2) {
        float a = ((float) C5224a.m22093a(c5316s, c5316s2)) / ((float) i);
        float a2 = (float) C5224a.m22093a(c5316s3, c5316s4);
        C5316s c5316s5 = new C5316s(c5316s4.m22582a() + (((c5316s4.m22582a() - c5316s3.m22582a()) / a2) * a), c5316s4.m22583b() + (a * ((c5316s4.m22583b() - c5316s3.m22583b()) / a2)));
        c5316s = ((float) C5224a.m22093a(c5316s, c5316s3)) / ((float) i2);
        a = (float) C5224a.m22093a(c5316s2, c5316s4);
        C5316s c5316s6 = new C5316s(c5316s4.m22582a() + (((c5316s4.m22582a() - c5316s2.m22582a()) / a) * c5316s), c5316s4.m22583b() + (c5316s * ((c5316s4.m22583b() - c5316s2.m22583b()) / a)));
        return m22098a(c5316s5) == null ? m22098a(c5316s6) != null ? c5316s6 : null : (m22098a(c5316s6) != null && Math.abs(i - m22099b(c5316s3, c5316s5).m22091c()) + Math.abs(i2 - m22099b(c5316s2, c5316s5).m22091c()) > Math.abs(i - m22099b(c5316s3, c5316s6).m22091c()) + Math.abs(i2 - m22099b(c5316s2, c5316s6).m22091c())) ? c5316s6 : c5316s5;
    }

    /* renamed from: a */
    private C5316s m22095a(C5316s c5316s, C5316s c5316s2, C5316s c5316s3, C5316s c5316s4, int i) {
        i = (float) i;
        float a = ((float) C5224a.m22093a(c5316s, c5316s2)) / i;
        float a2 = (float) C5224a.m22093a(c5316s3, c5316s4);
        C5316s c5316s5 = new C5316s(c5316s4.m22582a() + (((c5316s4.m22582a() - c5316s3.m22582a()) / a2) * a), c5316s4.m22583b() + (a * ((c5316s4.m22583b() - c5316s3.m22583b()) / a2)));
        c5316s = ((float) C5224a.m22093a(c5316s, c5316s3)) / i;
        i = (float) C5224a.m22093a(c5316s2, c5316s4);
        i = new C5316s(c5316s4.m22582a() + (((c5316s4.m22582a() - c5316s2.m22582a()) / i) * c5316s), c5316s4.m22583b() + (c5316s * ((c5316s4.m22583b() - c5316s2.m22583b()) / i)));
        return m22098a(c5316s5) == null ? m22098a(i) != null ? i : null : (m22098a(i) != null && Math.abs(m22099b(c5316s3, c5316s5).m22091c() - m22099b(c5316s2, c5316s5).m22091c()) > Math.abs(m22099b(c5316s3, i).m22091c() - m22099b(c5316s2, i).m22091c())) ? i : c5316s5;
    }

    /* renamed from: a */
    private boolean m22098a(C5316s c5316s) {
        return (c5316s.m22582a() < 0.0f || c5316s.m22582a() >= ((float) this.f17635a.m22010f()) || c5316s.m22583b() <= 0.0f || c5316s.m22583b() >= ((float) this.f17635a.m22011g())) ? null : true;
    }

    /* renamed from: a */
    private static int m22093a(C5316s c5316s, C5316s c5316s2) {
        return C5194a.m21946a(C5316s.m22579a(c5316s, c5316s2));
    }

    /* renamed from: a */
    private static void m22097a(Map<C5316s, Integer> map, C5316s c5316s) {
        Integer num = (Integer) map.get(c5316s);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        map.put(c5316s, Integer.valueOf(i));
    }

    /* renamed from: a */
    private static C5202b m22094a(C5202b c5202b, C5316s c5316s, C5316s c5316s2, C5316s c5316s3, C5316s c5316s4, int i, int i2) {
        float f = ((float) i) - 0.5f;
        float f2 = ((float) i2) - 0.5f;
        return C5207i.m22035a().mo4861a(c5202b, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, c5316s.m22582a(), c5316s.m22583b(), c5316s4.m22582a(), c5316s4.m22583b(), c5316s3.m22582a(), c5316s3.m22583b(), c5316s2.m22582a(), c5316s2.m22583b());
    }

    /* renamed from: b */
    private C5222a m22099b(C5316s c5316s, C5316s c5316s2) {
        C5224a c5224a = this;
        int a = (int) c5316s.m22582a();
        int b = (int) c5316s.m22583b();
        int a2 = (int) c5316s2.m22582a();
        int b2 = (int) c5316s2.m22583b();
        int i = 0;
        int i2 = 1;
        Object obj = Math.abs(b2 - b) > Math.abs(a2 - a) ? 1 : null;
        if (obj != null) {
            int i3 = b;
            b = a;
            a = i3;
            int i4 = b2;
            b2 = a2;
            a2 = i4;
        }
        int abs = Math.abs(a2 - a);
        int abs2 = Math.abs(b2 - b);
        int i5 = (-abs) / 2;
        int i6 = b < b2 ? 1 : -1;
        if (a >= a2) {
            i2 = -1;
        }
        boolean a3 = c5224a.f17635a.m22002a(obj != null ? b : a, obj != null ? a : b);
        while (a != a2) {
            boolean a4 = c5224a.f17635a.m22002a(obj != null ? b : a, obj != null ? a : b);
            if (a4 != a3) {
                i++;
                a3 = a4;
            }
            i5 += abs2;
            if (i5 > 0) {
                if (b == b2) {
                    break;
                }
                b += i6;
                i5 -= abs;
            }
            a += i2;
        }
        return new C5222a(c5316s, c5316s2, i);
    }
}
