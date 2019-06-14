package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;

public interface TlsKeyExchange {
    /* renamed from: a */
    void mo5813a(InputStream inputStream);

    /* renamed from: a */
    void mo6488a(OutputStream outputStream);

    /* renamed from: a */
    void mo5814a(Certificate certificate);

    /* renamed from: a */
    void mo6489a(CertificateRequest certificateRequest);

    /* renamed from: a */
    void mo5815a(TlsContext tlsContext);

    /* renamed from: a */
    void mo5816a(TlsCredentials tlsCredentials);

    /* renamed from: b */
    void mo5817b(InputStream inputStream);

    /* renamed from: b */
    void mo5818b(Certificate certificate);

    /* renamed from: b */
    void mo6491b(TlsCredentials tlsCredentials);

    /* renamed from: b */
    byte[] mo5819b();

    /* renamed from: c */
    void mo5820c();

    /* renamed from: d */
    void mo5821d();

    /* renamed from: e */
    void mo6492e();

    /* renamed from: f */
    byte[] mo6493f();
}
