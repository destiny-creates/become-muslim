package org.spongycastle.crypto.prng;

import org.spongycastle.crypto.BlockCipher;

public class X931RNG {
    /* renamed from: a */
    private final BlockCipher f22443a;
    /* renamed from: b */
    private final EntropySource f22444b;
    /* renamed from: c */
    private final byte[] f22445c;
    /* renamed from: d */
    private final byte[] f22446d;
    /* renamed from: e */
    private final byte[] f22447e;
    /* renamed from: f */
    private byte[] f22448f;
    /* renamed from: g */
    private long f22449g;

    /* renamed from: a */
    int m27514a(byte[] bArr, boolean z) {
        if (this.f22447e.length == 8) {
            if (this.f22449g > 32768) {
                return -1;
            }
            if (m27513a(bArr, 512)) {
                throw new IllegalArgumentException("Number of bits per request limited to 4096");
            }
        } else if (this.f22449g > 8388608) {
            return -1;
        } else {
            if (m27513a(bArr, 32768)) {
                throw new IllegalArgumentException("Number of bits per request limited to 262144");
            }
        }
        if (z || !this.f22448f) {
            this.f22448f = this.f22444b.mo5788a();
            if (this.f22448f.length != this.f22443a.mo5743b()) {
                throw new IllegalStateException("Insufficient entropy returned");
            }
        }
        z = bArr.length / this.f22447e.length;
        for (boolean z2 = false; z2 < z; z2++) {
            this.f22443a.mo5740a(this.f22445c, 0, this.f22446d, 0);
            m27512a(this.f22447e, this.f22446d, this.f22448f);
            m27512a(this.f22448f, this.f22447e, this.f22446d);
            System.arraycopy(this.f22447e, 0, bArr, this.f22447e.length * z2, this.f22447e.length);
            m27511a(this.f22445c);
        }
        int length = bArr.length - (this.f22447e.length * z);
        if (length > 0) {
            this.f22443a.mo5740a(this.f22445c, 0, this.f22446d, 0);
            m27512a(this.f22447e, this.f22446d, this.f22448f);
            m27512a(this.f22448f, this.f22447e, this.f22446d);
            System.arraycopy(this.f22447e, 0, bArr, z * this.f22447e.length, length);
            m27511a(this.f22445c);
        }
        this.f22449g++;
        return bArr.length;
    }

    /* renamed from: a */
    void m27515a() {
        this.f22448f = this.f22444b.mo5788a();
        if (this.f22448f.length == this.f22443a.mo5743b()) {
            this.f22449g = 1;
            return;
        }
        throw new IllegalStateException("Insufficient entropy returned");
    }

    /* renamed from: a */
    private void m27512a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = (byte) (bArr2[i] ^ bArr3[i]);
        }
        this.f22443a.mo5740a(bArr, 0, bArr, 0);
    }

    /* renamed from: a */
    private void m27511a(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0) {
            byte b = (byte) (bArr[length] + 1);
            bArr[length] = b;
            if (b == (byte) 0) {
                length--;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private static boolean m27513a(byte[] bArr, int i) {
        return (bArr == null || bArr.length <= i) ? null : 1;
    }
}
