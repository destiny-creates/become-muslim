package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

public class Certificate {
    /* renamed from: a */
    public static final Certificate f22464a = new Certificate(new org.spongycastle.asn1.x509.Certificate[0]);
    /* renamed from: b */
    protected org.spongycastle.asn1.x509.Certificate[] f22465b;

    public Certificate(org.spongycastle.asn1.x509.Certificate[] certificateArr) {
        if (certificateArr != null) {
            this.f22465b = certificateArr;
            return;
        }
        throw new IllegalArgumentException("'certificateList' cannot be null");
    }

    /* renamed from: a */
    public org.spongycastle.asn1.x509.Certificate m27543a(int i) {
        return this.f22465b[i];
    }

    /* renamed from: a */
    public boolean m27545a() {
        return this.f22465b.length == 0;
    }

    /* renamed from: a */
    public void m27544a(OutputStream outputStream) {
        Vector vector = new Vector(this.f22465b.length);
        int i = 0;
        for (org.spongycastle.asn1.x509.Certificate a : this.f22465b) {
            Object a2 = a.m34596a("DER");
            vector.addElement(a2);
            i += a2.length + 3;
        }
        TlsUtils.m27856c(i);
        TlsUtils.m27857c(i, outputStream);
        for (int i2 = 0; i2 < vector.size(); i2++) {
            TlsUtils.m27859c((byte[]) vector.elementAt(i2), outputStream);
        }
    }

    /* renamed from: a */
    public static Certificate m27542a(InputStream inputStream) {
        int c = TlsUtils.m27851c(inputStream);
        if (c == 0) {
            return f22464a;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(TlsUtils.m27849b(c, inputStream));
        inputStream = new Vector();
        while (byteArrayInputStream.available() > 0) {
            inputStream.addElement(org.spongycastle.asn1.x509.Certificate.m40272a(TlsUtils.m27854c(TlsUtils.m27877g(byteArrayInputStream))));
        }
        org.spongycastle.asn1.x509.Certificate[] certificateArr = new org.spongycastle.asn1.x509.Certificate[inputStream.size()];
        for (int i = 0; i < inputStream.size(); i++) {
            certificateArr[i] = (org.spongycastle.asn1.x509.Certificate) inputStream.elementAt(i);
        }
        return new Certificate(certificateArr);
    }
}
