package expolib_v1.p321a.p322a;

import com.facebook.stetho.common.Utf8Charset;
import expolib_v1.p321a.C6237r;
import expolib_v1.p321a.aa;
import expolib_v1.p321a.ac;
import expolib_v1.p332b.C6251f;
import expolib_v1.p332b.C7497e;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;

/* compiled from: Util */
/* renamed from: expolib_v1.a.a.c */
public final class C6165c {
    /* renamed from: a */
    public static final byte[] f19907a = new byte[0];
    /* renamed from: b */
    public static final String[] f19908b = new String[0];
    /* renamed from: c */
    public static final ac f19909c = ac.create(null, f19907a);
    /* renamed from: d */
    public static final aa f19910d = aa.create(null, f19907a);
    /* renamed from: e */
    public static final Charset f19911e = Charset.forName(Utf8Charset.NAME);
    /* renamed from: f */
    public static final TimeZone f19912f = TimeZone.getTimeZone("GMT");
    /* renamed from: g */
    private static final C6251f f19913g = C6251f.m25840c("efbbbf");
    /* renamed from: h */
    private static final C6251f f19914h = C6251f.m25840c("feff");
    /* renamed from: i */
    private static final C6251f f19915i = C6251f.m25840c("fffe");
    /* renamed from: j */
    private static final C6251f f19916j = C6251f.m25840c("0000ffff");
    /* renamed from: k */
    private static final C6251f f19917k = C6251f.m25840c("ffff0000");
    /* renamed from: l */
    private static final Charset f19918l = Charset.forName("UTF-16BE");
    /* renamed from: m */
    private static final Charset f19919m = Charset.forName("UTF-16LE");
    /* renamed from: n */
    private static final Charset f19920n = Charset.forName("UTF-32BE");
    /* renamed from: o */
    private static final Charset f19921o = Charset.forName("UTF-32LE");
    /* renamed from: p */
    private static final Pattern f19922p = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* renamed from: a */
    public static void m25314a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: a */
    public static boolean m25319a(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static void m25315a(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0008;
    L_0x0002:
        r0.close();	 Catch:{ RuntimeException -> 0x0006, Exception -> 0x0008 }
        goto L_0x0008;
    L_0x0006:
        r0 = move-exception;
        throw r0;
    L_0x0008:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.c.a(java.io.Closeable):void");
    }

    /* renamed from: a */
    public static void m25316a(java.net.Socket r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r1 == 0) goto L_0x0011;
    L_0x0002:
        r1.close();	 Catch:{ AssertionError -> 0x0008, RuntimeException -> 0x0006, Exception -> 0x0011 }
        goto L_0x0011;
    L_0x0006:
        r1 = move-exception;
        throw r1;
    L_0x0008:
        r1 = move-exception;
        r0 = expolib_v1.p321a.p322a.C6165c.m25318a(r1);
        if (r0 == 0) goto L_0x0010;
    L_0x000f:
        goto L_0x0011;
    L_0x0010:
        throw r1;
    L_0x0011:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.c.a(java.net.Socket):void");
    }

    /* renamed from: a */
    public static boolean m25317a(expolib_v1.p332b.C6258s r0, int r1, java.util.concurrent.TimeUnit r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = expolib_v1.p321a.p322a.C6165c.m25324b(r0, r1, r2);	 Catch:{ IOException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.c.a(expolib_v1.b.s, int, java.util.concurrent.TimeUnit):boolean");
    }

    /* renamed from: b */
    public static boolean m25324b(expolib_v1.p332b.C6258s r11, int r12, java.util.concurrent.TimeUnit r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.System.nanoTime();
        r2 = r11.timeout();
        r2 = r2.O_();
        r3 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        if (r2 == 0) goto L_0x001d;
    L_0x0013:
        r2 = r11.timeout();
        r5 = r2.mo5350d();
        r5 = r5 - r0;
        goto L_0x001e;
    L_0x001d:
        r5 = r3;
    L_0x001e:
        r2 = r11.timeout();
        r7 = (long) r12;
        r12 = r13.toNanos(r7);
        r12 = java.lang.Math.min(r5, r12);
        r12 = r12 + r0;
        r2.mo5348a(r12);
        r12 = new expolib_v1.b.c;	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        r12.<init>();	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
    L_0x0034:
        r7 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        r7 = r11.read(r12, r7);	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        r9 = -1;	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        if (r13 == 0) goto L_0x0044;	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
    L_0x0040:
        r12.m39650u();	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        goto L_0x0034;
    L_0x0044:
        r12 = 1;
        r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r13 != 0) goto L_0x0051;
    L_0x0049:
        r11 = r11.timeout();
        r11.mo5351f();
        goto L_0x0059;
    L_0x0051:
        r11 = r11.timeout();
        r0 = r0 + r5;
        r11.mo5348a(r0);
    L_0x0059:
        return r12;
    L_0x005a:
        r12 = move-exception;
        r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r13 != 0) goto L_0x0067;
    L_0x005f:
        r11 = r11.timeout();
        r11.mo5351f();
        goto L_0x006f;
    L_0x0067:
        r11 = r11.timeout();
        r0 = r0 + r5;
        r11.mo5348a(r0);
    L_0x006f:
        throw r12;
        r12 = 0;
        r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r13 != 0) goto L_0x007e;
    L_0x0076:
        r11 = r11.timeout();
        r11.mo5351f();
        goto L_0x0086;
    L_0x007e:
        r11 = r11.timeout();
        r0 = r0 + r5;
        r11.mo5348a(r0);
    L_0x0086:
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.c.b(expolib_v1.b.s, int, java.util.concurrent.TimeUnit):boolean");
    }

    /* renamed from: a */
    public static <T> List<T> m25310a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* renamed from: a */
    public static <T> List<T> m25311a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* renamed from: a */
    public static ThreadFactory m25313a(final String str, final boolean z) {
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    /* renamed from: a */
    public static <T> T[] m25320a(Class<T> cls, T[] tArr, T[] tArr2) {
        tArr = C6165c.m25312a((Object[]) tArr, (Object[]) tArr2);
        return tArr.toArray((Object[]) Array.newInstance(cls, tArr.size()));
    }

    /* renamed from: a */
    private static <T> List<T> m25312a(T[] tArr, T[] tArr2) {
        List<T> arrayList = new ArrayList();
        for (Object obj : tArr) {
            for (Object obj2 : tArr2) {
                if (obj.equals(obj2)) {
                    arrayList.add(obj2);
                    break;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static String m25306a(C6237r c6237r, boolean z) {
        String stringBuilder;
        if (c6237r.m25769f().contains(":")) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("[");
            stringBuilder2.append(c6237r.m25769f());
            stringBuilder2.append("]");
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = c6237r.m25769f();
        }
        if (!z && c6237r.m25770g() == C6237r.m25747a(c6237r.m25763b())) {
            return stringBuilder;
        }
        z = new StringBuilder();
        z.append(stringBuilder);
        z.append(":");
        z.append(c6237r.m25770g());
        return z.toString();
    }

    /* renamed from: a */
    public static boolean m25318a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || assertionError.getMessage().contains("getsockname failed") == null) ? null : true;
    }

    /* renamed from: a */
    public static <T> int m25305a(T[] tArr, T t) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (C6165c.m25319a(tArr[i], (Object) t)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static String[] m25321a(String[] strArr, String str) {
        Object obj = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, obj, 0, strArr.length);
        obj[obj.length - 1] = str;
        return obj;
    }

    /* renamed from: a */
    public static int m25302a(String str, int i, int i2) {
        while (i < i2) {
            switch (str.charAt(i)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i++;
                default:
                    return i;
            }
        }
        return i2;
    }

    /* renamed from: b */
    public static int m25323b(String str, int i, int i2) {
        i2--;
        while (i2 >= i) {
            switch (str.charAt(i2)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i2--;
                default:
                    return i2 + 1;
            }
        }
        return i;
    }

    /* renamed from: c */
    public static String m25325c(String str, int i, int i2) {
        i = C6165c.m25302a(str, i, i2);
        return str.substring(i, C6165c.m25323b(str, i, i2));
    }

    /* renamed from: a */
    public static int m25304a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static int m25303a(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static java.lang.String m25307a(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r2 = java.net.IDN.toASCII(r2);	 Catch:{ IllegalArgumentException -> 0x001a }
        r1 = java.util.Locale.US;	 Catch:{ IllegalArgumentException -> 0x001a }
        r2 = r2.toLowerCase(r1);	 Catch:{ IllegalArgumentException -> 0x001a }
        r1 = r2.isEmpty();	 Catch:{ IllegalArgumentException -> 0x001a }
        if (r1 == 0) goto L_0x0012;	 Catch:{ IllegalArgumentException -> 0x001a }
    L_0x0011:
        return r0;	 Catch:{ IllegalArgumentException -> 0x001a }
    L_0x0012:
        r1 = expolib_v1.p321a.p322a.C6165c.m25327d(r2);	 Catch:{ IllegalArgumentException -> 0x001a }
        if (r1 == 0) goto L_0x0019;
    L_0x0018:
        return r0;
    L_0x0019:
        return r2;
    L_0x001a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.c.a(java.lang.String):java.lang.String");
    }

    /* renamed from: d */
    private static boolean m25327d(String str) {
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt > '\u001f') {
                if (charAt < '') {
                    if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                        return true;
                    }
                    i++;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static int m25322b(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt > '\u001f') {
                if (charAt < '') {
                    i++;
                }
            }
            return i;
        }
        return -1;
    }

    /* renamed from: c */
    public static boolean m25326c(String str) {
        return f19922p.matcher(str).matches();
    }

    /* renamed from: a */
    public static String m25308a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: a */
    public static Charset m25309a(C7497e c7497e, Charset charset) {
        if (c7497e.mo6371a(0, f19913g)) {
            c7497e.mo6387h((long) f19913g.mo5366h());
            return f19911e;
        } else if (c7497e.mo6371a(0, f19914h)) {
            c7497e.mo6387h((long) f19914h.mo5366h());
            return f19918l;
        } else if (c7497e.mo6371a(0, f19915i)) {
            c7497e.mo6387h((long) f19915i.mo5366h());
            return f19919m;
        } else if (c7497e.mo6371a(0, f19916j)) {
            c7497e.mo6387h((long) f19916j.mo5366h());
            return f19920n;
        } else if (!c7497e.mo6371a(0, f19917k)) {
            return charset;
        } else {
            c7497e.mo6387h((long) f19917k.mo5366h());
            return f19921o;
        }
    }
}
