package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;

public class DSAUtil {
    /* renamed from: a */
    public static final ASN1ObjectIdentifier[] f22734a = new ASN1ObjectIdentifier[]{X9ObjectIdentifiers.f22154U, OIWObjectIdentifiers.f21831j};

    /* renamed from: a */
    public static boolean m27966a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        for (int i = 0; i != f22734a.length; i++) {
            if (aSN1ObjectIdentifier.equals(f22734a[i])) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static AsymmetricKeyParameter m27965a(PublicKey publicKey) {
        if (publicKey instanceof DSAPublicKey) {
            DSAPublicKey dSAPublicKey = (DSAPublicKey) publicKey;
            return new DSAPublicKeyParameters(dSAPublicKey.getY(), new DSAParameters(dSAPublicKey.getParams().getP(), dSAPublicKey.getParams().getQ(), dSAPublicKey.getParams().getG()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("can't identify DSA public key: ");
        stringBuilder.append(publicKey.getClass().getName());
        throw new InvalidKeyException(stringBuilder.toString());
    }

    /* renamed from: a */
    public static AsymmetricKeyParameter m27964a(PrivateKey privateKey) {
        if (privateKey instanceof DSAPrivateKey) {
            DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) privateKey;
            return new DSAPrivateKeyParameters(dSAPrivateKey.getX(), new DSAParameters(dSAPrivateKey.getParams().getP(), dSAPrivateKey.getParams().getQ(), dSAPrivateKey.getParams().getG()));
        }
        throw new InvalidKeyException("can't identify DSA private key.");
    }
}
