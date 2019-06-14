package org.spongycastle.crypto.modes.gcm;

import java.util.Vector;
import org.spongycastle.util.Arrays;

public class Tables1kGCMExponentiator implements GCMExponentiator {
    /* renamed from: a */
    private Vector f27056a;

    /* renamed from: a */
    public void mo5780a(byte[] bArr) {
        int[] a = GCMUtil.m27486a(bArr);
        if (this.f27056a == null || !Arrays.m29356a(a, (int[]) this.f27056a.elementAt(0))) {
            this.f27056a = new Vector(8);
            this.f27056a.addElement(a);
        }
    }

    /* renamed from: a */
    public void mo5779a(long j, byte[] bArr) {
        int[] a = GCMUtil.m27485a();
        int i = 0;
        while (j > 0) {
            if ((1 & j) != 0) {
                m35596a(i);
                GCMUtil.m27483a(a, (int[]) this.f27056a.elementAt(i));
            }
            i++;
            j >>>= 1;
        }
        GCMUtil.m27482a(a, bArr);
    }

    /* renamed from: a */
    private void m35596a(int i) {
        int size = this.f27056a.size();
        if (size <= i) {
            int[] iArr = (int[]) this.f27056a.elementAt(size - 1);
            do {
                iArr = Arrays.m29375b(iArr);
                GCMUtil.m27483a(iArr, iArr);
                this.f27056a.addElement(iArr);
                size++;
            } while (size <= i);
        }
    }
}
