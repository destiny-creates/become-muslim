package expolib_v1.p321a.p322a.p330h;

import com.facebook.imageutils.JfifUtil;
import javax.security.auth.x500.X500Principal;

/* compiled from: DistinguishedNameParser */
/* renamed from: expolib_v1.a.a.h.c */
final class C6194c {
    /* renamed from: a */
    private final String f20045a;
    /* renamed from: b */
    private final int f20046b = this.f20045a.length();
    /* renamed from: c */
    private int f20047c;
    /* renamed from: d */
    private int f20048d;
    /* renamed from: e */
    private int f20049e;
    /* renamed from: f */
    private int f20050f;
    /* renamed from: g */
    private char[] f20051g;

    public C6194c(X500Principal x500Principal) {
        this.f20045a = x500Principal.getName("RFC2253");
    }

    /* renamed from: a */
    private String m25511a() {
        while (this.f20047c < this.f20046b && this.f20051g[this.f20047c] == ' ') {
            this.f20047c++;
        }
        if (this.f20047c == this.f20046b) {
            return null;
        }
        this.f20048d = this.f20047c;
        this.f20047c++;
        while (this.f20047c < this.f20046b && this.f20051g[this.f20047c] != '=' && this.f20051g[this.f20047c] != ' ') {
            this.f20047c++;
        }
        if (this.f20047c < this.f20046b) {
            this.f20049e = this.f20047c;
            if (this.f20051g[this.f20047c] == ' ') {
                while (this.f20047c < this.f20046b && this.f20051g[this.f20047c] != '=' && this.f20051g[this.f20047c] == ' ') {
                    this.f20047c++;
                }
                if (this.f20051g[this.f20047c] != '=' || this.f20047c == this.f20046b) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected end of DN: ");
                    stringBuilder.append(this.f20045a);
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
            this.f20047c++;
            while (this.f20047c < this.f20046b && this.f20051g[this.f20047c] == ' ') {
                this.f20047c++;
            }
            if (this.f20049e - this.f20048d > 4 && this.f20051g[this.f20048d + 3] == '.' && ((this.f20051g[this.f20048d] == 'O' || this.f20051g[this.f20048d] == 'o') && ((this.f20051g[this.f20048d + 1] == 'I' || this.f20051g[this.f20048d + 1] == 'i') && (this.f20051g[this.f20048d + 2] == 'D' || this.f20051g[this.f20048d + 2] == 'd')))) {
                this.f20048d += 4;
            }
            return new String(this.f20051g, this.f20048d, this.f20049e - this.f20048d);
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected end of DN: ");
        stringBuilder.append(this.f20045a);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: b */
    private String m25512b() {
        this.f20047c++;
        this.f20048d = this.f20047c;
        this.f20049e = this.f20048d;
        while (this.f20047c != this.f20046b) {
            if (this.f20051g[this.f20047c] == '\"') {
                this.f20047c++;
                while (this.f20047c < this.f20046b && this.f20051g[this.f20047c] == ' ') {
                    this.f20047c++;
                }
                return new String(this.f20051g, this.f20048d, this.f20049e - this.f20048d);
            }
            if (this.f20051g[this.f20047c] == '\\') {
                this.f20051g[this.f20049e] = m25515e();
            } else {
                this.f20051g[this.f20049e] = this.f20051g[this.f20047c];
            }
            this.f20047c++;
            this.f20049e++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected end of DN: ");
        stringBuilder.append(this.f20045a);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: c */
    private String m25513c() {
        StringBuilder stringBuilder;
        if (this.f20047c + 4 < this.f20046b) {
            int i;
            this.f20048d = this.f20047c;
            this.f20047c++;
            while (this.f20047c != this.f20046b && this.f20051g[this.f20047c] != '+' && this.f20051g[this.f20047c] != ',') {
                if (this.f20051g[this.f20047c] == ';') {
                    break;
                } else if (this.f20051g[this.f20047c] == ' ') {
                    this.f20049e = this.f20047c;
                    this.f20047c++;
                    while (this.f20047c < this.f20046b && this.f20051g[this.f20047c] == ' ') {
                        this.f20047c++;
                    }
                    i = this.f20049e - this.f20048d;
                    if (i >= 5 || (i & 1) == 0) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Unexpected end of DN: ");
                        stringBuilder.append(this.f20045a);
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                    byte[] bArr = new byte[(i / 2)];
                    int i2 = this.f20048d + 1;
                    for (r2 = 0; r2 < bArr.length; r2++) {
                        bArr[r2] = (byte) m25510a(i2);
                        i2 += 2;
                    }
                    return new String(this.f20051g, this.f20048d, i);
                } else {
                    if (this.f20051g[this.f20047c] >= 'A' && this.f20051g[this.f20047c] <= 'F') {
                        char[] cArr = this.f20051g;
                        r2 = this.f20047c;
                        cArr[r2] = (char) (cArr[r2] + 32);
                    }
                    this.f20047c++;
                }
            }
            this.f20049e = this.f20047c;
            i = this.f20049e - this.f20048d;
            if (i >= 5) {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected end of DN: ");
            stringBuilder.append(this.f20045a);
            throw new IllegalStateException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected end of DN: ");
        stringBuilder.append(this.f20045a);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: d */
    private String m25514d() {
        this.f20048d = this.f20047c;
        this.f20049e = this.f20047c;
        while (this.f20047c < this.f20046b) {
            char c = this.f20051g[this.f20047c];
            char[] cArr;
            if (c != ' ') {
                if (c != ';') {
                    int i;
                    if (c != '\\') {
                        switch (c) {
                            case '+':
                            case ',':
                                break;
                            default:
                                cArr = this.f20051g;
                                i = this.f20049e;
                                this.f20049e = i + 1;
                                cArr[i] = this.f20051g[this.f20047c];
                                this.f20047c++;
                                continue;
                        }
                    } else {
                        cArr = this.f20051g;
                        i = this.f20049e;
                        this.f20049e = i + 1;
                        cArr[i] = m25515e();
                        this.f20047c++;
                    }
                }
                return new String(this.f20051g, this.f20048d, this.f20049e - this.f20048d);
            }
            this.f20050f = this.f20049e;
            this.f20047c++;
            cArr = this.f20051g;
            int i2 = this.f20049e;
            this.f20049e = i2 + 1;
            cArr[i2] = ' ';
            while (this.f20047c < this.f20046b && this.f20051g[this.f20047c] == ' ') {
                cArr = this.f20051g;
                i2 = this.f20049e;
                this.f20049e = i2 + 1;
                cArr[i2] = ' ';
                this.f20047c++;
            }
            if (this.f20047c == this.f20046b || this.f20051g[this.f20047c] == ',' || this.f20051g[this.f20047c] == '+' || this.f20051g[this.f20047c] == ';') {
                return new String(this.f20051g, this.f20048d, this.f20050f - this.f20048d);
            }
        }
        return new String(this.f20051g, this.f20048d, this.f20049e - this.f20048d);
    }

    /* renamed from: e */
    private char m25515e() {
        this.f20047c++;
        if (this.f20047c != this.f20046b) {
            char c = this.f20051g[this.f20047c];
            if (!(c == ' ' || c == '%' || c == '\\' || c == '_')) {
                switch (c) {
                    case '\"':
                    case '#':
                        break;
                    default:
                        switch (c) {
                            case '*':
                            case '+':
                            case ',':
                                break;
                            default:
                                switch (c) {
                                    case ';':
                                    case '<':
                                    case '=':
                                    case '>':
                                        break;
                                    default:
                                        return m25516f();
                                }
                        }
                }
            }
            return this.f20051g[this.f20047c];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected end of DN: ");
        stringBuilder.append(this.f20045a);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: f */
    private char m25516f() {
        int a = m25510a(this.f20047c);
        this.f20047c++;
        if (a < 128) {
            return (char) a;
        }
        if (a < JfifUtil.MARKER_SOFn || a > 247) {
            return '?';
        }
        int i;
        if (a <= 223) {
            a &= 31;
            i = 1;
        } else if (a <= 239) {
            i = 2;
            a &= 15;
        } else {
            i = 3;
            a &= 7;
        }
        int i2 = 0;
        while (i2 < i) {
            this.f20047c++;
            if (this.f20047c != this.f20046b) {
                if (this.f20051g[this.f20047c] == '\\') {
                    this.f20047c++;
                    int a2 = m25510a(this.f20047c);
                    this.f20047c++;
                    if ((a2 & JfifUtil.MARKER_SOFn) != 128) {
                        return '?';
                    }
                    a = (a << 6) + (a2 & 63);
                    i2++;
                }
            }
            return '?';
        }
        return (char) a;
    }

    /* renamed from: a */
    private int m25510a(int i) {
        int i2 = i + 1;
        StringBuilder stringBuilder;
        if (i2 < this.f20046b) {
            i = this.f20051g[i];
            if (i >= 48 && i <= 57) {
                i -= 48;
            } else if (i >= 97 && i <= 102) {
                i -= 87;
            } else if (i < 65 || i > 70) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Malformed DN: ");
                stringBuilder.append(this.f20045a);
                throw new IllegalStateException(stringBuilder.toString());
            } else {
                i -= 55;
            }
            char c = this.f20051g[i2];
            if (c >= '0' && c <= '9') {
                i2 = c - 48;
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 87;
            } else if (c < 'A' || c > 'F') {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Malformed DN: ");
                stringBuilder.append(this.f20045a);
                throw new IllegalStateException(stringBuilder.toString());
            } else {
                i2 = c - 55;
            }
            return (i << 4) + i2;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Malformed DN: ");
        stringBuilder.append(this.f20045a);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: a */
    public String m25517a(String str) {
        this.f20047c = 0;
        this.f20048d = 0;
        this.f20049e = 0;
        this.f20050f = 0;
        this.f20051g = this.f20045a.toCharArray();
        String a = m25511a();
        if (a == null) {
            return null;
        }
        while (true) {
            String str2 = "";
            if (this.f20047c == this.f20046b) {
                return null;
            }
            switch (this.f20051g[this.f20047c]) {
                case '\"':
                    str2 = m25512b();
                    break;
                case '#':
                    str2 = m25513c();
                    break;
                case '+':
                case ',':
                case ';':
                    break;
                default:
                    str2 = m25514d();
                    break;
            }
            if (str.equalsIgnoreCase(a)) {
                return str2;
            }
            if (this.f20047c >= this.f20046b) {
                return null;
            }
            if (this.f20051g[this.f20047c] != ',') {
                if (this.f20051g[this.f20047c] != ';') {
                    if (this.f20051g[this.f20047c] != '+') {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Malformed DN: ");
                        stringBuilder.append(this.f20045a);
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                }
            }
            this.f20047c++;
            a = m25511a();
            if (a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Malformed DN: ");
                stringBuilder.append(this.f20045a);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }
}
