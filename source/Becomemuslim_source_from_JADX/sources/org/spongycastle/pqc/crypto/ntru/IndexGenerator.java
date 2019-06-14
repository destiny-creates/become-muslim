package org.spongycastle.pqc.crypto.ntru;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.Digest;

public class IndexGenerator {
    /* renamed from: a */
    private byte[] f23259a;
    /* renamed from: b */
    private int f23260b;
    /* renamed from: c */
    private int f23261c;
    /* renamed from: d */
    private int f23262d;
    /* renamed from: e */
    private int f23263e = 0;
    /* renamed from: f */
    private int f23264f = 0;
    /* renamed from: g */
    private BitString f23265g;
    /* renamed from: h */
    private int f23266h = 0;
    /* renamed from: i */
    private boolean f23267i;
    /* renamed from: j */
    private Digest f23268j;
    /* renamed from: k */
    private int f23269k;

    public static class BitString {
        /* renamed from: a */
        byte[] f23256a = new byte[4];
        /* renamed from: b */
        int f23257b;
        /* renamed from: c */
        int f23258c;

        /* renamed from: a */
        void m29094a(byte[] bArr) {
            for (int i = 0; i != bArr.length; i++) {
                m29093a(bArr[i]);
            }
        }

        /* renamed from: a */
        public void m29093a(byte b) {
            if (this.f23257b == this.f23256a.length) {
                this.f23256a = IndexGenerator.m29099b(this.f23256a, this.f23256a.length * 2);
            }
            if (this.f23257b == 0) {
                this.f23257b = 1;
                this.f23256a[0] = b;
                this.f23258c = 8;
            } else if (this.f23258c == 8) {
                r0 = this.f23256a;
                r1 = this.f23257b;
                this.f23257b = r1 + 1;
                r0[r1] = b;
            } else {
                r1 = 8 - this.f23258c;
                r0 = this.f23256a;
                int i = this.f23257b - 1;
                b &= JfifUtil.MARKER_FIRST_BYTE;
                r0[i] = (byte) (r0[i] | (b << this.f23258c));
                r0 = this.f23256a;
                int i2 = this.f23257b;
                this.f23257b = i2 + 1;
                r0[i2] = (byte) (b >> r1);
            }
        }

        /* renamed from: a */
        public BitString m29092a(int i) {
            BitString bitString = new BitString();
            bitString.f23257b = (i + 7) / 8;
            bitString.f23256a = new byte[bitString.f23257b];
            for (int i2 = 0; i2 < bitString.f23257b; i2++) {
                bitString.f23256a[i2] = this.f23256a[i2];
            }
            bitString.f23258c = i % 8;
            if (bitString.f23258c == 0) {
                bitString.f23258c = 8;
            } else {
                i = 32 - bitString.f23258c;
                bitString.f23256a[bitString.f23257b - 1] = (byte) ((bitString.f23256a[bitString.f23257b - 1] << i) >>> i);
            }
            return bitString;
        }

        /* renamed from: b */
        public int m29095b(int i) {
            int i2 = (((this.f23257b - 1) * 8) + this.f23258c) - i;
            i = i2 / 8;
            i2 %= 8;
            int i3 = (this.f23256a[i] & JfifUtil.MARKER_FIRST_BYTE) >>> i2;
            i2 = 8 - i2;
            while (true) {
                i++;
                if (i >= this.f23257b) {
                    return i3;
                }
                i3 |= (this.f23256a[i] & JfifUtil.MARKER_FIRST_BYTE) << i2;
                i2 += 8;
            }
        }
    }

    IndexGenerator(byte[] bArr, NTRUEncryptionParameters nTRUEncryptionParameters) {
        this.f23259a = bArr;
        this.f23260b = nTRUEncryptionParameters.f23271a;
        this.f23261c = nTRUEncryptionParameters.f23289s;
        this.f23262d = nTRUEncryptionParameters.f23290t;
        this.f23268j = nTRUEncryptionParameters.f23270A;
        this.f23269k = this.f23268j.mo5732b();
        this.f23267i = false;
    }

    /* renamed from: a */
    int m29100a() {
        int b;
        if (!this.f23267i) {
            this.f23265g = new BitString();
            byte[] bArr = new byte[this.f23268j.mo5732b()];
            while (this.f23266h < this.f23262d) {
                m29097a(this.f23265g, bArr);
                this.f23266h++;
            }
            this.f23263e = (this.f23262d * 8) * this.f23269k;
            this.f23264f = this.f23263e;
            this.f23267i = true;
        }
        do {
            this.f23263e += this.f23261c;
            BitString a = this.f23265g.m29092a(this.f23264f);
            if (this.f23264f < this.f23261c) {
                int i = this.f23261c - this.f23264f;
                int i2 = this.f23266h + (((this.f23269k + i) - 1) / this.f23269k);
                byte[] bArr2 = new byte[this.f23268j.mo5732b()];
                while (this.f23266h < i2) {
                    m29097a(a, bArr2);
                    this.f23266h++;
                    if (i > this.f23269k * 8) {
                        i -= this.f23269k * 8;
                    }
                }
                this.f23264f = (this.f23269k * 8) - i;
                this.f23265g = new BitString();
                this.f23265g.m29094a(bArr2);
            } else {
                this.f23264f -= this.f23261c;
            }
            b = a.m29095b(this.f23261c);
        } while (b >= (1 << this.f23261c) - ((1 << this.f23261c) % this.f23260b));
        return b % this.f23260b;
    }

    /* renamed from: a */
    private void m29097a(BitString bitString, byte[] bArr) {
        this.f23268j.mo5731a(this.f23259a, 0, this.f23259a.length);
        m29096a(this.f23268j, this.f23266h);
        this.f23268j.mo5728a(bArr, 0);
        bitString.m29094a(bArr);
    }

    /* renamed from: a */
    private void m29096a(Digest digest, int i) {
        digest.mo5730a((byte) (i >> 24));
        digest.mo5730a((byte) (i >> 16));
        digest.mo5730a((byte) (i >> 8));
        digest.mo5730a((byte) i);
    }

    /* renamed from: b */
    private static byte[] m29099b(byte[] bArr, int i) {
        Object obj = new byte[i];
        if (i >= bArr.length) {
            i = bArr.length;
        }
        System.arraycopy(bArr, 0, obj, 0, i);
        return obj;
    }
}
