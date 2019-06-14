package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.KeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;

public class KeyFactorySpi extends BaseKeyFactorySpi {
    protected KeySpec engineGetKeySpec(Key key, Class cls) {
        if (cls.isAssignableFrom(DSAPublicKeySpec.class) && (key instanceof DSAPublicKey)) {
            DSAPublicKey dSAPublicKey = (DSAPublicKey) key;
            return new DSAPublicKeySpec(dSAPublicKey.getY(), dSAPublicKey.getParams().getP(), dSAPublicKey.getParams().getQ(), dSAPublicKey.getParams().getG());
        } else if (!cls.isAssignableFrom(DSAPrivateKeySpec.class) || !(key instanceof DSAPrivateKey)) {
            return super.engineGetKeySpec(key, cls);
        } else {
            DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) key;
            return new DSAPrivateKeySpec(dSAPrivateKey.getX(), dSAPrivateKey.getParams().getP(), dSAPrivateKey.getParams().getQ(), dSAPrivateKey.getParams().getG());
        }
    }

    protected Key engineTranslateKey(Key key) {
        if (key instanceof DSAPublicKey) {
            return new BCDSAPublicKey((DSAPublicKey) key);
        }
        if (key instanceof DSAPrivateKey) {
            return new BCDSAPrivateKey((DSAPrivateKey) key);
        }
        throw new InvalidKeyException("key type unknown");
    }

    /* renamed from: a */
    public PrivateKey mo5916a(PrivateKeyInfo privateKeyInfo) {
        ASN1ObjectIdentifier a = privateKeyInfo.m40112a().m40230a();
        if (DSAUtil.m27966a(a)) {
            return new BCDSAPrivateKey(privateKeyInfo);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("algorithm identifier ");
        stringBuilder.append(a);
        stringBuilder.append(" in key not recognised");
        throw new IOException(stringBuilder.toString());
    }

    /* renamed from: a */
    public PublicKey mo5917a(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        ASN1ObjectIdentifier a = subjectPublicKeyInfo.m40410a().m40230a();
        if (DSAUtil.m27966a(a)) {
            return new BCDSAPublicKey(subjectPublicKeyInfo);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("algorithm identifier ");
        stringBuilder.append(a);
        stringBuilder.append(" in key not recognised");
        throw new IOException(stringBuilder.toString());
    }

    protected PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        if (keySpec instanceof DSAPrivateKeySpec) {
            return new BCDSAPrivateKey((DSAPrivateKeySpec) keySpec);
        }
        return super.engineGeneratePrivate(keySpec);
    }

    protected PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (keySpec instanceof DSAPublicKeySpec) {
            return new BCDSAPublicKey((DSAPublicKeySpec) keySpec);
        }
        return super.engineGeneratePublic(keySpec);
    }
}
