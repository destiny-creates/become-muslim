package org.spongycastle.pqc.crypto.rainbow;

public class RainbowPublicKeyParameters extends RainbowKeyParameters {
    /* renamed from: b */
    private short[][] f32745b;
    /* renamed from: c */
    private short[][] f32746c;
    /* renamed from: d */
    private short[] f32747d;

    public RainbowPublicKeyParameters(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        super(false, i);
        this.f32745b = sArr;
        this.f32746c = sArr2;
        this.f32747d = sArr3;
    }

    /* renamed from: c */
    public short[][] m43478c() {
        return this.f32745b;
    }

    /* renamed from: d */
    public short[][] m43479d() {
        return this.f32746c;
    }

    /* renamed from: e */
    public short[] m43480e() {
        return this.f32747d;
    }
}
