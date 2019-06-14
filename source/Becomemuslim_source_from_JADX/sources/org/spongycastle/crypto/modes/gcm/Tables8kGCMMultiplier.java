package org.spongycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class Tables8kGCMMultiplier implements GCMMultiplier {
    /* renamed from: a */
    private byte[] f27059a;
    /* renamed from: b */
    private int[][][] f27060b;

    /* renamed from: a */
    public void mo5781a(byte[] bArr) {
        int i = 4;
        if (this.f27060b == null) {
            this.f27060b = (int[][][]) Array.newInstance(int.class, new int[]{32, 16, 4});
        } else if (Arrays.m29353a(this.f27059a, bArr)) {
            return;
        }
        this.f27059a = Arrays.m29373b(bArr);
        GCMUtil.m27481a(bArr, this.f27060b[1][8]);
        for (bArr = 4; bArr >= 1; bArr >>= 1) {
            GCMUtil.m27488b(this.f27060b[1][bArr + bArr], this.f27060b[1][bArr]);
        }
        int i2 = 0;
        GCMUtil.m27488b(this.f27060b[1][1], this.f27060b[0][8]);
        while (i >= 1) {
            GCMUtil.m27488b(this.f27060b[0][i + i], this.f27060b[0][i]);
            i >>= 1;
        }
        while (true) {
            for (bArr = 2; bArr < 16; bArr += bArr) {
                for (int i3 = 1; i3 < bArr; i3++) {
                    GCMUtil.m27484a(this.f27060b[i2][bArr], this.f27060b[i2][i3], this.f27060b[i2][bArr + i3]);
                }
            }
            i2++;
            if (i2 != 32) {
                if (i2 > 1) {
                    for (bArr = 8; bArr > null; bArr >>= 1) {
                        GCMUtil.m27490c(this.f27060b[i2 - 2][bArr], this.f27060b[i2][bArr]);
                    }
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
            int i2 = i + i;
            int[] iArr2 = this.f27060b[i2][bArr[i] & 15];
            iArr[0] = iArr[0] ^ iArr2[0];
            iArr[1] = iArr[1] ^ iArr2[1];
            iArr[2] = iArr[2] ^ iArr2[2];
            iArr[3] = iArr2[3] ^ iArr[3];
            iArr2 = this.f27060b[i2 + 1][(bArr[i] & 240) >>> 4];
            iArr[0] = iArr[0] ^ iArr2[0];
            iArr[1] = iArr[1] ^ iArr2[1];
            iArr[2] = iArr[2] ^ iArr2[2];
            iArr[3] = iArr[3] ^ iArr2[3];
        }
        Pack.m29403a(iArr, bArr, 0);
    }
}
