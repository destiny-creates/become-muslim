package okhttp3.internal;

import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.common.Utf8Charset;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p286d.C5869f;
import p286d.C7204e;
import p286d.C8037c;

public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final RequestBody EMPTY_REQUEST = RequestBody.create(null, EMPTY_BYTE_ARRAY);
    public static final ResponseBody EMPTY_RESPONSE = ResponseBody.create(null, EMPTY_BYTE_ARRAY);
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Comparator<String> NATURAL_ORDER = new C66181();
    public static final TimeZone UTC = TimeZone.getTimeZone("GMT");
    private static final Charset UTF_16_BE = Charset.forName("UTF-16BE");
    private static final C5869f UTF_16_BE_BOM = C5869f.m24701c("feff");
    private static final Charset UTF_16_LE = Charset.forName("UTF-16LE");
    private static final C5869f UTF_16_LE_BOM = C5869f.m24701c("fffe");
    private static final Charset UTF_32_BE = Charset.forName("UTF-32BE");
    private static final C5869f UTF_32_BE_BOM = C5869f.m24701c("0000ffff");
    private static final Charset UTF_32_LE = Charset.forName("UTF-32LE");
    private static final C5869f UTF_32_LE_BOM = C5869f.m24701c("ffff0000");
    public static final Charset UTF_8 = Charset.forName(Utf8Charset.NAME);
    private static final C5869f UTF_8_BOM = C5869f.m24701c("efbbbf");
    private static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* renamed from: okhttp3.internal.Util$1 */
    class C66181 implements Comparator<String> {
        C66181() {
        }

        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    /* renamed from: okhttp3.internal.Util$2 */
    class C66192 implements ThreadFactory {
        final /* synthetic */ boolean val$daemon;
        final /* synthetic */ String val$name;

        C66192(String str, boolean z) {
            this.val$name = str;
            this.val$daemon = z;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.val$name);
            thread.setDaemon(this.val$daemon);
            return thread;
        }
    }

    public static int decodeHexDigit(char c) {
        return (c < '0' || c > '9') ? (c < 'a' || c > 'f') ? (c < 'A' || c > 'F') ? -1 : (c - 65) + 10 : (c - 97) + 10 : c - 48;
    }

    private Util() {
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    public static void closeQuietly(java.io.Closeable r0) {
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
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.closeQuietly(java.io.Closeable):void");
    }

    public static void closeQuietly(java.net.Socket r1) {
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
        r0 = isAndroidGetsocknameError(r1);
        if (r0 == 0) goto L_0x0010;
    L_0x000f:
        goto L_0x0011;
    L_0x0010:
        throw r1;
    L_0x0011:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.closeQuietly(java.net.Socket):void");
    }

    public static void closeQuietly(java.net.ServerSocket r0) {
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
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.closeQuietly(java.net.ServerSocket):void");
    }

    public static boolean discard(p286d.C5876t r0, int r1, java.util.concurrent.TimeUnit r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = skipAll(r0, r1, r2);	 Catch:{ IOException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.discard(d.t, int, java.util.concurrent.TimeUnit):boolean");
    }

    public static boolean skipAll(p286d.C5876t r11, int r12, java.util.concurrent.TimeUnit r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.System.nanoTime();
        r2 = r11.timeout();
        r2 = r2.hasDeadline();
        r3 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        if (r2 == 0) goto L_0x001d;
    L_0x0013:
        r2 = r11.timeout();
        r5 = r2.deadlineNanoTime();
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
        r2.deadlineNanoTime(r12);
        r12 = new d.c;	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        r12.<init>();	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
    L_0x0034:
        r7 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        r7 = r11.read(r12, r7);	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        r9 = -1;	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        if (r13 == 0) goto L_0x0044;	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
    L_0x0040:
        r12.m39025t();	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        goto L_0x0034;
    L_0x0044:
        r12 = 1;
        r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r13 != 0) goto L_0x0051;
    L_0x0049:
        r11 = r11.timeout();
        r11.clearDeadline();
        goto L_0x0059;
    L_0x0051:
        r11 = r11.timeout();
        r0 = r0 + r5;
        r11.deadlineNanoTime(r0);
    L_0x0059:
        return r12;
    L_0x005a:
        r12 = move-exception;
        r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r13 != 0) goto L_0x0067;
    L_0x005f:
        r11 = r11.timeout();
        r11.clearDeadline();
        goto L_0x006f;
    L_0x0067:
        r11 = r11.timeout();
        r0 = r0 + r5;
        r11.deadlineNanoTime(r0);
    L_0x006f:
        throw r12;
        r12 = 0;
        r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r13 != 0) goto L_0x007e;
    L_0x0076:
        r11 = r11.timeout();
        r11.clearDeadline();
        goto L_0x0086;
    L_0x007e:
        r11 = r11.timeout();
        r0 = r0 + r5;
        r11.deadlineNanoTime(r0);
    L_0x0086:
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.skipAll(d.t, int, java.util.concurrent.TimeUnit):boolean");
    }

    public static <T> List<T> immutableList(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> immutableList(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory threadFactory(String str, boolean z) {
        return new C66192(str, z);
    }

    public static String[] intersect(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        List arrayList = new ArrayList();
        for (Object obj : strArr) {
            for (Object compare : strArr2) {
                if (comparator.compare(obj, compare) == 0) {
                    arrayList.add(obj);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean nonEmptyIntersection(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0)) {
            if (strArr2.length != 0) {
                for (Object obj : strArr) {
                    for (Object compare : strArr2) {
                        if (comparator.compare(obj, compare) == 0) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static String hostHeader(HttpUrl httpUrl, boolean z) {
        String stringBuilder;
        if (httpUrl.host().contains(":")) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("[");
            stringBuilder2.append(httpUrl.host());
            stringBuilder2.append("]");
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = httpUrl.host();
        }
        if (!z && httpUrl.port() == HttpUrl.defaultPort(httpUrl.scheme())) {
            return stringBuilder;
        }
        z = new StringBuilder();
        z.append(stringBuilder);
        z.append(":");
        z.append(httpUrl.port());
        return z.toString();
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || assertionError.getMessage().contains("getsockname failed") == null) ? null : true;
    }

    public static int indexOf(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static String[] concat(String[] strArr, String str) {
        Object obj = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, obj, 0, strArr.length);
        obj[obj.length - 1] = str;
        return obj;
    }

    public static int skipLeadingAsciiWhitespace(String str, int i, int i2) {
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

    public static int skipTrailingAsciiWhitespace(String str, int i, int i2) {
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

    public static String trimSubstring(String str, int i, int i2) {
        i = skipLeadingAsciiWhitespace(str, i, i2);
        return str.substring(i, skipTrailingAsciiWhitespace(str, i, i2));
    }

    public static int delimiterOffset(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int delimiterOffset(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static java.lang.String canonicalizeHost(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = ":";
        r0 = r3.contains(r0);
        r1 = 0;
        if (r0 == 0) goto L_0x005a;
    L_0x0009:
        r0 = "[";
        r0 = r3.startsWith(r0);
        if (r0 == 0) goto L_0x0024;
    L_0x0011:
        r0 = "]";
        r0 = r3.endsWith(r0);
        if (r0 == 0) goto L_0x0024;
    L_0x0019:
        r0 = r3.length();
        r2 = 1;
        r0 = r0 - r2;
        r0 = decodeIpv6(r3, r2, r0);
        goto L_0x002d;
    L_0x0024:
        r0 = 0;
        r2 = r3.length();
        r0 = decodeIpv6(r3, r0, r2);
    L_0x002d:
        if (r0 != 0) goto L_0x0030;
    L_0x002f:
        return r1;
    L_0x0030:
        r0 = r0.getAddress();
        r1 = r0.length;
        r2 = 16;
        if (r1 != r2) goto L_0x003e;
    L_0x0039:
        r3 = inet6AddressToAscii(r0);
        return r3;
    L_0x003e:
        r0 = new java.lang.AssertionError;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Invalid IPv6 address: '";
        r1.append(r2);
        r1.append(r3);
        r3 = "'";
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
    L_0x005a:
        r3 = java.net.IDN.toASCII(r3);	 Catch:{ IllegalArgumentException -> 0x0073 }
        r0 = java.util.Locale.US;	 Catch:{ IllegalArgumentException -> 0x0073 }
        r3 = r3.toLowerCase(r0);	 Catch:{ IllegalArgumentException -> 0x0073 }
        r0 = r3.isEmpty();	 Catch:{ IllegalArgumentException -> 0x0073 }
        if (r0 == 0) goto L_0x006b;	 Catch:{ IllegalArgumentException -> 0x0073 }
    L_0x006a:
        return r1;	 Catch:{ IllegalArgumentException -> 0x0073 }
    L_0x006b:
        r0 = containsInvalidHostnameAsciiCodes(r3);	 Catch:{ IllegalArgumentException -> 0x0073 }
        if (r0 == 0) goto L_0x0072;
    L_0x0071:
        return r1;
    L_0x0072:
        return r3;
    L_0x0073:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.canonicalizeHost(java.lang.String):java.lang.String");
    }

    private static boolean containsInvalidHostnameAsciiCodes(String str) {
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

    public static int indexOfControlOrNonAscii(String str) {
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

    public static boolean verifyAsIpAddress(String str) {
        return VERIFY_AS_IP_ADDRESS.matcher(str).matches();
    }

    public static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset bomAwareCharset(C7204e c7204e, Charset charset) {
        if (c7204e.mo6291a(0, UTF_8_BOM)) {
            c7204e.mo6309i((long) UTF_8_BOM.mo5110h());
            return UTF_8;
        } else if (c7204e.mo6291a(0, UTF_16_BE_BOM)) {
            c7204e.mo6309i((long) UTF_16_BE_BOM.mo5110h());
            return UTF_16_BE;
        } else if (c7204e.mo6291a(0, UTF_16_LE_BOM)) {
            c7204e.mo6309i((long) UTF_16_LE_BOM.mo5110h());
            return UTF_16_LE;
        } else if (c7204e.mo6291a(0, UTF_32_BE_BOM)) {
            c7204e.mo6309i((long) UTF_32_BE_BOM.mo5110h());
            return UTF_32_BE;
        } else if (!c7204e.mo6291a(0, UTF_32_LE_BOM)) {
            return charset;
        } else {
            c7204e.mo6309i((long) UTF_32_LE_BOM.mo5110h());
            return UTF_32_LE;
        }
    }

    public static int checkDuration(String str, long j, TimeUnit timeUnit) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        StringBuilder stringBuilder;
        if (i < 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" < 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (timeUnit != null) {
            j = timeUnit.toMillis(j);
            if (j <= 2147483647L) {
                if (j == 0) {
                    if (i > 0) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append(" too small.");
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                return (int) j;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" too large.");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public static java.lang.AssertionError assertionError(java.lang.String r1, java.lang.Exception r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.lang.AssertionError;
        r0.<init>(r1);
        r0.initCause(r2);	 Catch:{ IllegalStateException -> 0x0008 }
    L_0x0008:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.assertionError(java.lang.String, java.lang.Exception):java.lang.AssertionError");
    }

    private static java.net.InetAddress decodeIpv6(java.lang.String r10, int r11, int r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 16;
        r0 = new byte[r0];
        r1 = -1;
        r2 = 0;
        r3 = 0;
        r4 = -1;
        r5 = -1;
    L_0x0009:
        r6 = 0;
        if (r11 >= r12) goto L_0x007c;
    L_0x000c:
        r7 = r0.length;
        if (r3 != r7) goto L_0x0010;
    L_0x000f:
        return r6;
    L_0x0010:
        r7 = r11 + 2;
        if (r7 > r12) goto L_0x0029;
    L_0x0014:
        r8 = "::";
        r9 = 2;
        r8 = r10.regionMatches(r11, r8, r2, r9);
        if (r8 == 0) goto L_0x0029;
    L_0x001d:
        if (r4 == r1) goto L_0x0020;
    L_0x001f:
        return r6;
    L_0x0020:
        r3 = r3 + 2;
        if (r7 != r12) goto L_0x0026;
    L_0x0024:
        r4 = r3;
        goto L_0x007c;
    L_0x0026:
        r4 = r3;
        r5 = r7;
        goto L_0x004d;
    L_0x0029:
        if (r3 == 0) goto L_0x004c;
    L_0x002b:
        r7 = ":";
        r8 = 1;
        r7 = r10.regionMatches(r11, r7, r2, r8);
        if (r7 == 0) goto L_0x0037;
    L_0x0034:
        r11 = r11 + 1;
        goto L_0x004c;
    L_0x0037:
        r7 = ".";
        r11 = r10.regionMatches(r11, r7, r2, r8);
        if (r11 == 0) goto L_0x004b;
    L_0x003f:
        r11 = r3 + -2;
        r10 = decodeIpv4Suffix(r10, r5, r12, r0, r11);
        if (r10 != 0) goto L_0x0048;
    L_0x0047:
        return r6;
    L_0x0048:
        r3 = r3 + 2;
        goto L_0x007c;
    L_0x004b:
        return r6;
    L_0x004c:
        r5 = r11;
    L_0x004d:
        r11 = r5;
        r7 = 0;
    L_0x004f:
        if (r11 >= r12) goto L_0x0062;
    L_0x0051:
        r8 = r10.charAt(r11);
        r8 = decodeHexDigit(r8);
        if (r8 != r1) goto L_0x005c;
    L_0x005b:
        goto L_0x0062;
    L_0x005c:
        r7 = r7 << 4;
        r7 = r7 + r8;
        r11 = r11 + 1;
        goto L_0x004f;
    L_0x0062:
        r8 = r11 - r5;
        if (r8 == 0) goto L_0x007b;
    L_0x0066:
        r9 = 4;
        if (r8 <= r9) goto L_0x006a;
    L_0x0069:
        goto L_0x007b;
    L_0x006a:
        r6 = r3 + 1;
        r8 = r7 >>> 8;
        r8 = r8 & 255;
        r8 = (byte) r8;
        r0[r3] = r8;
        r3 = r6 + 1;
        r7 = r7 & 255;
        r7 = (byte) r7;
        r0[r6] = r7;
        goto L_0x0009;
    L_0x007b:
        return r6;
    L_0x007c:
        r10 = r0.length;
        if (r3 == r10) goto L_0x008f;
    L_0x007f:
        if (r4 != r1) goto L_0x0082;
    L_0x0081:
        return r6;
    L_0x0082:
        r10 = r0.length;
        r11 = r3 - r4;
        r10 = r10 - r11;
        java.lang.System.arraycopy(r0, r4, r0, r10, r11);
        r10 = r0.length;
        r10 = r10 - r3;
        r10 = r10 + r4;
        java.util.Arrays.fill(r0, r4, r10, r2);
    L_0x008f:
        r10 = java.net.InetAddress.getByAddress(r0);	 Catch:{ UnknownHostException -> 0x0094 }
        return r10;
    L_0x0094:
        r10 = new java.lang.AssertionError;
        r10.<init>();
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
    }

    private static boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = str.charAt(i5);
                if (charAt < '0') {
                    break;
                } else if (charAt > '9') {
                    break;
                } else if (i6 == 0 && i != i5) {
                    return false;
                } else {
                    i6 = ((i6 * 10) + charAt) - 48;
                    if (i6 > JfifUtil.MARKER_FIRST_BYTE) {
                        return false;
                    }
                    i5++;
                }
            }
            if (i5 - i == 0) {
                return false;
            }
            i = i4 + 1;
            bArr[i4] = (byte) i6;
            i4 = i;
            i = i5;
        }
        if (i4 != i3 + 4) {
            return false;
        }
        return true;
    }

    private static String inet6AddressToAscii(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        while (i2 < bArr.length) {
            int i5 = i2;
            while (i5 < 16 && bArr[i5] == (byte) 0 && bArr[i5 + 1] == (byte) 0) {
                i5 += 2;
            }
            int i6 = i5 - i2;
            if (i6 > i3 && i6 >= 4) {
                i4 = i2;
                i3 = i6;
            }
            i2 = i5 + 2;
        }
        C8037c c8037c = new C8037c();
        while (i < bArr.length) {
            if (i == i4) {
                c8037c.m38981b(58);
                i += i3;
                if (i == 16) {
                    c8037c.m38981b(58);
                }
            } else {
                if (i > 0) {
                    c8037c.m38981b(58);
                }
                c8037c.m39014l((long) (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE)));
                i += 2;
            }
        }
        return c8037c.m39022q();
    }
}
