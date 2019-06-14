package org.spongycastle.jce.provider;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.react.uimanager.ViewProps;
import java.io.ByteArrayInputStream;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreSpi;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.jce.X509LDAPCertStoreParameters;

public class X509LDAPCertStoreSpi extends CertStoreSpi {
    /* renamed from: b */
    private static String f23040b = "com.sun.jndi.ldap.LdapCtxFactory";
    /* renamed from: c */
    private static String f23041c = "ignore";
    /* renamed from: a */
    private X509LDAPCertStoreParameters f23042a;

    /* renamed from: a */
    private DirContext m28303a() {
        Hashtable properties = new Properties();
        properties.setProperty("java.naming.factory.initial", f23040b);
        properties.setProperty("java.naming.batchsize", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        properties.setProperty("java.naming.provider.url", this.f23042a.m36153F());
        properties.setProperty("java.naming.factory.url.pkgs", "com.sun.jndi.url");
        properties.setProperty("java.naming.referral", f23041c);
        properties.setProperty("java.naming.security.authentication", ViewProps.NONE);
        return new InitialDirContext(properties);
    }

    /* renamed from: a */
    private String m28299a(String str, String str2) {
        str = str.substring(str.toLowerCase().indexOf(str2.toLowerCase()) + str2.length());
        int indexOf = str.indexOf(44);
        if (indexOf == -1) {
            indexOf = str.length();
        }
        while (str.charAt(indexOf - 1) == '\\') {
            indexOf = str.indexOf(44, indexOf + 1);
            if (indexOf == -1) {
                indexOf = str.length();
            }
        }
        str = str.substring(0, indexOf);
        str = str.substring(str.indexOf(61) + 1);
        if (str.charAt(0) == ' ') {
            str = str.substring(1);
        }
        if (str.startsWith("\"")) {
            str = str.substring(1);
        }
        return str.endsWith("\"") ? str.substring(0, str.length() - 1) : str;
    }

    public java.util.Collection engineGetCertificates(java.security.cert.CertSelector r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r7 instanceof java.security.cert.X509CertSelector;
        if (r0 == 0) goto L_0x00b5;
    L_0x0004:
        r7 = (java.security.cert.X509CertSelector) r7;
        r0 = new java.util.HashSet;
        r0.<init>();
        r1 = r6.m28301a(r7);
        r2 = r6.m28304b(r7);
        r1.addAll(r2);
        r2 = r6.m28305c(r7);
        r1.addAll(r2);
        r1 = r1.iterator();
        r2 = "X.509";	 Catch:{ Exception -> 0x009d }
        r3 = "SC";	 Catch:{ Exception -> 0x009d }
        r2 = java.security.cert.CertificateFactory.getInstance(r2, r3);	 Catch:{ Exception -> 0x009d }
    L_0x0029:
        r3 = r1.hasNext();	 Catch:{ Exception -> 0x009d }
        if (r3 == 0) goto L_0x009c;	 Catch:{ Exception -> 0x009d }
    L_0x002f:
        r3 = r1.next();	 Catch:{ Exception -> 0x009d }
        r3 = (byte[]) r3;	 Catch:{ Exception -> 0x009d }
        r3 = (byte[]) r3;	 Catch:{ Exception -> 0x009d }
        if (r3 == 0) goto L_0x0029;	 Catch:{ Exception -> 0x009d }
    L_0x0039:
        r4 = r3.length;	 Catch:{ Exception -> 0x009d }
        if (r4 != 0) goto L_0x003d;	 Catch:{ Exception -> 0x009d }
    L_0x003c:
        goto L_0x0029;	 Catch:{ Exception -> 0x009d }
    L_0x003d:
        r4 = new java.util.ArrayList;	 Catch:{ Exception -> 0x009d }
        r4.<init>();	 Catch:{ Exception -> 0x009d }
        r4.add(r3);	 Catch:{ Exception -> 0x009d }
        r5 = new org.spongycastle.asn1.ASN1InputStream;	 Catch:{ IOException -> 0x0077, IOException -> 0x0077 }
        r5.<init>(r3);	 Catch:{ IOException -> 0x0077, IOException -> 0x0077 }
        r3 = r5.m34595d();	 Catch:{ IOException -> 0x0077, IOException -> 0x0077 }
        r3 = org.spongycastle.asn1.x509.CertificatePair.m40295a(r3);	 Catch:{ IOException -> 0x0077, IOException -> 0x0077 }
        r4.clear();	 Catch:{ IOException -> 0x0077, IOException -> 0x0077 }
        r5 = r3.m40296a();	 Catch:{ IOException -> 0x0077, IOException -> 0x0077 }
        if (r5 == 0) goto L_0x0066;	 Catch:{ IOException -> 0x0077, IOException -> 0x0077 }
    L_0x005b:
        r5 = r3.m40296a();	 Catch:{ IOException -> 0x0077, IOException -> 0x0077 }
        r5 = r5.mo6822f();	 Catch:{ IOException -> 0x0077, IOException -> 0x0077 }
        r4.add(r5);	 Catch:{ IOException -> 0x0077, IOException -> 0x0077 }
    L_0x0066:
        r5 = r3.m40297b();	 Catch:{ IOException -> 0x0077, IOException -> 0x0077 }
        if (r5 == 0) goto L_0x0077;	 Catch:{ IOException -> 0x0077, IOException -> 0x0077 }
    L_0x006c:
        r3 = r3.m40297b();	 Catch:{ IOException -> 0x0077, IOException -> 0x0077 }
        r3 = r3.mo6822f();	 Catch:{ IOException -> 0x0077, IOException -> 0x0077 }
        r4.add(r3);	 Catch:{ IOException -> 0x0077, IOException -> 0x0077 }
    L_0x0077:
        r3 = r4.iterator();	 Catch:{ Exception -> 0x009d }
    L_0x007b:
        r4 = r3.hasNext();	 Catch:{ Exception -> 0x009d }
        if (r4 == 0) goto L_0x0029;	 Catch:{ Exception -> 0x009d }
    L_0x0081:
        r4 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x009d }
        r5 = r3.next();	 Catch:{ Exception -> 0x009d }
        r5 = (byte[]) r5;	 Catch:{ Exception -> 0x009d }
        r5 = (byte[]) r5;	 Catch:{ Exception -> 0x009d }
        r4.<init>(r5);	 Catch:{ Exception -> 0x009d }
        r4 = r2.generateCertificate(r4);	 Catch:{ Exception -> 0x007b }
        r5 = r7.match(r4);	 Catch:{ Exception -> 0x007b }
        if (r5 == 0) goto L_0x007b;	 Catch:{ Exception -> 0x007b }
    L_0x0098:
        r0.add(r4);	 Catch:{ Exception -> 0x007b }
        goto L_0x007b;
    L_0x009c:
        return r0;
    L_0x009d:
        r7 = move-exception;
        r0 = new java.security.cert.CertStoreException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "certificate cannot be constructed from LDAP result: ";
        r1.append(r2);
        r1.append(r7);
        r7 = r1.toString();
        r0.<init>(r7);
        throw r0;
    L_0x00b5:
        r7 = new java.security.cert.CertStoreException;
        r0 = "selector is not a X509CertSelector";
        r7.<init>(r0);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.X509LDAPCertStoreSpi.engineGetCertificates(java.security.cert.CertSelector):java.util.Collection");
    }

    /* renamed from: a */
    private Set m28302a(X509CertSelector x509CertSelector, String[] strArr, String str, String str2) {
        Set hashSet = new HashSet();
        try {
            if (x509CertSelector.getSubjectAsBytes() == null && x509CertSelector.getSubjectAsString() == null) {
                if (x509CertSelector.getCertificate() == null) {
                    hashSet.addAll(m28300a(str, "*", strArr));
                    return hashSet;
                }
            }
            String str3 = null;
            if (x509CertSelector.getCertificate() != null) {
                String name = x509CertSelector.getCertificate().getSubjectX500Principal().getName("RFC1779");
                str3 = x509CertSelector.getCertificate().getSerialNumber().toString();
                x509CertSelector = name;
            } else if (x509CertSelector.getSubjectAsBytes() != null) {
                x509CertSelector = new X500Principal(x509CertSelector.getSubjectAsBytes()).getName("RFC1779");
            } else {
                x509CertSelector = x509CertSelector.getSubjectAsString();
            }
            x509CertSelector = m28299a(x509CertSelector, str2);
            str2 = new StringBuilder();
            str2.append("*");
            str2.append(x509CertSelector);
            str2.append("*");
            hashSet.addAll(m28300a(str, str2.toString(), strArr));
            if (!(str3 == null || this.f23042a.m36155H() == null)) {
                x509CertSelector = this.f23042a.m36155H();
                str = new StringBuilder();
                str.append("*");
                str.append(str3);
                str.append("*");
                hashSet.addAll(m28300a(x509CertSelector, str.toString(), strArr));
            }
            return hashSet;
        } catch (X509CertSelector x509CertSelector2) {
            str = new StringBuilder();
            str.append("exception processing selector: ");
            str.append(x509CertSelector2);
            throw new CertStoreException(str.toString());
        }
    }

    /* renamed from: a */
    private Set m28301a(X509CertSelector x509CertSelector) {
        return m28302a(x509CertSelector, new String[]{this.f23042a.m36156I()}, this.f23042a.m36154G(), this.f23042a.m36157J());
    }

    /* renamed from: b */
    private Set m28304b(X509CertSelector x509CertSelector) {
        String[] strArr = new String[]{this.f23042a.m36171n()};
        x509CertSelector = m28302a(x509CertSelector, strArr, this.f23042a.m36149B(), this.f23042a.m36172o());
        if (x509CertSelector.isEmpty()) {
            x509CertSelector.addAll(m28300a(null, "*", strArr));
        }
        return x509CertSelector;
    }

    /* renamed from: c */
    private Set m28305c(X509CertSelector x509CertSelector) {
        String[] strArr = new String[]{this.f23042a.m36175r()};
        x509CertSelector = m28302a(x509CertSelector, strArr, this.f23042a.m36151D(), this.f23042a.m36176s());
        if (x509CertSelector.isEmpty()) {
            x509CertSelector.addAll(m28300a(null, "*", strArr));
        }
        return x509CertSelector;
    }

    public Collection engineGetCRLs(CRLSelector cRLSelector) {
        String[] strArr = new String[]{this.f23042a.m36173p()};
        if (cRLSelector instanceof X509CRLSelector) {
            X509CRLSelector x509CRLSelector = (X509CRLSelector) cRLSelector;
            Collection hashSet = new HashSet();
            String C = this.f23042a.m36150C();
            Set<byte[]> hashSet2 = new HashSet();
            if (x509CRLSelector.getIssuerNames() != null) {
                for (Object next : x509CRLSelector.getIssuerNames()) {
                    String a;
                    if (next instanceof String) {
                        a = m28299a((String) next, this.f23042a.m36174q());
                    } else {
                        a = m28299a(new X500Principal((byte[]) next).getName("RFC1779"), this.f23042a.m36174q());
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("*");
                    stringBuilder.append(a);
                    stringBuilder.append("*");
                    hashSet2.addAll(m28300a(C, stringBuilder.toString(), strArr));
                }
            } else {
                hashSet2.addAll(m28300a(C, "*", strArr));
            }
            hashSet2.addAll(m28300a(null, "*", strArr));
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509", "SC");
                for (byte[] byteArrayInputStream : hashSet2) {
                    CRL generateCRL = instance.generateCRL(new ByteArrayInputStream(byteArrayInputStream));
                    if (x509CRLSelector.match(generateCRL)) {
                        hashSet.add(generateCRL);
                    }
                }
                return hashSet;
            } catch (CRLSelector cRLSelector2) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("CRL cannot be constructed from LDAP result ");
                stringBuilder2.append(cRLSelector2);
                throw new CertStoreException(stringBuilder2.toString());
            }
        }
        throw new CertStoreException("selector is not a X509CRLSelector");
    }

    /* renamed from: a */
    private java.util.Set m28300a(java.lang.String r8, java.lang.String r9, java.lang.String[] r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r8);
        r1 = "=";
        r0.append(r1);
        r0.append(r9);
        r9 = r0.toString();
        r0 = 0;
        if (r8 != 0) goto L_0x0018;
    L_0x0017:
        r9 = r0;
    L_0x0018:
        r8 = new java.util.HashSet;
        r8.<init>();
        r1 = r7.m28303a();	 Catch:{ Exception -> 0x00bf }
        r0 = new javax.naming.directory.SearchControls;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r0.<init>();	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r2 = 2;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r0.setSearchScope(r2);	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r2 = 0;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r0.setCountLimit(r2);	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r2 = 0;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r3 = 0;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
    L_0x0031:
        r4 = r10.length;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        if (r3 >= r4) goto L_0x00b1;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
    L_0x0034:
        r4 = 1;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5 = r10[r3];	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r4[r2] = r5;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r0.setReturningAttributes(r4);	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5.<init>();	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r6 = "(&(";	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5.append(r6);	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5.append(r9);	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r6 = ")(";	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5.append(r6);	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r6 = r4[r2];	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5.append(r6);	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r6 = "=*))";	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5.append(r6);	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        if (r9 != 0) goto L_0x0078;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
    L_0x0060:
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5.<init>();	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r6 = "(";	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5.append(r6);	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r4 = r4[r2];	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5.append(r4);	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r4 = "=*)";	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5.append(r4);	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
    L_0x0078:
        r4 = r7.f23042a;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r4 = r4.m36170m();	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r4 = r1.search(r4, r5, r0);	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
    L_0x0082:
        r5 = r4.hasMoreElements();	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        if (r5 == 0) goto L_0x00ae;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
    L_0x0088:
        r5 = r4.next();	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5 = (javax.naming.directory.SearchResult) r5;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5 = r5.getAttributes();	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5 = r5.getAll();	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5 = r5.next();	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5 = (javax.naming.directory.Attribute) r5;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r5 = r5.getAll();	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
    L_0x00a0:
        r6 = r5.hasMore();	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        if (r6 == 0) goto L_0x0082;	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
    L_0x00a6:
        r6 = r5.next();	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        r8.add(r6);	 Catch:{ Exception -> 0x00b9, all -> 0x00b7 }
        goto L_0x00a0;
    L_0x00ae:
        r3 = r3 + 1;
        goto L_0x0031;
    L_0x00b1:
        if (r1 == 0) goto L_0x00b6;
    L_0x00b3:
        r1.close();	 Catch:{ Exception -> 0x00b6 }
    L_0x00b6:
        return r8;
    L_0x00b7:
        r8 = move-exception;
        goto L_0x00d7;
    L_0x00b9:
        r8 = move-exception;
        r0 = r1;
        goto L_0x00c0;
    L_0x00bc:
        r8 = move-exception;
        r1 = r0;
        goto L_0x00d7;
    L_0x00bf:
        r8 = move-exception;
    L_0x00c0:
        r9 = new java.security.cert.CertStoreException;	 Catch:{ all -> 0x00bc }
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00bc }
        r10.<init>();	 Catch:{ all -> 0x00bc }
        r1 = "Error getting results from LDAP directory ";	 Catch:{ all -> 0x00bc }
        r10.append(r1);	 Catch:{ all -> 0x00bc }
        r10.append(r8);	 Catch:{ all -> 0x00bc }
        r8 = r10.toString();	 Catch:{ all -> 0x00bc }
        r9.<init>(r8);	 Catch:{ all -> 0x00bc }
        throw r9;	 Catch:{ all -> 0x00bc }
    L_0x00d7:
        if (r1 == 0) goto L_0x00dc;
    L_0x00d9:
        r1.close();	 Catch:{ Exception -> 0x00dc }
    L_0x00dc:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.X509LDAPCertStoreSpi.a(java.lang.String, java.lang.String, java.lang.String[]):java.util.Set");
    }
}
