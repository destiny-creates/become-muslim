package org.spongycastle.jcajce.provider.asymmetric.ec;

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
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECParameterSpec;

public class KeyFactorySpi extends BaseKeyFactorySpi implements AsymmetricKeyInfoConverter {
    /* renamed from: a */
    String f31896a;
    /* renamed from: b */
    ProviderConfiguration f31897b;

    public static class EC extends KeyFactorySpi {
        public EC() {
            super("EC", BouncyCastleProvider.f27551a);
        }
    }

    public static class ECDH extends KeyFactorySpi {
        public ECDH() {
            super("ECDH", BouncyCastleProvider.f27551a);
        }
    }

    public static class ECDHC extends KeyFactorySpi {
        public ECDHC() {
            super("ECDHC", BouncyCastleProvider.f27551a);
        }
    }

    public static class ECDSA extends KeyFactorySpi {
        public ECDSA() {
            super("ECDSA", BouncyCastleProvider.f27551a);
        }
    }

    public static class ECGOST3410 extends KeyFactorySpi {
        public ECGOST3410() {
            super("ECGOST3410", BouncyCastleProvider.f27551a);
        }
    }

    public static class ECMQV extends KeyFactorySpi {
        public ECMQV() {
            super("ECMQV", BouncyCastleProvider.f27551a);
        }
    }

    KeyFactorySpi(String str, ProviderConfiguration providerConfiguration) {
        this.f31896a = str;
        this.f31897b = providerConfiguration;
    }

    protected Key engineTranslateKey(Key key) {
        if (key instanceof ECPublicKey) {
            return new BCECPublicKey((ECPublicKey) key, this.f31897b);
        }
        if (key instanceof ECPrivateKey) {
            return new BCECPrivateKey((ECPrivateKey) key, this.f31897b);
        }
        throw new InvalidKeyException("key type unknown");
    }

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

    protected PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        if (keySpec instanceof org.spongycastle.jce.spec.ECPrivateKeySpec) {
            return new BCECPrivateKey(this.f31896a, (org.spongycastle.jce.spec.ECPrivateKeySpec) keySpec, this.f31897b);
        }
        if (keySpec instanceof ECPrivateKeySpec) {
            return new BCECPrivateKey(this.f31896a, (ECPrivateKeySpec) keySpec, this.f31897b);
        }
        return super.engineGeneratePrivate(keySpec);
    }

    protected PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (keySpec instanceof org.spongycastle.jce.spec.ECPublicKeySpec) {
            return new BCECPublicKey(this.f31896a, (org.spongycastle.jce.spec.ECPublicKeySpec) keySpec, this.f31897b);
        }
        if (keySpec instanceof ECPublicKeySpec) {
            return new BCECPublicKey(this.f31896a, (ECPublicKeySpec) keySpec, this.f31897b);
        }
        return super.engineGeneratePublic(keySpec);
    }

    /* renamed from: a */
    public PrivateKey mo5916a(PrivateKeyInfo privateKeyInfo) {
        ASN1ObjectIdentifier a = privateKeyInfo.m40112a().m40230a();
        if (a.equals(X9ObjectIdentifiers.f22170k)) {
            return new BCECPrivateKey(this.f31896a, privateKeyInfo, this.f31897b);
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
        if (a.equals(X9ObjectIdentifiers.f22170k)) {
            return new BCECPublicKey(this.f31896a, subjectPublicKeyInfo, this.f31897b);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("algorithm identifier ");
        stringBuilder.append(a);
        stringBuilder.append(" in key not recognised");
        throw new IOException(stringBuilder.toString());
    }
}
