package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.spongycastle.pqc.asn1.RainbowPrivateKey;
import org.spongycastle.pqc.asn1.RainbowPublicKey;
import org.spongycastle.pqc.jcajce.spec.RainbowPrivateKeySpec;
import org.spongycastle.pqc.jcajce.spec.RainbowPublicKeySpec;

public class RainbowKeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        if (keySpec instanceof RainbowPrivateKeySpec) {
            return new BCRainbowPrivateKey((RainbowPrivateKeySpec) keySpec);
        }
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return mo5916a(PrivateKeyInfo.m40111a(ASN1Primitive.m39798b(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
            } catch (KeySpec keySpec2) {
                throw new InvalidKeySpecException(keySpec2.toString());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported key specification: ");
        stringBuilder.append(keySpec2.getClass());
        stringBuilder.append(".");
        throw new InvalidKeySpecException(stringBuilder.toString());
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (keySpec instanceof RainbowPublicKeySpec) {
            return new BCRainbowPublicKey((RainbowPublicKeySpec) keySpec);
        }
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                return mo5917a(SubjectPublicKeyInfo.m40409a(((X509EncodedKeySpec) keySpec).getEncoded()));
            } catch (KeySpec keySpec2) {
                throw new InvalidKeySpecException(keySpec2.toString());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown key specification: ");
        stringBuilder.append(keySpec2);
        stringBuilder.append(".");
        throw new InvalidKeySpecException(stringBuilder.toString());
    }

    public final KeySpec engineGetKeySpec(Key key, Class cls) {
        StringBuilder stringBuilder;
        if (key instanceof BCRainbowPrivateKey) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
            if (RainbowPrivateKeySpec.class.isAssignableFrom(cls)) {
                BCRainbowPrivateKey bCRainbowPrivateKey = (BCRainbowPrivateKey) key;
                return new RainbowPrivateKeySpec(bCRainbowPrivateKey.m29143a(), bCRainbowPrivateKey.m29144b(), bCRainbowPrivateKey.m29146d(), bCRainbowPrivateKey.m29145c(), bCRainbowPrivateKey.m29148f(), bCRainbowPrivateKey.m29147e());
            }
        } else if (!(key instanceof BCRainbowPublicKey)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported key type: ");
            stringBuilder.append(key.getClass());
            stringBuilder.append(".");
            throw new InvalidKeySpecException(stringBuilder.toString());
        } else if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
            return new X509EncodedKeySpec(key.getEncoded());
        } else {
            if (RainbowPublicKeySpec.class.isAssignableFrom(cls)) {
                BCRainbowPublicKey bCRainbowPublicKey = (BCRainbowPublicKey) key;
                return new RainbowPublicKeySpec(bCRainbowPublicKey.m29149a(), bCRainbowPublicKey.m29150b(), bCRainbowPublicKey.m29151c(), bCRainbowPublicKey.m29152d());
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown key specification: ");
        stringBuilder.append(cls);
        stringBuilder.append(".");
        throw new InvalidKeySpecException(stringBuilder.toString());
    }

    public final Key engineTranslateKey(Key key) {
        if (!(key instanceof BCRainbowPrivateKey)) {
            if (!(key instanceof BCRainbowPublicKey)) {
                throw new InvalidKeyException("Unsupported key type");
            }
        }
        return key;
    }

    /* renamed from: a */
    public PrivateKey mo5916a(PrivateKeyInfo privateKeyInfo) {
        privateKeyInfo = RainbowPrivateKey.m42079a(privateKeyInfo.m40114c());
        return new BCRainbowPrivateKey(privateKeyInfo.m42080a(), privateKeyInfo.m42081b(), privateKeyInfo.m42083d(), privateKeyInfo.m42082c(), privateKeyInfo.m42086h(), privateKeyInfo.m42085g());
    }

    /* renamed from: a */
    public PublicKey mo5917a(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        subjectPublicKeyInfo = RainbowPublicKey.m42087a(subjectPublicKeyInfo.m40412c());
        return new BCRainbowPublicKey(subjectPublicKeyInfo.m42088a(), subjectPublicKeyInfo.m42089b(), subjectPublicKeyInfo.m42090c(), subjectPublicKeyInfo.m42091d());
    }
}
