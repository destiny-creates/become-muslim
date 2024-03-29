package org.spongycastle.crypto.prng;

import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.dumpapp.Framer;

public class VMPCRandomGenerator implements RandomGenerator {
    /* renamed from: a */
    private byte f27187a = (byte) 0;
    /* renamed from: b */
    private byte[] f27188b = new byte[]{(byte) -69, (byte) 44, (byte) 98, Byte.MAX_VALUE, (byte) -75, (byte) -86, (byte) -44, (byte) 13, (byte) -127, (byte) -2, (byte) -78, (byte) -126, (byte) -53, (byte) -96, (byte) -95, (byte) 8, (byte) 24, (byte) 113, (byte) 86, (byte) -24, (byte) 73, (byte) 2, (byte) 16, (byte) -60, (byte) -34, (byte) 53, (byte) -91, (byte) -20, Byte.MIN_VALUE, (byte) 18, (byte) -72, (byte) 105, (byte) -38, (byte) 47, (byte) 117, (byte) -52, (byte) -94, (byte) 9, (byte) 54, (byte) 3, (byte) 97, Framer.STDIN_FRAME_PREFIX, (byte) -3, (byte) -32, (byte) -35, (byte) 5, (byte) 67, (byte) -112, (byte) -83, (byte) -56, (byte) -31, (byte) -81, (byte) 87, (byte) -101, (byte) 76, (byte) -40, (byte) 81, (byte) -82, (byte) 80, (byte) -123, (byte) 60, (byte) 10, (byte) -28, (byte) -13, (byte) -100, (byte) 38, (byte) 35, (byte) 83, (byte) -55, (byte) -125, (byte) -105, (byte) 70, (byte) -79, (byte) -103, (byte) 100, Framer.STDOUT_FRAME_PREFIX, (byte) 119, (byte) -43, (byte) 29, (byte) -42, Framer.EXIT_FRAME_PREFIX, (byte) -67, (byte) 94, (byte) -80, (byte) -118, (byte) 34, (byte) 56, (byte) -8, (byte) 104, (byte) 43, (byte) 42, (byte) -59, (byte) -45, (byte) -9, (byte) -68, (byte) 111, (byte) -33, (byte) 4, (byte) -27, (byte) -107, (byte) 62, (byte) 37, (byte) -122, (byte) -90, (byte) 11, (byte) -113, (byte) -15, (byte) 36, (byte) 14, (byte) -41, (byte) 64, (byte) -77, (byte) -49, (byte) 126, (byte) 6, (byte) 21, (byte) -102, (byte) 77, (byte) 28, (byte) -93, (byte) -37, Framer.STDERR_FRAME_PREFIX, (byte) -110, (byte) 88, (byte) 17, (byte) 39, (byte) -12, (byte) 89, (byte) -48, (byte) 78, (byte) 106, (byte) 23, (byte) 91, (byte) -84, (byte) -1, (byte) 7, (byte) -64, (byte) 101, (byte) 121, (byte) -4, (byte) -57, (byte) -51, (byte) 118, (byte) 66, (byte) 93, (byte) -25, (byte) 58, (byte) 52, (byte) 122, (byte) 48, (byte) 40, (byte) 15, (byte) 115, (byte) 1, (byte) -7, (byte) -47, (byte) -46, (byte) 25, (byte) -23, (byte) -111, (byte) -71, (byte) 90, (byte) -19, (byte) 65, (byte) 109, (byte) -76, (byte) -61, (byte) -98, (byte) -65, (byte) 99, (byte) -6, (byte) 31, (byte) 51, (byte) 96, (byte) 71, (byte) -119, (byte) -16, (byte) -106, (byte) 26, Framer.STDIN_REQUEST_FRAME_PREFIX, (byte) -109, (byte) 61, (byte) 55, (byte) 75, (byte) -39, (byte) -88, (byte) -63, (byte) 27, (byte) -10, (byte) 57, (byte) -117, (byte) -73, (byte) 12, (byte) 32, (byte) -50, (byte) -120, (byte) 110, (byte) -74, (byte) 116, (byte) -114, (byte) -115, (byte) 22, (byte) 41, (byte) -14, (byte) -121, (byte) -11, (byte) -21, (byte) 112, (byte) -29, (byte) -5, (byte) 85, (byte) -97, (byte) -58, (byte) 68, (byte) 74, (byte) 69, (byte) 125, (byte) -30, (byte) 107, (byte) 92, (byte) 108, (byte) 102, (byte) -87, (byte) -116, (byte) -18, (byte) -124, (byte) 19, (byte) -89, (byte) 30, (byte) -99, (byte) -36, (byte) 103, (byte) 72, (byte) -70, (byte) 46, (byte) -26, (byte) -92, (byte) -85, (byte) 124, (byte) -108, (byte) 0, Framer.ENTER_FRAME_PREFIX, (byte) -17, (byte) -22, (byte) -66, (byte) -54, (byte) 114, (byte) 79, (byte) 82, (byte) -104, (byte) 63, (byte) -62, (byte) 20, (byte) 123, (byte) 59, (byte) 84};
    /* renamed from: c */
    private byte f27189c = (byte) -66;

    /* renamed from: b */
    public void mo5791b(byte[] bArr) {
        mo5790a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void mo5790a(byte[] bArr, int i, int i2) {
        synchronized (this.f27188b) {
            i2 += i;
            while (i != i2) {
                this.f27189c = this.f27188b[(this.f27189c + this.f27188b[this.f27187a & JfifUtil.MARKER_FIRST_BYTE]) & JfifUtil.MARKER_FIRST_BYTE];
                bArr[i] = this.f27188b[(this.f27188b[this.f27188b[this.f27189c & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE] + 1) & JfifUtil.MARKER_FIRST_BYTE];
                byte b = this.f27188b[this.f27187a & JfifUtil.MARKER_FIRST_BYTE];
                this.f27188b[this.f27187a & JfifUtil.MARKER_FIRST_BYTE] = this.f27188b[this.f27189c & JfifUtil.MARKER_FIRST_BYTE];
                this.f27188b[this.f27189c & JfifUtil.MARKER_FIRST_BYTE] = b;
                this.f27187a = (byte) ((this.f27187a + 1) & JfifUtil.MARKER_FIRST_BYTE);
                i++;
            }
        }
    }
}
