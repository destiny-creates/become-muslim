package expolib_v1.p321a.p322a.p327e;

import com.facebook.common.util.UriUtil;
import com.facebook.imageutils.JfifUtil;
import com.facebook.places.model.PlaceFields;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p332b.C6251f;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C6258s;
import expolib_v1.p332b.C7497e;
import expolib_v1.p332b.C8170c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Hpack */
/* renamed from: expolib_v1.a.a.e.d */
final class C6173d {
    /* renamed from: a */
    static final C6170c[] f19958a = new C6170c[]{new C6170c(C6170c.f19936f, ""), new C6170c(C6170c.f19933c, "GET"), new C6170c(C6170c.f19933c, "POST"), new C6170c(C6170c.f19934d, "/"), new C6170c(C6170c.f19934d, "/index.html"), new C6170c(C6170c.f19935e, UriUtil.HTTP_SCHEME), new C6170c(C6170c.f19935e, UriUtil.HTTPS_SCHEME), new C6170c(C6170c.f19932b, "200"), new C6170c(C6170c.f19932b, "204"), new C6170c(C6170c.f19932b, "206"), new C6170c(C6170c.f19932b, "304"), new C6170c(C6170c.f19932b, "400"), new C6170c(C6170c.f19932b, "404"), new C6170c(C6170c.f19932b, "500"), new C6170c("accept-charset", ""), new C6170c("accept-encoding", "gzip, deflate"), new C6170c("accept-language", ""), new C6170c("accept-ranges", ""), new C6170c("accept", ""), new C6170c("access-control-allow-origin", ""), new C6170c("age", ""), new C6170c("allow", ""), new C6170c("authorization", ""), new C6170c("cache-control", ""), new C6170c("content-disposition", ""), new C6170c("content-encoding", ""), new C6170c("content-language", ""), new C6170c("content-length", ""), new C6170c("content-location", ""), new C6170c("content-range", ""), new C6170c("content-type", ""), new C6170c("cookie", ""), new C6170c("date", ""), new C6170c("etag", ""), new C6170c("expect", ""), new C6170c("expires", ""), new C6170c("from", ""), new C6170c("host", ""), new C6170c("if-match", ""), new C6170c("if-modified-since", ""), new C6170c("if-none-match", ""), new C6170c("if-range", ""), new C6170c("if-unmodified-since", ""), new C6170c("last-modified", ""), new C6170c("link", ""), new C6170c(PlaceFields.LOCATION, ""), new C6170c("max-forwards", ""), new C6170c("proxy-authenticate", ""), new C6170c("proxy-authorization", ""), new C6170c("range", ""), new C6170c("referer", ""), new C6170c("refresh", ""), new C6170c("retry-after", ""), new C6170c("server", ""), new C6170c("set-cookie", ""), new C6170c("strict-transport-security", ""), new C6170c("transfer-encoding", ""), new C6170c("user-agent", ""), new C6170c("vary", ""), new C6170c("via", ""), new C6170c("www-authenticate", "")};
    /* renamed from: b */
    static final Map<C6251f, Integer> f19959b = C6173d.m25356a();

    /* compiled from: Hpack */
    /* renamed from: expolib_v1.a.a.e.d$a */
    static final class C6171a {
        /* renamed from: a */
        C6170c[] f19940a;
        /* renamed from: b */
        int f19941b;
        /* renamed from: c */
        int f19942c;
        /* renamed from: d */
        int f19943d;
        /* renamed from: e */
        private final List<C6170c> f19944e;
        /* renamed from: f */
        private final C7497e f19945f;
        /* renamed from: g */
        private final int f19946g;
        /* renamed from: h */
        private int f19947h;

        C6171a(int i, C6258s c6258s) {
            this(i, i, c6258s);
        }

        C6171a(int i, int i2, C6258s c6258s) {
            this.f19944e = new ArrayList();
            this.f19940a = new C6170c[8];
            this.f19941b = this.f19940a.length - 1;
            this.f19942c = 0;
            this.f19943d = 0;
            this.f19946g = i;
            this.f19947h = i2;
            this.f19945f = C6252l.m25859a(c6258s);
        }

        /* renamed from: d */
        private void m25334d() {
            if (this.f19947h >= this.f19943d) {
                return;
            }
            if (this.f19947h == 0) {
                m25336e();
            } else {
                m25330a(this.f19943d - this.f19947h);
            }
        }

        /* renamed from: e */
        private void m25336e() {
            Arrays.fill(this.f19940a, null);
            this.f19941b = this.f19940a.length - 1;
            this.f19942c = 0;
            this.f19943d = 0;
        }

        /* renamed from: a */
        private int m25330a(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.f19940a.length - 1; length >= this.f19941b && i > 0; length--) {
                    i -= this.f19940a[length].f19939i;
                    this.f19943d -= this.f19940a[length].f19939i;
                    this.f19942c--;
                    i2++;
                }
                System.arraycopy(this.f19940a, this.f19941b + 1, this.f19940a, (this.f19941b + 1) + i2, this.f19942c);
                this.f19941b += i2;
            }
            return i2;
        }

        /* renamed from: a */
        void m25344a() {
            while (!this.f19945f.mo6382f()) {
                int i = this.f19945f.mo6388i() & JfifUtil.MARKER_FIRST_BYTE;
                if (i == 128) {
                    throw new IOException("index == 0");
                } else if ((i & 128) == 128) {
                    m25332b(m25343a(i, 127) - 1);
                } else if (i == 64) {
                    m25340g();
                } else if ((i & 64) == 64) {
                    m25337e(m25343a(i, 63) - 1);
                } else if ((i & 32) == 32) {
                    this.f19947h = m25343a(i, 31);
                    if (this.f19947h < 0 || this.f19947h > this.f19946g) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid dynamic table size update ");
                        stringBuilder.append(this.f19947h);
                        throw new IOException(stringBuilder.toString());
                    }
                    m25334d();
                } else {
                    if (i != 16) {
                        if (i != 0) {
                            m25335d(m25343a(i, 15) - 1);
                        }
                    }
                    m25339f();
                }
            }
        }

        /* renamed from: b */
        public List<C6170c> m25345b() {
            List arrayList = new ArrayList(this.f19944e);
            this.f19944e.clear();
            return arrayList;
        }

        /* renamed from: b */
        private void m25332b(int i) {
            if (m25341g(i)) {
                this.f19944e.add(C6173d.f19958a[i]);
                return;
            }
            int c = m25333c(i - C6173d.f19958a.length);
            if (c < 0 || c > this.f19940a.length - 1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Header index too large ");
                stringBuilder.append(i + 1);
                throw new IOException(stringBuilder.toString());
            }
            this.f19944e.add(this.f19940a[c]);
        }

        /* renamed from: c */
        private int m25333c(int i) {
            return (this.f19941b + 1) + i;
        }

        /* renamed from: d */
        private void m25335d(int i) {
            this.f19944e.add(new C6170c(m25338f(i), m25346c()));
        }

        /* renamed from: f */
        private void m25339f() {
            this.f19944e.add(new C6170c(C6173d.m25355a(m25346c()), m25346c()));
        }

        /* renamed from: e */
        private void m25337e(int i) {
            m25331a(-1, new C6170c(m25338f(i), m25346c()));
        }

        /* renamed from: g */
        private void m25340g() {
            m25331a(-1, new C6170c(C6173d.m25355a(m25346c()), m25346c()));
        }

        /* renamed from: f */
        private C6251f m25338f(int i) {
            if (m25341g(i)) {
                return C6173d.f19958a[i].f19937g;
            }
            return this.f19940a[m25333c(i - C6173d.f19958a.length)].f19937g;
        }

        /* renamed from: g */
        private boolean m25341g(int i) {
            return i >= 0 && i <= C6173d.f19958a.length - 1;
        }

        /* renamed from: a */
        private void m25331a(int i, C6170c c6170c) {
            this.f19944e.add(c6170c);
            int i2 = c6170c.f19939i;
            if (i != -1) {
                i2 -= this.f19940a[m25333c(i)].f19939i;
            }
            if (i2 > this.f19947h) {
                m25336e();
                return;
            }
            int a = m25330a((this.f19943d + i2) - this.f19947h);
            if (i == -1) {
                if (this.f19942c + 1 > this.f19940a.length) {
                    i = new C6170c[(this.f19940a.length * 2)];
                    System.arraycopy(this.f19940a, 0, i, this.f19940a.length, this.f19940a.length);
                    this.f19941b = this.f19940a.length - 1;
                    this.f19940a = i;
                }
                i = this.f19941b;
                this.f19941b = i - 1;
                this.f19940a[i] = c6170c;
                this.f19942c++;
            } else {
                this.f19940a[i + (m25333c(i) + a)] = c6170c;
            }
            this.f19943d += i2;
        }

        /* renamed from: h */
        private int m25342h() {
            return this.f19945f.mo6388i() & JfifUtil.MARKER_FIRST_BYTE;
        }

        /* renamed from: a */
        int m25343a(int i, int i2) {
            i &= i2;
            if (i < i2) {
                return i;
            }
            i = 0;
            while (true) {
                int h = m25342h();
                if ((h & 128) == 0) {
                    return i2 + (h << i);
                }
                i2 += (h & 127) << i;
                i += 7;
            }
        }

        /* renamed from: c */
        C6251f m25346c() {
            int h = m25342h();
            Object obj = (h & 128) == 128 ? 1 : null;
            h = m25343a(h, 127);
            if (obj != null) {
                return C6251f.m25838a(C6183k.m25451a().m25456a(this.f19945f.mo6385g((long) h)));
            }
            return this.f19945f.mo6378c((long) h);
        }
    }

    /* compiled from: Hpack */
    /* renamed from: expolib_v1.a.a.e.d$b */
    static final class C6172b {
        /* renamed from: a */
        int f19948a;
        /* renamed from: b */
        int f19949b;
        /* renamed from: c */
        C6170c[] f19950c;
        /* renamed from: d */
        int f19951d;
        /* renamed from: e */
        int f19952e;
        /* renamed from: f */
        int f19953f;
        /* renamed from: g */
        private final C8170c f19954g;
        /* renamed from: h */
        private final boolean f19955h;
        /* renamed from: i */
        private int f19956i;
        /* renamed from: j */
        private boolean f19957j;

        C6172b(C8170c c8170c) {
            this(4096, true, c8170c);
        }

        C6172b(int i, boolean z, C8170c c8170c) {
            this.f19956i = Integer.MAX_VALUE;
            this.f19950c = new C6170c[8];
            this.f19951d = this.f19950c.length - 1;
            this.f19952e = 0;
            this.f19953f = 0;
            this.f19948a = i;
            this.f19949b = i;
            this.f19955h = z;
            this.f19954g = c8170c;
        }

        /* renamed from: a */
        private void m25347a() {
            Arrays.fill(this.f19950c, null);
            this.f19951d = this.f19950c.length - 1;
            this.f19952e = 0;
            this.f19953f = 0;
        }

        /* renamed from: b */
        private int m25349b(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.f19950c.length - 1; length >= this.f19951d && i > 0; length--) {
                    i -= this.f19950c[length].f19939i;
                    this.f19953f -= this.f19950c[length].f19939i;
                    this.f19952e--;
                    i2++;
                }
                System.arraycopy(this.f19950c, this.f19951d + 1, this.f19950c, (this.f19951d + 1) + i2, this.f19952e);
                Arrays.fill(this.f19950c, this.f19951d + 1, (this.f19951d + 1) + i2, null);
                this.f19951d += i2;
            }
            return i2;
        }

        /* renamed from: a */
        private void m25348a(C6170c c6170c) {
            int i = c6170c.f19939i;
            if (i > this.f19949b) {
                m25347a();
                return;
            }
            m25349b((this.f19953f + i) - this.f19949b);
            if (this.f19952e + 1 > this.f19950c.length) {
                Object obj = new C6170c[(this.f19950c.length * 2)];
                System.arraycopy(this.f19950c, 0, obj, this.f19950c.length, this.f19950c.length);
                this.f19951d = this.f19950c.length - 1;
                this.f19950c = obj;
            }
            int i2 = this.f19951d;
            this.f19951d = i2 - 1;
            this.f19950c[i2] = c6170c;
            this.f19952e++;
            this.f19953f += i;
        }

        /* renamed from: a */
        void m25354a(List<C6170c> list) {
            if (this.f19957j) {
                if (this.f19956i < this.f19949b) {
                    m25352a(this.f19956i, 31, 32);
                }
                this.f19957j = false;
                this.f19956i = Integer.MAX_VALUE;
                m25352a(this.f19949b, 31, 32);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int intValue;
                int i2;
                C6170c c6170c = (C6170c) list.get(i);
                C6251f g = c6170c.f19937g.mo5365g();
                C6251f c6251f = c6170c.f19938h;
                Integer num = (Integer) C6173d.f19959b.get(g);
                if (num != null) {
                    intValue = num.intValue() + 1;
                    if (intValue > 1 && intValue < 8) {
                        if (C6165c.m25319a(C6173d.f19958a[intValue - 1].f19938h, (Object) c6251f)) {
                            i2 = intValue;
                        } else if (C6165c.m25319a(C6173d.f19958a[intValue].f19938h, (Object) c6251f)) {
                            i2 = intValue;
                            intValue++;
                        }
                    }
                    i2 = intValue;
                    intValue = -1;
                } else {
                    intValue = -1;
                    i2 = -1;
                }
                if (intValue == -1) {
                    int length = this.f19950c.length;
                    for (int i3 = this.f19951d + 1; i3 < length; i3++) {
                        if (C6165c.m25319a(this.f19950c[i3].f19937g, (Object) g)) {
                            if (C6165c.m25319a(this.f19950c[i3].f19938h, (Object) c6251f)) {
                                intValue = C6173d.f19958a.length + (i3 - this.f19951d);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i3 - this.f19951d) + C6173d.f19958a.length;
                            }
                        }
                    }
                }
                if (intValue != -1) {
                    m25352a(intValue, 127, 128);
                } else if (i2 == -1) {
                    this.f19954g.m39604b(64);
                    m25353a(g);
                    m25353a(c6251f);
                    m25348a(c6170c);
                } else if (!g.m25848a(C6170c.f19931a) || C6170c.f19936f.equals(g)) {
                    m25352a(i2, 63, 64);
                    m25353a(c6251f);
                    m25348a(c6170c);
                } else {
                    m25352a(i2, 15, 0);
                    m25353a(c6251f);
                }
            }
        }

        /* renamed from: a */
        void m25352a(int i, int i2, int i3) {
            if (i < i2) {
                this.f19954g.m39604b(i | i3);
                return;
            }
            this.f19954g.m39604b(i3 | i2);
            i -= i2;
            while (i >= 128) {
                this.f19954g.m39604b(128 | (i & 127));
                i >>>= 7;
            }
            this.f19954g.m39604b(i);
        }

        /* renamed from: a */
        void m25353a(C6251f c6251f) {
            if (!this.f19955h || C6183k.m25451a().m25454a(c6251f) >= c6251f.mo5366h()) {
                m25352a(c6251f.mo5366h(), 127, 0);
                this.f19954g.m39590a(c6251f);
                return;
            }
            Object c8170c = new C8170c();
            C6183k.m25451a().m25455a(c6251f, c8170c);
            c6251f = c8170c.m39646q();
            m25352a(c6251f.mo5366h(), 127, 128);
            this.f19954g.m39590a(c6251f);
        }

        /* renamed from: a */
        void m25351a(int i) {
            this.f19948a = i;
            i = Math.min(i, 16384);
            if (this.f19949b != i) {
                if (i < this.f19949b) {
                    this.f19956i = Math.min(this.f19956i, i);
                }
                this.f19957j = true;
                this.f19949b = i;
                m25350b();
            }
        }

        /* renamed from: b */
        private void m25350b() {
            if (this.f19949b >= this.f19953f) {
                return;
            }
            if (this.f19949b == 0) {
                m25347a();
            } else {
                m25349b(this.f19953f - this.f19949b);
            }
        }
    }

    /* renamed from: a */
    private static Map<C6251f, Integer> m25356a() {
        Map linkedHashMap = new LinkedHashMap(f19958a.length);
        for (int i = 0; i < f19958a.length; i++) {
            if (!linkedHashMap.containsKey(f19958a[i].f19937g)) {
                linkedHashMap.put(f19958a[i].f19937g, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* renamed from: a */
    static C6251f m25355a(C6251f c6251f) {
        int h = c6251f.mo5366h();
        for (int i = 0; i < h; i++) {
            byte a = c6251f.mo5353a(i);
            if (a >= (byte) 65) {
                if (a <= (byte) 90) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("PROTOCOL_ERROR response malformed: mixed case name: ");
                    stringBuilder.append(c6251f.mo5355a());
                    throw new IOException(stringBuilder.toString());
                }
            }
        }
        return c6251f;
    }
}
