package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.PolynomialExtensionField;
import org.spongycastle.util.Arrays;

public class ECNamedCurveSpec extends ECParameterSpec {
    /* renamed from: a */
    private String f23046a;

    /* renamed from: a */
    private static EllipticCurve m28313a(ECCurve eCCurve, byte[] bArr) {
        return new EllipticCurve(m28311a(eCCurve.m28382f()), eCCurve.m28383g().mo6549a(), eCCurve.m28384h().mo6549a(), bArr);
    }

    /* renamed from: a */
    private static ECField m28311a(FiniteField finiteField) {
        if (ECAlgorithms.m28355b(finiteField)) {
            return new ECFieldFp(finiteField.mo5911a());
        }
        finiteField = ((PolynomialExtensionField) finiteField).mo6823c();
        int[] b = finiteField.mo5910b();
        return new ECFieldF2m(finiteField.mo5909a(), Arrays.m29383c(Arrays.m29377b(b, 1, b.length - 1)));
    }

    /* renamed from: a */
    private static ECPoint m28312a(org.spongycastle.math.ec.ECPoint eCPoint) {
        eCPoint = eCPoint.m28418p();
        return new ECPoint(eCPoint.m28409g().mo6549a(), eCPoint.m28410h().mo6549a());
    }

    public ECNamedCurveSpec(String str, EllipticCurve ellipticCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(ellipticCurve, eCPoint, bigInteger, bigInteger2.intValue());
        this.f23046a = str;
    }

    public ECNamedCurveSpec(String str, ECCurve eCCurve, org.spongycastle.math.ec.ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        super(m28313a(eCCurve, bArr), m28312a(eCPoint), bigInteger, bigInteger2.intValue());
        this.f23046a = str;
    }

    /* renamed from: a */
    public String m28314a() {
        return this.f23046a;
    }
}
