package org.spongycastle.jcajce.util;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;

public interface JcaJceHelper {
    /* renamed from: a */
    Cipher mo5876a(String str);

    /* renamed from: b */
    Mac mo5877b(String str);

    /* renamed from: c */
    AlgorithmParameters mo5878c(String str);

    /* renamed from: d */
    KeyFactory mo5879d(String str);

    /* renamed from: e */
    SecretKeyFactory mo5880e(String str);

    /* renamed from: f */
    Signature mo5881f(String str);

    /* renamed from: g */
    CertificateFactory mo5882g(String str);
}
