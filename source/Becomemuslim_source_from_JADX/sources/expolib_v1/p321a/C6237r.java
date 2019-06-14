package expolib_v1.p321a;

import com.facebook.common.util.UriUtil;
import com.facebook.imageutils.JfifUtil;
import com.facebook.soloader.MinElf;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p332b.C8170c;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: HttpUrl */
/* renamed from: expolib_v1.a.r */
public final class C6237r {
    /* renamed from: d */
    private static final char[] f20309d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* renamed from: a */
    final String f20310a;
    /* renamed from: b */
    final String f20311b;
    /* renamed from: c */
    final int f20312c;
    /* renamed from: e */
    private final String f20313e;
    /* renamed from: f */
    private final String f20314f;
    /* renamed from: g */
    private final List<String> f20315g;
    /* renamed from: h */
    private final List<String> f20316h;
    /* renamed from: i */
    private final String f20317i;
    /* renamed from: j */
    private final String f20318j;

    /* compiled from: HttpUrl */
    /* renamed from: expolib_v1.a.r$a */
    public static final class C6236a {
        /* renamed from: a */
        String f20301a;
        /* renamed from: b */
        String f20302b = "";
        /* renamed from: c */
        String f20303c = "";
        /* renamed from: d */
        String f20304d;
        /* renamed from: e */
        int f20305e = -1;
        /* renamed from: f */
        final List<String> f20306f = new ArrayList();
        /* renamed from: g */
        List<String> f20307g;
        /* renamed from: h */
        String f20308h;

        /* compiled from: HttpUrl */
        /* renamed from: expolib_v1.a.r$a$a */
        enum C6235a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public C6236a() {
            this.f20306f.add("");
        }

        /* renamed from: a */
        public C6236a m25739a(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase(UriUtil.HTTP_SCHEME)) {
                    this.f20301a = UriUtil.HTTP_SCHEME;
                } else if (str.equalsIgnoreCase(UriUtil.HTTPS_SCHEME)) {
                    this.f20301a = UriUtil.HTTPS_SCHEME;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("unexpected scheme: ");
                    stringBuilder.append(str);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        /* renamed from: b */
        public C6236a m25741b(String str) {
            if (str != null) {
                this.f20302b = C6237r.m25752a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        /* renamed from: c */
        public C6236a m25742c(String str) {
            if (str != null) {
                this.f20303c = C6237r.m25752a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        /* renamed from: d */
        public C6236a m25744d(String str) {
            if (str != null) {
                String e = C6236a.m25731e(str, 0, str.length());
                if (e != null) {
                    this.f20304d = e;
                    return this;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unexpected host: ");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            throw new NullPointerException("host == null");
        }

        /* renamed from: a */
        public C6236a m25738a(int i) {
            if (i <= 0 || i > MinElf.PN_XNUM) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unexpected port: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.f20305e = i;
            return this;
        }

        /* renamed from: a */
        int m25736a() {
            return this.f20305e != -1 ? this.f20305e : C6237r.m25747a(this.f20301a);
        }

        /* renamed from: e */
        public C6236a m25745e(String str) {
            if (str != null) {
                str = C6237r.m25759b(C6237r.m25752a(str, " \"'<>#", true, false, true, true));
            } else {
                str = null;
            }
            this.f20307g = str;
            return this;
        }

        /* renamed from: b */
        C6236a m25740b() {
            int size = this.f20306f.size();
            for (int i = 0; i < size; i++) {
                this.f20306f.set(i, C6237r.m25752a((String) this.f20306f.get(i), "[]", true, true, false, true));
            }
            if (this.f20307g != null) {
                size = this.f20307g.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = (String) this.f20307g.get(i2);
                    if (str != null) {
                        this.f20307g.set(i2, C6237r.m25752a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            if (this.f20308h != null) {
                this.f20308h = C6237r.m25752a(this.f20308h, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        /* renamed from: c */
        public C6237r m25743c() {
            if (this.f20301a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f20304d != null) {
                return new C6237r(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f20301a);
            stringBuilder.append("://");
            if (!(this.f20302b.isEmpty() && this.f20303c.isEmpty())) {
                stringBuilder.append(this.f20302b);
                if (!this.f20303c.isEmpty()) {
                    stringBuilder.append(':');
                    stringBuilder.append(this.f20303c);
                }
                stringBuilder.append('@');
            }
            if (this.f20304d.indexOf(58) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.f20304d);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(this.f20304d);
            }
            int a = m25736a();
            if (a != C6237r.m25747a(this.f20301a)) {
                stringBuilder.append(':');
                stringBuilder.append(a);
            }
            C6237r.m25757a(stringBuilder, this.f20306f);
            if (this.f20307g != null) {
                stringBuilder.append('?');
                C6237r.m25760b(stringBuilder, this.f20307g);
            }
            if (this.f20308h != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.f20308h);
            }
            return stringBuilder.toString();
        }

        /* renamed from: a */
        C6235a m25737a(C6237r c6237r, String str) {
            int a;
            C6236a c6236a = this;
            C6237r c6237r2 = c6237r;
            String str2 = str;
            int a2 = C6165c.m25302a(str2, 0, str.length());
            int b = C6165c.m25323b(str2, a2, str.length());
            if (C6236a.m25727b(str2, a2, b) != -1) {
                if (str.regionMatches(true, a2, "https:", 0, 6)) {
                    c6236a.f20301a = UriUtil.HTTPS_SCHEME;
                    a2 += "https:".length();
                } else {
                    if (!str.regionMatches(true, a2, "http:", 0, 5)) {
                        return C6235a.UNSUPPORTED_SCHEME;
                    }
                    c6236a.f20301a = UriUtil.HTTP_SCHEME;
                    a2 += "http:".length();
                }
            } else if (c6237r2 == null) {
                return C6235a.MISSING_SCHEME;
            } else {
                c6236a.f20301a = c6237r2.f20310a;
            }
            int c = C6236a.m25728c(str2, a2, b);
            char c2 = '#';
            if (c < 2 && c6237r2 != null) {
                if (c6237r2.f20310a.equals(c6236a.f20301a)) {
                    c6236a.f20302b = c6237r.m25767d();
                    c6236a.f20303c = c6237r.m25768e();
                    c6236a.f20304d = c6237r2.f20311b;
                    c6236a.f20305e = c6237r2.f20312c;
                    c6236a.f20306f.clear();
                    c6236a.f20306f.addAll(c6237r.m25772i());
                    if (a2 == b || str2.charAt(a2) == '#') {
                        m25745e(c6237r.m25774k());
                    }
                    int i = a2;
                    a = C6165c.m25304a(str2, i, b, "?#");
                    m25724a(str2, i, a);
                    if (a < b && str2.charAt(a) == '?') {
                        a2 = C6165c.m25303a(str2, a, b, '#');
                        c6236a.f20307g = C6237r.m25759b(C6237r.m25750a(str, a + 1, a2, " \"'<>#", true, false, true, true));
                        a = a2;
                    }
                    if (a < b && str2.charAt(a) == '#') {
                        c6236a.f20308h = C6237r.m25750a(str, 1 + a, b, "", true, false, false, false);
                    }
                    return C6235a.SUCCESS;
                }
            }
            c = a2 + c;
            Object obj = null;
            Object obj2 = null;
            while (true) {
                int a3 = C6165c.m25304a(str2, c, b, "@/\\?#");
                char charAt = a3 != b ? str2.charAt(a3) : '￿';
                if (!(charAt == '￿' || charAt == r13 || charAt == '/' || charAt == '\\')) {
                    switch (charAt) {
                        case '?':
                            break;
                        case '@':
                            if (obj == null) {
                                int a4 = C6165c.m25303a(str2, c, a3, ':');
                                int i2 = a4;
                                i = a3;
                                String a5 = C6237r.m25750a(str, c, a4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                if (obj2 != null) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(c6236a.f20302b);
                                    stringBuilder.append("%40");
                                    stringBuilder.append(a5);
                                    a5 = stringBuilder.toString();
                                }
                                c6236a.f20302b = a5;
                                if (i2 != i) {
                                    c6236a.f20303c = C6237r.m25750a(str, i2 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                    obj = 1;
                                }
                                obj2 = 1;
                            } else {
                                i = a3;
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(c6236a.f20303c);
                                stringBuilder2.append("%40");
                                stringBuilder2.append(C6237r.m25750a(str, c, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true));
                                c6236a.f20303c = stringBuilder2.toString();
                            }
                            c = i + 1;
                            continue;
                        default:
                            continue;
                    }
                }
                i = a3;
                a = C6236a.m25729d(str2, c, i);
                int i3 = a + 1;
                if (i3 < i) {
                    c6236a.f20304d = C6236a.m25731e(str2, c, a);
                    c6236a.f20305e = C6236a.m25734g(str2, i3, i);
                    if (c6236a.f20305e == -1) {
                        return C6235a.INVALID_PORT;
                    }
                }
                c6236a.f20304d = C6236a.m25731e(str2, c, a);
                c6236a.f20305e = C6237r.m25747a(c6236a.f20301a);
                if (c6236a.f20304d == null) {
                    return C6235a.INVALID_HOST;
                }
                a = C6165c.m25304a(str2, i, b, "?#");
                m25724a(str2, i, a);
                a2 = C6165c.m25303a(str2, a, b, '#');
                c6236a.f20307g = C6237r.m25759b(C6237r.m25750a(str, a + 1, a2, " \"'<>#", true, false, true, true));
                a = a2;
                c6236a.f20308h = C6237r.m25750a(str, 1 + a, b, "", true, false, false, false);
                return C6235a.SUCCESS;
                c2 = '#';
            }
        }

        /* renamed from: a */
        private void m25724a(String str, int i, int i2) {
            if (i != i2) {
                int i3;
                boolean z;
                char charAt = str.charAt(i);
                if (charAt != '/') {
                    if (charAt != '\\') {
                        this.f20306f.set(this.f20306f.size() - 1, "");
                        while (true) {
                            i3 = i;
                            if (i3 < i2) {
                                i = C6165c.m25304a(str, i3, i2, "/\\");
                                z = i >= i2;
                                m25725a(str, i3, i, z, true);
                                if (z) {
                                    i++;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
                this.f20306f.clear();
                this.f20306f.add("");
                i++;
                while (true) {
                    i3 = i;
                    if (i3 < i2) {
                        i = C6165c.m25304a(str, i3, i2, "/\\");
                        if (i >= i2) {
                        }
                        m25725a(str, i3, i, z, true);
                        if (z) {
                            i++;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* renamed from: a */
        private void m25725a(String str, int i, int i2, boolean z, boolean z2) {
            str = C6237r.m25750a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true);
            if (m25733f(str) == 0) {
                if (m25735g(str) != 0) {
                    m25730d();
                    return;
                }
                if (((String) this.f20306f.get(this.f20306f.size() - 1)).isEmpty() != 0) {
                    this.f20306f.set(this.f20306f.size() - 1, str);
                } else {
                    this.f20306f.add(str);
                }
                if (z) {
                    this.f20306f.add("");
                }
            }
        }

        /* renamed from: f */
        private boolean m25733f(String str) {
            if (!str.equals(".")) {
                if (str.equalsIgnoreCase("%2e") == null) {
                    return null;
                }
            }
            return true;
        }

        /* renamed from: g */
        private boolean m25735g(String str) {
            if (!(str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e"))) {
                if (str.equalsIgnoreCase("%2e%2e") == null) {
                    return null;
                }
            }
            return true;
        }

        /* renamed from: d */
        private void m25730d() {
            if (!((String) this.f20306f.remove(this.f20306f.size() - 1)).isEmpty() || this.f20306f.isEmpty()) {
                this.f20306f.add("");
            } else {
                this.f20306f.set(this.f20306f.size() - 1, "");
            }
        }

        /* renamed from: b */
        private static int m25727b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if (charAt < 'a' || charAt > 'z') {
                if (charAt >= 'A') {
                    if (charAt > 'Z') {
                    }
                }
                return -1;
            }
            while (true) {
                i++;
                if (i < i2) {
                    charAt = str.charAt(i);
                    if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && !((charAt >= '0' && charAt <= '9') || charAt == '+' || charAt == '-'))) {
                        if (charAt != '.') {
                            break;
                        }
                    }
                } else {
                    return -1;
                }
            }
            if (charAt == ':') {
                return i;
            }
            return -1;
        }

        /* renamed from: c */
        private static int m25728c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* renamed from: d */
        private static int m25729d(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        /* renamed from: e */
        private static String m25731e(String str, int i, int i2) {
            str = C6237r.m25751a(str, i, i2, false);
            if (str.contains(":") == 0) {
                return C6165c.m25307a(str);
            }
            if (str.startsWith("[") == 0 || str.endsWith("]") == 0) {
                str = C6236a.m25732f(str, 0, str.length());
            } else {
                str = C6236a.m25732f(str, 1, str.length() - 1);
            }
            if (str == null) {
                return null;
            }
            byte[] address = str.getAddress();
            if (address.length == 16) {
                return C6236a.m25723a(address);
            }
            throw new AssertionError();
        }

        /* renamed from: f */
        private static java.net.InetAddress m25732f(java.lang.String r10, int r11, int r12) {
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
            r10 = expolib_v1.p321a.C6237r.C6236a.m25726a(r10, r5, r12, r0, r11);
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
            r8 = expolib_v1.p321a.C6237r.m25746a(r8);
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
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.r.a.f(java.lang.String, int, int):java.net.InetAddress");
        }

        /* renamed from: a */
        private static boolean m25726a(String str, int i, int i2, byte[] bArr, int i3) {
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

        /* renamed from: a */
        private static String m25723a(byte[] bArr) {
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
                if (i6 > i3) {
                    i4 = i2;
                    i3 = i6;
                }
                i2 = i5 + 2;
            }
            C8170c c8170c = new C8170c();
            while (i < bArr.length) {
                if (i == i4) {
                    c8170c.m39604b(58);
                    i += i3;
                    if (i == 16) {
                        c8170c.m39604b(58);
                    }
                } else {
                    if (i > 0) {
                        c8170c.m39604b(58);
                    }
                    c8170c.m39637k((long) (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE)));
                    i += 2;
                }
            }
            return c8170c.mo6400r();
        }

        /* renamed from: g */
        private static int m25734g(java.lang.String r9, int r10, int r11) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = -1;
            r4 = "";	 Catch:{ NumberFormatException -> 0x001b }
            r5 = 0;	 Catch:{ NumberFormatException -> 0x001b }
            r6 = 0;	 Catch:{ NumberFormatException -> 0x001b }
            r7 = 0;	 Catch:{ NumberFormatException -> 0x001b }
            r8 = 1;	 Catch:{ NumberFormatException -> 0x001b }
            r1 = r9;	 Catch:{ NumberFormatException -> 0x001b }
            r2 = r10;	 Catch:{ NumberFormatException -> 0x001b }
            r3 = r11;	 Catch:{ NumberFormatException -> 0x001b }
            r9 = expolib_v1.p321a.C6237r.m25750a(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ NumberFormatException -> 0x001b }
            r9 = java.lang.Integer.parseInt(r9);	 Catch:{ NumberFormatException -> 0x001b }
            if (r9 <= 0) goto L_0x001a;
        L_0x0014:
            r10 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
            if (r9 > r10) goto L_0x001a;
        L_0x0019:
            return r9;
        L_0x001a:
            return r0;
        L_0x001b:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.r.a.g(java.lang.String, int, int):int");
        }
    }

    /* renamed from: a */
    static int m25746a(char c) {
        return (c < '0' || c > '9') ? (c < 'a' || c > 'f') ? (c < 'A' || c > 'F') ? -1 : (c - 65) + 10 : (c - 97) + 10 : c - 48;
    }

    C6237r(C6236a c6236a) {
        this.f20310a = c6236a.f20301a;
        this.f20313e = C6237r.m25753a(c6236a.f20302b, false);
        this.f20314f = C6237r.m25753a(c6236a.f20303c, false);
        this.f20311b = c6236a.f20304d;
        this.f20312c = c6236a.m25736a();
        this.f20315g = m25754a(c6236a.f20306f, false);
        String str = null;
        this.f20316h = c6236a.f20307g != null ? m25754a(c6236a.f20307g, true) : null;
        if (c6236a.f20308h != null) {
            str = C6237r.m25753a(c6236a.f20308h, false);
        }
        this.f20317i = str;
        this.f20318j = c6236a.toString();
    }

    /* renamed from: a */
    public java.net.URI m25762a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.m25778o();
        r0 = r0.m25740b();
        r0 = r0.toString();
        r1 = new java.net.URI;	 Catch:{ URISyntaxException -> 0x0012 }
        r1.<init>(r0);	 Catch:{ URISyntaxException -> 0x0012 }
        return r1;
    L_0x0012:
        r1 = move-exception;
        r2 = "[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]";	 Catch:{ Exception -> 0x0020 }
        r3 = "";	 Catch:{ Exception -> 0x0020 }
        r0 = r0.replaceAll(r2, r3);	 Catch:{ Exception -> 0x0020 }
        r0 = java.net.URI.create(r0);	 Catch:{ Exception -> 0x0020 }
        return r0;
    L_0x0020:
        r0 = new java.lang.RuntimeException;
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.r.a():java.net.URI");
    }

    /* renamed from: b */
    public String m25763b() {
        return this.f20310a;
    }

    /* renamed from: c */
    public boolean m25765c() {
        return this.f20310a.equals(UriUtil.HTTPS_SCHEME);
    }

    /* renamed from: d */
    public String m25767d() {
        if (this.f20313e.isEmpty()) {
            return "";
        }
        int length = this.f20310a.length() + 3;
        return this.f20318j.substring(length, C6165c.m25304a(this.f20318j, length, this.f20318j.length(), ":@"));
    }

    /* renamed from: e */
    public String m25768e() {
        if (this.f20314f.isEmpty()) {
            return "";
        }
        return this.f20318j.substring(this.f20318j.indexOf(58, this.f20310a.length() + 3) + 1, this.f20318j.indexOf(64));
    }

    /* renamed from: f */
    public String m25769f() {
        return this.f20311b;
    }

    /* renamed from: g */
    public int m25770g() {
        return this.f20312c;
    }

    /* renamed from: a */
    public static int m25747a(String str) {
        if (str.equals(UriUtil.HTTP_SCHEME)) {
            return 80;
        }
        return str.equals(UriUtil.HTTPS_SCHEME) != null ? 443 : -1;
    }

    /* renamed from: h */
    public String m25771h() {
        int indexOf = this.f20318j.indexOf(47, this.f20310a.length() + 3);
        return this.f20318j.substring(indexOf, C6165c.m25304a(this.f20318j, indexOf, this.f20318j.length(), "?#"));
    }

    /* renamed from: a */
    static void m25757a(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append('/');
            stringBuilder.append((String) list.get(i));
        }
    }

    /* renamed from: i */
    public List<String> m25772i() {
        int indexOf = this.f20318j.indexOf(47, this.f20310a.length() + 3);
        int a = C6165c.m25304a(this.f20318j, indexOf, this.f20318j.length(), "?#");
        List<String> arrayList = new ArrayList();
        while (indexOf < a) {
            indexOf++;
            int a2 = C6165c.m25303a(this.f20318j, indexOf, a, '/');
            arrayList.add(this.f20318j.substring(indexOf, a2));
            indexOf = a2;
        }
        return arrayList;
    }

    /* renamed from: j */
    public List<String> m25773j() {
        return this.f20315g;
    }

    /* renamed from: k */
    public String m25774k() {
        if (this.f20316h == null) {
            return null;
        }
        int indexOf = this.f20318j.indexOf(63) + 1;
        return this.f20318j.substring(indexOf, C6165c.m25303a(this.f20318j, indexOf + 1, this.f20318j.length(), '#'));
    }

    /* renamed from: b */
    static void m25760b(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str);
            if (str2 != null) {
                stringBuilder.append('=');
                stringBuilder.append(str2);
            }
        }
    }

    /* renamed from: b */
    static List<String> m25759b(String str) {
        List<String> arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 != -1) {
                if (indexOf2 <= indexOf) {
                    arrayList.add(str.substring(i, indexOf2));
                    arrayList.add(str.substring(indexOf2 + 1, indexOf));
                    i = indexOf + 1;
                }
            }
            arrayList.add(str.substring(i, indexOf));
            arrayList.add(null);
            i = indexOf + 1;
        }
        return arrayList;
    }

    /* renamed from: l */
    public String m25775l() {
        if (this.f20316h == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        C6237r.m25760b(stringBuilder, this.f20316h);
        return stringBuilder.toString();
    }

    /* renamed from: m */
    public String m25776m() {
        if (this.f20317i == null) {
            return null;
        }
        return this.f20318j.substring(this.f20318j.indexOf(35) + 1);
    }

    /* renamed from: n */
    public String m25777n() {
        return m25766d("/...").m25741b("").m25742c("").m25743c().toString();
    }

    /* renamed from: c */
    public C6237r m25764c(String str) {
        str = m25766d(str);
        return str != null ? str.m25743c() : null;
    }

    /* renamed from: o */
    public C6236a m25778o() {
        C6236a c6236a = new C6236a();
        c6236a.f20301a = this.f20310a;
        c6236a.f20302b = m25767d();
        c6236a.f20303c = m25768e();
        c6236a.f20304d = this.f20311b;
        c6236a.f20305e = this.f20312c != C6237r.m25747a(this.f20310a) ? this.f20312c : -1;
        c6236a.f20306f.clear();
        c6236a.f20306f.addAll(m25772i());
        c6236a.m25745e(m25774k());
        c6236a.f20308h = m25776m();
        return c6236a;
    }

    /* renamed from: d */
    public C6236a m25766d(String str) {
        C6236a c6236a = new C6236a();
        return c6236a.m25737a(this, str) == C6235a.SUCCESS ? c6236a : null;
    }

    /* renamed from: e */
    public static C6237r m25761e(String str) {
        C6236a c6236a = new C6236a();
        if (c6236a.m25737a(null, str) == C6235a.SUCCESS) {
            return c6236a.m25743c();
        }
        return null;
    }

    /* renamed from: a */
    public static C6237r m25749a(URL url) {
        return C6237r.m25761e(url.toString());
    }

    /* renamed from: a */
    public static C6237r m25748a(URI uri) {
        return C6237r.m25761e(uri.toString());
    }

    public boolean equals(Object obj) {
        return (!(obj instanceof C6237r) || ((C6237r) obj).f20318j.equals(this.f20318j) == null) ? null : true;
    }

    public int hashCode() {
        return this.f20318j.hashCode();
    }

    public String toString() {
        return this.f20318j;
    }

    /* renamed from: a */
    static String m25753a(String str, boolean z) {
        return C6237r.m25751a(str, 0, str.length(), z);
    }

    /* renamed from: a */
    private List<String> m25754a(List<String> list, boolean z) {
        int size = list.size();
        List arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = (String) list.get(i);
            arrayList.add(str != null ? C6237r.m25753a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    static String m25751a(String str, int i, int i2, boolean z) {
        int i3 = i;
        while (i3 < i2) {
            char charAt = str.charAt(i3);
            if (charAt != '%') {
                if (charAt != '+' || !z) {
                    i3++;
                }
            }
            C8170c c8170c = new C8170c();
            c8170c.m39592a(str, i, i3);
            C6237r.m25756a(c8170c, str, i3, i2, z);
            return c8170c.mo6400r();
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m25756a(C8170c c8170c, String str, int i, int i2, boolean z) {
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37) {
                int i3 = i + 2;
                if (i3 < i2) {
                    int a = C6237r.m25746a(str.charAt(i + 1));
                    int a2 = C6237r.m25746a(str.charAt(i3));
                    if (!(a == -1 || a2 == -1)) {
                        c8170c.m39604b((a << 4) + a2);
                        i = i3;
                        i += Character.charCount(codePointAt);
                    }
                    c8170c.m39588a(codePointAt);
                    i += Character.charCount(codePointAt);
                }
            }
            if (codePointAt == 43 && z) {
                c8170c.m39604b(32);
                i += Character.charCount(codePointAt);
            }
            c8170c.m39588a(codePointAt);
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static boolean m25758a(String str, int i, int i2) {
        int i3 = i + 2;
        if (i3 >= i2 || str.charAt(i) != 37 || C6237r.m25746a(str.charAt(i + 1)) == -1 || C6237r.m25746a(str.charAt(i3)) == -1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    static String m25750a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int codePointAt;
        String str3 = str;
        int i3 = i2;
        int i4 = i;
        while (i4 < i3) {
            codePointAt = str.codePointAt(i4);
            String str4;
            if (codePointAt < 32 || codePointAt == 127 || (codePointAt >= 128 && z4)) {
                str4 = str2;
            } else {
                str4 = str2;
                if (str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || C6237r.m25758a(str, i4, i2))))) {
                    if (codePointAt != 43 || !z3) {
                        i4 += Character.charCount(codePointAt);
                    }
                }
            }
            C8170c c8170c = new C8170c();
            codePointAt = i;
            c8170c.m39592a(str, i, i4);
            C6237r.m25755a(c8170c, str, i4, i2, str2, z, z2, z3, z4);
            return c8170c.mo6400r();
        }
        codePointAt = i;
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m25755a(C8170c c8170c, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        C8170c c8170c2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (z) {
                if (!(codePointAt == 9 || codePointAt == 10 || codePointAt == 12)) {
                    if (codePointAt == 13) {
                    }
                }
                i += Character.charCount(codePointAt);
            }
            if (codePointAt == 43 && z3) {
                c8170c.m39591a(z ? "+" : "%2B");
                i += Character.charCount(codePointAt);
            } else {
                if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1)) {
                    if (codePointAt == 37) {
                        if (z) {
                            if (z2 && !C6237r.m25758a(str, i, i2)) {
                            }
                        }
                    }
                    c8170c.m39588a(codePointAt);
                    i += Character.charCount(codePointAt);
                }
                if (c8170c2 == null) {
                    c8170c2 = new C8170c();
                }
                c8170c2.m39588a(codePointAt);
                while (!c8170c2.mo6382f()) {
                    int i3 = c8170c2.mo6388i() & JfifUtil.MARKER_FIRST_BYTE;
                    c8170c.m39604b(37);
                    c8170c.m39604b(f20309d[(i3 >> 4) & 15]);
                    c8170c.m39604b(f20309d[i3 & 15]);
                }
                i += Character.charCount(codePointAt);
            }
        }
    }

    /* renamed from: a */
    static String m25752a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return C6237r.m25750a(str, 0, str.length(), str2, z, z2, z3, z4);
    }
}
