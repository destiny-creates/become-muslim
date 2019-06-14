package expolib_v1.p321a.p322a.p330h;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: BasicCertificateChainCleaner */
/* renamed from: expolib_v1.a.a.h.a */
public final class C7471a extends C6193b {
    /* renamed from: a */
    private final C6196e f25923a;

    public C7471a(C6196e c6196e) {
        this.f25923a = c6196e;
    }

    /* renamed from: a */
    public List<Certificate> mo5291a(List<Certificate> list, String str) {
        str = new ArrayDeque(list);
        list = new ArrayList();
        list.add(str.removeFirst());
        Object obj = null;
        for (int i = 0; i < 9; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(list.size() - 1);
            X509Certificate a = this.f25923a.mo5302a(x509Certificate);
            if (a != null) {
                if (list.size() > 1 || !x509Certificate.equals(a)) {
                    list.add(a);
                }
                if (m33920a(a, a)) {
                    return list;
                }
                obj = 1;
            } else {
                Iterator it = str.iterator();
                while (it.hasNext()) {
                    a = (X509Certificate) it.next();
                    if (m33920a(x509Certificate, a)) {
                        it.remove();
                        list.add(a);
                    }
                }
                if (obj != null) {
                    return list;
                }
                str = new StringBuilder();
                str.append("Failed to find a trusted cert that signed ");
                str.append(x509Certificate);
                throw new SSLPeerUnverifiedException(str.toString());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Certificate chain too long: ");
        stringBuilder.append(list);
        throw new SSLPeerUnverifiedException(stringBuilder.toString());
    }

    /* renamed from: a */
    private boolean m33920a(java.security.cert.X509Certificate r3, java.security.cert.X509Certificate r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r3.getIssuerDN();
        r1 = r4.getSubjectDN();
        r0 = r0.equals(r1);
        r1 = 0;
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r4 = r4.getPublicKey();	 Catch:{ GeneralSecurityException -> 0x0019 }
        r3.verify(r4);	 Catch:{ GeneralSecurityException -> 0x0019 }
        r3 = 1;
        return r3;
    L_0x0019:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.h.a.a(java.security.cert.X509Certificate, java.security.cert.X509Certificate):boolean");
    }

    public int hashCode() {
        return this.f25923a.hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C7471a) || ((C7471a) obj).f25923a.equals(this.f25923a) == null) {
            z = false;
        }
        return z;
    }
}
