package org.spongycastle.pqc.crypto.ntru;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;

public class NTRUSigningKeyGenerationParameters extends KeyGenerationParameters implements Cloneable {
    /* renamed from: a */
    public static final NTRUSigningKeyGenerationParameters f27766a = new NTRUSigningKeyGenerationParameters(439, 2048, 146, 1, 1, 0.165d, 490.0d, 280.0d, false, true, 0, new SHA256Digest());
    /* renamed from: b */
    public static final NTRUSigningKeyGenerationParameters f27767b;
    /* renamed from: c */
    public static final NTRUSigningKeyGenerationParameters f27768c = new NTRUSigningKeyGenerationParameters(743, 2048, 248, 1, 1, 0.127d, 560.0d, 360.0d, true, false, 0, new SHA512Digest());
    /* renamed from: d */
    public static final NTRUSigningKeyGenerationParameters f27769d;
    /* renamed from: e */
    public static final NTRUSigningKeyGenerationParameters f27770e = new NTRUSigningKeyGenerationParameters(157, 256, 29, 1, 1, 0.38d, 200.0d, 80.0d, false, false, 0, new SHA256Digest());
    /* renamed from: f */
    public static final NTRUSigningKeyGenerationParameters f27771f;
    /* renamed from: A */
    public int f27772A;
    /* renamed from: g */
    public int f27773g;
    /* renamed from: h */
    public int f27774h;
    /* renamed from: i */
    public int f27775i;
    /* renamed from: j */
    public int f27776j;
    /* renamed from: k */
    public int f27777k;
    /* renamed from: l */
    public int f27778l;
    /* renamed from: m */
    public int f27779m;
    /* renamed from: n */
    double f27780n;
    /* renamed from: o */
    public double f27781o;
    /* renamed from: p */
    double f27782p;
    /* renamed from: q */
    public double f27783q;
    /* renamed from: r */
    public int f27784r = 100;
    /* renamed from: s */
    double f27785s;
    /* renamed from: t */
    public double f27786t;
    /* renamed from: u */
    public boolean f27787u;
    /* renamed from: v */
    public int f27788v;
    /* renamed from: w */
    int f27789w = 6;
    /* renamed from: x */
    public boolean f27790x;
    /* renamed from: y */
    public int f27791y;
    /* renamed from: z */
    public Digest f27792z;

    public /* synthetic */ Object clone() {
        return m36400d();
    }

    static {
        SHA256Digest sHA256Digest = r1;
        SHA256Digest sHA256Digest2 = new SHA256Digest();
        f27767b = new NTRUSigningKeyGenerationParameters(439, 2048, 9, 8, 5, 1, 1, 0.165d, 490.0d, 280.0d, false, true, 0, sHA256Digest);
        SHA512Digest sHA512Digest = r1;
        SHA512Digest sHA512Digest2 = new SHA512Digest();
        f27769d = new NTRUSigningKeyGenerationParameters(743, 2048, 11, 11, 15, 1, 1, 0.127d, 560.0d, 360.0d, true, false, 0, sHA512Digest);
        sHA256Digest = sHA256Digest2;
        sHA256Digest2 = new SHA256Digest();
        f27771f = new NTRUSigningKeyGenerationParameters(157, 256, 5, 5, 8, 1, 1, 0.38d, 200.0d, 80.0d, false, false, 0, sHA256Digest);
    }

    public NTRUSigningKeyGenerationParameters(int i, int i2, int i3, int i4, int i5, double d, double d2, double d3, boolean z, boolean z2, int i6, Digest digest) {
        int i7 = i;
        super(new SecureRandom(), i);
        this.f27773g = i7;
        this.f27774h = i2;
        this.f27775i = i3;
        this.f27779m = i4;
        this.f27788v = i5;
        this.f27780n = d;
        this.f27782p = d2;
        this.f27785s = d3;
        this.f27787u = z;
        this.f27790x = z2;
        this.f27791y = i6;
        this.f27792z = digest;
        this.f27772A = 0;
        m36398e();
    }

    public NTRUSigningKeyGenerationParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, double d, double d2, double d3, boolean z, boolean z2, int i8, Digest digest) {
        int i9 = i;
        super(new SecureRandom(), i);
        this.f27773g = i9;
        this.f27774h = i2;
        this.f27776j = i3;
        this.f27777k = i4;
        this.f27778l = i5;
        this.f27779m = i6;
        this.f27788v = i7;
        this.f27780n = d;
        this.f27782p = d2;
        this.f27785s = d3;
        this.f27787u = z;
        this.f27790x = z2;
        this.f27791y = i8;
        this.f27792z = digest;
        this.f27772A = 1;
        m36398e();
    }

    /* renamed from: e */
    private void m36398e() {
        this.f27781o = this.f27780n * this.f27780n;
        this.f27783q = this.f27782p * this.f27782p;
        this.f27786t = this.f27785s * this.f27785s;
    }

    /* renamed from: c */
    public NTRUSigningParameters m36399c() {
        return new NTRUSigningParameters(this.f27773g, this.f27774h, this.f27775i, this.f27779m, this.f27780n, this.f27782p, this.f27792z);
    }

    /* renamed from: d */
    public NTRUSigningKeyGenerationParameters m36400d() {
        if (this.f27772A != 0) {
            return new NTRUSigningKeyGenerationParameters(r0.f27773g, r0.f27774h, r0.f27776j, r0.f27777k, r0.f27778l, r0.f27779m, r0.f27788v, r0.f27780n, r0.f27782p, r0.f27785s, r0.f27787u, r0.f27790x, r0.f27791y, r0.f27792z);
        }
        int i = r0.f27773g;
        int i2 = r0.f27774h;
        int i3 = r0.f27775i;
        int i4 = r0.f27779m;
        int i5 = r0.f27788v;
        double d = r0.f27780n;
        double d2 = r0.f27782p;
        double d3 = r0.f27785s;
        boolean z = r0.f27787u;
        boolean z2 = r0.f27790x;
        boolean z3 = z2;
        return new NTRUSigningKeyGenerationParameters(i, i2, i3, i4, i5, d, d2, d3, z, z3, r0.f27791y, r0.f27792z);
    }

    public int hashCode() {
        int i = ((((this.f27779m + 31) * 31) + this.f27773g) * 31) + this.f27788v;
        long doubleToLongBits = Double.doubleToLongBits(this.f27780n);
        i = (i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        doubleToLongBits = Double.doubleToLongBits(this.f27781o);
        i = (((((((((((((((i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f27789w) * 31) + this.f27775i) * 31) + this.f27776j) * 31) + this.f27777k) * 31) + this.f27778l) * 31) + (this.f27792z == null ? 0 : this.f27792z.mo5729a().hashCode())) * 31) + this.f27791y;
        doubleToLongBits = Double.doubleToLongBits(this.f27785s);
        i = (i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        doubleToLongBits = Double.doubleToLongBits(this.f27786t);
        i = (i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        doubleToLongBits = Double.doubleToLongBits(this.f27782p);
        i = (i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        doubleToLongBits = Double.doubleToLongBits(this.f27783q);
        int i2 = 1237;
        i = ((((((((((i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f27772A) * 31) + (this.f27787u ? 1231 : 1237)) * 31) + this.f27774h) * 31) + this.f27784r) * 31;
        if (this.f27790x) {
            i2 = 1231;
        }
        return i + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NTRUSigningKeyGenerationParameters)) {
            return false;
        }
        NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = (NTRUSigningKeyGenerationParameters) obj;
        if (this.f27779m != nTRUSigningKeyGenerationParameters.f27779m || this.f27773g != nTRUSigningKeyGenerationParameters.f27773g || this.f27788v != nTRUSigningKeyGenerationParameters.f27788v || Double.doubleToLongBits(this.f27780n) != Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.f27780n) || Double.doubleToLongBits(this.f27781o) != Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.f27781o) || this.f27789w != nTRUSigningKeyGenerationParameters.f27789w || this.f27775i != nTRUSigningKeyGenerationParameters.f27775i || this.f27776j != nTRUSigningKeyGenerationParameters.f27776j || this.f27777k != nTRUSigningKeyGenerationParameters.f27777k || this.f27778l != nTRUSigningKeyGenerationParameters.f27778l) {
            return false;
        }
        if (this.f27792z == null) {
            if (nTRUSigningKeyGenerationParameters.f27792z != null) {
                return false;
            }
        } else if (!this.f27792z.mo5729a().equals(nTRUSigningKeyGenerationParameters.f27792z.mo5729a())) {
            return false;
        }
        return this.f27791y == nTRUSigningKeyGenerationParameters.f27791y && Double.doubleToLongBits(this.f27785s) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.f27785s) && Double.doubleToLongBits(this.f27786t) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.f27786t) && Double.doubleToLongBits(this.f27782p) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.f27782p) && Double.doubleToLongBits(this.f27783q) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.f27783q) && this.f27772A == nTRUSigningKeyGenerationParameters.f27772A && this.f27787u == nTRUSigningKeyGenerationParameters.f27787u && this.f27774h == nTRUSigningKeyGenerationParameters.f27774h && this.f27784r == nTRUSigningKeyGenerationParameters.f27784r && this.f27790x == nTRUSigningKeyGenerationParameters.f27790x;
    }

    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SignatureParameters(N=");
        stringBuilder.append(this.f27773g);
        stringBuilder.append(" q=");
        stringBuilder.append(this.f27774h);
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.toString());
        if (this.f27772A == 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" polyType=SIMPLE d=");
            stringBuilder.append(this.f27775i);
            stringBuilder2.append(stringBuilder.toString());
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" polyType=PRODUCT d1=");
            stringBuilder.append(this.f27776j);
            stringBuilder.append(" d2=");
            stringBuilder.append(this.f27777k);
            stringBuilder.append(" d3=");
            stringBuilder.append(this.f27778l);
            stringBuilder2.append(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(" B=");
        stringBuilder.append(this.f27779m);
        stringBuilder.append(" basisType=");
        stringBuilder.append(this.f27788v);
        stringBuilder.append(" beta=");
        stringBuilder.append(decimalFormat.format(this.f27780n));
        stringBuilder.append(" normBound=");
        stringBuilder.append(decimalFormat.format(this.f27782p));
        stringBuilder.append(" keyNormBound=");
        stringBuilder.append(decimalFormat.format(this.f27785s));
        stringBuilder.append(" prime=");
        stringBuilder.append(this.f27787u);
        stringBuilder.append(" sparse=");
        stringBuilder.append(this.f27790x);
        stringBuilder.append(" keyGenAlg=");
        stringBuilder.append(this.f27791y);
        stringBuilder.append(" hashAlg=");
        stringBuilder.append(this.f27792z);
        stringBuilder.append(")");
        stringBuilder2.append(stringBuilder.toString());
        return stringBuilder2.toString();
    }
}
