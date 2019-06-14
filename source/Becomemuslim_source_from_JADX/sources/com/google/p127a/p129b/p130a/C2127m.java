package com.google.p127a.p129b.p130a;

import com.google.a.b.a.m.AnonymousClass15;
import com.google.a.b.a.m.AnonymousClass26;
import com.google.p127a.C2157f;
import com.google.p127a.C2162l;
import com.google.p127a.C2168w;
import com.google.p127a.C2169x;
import com.google.p127a.C4049i;
import com.google.p127a.C4050m;
import com.google.p127a.C4051n;
import com.google.p127a.C4052o;
import com.google.p127a.C4053q;
import com.google.p127a.C4054t;
import com.google.p127a.p129b.C2135f;
import com.google.p127a.p129b.p130a.C2127m.C4023a;
import com.google.p127a.p131c.C2150a;
import com.google.p127a.p132d.C2152a;
import com.google.p127a.p132d.C2153b;
import com.google.p127a.p132d.C2154c;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.UUID;

/* compiled from: TypeAdapters */
/* renamed from: com.google.a.b.a.m */
public final class C2127m {
    /* renamed from: A */
    public static final C2168w<StringBuffer> f5051A = new C40229();
    /* renamed from: B */
    public static final C2169x f5052B = C2127m.m5830a(StringBuffer.class, f5051A);
    /* renamed from: C */
    public static final C2168w<URL> f5053C = new C2168w<URL>() {
        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12301a(c2152a);
        }

        /* renamed from: a */
        public URL m12301a(C2152a c2152a) {
            URL url = null;
            if (c2152a.mo1999f() == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            }
            c2152a = c2152a.mo2001h();
            if (!"null".equals(c2152a)) {
                url = new URL(c2152a);
            }
            return url;
        }

        /* renamed from: a */
        public void m12303a(C2154c c2154c, URL url) {
            c2154c.mo2016b(url == null ? null : url.toExternalForm());
        }
    };
    /* renamed from: D */
    public static final C2169x f5054D = C2127m.m5830a(URL.class, f5053C);
    /* renamed from: E */
    public static final C2168w<URI> f5055E = new C2168w<URI>() {
        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12305a(c2152a);
        }

        /* renamed from: a */
        public URI m12305a(C2152a c2152a) {
            URI uri = null;
            if (c2152a.mo1999f() == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            }
            try {
                c2152a = c2152a.mo2001h();
                if (!"null".equals(c2152a)) {
                    uri = new URI(c2152a);
                }
                return uri;
            } catch (Throwable e) {
                throw new C4050m(e);
            }
        }

        /* renamed from: a */
        public void m12307a(C2154c c2154c, URI uri) {
            c2154c.mo2016b(uri == null ? null : uri.toASCIIString());
        }
    };
    /* renamed from: F */
    public static final C2169x f5056F = C2127m.m5830a(URI.class, f5055E);
    /* renamed from: G */
    public static final C2168w<InetAddress> f5057G = new C2168w<InetAddress>() {
        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12313a(c2152a);
        }

        /* renamed from: a */
        public InetAddress m12313a(C2152a c2152a) {
            if (c2152a.mo1999f() != C2153b.NULL) {
                return InetAddress.getByName(c2152a.mo2001h());
            }
            c2152a.mo2003j();
            return null;
        }

        /* renamed from: a */
        public void m12315a(C2154c c2154c, InetAddress inetAddress) {
            c2154c.mo2016b(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    /* renamed from: H */
    public static final C2169x f5058H = C2127m.m5832b(InetAddress.class, f5057G);
    /* renamed from: I */
    public static final C2168w<UUID> f5059I = new C2168w<UUID>() {
        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12317a(c2152a);
        }

        /* renamed from: a */
        public UUID m12317a(C2152a c2152a) {
            if (c2152a.mo1999f() != C2153b.NULL) {
                return UUID.fromString(c2152a.mo2001h());
            }
            c2152a.mo2003j();
            return null;
        }

        /* renamed from: a */
        public void m12319a(C2154c c2154c, UUID uuid) {
            c2154c.mo2016b(uuid == null ? null : uuid.toString());
        }
    };
    /* renamed from: J */
    public static final C2169x f5060J = C2127m.m5830a(UUID.class, f5059I);
    /* renamed from: K */
    public static final C2169x f5061K = new C2169x() {
        /* renamed from: a */
        public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
            if (c2150a.m5891a() != Timestamp.class) {
                return null;
            }
            c2157f = c2157f.m5972a(Date.class);
            return new C2168w<Timestamp>(this) {
                /* renamed from: b */
                final /* synthetic */ AnonymousClass15 f10054b;

                /* renamed from: b */
                public /* synthetic */ Object mo1992b(C2152a c2152a) {
                    return m12321a(c2152a);
                }

                /* renamed from: a */
                public Timestamp m12321a(C2152a c2152a) {
                    Date date = (Date) c2157f.mo1992b(c2152a);
                    return date != null ? new Timestamp(date.getTime()) : null;
                }

                /* renamed from: a */
                public void m12323a(C2154c c2154c, Timestamp timestamp) {
                    c2157f.mo1991a(c2154c, timestamp);
                }
            };
        }
    };
    /* renamed from: L */
    public static final C2168w<Calendar> f5062L = new C2168w<Calendar>() {
        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12326a(c2152a);
        }

        /* renamed from: a */
        public Calendar m12326a(C2152a c2152a) {
            if (c2152a.mo1999f() == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            }
            c2152a.mo1995c();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (c2152a.mo1999f() != C2153b.END_OBJECT) {
                String g = c2152a.mo2000g();
                int m = c2152a.mo2006m();
                if ("year".equals(g)) {
                    i = m;
                } else if ("month".equals(g)) {
                    i2 = m;
                } else if ("dayOfMonth".equals(g)) {
                    i3 = m;
                } else if ("hourOfDay".equals(g)) {
                    i4 = m;
                } else if ("minute".equals(g)) {
                    i5 = m;
                } else if ("second".equals(g)) {
                    i6 = m;
                }
            }
            c2152a.mo1997d();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }

        /* renamed from: a */
        public void m12328a(C2154c c2154c, Calendar calendar) {
            if (calendar == null) {
                c2154c.mo2021f();
                return;
            }
            c2154c.mo2019d();
            c2154c.mo2012a("year");
            c2154c.mo2010a((long) calendar.get(1));
            c2154c.mo2012a("month");
            c2154c.mo2010a((long) calendar.get(2));
            c2154c.mo2012a("dayOfMonth");
            c2154c.mo2010a((long) calendar.get(5));
            c2154c.mo2012a("hourOfDay");
            c2154c.mo2010a((long) calendar.get(11));
            c2154c.mo2012a("minute");
            c2154c.mo2010a((long) calendar.get(12));
            c2154c.mo2012a("second");
            c2154c.mo2010a((long) calendar.get(13));
            c2154c.mo2020e();
        }
    };
    /* renamed from: M */
    public static final C2169x f5063M = C2127m.m5833b(Calendar.class, GregorianCalendar.class, f5062L);
    /* renamed from: N */
    public static final C2168w<Locale> f5064N = new C2168w<Locale>() {
        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12330a(c2152a);
        }

        /* renamed from: a */
        public Locale m12330a(C2152a c2152a) {
            String str = null;
            if (c2152a.mo1999f() == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(c2152a.mo2001h(), "_");
            c2152a = stringTokenizer.hasMoreElements() != null ? stringTokenizer.nextToken() : null;
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (stringTokenizer.hasMoreElements()) {
                str = stringTokenizer.nextToken();
            }
            if (nextToken == null && str == null) {
                return new Locale(c2152a);
            }
            if (str == null) {
                return new Locale(c2152a, nextToken);
            }
            return new Locale(c2152a, nextToken, str);
        }

        /* renamed from: a */
        public void m12332a(C2154c c2154c, Locale locale) {
            c2154c.mo2016b(locale == null ? null : locale.toString());
        }
    };
    /* renamed from: O */
    public static final C2169x f5065O = C2127m.m5830a(Locale.class, f5064N);
    /* renamed from: P */
    public static final C2168w<C2162l> f5066P = new C2168w<C2162l>() {
        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12334a(c2152a);
        }

        /* renamed from: a */
        public C2162l m12334a(C2152a c2152a) {
            C2162l c4049i;
            switch (c2152a.mo1999f()) {
                case NUMBER:
                    return new C4053q(new C2135f(c2152a.mo2001h()));
                case BOOLEAN:
                    return new C4053q(Boolean.valueOf(c2152a.mo2002i()));
                case STRING:
                    return new C4053q(c2152a.mo2001h());
                case NULL:
                    c2152a.mo2003j();
                    return C4051n.f10123a;
                case BEGIN_ARRAY:
                    c4049i = new C4049i();
                    c2152a.mo1993a();
                    while (c2152a.mo1998e()) {
                        c4049i.m12466a(m12334a(c2152a));
                    }
                    c2152a.mo1994b();
                    return c4049i;
                case BEGIN_OBJECT:
                    c4049i = new C4052o();
                    c2152a.mo1995c();
                    while (c2152a.mo1998e()) {
                        c4049i.m12473a(c2152a.mo2000g(), m12334a(c2152a));
                    }
                    c2152a.mo1997d();
                    return c4049i;
                default:
                    throw new IllegalArgumentException();
            }
        }

        /* renamed from: a */
        public void m12335a(C2154c c2154c, C2162l c2162l) {
            if (c2162l != null) {
                if (!c2162l.m6001j()) {
                    if (c2162l.m6000i()) {
                        c2162l = c2162l.m6004m();
                        if (c2162l.m12486p()) {
                            c2154c.mo2011a(c2162l.mo2031a());
                            return;
                        } else if (c2162l.m12485o()) {
                            c2154c.mo2013a(c2162l.mo2036f());
                            return;
                        } else {
                            c2154c.mo2016b(c2162l.mo2032b());
                            return;
                        }
                    } else if (c2162l.m5998g()) {
                        c2154c.mo2015b();
                        c2162l = c2162l.m6003l().iterator();
                        while (c2162l.hasNext()) {
                            m12335a(c2154c, (C2162l) c2162l.next());
                        }
                        c2154c.mo2017c();
                        return;
                    } else if (c2162l.m5999h()) {
                        c2154c.mo2019d();
                        for (Entry entry : c2162l.m6002k().m12474o()) {
                            c2154c.mo2012a((String) entry.getKey());
                            m12335a(c2154c, (C2162l) entry.getValue());
                        }
                        c2154c.mo2020e();
                        return;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Couldn't write ");
                        stringBuilder.append(c2162l.getClass());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
            }
            c2154c.mo2021f();
        }
    };
    /* renamed from: Q */
    public static final C2169x f5067Q = C2127m.m5832b(C2162l.class, f5066P);
    /* renamed from: R */
    public static final C2169x f5068R = new C2169x() {
        /* renamed from: a */
        public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
            c2157f = c2150a.m5891a();
            if (Enum.class.isAssignableFrom(c2157f) != null) {
                if (c2157f != Enum.class) {
                    if (c2157f.isEnum() == null) {
                        c2157f = c2157f.getSuperclass();
                    }
                    return new C4023a(c2157f);
                }
            }
            return null;
        }
    };
    /* renamed from: a */
    public static final C2168w<Class> f5069a = new C40141();
    /* renamed from: b */
    public static final C2169x f5070b = C2127m.m5830a(Class.class, f5069a);
    /* renamed from: c */
    public static final C2168w<BitSet> f5071c = new C2168w<BitSet>() {
        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12309a(c2152a);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public java.util.BitSet m12309a(com.google.p127a.p132d.C2152a r7) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r6 = this;
            r0 = r7.mo1999f();
            r1 = com.google.p127a.p132d.C2153b.NULL;
            if (r0 != r1) goto L_0x000d;
        L_0x0008:
            r7.mo2003j();
            r7 = 0;
            return r7;
        L_0x000d:
            r0 = new java.util.BitSet;
            r0.<init>();
            r7.mo1993a();
            r1 = r7.mo1999f();
            r2 = 0;
            r3 = 0;
        L_0x001b:
            r4 = com.google.p127a.p132d.C2153b.END_ARRAY;
            if (r1 == r4) goto L_0x007d;
        L_0x001f:
            r4 = com.google.a.b.a.m.AnonymousClass26.f5050a;
            r5 = r1.ordinal();
            r4 = r4[r5];
            r5 = 1;
            switch(r4) {
                case 1: goto L_0x006b;
                case 2: goto L_0x0066;
                case 3: goto L_0x0042;
                default: goto L_0x002b;
            };
        L_0x002b:
            r7 = new com.google.a.t;
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r2 = "Invalid bitset value type: ";
            r0.append(r2);
            r0.append(r1);
            r0 = r0.toString();
            r7.<init>(r0);
            throw r7;
        L_0x0042:
            r1 = r7.mo2001h();
            r4 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x004f }
            if (r4 == 0) goto L_0x004d;
        L_0x004c:
            goto L_0x0071;
        L_0x004d:
            r5 = 0;
            goto L_0x0071;
        L_0x004f:
            r7 = new com.google.a.t;
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r2 = "Error: Expecting: bitset number value (1, 0), Found: ";
            r0.append(r2);
            r0.append(r1);
            r0 = r0.toString();
            r7.<init>(r0);
            throw r7;
        L_0x0066:
            r5 = r7.mo2002i();
            goto L_0x0071;
        L_0x006b:
            r1 = r7.mo2006m();
            if (r1 == 0) goto L_0x004d;
        L_0x0071:
            if (r5 == 0) goto L_0x0076;
        L_0x0073:
            r0.set(r3);
        L_0x0076:
            r3 = r3 + 1;
            r1 = r7.mo1999f();
            goto L_0x001b;
        L_0x007d:
            r7.mo1994b();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.a.m.12.a(com.google.a.d.a):java.util.BitSet");
        }

        /* renamed from: a */
        public void m12311a(C2154c c2154c, BitSet bitSet) {
            if (bitSet == null) {
                c2154c.mo2021f();
                return;
            }
            c2154c.mo2015b();
            for (int i = 0; i < bitSet.length(); i++) {
                c2154c.mo2010a((long) bitSet.get(i));
            }
            c2154c.mo2017c();
        }
    };
    /* renamed from: d */
    public static final C2169x f5072d = C2127m.m5830a(BitSet.class, f5071c);
    /* renamed from: e */
    public static final C2168w<Boolean> f5073e = new C2168w<Boolean>() {
        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12346a(c2152a);
        }

        /* renamed from: a */
        public Boolean m12346a(C2152a c2152a) {
            if (c2152a.mo1999f() == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            } else if (c2152a.mo1999f() == C2153b.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(c2152a.mo2001h()));
            } else {
                return Boolean.valueOf(c2152a.mo2002i());
            }
        }

        /* renamed from: a */
        public void m12347a(C2154c c2154c, Boolean bool) {
            if (bool == null) {
                c2154c.mo2021f();
            } else {
                c2154c.mo2013a(bool.booleanValue());
            }
        }
    };
    /* renamed from: f */
    public static final C2168w<Boolean> f5074f = new C2168w<Boolean>() {
        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12352a(c2152a);
        }

        /* renamed from: a */
        public Boolean m12352a(C2152a c2152a) {
            if (c2152a.mo1999f() != C2153b.NULL) {
                return Boolean.valueOf(c2152a.mo2001h());
            }
            c2152a.mo2003j();
            return null;
        }

        /* renamed from: a */
        public void m12353a(C2154c c2154c, Boolean bool) {
            c2154c.mo2016b(bool == null ? "null" : bool.toString());
        }
    };
    /* renamed from: g */
    public static final C2169x f5075g = C2127m.m5831a(Boolean.TYPE, Boolean.class, f5073e);
    /* renamed from: h */
    public static final C2168w<Number> f5076h = new C2168w<Number>() {
        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12356a(c2152a);
        }

        /* renamed from: a */
        public Number m12356a(C2152a c2152a) {
            if (c2152a.mo1999f() == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            }
            try {
                return Byte.valueOf((byte) c2152a.mo2006m());
            } catch (Throwable e) {
                throw new C4054t(e);
            }
        }

        /* renamed from: a */
        public void m12357a(C2154c c2154c, Number number) {
            c2154c.mo2011a(number);
        }
    };
    /* renamed from: i */
    public static final C2169x f5077i = C2127m.m5831a(Byte.TYPE, Byte.class, f5076h);
    /* renamed from: j */
    public static final C2168w<Number> f5078j = new C2168w<Number>() {
        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12360a(c2152a);
        }

        /* renamed from: a */
        public Number m12360a(C2152a c2152a) {
            if (c2152a.mo1999f() == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            }
            try {
                return Short.valueOf((short) c2152a.mo2006m());
            } catch (Throwable e) {
                throw new C4054t(e);
            }
        }

        /* renamed from: a */
        public void m12361a(C2154c c2154c, Number number) {
            c2154c.mo2011a(number);
        }
    };
    /* renamed from: k */
    public static final C2169x f5079k = C2127m.m5831a(Short.TYPE, Short.class, f5078j);
    /* renamed from: l */
    public static final C2168w<Number> f5080l = new C2168w<Number>() {
        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12368a(c2152a);
        }

        /* renamed from: a */
        public Number m12368a(C2152a c2152a) {
            if (c2152a.mo1999f() == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            }
            try {
                return Integer.valueOf(c2152a.mo2006m());
            } catch (Throwable e) {
                throw new C4054t(e);
            }
        }

        /* renamed from: a */
        public void m12369a(C2154c c2154c, Number number) {
            c2154c.mo2011a(number);
        }
    };
    /* renamed from: m */
    public static final C2169x f5081m = C2127m.m5831a(Integer.TYPE, Integer.class, f5080l);
    /* renamed from: n */
    public static final C2168w<Number> f5082n = new C2168w<Number>() {
        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12372a(c2152a);
        }

        /* renamed from: a */
        public Number m12372a(C2152a c2152a) {
            if (c2152a.mo1999f() == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            }
            try {
                return Long.valueOf(c2152a.mo2005l());
            } catch (Throwable e) {
                throw new C4054t(e);
            }
        }

        /* renamed from: a */
        public void m12373a(C2154c c2154c, Number number) {
            c2154c.mo2011a(number);
        }
    };
    /* renamed from: o */
    public static final C2168w<Number> f5083o = new C2168w<Number>() {
        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12376a(c2152a);
        }

        /* renamed from: a */
        public Number m12376a(C2152a c2152a) {
            if (c2152a.mo1999f() != C2153b.NULL) {
                return Float.valueOf((float) c2152a.mo2004k());
            }
            c2152a.mo2003j();
            return null;
        }

        /* renamed from: a */
        public void m12377a(C2154c c2154c, Number number) {
            c2154c.mo2011a(number);
        }
    };
    /* renamed from: p */
    public static final C2168w<Number> f5084p = new C40152();
    /* renamed from: q */
    public static final C2168w<Number> f5085q = new C40163();
    /* renamed from: r */
    public static final C2169x f5086r = C2127m.m5830a(Number.class, f5085q);
    /* renamed from: s */
    public static final C2168w<Character> f5087s = new C40174();
    /* renamed from: t */
    public static final C2169x f5088t = C2127m.m5831a(Character.TYPE, Character.class, f5087s);
    /* renamed from: u */
    public static final C2168w<String> f5089u = new C40185();
    /* renamed from: v */
    public static final C2168w<BigDecimal> f5090v = new C40196();
    /* renamed from: w */
    public static final C2168w<BigInteger> f5091w = new C40207();
    /* renamed from: x */
    public static final C2169x f5092x = C2127m.m5830a(String.class, f5089u);
    /* renamed from: y */
    public static final C2168w<StringBuilder> f5093y = new C40218();
    /* renamed from: z */
    public static final C2169x f5094z = C2127m.m5830a(StringBuilder.class, f5093y);

    /* compiled from: TypeAdapters */
    /* renamed from: com.google.a.b.a.m$1 */
    static class C40141 extends C2168w<Class> {
        C40141() {
        }

        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12339a(c2152a);
        }

        /* renamed from: a */
        public void m12340a(C2154c c2154c, Class cls) {
            if (cls == null) {
                c2154c.mo2021f();
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Attempted to serialize java.lang.Class: ");
            stringBuilder.append(cls.getName());
            stringBuilder.append(". Forgot to register a type adapter?");
            throw new UnsupportedOperationException(stringBuilder.toString());
        }

        /* renamed from: a */
        public Class m12339a(C2152a c2152a) {
            if (c2152a.mo1999f() == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    /* compiled from: TypeAdapters */
    /* renamed from: com.google.a.b.a.m$2 */
    static class C40152 extends C2168w<Number> {
        C40152() {
        }

        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12364a(c2152a);
        }

        /* renamed from: a */
        public Number m12364a(C2152a c2152a) {
            if (c2152a.mo1999f() != C2153b.NULL) {
                return Double.valueOf(c2152a.mo2004k());
            }
            c2152a.mo2003j();
            return null;
        }

        /* renamed from: a */
        public void m12365a(C2154c c2154c, Number number) {
            c2154c.mo2011a(number);
        }
    }

    /* compiled from: TypeAdapters */
    /* renamed from: com.google.a.b.a.m$3 */
    static class C40163 extends C2168w<Number> {
        C40163() {
        }

        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12380a(c2152a);
        }

        /* renamed from: a */
        public Number m12380a(C2152a c2152a) {
            C2153b f = c2152a.mo1999f();
            int i = AnonymousClass26.f5050a[f.ordinal()];
            if (i == 1) {
                return new C2135f(c2152a.mo2001h());
            }
            if (i == 4) {
                c2152a.mo2003j();
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expecting number, got: ");
            stringBuilder.append(f);
            throw new C4054t(stringBuilder.toString());
        }

        /* renamed from: a */
        public void m12381a(C2154c c2154c, Number number) {
            c2154c.mo2011a(number);
        }
    }

    /* compiled from: TypeAdapters */
    /* renamed from: com.google.a.b.a.m$4 */
    static class C40174 extends C2168w<Character> {
        C40174() {
        }

        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12384a(c2152a);
        }

        /* renamed from: a */
        public Character m12384a(C2152a c2152a) {
            if (c2152a.mo1999f() == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            }
            c2152a = c2152a.mo2001h();
            if (c2152a.length() == 1) {
                return Character.valueOf(c2152a.charAt(0));
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expecting character, got: ");
            stringBuilder.append(c2152a);
            throw new C4054t(stringBuilder.toString());
        }

        /* renamed from: a */
        public void m12385a(C2154c c2154c, Character ch) {
            c2154c.mo2016b(ch == null ? null : String.valueOf(ch));
        }
    }

    /* compiled from: TypeAdapters */
    /* renamed from: com.google.a.b.a.m$5 */
    static class C40185 extends C2168w<String> {
        C40185() {
        }

        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12388a(c2152a);
        }

        /* renamed from: a */
        public String m12388a(C2152a c2152a) {
            C2153b f = c2152a.mo1999f();
            if (f == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            } else if (f == C2153b.BOOLEAN) {
                return Boolean.toString(c2152a.mo2002i());
            } else {
                return c2152a.mo2001h();
            }
        }

        /* renamed from: a */
        public void m12390a(C2154c c2154c, String str) {
            c2154c.mo2016b(str);
        }
    }

    /* compiled from: TypeAdapters */
    /* renamed from: com.google.a.b.a.m$6 */
    static class C40196 extends C2168w<BigDecimal> {
        C40196() {
        }

        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12392a(c2152a);
        }

        /* renamed from: a */
        public BigDecimal m12392a(C2152a c2152a) {
            if (c2152a.mo1999f() == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            }
            try {
                return new BigDecimal(c2152a.mo2001h());
            } catch (Throwable e) {
                throw new C4054t(e);
            }
        }

        /* renamed from: a */
        public void m12394a(C2154c c2154c, BigDecimal bigDecimal) {
            c2154c.mo2011a((Number) bigDecimal);
        }
    }

    /* compiled from: TypeAdapters */
    /* renamed from: com.google.a.b.a.m$7 */
    static class C40207 extends C2168w<BigInteger> {
        C40207() {
        }

        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12396a(c2152a);
        }

        /* renamed from: a */
        public BigInteger m12396a(C2152a c2152a) {
            if (c2152a.mo1999f() == C2153b.NULL) {
                c2152a.mo2003j();
                return null;
            }
            try {
                return new BigInteger(c2152a.mo2001h());
            } catch (Throwable e) {
                throw new C4054t(e);
            }
        }

        /* renamed from: a */
        public void m12398a(C2154c c2154c, BigInteger bigInteger) {
            c2154c.mo2011a((Number) bigInteger);
        }
    }

    /* compiled from: TypeAdapters */
    /* renamed from: com.google.a.b.a.m$8 */
    static class C40218 extends C2168w<StringBuilder> {
        C40218() {
        }

        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12400a(c2152a);
        }

        /* renamed from: a */
        public StringBuilder m12400a(C2152a c2152a) {
            if (c2152a.mo1999f() != C2153b.NULL) {
                return new StringBuilder(c2152a.mo2001h());
            }
            c2152a.mo2003j();
            return null;
        }

        /* renamed from: a */
        public void m12402a(C2154c c2154c, StringBuilder stringBuilder) {
            c2154c.mo2016b(stringBuilder == null ? null : stringBuilder.toString());
        }
    }

    /* compiled from: TypeAdapters */
    /* renamed from: com.google.a.b.a.m$9 */
    static class C40229 extends C2168w<StringBuffer> {
        C40229() {
        }

        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12404a(c2152a);
        }

        /* renamed from: a */
        public StringBuffer m12404a(C2152a c2152a) {
            if (c2152a.mo1999f() != C2153b.NULL) {
                return new StringBuffer(c2152a.mo2001h());
            }
            c2152a.mo2003j();
            return null;
        }

        /* renamed from: a */
        public void m12406a(C2154c c2154c, StringBuffer stringBuffer) {
            c2154c.mo2016b(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* compiled from: TypeAdapters */
    /* renamed from: com.google.a.b.a.m$a */
    private static final class C4023a<T extends Enum<T>> extends C2168w<T> {
        /* renamed from: a */
        private final Map<String, T> f10067a = new HashMap();
        /* renamed from: b */
        private final Map<T, String> f10068b = new HashMap();

        /* renamed from: b */
        public /* synthetic */ Object mo1992b(C2152a c2152a) {
            return m12408a(c2152a);
        }

        public C4023a(java.lang.Class<T> r8) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r7 = this;
            r7.<init>();
            r0 = new java.util.HashMap;
            r0.<init>();
            r7.f10067a = r0;
            r0 = new java.util.HashMap;
            r0.<init>();
            r7.f10068b = r0;
            r0 = r8.getEnumConstants();	 Catch:{ NoSuchFieldException -> 0x0041 }
            r0 = (java.lang.Enum[]) r0;	 Catch:{ NoSuchFieldException -> 0x0041 }
            r1 = r0.length;	 Catch:{ NoSuchFieldException -> 0x0041 }
            r2 = 0;	 Catch:{ NoSuchFieldException -> 0x0041 }
        L_0x0019:
            if (r2 >= r1) goto L_0x0040;	 Catch:{ NoSuchFieldException -> 0x0041 }
        L_0x001b:
            r3 = r0[r2];	 Catch:{ NoSuchFieldException -> 0x0041 }
            r4 = r3.name();	 Catch:{ NoSuchFieldException -> 0x0041 }
            r5 = r8.getField(r4);	 Catch:{ NoSuchFieldException -> 0x0041 }
            r6 = com.google.p127a.p128a.C2120c.class;	 Catch:{ NoSuchFieldException -> 0x0041 }
            r5 = r5.getAnnotation(r6);	 Catch:{ NoSuchFieldException -> 0x0041 }
            r5 = (com.google.p127a.p128a.C2120c) r5;	 Catch:{ NoSuchFieldException -> 0x0041 }
            if (r5 == 0) goto L_0x0033;	 Catch:{ NoSuchFieldException -> 0x0041 }
        L_0x002f:
            r4 = r5.m5823a();	 Catch:{ NoSuchFieldException -> 0x0041 }
        L_0x0033:
            r5 = r7.f10067a;	 Catch:{ NoSuchFieldException -> 0x0041 }
            r5.put(r4, r3);	 Catch:{ NoSuchFieldException -> 0x0041 }
            r5 = r7.f10068b;	 Catch:{ NoSuchFieldException -> 0x0041 }
            r5.put(r3, r4);	 Catch:{ NoSuchFieldException -> 0x0041 }
            r2 = r2 + 1;
            goto L_0x0019;
        L_0x0040:
            return;
        L_0x0041:
            r8 = new java.lang.AssertionError;
            r8.<init>();
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.a.m.a.<init>(java.lang.Class):void");
        }

        /* renamed from: a */
        public T m12408a(C2152a c2152a) {
            if (c2152a.mo1999f() != C2153b.NULL) {
                return (Enum) this.f10067a.get(c2152a.mo2001h());
            }
            c2152a.mo2003j();
            return null;
        }

        /* renamed from: a */
        public void m12409a(C2154c c2154c, T t) {
            c2154c.mo2016b(t == null ? null : (String) this.f10068b.get(t));
        }
    }

    /* renamed from: a */
    public static <TT> C2169x m5829a(final C2150a<TT> c2150a, final C2168w<TT> c2168w) {
        return new C2169x() {
            /* renamed from: a */
            public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
                return c2150a.equals(c2150a) != null ? c2168w : null;
            }
        };
    }

    /* renamed from: a */
    public static <TT> C2169x m5830a(final Class<TT> cls, final C2168w<TT> c2168w) {
        return new C2169x() {
            /* renamed from: a */
            public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
                return c2150a.m5891a() == cls ? c2168w : null;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Factory[type=");
                stringBuilder.append(cls.getName());
                stringBuilder.append(",adapter=");
                stringBuilder.append(c2168w);
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
        };
    }

    /* renamed from: a */
    public static <TT> C2169x m5831a(final Class<TT> cls, final Class<TT> cls2, final C2168w<? super TT> c2168w) {
        return new C2169x() {
            /* renamed from: a */
            public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
                c2157f = c2150a.m5891a();
                if (c2157f != cls) {
                    if (c2157f != cls2) {
                        return null;
                    }
                }
                return c2168w;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Factory[type=");
                stringBuilder.append(cls2.getName());
                stringBuilder.append("+");
                stringBuilder.append(cls.getName());
                stringBuilder.append(",adapter=");
                stringBuilder.append(c2168w);
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
        };
    }

    /* renamed from: b */
    public static <TT> C2169x m5833b(final Class<TT> cls, final Class<? extends TT> cls2, final C2168w<? super TT> c2168w) {
        return new C2169x() {
            /* renamed from: a */
            public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
                c2157f = c2150a.m5891a();
                if (c2157f != cls) {
                    if (c2157f != cls2) {
                        return null;
                    }
                }
                return c2168w;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Factory[type=");
                stringBuilder.append(cls.getName());
                stringBuilder.append("+");
                stringBuilder.append(cls2.getName());
                stringBuilder.append(",adapter=");
                stringBuilder.append(c2168w);
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
        };
    }

    /* renamed from: b */
    public static <TT> C2169x m5832b(final Class<TT> cls, final C2168w<TT> c2168w) {
        return new C2169x() {
            /* renamed from: a */
            public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
                return cls.isAssignableFrom(c2150a.m5891a()) != null ? c2168w : null;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Factory[typeHierarchy=");
                stringBuilder.append(cls.getName());
                stringBuilder.append(",adapter=");
                stringBuilder.append(c2168w);
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
        };
    }
}
