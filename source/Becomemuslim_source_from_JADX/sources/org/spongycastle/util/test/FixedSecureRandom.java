package org.spongycastle.util.test;

import com.facebook.imageutils.JfifUtil;
import java.security.SecureRandom;

public class FixedSecureRandom extends SecureRandom {
    /* renamed from: a */
    private byte[] f23455a;
    /* renamed from: b */
    private int f23456b;
    /* renamed from: c */
    private int f23457c;

    public void nextBytes(byte[] bArr) {
        System.arraycopy(this.f23455a, this.f23456b, bArr, 0, bArr.length);
        this.f23456b += bArr.length;
    }

    public int nextInt() {
        int a = ((m29452a() << 24) | 0) | (m29452a() << 16);
        if (this.f23457c == 2) {
            this.f23457c--;
        } else {
            a |= m29452a() << 8;
        }
        if (this.f23457c != 1) {
            return a | m29452a();
        }
        this.f23457c--;
        return a;
    }

    public long nextLong() {
        return ((((((((((long) m29452a()) << 56) | 0) | (((long) m29452a()) << 48)) | (((long) m29452a()) << 40)) | (((long) m29452a()) << 32)) | (((long) m29452a()) << 24)) | (((long) m29452a()) << 16)) | (((long) m29452a()) << 8)) | ((long) m29452a());
    }

    /* renamed from: a */
    private int m29452a() {
        byte[] bArr = this.f23455a;
        int i = this.f23456b;
        this.f23456b = i + 1;
        return bArr[i] & JfifUtil.MARKER_FIRST_BYTE;
    }
}
