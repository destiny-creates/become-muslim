package org.spongycastle.util.encoders;

import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.dumpapp.Framer;
import java.io.IOException;
import java.io.OutputStream;

public class Base64Encoder implements Encoder {
    /* renamed from: a */
    protected final byte[] f27885a = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, Framer.EXIT_FRAME_PREFIX, (byte) 121, (byte) 122, (byte) 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
    /* renamed from: b */
    protected byte f27886b = (byte) 61;
    /* renamed from: c */
    protected final byte[] f27887c = new byte[128];

    /* renamed from: a */
    private boolean m36590a(char c) {
        if (!(c == '\n' || c == '\r' || c == '\t')) {
            if (c != ' ') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    protected void m36593a() {
        for (int i = 0; i < this.f27887c.length; i++) {
            this.f27887c[i] = (byte) -1;
        }
        for (int i2 = 0; i2 < this.f27885a.length; i2++) {
            this.f27887c[this.f27885a[i2]] = (byte) i2;
        }
    }

    public Base64Encoder() {
        m36593a();
    }

    /* renamed from: a */
    public int mo5938a(byte[] bArr, int i, int i2, OutputStream outputStream) {
        int i3;
        int i4 = i2 % 3;
        i2 -= i4;
        int i5 = i;
        while (true) {
            int i6 = i + i2;
            i3 = 4;
            if (i5 >= i6) {
                break;
            }
            i6 = bArr[i5] & JfifUtil.MARKER_FIRST_BYTE;
            int i7 = bArr[i5 + 1] & JfifUtil.MARKER_FIRST_BYTE;
            int i8 = bArr[i5 + 2] & JfifUtil.MARKER_FIRST_BYTE;
            outputStream.write(this.f27885a[(i6 >>> 2) & 63]);
            outputStream.write(this.f27885a[((i6 << 4) | (i7 >>> 4)) & 63]);
            outputStream.write(this.f27885a[((i7 << 2) | (i8 >>> 6)) & 63]);
            outputStream.write(this.f27885a[i8 & 63]);
            i5 += 3;
        }
        switch (i4) {
            case 0:
                break;
            case 1:
                bArr = bArr[i6] & JfifUtil.MARKER_FIRST_BYTE;
                i = (bArr >>> 2) & 63;
                bArr = (bArr << 4) & 63;
                outputStream.write(this.f27885a[i]);
                outputStream.write(this.f27885a[bArr]);
                outputStream.write(this.f27886b);
                outputStream.write(this.f27886b);
                break;
            case 2:
                i = bArr[i6] & JfifUtil.MARKER_FIRST_BYTE;
                bArr = bArr[i6 + 1] & JfifUtil.MARKER_FIRST_BYTE;
                i5 = (i >>> 2) & 63;
                i = ((i << 4) | (bArr >>> 4)) & 63;
                bArr = (bArr << 2) & 63;
                outputStream.write(this.f27885a[i5]);
                outputStream.write(this.f27885a[i]);
                outputStream.write(this.f27885a[bArr]);
                outputStream.write(this.f27886b);
                break;
            default:
                break;
        }
        i2 = (i2 / 3) * 4;
        if (i4 == 0) {
            i3 = 0;
        }
        return i2 + i3;
    }

    /* renamed from: a */
    public int mo5937a(String str, OutputStream outputStream) {
        int length = str.length();
        while (length > 0) {
            if (!m36590a(str.charAt(length - 1))) {
                break;
            }
            length--;
        }
        int i = length - 4;
        int i2 = 0;
        int a = m36589a(str, 0, i);
        while (a < i) {
            int i3 = a + 1;
            byte b = this.f27887c[str.charAt(a)];
            int a2 = m36589a(str, i3, i);
            int i4 = a2 + 1;
            byte b2 = this.f27887c[str.charAt(a2)];
            i3 = m36589a(str, i4, i);
            int i5 = i3 + 1;
            byte b3 = this.f27887c[str.charAt(i3)];
            i4 = m36589a(str, i5, i);
            int i6 = i4 + 1;
            byte b4 = this.f27887c[str.charAt(i4)];
            if ((((b | b2) | b3) | b4) >= 0) {
                outputStream.write((b << 2) | (b2 >> 4));
                outputStream.write((b2 << 4) | (b3 >> 2));
                outputStream.write((b3 << 6) | b4);
                i2 += 3;
                a = m36589a(str, i6, i);
            } else {
                throw new IOException("invalid characters encountered in base64 data");
            }
        }
        return i2 + m36588a(outputStream, str.charAt(i), str.charAt(length - 3), str.charAt(length - 2), str.charAt(length - 1));
    }

    /* renamed from: a */
    private int m36588a(OutputStream outputStream, char c, char c2, char c3, char c4) {
        if (c3 == this.f27886b) {
            c = this.f27887c[c];
            c2 = this.f27887c[c2];
            if ((c | c2) >= '\u0000') {
                outputStream.write((c << '\u0002') | (c2 >> 4));
                return 1;
            }
            throw new IOException("invalid characters encountered at end of base64 data");
        } else if (c4 == this.f27886b) {
            c = this.f27887c[c];
            c2 = this.f27887c[c2];
            c3 = this.f27887c[c3];
            if (((c | c2) | c3) >= '\u0000') {
                outputStream.write((c << '\u0002') | (c2 >> 4));
                outputStream.write((c2 << 4) | (c3 >> 2));
                return 2;
            }
            throw new IOException("invalid characters encountered at end of base64 data");
        } else {
            c = this.f27887c[c];
            c2 = this.f27887c[c2];
            c3 = this.f27887c[c3];
            c4 = this.f27887c[c4];
            if ((((c | c2) | c3) | c4) >= 0) {
                outputStream.write((c << '\u0002') | (c2 >> 4));
                outputStream.write((c2 << 4) | (c3 >> 2));
                outputStream.write((c3 << 6) | c4);
                return 3;
            }
            throw new IOException("invalid characters encountered at end of base64 data");
        }
    }

    /* renamed from: a */
    private int m36589a(String str, int i, int i2) {
        while (i < i2 && m36590a(str.charAt(i))) {
            i++;
        }
        return i;
    }
}
