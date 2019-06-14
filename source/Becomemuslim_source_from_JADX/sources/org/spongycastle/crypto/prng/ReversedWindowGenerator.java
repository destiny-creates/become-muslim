package org.spongycastle.crypto.prng;

public class ReversedWindowGenerator implements RandomGenerator {
    /* renamed from: a */
    private final RandomGenerator f27162a;
    /* renamed from: b */
    private byte[] f27163b;
    /* renamed from: c */
    private int f27164c;

    /* renamed from: b */
    public void mo5791b(byte[] bArr) {
        m35726b(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void mo5790a(byte[] bArr, int i, int i2) {
        m35726b(bArr, i, i2);
    }

    /* renamed from: b */
    private void m35726b(byte[] bArr, int i, int i2) {
        synchronized (this) {
            int i3 = 0;
            while (i3 < i2) {
                if (this.f27164c < 1) {
                    this.f27162a.mo5790a(this.f27163b, 0, this.f27163b.length);
                    this.f27164c = this.f27163b.length;
                }
                int i4 = i3 + 1;
                i3 += i;
                byte[] bArr2 = this.f27163b;
                int i5 = this.f27164c - 1;
                this.f27164c = i5;
                bArr[i3] = bArr2[i5];
                i3 = i4;
            }
        }
    }
}
