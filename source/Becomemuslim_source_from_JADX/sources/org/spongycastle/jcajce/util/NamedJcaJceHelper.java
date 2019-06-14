package org.spongycastle.jcajce.util;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;

public class NamedJcaJceHelper implements JcaJceHelper {
    /* renamed from: a */
    protected final String f27508a;

    /* renamed from: a */
    public Cipher mo5876a(String str) {
        return Cipher.getInstance(str, this.f27508a);
    }

    /* renamed from: b */
    public Mac mo5877b(String str) {
        return Mac.getInstance(str, this.f27508a);
    }

    /* renamed from: c */
    public AlgorithmParameters mo5878c(String str) {
        return AlgorithmParameters.getInstance(str, this.f27508a);
    }

    /* renamed from: d */
    public KeyFactory mo5879d(String str) {
        return KeyFactory.getInstance(str, this.f27508a);
    }

    /* renamed from: e */
    public SecretKeyFactory mo5880e(String str) {
        return SecretKeyFactory.getInstance(str, this.f27508a);
    }

    /* renamed from: f */
    public Signature mo5881f(String str) {
        return Signature.getInstance(str, this.f27508a);
    }

    /* renamed from: g */
    public CertificateFactory mo5882g(String str) {
        return CertificateFactory.getInstance(str, this.f27508a);
    }
}
