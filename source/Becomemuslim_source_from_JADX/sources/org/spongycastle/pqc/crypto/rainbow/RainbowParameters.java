package org.spongycastle.pqc.crypto.rainbow;

import org.spongycastle.crypto.CipherParameters;

public class RainbowParameters implements CipherParameters {
    /* renamed from: a */
    private final int[] f27813a;
    /* renamed from: b */
    private int[] f27814b;

    public RainbowParameters() {
        this.f27813a = new int[]{6, 12, 17, 22, 33};
        this.f27814b = this.f27813a;
    }

    public RainbowParameters(int[] iArr) {
        this.f27813a = new int[]{6, 12, 17, 22, 33};
        this.f27814b = iArr;
        try {
            m36418c();
        } catch (int[] iArr2) {
            iArr2.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m36418c() {
        if (this.f27814b == null) {
            throw new Exception("no layers defined.");
        } else if (this.f27814b.length > 1) {
            int i = 0;
            while (i < this.f27814b.length - 1) {
                int i2 = this.f27814b[i];
                i++;
                if (i2 >= this.f27814b[i]) {
                    throw new Exception("v[i] has to be smaller than v[i+1]");
                }
            }
        } else {
            throw new Exception("Rainbow needs at least 1 layer, such that v1 < v2.");
        }
    }

    /* renamed from: a */
    public int m36419a() {
        return this.f27814b.length - 1;
    }

    /* renamed from: b */
    public int[] m36420b() {
        return this.f27814b;
    }
}
