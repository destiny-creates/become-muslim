package org.spongycastle.pqc.crypto.ntru;

import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;
import org.spongycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.pqc.math.ntru.util.Util;

public class NTRUEncryptionKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    /* renamed from: a */
    private NTRUEncryptionKeyGenerationParameters f27760a;

    /* renamed from: a */
    public AsymmetricCipherKeyPair mo5755a() {
        Polynomial a;
        IntegerPolynomial m;
        IntegerPolynomial integerPolynomial;
        DenseTernaryPolynomial a2;
        int i = this.f27760a.f27741h;
        int i2 = this.f27760a.f27742i;
        int i3 = this.f27760a.f27743j;
        int i4 = this.f27760a.f27744k;
        int i5 = this.f27760a.f27745l;
        int i6 = this.f27760a.f27746m;
        int i7 = this.f27760a.f27751r;
        boolean z = this.f27760a.f27738F;
        boolean z2 = this.f27760a.f27737E;
        IntegerPolynomial integerPolynomial2 = null;
        while (true) {
            if (z) {
                if (r0.f27760a.f27739G == 0) {
                    a = Util.m29338a(i, i3, i3, z2, r0.f27760a.m27324a());
                } else {
                    a = ProductFormPolynomial.m36579a(i, i4, i5, i6, i6, r0.f27760a.m27324a());
                }
                m = a.mo5935m();
                m.m36560e(3);
                int[] iArr = m.f27879a;
                iArr[0] = iArr[0] + 1;
            } else {
                if (r0.f27760a.f27739G == 0) {
                    a = Util.m29338a(i, i3, i3 - 1, z2, r0.f27760a.m27324a());
                } else {
                    a = ProductFormPolynomial.m36579a(i, i4, i5, i6, i6 - 1, r0.f27760a.m27324a());
                }
                m = a.mo5935m();
                integerPolynomial2 = m.m36559e();
                if (integerPolynomial2 == null) {
                }
            }
            m = m.m36551b(i2);
            if (m != null) {
                break;
            }
        }
        if (z) {
            integerPolynomial = new IntegerPolynomial(i);
            integerPolynomial.f27879a[0] = 1;
        } else {
            integerPolynomial = integerPolynomial2;
        }
        do {
            a2 = DenseTernaryPolynomial.m42134a(i, i7, i7 - 1, r0.f27760a.m27324a());
        } while (a2.m36551b(i2) == null);
        IntegerPolynomial a3 = a2.mo5934a(m, i2);
        a3.m36562f(i2);
        a3.m36569j(i2);
        a2.m36573l();
        m.m36573l();
        return new AsymmetricCipherKeyPair(new NTRUEncryptionPublicKeyParameters(a3, r0.f27760a.m36379c()), new NTRUEncryptionPrivateKeyParameters(a3, a, integerPolynomial, r0.f27760a.m36379c()));
    }
}
