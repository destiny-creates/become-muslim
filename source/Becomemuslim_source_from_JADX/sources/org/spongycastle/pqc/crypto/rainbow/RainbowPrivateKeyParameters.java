package org.spongycastle.pqc.crypto.rainbow;

public class RainbowPrivateKeyParameters extends RainbowKeyParameters {
    /* renamed from: b */
    private short[][] f32739b;
    /* renamed from: c */
    private short[] f32740c;
    /* renamed from: d */
    private short[][] f32741d;
    /* renamed from: e */
    private short[] f32742e;
    /* renamed from: f */
    private int[] f32743f;
    /* renamed from: g */
    private Layer[] f32744g;

    public RainbowPrivateKeyParameters(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, Layer[] layerArr) {
        super(true, iArr[iArr.length - 1] - iArr[0]);
        this.f32739b = sArr;
        this.f32740c = sArr2;
        this.f32741d = sArr3;
        this.f32742e = sArr4;
        this.f32743f = iArr;
        this.f32744g = layerArr;
    }

    /* renamed from: c */
    public short[] m43472c() {
        return this.f32740c;
    }

    /* renamed from: d */
    public short[][] m43473d() {
        return this.f32739b;
    }

    /* renamed from: e */
    public short[] m43474e() {
        return this.f32742e;
    }

    /* renamed from: f */
    public short[][] m43475f() {
        return this.f32741d;
    }

    /* renamed from: g */
    public Layer[] m43476g() {
        return this.f32744g;
    }

    /* renamed from: h */
    public int[] m43477h() {
        return this.f32743f;
    }
}
