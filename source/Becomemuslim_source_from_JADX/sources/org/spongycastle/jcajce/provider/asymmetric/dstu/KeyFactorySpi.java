package org.spongycastle.jcajce.provider.asymmetric.dstu;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.KeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.ua.UAObjectIdentifiers;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECParameterSpec;

public class KeyFactorySpi extends BaseKeyFactorySpi {
    protected KeySpec engineGetKeySpec(Key key, Class cls) {
        ECPublicKey eCPublicKey;
        ECParameterSpec a;
        if (cls.isAssignableFrom(ECPublicKeySpec.class) && (key instanceof ECPublicKey)) {
            eCPublicKey = (ECPublicKey) key;
            if (eCPublicKey.getParams() != null) {
                return new ECPublicKeySpec(eCPublicKey.getW(), eCPublicKey.getParams());
            }
            a = BouncyCastleProvider.f27551a.mo5888a();
            return new ECPublicKeySpec(eCPublicKey.getW(), EC5Util.m27996a(EC5Util.m27999a(a.m28315b(), a.m28319f()), a));
        } else if (cls.isAssignableFrom(ECPrivateKeySpec.class) && (key instanceof ECPrivateKey)) {
            r4 = (ECPrivateKey) key;
            if (r4.getParams() != null) {
                return new ECPrivateKeySpec(r4.getS(), r4.getParams());
            }
            a = BouncyCastleProvider.f27551a.mo5888a();
            return new ECPrivateKeySpec(r4.getS(), EC5Util.m27996a(EC5Util.m27999a(a.m28315b(), a.m28319f()), a));
        } else if (cls.isAssignableFrom(org.spongycastle.jce.spec.ECPublicKeySpec.class) && (key instanceof ECPublicKey)) {
            eCPublicKey = (ECPublicKey) key;
            if (eCPublicKey.getParams() != null) {
                return new org.spongycastle.jce.spec.ECPublicKeySpec(EC5Util.m28003a(eCPublicKey.getParams(), eCPublicKey.getW(), false), EC5Util.m28000a(eCPublicKey.getParams(), false));
            }
            return new org.spongycastle.jce.spec.ECPublicKeySpec(EC5Util.m28003a(eCPublicKey.getParams(), eCPublicKey.getW(), false), BouncyCastleProvider.f27551a.mo5888a());
        } else if (!cls.isAssignableFrom(org.spongycastle.jce.spec.ECPrivateKeySpec.class) || !(key instanceof ECPrivateKey)) {
            return super.engineGetKeySpec(key, cls);
        } else {
            r4 = (ECPrivateKey) key;
            if (r4.getParams() != null) {
                return new org.spongycastle.jce.spec.ECPrivateKeySpec(r4.getS(), EC5Util.m28000a(r4.getParams(), false));
            }
            return new org.spongycastle.jce.spec.ECPrivateKeySpec(r4.getS(), BouncyCastleProvider.f27551a.mo5888a());
        }
    }

    protected Key engineTranslateKey(Key key) {
        throw new InvalidKeyException("key type unknown");
    }

    protected PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        if (keySpec instanceof org.spongycastle.jce.spec.ECPrivateKeySpec) {
            return new BCDSTU4145PrivateKey((org.spongycastle.jce.spec.ECPrivateKeySpec) keySpec);
        }
        if (keySpec instanceof ECPrivateKeySpec) {
            return new BCDSTU4145PrivateKey((ECPrivateKeySpec) keySpec);
        }
        return super.engineGeneratePrivate(keySpec);
    }

    protected PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (keySpec instanceof org.spongycastle.jce.spec.ECPublicKeySpec) {
            return new BCDSTU4145PublicKey((org.spongycastle.jce.spec.ECPublicKeySpec) keySpec);
        }
        if (keySpec instanceof ECPublicKeySpec) {
            return new BCDSTU4145PublicKey((ECPublicKeySpec) keySpec);
        }
        return super.engineGeneratePublic(keySpec);
    }

    /* renamed from: a */
    public PrivateKey mo5916a(PrivateKeyInfo privateKeyInfo) {
        ASN1ObjectIdentifier a = privateKeyInfo.m40112a().m40230a();
        if (!a.equals(UAObjectIdentifiers.f22013b)) {
            if (!a.equals(UAObjectIdentifiers.f22014c)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("algorithm identifier ");
                stringBuilder.append(a);
                stringBuilder.append(" in key not recognised");
                throw new IOException(stringBuilder.toString());
            }
        }
        return new BCDSTU4145PrivateKey(privateKeyInfo);
    }

    /* renamed from: a */
    public PublicKey mo5917a(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        ASN1ObjectIdentifier a = subjectPublicKeyInfo.m40410a().m40230a();
        if (!a.equals(UAObjectIdentifiers.f22013b)) {
            if (!a.equals(UAObjectIdentifiers.f22014c)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("algorithm identifier ");
                stringBuilder.append(a);
                stringBuilder.append(" in key not recognised");
                throw new IOException(stringBuilder.toString());
            }
        }
        return new BCDSTU4145PublicKey(subjectPublicKeyInfo);
    }
}
