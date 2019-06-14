package org.spongycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.util.Arrays;

public class IESParameterSpec implements AlgorithmParameterSpec {
    /* renamed from: a */
    private byte[] f23066a;
    /* renamed from: b */
    private byte[] f23067b;
    /* renamed from: c */
    private int f23068c;
    /* renamed from: d */
    private int f23069d;
    /* renamed from: e */
    private byte[] f23070e;
    /* renamed from: f */
    private boolean f23071f;

    public IESParameterSpec(byte[] bArr, byte[] bArr2, int i) {
        this(bArr, bArr2, i, -1, null, false);
    }

    public IESParameterSpec(byte[] bArr, byte[] bArr2, int i, int i2) {
        this(bArr, bArr2, i, i2, null, false);
    }

    public IESParameterSpec(byte[] bArr, byte[] bArr2, int i, int i2, byte[] bArr3, boolean z) {
        if (bArr != null) {
            this.f23066a = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f23066a, 0, bArr.length);
        } else {
            this.f23066a = null;
        }
        if (bArr2 != null) {
            this.f23067b = new byte[bArr2.length];
            System.arraycopy(bArr2, 0, this.f23067b, 0, bArr2.length);
        } else {
            this.f23067b = null;
        }
        this.f23068c = i;
        this.f23069d = i2;
        this.f23070e = Arrays.m29373b(bArr3);
        this.f23071f = z;
    }

    /* renamed from: a */
    public byte[] m28334a() {
        return Arrays.m29373b(this.f23066a);
    }

    /* renamed from: b */
    public byte[] m28335b() {
        return Arrays.m29373b(this.f23067b);
    }

    /* renamed from: c */
    public int m28336c() {
        return this.f23068c;
    }

    /* renamed from: d */
    public int m28337d() {
        return this.f23069d;
    }

    /* renamed from: e */
    public byte[] m28338e() {
        return Arrays.m29373b(this.f23070e);
    }

    /* renamed from: f */
    public boolean m28339f() {
        return this.f23071f;
    }
}
