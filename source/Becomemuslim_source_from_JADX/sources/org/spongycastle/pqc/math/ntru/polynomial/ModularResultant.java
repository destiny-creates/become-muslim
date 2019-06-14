package org.spongycastle.pqc.math.ntru.polynomial;

import java.math.BigInteger;
import org.spongycastle.pqc.math.ntru.euclid.BigIntEuclidean;

public class ModularResultant extends Resultant {
    /* renamed from: a */
    BigInteger f27880a;

    ModularResultant(BigIntPolynomial bigIntPolynomial, BigInteger bigInteger, BigInteger bigInteger2) {
        super(bigIntPolynomial, bigInteger);
        this.f27880a = bigInteger2;
    }

    /* renamed from: a */
    static ModularResultant m36578a(ModularResultant modularResultant, ModularResultant modularResultant2) {
        BigInteger bigInteger = modularResultant.f27880a;
        BigInteger bigInteger2 = modularResultant2.f27880a;
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        BigIntEuclidean a = BigIntEuclidean.m29295a(bigInteger2, bigInteger);
        BigIntPolynomial bigIntPolynomial = (BigIntPolynomial) modularResultant.b.clone();
        bigIntPolynomial.m29311a(a.f23399a.multiply(bigInteger2));
        BigIntPolynomial bigIntPolynomial2 = (BigIntPolynomial) modularResultant2.b.clone();
        bigIntPolynomial2.m29311a(a.f23400b.multiply(bigInteger));
        bigIntPolynomial.m29313b(bigIntPolynomial2);
        bigIntPolynomial.m29314c(multiply);
        return new ModularResultant(bigIntPolynomial, null, multiply);
    }
}
