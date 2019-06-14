package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class McEliecePrivateKeyParameters extends McElieceKeyParameters {
    /* renamed from: b */
    private String f32721b;
    /* renamed from: c */
    private int f32722c;
    /* renamed from: d */
    private int f32723d;
    /* renamed from: e */
    private GF2mField f32724e;
    /* renamed from: f */
    private PolynomialGF2mSmallM f32725f;
    /* renamed from: g */
    private GF2Matrix f32726g;
    /* renamed from: h */
    private Permutation f32727h;
    /* renamed from: i */
    private Permutation f32728i;
    /* renamed from: j */
    private GF2Matrix f32729j;
    /* renamed from: k */
    private PolynomialGF2mSmallM[] f32730k;

    public McEliecePrivateKeyParameters(String str, int i, int i2, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, GF2Matrix gF2Matrix, Permutation permutation, Permutation permutation2, GF2Matrix gF2Matrix2, PolynomialGF2mSmallM[] polynomialGF2mSmallMArr, McElieceParameters mcElieceParameters) {
        super(true, mcElieceParameters);
        this.f32721b = str;
        this.f32723d = i2;
        this.f32722c = i;
        this.f32724e = gF2mField;
        this.f32725f = polynomialGF2mSmallM;
        this.f32726g = gF2Matrix;
        this.f32727h = permutation;
        this.f32728i = permutation2;
        this.f32729j = gF2Matrix2;
        this.f32730k = polynomialGF2mSmallMArr;
    }

    /* renamed from: c */
    public int m43457c() {
        return this.f32722c;
    }

    /* renamed from: d */
    public int m43458d() {
        return this.f32723d;
    }

    /* renamed from: e */
    public GF2mField m43459e() {
        return this.f32724e;
    }

    /* renamed from: f */
    public PolynomialGF2mSmallM m43460f() {
        return this.f32725f;
    }

    /* renamed from: g */
    public GF2Matrix m43461g() {
        return this.f32726g;
    }

    /* renamed from: h */
    public Permutation m43462h() {
        return this.f32727h;
    }

    /* renamed from: i */
    public Permutation m43463i() {
        return this.f32728i;
    }

    /* renamed from: j */
    public GF2Matrix m43464j() {
        return this.f32729j;
    }

    /* renamed from: k */
    public PolynomialGF2mSmallM[] m43465k() {
        return this.f32730k;
    }

    /* renamed from: l */
    public String m43466l() {
        return this.f32721b;
    }
}
