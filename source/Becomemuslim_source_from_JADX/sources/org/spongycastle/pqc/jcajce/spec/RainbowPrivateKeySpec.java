package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.spongycastle.pqc.crypto.rainbow.Layer;

public class RainbowPrivateKeySpec implements KeySpec {
    /* renamed from: a */
    private short[][] f23353a;
    /* renamed from: b */
    private short[] f23354b;
    /* renamed from: c */
    private short[][] f23355c;
    /* renamed from: d */
    private short[] f23356d;
    /* renamed from: e */
    private int[] f23357e;
    /* renamed from: f */
    private Layer[] f23358f;

    public RainbowPrivateKeySpec(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, Layer[] layerArr) {
        this.f23353a = sArr;
        this.f23354b = sArr2;
        this.f23355c = sArr3;
        this.f23356d = sArr4;
        this.f23357e = iArr;
        this.f23358f = layerArr;
    }

    /* renamed from: a */
    public short[] m29171a() {
        return this.f23354b;
    }

    /* renamed from: b */
    public short[][] m29172b() {
        return this.f23353a;
    }

    /* renamed from: c */
    public short[] m29173c() {
        return this.f23356d;
    }

    /* renamed from: d */
    public short[][] m29174d() {
        return this.f23355c;
    }

    /* renamed from: e */
    public Layer[] m29175e() {
        return this.f23358f;
    }

    /* renamed from: f */
    public int[] m29176f() {
        return this.f23357e;
    }
}
