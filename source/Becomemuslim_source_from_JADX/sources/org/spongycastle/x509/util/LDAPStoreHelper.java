package org.spongycastle.x509.util;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.react.uimanager.ViewProps;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.jce.X509LDAPCertStoreParameters;
import org.spongycastle.util.StoreException;
import org.spongycastle.x509.X509AttributeCertStoreSelector;
import org.spongycastle.x509.X509CRLStoreSelector;
import org.spongycastle.x509.X509CertPairStoreSelector;
import org.spongycastle.x509.X509CertStoreSelector;

public class LDAPStoreHelper {
    /* renamed from: b */
    private static String f23498b = "com.sun.jndi.ldap.LdapCtxFactory";
    /* renamed from: c */
    private static String f23499c = "ignore";
    /* renamed from: e */
    private static int f23500e = 32;
    /* renamed from: f */
    private static long f23501f = 60000;
    /* renamed from: a */
    private X509LDAPCertStoreParameters f23502a;
    /* renamed from: d */
    private Map f23503d;

    /* renamed from: a */
    private DirContext m29487a() {
        Hashtable properties = new Properties();
        properties.setProperty("java.naming.factory.initial", f23498b);
        properties.setProperty("java.naming.batchsize", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        properties.setProperty("java.naming.provider.url", this.f23502a.m36153F());
        properties.setProperty("java.naming.factory.url.pkgs", "com.sun.jndi.url");
        properties.setProperty("java.naming.referral", f23499c);
        properties.setProperty("java.naming.security.authentication", ViewProps.NONE);
        return new InitialDirContext(properties);
    }

    /* renamed from: a */
    private String m29476a(String str, String str2) {
        String toLowerCase = str.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2.toLowerCase());
        stringBuilder.append("=");
        int indexOf = toLowerCase.indexOf(stringBuilder.toString());
        if (indexOf == -1) {
            return "";
        }
        str = str.substring(indexOf + str2.length());
        indexOf = str.indexOf(44);
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
        if (str.endsWith("\"")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    /* renamed from: a */
    private java.util.Set m29486a(java.util.List r5, org.spongycastle.x509.X509CertStoreSelector r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new java.util.HashSet;
        r0.<init>();
        r5 = r5.iterator();
        r1 = new org.spongycastle.jce.provider.X509CertParser;
        r1.<init>();
    L_0x000e:
        r2 = r5.hasNext();
        if (r2 == 0) goto L_0x0036;
    L_0x0014:
        r2 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x0034 }
        r3 = r5.next();	 Catch:{ Exception -> 0x0034 }
        r3 = (byte[]) r3;	 Catch:{ Exception -> 0x0034 }
        r3 = (byte[]) r3;	 Catch:{ Exception -> 0x0034 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0034 }
        r1.m36232a(r2);	 Catch:{ Exception -> 0x0034 }
        r2 = r1.m36231a();	 Catch:{ Exception -> 0x0034 }
        r2 = (java.security.cert.X509Certificate) r2;	 Catch:{ Exception -> 0x0034 }
        r3 = r6.mo5847a(r2);	 Catch:{ Exception -> 0x0034 }
        if (r3 == 0) goto L_0x000e;	 Catch:{ Exception -> 0x0034 }
    L_0x0030:
        r0.add(r2);	 Catch:{ Exception -> 0x0034 }
        goto L_0x000e;
        goto L_0x000e;
    L_0x0036:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.util.LDAPStoreHelper.a(java.util.List, org.spongycastle.x509.X509CertStoreSelector):java.util.Set");
    }

    /* renamed from: a */
    private List m29481a(X509CertStoreSelector x509CertStoreSelector, String[] strArr, String[] strArr2, String[] strArr3) {
        List arrayList = new ArrayList();
        String c = m29491c(x509CertStoreSelector);
        String bigInteger = x509CertStoreSelector.getSerialNumber() != null ? x509CertStoreSelector.getSerialNumber().toString() : null;
        if (x509CertStoreSelector.getCertificate() != null) {
            c = x509CertStoreSelector.getCertificate().getSubjectX500Principal().getName("RFC1779");
            bigInteger = x509CertStoreSelector.getCertificate().getSerialNumber().toString();
        }
        if (c != null) {
            for (String a : strArr3) {
                String a2 = m29476a(c, a2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("*");
                stringBuilder.append(a2);
                stringBuilder.append("*");
                arrayList.addAll(m29482a(strArr2, stringBuilder.toString(), strArr));
            }
        }
        if (!(bigInteger == null || this.f23502a.m36155H() == null)) {
            arrayList.addAll(m29482a(m29490b(this.f23502a.m36155H()), bigInteger, strArr));
        }
        if (bigInteger == null && c == null) {
            arrayList.addAll(m29482a(strArr2, "*", strArr));
        }
        return arrayList;
    }

    /* renamed from: a */
    private List m29480a(X509CertPairStoreSelector x509CertPairStoreSelector, String[] strArr, String[] strArr2, String[] strArr3) {
        List arrayList = new ArrayList();
        String c = x509CertPairStoreSelector.m36637b() != null ? m29491c(x509CertPairStoreSelector.m36637b()) : null;
        if (!(x509CertPairStoreSelector.m36634a() == null || x509CertPairStoreSelector.m36634a().m29471a() == null)) {
            c = x509CertPairStoreSelector.m36634a().m29471a().getSubjectX500Principal().getName("RFC1779");
        }
        if (c != null) {
            for (String a : strArr3) {
                String a2 = m29476a(c, a2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("*");
                stringBuilder.append(a2);
                stringBuilder.append("*");
                arrayList.addAll(m29482a(strArr2, stringBuilder.toString(), strArr));
            }
        }
        if (c == null) {
            arrayList.addAll(m29482a(strArr2, "*", strArr));
        }
        return arrayList;
    }

    /* renamed from: a */
    private List m29478a(X509AttributeCertStoreSelector x509AttributeCertStoreSelector, String[] strArr, String[] strArr2, String[] strArr3) {
        Principal[] d;
        int i;
        List arrayList = new ArrayList();
        Collection<String> hashSet = new HashSet();
        String str = null;
        if (x509AttributeCertStoreSelector.m36625c() != null) {
            if (x509AttributeCertStoreSelector.m36625c().m36614f() != null) {
                hashSet.add(x509AttributeCertStoreSelector.m36625c().m36614f().toString());
            }
            if (x509AttributeCertStoreSelector.m36625c().m36612d() != null) {
                d = x509AttributeCertStoreSelector.m36625c().m36612d();
                if (x509AttributeCertStoreSelector.m36622a() != null) {
                    if (x509AttributeCertStoreSelector.m36622a().mo5946c().m36612d() != null) {
                        d = x509AttributeCertStoreSelector.m36622a().mo5946c().m36612d();
                    }
                    hashSet.add(x509AttributeCertStoreSelector.m36622a().mo5942a().toString());
                }
                i = 0;
                if (d != null) {
                    if (d[0] instanceof X500Principal) {
                        str = d[0].getName();
                    } else {
                        str = ((X500Principal) d[0]).getName("RFC1779");
                    }
                }
                if (x509AttributeCertStoreSelector.m36626d() != null) {
                    hashSet.add(x509AttributeCertStoreSelector.m36626d().toString());
                }
                if (str != null) {
                    while (i < strArr3.length) {
                        x509AttributeCertStoreSelector = m29476a(str, strArr3[i]);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("*");
                        stringBuilder.append(x509AttributeCertStoreSelector);
                        stringBuilder.append("*");
                        arrayList.addAll(m29482a(strArr2, stringBuilder.toString(), strArr));
                        i++;
                    }
                }
                if (hashSet.size() > null && this.f23502a.m36155H() != null) {
                    for (String a : hashSet) {
                        arrayList.addAll(m29482a(m29490b(this.f23502a.m36155H()), a, strArr));
                    }
                }
                if (hashSet.size() == null && str == null) {
                    arrayList.addAll(m29482a(strArr2, "*", strArr));
                }
                return arrayList;
            }
        }
        d = null;
        if (x509AttributeCertStoreSelector.m36622a() != null) {
            if (x509AttributeCertStoreSelector.m36622a().mo5946c().m36612d() != null) {
                d = x509AttributeCertStoreSelector.m36622a().mo5946c().m36612d();
            }
            hashSet.add(x509AttributeCertStoreSelector.m36622a().mo5942a().toString());
        }
        i = 0;
        if (d != null) {
            if (d[0] instanceof X500Principal) {
                str = d[0].getName();
            } else {
                str = ((X500Principal) d[0]).getName("RFC1779");
            }
        }
        if (x509AttributeCertStoreSelector.m36626d() != null) {
            hashSet.add(x509AttributeCertStoreSelector.m36626d().toString());
        }
        if (str != null) {
            while (i < strArr3.length) {
                x509AttributeCertStoreSelector = m29476a(str, strArr3[i]);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("*");
                stringBuilder2.append(x509AttributeCertStoreSelector);
                stringBuilder2.append("*");
                arrayList.addAll(m29482a(strArr2, stringBuilder2.toString(), strArr));
                i++;
            }
        }
        while (x509AttributeCertStoreSelector.hasNext() != null) {
            arrayList.addAll(m29482a(m29490b(this.f23502a.m36155H()), a, strArr));
        }
        arrayList.addAll(m29482a(strArr2, "*", strArr));
        return arrayList;
    }

    /* renamed from: a */
    private List m29479a(X509CRLStoreSelector x509CRLStoreSelector, String[] strArr, String[] strArr2, String[] strArr3) {
        int i;
        List arrayList = new ArrayList();
        Collection<X500Principal> hashSet = new HashSet();
        if (x509CRLStoreSelector.getIssuers() != null) {
            hashSet.addAll(x509CRLStoreSelector.getIssuers());
        }
        if (x509CRLStoreSelector.getCertificateChecking() != null) {
            hashSet.add(m29488a(x509CRLStoreSelector.getCertificateChecking()));
        }
        if (x509CRLStoreSelector.m36630a() != null) {
            x509CRLStoreSelector = x509CRLStoreSelector.m36630a().mo5947d().m36618a();
            for (i = 0; i < x509CRLStoreSelector.length; i++) {
                if (x509CRLStoreSelector[i] instanceof X500Principal) {
                    hashSet.add(x509CRLStoreSelector[i]);
                }
            }
        }
        String str = null;
        for (X500Principal name : hashSet) {
            str = name.getName("RFC1779");
            for (String a : strArr3) {
                String a2 = m29476a(str, a2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("*");
                stringBuilder.append(a2);
                stringBuilder.append("*");
                arrayList.addAll(m29482a(strArr2, stringBuilder.toString(), strArr));
            }
        }
        if (str == null) {
            arrayList.addAll(m29482a(strArr2, "*", strArr));
        }
        return arrayList;
    }

    /* renamed from: a */
    private java.util.List m29482a(java.lang.String[] r6, java.lang.String r7, java.lang.String[] r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = 0;
        if (r6 != 0) goto L_0x0006;
    L_0x0004:
        r6 = r1;
        goto L_0x0053;
    L_0x0006:
        r2 = "";
        r3 = "**";
        r3 = r7.equals(r3);
        if (r3 == 0) goto L_0x0012;
    L_0x0010:
        r7 = "*";
    L_0x0012:
        r3 = r2;
        r2 = 0;
    L_0x0014:
        r4 = r6.length;
        if (r2 >= r4) goto L_0x003d;
    L_0x0017:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r3);
        r3 = "(";
        r4.append(r3);
        r3 = r6[r2];
        r4.append(r3);
        r3 = "=";
        r4.append(r3);
        r4.append(r7);
        r3 = ")";
        r4.append(r3);
        r3 = r4.toString();
        r2 = r2 + 1;
        goto L_0x0014;
    L_0x003d:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "(|";
        r6.append(r7);
        r6.append(r3);
        r7 = ")";
        r6.append(r7);
        r6 = r6.toString();
    L_0x0053:
        r7 = "";
    L_0x0055:
        r2 = r8.length;
        if (r0 >= r2) goto L_0x0076;
    L_0x0058:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r7);
        r7 = "(";
        r2.append(r7);
        r7 = r8[r0];
        r2.append(r7);
        r7 = "=*)";
        r2.append(r7);
        r7 = r2.toString();
        r0 = r0 + 1;
        goto L_0x0055;
    L_0x0076:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "(|";
        r0.append(r2);
        r0.append(r7);
        r7 = ")";
        r0.append(r7);
        r7 = r0.toString();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "(&";
        r0.append(r2);
        r0.append(r6);
        r2 = "";
        r0.append(r2);
        r0.append(r7);
        r2 = ")";
        r0.append(r2);
        r0 = r0.toString();
        if (r6 != 0) goto L_0x00ad;
    L_0x00ac:
        goto L_0x00ae;
    L_0x00ad:
        r7 = r0;
    L_0x00ae:
        r6 = r5.m29477a(r7);
        if (r6 == 0) goto L_0x00b5;
    L_0x00b4:
        return r6;
    L_0x00b5:
        r6 = new java.util.ArrayList;
        r6.<init>();
        r0 = r5.m29487a();	 Catch:{ NamingException -> 0x0118, all -> 0x0110 }
        r1 = new javax.naming.directory.SearchControls;	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        r1.<init>();	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        r2 = 2;	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        r1.setSearchScope(r2);	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        r2 = 0;	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        r1.setCountLimit(r2);	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        r1.setReturningAttributes(r8);	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        r8 = r5.f23502a;	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        r8 = r8.m36170m();	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        r8 = r0.search(r8, r7, r1);	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
    L_0x00d9:
        r1 = r8.hasMoreElements();	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        if (r1 == 0) goto L_0x0105;	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
    L_0x00df:
        r1 = r8.next();	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        r1 = (javax.naming.directory.SearchResult) r1;	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        r1 = r1.getAttributes();	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        r1 = r1.getAll();	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        r1 = r1.next();	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        r1 = (javax.naming.directory.Attribute) r1;	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        r1 = r1.getAll();	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
    L_0x00f7:
        r2 = r1.hasMore();	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        if (r2 == 0) goto L_0x00d9;	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
    L_0x00fd:
        r2 = r1.next();	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        r6.add(r2);	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        goto L_0x00f7;	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
    L_0x0105:
        r5.m29489a(r7, r6);	 Catch:{ NamingException -> 0x0119, all -> 0x010e }
        if (r0 == 0) goto L_0x011c;
    L_0x010a:
        r0.close();	 Catch:{ Exception -> 0x011c }
        goto L_0x011c;
    L_0x010e:
        r6 = move-exception;
        goto L_0x0112;
    L_0x0110:
        r6 = move-exception;
        r0 = r1;
    L_0x0112:
        if (r0 == 0) goto L_0x0117;
    L_0x0114:
        r0.close();	 Catch:{ Exception -> 0x0117 }
    L_0x0117:
        throw r6;
    L_0x0118:
        r0 = r1;
    L_0x0119:
        if (r0 == 0) goto L_0x011c;
    L_0x011b:
        goto L_0x010a;
    L_0x011c:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.util.LDAPStoreHelper.a(java.lang.String[], java.lang.String, java.lang.String[]):java.util.List");
    }

    /* renamed from: a */
    private java.util.Set m29484a(java.util.List r5, org.spongycastle.x509.X509CRLStoreSelector r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new java.util.HashSet;
        r0.<init>();
        r1 = new org.spongycastle.jce.provider.X509CRLParser;
        r1.<init>();
        r5 = r5.iterator();
    L_0x000e:
        r2 = r5.hasNext();
        if (r2 == 0) goto L_0x0036;
    L_0x0014:
        r2 = new java.io.ByteArrayInputStream;	 Catch:{ StreamParsingException -> 0x0034 }
        r3 = r5.next();	 Catch:{ StreamParsingException -> 0x0034 }
        r3 = (byte[]) r3;	 Catch:{ StreamParsingException -> 0x0034 }
        r3 = (byte[]) r3;	 Catch:{ StreamParsingException -> 0x0034 }
        r2.<init>(r3);	 Catch:{ StreamParsingException -> 0x0034 }
        r1.m36224a(r2);	 Catch:{ StreamParsingException -> 0x0034 }
        r2 = r1.m36223a();	 Catch:{ StreamParsingException -> 0x0034 }
        r2 = (java.security.cert.X509CRL) r2;	 Catch:{ StreamParsingException -> 0x0034 }
        r3 = r6.mo5847a(r2);	 Catch:{ StreamParsingException -> 0x0034 }
        if (r3 == 0) goto L_0x000e;	 Catch:{ StreamParsingException -> 0x0034 }
    L_0x0030:
        r0.add(r2);	 Catch:{ StreamParsingException -> 0x0034 }
        goto L_0x000e;
        goto L_0x000e;
    L_0x0036:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.util.LDAPStoreHelper.a(java.util.List, org.spongycastle.x509.X509CRLStoreSelector):java.util.Set");
    }

    /* renamed from: a */
    private java.util.Set m29485a(java.util.List r9, org.spongycastle.x509.X509CertPairStoreSelector r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = new java.util.HashSet;
        r0.<init>();
        r1 = 0;
    L_0x0006:
        r2 = r9.size();
        if (r1 >= r2) goto L_0x006c;
    L_0x000c:
        r2 = new org.spongycastle.jce.provider.X509CertPairParser;	 Catch:{ StreamParsingException -> 0x0028 }
        r2.<init>();	 Catch:{ StreamParsingException -> 0x0028 }
        r3 = new java.io.ByteArrayInputStream;	 Catch:{ StreamParsingException -> 0x0028 }
        r4 = r9.get(r1);	 Catch:{ StreamParsingException -> 0x0028 }
        r4 = (byte[]) r4;	 Catch:{ StreamParsingException -> 0x0028 }
        r4 = (byte[]) r4;	 Catch:{ StreamParsingException -> 0x0028 }
        r3.<init>(r4);	 Catch:{ StreamParsingException -> 0x0028 }
        r2.m36227a(r3);	 Catch:{ StreamParsingException -> 0x0028 }
        r2 = r2.m36226a();	 Catch:{ StreamParsingException -> 0x0028 }
        r2 = (org.spongycastle.x509.X509CertificatePair) r2;	 Catch:{ StreamParsingException -> 0x0028 }
        goto L_0x0060;
    L_0x0028:
        r2 = r9.get(r1);	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r2 = (byte[]) r2;	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r2 = (byte[]) r2;	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r3 = r1 + 1;	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r4 = r9.get(r3);	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r4 = (byte[]) r4;	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r4 = (byte[]) r4;	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r5 = new org.spongycastle.x509.X509CertificatePair;	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r6 = new org.spongycastle.asn1.x509.CertificatePair;	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r7 = new org.spongycastle.asn1.ASN1InputStream;	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r7.<init>(r2);	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r2 = r7.m34595d();	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r2 = org.spongycastle.asn1.x509.Certificate.m40272a(r2);	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r7 = new org.spongycastle.asn1.ASN1InputStream;	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r7.<init>(r4);	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r4 = r7.m34595d();	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r4 = org.spongycastle.asn1.x509.Certificate.m40272a(r4);	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r6.<init>(r2, r4);	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r5.<init>(r6);	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r1 = r3;	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        r2 = r5;	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
    L_0x0060:
        r3 = r10.mo5847a(r2);	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
        if (r3 == 0) goto L_0x0069;	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
    L_0x0066:
        r0.add(r2);	 Catch:{ CertificateParsingException -> 0x0069, CertificateParsingException -> 0x0069 }
    L_0x0069:
        r1 = r1 + 1;
        goto L_0x0006;
    L_0x006c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.util.LDAPStoreHelper.a(java.util.List, org.spongycastle.x509.X509CertPairStoreSelector):java.util.Set");
    }

    /* renamed from: a */
    private java.util.Set m29483a(java.util.List r5, org.spongycastle.x509.X509AttributeCertStoreSelector r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new java.util.HashSet;
        r0.<init>();
        r5 = r5.iterator();
        r1 = new org.spongycastle.jce.provider.X509AttrCertParser;
        r1.<init>();
    L_0x000e:
        r2 = r5.hasNext();
        if (r2 == 0) goto L_0x0036;
    L_0x0014:
        r2 = new java.io.ByteArrayInputStream;	 Catch:{ StreamParsingException -> 0x0034 }
        r3 = r5.next();	 Catch:{ StreamParsingException -> 0x0034 }
        r3 = (byte[]) r3;	 Catch:{ StreamParsingException -> 0x0034 }
        r3 = (byte[]) r3;	 Catch:{ StreamParsingException -> 0x0034 }
        r2.<init>(r3);	 Catch:{ StreamParsingException -> 0x0034 }
        r1.m36219a(r2);	 Catch:{ StreamParsingException -> 0x0034 }
        r2 = r1.m36218a();	 Catch:{ StreamParsingException -> 0x0034 }
        r2 = (org.spongycastle.x509.X509AttributeCertificate) r2;	 Catch:{ StreamParsingException -> 0x0034 }
        r3 = r6.mo5847a(r2);	 Catch:{ StreamParsingException -> 0x0034 }
        if (r3 == 0) goto L_0x000e;	 Catch:{ StreamParsingException -> 0x0034 }
    L_0x0030:
        r0.add(r2);	 Catch:{ StreamParsingException -> 0x0034 }
        goto L_0x000e;
        goto L_0x000e;
    L_0x0036:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.util.LDAPStoreHelper.a(java.util.List, org.spongycastle.x509.X509AttributeCertStoreSelector):java.util.Set");
    }

    /* renamed from: a */
    public Collection m29493a(X509CRLStoreSelector x509CRLStoreSelector) {
        String[] b = m29490b(this.f23502a.m36168k());
        String[] b2 = m29490b(this.f23502a.m36148A());
        String[] b3 = m29490b(this.f23502a.m36169l());
        Collection a = m29484a(m29479a(x509CRLStoreSelector, b, b2, b3), x509CRLStoreSelector);
        if (a.size() == 0) {
            a.addAll(m29484a(m29479a(new X509CRLStoreSelector(), b, b2, b3), x509CRLStoreSelector));
        }
        return a;
    }

    /* renamed from: b */
    public Collection m29497b(X509CRLStoreSelector x509CRLStoreSelector) {
        String[] b = m29490b(this.f23502a.m36164g());
        String[] b2 = m29490b(this.f23502a.m36182y());
        String[] b3 = m29490b(this.f23502a.m36165h());
        Collection a = m29484a(m29479a(x509CRLStoreSelector, b, b2, b3), x509CRLStoreSelector);
        if (a.size() == 0) {
            a.addAll(m29484a(m29479a(new X509CRLStoreSelector(), b, b2, b3), x509CRLStoreSelector));
        }
        return a;
    }

    /* renamed from: c */
    public Collection m29500c(X509CRLStoreSelector x509CRLStoreSelector) {
        String[] b = m29490b(this.f23502a.m36160c());
        String[] b2 = m29490b(this.f23502a.m36180w());
        String[] b3 = m29490b(this.f23502a.m36161d());
        Collection a = m29484a(m29479a(x509CRLStoreSelector, b, b2, b3), x509CRLStoreSelector);
        if (a.size() == 0) {
            a.addAll(m29484a(m29479a(new X509CRLStoreSelector(), b, b2, b3), x509CRLStoreSelector));
        }
        return a;
    }

    /* renamed from: a */
    public Collection m29494a(X509CertPairStoreSelector x509CertPairStoreSelector) {
        String[] b = m29490b(this.f23502a.m36175r());
        String[] b2 = m29490b(this.f23502a.m36151D());
        String[] b3 = m29490b(this.f23502a.m36176s());
        Collection a = m29485a(m29480a(x509CertPairStoreSelector, b, b2, b3), x509CertPairStoreSelector);
        if (a.size() == 0) {
            X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
            X509CertPairStoreSelector x509CertPairStoreSelector2 = new X509CertPairStoreSelector();
            x509CertPairStoreSelector2.m36635a(x509CertStoreSelector);
            x509CertPairStoreSelector2.m36638b(x509CertStoreSelector);
            a.addAll(m29485a(m29480a(x509CertPairStoreSelector2, b, b2, b3), x509CertPairStoreSelector));
        }
        return a;
    }

    /* renamed from: a */
    public Collection m29495a(X509CertStoreSelector x509CertStoreSelector) {
        String[] b = m29490b(this.f23502a.m36156I());
        String[] b2 = m29490b(this.f23502a.m36154G());
        String[] b3 = m29490b(this.f23502a.m36157J());
        Collection a = m29486a(m29481a(x509CertStoreSelector, b, b2, b3), x509CertStoreSelector);
        if (a.size() == 0) {
            a.addAll(m29486a(m29481a(new X509CertStoreSelector(), b, b2, b3), x509CertStoreSelector));
        }
        return a;
    }

    /* renamed from: a */
    public Collection m29492a(X509AttributeCertStoreSelector x509AttributeCertStoreSelector) {
        String[] b = m29490b(this.f23502a.m36158a());
        String[] b2 = m29490b(this.f23502a.m36179v());
        String[] b3 = m29490b(this.f23502a.m36159b());
        Collection a = m29483a(m29478a(x509AttributeCertStoreSelector, b, b2, b3), x509AttributeCertStoreSelector);
        if (a.size() == 0) {
            a.addAll(m29483a(m29478a(new X509AttributeCertStoreSelector(), b, b2, b3), x509AttributeCertStoreSelector));
        }
        return a;
    }

    /* renamed from: b */
    public Collection m29496b(X509AttributeCertStoreSelector x509AttributeCertStoreSelector) {
        String[] b = m29490b(this.f23502a.m36166i());
        String[] b2 = m29490b(this.f23502a.m36183z());
        String[] b3 = m29490b(this.f23502a.m36167j());
        Collection a = m29483a(m29478a(x509AttributeCertStoreSelector, b, b2, b3), x509AttributeCertStoreSelector);
        if (a.size() == 0) {
            a.addAll(m29483a(m29478a(new X509AttributeCertStoreSelector(), b, b2, b3), x509AttributeCertStoreSelector));
        }
        return a;
    }

    /* renamed from: b */
    public Collection m29498b(X509CertStoreSelector x509CertStoreSelector) {
        String[] b = m29490b(this.f23502a.m36171n());
        String[] b2 = m29490b(this.f23502a.m36149B());
        String[] b3 = m29490b(this.f23502a.m36172o());
        Collection a = m29486a(m29481a(x509CertStoreSelector, b, b2, b3), x509CertStoreSelector);
        if (a.size() == 0) {
            a.addAll(m29486a(m29481a(new X509CertStoreSelector(), b, b2, b3), x509CertStoreSelector));
        }
        return a;
    }

    /* renamed from: d */
    public Collection m29501d(X509CRLStoreSelector x509CRLStoreSelector) {
        String[] b = m29490b(this.f23502a.m36177t());
        String[] b2 = m29490b(this.f23502a.m36152E());
        String[] b3 = m29490b(this.f23502a.m36178u());
        Collection a = m29484a(m29479a(x509CRLStoreSelector, b, b2, b3), x509CRLStoreSelector);
        if (a.size() == 0) {
            a.addAll(m29484a(m29479a(new X509CRLStoreSelector(), b, b2, b3), x509CRLStoreSelector));
        }
        return a;
    }

    /* renamed from: c */
    public Collection m29499c(X509AttributeCertStoreSelector x509AttributeCertStoreSelector) {
        String[] b = m29490b(this.f23502a.m36162e());
        String[] b2 = m29490b(this.f23502a.m36181x());
        String[] b3 = m29490b(this.f23502a.m36163f());
        Collection a = m29483a(m29478a(x509AttributeCertStoreSelector, b, b2, b3), x509AttributeCertStoreSelector);
        if (a.size() == 0) {
            a.addAll(m29483a(m29478a(new X509AttributeCertStoreSelector(), b, b2, b3), x509AttributeCertStoreSelector));
        }
        return a;
    }

    /* renamed from: e */
    public Collection m29502e(X509CRLStoreSelector x509CRLStoreSelector) {
        String[] b = m29490b(this.f23502a.m36173p());
        String[] b2 = m29490b(this.f23502a.m36150C());
        String[] b3 = m29490b(this.f23502a.m36174q());
        Collection a = m29484a(m29479a(x509CRLStoreSelector, b, b2, b3), x509CRLStoreSelector);
        if (a.size() == 0) {
            a.addAll(m29484a(m29479a(new X509CRLStoreSelector(), b, b2, b3), x509CRLStoreSelector));
        }
        return a;
    }

    /* renamed from: a */
    private synchronized void m29489a(String str, List list) {
        Date date = new Date(System.currentTimeMillis());
        List arrayList = new ArrayList();
        arrayList.add(date);
        arrayList.add(list);
        if (this.f23503d.containsKey(str) != null) {
            this.f23503d.put(str, arrayList);
        } else {
            if (this.f23503d.size() >= f23500e) {
                long time = date.getTime();
                Object obj = null;
                for (Entry entry : this.f23503d.entrySet()) {
                    long time2 = ((Date) ((List) entry.getValue()).get(0)).getTime();
                    if (time2 < time) {
                        obj = entry.getKey();
                        time = time2;
                    }
                }
                this.f23503d.remove(obj);
            }
            this.f23503d.put(str, arrayList);
        }
    }

    /* renamed from: a */
    private List m29477a(String str) {
        List list = (List) this.f23503d.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || ((Date) list.get(0)).getTime() < currentTimeMillis - f23501f) {
            return null;
        }
        return (List) list.get(1);
    }

    /* renamed from: b */
    private String[] m29490b(String str) {
        return str.split("\\s+");
    }

    /* renamed from: c */
    private String m29491c(X509CertStoreSelector x509CertStoreSelector) {
        try {
            x509CertStoreSelector = x509CertStoreSelector.getSubjectAsBytes();
            return x509CertStoreSelector != null ? new X500Principal(x509CertStoreSelector).getName("RFC1779") : null;
        } catch (X509CertStoreSelector x509CertStoreSelector2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("exception processing name: ");
            stringBuilder.append(x509CertStoreSelector2.getMessage());
            throw new StoreException(stringBuilder.toString(), x509CertStoreSelector2);
        }
    }

    /* renamed from: a */
    private X500Principal m29488a(X509Certificate x509Certificate) {
        return x509Certificate.getIssuerX500Principal();
    }
}
