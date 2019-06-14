package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.asn1.ocsp.OCSPResponse;

public class CertificateStatus {
    /* renamed from: a */
    protected short f22469a;
    /* renamed from: b */
    protected Object f22470b;

    public CertificateStatus(short s, Object obj) {
        if (m27551a(s, obj)) {
            this.f22469a = s;
            this.f22470b = obj;
            return;
        }
        throw new IllegalArgumentException("'response' is not an instance of the correct type");
    }

    /* renamed from: a */
    public void m27552a(OutputStream outputStream) {
        TlsUtils.m27817a(this.f22469a, outputStream);
        if (this.f22469a == (short) 1) {
            TlsUtils.m27859c(((OCSPResponse) this.f22470b).m34596a("DER"), outputStream);
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: a */
    public static CertificateStatus m27550a(InputStream inputStream) {
        short a = TlsUtils.m27802a(inputStream);
        if (a == (short) 1) {
            return new CertificateStatus(a, OCSPResponse.m40031a(TlsUtils.m27854c(TlsUtils.m27877g(inputStream))));
        }
        throw new TlsFatalAlert((short) 50);
    }

    /* renamed from: a */
    protected static boolean m27551a(short s, Object obj) {
        if (s == (short) 1) {
            return obj instanceof OCSPResponse;
        }
        throw new IllegalArgumentException("'statusType' is an unsupported value");
    }
}
