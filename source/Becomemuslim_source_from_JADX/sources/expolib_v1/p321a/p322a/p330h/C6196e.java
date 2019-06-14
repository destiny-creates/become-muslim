package expolib_v1.p321a.p322a.p330h;

import java.lang.reflect.Method;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* compiled from: TrustRootIndex */
/* renamed from: expolib_v1.a.a.h.e */
public abstract class C6196e {

    /* compiled from: TrustRootIndex */
    /* renamed from: expolib_v1.a.a.h.e$a */
    static final class C7472a extends C6196e {
        /* renamed from: a */
        private final X509TrustManager f25924a;
        /* renamed from: b */
        private final Method f25925b;

        C7472a(X509TrustManager x509TrustManager, Method method) {
            this.f25925b = method;
            this.f25924a = x509TrustManager;
        }

        /* renamed from: a */
        public java.security.cert.X509Certificate mo5302a(java.security.cert.X509Certificate r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r5 = this;
            r0 = 0;
            r1 = r5.f25925b;	 Catch:{ IllegalAccessException -> 0x001b, InvocationTargetException -> 0x001a }
            r2 = r5.f25924a;	 Catch:{ IllegalAccessException -> 0x001b, InvocationTargetException -> 0x001a }
            r3 = 1;	 Catch:{ IllegalAccessException -> 0x001b, InvocationTargetException -> 0x001a }
            r3 = new java.lang.Object[r3];	 Catch:{ IllegalAccessException -> 0x001b, InvocationTargetException -> 0x001a }
            r4 = 0;	 Catch:{ IllegalAccessException -> 0x001b, InvocationTargetException -> 0x001a }
            r3[r4] = r6;	 Catch:{ IllegalAccessException -> 0x001b, InvocationTargetException -> 0x001a }
            r6 = r1.invoke(r2, r3);	 Catch:{ IllegalAccessException -> 0x001b, InvocationTargetException -> 0x001a }
            r6 = (java.security.cert.TrustAnchor) r6;	 Catch:{ IllegalAccessException -> 0x001b, InvocationTargetException -> 0x001a }
            if (r6 == 0) goto L_0x0018;	 Catch:{ IllegalAccessException -> 0x001b, InvocationTargetException -> 0x001a }
        L_0x0013:
            r6 = r6.getTrustedCert();	 Catch:{ IllegalAccessException -> 0x001b, InvocationTargetException -> 0x001a }
            goto L_0x0019;
        L_0x0018:
            r6 = r0;
        L_0x0019:
            return r6;
        L_0x001a:
            return r0;
        L_0x001b:
            r6 = new java.lang.AssertionError;
            r6.<init>();
            throw r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.h.e.a.a(java.security.cert.X509Certificate):java.security.cert.X509Certificate");
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C7472a)) {
                return false;
            }
            C7472a c7472a = (C7472a) obj;
            if (!this.f25924a.equals(c7472a.f25924a) || this.f25925b.equals(c7472a.f25925b) == null) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return this.f25924a.hashCode() + (this.f25925b.hashCode() * 31);
        }
    }

    /* compiled from: TrustRootIndex */
    /* renamed from: expolib_v1.a.a.h.e$b */
    static final class C7473b extends C6196e {
        /* renamed from: a */
        private final Map<X500Principal, Set<X509Certificate>> f25926a = new LinkedHashMap();

        public C7473b(X509Certificate... x509CertificateArr) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                Set set = (Set) this.f25926a.get(subjectX500Principal);
                if (set == null) {
                    set = new LinkedHashSet(1);
                    this.f25926a.put(subjectX500Principal, set);
                }
                set.add(x509Certificate);
            }
        }

        /* renamed from: a */
        public java.security.cert.X509Certificate mo5302a(java.security.cert.X509Certificate r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = r5.getIssuerX500Principal();
            r1 = r4.f25926a;
            r0 = r1.get(r0);
            r0 = (java.util.Set) r0;
            r1 = 0;
            if (r0 != 0) goto L_0x0010;
        L_0x000f:
            return r1;
        L_0x0010:
            r0 = r0.iterator();
        L_0x0014:
            r2 = r0.hasNext();
            if (r2 == 0) goto L_0x0028;
        L_0x001a:
            r2 = r0.next();
            r2 = (java.security.cert.X509Certificate) r2;
            r3 = r2.getPublicKey();
            r5.verify(r3);	 Catch:{ Exception -> 0x0014 }
            return r2;
        L_0x0028:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.h.e.b.a(java.security.cert.X509Certificate):java.security.cert.X509Certificate");
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C7473b) || ((C7473b) obj).f25926a.equals(this.f25926a) == null) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return this.f25926a.hashCode();
        }
    }

    /* renamed from: a */
    public abstract X509Certificate mo5302a(X509Certificate x509Certificate);

    /* renamed from: a */
    public static expolib_v1.p321a.p322a.p330h.C6196e m25524a(javax.net.ssl.X509TrustManager r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r6.getClass();	 Catch:{ NoSuchMethodException -> 0x001b }
        r1 = "findTrustAnchorByIssuerAndSignature";	 Catch:{ NoSuchMethodException -> 0x001b }
        r2 = 1;	 Catch:{ NoSuchMethodException -> 0x001b }
        r3 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x001b }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x001b }
        r5 = java.security.cert.X509Certificate.class;	 Catch:{ NoSuchMethodException -> 0x001b }
        r3[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x001b }
        r0 = r0.getDeclaredMethod(r1, r3);	 Catch:{ NoSuchMethodException -> 0x001b }
        r0.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x001b }
        r1 = new expolib_v1.a.a.h.e$a;	 Catch:{ NoSuchMethodException -> 0x001b }
        r1.<init>(r6, r0);	 Catch:{ NoSuchMethodException -> 0x001b }
        return r1;
    L_0x001b:
        r6 = r6.getAcceptedIssuers();
        r6 = expolib_v1.p321a.p322a.p330h.C6196e.m25525a(r6);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.h.e.a(javax.net.ssl.X509TrustManager):expolib_v1.a.a.h.e");
    }

    /* renamed from: a */
    public static C6196e m25525a(X509Certificate... x509CertificateArr) {
        return new C7473b(x509CertificateArr);
    }
}
