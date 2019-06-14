package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.spongycastle.asn1.x500.X500Name;

public class CertificateRequest {
    /* renamed from: a */
    protected short[] f22466a;
    /* renamed from: b */
    protected Vector f22467b;
    /* renamed from: c */
    protected Vector f22468c;

    public CertificateRequest(short[] sArr, Vector vector, Vector vector2) {
        this.f22466a = sArr;
        this.f22467b = vector;
        this.f22468c = vector2;
    }

    /* renamed from: a */
    public short[] m27548a() {
        return this.f22466a;
    }

    /* renamed from: b */
    public Vector m27549b() {
        return this.f22467b;
    }

    /* renamed from: a */
    public void m27547a(OutputStream outputStream) {
        Vector vector;
        int i;
        int i2;
        int i3 = 0;
        if (this.f22466a != null) {
            if (this.f22466a.length != 0) {
                TlsUtils.m27845b(this.f22466a, outputStream);
                if (this.f22467b != null) {
                    TlsUtils.m27810a(this.f22467b, false, outputStream);
                }
                if (this.f22468c != null) {
                    if (this.f22468c.isEmpty()) {
                        vector = new Vector(this.f22468c.size());
                        i = 0;
                        for (i2 = 0; i2 < this.f22468c.size(); i2++) {
                            Object a = ((X500Name) this.f22468c.elementAt(i2)).m34596a("DER");
                            vector.addElement(a);
                            i += a.length + 2;
                        }
                        TlsUtils.m27841b(i);
                        TlsUtils.m27842b(i, outputStream);
                        while (i3 < vector.size()) {
                            TlsUtils.m27844b((byte[]) vector.elementAt(i3), outputStream);
                            i3++;
                        }
                        return;
                    }
                }
                TlsUtils.m27842b(0, outputStream);
            }
        }
        TlsUtils.m27806a(0, outputStream);
        if (this.f22467b != null) {
            TlsUtils.m27810a(this.f22467b, false, outputStream);
        }
        if (this.f22468c != null) {
            if (this.f22468c.isEmpty()) {
                vector = new Vector(this.f22468c.size());
                i = 0;
                for (i2 = 0; i2 < this.f22468c.size(); i2++) {
                    Object a2 = ((X500Name) this.f22468c.elementAt(i2)).m34596a("DER");
                    vector.addElement(a2);
                    i += a2.length + 2;
                }
                TlsUtils.m27841b(i);
                TlsUtils.m27842b(i, outputStream);
                while (i3 < vector.size()) {
                    TlsUtils.m27844b((byte[]) vector.elementAt(i3), outputStream);
                    i3++;
                }
                return;
            }
        }
        TlsUtils.m27842b(0, outputStream);
    }

    /* renamed from: a */
    public static CertificateRequest m27546a(TlsContext tlsContext, InputStream inputStream) {
        short a = TlsUtils.m27802a(inputStream);
        short[] sArr = new short[a];
        for (short s = (short) 0; s < a; s++) {
            sArr[s] = TlsUtils.m27802a(inputStream);
        }
        Vector vector = null;
        if (TlsUtils.m27860c(tlsContext) != null) {
            vector = TlsUtils.m27798a(false, inputStream);
        }
        tlsContext = new Vector();
        InputStream byteArrayInputStream = new ByteArrayInputStream(TlsUtils.m27875f(inputStream));
        while (byteArrayInputStream.available() > null) {
            tlsContext.addElement(X500Name.m40212a(TlsUtils.m27854c(TlsUtils.m27875f(byteArrayInputStream))));
        }
        return new CertificateRequest(sArr, vector, tlsContext);
    }
}
