package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class McElieceCCA2PublicKeyParameters extends McElieceCCA2KeyParameters {
    /* renamed from: b */
    private String f32717b;
    /* renamed from: c */
    private int f32718c;
    /* renamed from: d */
    private int f32719d;
    /* renamed from: e */
    private GF2Matrix f32720e;

    public McElieceCCA2PublicKeyParameters(String str, int i, int i2, GF2Matrix gF2Matrix, McElieceCCA2Parameters mcElieceCCA2Parameters) {
        super(false, mcElieceCCA2Parameters);
        this.f32717b = str;
        this.f32718c = i;
        this.f32719d = i2;
        this.f32720e = new GF2Matrix(gF2Matrix);
    }

    /* renamed from: c */
    public int m43452c() {
        return this.f32718c;
    }

    /* renamed from: d */
    public int m43453d() {
        return this.f32719d;
    }

    /* renamed from: e */
    public GF2Matrix m43454e() {
        return this.f32720e;
    }

    /* renamed from: f */
    public int m43455f() {
        return this.f32720e.m29244g();
    }

    /* renamed from: g */
    public String m43456g() {
        return this.f32717b;
    }
}
