package expolib_v1.p321a;

import expolib_v1.p321a.p322a.p325c.C6160e;
import java.util.concurrent.TimeUnit;

/* compiled from: CacheControl */
/* renamed from: expolib_v1.a.d */
public final class C6214d {
    /* renamed from: a */
    public static final C6214d f20163a = new C6213a().m25616a().m25620d();
    /* renamed from: b */
    public static final C6214d f20164b = new C6213a().m25619c().m25617a(Integer.MAX_VALUE, TimeUnit.SECONDS).m25620d();
    /* renamed from: c */
    String f20165c;
    /* renamed from: d */
    private final boolean f20166d;
    /* renamed from: e */
    private final boolean f20167e;
    /* renamed from: f */
    private final int f20168f;
    /* renamed from: g */
    private final int f20169g;
    /* renamed from: h */
    private final boolean f20170h;
    /* renamed from: i */
    private final boolean f20171i;
    /* renamed from: j */
    private final boolean f20172j;
    /* renamed from: k */
    private final int f20173k;
    /* renamed from: l */
    private final int f20174l;
    /* renamed from: m */
    private final boolean f20175m;
    /* renamed from: n */
    private final boolean f20176n;

    /* compiled from: CacheControl */
    /* renamed from: expolib_v1.a.d$a */
    public static final class C6213a {
        /* renamed from: a */
        boolean f20156a;
        /* renamed from: b */
        boolean f20157b;
        /* renamed from: c */
        int f20158c = -1;
        /* renamed from: d */
        int f20159d = -1;
        /* renamed from: e */
        int f20160e = -1;
        /* renamed from: f */
        boolean f20161f;
        /* renamed from: g */
        boolean f20162g;

        /* renamed from: a */
        public C6213a m25616a() {
            this.f20156a = true;
            return this;
        }

        /* renamed from: b */
        public C6213a m25618b() {
            this.f20157b = true;
            return this;
        }

        /* renamed from: a */
        public C6213a m25617a(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                i = timeUnit.toSeconds((long) i);
                this.f20159d = i > 2147483647L ? Integer.MAX_VALUE : (int) i;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("maxStale < 0: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        /* renamed from: c */
        public C6213a m25619c() {
            this.f20161f = true;
            return this;
        }

        /* renamed from: d */
        public C6214d m25620d() {
            return new C6214d(this);
        }
    }

    private C6214d(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.f20166d = z;
        this.f20167e = z2;
        this.f20168f = i;
        this.f20169g = i2;
        this.f20170h = z3;
        this.f20171i = z4;
        this.f20172j = z5;
        this.f20173k = i3;
        this.f20174l = i4;
        this.f20175m = z6;
        this.f20176n = z7;
        this.f20165c = str;
    }

    C6214d(C6213a c6213a) {
        this.f20166d = c6213a.f20156a;
        this.f20167e = c6213a.f20157b;
        this.f20168f = c6213a.f20158c;
        this.f20169g = -1;
        this.f20170h = false;
        this.f20171i = false;
        this.f20172j = false;
        this.f20173k = c6213a.f20159d;
        this.f20174l = c6213a.f20160e;
        this.f20175m = c6213a.f20161f;
        this.f20176n = c6213a.f20162g;
    }

    /* renamed from: a */
    public boolean m25623a() {
        return this.f20166d;
    }

    /* renamed from: b */
    public boolean m25624b() {
        return this.f20167e;
    }

    /* renamed from: c */
    public int m25625c() {
        return this.f20168f;
    }

    /* renamed from: d */
    public boolean m25626d() {
        return this.f20170h;
    }

    /* renamed from: e */
    public boolean m25627e() {
        return this.f20171i;
    }

    /* renamed from: f */
    public boolean m25628f() {
        return this.f20172j;
    }

    /* renamed from: g */
    public int m25629g() {
        return this.f20173k;
    }

    /* renamed from: h */
    public int m25630h() {
        return this.f20174l;
    }

    /* renamed from: i */
    public boolean m25631i() {
        return this.f20175m;
    }

    /* renamed from: a */
    public static C6214d m25621a(C6234q c6234q) {
        C6234q c6234q2 = c6234q;
        int a = c6234q.m25716a();
        Object obj = 1;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        int i = -1;
        int i2 = -1;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i3 = -1;
        int i4 = -1;
        boolean z6 = false;
        boolean z7 = false;
        for (int i5 = 0; i5 < a; i5++) {
            int a2;
            int a3;
            String trim;
            int a4;
            String trim2;
            String a5 = c6234q2.m25717a(i5);
            String b = c6234q2.m25720b(i5);
            if (a5.equalsIgnoreCase("Cache-Control")) {
                if (str == null) {
                    str = b;
                    int i6;
                    for (i6 = 0; i6 < b.length(); i6 = a2) {
                        a3 = C6160e.m25279a(b, i6, "=,;");
                        trim = b.substring(i6, a3).trim();
                        if (!(a3 == b.length() || b.charAt(a3) == ',')) {
                            if (b.charAt(a3) == ';') {
                                a4 = C6160e.m25278a(b, a3 + 1);
                                if (a4 < b.length() || b.charAt(a4) != '\"') {
                                    a2 = C6160e.m25279a(b, a4, ",;");
                                    trim2 = b.substring(a4, a2).trim();
                                } else {
                                    a4++;
                                    a2 = C6160e.m25279a(b, a4, "\"");
                                    trim2 = b.substring(a4, a2);
                                    a2++;
                                }
                                if (!"no-cache".equalsIgnoreCase(trim)) {
                                    z = true;
                                } else if (!"no-store".equalsIgnoreCase(trim)) {
                                    z2 = true;
                                } else if (!"max-age".equalsIgnoreCase(trim)) {
                                    i = C6160e.m25286b(trim2, -1);
                                } else if (!"s-maxage".equalsIgnoreCase(trim)) {
                                    i2 = C6160e.m25286b(trim2, -1);
                                } else if (!"private".equalsIgnoreCase(trim)) {
                                    z3 = true;
                                } else if (!"public".equalsIgnoreCase(trim)) {
                                    z4 = true;
                                } else if (!"must-revalidate".equalsIgnoreCase(trim)) {
                                    z5 = true;
                                } else if (!"max-stale".equalsIgnoreCase(trim)) {
                                    i3 = C6160e.m25286b(trim2, Integer.MAX_VALUE);
                                } else if (!"min-fresh".equalsIgnoreCase(trim)) {
                                    i4 = C6160e.m25286b(trim2, -1);
                                } else if (!"only-if-cached".equalsIgnoreCase(trim)) {
                                    z6 = true;
                                } else if (!"no-transform".equalsIgnoreCase(trim)) {
                                    z7 = true;
                                }
                            }
                        }
                        a2 = a3 + 1;
                        trim2 = null;
                        if (!"no-cache".equalsIgnoreCase(trim)) {
                            z = true;
                        } else if (!"no-store".equalsIgnoreCase(trim)) {
                            z2 = true;
                        } else if (!"max-age".equalsIgnoreCase(trim)) {
                            i = C6160e.m25286b(trim2, -1);
                        } else if (!"s-maxage".equalsIgnoreCase(trim)) {
                            i2 = C6160e.m25286b(trim2, -1);
                        } else if (!"private".equalsIgnoreCase(trim)) {
                            z3 = true;
                        } else if (!"public".equalsIgnoreCase(trim)) {
                            z4 = true;
                        } else if (!"must-revalidate".equalsIgnoreCase(trim)) {
                            z5 = true;
                        } else if (!"max-stale".equalsIgnoreCase(trim)) {
                            i3 = C6160e.m25286b(trim2, Integer.MAX_VALUE);
                        } else if (!"min-fresh".equalsIgnoreCase(trim)) {
                            i4 = C6160e.m25286b(trim2, -1);
                        } else if (!"only-if-cached".equalsIgnoreCase(trim)) {
                            z6 = true;
                        } else if (!"no-transform".equalsIgnoreCase(trim)) {
                            z7 = true;
                        }
                    }
                }
            } else if (!a5.equalsIgnoreCase("Pragma")) {
            }
            obj = null;
            while (i6 < b.length()) {
                a3 = C6160e.m25279a(b, i6, "=,;");
                trim = b.substring(i6, a3).trim();
                if (b.charAt(a3) == ';') {
                    a4 = C6160e.m25278a(b, a3 + 1);
                    if (a4 < b.length()) {
                    }
                    a2 = C6160e.m25279a(b, a4, ",;");
                    trim2 = b.substring(a4, a2).trim();
                    if (!"no-cache".equalsIgnoreCase(trim)) {
                        z = true;
                    } else if (!"no-store".equalsIgnoreCase(trim)) {
                        z2 = true;
                    } else if (!"max-age".equalsIgnoreCase(trim)) {
                        i = C6160e.m25286b(trim2, -1);
                    } else if (!"s-maxage".equalsIgnoreCase(trim)) {
                        i2 = C6160e.m25286b(trim2, -1);
                    } else if (!"private".equalsIgnoreCase(trim)) {
                        z3 = true;
                    } else if (!"public".equalsIgnoreCase(trim)) {
                        z4 = true;
                    } else if (!"must-revalidate".equalsIgnoreCase(trim)) {
                        z5 = true;
                    } else if (!"max-stale".equalsIgnoreCase(trim)) {
                        i3 = C6160e.m25286b(trim2, Integer.MAX_VALUE);
                    } else if (!"min-fresh".equalsIgnoreCase(trim)) {
                        i4 = C6160e.m25286b(trim2, -1);
                    } else if (!"only-if-cached".equalsIgnoreCase(trim)) {
                        z6 = true;
                    } else if (!"no-transform".equalsIgnoreCase(trim)) {
                        z7 = true;
                    }
                } else {
                    a2 = a3 + 1;
                    trim2 = null;
                    if (!"no-cache".equalsIgnoreCase(trim)) {
                        z = true;
                    } else if (!"no-store".equalsIgnoreCase(trim)) {
                        z2 = true;
                    } else if (!"max-age".equalsIgnoreCase(trim)) {
                        i = C6160e.m25286b(trim2, -1);
                    } else if (!"s-maxage".equalsIgnoreCase(trim)) {
                        i2 = C6160e.m25286b(trim2, -1);
                    } else if (!"private".equalsIgnoreCase(trim)) {
                        z3 = true;
                    } else if (!"public".equalsIgnoreCase(trim)) {
                        z4 = true;
                    } else if (!"must-revalidate".equalsIgnoreCase(trim)) {
                        z5 = true;
                    } else if (!"max-stale".equalsIgnoreCase(trim)) {
                        i3 = C6160e.m25286b(trim2, Integer.MAX_VALUE);
                    } else if (!"min-fresh".equalsIgnoreCase(trim)) {
                        i4 = C6160e.m25286b(trim2, -1);
                    } else if (!"only-if-cached".equalsIgnoreCase(trim)) {
                        z6 = true;
                    } else if (!"no-transform".equalsIgnoreCase(trim)) {
                        z7 = true;
                    }
                }
            }
        }
        return new C6214d(z, z2, i, i2, z3, z4, z5, i3, i4, z6, z7, obj == null ? null : str);
    }

    public String toString() {
        String str = this.f20165c;
        if (str != null) {
            return str;
        }
        str = m25622j();
        this.f20165c = str;
        return str;
    }

    /* renamed from: j */
    private String m25622j() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.f20166d) {
            stringBuilder.append("no-cache, ");
        }
        if (this.f20167e) {
            stringBuilder.append("no-store, ");
        }
        if (this.f20168f != -1) {
            stringBuilder.append("max-age=");
            stringBuilder.append(this.f20168f);
            stringBuilder.append(", ");
        }
        if (this.f20169g != -1) {
            stringBuilder.append("s-maxage=");
            stringBuilder.append(this.f20169g);
            stringBuilder.append(", ");
        }
        if (this.f20170h) {
            stringBuilder.append("private, ");
        }
        if (this.f20171i) {
            stringBuilder.append("public, ");
        }
        if (this.f20172j) {
            stringBuilder.append("must-revalidate, ");
        }
        if (this.f20173k != -1) {
            stringBuilder.append("max-stale=");
            stringBuilder.append(this.f20173k);
            stringBuilder.append(", ");
        }
        if (this.f20174l != -1) {
            stringBuilder.append("min-fresh=");
            stringBuilder.append(this.f20174l);
            stringBuilder.append(", ");
        }
        if (this.f20175m) {
            stringBuilder.append("only-if-cached, ");
        }
        if (this.f20176n) {
            stringBuilder.append("no-transform, ");
        }
        if (stringBuilder.length() == 0) {
            return "";
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.toString();
    }
}
