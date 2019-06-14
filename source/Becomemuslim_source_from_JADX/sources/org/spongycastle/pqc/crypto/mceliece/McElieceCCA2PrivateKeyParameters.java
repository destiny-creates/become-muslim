package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class McElieceCCA2PrivateKeyParameters extends McElieceCCA2KeyParameters {
    /* renamed from: b */
    private String f32709b;
    /* renamed from: c */
    private int f32710c;
    /* renamed from: d */
    private int f32711d;
    /* renamed from: e */
    private GF2mField f32712e;
    /* renamed from: f */
    private PolynomialGF2mSmallM f32713f;
    /* renamed from: g */
    private Permutation f32714g;
    /* renamed from: h */
    private GF2Matrix f32715h;
    /* renamed from: i */
    private PolynomialGF2mSmallM[] f32716i;

    public McElieceCCA2PrivateKeyParameters(String str, int i, int i2, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, GF2Matrix gF2Matrix, PolynomialGF2mSmallM[] polynomialGF2mSmallMArr, McElieceCCA2Parameters mcElieceCCA2Parameters) {
        super(true, mcElieceCCA2Parameters);
        this.f32709b = str;
        this.f32710c = i;
        this.f32711d = i2;
        this.f32712e = gF2mField;
        this.f32713f = polynomialGF2mSmallM;
        this.f32714g = permutation;
        this.f32715h = gF2Matrix;
        this.f32716i = polynomialGF2mSmallMArr;
    }

    /* renamed from: c */
    public int m43443c() {
        return this.f32710c;
    }

    /* renamed from: d */
    public int m43444d() {
        return this.f32711d;
    }

    /* renamed from: e */
    public int m43445e() {
        return this.f32713f.m29266a();
    }

    /* renamed from: f */
    public GF2mField m43446f() {
        return this.f32712e;
    }

    /* renamed from: g */
    public PolynomialGF2mSmallM m43447g() {
        return this.f32713f;
    }

    /* renamed from: h */
    public Permutation m43448h() {
        return this.f32714g;
    }

    /* renamed from: i */
    public GF2Matrix m43449i() {
        return this.f32715h;
    }

    /* renamed from: j */
    public PolynomialGF2mSmallM[] m43450j() {
        return this.f32716i;
    }

    /* renamed from: k */
    public String m43451k() {
        return this.f32709b;
    }
}
