package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jce.provider.BouncyCastleProvider;

public class KeyFactory extends KeyFactorySpi {
    protected PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                PrivateKeyInfo a = PrivateKeyInfo.m40111a(((PKCS8EncodedKeySpec) keySpec).getEncoded());
                PrivateKey a2 = BouncyCastleProvider.m36188a(a);
                if (a2 != null) {
                    return a2;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("no factory found for OID: ");
                stringBuilder.append(a.m40112a().m40230a());
                throw new InvalidKeySpecException(stringBuilder.toString());
            } catch (KeySpec keySpec2) {
                throw new InvalidKeySpecException(keySpec2.toString());
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown KeySpec type: ");
        stringBuilder.append(keySpec2.getClass().getName());
        throw new InvalidKeySpecException(stringBuilder.toString());
    }

    protected PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                SubjectPublicKeyInfo a = SubjectPublicKeyInfo.m40409a(((X509EncodedKeySpec) keySpec).getEncoded());
                PublicKey a2 = BouncyCastleProvider.m36189a(a);
                if (a2 != null) {
                    return a2;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("no factory found for OID: ");
                stringBuilder.append(a.m40410a().m40230a());
                throw new InvalidKeySpecException(stringBuilder.toString());
            } catch (KeySpec keySpec2) {
                throw new InvalidKeySpecException(keySpec2.toString());
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown KeySpec type: ");
        stringBuilder.append(keySpec2.getClass().getName());
        throw new InvalidKeySpecException(stringBuilder.toString());
    }

    protected KeySpec engineGetKeySpec(Key key, Class cls) {
        if (cls.isAssignableFrom(PKCS8EncodedKeySpec.class) && key.getFormat().equals("PKCS#8")) {
            return new PKCS8EncodedKeySpec(key.getEncoded());
        }
        if (cls.isAssignableFrom(X509EncodedKeySpec.class) && key.getFormat().equals("X.509")) {
            return new X509EncodedKeySpec(key.getEncoded());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("not implemented yet ");
        stringBuilder.append(key);
        stringBuilder.append(" ");
        stringBuilder.append(cls);
        throw new InvalidKeySpecException(stringBuilder.toString());
    }

    protected Key engineTranslateKey(Key key) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("not implemented yet ");
        stringBuilder.append(key);
        throw new InvalidKeyException(stringBuilder.toString());
    }
}
