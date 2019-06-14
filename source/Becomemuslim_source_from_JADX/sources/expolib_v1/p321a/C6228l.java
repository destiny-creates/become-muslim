package expolib_v1.p321a;

import com.facebook.ads.AdError;
import com.facebook.common.time.Clock;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p325c.C6159d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http.HttpDate;

/* compiled from: Cookie */
/* renamed from: expolib_v1.a.l */
public final class C6228l {
    /* renamed from: a */
    private static final Pattern f20267a = Pattern.compile("(\\d{2,4})[^\\d]*");
    /* renamed from: b */
    private static final Pattern f20268b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    /* renamed from: c */
    private static final Pattern f20269c = Pattern.compile("(\\d{1,2})[^\\d]*");
    /* renamed from: d */
    private static final Pattern f20270d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    /* renamed from: e */
    private final String f20271e;
    /* renamed from: f */
    private final String f20272f;
    /* renamed from: g */
    private final long f20273g;
    /* renamed from: h */
    private final String f20274h;
    /* renamed from: i */
    private final String f20275i;
    /* renamed from: j */
    private final boolean f20276j;
    /* renamed from: k */
    private final boolean f20277k;
    /* renamed from: l */
    private final boolean f20278l;
    /* renamed from: m */
    private final boolean f20279m;

    /* compiled from: Cookie */
    /* renamed from: expolib_v1.a.l$a */
    public static final class C6227a {
        /* renamed from: a */
        String f20258a;
        /* renamed from: b */
        String f20259b;
        /* renamed from: c */
        long f20260c = HttpDate.MAX_DATE;
        /* renamed from: d */
        String f20261d;
        /* renamed from: e */
        String f20262e = "/";
        /* renamed from: f */
        boolean f20263f;
        /* renamed from: g */
        boolean f20264g;
        /* renamed from: h */
        boolean f20265h;
        /* renamed from: i */
        boolean f20266i;

        /* renamed from: a */
        public C6227a m25671a(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.trim().equals(str)) {
                this.f20258a = str;
                return this;
            } else {
                throw new IllegalArgumentException("name is not trimmed");
            }
        }

        /* renamed from: b */
        public C6227a m25673b(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            } else if (str.trim().equals(str)) {
                this.f20259b = str;
                return this;
            } else {
                throw new IllegalArgumentException("value is not trimmed");
            }
        }

        /* renamed from: c */
        public C6227a m25674c(String str) {
            return m25670a(str, false);
        }

        /* renamed from: a */
        private C6227a m25670a(String str, boolean z) {
            if (str != null) {
                String a = C6165c.m25307a(str);
                if (a != null) {
                    this.f20261d = a;
                    this.f20266i = z;
                    return this;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unexpected domain: ");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            throw new NullPointerException("domain == null");
        }

        /* renamed from: a */
        public C6228l m25672a() {
            return new C6228l(this);
        }
    }

    private C6228l(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f20271e = str;
        this.f20272f = str2;
        this.f20273g = j;
        this.f20274h = str3;
        this.f20275i = str4;
        this.f20276j = z;
        this.f20277k = z2;
        this.f20279m = z3;
        this.f20278l = z4;
    }

    C6228l(C6227a c6227a) {
        if (c6227a.f20258a == null) {
            throw new NullPointerException("builder.name == null");
        } else if (c6227a.f20259b == null) {
            throw new NullPointerException("builder.value == null");
        } else if (c6227a.f20261d != null) {
            this.f20271e = c6227a.f20258a;
            this.f20272f = c6227a.f20259b;
            this.f20273g = c6227a.f20260c;
            this.f20274h = c6227a.f20261d;
            this.f20275i = c6227a.f20262e;
            this.f20276j = c6227a.f20263f;
            this.f20277k = c6227a.f20264g;
            this.f20278l = c6227a.f20265h;
            this.f20279m = c6227a.f20266i;
        } else {
            throw new NullPointerException("builder.domain == null");
        }
    }

    /* renamed from: a */
    public String m25684a() {
        return this.f20271e;
    }

    /* renamed from: b */
    public String m25687b() {
        return this.f20272f;
    }

    /* renamed from: a */
    public boolean m25686a(C6237r c6237r) {
        boolean equals;
        if (this.f20279m) {
            equals = c6237r.m25769f().equals(this.f20274h);
        } else {
            equals = C6228l.m25682b(c6237r, this.f20274h);
        }
        if (!equals || !C6228l.m25683c(c6237r, this.f20275i)) {
            return false;
        }
        if (this.f20276j && c6237r.m25765c() == null) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m25682b(C6237r c6237r, String str) {
        c6237r = c6237r.m25769f();
        if (c6237r.equals(str)) {
            return true;
        }
        if (c6237r.endsWith(str) && c6237r.charAt((c6237r.length() - str.length()) - 1) == 46 && C6165c.m25326c(c6237r) == null) {
            return true;
        }
        return null;
    }

    /* renamed from: c */
    private static boolean m25683c(C6237r c6237r, String str) {
        c6237r = c6237r.m25771h();
        if (c6237r.equals(str)) {
            return true;
        }
        if (c6237r.startsWith(str) && (str.endsWith("/") || c6237r.charAt(str.length()) == 47)) {
            return true;
        }
        return null;
    }

    /* renamed from: a */
    public static C6228l m25679a(C6237r c6237r, String str) {
        return C6228l.m25678a(System.currentTimeMillis(), c6237r, str);
    }

    /* renamed from: a */
    static expolib_v1.p321a.C6228l m25678a(long r25, expolib_v1.p321a.C6237r r27, java.lang.String r28) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = r28;
        r3 = r28.length();
        r4 = 59;
        r5 = 0;
        r6 = expolib_v1.p321a.p322a.C6165c.m25303a(r2, r5, r3, r4);
        r7 = 61;
        r8 = expolib_v1.p321a.p322a.C6165c.m25303a(r2, r5, r6, r7);
        r9 = 0;
        if (r8 != r6) goto L_0x0017;
    L_0x0016:
        return r9;
    L_0x0017:
        r11 = expolib_v1.p321a.p322a.C6165c.m25325c(r2, r5, r8);
        r10 = r11.isEmpty();
        if (r10 != 0) goto L_0x013d;
    L_0x0021:
        r10 = expolib_v1.p321a.p322a.C6165c.m25322b(r11);
        r12 = -1;
        if (r10 == r12) goto L_0x002a;
    L_0x0028:
        goto L_0x013d;
    L_0x002a:
        r10 = 1;
        r8 = r8 + r10;
        r8 = expolib_v1.p321a.p322a.C6165c.m25325c(r2, r8, r6);
        r13 = expolib_v1.p321a.p322a.C6165c.m25322b(r8);
        if (r13 == r12) goto L_0x0037;
    L_0x0036:
        return r9;
    L_0x0037:
        r6 = r6 + r10;
        r12 = -1;
        r14 = 253402300799999; // 0xe677d21fdbff float:-1.71647681E11 double:1.251973714024093E-309;
        r10 = r9;
        r21 = r10;
        r16 = r12;
        r18 = r14;
        r20 = 0;
        r22 = 0;
        r23 = 1;
        r24 = 0;
    L_0x004e:
        if (r6 >= r3) goto L_0x00c3;
    L_0x0050:
        r9 = expolib_v1.p321a.p322a.C6165c.m25303a(r2, r6, r3, r4);
        r4 = expolib_v1.p321a.p322a.C6165c.m25303a(r2, r6, r9, r7);
        r6 = expolib_v1.p321a.p322a.C6165c.m25325c(r2, r6, r4);
        if (r4 >= r9) goto L_0x0065;
    L_0x005e:
        r4 = r4 + 1;
        r4 = expolib_v1.p321a.p322a.C6165c.m25325c(r2, r4, r9);
        goto L_0x0067;
    L_0x0065:
        r4 = "";
    L_0x0067:
        r7 = "expires";
        r7 = r6.equalsIgnoreCase(r7);
        if (r7 == 0) goto L_0x007c;
    L_0x006f:
        r6 = r4.length();	 Catch:{ IllegalArgumentException -> 0x00bb }
        r6 = expolib_v1.p321a.C6228l.m25677a(r4, r5, r6);	 Catch:{ IllegalArgumentException -> 0x00bb }
        r18 = r6;
    L_0x0079:
        r24 = 1;
        goto L_0x00bb;
    L_0x007c:
        r7 = "max-age";
        r7 = r6.equalsIgnoreCase(r7);
        if (r7 == 0) goto L_0x008b;
    L_0x0084:
        r6 = expolib_v1.p321a.C6228l.m25676a(r4);	 Catch:{  }
        r16 = r6;
        goto L_0x0079;
    L_0x008b:
        r7 = "domain";
        r7 = r6.equalsIgnoreCase(r7);
        if (r7 == 0) goto L_0x009b;
    L_0x0093:
        r4 = expolib_v1.p321a.C6228l.m25681b(r4);	 Catch:{ IllegalArgumentException -> 0x00bb }
        r10 = r4;
        r23 = 0;
        goto L_0x00bb;
    L_0x009b:
        r7 = "path";
        r7 = r6.equalsIgnoreCase(r7);
        if (r7 == 0) goto L_0x00a6;
    L_0x00a3:
        r21 = r4;
        goto L_0x00bb;
    L_0x00a6:
        r4 = "secure";
        r4 = r6.equalsIgnoreCase(r4);
        if (r4 == 0) goto L_0x00b1;
    L_0x00ae:
        r20 = 1;
        goto L_0x00bb;
    L_0x00b1:
        r4 = "httponly";
        r4 = r6.equalsIgnoreCase(r4);
        if (r4 == 0) goto L_0x00bb;
    L_0x00b9:
        r22 = 1;
    L_0x00bb:
        r6 = r9 + 1;
        r4 = 59;
        r7 = 61;
        r9 = 0;
        goto L_0x004e;
    L_0x00c3:
        r2 = -9223372036854775808;
        r4 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1));
        if (r4 != 0) goto L_0x00cb;
    L_0x00c9:
        r13 = r2;
        goto L_0x00f1;
    L_0x00cb:
        r2 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1));
        if (r2 == 0) goto L_0x00ef;
    L_0x00cf:
        r2 = 9223372036854775; // 0x20c49ba5e353f7 float:-3.943512E-16 double:4.663754807431093E-308;
        r2 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1));
        if (r2 > 0) goto L_0x00dd;
    L_0x00d8:
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r16 = r16 * r2;
        goto L_0x00e2;
    L_0x00dd:
        r16 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
    L_0x00e2:
        r2 = 0;
        r2 = r25 + r16;
        r0 = (r2 > r25 ? 1 : (r2 == r25 ? 0 : -1));
        if (r0 < 0) goto L_0x00ed;
    L_0x00e9:
        r0 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1));
        if (r0 <= 0) goto L_0x00c9;
    L_0x00ed:
        r13 = r14;
        goto L_0x00f1;
    L_0x00ef:
        r13 = r18;
    L_0x00f1:
        if (r10 != 0) goto L_0x00fd;
    L_0x00f3:
        r0 = r27.m25769f();
        r15 = r0;
        r9 = r21;
        r0 = r27;
        goto L_0x010a;
    L_0x00fd:
        r0 = r27;
        r1 = expolib_v1.p321a.C6228l.m25682b(r0, r10);
        if (r1 != 0) goto L_0x0107;
    L_0x0105:
        r1 = 0;
        return r1;
    L_0x0107:
        r15 = r10;
        r9 = r21;
    L_0x010a:
        if (r9 == 0) goto L_0x0118;
    L_0x010c:
        r1 = "/";
        r1 = r9.startsWith(r1);
        if (r1 != 0) goto L_0x0115;
    L_0x0114:
        goto L_0x0118;
    L_0x0115:
        r16 = r9;
        goto L_0x012d;
    L_0x0118:
        r0 = r27.m25771h();
        r1 = 47;
        r1 = r0.lastIndexOf(r1);
        if (r1 == 0) goto L_0x0129;
    L_0x0124:
        r0 = r0.substring(r5, r1);
        goto L_0x012b;
    L_0x0129:
        r0 = "/";
    L_0x012b:
        r16 = r0;
    L_0x012d:
        r0 = new expolib_v1.a.l;
        r10 = r0;
        r12 = r8;
        r17 = r20;
        r18 = r22;
        r19 = r23;
        r20 = r24;
        r10.<init>(r11, r12, r13, r15, r16, r17, r18, r19, r20);
        return r0;
    L_0x013d:
        r0 = r9;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.l.a(long, expolib_v1.a.r, java.lang.String):expolib_v1.a.l");
    }

    /* renamed from: a */
    private static long m25677a(String str, int i, int i2) {
        i = C6228l.m25675a(str, i, i2, false);
        Matcher matcher = f20270d.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (i < i2) {
            int a = C6228l.m25675a(str, i + 1, i2, true);
            matcher.region(i, a);
            if (i3 == -1 && matcher.usePattern(f20270d).matches() != 0) {
                i = Integer.parseInt(matcher.group(1));
                i3 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
                i7 = i3;
                i3 = i;
            } else if (i5 == -1 && matcher.usePattern(f20269c).matches() != 0) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (i6 == -1 && matcher.usePattern(f20268b).matches() != 0) {
                i6 = f20268b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i4 == -1 && matcher.usePattern(f20267a).matches() != 0) {
                i4 = Integer.parseInt(matcher.group(1));
            }
            i = C6228l.m25675a(str, a + 1, i2, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += AdError.SERVER_ERROR_CODE;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        } else if (i6 == -1) {
            throw new IllegalArgumentException();
        } else if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        } else if (i3 < 0 || i3 > 23) {
            throw new IllegalArgumentException();
        } else if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else {
            str = new GregorianCalendar(C6165c.f19912f);
            str.setLenient(false);
            str.set(1, i4);
            str.set(2, i6 - 1);
            str.set(5, i5);
            str.set(11, i3);
            str.set(12, i7);
            str.set(13, i8);
            str.set(14, 0);
            return str.getTimeInMillis();
        }
    }

    /* renamed from: a */
    private static int m25675a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            int i3;
            char charAt = str.charAt(i);
            if ((charAt >= ' ' || charAt == '\t') && charAt < '' && ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')))) {
                if (charAt != ':') {
                    i3 = 0;
                    if (i3 == (z ^ 1)) {
                        return i;
                    }
                    i++;
                }
            }
            i3 = 1;
            if (i3 == (z ^ 1)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    private static long m25676a(String str) {
        long j = Long.MIN_VALUE;
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 0) {
                j = parseLong;
            }
            return j;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                if (str.startsWith("-") == null) {
                    j = Clock.MAX_TIME;
                }
                return j;
            }
            throw e;
        }
    }

    /* renamed from: b */
    private static String m25681b(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        str = C6165c.m25307a(str);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public static List<C6228l> m25680a(C6237r c6237r, C6234q c6234q) {
        c6234q = c6234q.m25721b("Set-Cookie");
        int size = c6234q.size();
        List list = null;
        for (int i = 0; i < size; i++) {
            C6228l a = C6228l.m25679a(c6237r, (String) c6234q.get(i));
            if (a != null) {
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(a);
            }
        }
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    public String toString() {
        return m25685a(false);
    }

    /* renamed from: a */
    String m25685a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f20271e);
        stringBuilder.append('=');
        stringBuilder.append(this.f20272f);
        if (this.f20278l) {
            if (this.f20273g == Long.MIN_VALUE) {
                stringBuilder.append("; max-age=0");
            } else {
                stringBuilder.append("; expires=");
                stringBuilder.append(C6159d.m25276a(new Date(this.f20273g)));
            }
        }
        if (!this.f20279m) {
            stringBuilder.append("; domain=");
            if (z) {
                stringBuilder.append(".");
            }
            stringBuilder.append(this.f20274h);
        }
        stringBuilder.append("; path=");
        stringBuilder.append(this.f20275i);
        if (this.f20276j) {
            stringBuilder.append("; secure");
        }
        if (this.f20277k) {
            stringBuilder.append("; httponly");
        }
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C6228l)) {
            return false;
        }
        C6228l c6228l = (C6228l) obj;
        if (c6228l.f20271e.equals(this.f20271e) && c6228l.f20272f.equals(this.f20272f) && c6228l.f20274h.equals(this.f20274h) && c6228l.f20275i.equals(this.f20275i) && c6228l.f20273g == this.f20273g && c6228l.f20276j == this.f20276j && c6228l.f20277k == this.f20277k && c6228l.f20278l == this.f20278l && c6228l.f20279m == this.f20279m) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.f20271e.hashCode()) * 31) + this.f20272f.hashCode()) * 31) + this.f20274h.hashCode()) * 31) + this.f20275i.hashCode()) * 31) + ((int) (this.f20273g ^ (this.f20273g >>> 32)))) * 31) + (this.f20276j ^ 1)) * 31) + (this.f20277k ^ 1)) * 31) + (this.f20278l ^ 1)) * 31) + (this.f20279m ^ 1);
    }
}
