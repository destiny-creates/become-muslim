package org.spongycastle.pqc.crypto.gmss.util;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.Digest;

public class GMSSRandom {
    /* renamed from: a */
    private Digest f23243a;

    public GMSSRandom(Digest digest) {
        this.f23243a = digest;
    }

    /* renamed from: a */
    public byte[] m29078a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        this.f23243a.mo5731a(bArr, 0, bArr.length);
        bArr2 = new byte[this.f23243a.mo5732b()];
        this.f23243a.mo5728a(bArr2, 0);
        m29076a(bArr, bArr2);
        m29077b(bArr);
        return bArr2;
    }

    /* renamed from: a */
    private void m29076a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = ((bArr[i2] & JfifUtil.MARKER_FIRST_BYTE) + (bArr2[i2] & JfifUtil.MARKER_FIRST_BYTE)) + i;
            bArr[i2] = (byte) i3;
            i = (byte) (i3 >> 8);
        }
    }

    /* renamed from: b */
    private void m29077b(byte[] bArr) {
        int i = 1;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = (bArr[i2] & JfifUtil.MARKER_FIRST_BYTE) + i;
            bArr[i2] = (byte) i3;
            i = (byte) (i3 >> 8);
        }
    }
}
