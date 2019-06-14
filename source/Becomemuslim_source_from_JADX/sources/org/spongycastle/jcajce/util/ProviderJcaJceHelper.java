package org.spongycastle.jcajce.util;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;

public class ProviderJcaJceHelper implements JcaJceHelper {
    /* renamed from: a */
    protected final Provider f27509a;

    public ProviderJcaJceHelper(Provider provider) {
        this.f27509a = provider;
    }

    /* renamed from: a */
    public Cipher mo5876a(String str) {
        return Cipher.getInstance(str, this.f27509a);
    }

    /* renamed from: b */
    public Mac mo5877b(String str) {
        return Mac.getInstance(str, this.f27509a);
    }

    /* renamed from: c */
    public AlgorithmParameters mo5878c(String str) {
        return AlgorithmParameters.getInstance(str, this.f27509a);
    }

    /* renamed from: d */
    public KeyFactory mo5879d(String str) {
        return KeyFactory.getInstance(str, this.f27509a);
    }

    /* renamed from: e */
    public SecretKeyFactory mo5880e(String str) {
        return SecretKeyFactory.getInstance(str, this.f27509a);
    }

    /* renamed from: f */
    public Signature mo5881f(String str) {
        return Signature.getInstance(str, this.f27509a);
    }

    /* renamed from: g */
    public CertificateFactory mo5882g(String str) {
        return CertificateFactory.getInstance(str, this.f27509a);
    }
}
