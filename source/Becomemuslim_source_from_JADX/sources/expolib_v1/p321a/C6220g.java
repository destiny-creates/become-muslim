package expolib_v1.p321a;

import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p330h.C6193b;
import expolib_v1.p332b.C6251f;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: CertificatePinner */
/* renamed from: expolib_v1.a.g */
public final class C6220g {
    /* renamed from: a */
    public static final C6220g f20182a = new C6218a().m25638a();
    /* renamed from: b */
    private final Set<C6219b> f20183b;
    /* renamed from: c */
    private final C6193b f20184c;

    /* compiled from: CertificatePinner */
    /* renamed from: expolib_v1.a.g$a */
    public static final class C6218a {
        /* renamed from: a */
        private final List<C6219b> f20177a = new ArrayList();

        /* renamed from: a */
        public C6220g m25638a() {
            return new C6220g(new LinkedHashSet(this.f20177a), null);
        }
    }

    /* compiled from: CertificatePinner */
    /* renamed from: expolib_v1.a.g$b */
    static final class C6219b {
        /* renamed from: a */
        final String f20178a;
        /* renamed from: b */
        final String f20179b;
        /* renamed from: c */
        final String f20180c;
        /* renamed from: d */
        final C6251f f20181d;

        /* renamed from: a */
        boolean m25639a(String str) {
            if (!this.f20178a.startsWith("*.")) {
                return str.equals(this.f20179b);
            }
            return str.regionMatches(false, str.indexOf(46) + 1, this.f20179b, 0, this.f20179b.length());
        }

        public boolean equals(Object obj) {
            if (obj instanceof C6219b) {
                C6219b c6219b = (C6219b) obj;
                if (this.f20178a.equals(c6219b.f20178a) && this.f20180c.equals(c6219b.f20180c) && this.f20181d.equals(c6219b.f20181d) != null) {
                    return true;
                }
            }
            return null;
        }

        public int hashCode() {
            return ((((527 + this.f20178a.hashCode()) * 31) + this.f20180c.hashCode()) * 31) + this.f20181d.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f20180c);
            stringBuilder.append(this.f20181d.mo5359b());
            return stringBuilder.toString();
        }
    }

    C6220g(Set<C6219b> set, C6193b c6193b) {
        this.f20183b = set;
        this.f20184c = c6193b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof C6220g) {
            C6220g c6220g = (C6220g) obj;
            if (C6165c.m25319a(this.f20184c, c6220g.f20184c) && this.f20183b.equals(c6220g.f20183b) != null) {
                return z;
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        return ((this.f20184c != null ? this.f20184c.hashCode() : 0) * 31) + this.f20183b.hashCode();
    }

    /* renamed from: a */
    public void m25645a(String str, List<Certificate> list) {
        List a = m25644a(str);
        if (!a.isEmpty()) {
            int i;
            if (this.f20184c != null) {
                list = this.f20184c.mo5291a(list, str);
            }
            int size = list.size();
            for (i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = a.size();
                Object obj = null;
                Object obj2 = obj;
                for (int i2 = 0; i2 < size2; i2++) {
                    C6219b c6219b = (C6219b) a.get(i2);
                    if (c6219b.f20180c.equals("sha256/")) {
                        if (obj == null) {
                            obj = C6220g.m25642b(x509Certificate);
                        }
                        if (c6219b.f20181d.equals(obj)) {
                            return;
                        }
                    } else if (c6219b.f20180c.equals("sha1/")) {
                        if (obj2 == null) {
                            obj2 = C6220g.m25640a(x509Certificate);
                        }
                        if (c6219b.f20181d.equals(obj2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Certificate pinning failure!");
            stringBuilder.append("\n  Peer certificate chain:");
            i = list.size();
            for (int i3 = 0; i3 < i; i3++) {
                Certificate certificate = (X509Certificate) list.get(i3);
                stringBuilder.append("\n    ");
                stringBuilder.append(C6220g.m25641a(certificate));
                stringBuilder.append(": ");
                stringBuilder.append(certificate.getSubjectDN().getName());
            }
            stringBuilder.append("\n  Pinned certificates for ");
            stringBuilder.append(str);
            stringBuilder.append(":");
            str = a.size();
            for (int i4 = 0; i4 < str; i4++) {
                C6219b c6219b2 = (C6219b) a.get(i4);
                stringBuilder.append("\n    ");
                stringBuilder.append(c6219b2);
            }
            throw new SSLPeerUnverifiedException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    List<C6219b> m25644a(String str) {
        List<C6219b> emptyList = Collections.emptyList();
        for (C6219b c6219b : this.f20183b) {
            if (c6219b.m25639a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                emptyList.add(c6219b);
            }
        }
        return emptyList;
    }

    /* renamed from: a */
    C6220g m25643a(C6193b c6193b) {
        return C6165c.m25319a(this.f20184c, (Object) c6193b) ? this : new C6220g(this.f20183b, c6193b);
    }

    /* renamed from: a */
    public static String m25641a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sha256/");
            stringBuilder.append(C6220g.m25642b((X509Certificate) certificate).mo5359b());
            return stringBuilder.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* renamed from: a */
    static C6251f m25640a(X509Certificate x509Certificate) {
        return C6251f.m25838a(x509Certificate.getPublicKey().getEncoded()).mo5361d();
    }

    /* renamed from: b */
    static C6251f m25642b(X509Certificate x509Certificate) {
        return C6251f.m25838a(x509Certificate.getPublicKey().getEncoded()).mo5362e();
    }
}
