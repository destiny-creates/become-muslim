package org.spongycastle.pqc.crypto.ntru;

import java.text.DecimalFormat;
import org.spongycastle.crypto.Digest;

public class NTRUSigningParameters implements Cloneable {
    /* renamed from: a */
    public int f23298a;
    /* renamed from: b */
    public int f23299b;
    /* renamed from: c */
    public int f23300c;
    /* renamed from: d */
    public int f23301d;
    /* renamed from: e */
    public int f23302e;
    /* renamed from: f */
    public int f23303f;
    /* renamed from: g */
    public int f23304g;
    /* renamed from: h */
    double f23305h;
    /* renamed from: i */
    public double f23306i;
    /* renamed from: j */
    double f23307j;
    /* renamed from: k */
    public double f23308k;
    /* renamed from: l */
    public int f23309l = 100;
    /* renamed from: m */
    int f23310m = 6;
    /* renamed from: n */
    public Digest f23311n;

    public /* synthetic */ Object clone() {
        return m29105a();
    }

    public NTRUSigningParameters(int i, int i2, int i3, int i4, double d, double d2, Digest digest) {
        this.f23298a = i;
        this.f23299b = i2;
        this.f23300c = i3;
        this.f23304g = i4;
        this.f23305h = d;
        this.f23307j = d2;
        this.f23311n = digest;
        m29104b();
    }

    /* renamed from: b */
    private void m29104b() {
        this.f23306i = this.f23305h * this.f23305h;
        this.f23308k = this.f23307j * this.f23307j;
    }

    /* renamed from: a */
    public NTRUSigningParameters m29105a() {
        return new NTRUSigningParameters(this.f23298a, this.f23299b, this.f23300c, this.f23304g, this.f23305h, this.f23307j, this.f23311n);
    }

    public int hashCode() {
        int i = ((this.f23304g + 31) * 31) + this.f23298a;
        long doubleToLongBits = Double.doubleToLongBits(this.f23305h);
        i = (i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        doubleToLongBits = Double.doubleToLongBits(this.f23306i);
        i = (((((((((((((i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f23310m) * 31) + this.f23300c) * 31) + this.f23301d) * 31) + this.f23302e) * 31) + this.f23303f) * 31) + (this.f23311n == null ? 0 : this.f23311n.mo5729a().hashCode());
        doubleToLongBits = Double.doubleToLongBits(this.f23307j);
        i = (i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        doubleToLongBits = Double.doubleToLongBits(this.f23308k);
        return (((((i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f23299b) * 31) + this.f23309l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NTRUSigningParameters)) {
            return false;
        }
        NTRUSigningParameters nTRUSigningParameters = (NTRUSigningParameters) obj;
        if (this.f23304g != nTRUSigningParameters.f23304g || this.f23298a != nTRUSigningParameters.f23298a || Double.doubleToLongBits(this.f23305h) != Double.doubleToLongBits(nTRUSigningParameters.f23305h) || Double.doubleToLongBits(this.f23306i) != Double.doubleToLongBits(nTRUSigningParameters.f23306i) || this.f23310m != nTRUSigningParameters.f23310m || this.f23300c != nTRUSigningParameters.f23300c || this.f23301d != nTRUSigningParameters.f23301d || this.f23302e != nTRUSigningParameters.f23302e || this.f23303f != nTRUSigningParameters.f23303f) {
            return false;
        }
        if (this.f23311n == null) {
            if (nTRUSigningParameters.f23311n != null) {
                return false;
            }
        } else if (!this.f23311n.mo5729a().equals(nTRUSigningParameters.f23311n.mo5729a())) {
            return false;
        }
        return Double.doubleToLongBits(this.f23307j) == Double.doubleToLongBits(nTRUSigningParameters.f23307j) && Double.doubleToLongBits(this.f23308k) == Double.doubleToLongBits(nTRUSigningParameters.f23308k) && this.f23299b == nTRUSigningParameters.f23299b && this.f23309l == nTRUSigningParameters.f23309l;
    }

    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SignatureParameters(N=");
        stringBuilder.append(this.f23298a);
        stringBuilder.append(" q=");
        stringBuilder.append(this.f23299b);
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(" B=");
        stringBuilder.append(this.f23304g);
        stringBuilder.append(" beta=");
        stringBuilder.append(decimalFormat.format(this.f23305h));
        stringBuilder.append(" normBound=");
        stringBuilder.append(decimalFormat.format(this.f23307j));
        stringBuilder.append(" hashAlg=");
        stringBuilder.append(this.f23311n);
        stringBuilder.append(")");
        stringBuilder2.append(stringBuilder.toString());
        return stringBuilder2.toString();
    }
}
