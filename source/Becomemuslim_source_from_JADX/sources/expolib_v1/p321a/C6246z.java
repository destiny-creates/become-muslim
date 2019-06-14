package expolib_v1.p321a;

import expolib_v1.p321a.C6234q.C6233a;
import expolib_v1.p321a.p322a.p325c.C6161f;
import java.net.URL;
import java.util.List;

/* compiled from: Request */
/* renamed from: expolib_v1.a.z */
public final class C6246z {
    /* renamed from: a */
    final C6237r f20367a;
    /* renamed from: b */
    final String f20368b;
    /* renamed from: c */
    final C6234q f20369c;
    /* renamed from: d */
    final aa f20370d;
    /* renamed from: e */
    final Object f20371e;
    /* renamed from: f */
    private volatile C6214d f20372f;

    /* compiled from: Request */
    /* renamed from: expolib_v1.a.z$a */
    public static class C6245a {
        /* renamed from: a */
        C6237r f20362a;
        /* renamed from: b */
        String f20363b;
        /* renamed from: c */
        C6233a f20364c;
        /* renamed from: d */
        aa f20365d;
        /* renamed from: e */
        Object f20366e;

        public C6245a() {
            this.f20363b = "GET";
            this.f20364c = new C6233a();
        }

        C6245a(C6246z c6246z) {
            this.f20362a = c6246z.f20367a;
            this.f20363b = c6246z.f20368b;
            this.f20365d = c6246z.f20370d;
            this.f20366e = c6246z.f20371e;
            this.f20364c = c6246z.f20369c.m25719b();
        }

        /* renamed from: a */
        public C6245a m25812a(C6237r c6237r) {
            if (c6237r != null) {
                this.f20362a = c6237r;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: a */
        public C6245a m25814a(String str) {
            if (str != null) {
                StringBuilder stringBuilder;
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("http:");
                    stringBuilder.append(str.substring(3));
                    str = stringBuilder.toString();
                } else {
                    if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("https:");
                        stringBuilder.append(str.substring(4));
                        str = stringBuilder.toString();
                    }
                }
                C6237r e = C6237r.m25761e(str);
                if (e != null) {
                    return m25812a(e);
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("unexpected url: ");
                stringBuilder2.append(str);
                throw new IllegalArgumentException(stringBuilder2.toString());
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: a */
        public C6245a m25817a(URL url) {
            if (url != null) {
                C6237r a = C6237r.m25749a(url);
                if (a != null) {
                    return m25812a(a);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unexpected url: ");
                stringBuilder.append(url);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: a */
        public C6245a m25816a(String str, String str2) {
            this.f20364c.m25712c(str, str2);
            return this;
        }

        /* renamed from: b */
        public C6245a m25819b(String str, String str2) {
            this.f20364c.m25708a(str, str2);
            return this;
        }

        /* renamed from: b */
        public C6245a m25818b(String str) {
            this.f20364c.m25710b(str);
            return this;
        }

        /* renamed from: a */
        public C6245a m25811a(C6234q c6234q) {
            this.f20364c = c6234q.m25719b();
            return this;
        }

        /* renamed from: a */
        public C6245a m25810a(C6214d c6214d) {
            String c6214d2 = c6214d.toString();
            if (c6214d2.isEmpty()) {
                return m25818b("Cache-Control");
            }
            return m25816a("Cache-Control", c6214d2);
        }

        /* renamed from: a */
        public C6245a m25808a() {
            return m25815a("GET", null);
        }

        /* renamed from: a */
        public C6245a m25809a(aa aaVar) {
            return m25815a("POST", aaVar);
        }

        /* renamed from: a */
        public C6245a m25815a(String str, aa aaVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() != 0) {
                StringBuilder stringBuilder;
                if (aaVar != null) {
                    if (!C6161f.m25295c(str)) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("method ");
                        stringBuilder.append(str);
                        stringBuilder.append(" must not have a request body.");
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                if (aaVar == null) {
                    if (C6161f.m25294b(str)) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("method ");
                        stringBuilder.append(str);
                        stringBuilder.append(" must have a request body.");
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                this.f20363b = str;
                this.f20365d = aaVar;
                return this;
            } else {
                throw new IllegalArgumentException("method.length() == 0");
            }
        }

        /* renamed from: a */
        public C6245a m25813a(Object obj) {
            this.f20366e = obj;
            return this;
        }

        /* renamed from: b */
        public C6246z m25820b() {
            if (this.f20362a != null) {
                return new C6246z(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    C6246z(C6245a c6245a) {
        this.f20367a = c6245a.f20362a;
        this.f20368b = c6245a.f20363b;
        this.f20369c = c6245a.f20364c.m25709a();
        this.f20370d = c6245a.f20365d;
        this.f20371e = c6245a.f20366e != null ? c6245a.f20366e : this;
    }

    /* renamed from: a */
    public C6237r m25821a() {
        return this.f20367a;
    }

    /* renamed from: b */
    public String m25823b() {
        return this.f20368b;
    }

    /* renamed from: c */
    public C6234q m25825c() {
        return this.f20369c;
    }

    /* renamed from: a */
    public String m25822a(String str) {
        return this.f20369c.m25718a(str);
    }

    /* renamed from: b */
    public List<String> m25824b(String str) {
        return this.f20369c.m25721b(str);
    }

    /* renamed from: d */
    public aa m25826d() {
        return this.f20370d;
    }

    /* renamed from: e */
    public Object m25827e() {
        return this.f20371e;
    }

    /* renamed from: f */
    public C6245a m25828f() {
        return new C6245a(this);
    }

    /* renamed from: g */
    public C6214d m25829g() {
        C6214d c6214d = this.f20372f;
        if (c6214d != null) {
            return c6214d;
        }
        c6214d = C6214d.m25621a(this.f20369c);
        this.f20372f = c6214d;
        return c6214d;
    }

    /* renamed from: h */
    public boolean m25830h() {
        return this.f20367a.m25765c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request{method=");
        stringBuilder.append(this.f20368b);
        stringBuilder.append(", url=");
        stringBuilder.append(this.f20367a);
        stringBuilder.append(", tag=");
        stringBuilder.append(this.f20371e != this ? this.f20371e : null);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
