package expolib_v1.p321a.p322a.p330h;

import expolib_v1.p321a.p322a.C6165c;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;

/* compiled from: OkHostnameVerifier */
/* renamed from: expolib_v1.a.a.h.d */
public final class C6195d implements HostnameVerifier {
    /* renamed from: a */
    public static final C6195d f20052a = new C6195d();

    private C6195d() {
    }

    public boolean verify(java.lang.String r2, javax.net.ssl.SSLSession r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = 0;
        r3 = r3.getPeerCertificates();	 Catch:{ SSLException -> 0x000e }
        r3 = r3[r0];	 Catch:{ SSLException -> 0x000e }
        r3 = (java.security.cert.X509Certificate) r3;	 Catch:{ SSLException -> 0x000e }
        r2 = r1.m25523a(r2, r3);	 Catch:{ SSLException -> 0x000e }
        return r2;
    L_0x000e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.h.d.verify(java.lang.String, javax.net.ssl.SSLSession):boolean");
    }

    /* renamed from: a */
    public boolean m25523a(String str, X509Certificate x509Certificate) {
        if (C6165c.m25326c(str)) {
            return m25521b(str, x509Certificate);
        }
        return m25522c(str, x509Certificate);
    }

    /* renamed from: b */
    private boolean m25521b(String str, X509Certificate x509Certificate) {
        x509Certificate = C6195d.m25519a(x509Certificate, 7);
        int size = x509Certificate.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase((String) x509Certificate.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m25522c(String str, X509Certificate x509Certificate) {
        str = str.toLowerCase(Locale.US);
        List a = C6195d.m25519a(x509Certificate, 2);
        int size = a.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            if (m25520a(str, (String) a.get(i))) {
                return true;
            }
            i++;
            obj = 1;
        }
        if (obj == null) {
            String a2 = new C6194c(x509Certificate.getSubjectX500Principal()).m25517a("cn");
            if (a2 != null) {
                return m25520a(str, a2);
            }
        }
        return false;
    }

    /* renamed from: a */
    public static List<String> m25518a(X509Certificate x509Certificate) {
        Collection a = C6195d.m25519a(x509Certificate, 7);
        x509Certificate = C6195d.m25519a(x509Certificate, 2);
        List<String> arrayList = new ArrayList(a.size() + x509Certificate.size());
        arrayList.addAll(a);
        arrayList.addAll(x509Certificate);
        return arrayList;
    }

    /* renamed from: a */
    private static java.util.List<java.lang.String> m25519a(java.security.cert.X509Certificate r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.util.ArrayList;
        r0.<init>();
        r4 = r4.getSubjectAlternativeNames();	 Catch:{ CertificateParsingException -> 0x0048 }
        if (r4 != 0) goto L_0x0010;	 Catch:{ CertificateParsingException -> 0x0048 }
    L_0x000b:
        r4 = java.util.Collections.emptyList();	 Catch:{ CertificateParsingException -> 0x0048 }
        return r4;	 Catch:{ CertificateParsingException -> 0x0048 }
    L_0x0010:
        r4 = r4.iterator();	 Catch:{ CertificateParsingException -> 0x0048 }
    L_0x0014:
        r1 = r4.hasNext();	 Catch:{ CertificateParsingException -> 0x0048 }
        if (r1 == 0) goto L_0x0047;	 Catch:{ CertificateParsingException -> 0x0048 }
    L_0x001a:
        r1 = r4.next();	 Catch:{ CertificateParsingException -> 0x0048 }
        r1 = (java.util.List) r1;	 Catch:{ CertificateParsingException -> 0x0048 }
        if (r1 == 0) goto L_0x0014;	 Catch:{ CertificateParsingException -> 0x0048 }
    L_0x0022:
        r2 = r1.size();	 Catch:{ CertificateParsingException -> 0x0048 }
        r3 = 2;	 Catch:{ CertificateParsingException -> 0x0048 }
        if (r2 >= r3) goto L_0x002a;	 Catch:{ CertificateParsingException -> 0x0048 }
    L_0x0029:
        goto L_0x0014;	 Catch:{ CertificateParsingException -> 0x0048 }
    L_0x002a:
        r2 = 0;	 Catch:{ CertificateParsingException -> 0x0048 }
        r2 = r1.get(r2);	 Catch:{ CertificateParsingException -> 0x0048 }
        r2 = (java.lang.Integer) r2;	 Catch:{ CertificateParsingException -> 0x0048 }
        if (r2 != 0) goto L_0x0034;	 Catch:{ CertificateParsingException -> 0x0048 }
    L_0x0033:
        goto L_0x0014;	 Catch:{ CertificateParsingException -> 0x0048 }
    L_0x0034:
        r2 = r2.intValue();	 Catch:{ CertificateParsingException -> 0x0048 }
        if (r2 != r5) goto L_0x0014;	 Catch:{ CertificateParsingException -> 0x0048 }
    L_0x003a:
        r2 = 1;	 Catch:{ CertificateParsingException -> 0x0048 }
        r1 = r1.get(r2);	 Catch:{ CertificateParsingException -> 0x0048 }
        r1 = (java.lang.String) r1;	 Catch:{ CertificateParsingException -> 0x0048 }
        if (r1 == 0) goto L_0x0014;	 Catch:{ CertificateParsingException -> 0x0048 }
    L_0x0043:
        r0.add(r1);	 Catch:{ CertificateParsingException -> 0x0048 }
        goto L_0x0014;
    L_0x0047:
        return r0;
    L_0x0048:
        r4 = java.util.Collections.emptyList();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.h.d.a(java.security.cert.X509Certificate, int):java.util.List<java.lang.String>");
    }

    /* renamed from: a */
    private boolean m25520a(String str, String str2) {
        if (!(str == null || str.length() == 0 || str.startsWith("."))) {
            if (!str.endsWith("..")) {
                if (!(str2 == null || str2.length() == 0 || str2.startsWith("."))) {
                    if (!str2.endsWith("..")) {
                        StringBuilder stringBuilder;
                        if (!str.endsWith(".")) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(str);
                            stringBuilder.append('.');
                            str = stringBuilder.toString();
                        }
                        if (!str2.endsWith(".")) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(str2);
                            stringBuilder.append('.');
                            str2 = stringBuilder.toString();
                        }
                        str2 = str2.toLowerCase(Locale.US);
                        if (!str2.contains("*")) {
                            return str.equals(str2);
                        }
                        if (str2.startsWith("*.")) {
                            if (str2.indexOf(42, 1) == -1) {
                                if (str.length() < str2.length() || "*.".equals(str2)) {
                                    return false;
                                }
                                str2 = str2.substring(1);
                                if (!str.endsWith(str2)) {
                                    return false;
                                }
                                int length = str.length() - str2.length();
                                if (length <= 0 || str.lastIndexOf(46, length - 1) == -1) {
                                    return true;
                                }
                                return false;
                            }
                        }
                        return false;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
