package org.spongycastle.jcajce.provider.asymmetric.util;

import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public abstract class BaseKeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    protected java.security.PrivateKey engineGeneratePrivate(java.security.spec.KeySpec r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r2 instanceof java.security.spec.PKCS8EncodedKeySpec;
        if (r0 == 0) goto L_0x001b;
    L_0x0004:
        r2 = (java.security.spec.PKCS8EncodedKeySpec) r2;	 Catch:{ Exception -> 0x0013 }
        r2 = r2.getEncoded();	 Catch:{ Exception -> 0x0013 }
        r2 = org.spongycastle.asn1.pkcs.PrivateKeyInfo.m40111a(r2);	 Catch:{ Exception -> 0x0013 }
        r2 = r1.mo5916a(r2);	 Catch:{ Exception -> 0x0013 }
        return r2;
    L_0x0013:
        r2 = new java.security.spec.InvalidKeySpecException;
        r0 = "encoded key spec not recognised";
        r2.<init>(r0);
        throw r2;
    L_0x001b:
        r2 = new java.security.spec.InvalidKeySpecException;
        r0 = "key spec not recognised";
        r2.<init>(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi.engineGeneratePrivate(java.security.spec.KeySpec):java.security.PrivateKey");
    }

    protected java.security.PublicKey engineGeneratePublic(java.security.spec.KeySpec r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r2 instanceof java.security.spec.X509EncodedKeySpec;
        if (r0 == 0) goto L_0x001b;
    L_0x0004:
        r2 = (java.security.spec.X509EncodedKeySpec) r2;	 Catch:{ Exception -> 0x0013 }
        r2 = r2.getEncoded();	 Catch:{ Exception -> 0x0013 }
        r2 = org.spongycastle.asn1.x509.SubjectPublicKeyInfo.m40409a(r2);	 Catch:{ Exception -> 0x0013 }
        r2 = r1.mo5917a(r2);	 Catch:{ Exception -> 0x0013 }
        return r2;
    L_0x0013:
        r2 = new java.security.spec.InvalidKeySpecException;
        r0 = "encoded key spec not recognised";
        r2.<init>(r0);
        throw r2;
    L_0x001b:
        r2 = new java.security.spec.InvalidKeySpecException;
        r0 = "key spec not recognised";
        r2.<init>(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi.engineGeneratePublic(java.security.spec.KeySpec):java.security.PublicKey");
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
}
