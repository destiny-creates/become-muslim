package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactorySpi;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

public class BaseSecretKeyFactory extends SecretKeyFactorySpi implements PBE {
    /* renamed from: a */
    protected String f27497a;
    /* renamed from: b */
    protected ASN1ObjectIdentifier f27498b;

    protected BaseSecretKeyFactory(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f27497a = str;
        this.f27498b = aSN1ObjectIdentifier;
    }

    protected SecretKey engineGenerateSecret(KeySpec keySpec) {
        if (keySpec instanceof SecretKeySpec) {
            return (SecretKey) keySpec;
        }
        throw new InvalidKeySpecException("Invalid KeySpec");
    }

    protected KeySpec engineGetKeySpec(SecretKey secretKey, Class cls) {
        if (cls == null) {
            throw new InvalidKeySpecException("keySpec parameter is null");
        } else if (secretKey == null) {
            throw new InvalidKeySpecException("key parameter is null");
        } else if (SecretKeySpec.class.isAssignableFrom(cls)) {
            return new SecretKeySpec(secretKey.getEncoded(), this.f27497a);
        } else {
            try {
                return (KeySpec) cls.getConstructor(new Class[]{byte[].class}).newInstance(new Object[]{secretKey.getEncoded()});
            } catch (SecretKey secretKey2) {
                throw new InvalidKeySpecException(secretKey2.toString());
            }
        }
    }

    protected SecretKey engineTranslateKey(SecretKey secretKey) {
        if (secretKey == null) {
            throw new InvalidKeyException("key parameter is null");
        } else if (secretKey.getAlgorithm().equalsIgnoreCase(this.f27497a)) {
            return new SecretKeySpec(secretKey.getEncoded(), this.f27497a);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Key not of type ");
            stringBuilder.append(this.f27497a);
            stringBuilder.append(".");
            throw new InvalidKeyException(stringBuilder.toString());
        }
    }
}
