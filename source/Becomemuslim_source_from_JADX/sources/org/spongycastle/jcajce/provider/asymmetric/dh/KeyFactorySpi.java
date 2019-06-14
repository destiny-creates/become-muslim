package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHPrivateKeySpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;

public class KeyFactorySpi extends BaseKeyFactorySpi {
    protected KeySpec engineGetKeySpec(Key key, Class cls) {
        if (cls.isAssignableFrom(DHPrivateKeySpec.class) && (key instanceof DHPrivateKey)) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            return new DHPrivateKeySpec(dHPrivateKey.getX(), dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG());
        } else if (!cls.isAssignableFrom(DHPublicKeySpec.class) || !(key instanceof DHPublicKey)) {
            return super.engineGetKeySpec(key, cls);
        } else {
            DHPublicKey dHPublicKey = (DHPublicKey) key;
            return new DHPublicKeySpec(dHPublicKey.getY(), dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
        }
    }

    protected Key engineTranslateKey(Key key) {
        if (key instanceof DHPublicKey) {
            return new BCDHPublicKey((DHPublicKey) key);
        }
        if (key instanceof DHPrivateKey) {
            return new BCDHPrivateKey((DHPrivateKey) key);
        }
        throw new InvalidKeyException("key type unknown");
    }

    protected PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        if (keySpec instanceof DHPrivateKeySpec) {
            return new BCDHPrivateKey((DHPrivateKeySpec) keySpec);
        }
        return super.engineGeneratePrivate(keySpec);
    }

    protected PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (keySpec instanceof DHPublicKeySpec) {
            return new BCDHPublicKey((DHPublicKeySpec) keySpec);
        }
        return super.engineGeneratePublic(keySpec);
    }

    /* renamed from: a */
    public PrivateKey mo5916a(PrivateKeyInfo privateKeyInfo) {
        ASN1ObjectIdentifier a = privateKeyInfo.m40112a().m40230a();
        if (a.equals(PKCSObjectIdentifiers.f21865q)) {
            return new BCDHPrivateKey(privateKeyInfo);
        }
        if (a.equals(X9ObjectIdentifiers.ab)) {
            return new BCDHPrivateKey(privateKeyInfo);
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
        if (a.equals(PKCSObjectIdentifiers.f21865q)) {
            return new BCDHPublicKey(subjectPublicKeyInfo);
        }
        if (a.equals(X9ObjectIdentifiers.ab)) {
            return new BCDHPublicKey(subjectPublicKeyInfo);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("algorithm identifier ");
        stringBuilder.append(a);
        stringBuilder.append(" in key not recognised");
        throw new IOException(stringBuilder.toString());
    }
}
