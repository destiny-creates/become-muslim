package org.spongycastle.crypto.params;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.CipherParameters;

public class RC5Parameters implements CipherParameters {
    /* renamed from: a */
    private byte[] f27141a;
    /* renamed from: b */
    private int f27142b;

    public RC5Parameters(byte[] bArr, int i) {
        if (bArr.length <= JfifUtil.MARKER_FIRST_BYTE) {
            this.f27141a = new byte[bArr.length];
            this.f27142b = i;
            System.arraycopy(bArr, 0, this.f27141a, 0, bArr.length);
            return;
        }
        throw new IllegalArgumentException("RC5 key length can be no greater than 255");
    }

    /* renamed from: a */
    public byte[] m35703a() {
        return this.f27141a;
    }

    /* renamed from: b */
    public int m35704b() {
        return this.f27142b;
    }
}
