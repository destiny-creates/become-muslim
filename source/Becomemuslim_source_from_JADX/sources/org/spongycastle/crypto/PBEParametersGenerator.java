package org.spongycastle.crypto;

import org.spongycastle.util.Strings;

public abstract class PBEParametersGenerator {
    /* renamed from: a */
    protected byte[] f22204a;
    /* renamed from: b */
    protected byte[] f22205b;
    /* renamed from: c */
    protected int f22206c;

    /* renamed from: a */
    public abstract CipherParameters mo5758a(int i);

    /* renamed from: a */
    public abstract CipherParameters mo5759a(int i, int i2);

    /* renamed from: b */
    public abstract CipherParameters mo5760b(int i);

    protected PBEParametersGenerator() {
    }

    /* renamed from: a */
    public void m27339a(byte[] bArr, byte[] bArr2, int i) {
        this.f22204a = bArr;
        this.f22205b = bArr2;
        this.f22206c = i;
    }

    /* renamed from: a */
    public static byte[] m27334a(char[] cArr) {
        int i = 0;
        if (cArr == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[cArr.length];
        while (i != bArr.length) {
            bArr[i] = (byte) cArr[i];
            i++;
        }
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m27335b(char[] cArr) {
        if (cArr != null) {
            return Strings.m29422a(cArr);
        }
        return new byte[null];
    }

    /* renamed from: c */
    public static byte[] m27336c(char[] cArr) {
        int i = 0;
        if (cArr == null || cArr.length <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[((cArr.length + 1) * 2)];
        while (i != cArr.length) {
            int i2 = i * 2;
            bArr[i2] = (byte) (cArr[i] >>> 8);
            bArr[i2 + 1] = (byte) cArr[i];
            i++;
        }
        return bArr;
    }
}
