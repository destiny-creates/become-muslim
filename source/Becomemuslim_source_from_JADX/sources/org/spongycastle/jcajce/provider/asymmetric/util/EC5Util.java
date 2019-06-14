package org.spongycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.ec.CustomNamedCurves;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.spec.ECNamedCurveParameterSpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECCurve.F2m;
import org.spongycastle.math.ec.ECCurve.Fp;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.PolynomialExtensionField;
import org.spongycastle.util.Arrays;

public class EC5Util {
    /* renamed from: a */
    private static Map f22821a = new HashMap();

    static {
        Enumeration a = CustomNamedCurves.m27402a();
        while (a.hasMoreElements()) {
            String str = (String) a.nextElement();
            X9ECParameters a2 = ECNamedCurveTable.m27262a(str);
            if (a2 != null) {
                f22821a.put(a2.m40516a(), CustomNamedCurves.m27403a(str).m40516a());
            }
        }
    }

    /* renamed from: a */
    public static ECCurve m28002a(ProviderConfiguration providerConfiguration, X962Parameters x962Parameters) {
        if (x962Parameters.m40507a()) {
            return ECUtil.m28008a(ASN1ObjectIdentifier.m42973a(x962Parameters.m40509c())).m40516a();
        }
        if (x962Parameters.m40508b()) {
            return providerConfiguration.mo5888a().m28315b();
        }
        return X9ECParameters.m40515a(x962Parameters.m40509c()).m40516a();
    }

    /* renamed from: a */
    public static ECParameterSpec m27997a(X962Parameters x962Parameters, ECCurve eCCurve) {
        if (x962Parameters.m40507a()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) x962Parameters.m40509c();
            X9ECParameters a = ECUtil.m28008a(aSN1ObjectIdentifier);
            return new ECNamedCurveSpec(ECUtil.m28012b(aSN1ObjectIdentifier), m27999a(eCCurve, a.m40521g()), new ECPoint(a.m40517b().m28409g().mo6549a(), a.m40517b().m28410h().mo6549a()), a.m40518c(), a.m40519d());
        } else if (x962Parameters.m40508b()) {
            return null;
        } else {
            ECParameterSpec eCParameterSpec;
            x962Parameters = X9ECParameters.m40515a(x962Parameters.m40509c());
            eCCurve = m27999a(eCCurve, x962Parameters.m40521g());
            if (x962Parameters.m40519d() != null) {
                eCParameterSpec = new ECParameterSpec(eCCurve, new ECPoint(x962Parameters.m40517b().m28409g().mo6549a(), x962Parameters.m40517b().m28410h().mo6549a()), x962Parameters.m40518c(), x962Parameters.m40519d().intValue());
            } else {
                eCParameterSpec = new ECParameterSpec(eCCurve, new ECPoint(x962Parameters.m40517b().m28409g().mo6549a(), x962Parameters.m40517b().m28410h().mo6549a()), x962Parameters.m40518c(), 1);
            }
            return eCParameterSpec;
        }
    }

    /* renamed from: a */
    public static ECParameterSpec m27998a(X9ECParameters x9ECParameters) {
        return new ECParameterSpec(m27999a(x9ECParameters.m40516a(), null), new ECPoint(x9ECParameters.m40517b().m28409g().mo6549a(), x9ECParameters.m40517b().m28410h().mo6549a()), x9ECParameters.m40518c(), x9ECParameters.m40519d().intValue());
    }

    /* renamed from: a */
    public static EllipticCurve m27999a(ECCurve eCCurve, byte[] bArr) {
        return new EllipticCurve(m27995a(eCCurve.m28382f()), eCCurve.m28383g().mo6549a(), eCCurve.m28384h().mo6549a(), null);
    }

    /* renamed from: a */
    public static ECCurve m28001a(EllipticCurve ellipticCurve) {
        ECField field = ellipticCurve.getField();
        BigInteger a = ellipticCurve.getA();
        BigInteger b = ellipticCurve.getB();
        if ((field instanceof ECFieldFp) != null) {
            ellipticCurve = new Fp(((ECFieldFp) field).getP(), a, b);
            return f22821a.containsKey(ellipticCurve) ? (ECCurve) f22821a.get(ellipticCurve) : ellipticCurve;
        } else {
            ECFieldF2m eCFieldF2m = (ECFieldF2m) field;
            int m = eCFieldF2m.getM();
            ellipticCurve = ECUtil.m28011a(eCFieldF2m.getMidTermsOfReductionPolynomial());
            return new F2m(m, ellipticCurve[0], ellipticCurve[1], ellipticCurve[2], a, b);
        }
    }

    /* renamed from: a */
    public static ECField m27995a(FiniteField finiteField) {
        if (ECAlgorithms.m28355b(finiteField)) {
            return new ECFieldFp(finiteField.mo5911a());
        }
        finiteField = ((PolynomialExtensionField) finiteField).mo6823c();
        int[] b = finiteField.mo5910b();
        return new ECFieldF2m(finiteField.mo5909a(), Arrays.m29383c(Arrays.m29377b(b, 1, b.length - 1)));
    }

    /* renamed from: a */
    public static ECParameterSpec m27996a(EllipticCurve ellipticCurve, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        if (!(eCParameterSpec instanceof ECNamedCurveParameterSpec)) {
            return new ECParameterSpec(ellipticCurve, new ECPoint(eCParameterSpec.m28316c().m28409g().mo6549a(), eCParameterSpec.m28316c().m28410h().mo6549a()), eCParameterSpec.m28317d(), eCParameterSpec.m28318e().intValue());
        }
        return new ECNamedCurveSpec(((ECNamedCurveParameterSpec) eCParameterSpec).m36250a(), ellipticCurve, new ECPoint(eCParameterSpec.m28316c().m28409g().mo6549a(), eCParameterSpec.m28316c().m28410h().mo6549a()), eCParameterSpec.m28317d(), eCParameterSpec.m28318e());
    }

    /* renamed from: a */
    public static org.spongycastle.jce.spec.ECParameterSpec m28000a(ECParameterSpec eCParameterSpec, boolean z) {
        ECCurve a = m28001a(eCParameterSpec.getCurve());
        return new org.spongycastle.jce.spec.ECParameterSpec(a, m28004a(a, eCParameterSpec.getGenerator(), z), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed());
    }

    /* renamed from: a */
    public static org.spongycastle.math.ec.ECPoint m28003a(ECParameterSpec eCParameterSpec, ECPoint eCPoint, boolean z) {
        return m28004a(m28001a(eCParameterSpec.getCurve()), eCPoint, z);
    }

    /* renamed from: a */
    public static org.spongycastle.math.ec.ECPoint m28004a(ECCurve eCCurve, ECPoint eCPoint, boolean z) {
        return eCCurve.m28376b(eCPoint.getAffineX(), eCPoint.getAffineY());
    }
}
