package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKeyParameters extends McElieceKeyParameters {
    /* renamed from: b */
    private String f32731b;
    /* renamed from: c */
    private int f32732c;
    /* renamed from: d */
    private int f32733d;
    /* renamed from: e */
    private GF2Matrix f32734e;

    public McEliecePublicKeyParameters(String str, int i, int i2, GF2Matrix gF2Matrix, McElieceParameters mcElieceParameters) {
        super(false, mcElieceParameters);
        this.f32731b = str;
        this.f32732c = i;
        this.f32733d = i2;
        this.f32734e = new GF2Matrix(gF2Matrix);
    }

    /* renamed from: c */
    public int m43467c() {
        return this.f32732c;
    }

    /* renamed from: d */
    public int m43468d() {
        return this.f32733d;
    }

    /* renamed from: e */
    public GF2Matrix m43469e() {
        return this.f32734e;
    }

    /* renamed from: f */
    public String m43470f() {
        return this.f32731b;
    }

    /* renamed from: g */
    public int m43471g() {
        return this.f32734e.m29244g();
    }
}
