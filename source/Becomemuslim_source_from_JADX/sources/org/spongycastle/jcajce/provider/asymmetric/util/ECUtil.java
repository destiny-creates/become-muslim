package org.spongycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.nist.NISTNamedCurves;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.sec.SECNamedCurves;
import org.spongycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.X962NamedCurves;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.ec.CustomNamedCurves;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.spongycastle.jce.interfaces.ECPrivateKey;
import org.spongycastle.jce.interfaces.ECPublicKey;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECParameterSpec;

public class ECUtil {
    /* renamed from: a */
    static int[] m28011a(int[] iArr) {
        int[] iArr2 = new int[3];
        if (iArr.length == 1) {
            iArr2[0] = iArr[0];
        } else if (iArr.length != 3) {
            throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
        } else if (iArr[0] < iArr[1] && iArr[0] < iArr[2]) {
            iArr2[0] = iArr[0];
            if (iArr[1] < iArr[2]) {
                iArr2[1] = iArr[1];
                iArr2[2] = iArr[2];
            } else {
                iArr2[1] = iArr[2];
                iArr2[2] = iArr[1];
            }
        } else if (iArr[1] < iArr[2]) {
            iArr2[0] = iArr[1];
            if (iArr[0] < iArr[2]) {
                iArr2[1] = iArr[0];
                iArr2[2] = iArr[2];
            } else {
                iArr2[1] = iArr[2];
                iArr2[2] = iArr[0];
            }
        } else {
            iArr2[0] = iArr[2];
            if (iArr[0] < iArr[1]) {
                iArr2[1] = iArr[0];
                iArr2[2] = iArr[1];
            } else {
                iArr2[1] = iArr[1];
                iArr2[2] = iArr[0];
            }
        }
        return iArr2;
    }

    /* renamed from: a */
    public static AsymmetricKeyParameter m28010a(PublicKey publicKey) {
        ECParameterSpec b;
        if (publicKey instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
            b = eCPublicKey.mo6501b();
            if (b != null) {
                return new ECPublicKeyParameters(eCPublicKey.mo6503c(), new ECDomainParameters(b.m28315b(), b.m28316c(), b.m28317d(), b.m28318e(), b.m28319f()));
            }
            b = BouncyCastleProvider.f27551a.mo5888a();
            return new ECPublicKeyParameters(((BCECPublicKey) eCPublicKey).m41034a(), new ECDomainParameters(b.m28315b(), b.m28316c(), b.m28317d(), b.m28318e(), b.m28319f()));
        } else if (publicKey instanceof java.security.interfaces.ECPublicKey) {
            java.security.interfaces.ECPublicKey eCPublicKey2 = (java.security.interfaces.ECPublicKey) publicKey;
            b = EC5Util.m28000a(eCPublicKey2.getParams(), false);
            return new ECPublicKeyParameters(EC5Util.m28003a(eCPublicKey2.getParams(), eCPublicKey2.getW(), false), new ECDomainParameters(b.m28315b(), b.m28316c(), b.m28317d(), b.m28318e(), b.m28319f()));
        } else {
            try {
                publicKey = publicKey.getEncoded();
                if (publicKey != null) {
                    publicKey = BouncyCastleProvider.m36189a(SubjectPublicKeyInfo.m40409a(publicKey));
                    if (publicKey instanceof java.security.interfaces.ECPublicKey) {
                        return m28010a(publicKey);
                    }
                    throw new InvalidKeyException("cannot identify EC public key.");
                }
                throw new InvalidKeyException("no encoding for EC public key");
            } catch (PublicKey publicKey2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("cannot identify EC public key: ");
                stringBuilder.append(publicKey2.toString());
                throw new InvalidKeyException(stringBuilder.toString());
            }
        }
    }

    /* renamed from: a */
    public static AsymmetricKeyParameter m28009a(PrivateKey privateKey) {
        ECParameterSpec b;
        if (privateKey instanceof ECPrivateKey) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) privateKey;
            b = eCPrivateKey.mo6501b();
            if (b == null) {
                b = BouncyCastleProvider.f27551a.mo5888a();
            }
            return new ECPrivateKeyParameters(eCPrivateKey.mo6502d(), new ECDomainParameters(b.m28315b(), b.m28316c(), b.m28317d(), b.m28318e(), b.m28319f()));
        } else if (privateKey instanceof java.security.interfaces.ECPrivateKey) {
            java.security.interfaces.ECPrivateKey eCPrivateKey2 = (java.security.interfaces.ECPrivateKey) privateKey;
            b = EC5Util.m28000a(eCPrivateKey2.getParams(), false);
            return new ECPrivateKeyParameters(eCPrivateKey2.getS(), new ECDomainParameters(b.m28315b(), b.m28316c(), b.m28317d(), b.m28318e(), b.m28319f()));
        } else {
            try {
                privateKey = privateKey.getEncoded();
                if (privateKey != null) {
                    privateKey = BouncyCastleProvider.m36188a(PrivateKeyInfo.m40111a(privateKey));
                    if (privateKey instanceof java.security.interfaces.ECPrivateKey) {
                        return m28009a(privateKey);
                    }
                    throw new InvalidKeyException("can't identify EC private key.");
                }
                throw new InvalidKeyException("no encoding for EC private key");
            } catch (PrivateKey privateKey2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("cannot identify EC private key: ");
                stringBuilder.append(privateKey2.toString());
                throw new InvalidKeyException(stringBuilder.toString());
            }
        }
    }

    /* renamed from: a */
    public static int m28005a(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger != null) {
            return bigInteger.bitLength();
        }
        bigInteger = BouncyCastleProvider.f27551a.mo5888a();
        if (bigInteger == null) {
            return bigInteger2.bitLength();
        }
        return bigInteger.m28317d().bitLength();
    }

    /* renamed from: a */
    public static ASN1ObjectIdentifier m28006a(String str) {
        ASN1ObjectIdentifier b = X962NamedCurves.m27271b(str);
        if (b != null) {
            return b;
        }
        b = SECNamedCurves.m27199b(str);
        if (b == null) {
            b = NISTNamedCurves.m27191b(str);
        }
        if (b == null) {
            b = TeleTrusTNamedCurves.m27210b(str);
        }
        return b == null ? ECGOST3410NamedCurves.m27183b(str) : b;
    }

    /* renamed from: a */
    public static ASN1ObjectIdentifier m28007a(ECParameterSpec eCParameterSpec) {
        Enumeration a = ECNamedCurveTable.m27261a();
        while (a.hasMoreElements()) {
            String str = (String) a.nextElement();
            X9ECParameters a2 = ECNamedCurveTable.m27262a(str);
            if (a2.m40518c().equals(eCParameterSpec.m28317d()) && a2.m40519d().equals(eCParameterSpec.m28318e()) && a2.m40516a().m28374a(eCParameterSpec.m28315b()) && a2.m40517b().m28397a(eCParameterSpec.m28316c())) {
                return ECNamedCurveTable.m27264b(str);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static X9ECParameters m28008a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParameters a = CustomNamedCurves.m27404a(aSN1ObjectIdentifier);
        if (a != null) {
            return a;
        }
        a = X962NamedCurves.m27268a(aSN1ObjectIdentifier);
        if (a == null) {
            a = SECNamedCurves.m27194a(aSN1ObjectIdentifier);
        }
        if (a == null) {
            a = NISTNamedCurves.m27188a(aSN1ObjectIdentifier);
        }
        return a == null ? TeleTrusTNamedCurves.m27206a(aSN1ObjectIdentifier) : a;
    }

    /* renamed from: b */
    public static X9ECParameters m28013b(String str) {
        X9ECParameters a = CustomNamedCurves.m27403a(str);
        if (a != null) {
            return a;
        }
        a = X962NamedCurves.m27267a(str);
        if (a == null) {
            a = SECNamedCurves.m27193a(str);
        }
        if (a == null) {
            a = NISTNamedCurves.m27187a(str);
        }
        return a == null ? TeleTrusTNamedCurves.m27205a(str) : a;
    }

    /* renamed from: b */
    public static String m28012b(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String b = X962NamedCurves.m27270b(aSN1ObjectIdentifier);
        if (b != null) {
            return b;
        }
        b = SECNamedCurves.m27198b(aSN1ObjectIdentifier);
        if (b == null) {
            b = NISTNamedCurves.m27190b(aSN1ObjectIdentifier);
        }
        if (b == null) {
            b = TeleTrusTNamedCurves.m27209b(aSN1ObjectIdentifier);
        }
        return b == null ? ECGOST3410NamedCurves.m27182b(aSN1ObjectIdentifier) : b;
    }
}
