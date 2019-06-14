package org.spongycastle.crypto.util;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.oiw.ElGamalParameter;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.DHParameter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSAPublicKey;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.asn1.x9.DHPublicKey;
import org.spongycastle.asn1.x9.DomainParameters;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.ValidationParams;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECPoint;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.ec.CustomNamedCurves;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.params.DHValidationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECNamedDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;

public class PublicKeyFactory {
    /* renamed from: a */
    public static AsymmetricKeyParameter m27886a(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        AlgorithmIdentifier a = subjectPublicKeyInfo.m40410a();
        int i = 0;
        if (!a.m40230a().equals(PKCSObjectIdentifiers.h_)) {
            if (!a.m40230a().equals(X509ObjectIdentifiers.f22088l)) {
                DSAParameters dSAParameters = null;
                if (a.m40230a().equals(X9ObjectIdentifiers.ab)) {
                    subjectPublicKeyInfo = DHPublicKey.m40488a(subjectPublicKeyInfo.m40412c()).m40489a();
                    DomainParameters a2 = DomainParameters.m40493a(a.m40231b());
                    BigInteger a3 = a2.m40494a();
                    BigInteger b = a2.m40495b();
                    BigInteger c = a2.m40496c();
                    BigInteger d = a2.m40497d() != null ? a2.m40497d() : null;
                    ValidationParams g = a2.m40499g();
                    if (g != null) {
                        dSAParameters = new DHValidationParameters(g.m40503a(), g.m40504b().intValue());
                    }
                    return new DHPublicKeyParameters(subjectPublicKeyInfo, new DHParameters(a3, b, c, d, dSAParameters));
                } else if (a.m40230a().equals(PKCSObjectIdentifiers.f21865q)) {
                    DHParameter a4 = DHParameter.m40065a(a.m40231b());
                    r10 = (ASN1Integer) subjectPublicKeyInfo.m40412c();
                    BigInteger c2 = a4.m40068c();
                    if (c2 != null) {
                        i = c2.intValue();
                    }
                    return new DHPublicKeyParameters(r10.m42968b(), new DHParameters(a4.m40066a(), a4.m40067b(), null, i));
                } else if (a.m40230a().equals(OIWObjectIdentifiers.f21833l)) {
                    ElGamalParameter a5 = ElGamalParameter.m40046a(a.m40231b());
                    return new ElGamalPublicKeyParameters(((ASN1Integer) subjectPublicKeyInfo.m40412c()).m42968b(), new ElGamalParameters(a5.m40047a(), a5.m40048b()));
                } else {
                    if (!a.m40230a().equals(X9ObjectIdentifiers.f22154U)) {
                        if (!a.m40230a().equals(OIWObjectIdentifiers.f21831j)) {
                            if (a.m40230a().equals(X9ObjectIdentifiers.f22170k)) {
                                X9ECParameters a6;
                                ECDomainParameters eCNamedDomainParameters;
                                X962Parameters a7 = X962Parameters.m40506a(a.m40231b());
                                if (a7.m40507a()) {
                                    ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) a7.m40509c();
                                    a6 = CustomNamedCurves.m27404a(aSN1ObjectIdentifier);
                                    if (a6 == null) {
                                        a6 = ECNamedCurveTable.m27265b(aSN1ObjectIdentifier);
                                    }
                                    eCNamedDomainParameters = new ECNamedDomainParameters(aSN1ObjectIdentifier, a6.m40516a(), a6.m40517b(), a6.m40518c(), a6.m40519d(), a6.m40521g());
                                } else {
                                    a6 = X9ECParameters.m40515a(a7.m40509c());
                                    ECDomainParameters eCDomainParameters = new ECDomainParameters(a6.m40516a(), a6.m40517b(), a6.m40518c(), a6.m40519d(), a6.m40521g());
                                }
                                return new ECPublicKeyParameters(new X9ECPoint(a6.m40516a(), new DEROctetString(subjectPublicKeyInfo.m40413d().m43059c())).m40522a(), eCNamedDomainParameters);
                            }
                            throw new RuntimeException("algorithm identifier in key not recognised");
                        }
                    }
                    r10 = (ASN1Integer) subjectPublicKeyInfo.m40412c();
                    ASN1Encodable b2 = a.m40231b();
                    if (b2 != null) {
                        DSAParameter a8 = DSAParameter.m40300a(b2.mo5709e());
                        dSAParameters = new DSAParameters(a8.m40301a(), a8.m40302b(), a8.m40303c());
                    }
                    return new DSAPublicKeyParameters(r10.m42968b(), dSAParameters);
                }
            }
        }
        subjectPublicKeyInfo = RSAPublicKey.m40144a(subjectPublicKeyInfo.m40412c());
        return new RSAKeyParameters(false, subjectPublicKeyInfo.m40145a(), subjectPublicKeyInfo.m40146b());
    }
}
