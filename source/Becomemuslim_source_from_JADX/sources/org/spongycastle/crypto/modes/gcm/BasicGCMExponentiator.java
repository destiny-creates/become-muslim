package org.spongycastle.crypto.modes.gcm;

import org.spongycastle.util.Arrays;

public class BasicGCMExponentiator implements GCMExponentiator {
    /* renamed from: a */
    private int[] f27054a;

    /* renamed from: a */
    public void mo5780a(byte[] bArr) {
        this.f27054a = GCMUtil.m27486a(bArr);
    }

    /* renamed from: a */
    public void mo5779a(long j, byte[] bArr) {
        int[] a = GCMUtil.m27485a();
        if (j > 0) {
            int[] b = Arrays.m29375b(this.f27054a);
            do {
                if ((1 & j) != 0) {
                    GCMUtil.m27483a(a, b);
                }
                GCMUtil.m27483a(b, b);
                j >>>= 1;
            } while (j > 0);
        }
        GCMUtil.m27482a(a, bArr);
    }
}
