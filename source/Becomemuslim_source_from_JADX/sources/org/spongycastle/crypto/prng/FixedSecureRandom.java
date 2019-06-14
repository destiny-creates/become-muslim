package org.spongycastle.crypto.prng;

import com.facebook.imageutils.JfifUtil;
import java.security.SecureRandom;

public class FixedSecureRandom extends SecureRandom {
    /* renamed from: a */
    private byte[] f22429a;
    /* renamed from: b */
    private int f22430b;
    /* renamed from: c */
    private int f22431c;

    public void nextBytes(byte[] bArr) {
        System.arraycopy(this.f22429a, this.f22430b, bArr, 0, bArr.length);
        this.f22430b += bArr.length;
    }

    public byte[] generateSeed(int i) {
        i = new byte[i];
        nextBytes(i);
        return i;
    }

    public int nextInt() {
        int a = ((m27508a() << 24) | 0) | (m27508a() << 16);
        if (this.f22431c == 2) {
            this.f22431c--;
        } else {
            a |= m27508a() << 8;
        }
        if (this.f22431c != 1) {
            return a | m27508a();
        }
        this.f22431c--;
        return a;
    }

    public long nextLong() {
        return ((((((((((long) m27508a()) << 56) | 0) | (((long) m27508a()) << 48)) | (((long) m27508a()) << 40)) | (((long) m27508a()) << 32)) | (((long) m27508a()) << 24)) | (((long) m27508a()) << 16)) | (((long) m27508a()) << 8)) | ((long) m27508a());
    }

    /* renamed from: a */
    private int m27508a() {
        byte[] bArr = this.f22429a;
        int i = this.f22430b;
        this.f22430b = i + 1;
        return bArr[i] & JfifUtil.MARKER_FIRST_BYTE;
    }
}
