package com.google.p127a.p132d;

import com.facebook.internal.ServerProtocol;
import com.google.p127a.p129b.C2134e;
import com.google.p127a.p129b.p130a.C3999e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* compiled from: JsonReader */
/* renamed from: com.google.a.d.a */
public class C2152a implements Closeable {
    /* renamed from: a */
    private static final char[] f5137a = ")]}'\n".toCharArray();
    /* renamed from: b */
    private final Reader f5138b;
    /* renamed from: c */
    private boolean f5139c = false;
    /* renamed from: d */
    private final char[] f5140d = new char[1024];
    /* renamed from: e */
    private int f5141e = 0;
    /* renamed from: f */
    private int f5142f = 0;
    /* renamed from: g */
    private int f5143g = 0;
    /* renamed from: h */
    private int f5144h = 0;
    /* renamed from: i */
    private int f5145i = 0;
    /* renamed from: j */
    private long f5146j;
    /* renamed from: k */
    private int f5147k;
    /* renamed from: l */
    private String f5148l;
    /* renamed from: m */
    private int[] f5149m = new int[32];
    /* renamed from: n */
    private int f5150n = 0;
    /* renamed from: o */
    private String[] f5151o;
    /* renamed from: p */
    private int[] f5152p;

    /* compiled from: JsonReader */
    /* renamed from: com.google.a.d.a$1 */
    static class C40411 extends C2134e {
        C40411() {
        }

        /* renamed from: a */
        public void mo2028a(C2152a c2152a) {
            if (c2152a instanceof C3999e) {
                ((C3999e) c2152a).mo2008o();
                return;
            }
            int a = c2152a.f5145i;
            if (a == 0) {
                a = c2152a.mo2008o();
            }
            if (a == 13) {
                c2152a.f5145i = 9;
            } else if (a == 12) {
                c2152a.f5145i = 8;
            } else if (a == 14) {
                c2152a.f5145i = 10;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected a name but was ");
                stringBuilder.append(c2152a.mo1999f());
                stringBuilder.append(" ");
                stringBuilder.append(" at line ");
                stringBuilder.append(c2152a.m5912v());
                stringBuilder.append(" column ");
                stringBuilder.append(c2152a.m5913w());
                stringBuilder.append(" path ");
                stringBuilder.append(c2152a.m5933q());
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    static {
        C2134e.f5103a = new C40411();
    }

    public C2152a(Reader reader) {
        int[] iArr = this.f5149m;
        int i = this.f5150n;
        this.f5150n = i + 1;
        iArr[i] = 6;
        this.f5151o = new String[32];
        this.f5152p = new int[32];
        if (reader != null) {
            this.f5138b = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    /* renamed from: a */
    public final void m5918a(boolean z) {
        this.f5139c = z;
    }

    /* renamed from: p */
    public final boolean m5932p() {
        return this.f5139c;
    }

    /* renamed from: a */
    public void mo1993a() {
        int i = this.f5145i;
        if (i == 0) {
            i = mo2008o();
        }
        if (i == 3) {
            m5896a(1);
            this.f5152p[this.f5150n - 1] = 0;
            this.f5145i = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_ARRAY but was ");
        stringBuilder.append(mo1999f());
        stringBuilder.append(" at line ");
        stringBuilder.append(m5912v());
        stringBuilder.append(" column ");
        stringBuilder.append(m5913w());
        stringBuilder.append(" path ");
        stringBuilder.append(m5933q());
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: b */
    public void mo1994b() {
        int i = this.f5145i;
        if (i == 0) {
            i = mo2008o();
        }
        if (i == 4) {
            this.f5150n--;
            int[] iArr = this.f5152p;
            int i2 = this.f5150n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f5145i = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_ARRAY but was ");
        stringBuilder.append(mo1999f());
        stringBuilder.append(" at line ");
        stringBuilder.append(m5912v());
        stringBuilder.append(" column ");
        stringBuilder.append(m5913w());
        stringBuilder.append(" path ");
        stringBuilder.append(m5933q());
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: c */
    public void mo1995c() {
        int i = this.f5145i;
        if (i == 0) {
            i = mo2008o();
        }
        if (i == 1) {
            m5896a(3);
            this.f5145i = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_OBJECT but was ");
        stringBuilder.append(mo1999f());
        stringBuilder.append(" at line ");
        stringBuilder.append(m5912v());
        stringBuilder.append(" column ");
        stringBuilder.append(m5913w());
        stringBuilder.append(" path ");
        stringBuilder.append(m5933q());
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: d */
    public void mo1997d() {
        int i = this.f5145i;
        if (i == 0) {
            i = mo2008o();
        }
        if (i == 2) {
            this.f5150n--;
            this.f5151o[this.f5150n] = null;
            int[] iArr = this.f5152p;
            int i2 = this.f5150n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f5145i = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_OBJECT but was ");
        stringBuilder.append(mo1999f());
        stringBuilder.append(" at line ");
        stringBuilder.append(m5912v());
        stringBuilder.append(" column ");
        stringBuilder.append(m5913w());
        stringBuilder.append(" path ");
        stringBuilder.append(m5933q());
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: e */
    public boolean mo1998e() {
        int i = this.f5145i;
        if (i == 0) {
            i = mo2008o();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    /* renamed from: f */
    public C2153b mo1999f() {
        int i = this.f5145i;
        if (i == 0) {
            i = mo2008o();
        }
        switch (i) {
            case 1:
                return C2153b.BEGIN_OBJECT;
            case 2:
                return C2153b.END_OBJECT;
            case 3:
                return C2153b.BEGIN_ARRAY;
            case 4:
                return C2153b.END_ARRAY;
            case 5:
            case 6:
                return C2153b.BOOLEAN;
            case 7:
                return C2153b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return C2153b.STRING;
            case 12:
            case 13:
            case 14:
                return C2153b.NAME;
            case 15:
            case 16:
                return C2153b.NUMBER;
            case 17:
                return C2153b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* renamed from: o */
    private int mo2008o() {
        int b;
        int i = this.f5149m[this.f5150n - 1];
        if (i == 1) {
            this.f5149m[this.f5150n - 1] = 2;
        } else if (i == 2) {
            b = m5900b(true);
            if (b != 44) {
                if (b == 59) {
                    m5914x();
                } else if (b == 93) {
                    this.f5145i = 4;
                    return 4;
                } else {
                    throw m5901b("Unterminated array");
                }
            }
        } else {
            int b2;
            if (i != 3) {
                if (i != 5) {
                    if (i == 4) {
                        this.f5149m[this.f5150n - 1] = 5;
                        b = m5900b(true);
                        if (b != 58) {
                            if (b == 61) {
                                m5914x();
                                if ((this.f5141e < this.f5142f || m5903b(1)) && this.f5140d[this.f5141e] == '>') {
                                    this.f5141e++;
                                }
                            } else {
                                throw m5901b("Expected ':'");
                            }
                        }
                    } else if (i == 6) {
                        if (this.f5139c) {
                            m5893A();
                        }
                        this.f5149m[this.f5150n - 1] = 7;
                    } else if (i == 7) {
                        if (m5900b(false) == -1) {
                            this.f5145i = 17;
                            return 17;
                        }
                        m5914x();
                        this.f5141e--;
                    } else if (i == 8) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                }
            }
            this.f5149m[this.f5150n - 1] = 4;
            if (i == 5) {
                b2 = m5900b(true);
                if (b2 != 44) {
                    if (b2 == 59) {
                        m5914x();
                    } else if (b2 == 125) {
                        this.f5145i = 2;
                        return 2;
                    } else {
                        throw m5901b("Unterminated object");
                    }
                }
            }
            b2 = m5900b(true);
            if (b2 == 34) {
                this.f5145i = 13;
                return 13;
            } else if (b2 == 39) {
                m5914x();
                this.f5145i = 12;
                return 12;
            } else if (b2 != 125) {
                m5914x();
                this.f5141e--;
                if (m5897a((char) b2)) {
                    this.f5145i = 14;
                    return 14;
                }
                throw m5901b("Expected name");
            } else if (i != 5) {
                this.f5145i = 2;
                return 2;
            } else {
                throw m5901b("Expected name");
            }
        }
        b = m5900b(true);
        if (b == 34) {
            if (this.f5150n == 1) {
                m5914x();
            }
            this.f5145i = 9;
            return 9;
        } else if (b != 39) {
            if (!(b == 44 || b == 59)) {
                if (b == 91) {
                    this.f5145i = 3;
                    return 3;
                } else if (b != 93) {
                    if (b != 123) {
                        this.f5141e--;
                        if (this.f5150n == 1) {
                            m5914x();
                        }
                        i = m5908r();
                        if (i != 0) {
                            return i;
                        }
                        i = m5909s();
                        if (i != 0) {
                            return i;
                        }
                        if (m5897a(this.f5140d[this.f5141e])) {
                            m5914x();
                            this.f5145i = 10;
                            return 10;
                        }
                        throw m5901b("Expected value");
                    }
                    this.f5145i = 1;
                    return 1;
                } else if (i == 1) {
                    this.f5145i = 4;
                    return 4;
                }
            }
            if (i != 1) {
                if (i != 2) {
                    throw m5901b("Unexpected value");
                }
            }
            m5914x();
            this.f5141e--;
            this.f5145i = 7;
            return 7;
        } else {
            m5914x();
            this.f5145i = 8;
            return 8;
        }
    }

    /* renamed from: r */
    private int m5908r() {
        String str;
        String str2;
        int i;
        int length;
        int i2;
        char c;
        char c2 = this.f5140d[this.f5141e];
        if (c2 != 't') {
            if (c2 != 'T') {
                if (c2 != 'f') {
                    if (c2 != 'F') {
                        if (c2 != 'n') {
                            if (c2 != 'N') {
                                return 0;
                            }
                        }
                        str = "null";
                        str2 = "NULL";
                        i = 7;
                        length = str.length();
                        i2 = 1;
                        while (i2 < length) {
                            if (this.f5141e + i2 < this.f5142f && !m5903b(i2 + 1)) {
                                return 0;
                            }
                            c = this.f5140d[this.f5141e + i2];
                            if (c != str.charAt(i2) && c != r2.charAt(i2)) {
                                return 0;
                            }
                            i2++;
                        }
                        if ((this.f5141e + length >= this.f5142f || m5903b(length + 1)) && m5897a(this.f5140d[this.f5141e + length])) {
                            return 0;
                        }
                        this.f5141e += length;
                        this.f5145i = i;
                        return i;
                    }
                }
                str = "false";
                str2 = "FALSE";
                i = 6;
                length = str.length();
                i2 = 1;
                while (i2 < length) {
                    if (this.f5141e + i2 < this.f5142f) {
                    }
                    c = this.f5140d[this.f5141e + i2];
                    if (c != str.charAt(i2)) {
                    }
                    i2++;
                }
                if (this.f5141e + length >= this.f5142f) {
                }
                return 0;
            }
        }
        str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        str2 = "TRUE";
        i = 5;
        length = str.length();
        i2 = 1;
        while (i2 < length) {
            if (this.f5141e + i2 < this.f5142f) {
            }
            c = this.f5140d[this.f5141e + i2];
            if (c != str.charAt(i2)) {
            }
            i2++;
        }
        if (this.f5141e + length >= this.f5142f) {
        }
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: s */
    private int m5909s() {
        /*
        r18 = this;
        r0 = r18;
        r1 = r0.f5140d;
        r2 = r0.f5141e;
        r3 = r0.f5142f;
        r6 = 1;
        r7 = 0;
        r8 = r3;
        r3 = 0;
        r9 = 0;
        r10 = 1;
        r11 = 0;
        r13 = 0;
    L_0x0011:
        r14 = r2 + r3;
        r15 = 2;
        if (r14 != r8) goto L_0x0028;
    L_0x0016:
        r2 = r1.length;
        if (r3 != r2) goto L_0x001a;
    L_0x0019:
        return r7;
    L_0x001a:
        r2 = r3 + 1;
        r2 = r0.m5903b(r2);
        if (r2 != 0) goto L_0x0024;
    L_0x0022:
        goto L_0x0099;
    L_0x0024:
        r2 = r0.f5141e;
        r8 = r0.f5142f;
    L_0x0028:
        r14 = r2 + r3;
        r14 = r1[r14];
        r7 = 43;
        r4 = 3;
        r5 = 5;
        if (r14 == r7) goto L_0x00ea;
    L_0x0032:
        r7 = 69;
        if (r14 == r7) goto L_0x00de;
    L_0x0036:
        r7 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r14 == r7) goto L_0x00de;
    L_0x003a:
        switch(r14) {
            case 45: goto L_0x00d1;
            case 46: goto L_0x00c9;
            default: goto L_0x003d;
        };
    L_0x003d:
        r7 = 48;
        if (r14 < r7) goto L_0x0093;
    L_0x0041:
        r7 = 57;
        if (r14 <= r7) goto L_0x0046;
    L_0x0045:
        goto L_0x0093;
    L_0x0046:
        if (r9 == r6) goto L_0x0089;
    L_0x0048:
        if (r9 != 0) goto L_0x004b;
    L_0x004a:
        goto L_0x0089;
    L_0x004b:
        if (r9 != r15) goto L_0x0074;
    L_0x004d:
        r16 = 0;
        r4 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1));
        if (r4 != 0) goto L_0x0055;
    L_0x0053:
        r4 = 0;
        return r4;
    L_0x0055:
        r4 = 10;
        r4 = r4 * r11;
        r14 = r14 + -48;
        r14 = (long) r14;
        r4 = r4 - r14;
        r14 = -922337203685477580; // 0xf333333333333334 float:4.1723254E-8 double:-8.390303882365713E246;
        r7 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1));
        if (r7 > 0) goto L_0x006f;
    L_0x0066:
        if (r7 != 0) goto L_0x006d;
    L_0x0068:
        r7 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1));
        if (r7 >= 0) goto L_0x006d;
    L_0x006c:
        goto L_0x006f;
    L_0x006d:
        r7 = 0;
        goto L_0x0070;
    L_0x006f:
        r7 = 1;
    L_0x0070:
        r7 = r7 & r10;
        r11 = r4;
        r10 = r7;
        goto L_0x0082;
    L_0x0074:
        r16 = 0;
        if (r9 != r4) goto L_0x007c;
    L_0x0078:
        r7 = 0;
        r9 = 4;
        goto L_0x00f1;
    L_0x007c:
        if (r9 == r5) goto L_0x0085;
    L_0x007e:
        r4 = 6;
        if (r9 != r4) goto L_0x0082;
    L_0x0081:
        goto L_0x0085;
    L_0x0082:
        r7 = 0;
        goto L_0x00f1;
    L_0x0085:
        r7 = 0;
        r9 = 7;
        goto L_0x00f1;
    L_0x0089:
        r16 = 0;
        r14 = r14 + -48;
        r4 = -r14;
        r4 = (long) r4;
        r11 = r4;
        r7 = 0;
        r9 = 2;
        goto L_0x00f1;
    L_0x0093:
        r1 = r0.m5897a(r14);
        if (r1 != 0) goto L_0x00c7;
    L_0x0099:
        if (r9 != r15) goto L_0x00b5;
    L_0x009b:
        if (r10 == 0) goto L_0x00b5;
    L_0x009d:
        r1 = -9223372036854775808;
        r1 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1));
        if (r1 != 0) goto L_0x00a5;
    L_0x00a3:
        if (r13 == 0) goto L_0x00b5;
    L_0x00a5:
        if (r13 == 0) goto L_0x00a8;
    L_0x00a7:
        goto L_0x00a9;
    L_0x00a8:
        r11 = -r11;
    L_0x00a9:
        r0.f5146j = r11;
        r1 = r0.f5141e;
        r1 = r1 + r3;
        r0.f5141e = r1;
        r1 = 15;
        r0.f5145i = r1;
        return r1;
    L_0x00b5:
        if (r9 == r15) goto L_0x00c0;
    L_0x00b7:
        r1 = 4;
        if (r9 == r1) goto L_0x00c0;
    L_0x00ba:
        r1 = 7;
        if (r9 != r1) goto L_0x00be;
    L_0x00bd:
        goto L_0x00c0;
    L_0x00be:
        r7 = 0;
        return r7;
    L_0x00c0:
        r0.f5147k = r3;
        r1 = 16;
        r0.f5145i = r1;
        return r1;
    L_0x00c7:
        r7 = 0;
        return r7;
    L_0x00c9:
        r7 = 0;
        r16 = 0;
        if (r9 != r15) goto L_0x00d0;
    L_0x00ce:
        r9 = 3;
        goto L_0x00f1;
    L_0x00d0:
        return r7;
    L_0x00d1:
        r4 = 6;
        r7 = 0;
        r16 = 0;
        if (r9 != 0) goto L_0x00da;
    L_0x00d7:
        r9 = 1;
        r13 = 1;
        goto L_0x00f1;
    L_0x00da:
        if (r9 != r5) goto L_0x00dd;
    L_0x00dc:
        goto L_0x00f0;
    L_0x00dd:
        return r7;
    L_0x00de:
        r7 = 0;
        r16 = 0;
        if (r9 == r15) goto L_0x00e8;
    L_0x00e3:
        r4 = 4;
        if (r9 != r4) goto L_0x00e7;
    L_0x00e6:
        goto L_0x00e8;
    L_0x00e7:
        return r7;
    L_0x00e8:
        r9 = 5;
        goto L_0x00f1;
    L_0x00ea:
        r4 = 6;
        r7 = 0;
        r16 = 0;
        if (r9 != r5) goto L_0x00f5;
    L_0x00f0:
        r9 = 6;
    L_0x00f1:
        r3 = r3 + 1;
        goto L_0x0011;
    L_0x00f5:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.a.s():int");
    }

    /* renamed from: a */
    private boolean m5897a(char c) {
        switch (c) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                break;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                m5914x();
                break;
            default:
                return true;
        }
        return false;
    }

    /* renamed from: g */
    public String mo2000g() {
        String t;
        int i = this.f5145i;
        if (i == 0) {
            i = mo2008o();
        }
        if (i == 14) {
            t = m5910t();
        } else if (i == 12) {
            t = m5902b('\'');
        } else if (i == 13) {
            t = m5902b('\"');
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected a name but was ");
            stringBuilder.append(mo1999f());
            stringBuilder.append(" at line ");
            stringBuilder.append(m5912v());
            stringBuilder.append(" column ");
            stringBuilder.append(m5913w());
            stringBuilder.append(" path ");
            stringBuilder.append(m5933q());
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.f5145i = 0;
        this.f5151o[this.f5150n - 1] = t;
        return t;
    }

    /* renamed from: h */
    public String mo2001h() {
        String t;
        int i = this.f5145i;
        if (i == 0) {
            i = mo2008o();
        }
        if (i == 10) {
            t = m5910t();
        } else if (i == 8) {
            t = m5902b('\'');
        } else if (i == 9) {
            t = m5902b('\"');
        } else if (i == 11) {
            t = this.f5148l;
            this.f5148l = null;
        } else if (i == 15) {
            t = Long.toString(this.f5146j);
        } else if (i == 16) {
            t = new String(this.f5140d, this.f5141e, this.f5147k);
            this.f5141e += this.f5147k;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected a string but was ");
            stringBuilder.append(mo1999f());
            stringBuilder.append(" at line ");
            stringBuilder.append(m5912v());
            stringBuilder.append(" column ");
            stringBuilder.append(m5913w());
            stringBuilder.append(" path ");
            stringBuilder.append(m5933q());
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.f5145i = 0;
        int[] iArr = this.f5152p;
        int i2 = this.f5150n - 1;
        iArr[i2] = iArr[i2] + 1;
        return t;
    }

    /* renamed from: i */
    public boolean mo2002i() {
        int i = this.f5145i;
        if (i == 0) {
            i = mo2008o();
        }
        int[] iArr;
        int i2;
        if (i == 5) {
            this.f5145i = 0;
            iArr = this.f5152p;
            i2 = this.f5150n - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.f5145i = 0;
            iArr = this.f5152p;
            i2 = this.f5150n - 1;
            iArr[i2] = iArr[i2] + 1;
            return false;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected a boolean but was ");
            stringBuilder.append(mo1999f());
            stringBuilder.append(" at line ");
            stringBuilder.append(m5912v());
            stringBuilder.append(" column ");
            stringBuilder.append(m5913w());
            stringBuilder.append(" path ");
            stringBuilder.append(m5933q());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: j */
    public void mo2003j() {
        int i = this.f5145i;
        if (i == 0) {
            i = mo2008o();
        }
        if (i == 7) {
            this.f5145i = 0;
            int[] iArr = this.f5152p;
            int i2 = this.f5150n - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected null but was ");
        stringBuilder.append(mo1999f());
        stringBuilder.append(" at line ");
        stringBuilder.append(m5912v());
        stringBuilder.append(" column ");
        stringBuilder.append(m5913w());
        stringBuilder.append(" path ");
        stringBuilder.append(m5933q());
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: k */
    public double mo2004k() {
        int i = this.f5145i;
        if (i == 0) {
            i = mo2008o();
        }
        if (i == 15) {
            this.f5145i = 0;
            int[] iArr = this.f5152p;
            int i2 = this.f5150n - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.f5146j;
        }
        if (i == 16) {
            this.f5148l = new String(this.f5140d, this.f5141e, this.f5147k);
            this.f5141e += this.f5147k;
        } else {
            if (i != 8) {
                if (i != 9) {
                    if (i == 10) {
                        this.f5148l = m5910t();
                    } else if (i != 11) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Expected a double but was ");
                        stringBuilder.append(mo1999f());
                        stringBuilder.append(" at line ");
                        stringBuilder.append(m5912v());
                        stringBuilder.append(" column ");
                        stringBuilder.append(m5913w());
                        stringBuilder.append(" path ");
                        stringBuilder.append(m5933q());
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                }
            }
            this.f5148l = m5902b(i == 8 ? '\'' : '\"');
        }
        this.f5145i = 11;
        double parseDouble = Double.parseDouble(this.f5148l);
        if (!this.f5139c) {
            if (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("JSON forbids NaN and infinities: ");
                stringBuilder2.append(parseDouble);
                stringBuilder2.append(" at line ");
                stringBuilder2.append(m5912v());
                stringBuilder2.append(" column ");
                stringBuilder2.append(m5913w());
                stringBuilder2.append(" path ");
                stringBuilder2.append(m5933q());
                throw new C2155d(stringBuilder2.toString());
            }
        }
        this.f5148l = null;
        this.f5145i = 0;
        int[] iArr2 = this.f5152p;
        int i3 = this.f5150n - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    /* renamed from: l */
    public long mo2005l() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r7 = this;
        r0 = r7.f5145i;
        if (r0 != 0) goto L_0x0008;
    L_0x0004:
        r0 = r7.mo2008o();
    L_0x0008:
        r1 = 15;
        r2 = 0;
        if (r0 != r1) goto L_0x001e;
    L_0x000d:
        r7.f5145i = r2;
        r0 = r7.f5152p;
        r1 = r7.f5150n;
        r1 = r1 + -1;
        r2 = r0[r1];
        r2 = r2 + 1;
        r0[r1] = r2;
        r0 = r7.f5146j;
        return r0;
    L_0x001e:
        r1 = 16;
        if (r0 != r1) goto L_0x0037;
    L_0x0022:
        r0 = new java.lang.String;
        r1 = r7.f5140d;
        r3 = r7.f5141e;
        r4 = r7.f5147k;
        r0.<init>(r1, r3, r4);
        r7.f5148l = r0;
        r0 = r7.f5141e;
        r1 = r7.f5147k;
        r0 = r0 + r1;
        r7.f5141e = r0;
        goto L_0x00a1;
    L_0x0037:
        r1 = 8;
        if (r0 == r1) goto L_0x007f;
    L_0x003b:
        r3 = 9;
        if (r0 != r3) goto L_0x0040;
    L_0x003f:
        goto L_0x007f;
    L_0x0040:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Expected a long but was ";
        r1.append(r2);
        r2 = r7.mo1999f();
        r1.append(r2);
        r2 = " at line ";
        r1.append(r2);
        r2 = r7.m5912v();
        r1.append(r2);
        r2 = " column ";
        r1.append(r2);
        r2 = r7.m5913w();
        r1.append(r2);
        r2 = " path ";
        r1.append(r2);
        r2 = r7.m5933q();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x007f:
        if (r0 != r1) goto L_0x0084;
    L_0x0081:
        r0 = 39;
        goto L_0x0086;
    L_0x0084:
        r0 = 34;
    L_0x0086:
        r0 = r7.m5902b(r0);
        r7.f5148l = r0;
        r0 = r7.f5148l;	 Catch:{ NumberFormatException -> 0x00a1 }
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x00a1 }
        r7.f5145i = r2;	 Catch:{ NumberFormatException -> 0x00a1 }
        r3 = r7.f5152p;	 Catch:{ NumberFormatException -> 0x00a1 }
        r4 = r7.f5150n;	 Catch:{ NumberFormatException -> 0x00a1 }
        r4 = r4 + -1;	 Catch:{ NumberFormatException -> 0x00a1 }
        r5 = r3[r4];	 Catch:{ NumberFormatException -> 0x00a1 }
        r5 = r5 + 1;	 Catch:{ NumberFormatException -> 0x00a1 }
        r3[r4] = r5;	 Catch:{ NumberFormatException -> 0x00a1 }
        return r0;
    L_0x00a1:
        r0 = 11;
        r7.f5145i = r0;
        r0 = r7.f5148l;
        r0 = java.lang.Double.parseDouble(r0);
        r3 = (long) r0;
        r5 = (double) r3;
        r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        if (r0 != 0) goto L_0x00c3;
    L_0x00b1:
        r0 = 0;
        r7.f5148l = r0;
        r7.f5145i = r2;
        r0 = r7.f5152p;
        r1 = r7.f5150n;
        r1 = r1 + -1;
        r2 = r0[r1];
        r2 = r2 + 1;
        r0[r1] = r2;
        return r3;
    L_0x00c3:
        r0 = new java.lang.NumberFormatException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Expected a long but was ";
        r1.append(r2);
        r2 = r7.f5148l;
        r1.append(r2);
        r2 = " at line ";
        r1.append(r2);
        r2 = r7.m5912v();
        r1.append(r2);
        r2 = " column ";
        r1.append(r2);
        r2 = r7.m5913w();
        r1.append(r2);
        r2 = " path ";
        r1.append(r2);
        r2 = r7.m5933q();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.a.l():long");
    }

    /* renamed from: b */
    private String m5902b(char c) {
        char[] cArr = this.f5140d;
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int i;
            int i2 = this.f5141e;
            int i3 = this.f5142f;
            while (true) {
                i = i2;
                while (i2 < i3) {
                    int i4 = i2 + 1;
                    char c2 = cArr[i2];
                    if (c2 == c) {
                        this.f5141e = i4;
                        stringBuilder.append(cArr, i, (i4 - i) - 1);
                        return stringBuilder.toString();
                    } else if (c2 == '\\') {
                        this.f5141e = i4;
                        stringBuilder.append(cArr, i, (i4 - i) - 1);
                        stringBuilder.append(m5916z());
                        i2 = this.f5141e;
                        i3 = this.f5142f;
                    } else {
                        if (c2 == '\n') {
                            this.f5143g++;
                            this.f5144h = i4;
                        }
                        i2 = i4;
                    }
                }
                break;
            }
            stringBuilder.append(cArr, i, i2 - i);
            this.f5141e = i2;
            if (!m5903b(1)) {
                throw m5901b("Unterminated string");
            }
        }
    }

    /* renamed from: t */
    private String m5910t() {
        String str;
        int i = 0;
        StringBuilder stringBuilder = null;
        do {
            int i2 = 0;
            while (true) {
                if (this.f5141e + i2 < this.f5142f) {
                    switch (this.f5140d[this.f5141e + i2]) {
                        case '\t':
                        case '\n':
                        case '\f':
                        case '\r':
                        case ' ':
                        case ',':
                        case ':':
                        case '[':
                        case ']':
                        case '{':
                        case '}':
                            break;
                        case '#':
                        case '/':
                        case ';':
                        case '=':
                        case '\\':
                            m5914x();
                            break;
                        default:
                            i2++;
                            break;
                    }
                } else if (i2 >= this.f5140d.length) {
                    if (stringBuilder == null) {
                        stringBuilder = new StringBuilder();
                    }
                    stringBuilder.append(this.f5140d, this.f5141e, i2);
                    this.f5141e += i2;
                } else if (m5903b(i2 + 1)) {
                }
                i = i2;
                if (stringBuilder != null) {
                    str = new String(this.f5140d, this.f5141e, i);
                } else {
                    stringBuilder.append(this.f5140d, this.f5141e, i);
                    str = stringBuilder.toString();
                }
                this.f5141e += i;
                return str;
            }
        } while (m5903b(1));
        if (stringBuilder != null) {
            stringBuilder.append(this.f5140d, this.f5141e, i);
            str = stringBuilder.toString();
        } else {
            str = new String(this.f5140d, this.f5141e, i);
        }
        this.f5141e += i;
        return str;
    }

    /* renamed from: c */
    private void m5905c(char c) {
        char[] cArr = this.f5140d;
        while (true) {
            int i = this.f5141e;
            int i2 = this.f5142f;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.f5141e = i3;
                    return;
                } else if (c2 == '\\') {
                    this.f5141e = i3;
                    m5916z();
                    i = this.f5141e;
                    i2 = this.f5142f;
                } else {
                    if (c2 == '\n') {
                        this.f5143g++;
                        this.f5144h = i3;
                    }
                    i = i3;
                }
            }
            this.f5141e = i;
            if (!m5903b(1)) {
                throw m5901b("Unterminated string");
            }
        }
    }

    /* renamed from: u */
    private void m5911u() {
        do {
            int i = 0;
            while (this.f5141e + i < this.f5142f) {
                switch (this.f5140d[this.f5141e + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        m5914x();
                        break;
                    default:
                        i++;
                }
                this.f5141e += i;
                return;
            }
            this.f5141e += i;
        } while (m5903b(1));
    }

    /* renamed from: m */
    public int mo2006m() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r7 = this;
        r0 = r7.f5145i;
        if (r0 != 0) goto L_0x0008;
    L_0x0004:
        r0 = r7.mo2008o();
    L_0x0008:
        r1 = 15;
        r2 = 0;
        if (r0 != r1) goto L_0x0063;
    L_0x000d:
        r0 = r7.f5146j;
        r0 = (int) r0;
        r3 = r7.f5146j;
        r5 = (long) r0;
        r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r1 != 0) goto L_0x0026;
    L_0x0017:
        r7.f5145i = r2;
        r1 = r7.f5152p;
        r2 = r7.f5150n;
        r2 = r2 + -1;
        r3 = r1[r2];
        r3 = r3 + 1;
        r1[r2] = r3;
        return r0;
    L_0x0026:
        r0 = new java.lang.NumberFormatException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Expected an int but was ";
        r1.append(r2);
        r2 = r7.f5146j;
        r1.append(r2);
        r2 = " at line ";
        r1.append(r2);
        r2 = r7.m5912v();
        r1.append(r2);
        r2 = " column ";
        r1.append(r2);
        r2 = r7.m5913w();
        r1.append(r2);
        r2 = " path ";
        r1.append(r2);
        r2 = r7.m5933q();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0063:
        r1 = 16;
        if (r0 != r1) goto L_0x007c;
    L_0x0067:
        r0 = new java.lang.String;
        r1 = r7.f5140d;
        r3 = r7.f5141e;
        r4 = r7.f5147k;
        r0.<init>(r1, r3, r4);
        r7.f5148l = r0;
        r0 = r7.f5141e;
        r1 = r7.f5147k;
        r0 = r0 + r1;
        r7.f5141e = r0;
        goto L_0x00e6;
    L_0x007c:
        r1 = 8;
        if (r0 == r1) goto L_0x00c4;
    L_0x0080:
        r3 = 9;
        if (r0 != r3) goto L_0x0085;
    L_0x0084:
        goto L_0x00c4;
    L_0x0085:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Expected an int but was ";
        r1.append(r2);
        r2 = r7.mo1999f();
        r1.append(r2);
        r2 = " at line ";
        r1.append(r2);
        r2 = r7.m5912v();
        r1.append(r2);
        r2 = " column ";
        r1.append(r2);
        r2 = r7.m5913w();
        r1.append(r2);
        r2 = " path ";
        r1.append(r2);
        r2 = r7.m5933q();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00c4:
        if (r0 != r1) goto L_0x00c9;
    L_0x00c6:
        r0 = 39;
        goto L_0x00cb;
    L_0x00c9:
        r0 = 34;
    L_0x00cb:
        r0 = r7.m5902b(r0);
        r7.f5148l = r0;
        r0 = r7.f5148l;	 Catch:{ NumberFormatException -> 0x00e6 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x00e6 }
        r7.f5145i = r2;	 Catch:{ NumberFormatException -> 0x00e6 }
        r1 = r7.f5152p;	 Catch:{ NumberFormatException -> 0x00e6 }
        r3 = r7.f5150n;	 Catch:{ NumberFormatException -> 0x00e6 }
        r3 = r3 + -1;	 Catch:{ NumberFormatException -> 0x00e6 }
        r4 = r1[r3];	 Catch:{ NumberFormatException -> 0x00e6 }
        r4 = r4 + 1;	 Catch:{ NumberFormatException -> 0x00e6 }
        r1[r3] = r4;	 Catch:{ NumberFormatException -> 0x00e6 }
        return r0;
    L_0x00e6:
        r0 = 11;
        r7.f5145i = r0;
        r0 = r7.f5148l;
        r0 = java.lang.Double.parseDouble(r0);
        r3 = (int) r0;
        r4 = (double) r3;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 != 0) goto L_0x0108;
    L_0x00f6:
        r0 = 0;
        r7.f5148l = r0;
        r7.f5145i = r2;
        r0 = r7.f5152p;
        r1 = r7.f5150n;
        r1 = r1 + -1;
        r2 = r0[r1];
        r2 = r2 + 1;
        r0[r1] = r2;
        return r3;
    L_0x0108:
        r0 = new java.lang.NumberFormatException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Expected an int but was ";
        r1.append(r2);
        r2 = r7.f5148l;
        r1.append(r2);
        r2 = " at line ";
        r1.append(r2);
        r2 = r7.m5912v();
        r1.append(r2);
        r2 = " column ";
        r1.append(r2);
        r2 = r7.m5913w();
        r1.append(r2);
        r2 = " path ";
        r1.append(r2);
        r2 = r7.m5933q();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.a.m():int");
    }

    public void close() {
        this.f5145i = 0;
        this.f5149m[0] = 8;
        this.f5150n = 1;
        this.f5138b.close();
    }

    /* renamed from: n */
    public void mo2007n() {
        int i = 0;
        do {
            int i2 = this.f5145i;
            if (i2 == 0) {
                i2 = mo2008o();
            }
            if (i2 == 3) {
                m5896a(1);
                i++;
            } else if (i2 == 1) {
                m5896a(3);
                i++;
            } else if (i2 == 4) {
                this.f5150n--;
                i--;
            } else if (i2 == 2) {
                this.f5150n--;
                i--;
            } else {
                if (i2 != 14) {
                    if (i2 != 10) {
                        if (i2 != 8) {
                            if (i2 != 12) {
                                if (i2 != 9) {
                                    if (i2 != 13) {
                                        if (i2 == 16) {
                                            this.f5141e += this.f5147k;
                                        }
                                    }
                                }
                                m5905c('\"');
                            }
                        }
                        m5905c('\'');
                    }
                }
                m5911u();
            }
            this.f5145i = 0;
        } while (i != 0);
        int[] iArr = this.f5152p;
        i = this.f5150n - 1;
        iArr[i] = iArr[i] + 1;
        this.f5151o[this.f5150n - 1] = "null";
    }

    /* renamed from: a */
    private void m5896a(int i) {
        if (this.f5150n == this.f5149m.length) {
            Object obj = new int[(this.f5150n * 2)];
            Object obj2 = new int[(this.f5150n * 2)];
            Object obj3 = new String[(this.f5150n * 2)];
            System.arraycopy(this.f5149m, 0, obj, 0, this.f5150n);
            System.arraycopy(this.f5152p, 0, obj2, 0, this.f5150n);
            System.arraycopy(this.f5151o, 0, obj3, 0, this.f5150n);
            this.f5149m = obj;
            this.f5152p = obj2;
            this.f5151o = obj3;
        }
        int[] iArr = this.f5149m;
        int i2 = this.f5150n;
        this.f5150n = i2 + 1;
        iArr[i2] = i;
    }

    /* renamed from: b */
    private boolean m5903b(int i) {
        Object obj = this.f5140d;
        this.f5144h -= this.f5141e;
        if (this.f5142f != this.f5141e) {
            this.f5142f -= this.f5141e;
            System.arraycopy(obj, this.f5141e, obj, 0, this.f5142f);
        } else {
            this.f5142f = 0;
        }
        this.f5141e = 0;
        do {
            int read = this.f5138b.read(obj, this.f5142f, obj.length - this.f5142f);
            if (read == -1) {
                return false;
            }
            this.f5142f += read;
            if (this.f5143g == 0 && this.f5144h == 0 && this.f5142f > 0 && obj[0] == '﻿') {
                this.f5141e++;
                this.f5144h++;
                i++;
            }
        } while (this.f5142f < i);
        return true;
    }

    /* renamed from: v */
    private int m5912v() {
        return this.f5143g + 1;
    }

    /* renamed from: w */
    private int m5913w() {
        return (this.f5141e - this.f5144h) + 1;
    }

    /* renamed from: b */
    private int m5900b(boolean z) {
        char[] cArr = this.f5140d;
        int i = this.f5141e;
        int i2 = this.f5142f;
        while (true) {
            if (i == i2) {
                this.f5141e = i;
                if (!m5903b(1)) {
                    break;
                }
                i = this.f5141e;
                i2 = this.f5142f;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.f5143g++;
                this.f5144h = i3;
            } else if (!(c == ' ' || c == '\r')) {
                if (c != '\t') {
                    if (c == '/') {
                        this.f5141e = i3;
                        if (i3 == i2) {
                            this.f5141e--;
                            boolean b = m5903b(2);
                            this.f5141e++;
                            if (!b) {
                                return c;
                            }
                        }
                        m5914x();
                        char c2 = cArr[this.f5141e];
                        if (c2 == '*') {
                            this.f5141e++;
                            if (m5898a("*/")) {
                                i = this.f5141e + 2;
                                i2 = this.f5142f;
                            } else {
                                throw m5901b("Unterminated comment");
                            }
                        } else if (c2 != '/') {
                            return c;
                        } else {
                            this.f5141e++;
                            m5915y();
                            i = this.f5141e;
                            i2 = this.f5142f;
                        }
                    } else if (c == '#') {
                        this.f5141e = i3;
                        m5914x();
                        m5915y();
                        i = this.f5141e;
                        i2 = this.f5142f;
                    } else {
                        this.f5141e = i3;
                        return c;
                    }
                }
            }
            i = i3;
        }
        if (!z) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("End of input at line ");
        stringBuilder.append(m5912v());
        stringBuilder.append(" column ");
        stringBuilder.append(m5913w());
        throw new EOFException(stringBuilder.toString());
    }

    /* renamed from: x */
    private void m5914x() {
        if (!this.f5139c) {
            throw m5901b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* renamed from: y */
    private void m5915y() {
        char c;
        do {
            if (this.f5141e < this.f5142f || m5903b(1)) {
                char[] cArr = this.f5140d;
                int i = this.f5141e;
                this.f5141e = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.f5143g++;
                    this.f5144h = this.f5141e;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    /* renamed from: a */
    private boolean m5898a(String str) {
        while (true) {
            int i = 0;
            if (this.f5141e + str.length() > this.f5142f) {
                if (!m5903b(str.length())) {
                    return false;
                }
            }
            if (this.f5140d[this.f5141e] == '\n') {
                this.f5143g++;
                this.f5144h = this.f5141e + 1;
            } else {
                while (i < str.length()) {
                    if (this.f5140d[this.f5141e + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.f5141e++;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" at line ");
        stringBuilder.append(m5912v());
        stringBuilder.append(" column ");
        stringBuilder.append(m5913w());
        return stringBuilder.toString();
    }

    /* renamed from: q */
    public String m5933q() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('$');
        int i = this.f5150n;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.f5149m[i2]) {
                case 1:
                case 2:
                    stringBuilder.append('[');
                    stringBuilder.append(this.f5152p[i2]);
                    stringBuilder.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    stringBuilder.append('.');
                    if (this.f5151o[i2] == null) {
                        break;
                    }
                    stringBuilder.append(this.f5151o[i2]);
                    break;
                default:
                    break;
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: z */
    private char m5916z() {
        if (this.f5141e == this.f5142f) {
            if (!m5903b(1)) {
                throw m5901b("Unterminated escape sequence");
            }
        }
        char[] cArr = this.f5140d;
        int i = this.f5141e;
        this.f5141e = i + 1;
        char c = cArr[i];
        if (c == '\n') {
            this.f5143g++;
            this.f5144h = this.f5141e;
        } else if (c == 'b') {
            return '\b';
        } else {
            if (c == 'f') {
                return '\f';
            }
            if (c == 'n') {
                return '\n';
            }
            if (c != 'r') {
                switch (c) {
                    case 't':
                        return '\t';
                    case 'u':
                        if (this.f5141e + 4 > this.f5142f) {
                            if (!m5903b(4)) {
                                throw m5901b("Unterminated escape sequence");
                            }
                        }
                        c = '\u0000';
                        int i2 = this.f5141e;
                        int i3 = i2 + 4;
                        while (i2 < i3) {
                            char c2 = this.f5140d[i2];
                            c = (char) (c << 4);
                            if (c2 >= '0' && c2 <= '9') {
                                c = (char) (c + (c2 - 48));
                            } else if (c2 >= 'a' && c2 <= 'f') {
                                c = (char) (c + ((c2 - 97) + 10));
                            } else if (c2 < 'A' || c2 > 'F') {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("\\u");
                                stringBuilder.append(new String(this.f5140d, this.f5141e, 4));
                                throw new NumberFormatException(stringBuilder.toString());
                            } else {
                                c = (char) (c + ((c2 - 65) + 10));
                            }
                            i2++;
                        }
                        this.f5141e += 4;
                        return c;
                    default:
                        break;
                }
            }
            return '\r';
        }
        return c;
    }

    /* renamed from: b */
    private IOException m5901b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" at line ");
        stringBuilder.append(m5912v());
        stringBuilder.append(" column ");
        stringBuilder.append(m5913w());
        stringBuilder.append(" path ");
        stringBuilder.append(m5933q());
        throw new C2155d(stringBuilder.toString());
    }

    /* renamed from: A */
    private void m5893A() {
        m5900b(true);
        this.f5141e--;
        if (this.f5141e + f5137a.length <= this.f5142f || m5903b(f5137a.length)) {
            int i = 0;
            while (i < f5137a.length) {
                if (this.f5140d[this.f5141e + i] == f5137a[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.f5141e += f5137a.length;
        }
    }
}
