package org.spongycastle.util.encoders;

import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.dumpapp.Framer;
import java.io.IOException;
import java.io.OutputStream;

public class HexEncoder implements Encoder {
    /* renamed from: a */
    protected final byte[] f27888a = new byte[]{(byte) 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    /* renamed from: b */
    protected final byte[] f27889b = new byte[128];

    /* renamed from: a */
    private static boolean m36594a(char c) {
        if (!(c == '\n' || c == '\r' || c == '\t')) {
            if (c != ' ') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    protected void m36597a() {
        for (int i = 0; i < this.f27889b.length; i++) {
            this.f27889b[i] = (byte) -1;
        }
        for (int i2 = 0; i2 < this.f27888a.length; i2++) {
            this.f27889b[this.f27888a[i2]] = (byte) i2;
        }
        this.f27889b[65] = this.f27889b[97];
        this.f27889b[66] = this.f27889b[98];
        this.f27889b[67] = this.f27889b[99];
        this.f27889b[68] = this.f27889b[100];
        this.f27889b[69] = this.f27889b[101];
        this.f27889b[70] = this.f27889b[102];
    }

    public HexEncoder() {
        m36597a();
    }

    /* renamed from: a */
    public int mo5938a(byte[] bArr, int i, int i2, OutputStream outputStream) {
        for (int i3 = i; i3 < i + i2; i3++) {
            int i4 = bArr[i3] & JfifUtil.MARKER_FIRST_BYTE;
            outputStream.write(this.f27888a[i4 >>> 4]);
            outputStream.write(this.f27888a[i4 & 15]);
        }
        return i2 * 2;
    }

    /* renamed from: a */
    public int mo5937a(String str, OutputStream outputStream) {
        int length = str.length();
        while (length > 0) {
            if (!m36594a(str.charAt(length - 1))) {
                break;
            }
            length--;
        }
        int i = 0;
        int i2 = 0;
        while (i < length) {
            while (i < length && m36594a(str.charAt(i))) {
                i++;
            }
            int i3 = i + 1;
            byte b = this.f27889b[str.charAt(i)];
            while (i3 < length && m36594a(str.charAt(i3))) {
                i3++;
            }
            int i4 = i3 + 1;
            byte b2 = this.f27889b[str.charAt(i3)];
            if ((b | b2) >= 0) {
                outputStream.write((b << 4) | b2);
                i2++;
                i = i4;
            } else {
                throw new IOException("invalid characters encountered in Hex string");
            }
        }
        return i2;
    }
}
