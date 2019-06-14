package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;

public class RainbowPublicKeySpec implements KeySpec {
    /* renamed from: a */
    private short[][] f23359a;
    /* renamed from: b */
    private short[][] f23360b;
    /* renamed from: c */
    private short[] f23361c;
    /* renamed from: d */
    private int f23362d;

    public RainbowPublicKeySpec(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f23362d = i;
        this.f23359a = sArr;
        this.f23360b = sArr2;
        this.f23361c = sArr3;
    }

    /* renamed from: a */
    public int m29177a() {
        return this.f23362d;
    }

    /* renamed from: b */
    public short[][] m29178b() {
        return this.f23359a;
    }

    /* renamed from: c */
    public short[][] m29179c() {
        return this.f23360b;
    }

    /* renamed from: d */
    public short[] m29180d() {
        return this.f23361c;
    }
}
