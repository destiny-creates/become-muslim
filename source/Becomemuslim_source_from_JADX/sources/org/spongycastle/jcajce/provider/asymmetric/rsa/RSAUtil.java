package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;

public class RSAUtil {
    /* renamed from: a */
    public static final ASN1ObjectIdentifier[] f22810a = new ASN1ObjectIdentifier[]{PKCSObjectIdentifiers.h_, X509ObjectIdentifiers.f22088l, PKCSObjectIdentifiers.f21862h, PKCSObjectIdentifiers.f21864k};

    /* renamed from: a */
    public static boolean m27986a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        for (int i = 0; i != f22810a.length; i++) {
            if (aSN1ObjectIdentifier.equals(f22810a[i])) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static RSAKeyParameters m27985a(RSAPublicKey rSAPublicKey) {
        return new RSAKeyParameters(false, rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
    }

    /* renamed from: a */
    static RSAKeyParameters m27984a(RSAPrivateKey rSAPrivateKey) {
        if (!(rSAPrivateKey instanceof RSAPrivateCrtKey)) {
            return new RSAKeyParameters(true, rSAPrivateKey.getModulus(), rSAPrivateKey.getPrivateExponent());
        }
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) rSAPrivateKey;
        return new RSAPrivateCrtKeyParameters(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent(), rSAPrivateCrtKey.getPrivateExponent(), rSAPrivateCrtKey.getPrimeP(), rSAPrivateCrtKey.getPrimeQ(), rSAPrivateCrtKey.getPrimeExponentP(), rSAPrivateCrtKey.getPrimeExponentQ(), rSAPrivateCrtKey.getCrtCoefficient());
    }
}
