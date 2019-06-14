package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;

public class KeyFactorySpi extends BaseKeyFactorySpi {
    protected KeySpec engineGetKeySpec(Key key, Class cls) {
        if (cls.isAssignableFrom(RSAPublicKeySpec.class) && (key instanceof RSAPublicKey)) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) key;
            return new RSAPublicKeySpec(rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
        } else if (cls.isAssignableFrom(RSAPrivateKeySpec.class) && (key instanceof RSAPrivateKey)) {
            RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) key;
            return new RSAPrivateKeySpec(rSAPrivateKey.getModulus(), rSAPrivateKey.getPrivateExponent());
        } else if (!cls.isAssignableFrom(RSAPrivateCrtKeySpec.class) || !(key instanceof RSAPrivateCrtKey)) {
            return super.engineGetKeySpec(key, cls);
        } else {
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) key;
            return new RSAPrivateCrtKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent(), rSAPrivateCrtKey.getPrivateExponent(), rSAPrivateCrtKey.getPrimeP(), rSAPrivateCrtKey.getPrimeQ(), rSAPrivateCrtKey.getPrimeExponentP(), rSAPrivateCrtKey.getPrimeExponentQ(), rSAPrivateCrtKey.getCrtCoefficient());
        }
    }

    protected Key engineTranslateKey(Key key) {
        if (key instanceof RSAPublicKey) {
            return new BCRSAPublicKey((RSAPublicKey) key);
        }
        if (key instanceof RSAPrivateCrtKey) {
            return new BCRSAPrivateCrtKey((RSAPrivateCrtKey) key);
        }
        if (key instanceof RSAPrivateKey) {
            return new BCRSAPrivateKey((RSAPrivateKey) key);
        }
        throw new InvalidKeyException("key type unknown");
    }

    protected java.security.PrivateKey engineGeneratePrivate(java.security.spec.KeySpec r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r4 instanceof java.security.spec.PKCS8EncodedKeySpec;
        if (r0 == 0) goto L_0x0040;
    L_0x0004:
        r0 = r4;	 Catch:{ Exception -> 0x0014 }
        r0 = (java.security.spec.PKCS8EncodedKeySpec) r0;	 Catch:{ Exception -> 0x0014 }
        r0 = r0.getEncoded();	 Catch:{ Exception -> 0x0014 }
        r0 = org.spongycastle.asn1.pkcs.PrivateKeyInfo.m40111a(r0);	 Catch:{ Exception -> 0x0014 }
        r0 = r3.mo5916a(r0);	 Catch:{ Exception -> 0x0014 }
        return r0;
    L_0x0014:
        r0 = move-exception;
        r1 = new org.spongycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateCrtKey;	 Catch:{ Exception -> 0x0025 }
        r4 = (java.security.spec.PKCS8EncodedKeySpec) r4;	 Catch:{ Exception -> 0x0025 }
        r4 = r4.getEncoded();	 Catch:{ Exception -> 0x0025 }
        r4 = org.spongycastle.asn1.pkcs.RSAPrivateKey.m40125a(r4);	 Catch:{ Exception -> 0x0025 }
        r1.<init>(r4);	 Catch:{ Exception -> 0x0025 }
        return r1;
    L_0x0025:
        r4 = new org.spongycastle.jcajce.provider.asymmetric.util.ExtendedInvalidKeySpecException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "unable to process key spec: ";
        r1.append(r2);
        r2 = r0.toString();
        r1.append(r2);
        r1 = r1.toString();
        r4.<init>(r1, r0);
        throw r4;
    L_0x0040:
        r0 = r4 instanceof java.security.spec.RSAPrivateCrtKeySpec;
        if (r0 == 0) goto L_0x004c;
    L_0x0044:
        r0 = new org.spongycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateCrtKey;
        r4 = (java.security.spec.RSAPrivateCrtKeySpec) r4;
        r0.<init>(r4);
        return r0;
    L_0x004c:
        r0 = r4 instanceof java.security.spec.RSAPrivateKeySpec;
        if (r0 == 0) goto L_0x0058;
    L_0x0050:
        r0 = new org.spongycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey;
        r4 = (java.security.spec.RSAPrivateKeySpec) r4;
        r0.<init>(r4);
        return r0;
    L_0x0058:
        r0 = new java.security.spec.InvalidKeySpecException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unknown KeySpec type: ";
        r1.append(r2);
        r4 = r4.getClass();
        r4 = r4.getName();
        r1.append(r4);
        r4 = r1.toString();
        r0.<init>(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi.engineGeneratePrivate(java.security.spec.KeySpec):java.security.PrivateKey");
    }

    protected PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (keySpec instanceof RSAPublicKeySpec) {
            return new BCRSAPublicKey((RSAPublicKeySpec) keySpec);
        }
        return super.engineGeneratePublic(keySpec);
    }

    /* renamed from: a */
    public PrivateKey mo5916a(PrivateKeyInfo privateKeyInfo) {
        ASN1ObjectIdentifier a = privateKeyInfo.m40112a().m40230a();
        if (RSAUtil.m27986a(a)) {
            org.spongycastle.asn1.pkcs.RSAPrivateKey a2 = org.spongycastle.asn1.pkcs.RSAPrivateKey.m40125a(privateKeyInfo.m40114c());
            if (a2.m40134j().intValue() == 0) {
                return new BCRSAPrivateKey(a2);
            }
            return new BCRSAPrivateCrtKey(privateKeyInfo);
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
        if (RSAUtil.m27986a(a)) {
            return new BCRSAPublicKey(subjectPublicKeyInfo);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("algorithm identifier ");
        stringBuilder.append(a);
        stringBuilder.append(" in key not recognised");
        throw new IOException(stringBuilder.toString());
    }
}
