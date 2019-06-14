package org.spongycastle.x509;

import java.math.BigInteger;
import java.security.cert.X509Extension;
import java.util.Date;

public interface X509AttributeCertificate extends X509Extension {
    /* renamed from: a */
    BigInteger mo5942a();

    /* renamed from: a */
    void mo5943a(Date date);

    /* renamed from: a */
    X509Attribute[] mo5944a(String str);

    /* renamed from: b */
    Date mo5945b();

    /* renamed from: c */
    AttributeCertificateHolder mo5946c();

    /* renamed from: d */
    AttributeCertificateIssuer mo5947d();

    /* renamed from: e */
    byte[] mo5948e();
}
