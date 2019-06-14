package okhttp3.internal.tls;

import com.facebook.imageutils.JfifUtil;
import javax.security.auth.x500.X500Principal;

final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length = this.dn.length();
    private int pos;

    DistinguishedNameParser(X500Principal x500Principal) {
        this.dn = x500Principal.getName("RFC2253");
    }

    private String nextAT() {
        while (this.pos < this.length && this.chars[this.pos] == ' ') {
            this.pos++;
        }
        if (this.pos == this.length) {
            return null;
        }
        this.beg = this.pos;
        this.pos++;
        while (this.pos < this.length && this.chars[this.pos] != '=' && this.chars[this.pos] != ' ') {
            this.pos++;
        }
        if (this.pos < this.length) {
            this.end = this.pos;
            if (this.chars[this.pos] == ' ') {
                while (this.pos < this.length && this.chars[this.pos] != '=' && this.chars[this.pos] == ' ') {
                    this.pos++;
                }
                if (this.chars[this.pos] != '=' || this.pos == this.length) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected end of DN: ");
                    stringBuilder.append(this.dn);
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
            this.pos++;
            while (this.pos < this.length && this.chars[this.pos] == ' ') {
                this.pos++;
            }
            if (this.end - this.beg > 4 && this.chars[this.beg + 3] == '.' && ((this.chars[this.beg] == 'O' || this.chars[this.beg] == 'o') && ((this.chars[this.beg + 1] == 'I' || this.chars[this.beg + 1] == 'i') && (this.chars[this.beg + 2] == 'D' || this.chars[this.beg + 2] == 'd')))) {
                this.beg += 4;
            }
            return new String(this.chars, this.beg, this.end - this.beg);
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected end of DN: ");
        stringBuilder.append(this.dn);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private String quotedAV() {
        this.pos++;
        this.beg = this.pos;
        this.end = this.beg;
        while (this.pos != this.length) {
            if (this.chars[this.pos] == '\"') {
                this.pos++;
                while (this.pos < this.length && this.chars[this.pos] == ' ') {
                    this.pos++;
                }
                return new String(this.chars, this.beg, this.end - this.beg);
            }
            if (this.chars[this.pos] == '\\') {
                this.chars[this.end] = getEscaped();
            } else {
                this.chars[this.end] = this.chars[this.pos];
            }
            this.pos++;
            this.end++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected end of DN: ");
        stringBuilder.append(this.dn);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private String hexAV() {
        StringBuilder stringBuilder;
        if (this.pos + 4 < this.length) {
            int i;
            this.beg = this.pos;
            this.pos++;
            while (this.pos != this.length && this.chars[this.pos] != '+' && this.chars[this.pos] != ',') {
                if (this.chars[this.pos] == ';') {
                    break;
                } else if (this.chars[this.pos] == ' ') {
                    this.end = this.pos;
                    this.pos++;
                    while (this.pos < this.length && this.chars[this.pos] == ' ') {
                        this.pos++;
                    }
                    i = this.end - this.beg;
                    if (i >= 5 || (i & 1) == 0) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Unexpected end of DN: ");
                        stringBuilder.append(this.dn);
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                    byte[] bArr = new byte[(i / 2)];
                    int i2 = this.beg + 1;
                    for (r2 = 0; r2 < bArr.length; r2++) {
                        bArr[r2] = (byte) getByte(i2);
                        i2 += 2;
                    }
                    return new String(this.chars, this.beg, i);
                } else {
                    if (this.chars[this.pos] >= 'A' && this.chars[this.pos] <= 'F') {
                        char[] cArr = this.chars;
                        r2 = this.pos;
                        cArr[r2] = (char) (cArr[r2] + 32);
                    }
                    this.pos++;
                }
            }
            this.end = this.pos;
            i = this.end - this.beg;
            if (i >= 5) {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected end of DN: ");
            stringBuilder.append(this.dn);
            throw new IllegalStateException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected end of DN: ");
        stringBuilder.append(this.dn);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private String escapedAV() {
        this.beg = this.pos;
        this.end = this.pos;
        while (this.pos < this.length) {
            char c = this.chars[this.pos];
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
                                cArr = this.chars;
                                i = this.end;
                                this.end = i + 1;
                                cArr[i] = this.chars[this.pos];
                                this.pos++;
                                continue;
                        }
                    } else {
                        cArr = this.chars;
                        i = this.end;
                        this.end = i + 1;
                        cArr[i] = getEscaped();
                        this.pos++;
                    }
                }
                return new String(this.chars, this.beg, this.end - this.beg);
            }
            this.cur = this.end;
            this.pos++;
            cArr = this.chars;
            int i2 = this.end;
            this.end = i2 + 1;
            cArr[i2] = ' ';
            while (this.pos < this.length && this.chars[this.pos] == ' ') {
                cArr = this.chars;
                i2 = this.end;
                this.end = i2 + 1;
                cArr[i2] = ' ';
                this.pos++;
            }
            if (this.pos == this.length || this.chars[this.pos] == ',' || this.chars[this.pos] == '+' || this.chars[this.pos] == ';') {
                return new String(this.chars, this.beg, this.cur - this.beg);
            }
        }
        return new String(this.chars, this.beg, this.end - this.beg);
    }

    private char getEscaped() {
        this.pos++;
        if (this.pos != this.length) {
            char c = this.chars[this.pos];
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
                                        return getUTF8();
                                }
                        }
                }
            }
            return this.chars[this.pos];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected end of DN: ");
        stringBuilder.append(this.dn);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private char getUTF8() {
        int i = getByte(this.pos);
        this.pos++;
        if (i < 128) {
            return (char) i;
        }
        if (i < JfifUtil.MARKER_SOFn || i > 247) {
            return '?';
        }
        int i2;
        if (i <= 223) {
            i &= 31;
            i2 = 1;
        } else if (i <= 239) {
            i2 = 2;
            i &= 15;
        } else {
            i2 = 3;
            i &= 7;
        }
        int i3 = 0;
        while (i3 < i2) {
            this.pos++;
            if (this.pos != this.length) {
                if (this.chars[this.pos] == '\\') {
                    this.pos++;
                    int i4 = getByte(this.pos);
                    this.pos++;
                    if ((i4 & JfifUtil.MARKER_SOFn) != 128) {
                        return '?';
                    }
                    i = (i << 6) + (i4 & 63);
                    i3++;
                }
            }
            return '?';
        }
        return (char) i;
    }

    private int getByte(int i) {
        int i2 = i + 1;
        StringBuilder stringBuilder;
        if (i2 < this.length) {
            i = this.chars[i];
            if (i >= 48 && i <= 57) {
                i -= 48;
            } else if (i >= 97 && i <= 102) {
                i -= 87;
            } else if (i < 65 || i > 70) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Malformed DN: ");
                stringBuilder.append(this.dn);
                throw new IllegalStateException(stringBuilder.toString());
            } else {
                i -= 55;
            }
            char c = this.chars[i2];
            if (c >= '0' && c <= '9') {
                i2 = c - 48;
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 87;
            } else if (c < 'A' || c > 'F') {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Malformed DN: ");
                stringBuilder.append(this.dn);
                throw new IllegalStateException(stringBuilder.toString());
            } else {
                i2 = c - 55;
            }
            return (i << 4) + i2;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Malformed DN: ");
        stringBuilder.append(this.dn);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public String findMostSpecific(String str) {
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String nextAT = nextAT();
        if (nextAT == null) {
            return null;
        }
        while (true) {
            String str2 = "";
            if (this.pos == this.length) {
                return null;
            }
            switch (this.chars[this.pos]) {
                case '\"':
                    str2 = quotedAV();
                    break;
                case '#':
                    str2 = hexAV();
                    break;
                case '+':
                case ',':
                case ';':
                    break;
                default:
                    str2 = escapedAV();
                    break;
            }
            if (str.equalsIgnoreCase(nextAT)) {
                return str2;
            }
            if (this.pos >= this.length) {
                return null;
            }
            if (this.chars[this.pos] != ',') {
                if (this.chars[this.pos] != ';') {
                    if (this.chars[this.pos] != '+') {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Malformed DN: ");
                        stringBuilder.append(this.dn);
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                }
            }
            this.pos++;
            nextAT = nextAT();
            if (nextAT == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Malformed DN: ");
                stringBuilder.append(this.dn);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }
}
