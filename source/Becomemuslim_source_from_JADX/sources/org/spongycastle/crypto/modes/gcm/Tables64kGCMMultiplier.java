package org.spongycastle.crypto.modes.gcm;

import com.facebook.imageutils.JfifUtil;
import java.lang.reflect.Array;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class Tables64kGCMMultiplier implements GCMMultiplier {
    /* renamed from: a */
    private byte[] f27057a;
    /* renamed from: b */
    private int[][][] f27058b;

    /* renamed from: a */
    public void mo5781a(byte[] bArr) {
        if (this.f27058b == null) {
            this.f27058b = (int[][][]) Array.newInstance(int.class, new int[]{16, 256, 4});
        } else if (Arrays.m29353a(this.f27057a, bArr)) {
            return;
        }
        this.f27057a = Arrays.m29373b(bArr);
        int i = 0;
        GCMUtil.m27481a(bArr, this.f27058b[0][128]);
        for (bArr = 64; bArr >= 1; bArr >>= 1) {
            GCMUtil.m27488b(this.f27058b[0][bArr + bArr], this.f27058b[0][bArr]);
        }
        while (true) {
            for (bArr = 2; bArr < 256; bArr += bArr) {
                for (int i2 = 1; i2 < bArr; i2++) {
                    GCMUtil.m27484a(this.f27058b[i][bArr], this.f27058b[i][i2], this.f27058b[i][bArr + i2]);
                }
            }
            i++;
            if (i != 16) {
                for (bArr = 128; bArr > null; bArr >>= 1) {
                    GCMUtil.m27490c(this.f27058b[i - 1][bArr], this.f27058b[i][bArr]);
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public void mo5782b(byte[] bArr) {
        int[] iArr = new int[4];
        for (int i = 15; i >= 0; i--) {
            int[] iArr2 = this.f27058b[i][bArr[i] & JfifUtil.MARKER_FIRST_BYTE];
            iArr[0] = iArr[0] ^ iArr2[0];
            iArr[1] = iArr[1] ^ iArr2[1];
            iArr[2] = iArr[2] ^ iArr2[2];
            iArr[3] = iArr2[3] ^ iArr[3];
        }
        Pack.m29403a(iArr, bArr, 0);
    }
}
