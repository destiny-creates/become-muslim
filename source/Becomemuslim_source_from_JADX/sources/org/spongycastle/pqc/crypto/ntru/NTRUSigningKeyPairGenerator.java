package org.spongycastle.pqc.crypto.ntru;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.ntru.NTRUSigningPrivateKeyParameters.Basis;
import org.spongycastle.pqc.math.ntru.euclid.BigIntEuclidean;
import org.spongycastle.pqc.math.ntru.polynomial.BigDecimalPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.BigIntPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;
import org.spongycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Resultant;

public class NTRUSigningKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    /* renamed from: a */
    private NTRUSigningKeyGenerationParameters f27796a;

    private class BasisGenerationTask implements Callable<Basis> {
        /* renamed from: a */
        final /* synthetic */ NTRUSigningKeyPairGenerator f23297a;

        private BasisGenerationTask(NTRUSigningKeyPairGenerator nTRUSigningKeyPairGenerator) {
            this.f23297a = nTRUSigningKeyPairGenerator;
        }

        public /* synthetic */ Object call() {
            return m29103a();
        }

        /* renamed from: a */
        public Basis m29103a() {
            return this.f23297a.m36405b();
        }
    }

    public class FGBasis extends Basis {
        /* renamed from: a */
        public IntegerPolynomial f27793a;
        /* renamed from: b */
        public IntegerPolynomial f27794b;
        /* renamed from: c */
        final /* synthetic */ NTRUSigningKeyPairGenerator f27795c;

        FGBasis(NTRUSigningKeyPairGenerator nTRUSigningKeyPairGenerator, Polynomial polynomial, Polynomial polynomial2, IntegerPolynomial integerPolynomial, IntegerPolynomial integerPolynomial2, IntegerPolynomial integerPolynomial3, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) {
            this.f27795c = nTRUSigningKeyPairGenerator;
            super(polynomial, polynomial2, integerPolynomial, nTRUSigningKeyGenerationParameters);
            this.f27793a = integerPolynomial2;
            this.f27794b = integerPolynomial3;
        }

        /* renamed from: a */
        boolean m36401a() {
            double d = this.g.f27786t;
            int i = this.g.f27774h;
            return ((double) this.f27793a.m36571k(i)) < d && ((double) this.f27794b.m36571k(i)) < d;
        }
    }

    /* renamed from: a */
    public AsymmetricCipherKeyPair mo5755a() {
        AsymmetricKeyParameter asymmetricKeyParameter;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        List arrayList = new ArrayList();
        int i = this.f27796a.f27779m;
        while (true) {
            asymmetricKeyParameter = null;
            if (i < 0) {
                break;
            }
            arrayList.add(newCachedThreadPool.submit(new BasisGenerationTask()));
            i--;
        }
        newCachedThreadPool.shutdown();
        List arrayList2 = new ArrayList();
        i = this.f27796a.f27779m;
        while (i >= 0) {
            Future future = (Future) arrayList.get(i);
            try {
                arrayList2.add(future.get());
                if (i == this.f27796a.f27779m) {
                    asymmetricKeyParameter = new NTRUSigningPublicKeyParameters(((Basis) future.get()).f23314f, this.f27796a.m36399c());
                }
                i--;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        return new AsymmetricCipherKeyPair(asymmetricKeyParameter, new NTRUSigningPrivateKeyParameters(arrayList2, asymmetricKeyParameter));
    }

    /* renamed from: a */
    private void m36402a(IntegerPolynomial integerPolynomial, IntegerPolynomial integerPolynomial2, IntegerPolynomial integerPolynomial3, IntegerPolynomial integerPolynomial4, int i) {
        IntegerPolynomial integerPolynomial5 = integerPolynomial;
        IntegerPolynomial integerPolynomial6 = integerPolynomial2;
        IntegerPolynomial integerPolynomial7 = integerPolynomial3;
        IntegerPolynomial integerPolynomial8 = integerPolynomial4;
        int i2 = i;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += (i2 * 2) * ((integerPolynomial5.f27879a[i4] * integerPolynomial5.f27879a[i4]) + (integerPolynomial6.f27879a[i4] * integerPolynomial6.f27879a[i4]));
        }
        i3 -= 4;
        IntegerPolynomial integerPolynomial9 = (IntegerPolynomial) integerPolynomial.clone();
        IntegerPolynomial integerPolynomial10 = (IntegerPolynomial) integerPolynomial2.clone();
        int i5 = 0;
        int i6 = 0;
        while (i5 < i2 && r10 < i2) {
            int i7 = 0;
            for (int i8 = 0; i8 < i2; i8++) {
                i7 += (i2 * 4) * ((integerPolynomial7.f27879a[i8] * integerPolynomial5.f27879a[i8]) + (integerPolynomial8.f27879a[i8] * integerPolynomial6.f27879a[i8]));
            }
            i7 -= (integerPolynomial3.m36567i() + integerPolynomial4.m36567i()) * 4;
            if (i7 > i3) {
                integerPolynomial7.m36555c(integerPolynomial9);
                integerPolynomial8.m36555c(integerPolynomial10);
                i5++;
            } else if (i7 < (-i3)) {
                integerPolynomial7.m36552b(integerPolynomial9);
                integerPolynomial8.m36552b(integerPolynomial10);
                i5++;
            } else {
                i6++;
                integerPolynomial9.m36572k();
                integerPolynomial10.m36572k();
            }
            i6 = 0;
            i6++;
            integerPolynomial9.m36572k();
            integerPolynomial10.m36572k();
        }
    }

    /* renamed from: c */
    private FGBasis m36403c() {
        DenseTernaryPolynomial a;
        Polynomial polynomial;
        IntegerPolynomial m;
        IntegerPolynomial b;
        Resultant resultant;
        IntegerPolynomial integerPolynomial;
        IntegerPolynomial integerPolynomial2;
        Polynomial polynomial2;
        int i;
        IntegerPolynomial m2;
        Resultant f;
        BigIntEuclidean a2;
        BigIntPolynomial a3;
        Polynomial polynomial3;
        int i2 = this.f27796a.f27773g;
        int i3 = this.f27796a.f27774h;
        int i4 = this.f27796a.f27775i;
        int i5 = this.f27796a.f27776j;
        int i6 = this.f27796a.f27777k;
        int i7 = this.f27796a.f27778l;
        int i8 = this.f27796a.f27788v;
        int i9 = (i2 * 2) + 1;
        boolean z = this.f27796a.f27787u;
        while (true) {
            boolean z2;
            if (r8.f27796a.f27772A == 0) {
                a = DenseTernaryPolynomial.m42134a(i2, i4 + 1, i4, new SecureRandom());
                z2 = z;
            } else {
                z2 = z;
                a = ProductFormPolynomial.m36579a(i2, i5, i6, i7 + 1, i7, new SecureRandom());
            }
            polynomial = a;
            m = polynomial.mo5935m();
            if (z2) {
                if (m.m36554c(i9).c.equals(BigInteger.ZERO)) {
                    continue;
                    z = z2;
                }
            }
            b = m.m36551b(i3);
            if (b != null) {
                break;
            }
            z = z2;
        }
        Resultant f2 = m.m36561f();
        while (true) {
            int i10;
            int i11;
            int i12;
            if (r8.f27796a.f27772A == 0) {
                a = DenseTernaryPolynomial.m42134a(i2, i4 + 1, i4, new SecureRandom());
                resultant = f2;
                i10 = i5;
                i11 = i6;
                i12 = i7;
                integerPolynomial = b;
                integerPolynomial2 = m;
                polynomial2 = polynomial;
            } else {
                int i13 = i7 + 1;
                resultant = f2;
                i10 = i5;
                integerPolynomial = b;
                i11 = i6;
                integerPolynomial2 = m;
                i = i7;
                i12 = i7;
                polynomial2 = polynomial;
                a = ProductFormPolynomial.m36579a(i2, i5, i6, i13, i, new SecureRandom());
            }
            polynomial = a;
            m2 = polynomial.mo5935m();
            if (z2) {
                if (m2.m36554c(i9).c.equals(BigInteger.ZERO)) {
                    continue;
                    b = integerPolynomial;
                    m = integerPolynomial2;
                    polynomial = polynomial2;
                    f2 = resultant;
                    i5 = i10;
                    i6 = i11;
                    i7 = i12;
                }
            }
            if (m2.m36551b(i3) != null) {
                f = m2.m36561f();
                a2 = BigIntEuclidean.m29295a(resultant.f23422c, f.f23422c);
                if (a2.f23401c.equals(BigInteger.ONE)) {
                    break;
                }
            } else {
                continue;
            }
            b = integerPolynomial;
            m = integerPolynomial2;
            polynomial = polynomial2;
            f2 = resultant;
            i5 = i10;
            i6 = i11;
            i7 = i12;
        }
        BigIntPolynomial bigIntPolynomial = (BigIntPolynomial) resultant.f23421b.clone();
        int i14 = i8;
        Resultant resultant2 = resultant;
        bigIntPolynomial.m29311a(a2.f23399a.multiply(BigInteger.valueOf((long) i3)));
        BigIntPolynomial bigIntPolynomial2 = (BigIntPolynomial) f.f23421b.clone();
        bigIntPolynomial2.m29311a(a2.f23400b.multiply(BigInteger.valueOf((long) (-i3))));
        i = 0;
        if (r8.f27796a.f27791y == 0) {
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            iArr[0] = integerPolynomial2.f27879a[0];
            iArr2[0] = m2.f27879a[0];
            for (i = 1; i < i2; i++) {
                int i15 = i2 - i;
                iArr[i] = integerPolynomial2.f27879a[i15];
                iArr2[i] = m2.f27879a[i15];
            }
            m = new IntegerPolynomial(iArr);
            IntegerPolynomial integerPolynomial3 = new IntegerPolynomial(iArr2);
            IntegerPolynomial a4 = polynomial2.mo5933a(m);
            a4.m36552b(polynomial.mo5933a(integerPolynomial3));
            f2 = a4.m36561f();
            BigIntPolynomial a5 = m.mo5932a(bigIntPolynomial2);
            a5.m29313b(integerPolynomial3.mo5932a(bigIntPolynomial));
            a3 = a5.m29310a(f2.f23421b);
            a3.m29312b(f2.f23422c);
        } else {
            for (int i16 = 1; i16 < i2; i16 *= 10) {
                i++;
            }
            f2 = resultant2;
            BigDecimalPolynomial a6 = f2.f23421b.m29309a(new BigDecimal(f2.f23422c), (bigIntPolynomial2.m29308a() + 1) + i);
            BigDecimalPolynomial a7 = f.f23421b.m29309a(new BigDecimal(f.f23422c), (bigIntPolynomial.m29308a() + 1) + i);
            a6 = a6.m29301a(bigIntPolynomial2);
            a6.m29304b(a7.m29301a(bigIntPolynomial));
            a6.m29302a();
            a3 = a6.m29303b();
        }
        BigIntPolynomial bigIntPolynomial3 = (BigIntPolynomial) bigIntPolynomial2.clone();
        bigIntPolynomial3.m29315c(polynomial2.mo5932a(a3));
        bigIntPolynomial = (BigIntPolynomial) bigIntPolynomial.clone();
        bigIntPolynomial.m29315c(polynomial.mo5932a(a3));
        IntegerPolynomial integerPolynomial4 = new IntegerPolynomial(bigIntPolynomial3);
        IntegerPolynomial integerPolynomial5 = new IntegerPolynomial(bigIntPolynomial);
        m36402a(integerPolynomial2, m2, integerPolynomial4, integerPolynomial5, i2);
        if (i14 == 0) {
            b = polynomial.mo5934a(integerPolynomial, i3);
            polynomial3 = integerPolynomial4;
        } else {
            b = integerPolynomial4.mo5934a(integerPolynomial, i3);
            polynomial3 = polynomial;
        }
        b.m36564g(i3);
        return new FGBasis(this, polynomial2, polynomial3, b, integerPolynomial4, integerPolynomial5, r8.f27796a);
    }

    /* renamed from: b */
    public Basis m36405b() {
        Basis c;
        do {
            c = m36403c();
        } while (!c.m36401a());
        return c;
    }
}
