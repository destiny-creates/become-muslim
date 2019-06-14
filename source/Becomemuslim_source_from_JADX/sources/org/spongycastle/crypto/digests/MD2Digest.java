package org.spongycastle.crypto.digests;

import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.dumpapp.Framer;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Memoable;

public class MD2Digest implements ExtendedDigest, Memoable {
    /* renamed from: g */
    private static final byte[] f31613g = new byte[]{(byte) 41, (byte) 46, (byte) 67, (byte) -55, (byte) -94, (byte) -40, (byte) 124, (byte) 1, (byte) 61, (byte) 54, (byte) 84, (byte) -95, (byte) -20, (byte) -16, (byte) 6, (byte) 19, (byte) 98, (byte) -89, (byte) 5, (byte) -13, (byte) -64, (byte) -57, (byte) 115, (byte) -116, (byte) -104, (byte) -109, (byte) 43, (byte) -39, (byte) -68, (byte) 76, (byte) -126, (byte) -54, (byte) 30, (byte) -101, (byte) 87, (byte) 60, (byte) -3, (byte) -44, (byte) -32, (byte) 22, (byte) 103, (byte) 66, (byte) 111, (byte) 24, (byte) -118, (byte) 23, (byte) -27, (byte) 18, (byte) -66, (byte) 78, (byte) -60, (byte) -42, (byte) -38, (byte) -98, (byte) -34, (byte) 73, (byte) -96, (byte) -5, (byte) -11, (byte) -114, (byte) -69, (byte) 47, (byte) -18, (byte) 122, (byte) -87, (byte) 104, (byte) 121, (byte) -111, (byte) 21, (byte) -78, (byte) 7, (byte) 63, (byte) -108, (byte) -62, (byte) 16, (byte) -119, (byte) 11, (byte) 34, Framer.STDIN_REQUEST_FRAME_PREFIX, Framer.ENTER_FRAME_PREFIX, Byte.MIN_VALUE, Byte.MAX_VALUE, (byte) 93, (byte) -102, (byte) 90, (byte) -112, Framer.STDERR_FRAME_PREFIX, (byte) 39, (byte) 53, (byte) 62, (byte) -52, (byte) -25, (byte) -65, (byte) -9, (byte) -105, (byte) 3, (byte) -1, (byte) 25, (byte) 48, (byte) -77, (byte) 72, (byte) -91, (byte) -75, (byte) -47, (byte) -41, (byte) 94, (byte) -110, (byte) 42, (byte) -84, (byte) 86, (byte) -86, (byte) -58, (byte) 79, (byte) -72, (byte) 56, (byte) -46, (byte) -106, (byte) -92, (byte) 125, (byte) -74, (byte) 118, (byte) -4, (byte) 107, (byte) -30, (byte) -100, (byte) 116, (byte) 4, (byte) -15, (byte) 69, (byte) -99, (byte) 112, (byte) 89, (byte) 100, (byte) 113, (byte) -121, (byte) 32, (byte) -122, (byte) 91, (byte) -49, (byte) 101, (byte) -26, Framer.STDIN_FRAME_PREFIX, (byte) -88, (byte) 2, (byte) 27, (byte) 96, (byte) 37, (byte) -83, (byte) -82, (byte) -80, (byte) -71, (byte) -10, (byte) 28, (byte) 70, (byte) 97, (byte) 105, (byte) 52, (byte) 64, (byte) 126, (byte) 15, (byte) 85, (byte) 71, (byte) -93, (byte) 35, (byte) -35, (byte) 81, (byte) -81, (byte) 58, (byte) -61, (byte) 92, (byte) -7, (byte) -50, (byte) -70, (byte) -59, (byte) -22, (byte) 38, (byte) 44, (byte) 83, (byte) 13, (byte) 110, (byte) -123, (byte) 40, (byte) -124, (byte) 9, (byte) -45, (byte) -33, (byte) -51, (byte) -12, (byte) 65, (byte) -127, (byte) 77, (byte) 82, (byte) 106, (byte) -36, (byte) 55, (byte) -56, (byte) 108, (byte) -63, (byte) -85, (byte) -6, (byte) 36, (byte) -31, (byte) 123, (byte) 8, (byte) 12, (byte) -67, (byte) -79, (byte) 74, Framer.EXIT_FRAME_PREFIX, (byte) -120, (byte) -107, (byte) -117, (byte) -29, (byte) 99, (byte) -24, (byte) 109, (byte) -23, (byte) -53, (byte) -43, (byte) -2, (byte) 59, (byte) 0, (byte) 29, (byte) 57, (byte) -14, (byte) -17, (byte) -73, (byte) 14, (byte) 102, (byte) 88, (byte) -48, (byte) -28, (byte) -90, (byte) 119, (byte) 114, (byte) -8, (byte) -21, (byte) 117, (byte) 75, (byte) 10, Framer.STDOUT_FRAME_PREFIX, (byte) 68, (byte) 80, (byte) -76, (byte) -113, (byte) -19, (byte) 31, (byte) 26, (byte) -37, (byte) -103, (byte) -115, (byte) 51, (byte) -97, (byte) 17, (byte) -125, (byte) 20};
    /* renamed from: a */
    private byte[] f31614a;
    /* renamed from: b */
    private int f31615b;
    /* renamed from: c */
    private byte[] f31616c;
    /* renamed from: d */
    private int f31617d;
    /* renamed from: e */
    private byte[] f31618e;
    /* renamed from: f */
    private int f31619f;

    /* renamed from: a */
    public String mo5729a() {
        return "MD2";
    }

    /* renamed from: b */
    public int mo5732b() {
        return 16;
    }

    /* renamed from: d */
    public int mo6445d() {
        return 16;
    }

    public MD2Digest() {
        this.f31614a = new byte[48];
        this.f31616c = new byte[16];
        this.f31618e = new byte[16];
        mo5733c();
    }

    public MD2Digest(MD2Digest mD2Digest) {
        this.f31614a = new byte[48];
        this.f31616c = new byte[16];
        this.f31618e = new byte[16];
        m40619a(mD2Digest);
    }

    /* renamed from: a */
    private void m40619a(MD2Digest mD2Digest) {
        System.arraycopy(mD2Digest.f31614a, 0, this.f31614a, 0, mD2Digest.f31614a.length);
        this.f31615b = mD2Digest.f31615b;
        System.arraycopy(mD2Digest.f31616c, 0, this.f31616c, 0, mD2Digest.f31616c.length);
        this.f31617d = mD2Digest.f31617d;
        System.arraycopy(mD2Digest.f31618e, 0, this.f31618e, 0, mD2Digest.f31618e.length);
        this.f31619f = mD2Digest.f31619f;
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        byte length = (byte) (this.f31616c.length - this.f31617d);
        for (int i2 = this.f31617d; i2 < this.f31616c.length; i2++) {
            this.f31616c[i2] = length;
        }
        m40624a(this.f31616c);
        m40627b(this.f31616c);
        m40627b(this.f31618e);
        System.arraycopy(this.f31614a, this.f31615b, bArr, i, 16);
        mo5733c();
        return 16;
    }

    /* renamed from: c */
    public void mo5733c() {
        int i;
        this.f31615b = 0;
        for (i = 0; i != this.f31614a.length; i++) {
            this.f31614a[i] = (byte) 0;
        }
        this.f31617d = 0;
        for (i = 0; i != this.f31616c.length; i++) {
            this.f31616c[i] = (byte) 0;
        }
        this.f31619f = 0;
        for (i = 0; i != this.f31618e.length; i++) {
            this.f31618e[i] = (byte) 0;
        }
    }

    /* renamed from: a */
    public void mo5730a(byte b) {
        byte[] bArr = this.f31616c;
        int i = this.f31617d;
        this.f31617d = i + 1;
        bArr[i] = b;
        if (this.f31617d == (byte) 16) {
            m40624a(this.f31616c);
            m40627b(this.f31616c);
            this.f31617d = (byte) 0;
        }
    }

    /* renamed from: a */
    public void mo5731a(byte[] bArr, int i, int i2) {
        while (this.f31617d != 0 && i2 > 0) {
            mo5730a(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > 16) {
            System.arraycopy(bArr, i, this.f31616c, 0, 16);
            m40624a(this.f31616c);
            m40627b(this.f31616c);
            i2 -= 16;
            i += 16;
        }
        while (i2 > 0) {
            mo5730a(bArr[i]);
            i++;
            i2--;
        }
    }

    /* renamed from: a */
    protected void m40624a(byte[] bArr) {
        int i = this.f31618e[15];
        for (int i2 = 0; i2 < 16; i2++) {
            byte[] bArr2 = this.f31618e;
            bArr2[i2] = (byte) (f31613g[(i ^ bArr[i2]) & JfifUtil.MARKER_FIRST_BYTE] ^ bArr2[i2]);
            i = this.f31618e[i2];
        }
    }

    /* renamed from: b */
    protected void m40627b(byte[] bArr) {
        int i;
        for (i = 0; i < 16; i++) {
            this.f31614a[i + 16] = bArr[i];
            this.f31614a[i + 32] = (byte) (bArr[i] ^ this.f31614a[i]);
        }
        i = 0;
        for (bArr = null; bArr < 18; bArr++) {
            int i2 = i;
            for (i = 0; i < 48; i++) {
                byte[] bArr2 = this.f31614a;
                byte b = (byte) (f31613g[i2] ^ bArr2[i]);
                bArr2[i] = b;
                i2 = b & JfifUtil.MARKER_FIRST_BYTE;
            }
            i = (i2 + bArr) % 256;
        }
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new MD2Digest(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        m40619a((MD2Digest) memoable);
    }
}
