package org.spongycastle.x509;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.AttributeCertificate;
import org.spongycastle.asn1.x509.Extensions;

public class X509V2AttributeCertificate implements X509AttributeCertificate {
    /* renamed from: a */
    private AttributeCertificate f27925a;
    /* renamed from: b */
    private Date f27926b;
    /* renamed from: c */
    private Date f27927c;

    /* renamed from: a */
    private static AttributeCertificate m36643a(InputStream inputStream) {
        try {
            return AttributeCertificate.m40243a(new ASN1InputStream(inputStream).m34595d());
        } catch (InputStream inputStream2) {
            throw inputStream2;
        } catch (InputStream inputStream22) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("exception decoding certificate structure: ");
            stringBuilder.append(inputStream22.toString());
            throw new IOException(stringBuilder.toString());
        }
    }

    public X509V2AttributeCertificate(InputStream inputStream) {
        this(m36643a(inputStream));
    }

    public X509V2AttributeCertificate(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }

    X509V2AttributeCertificate(org.spongycastle.asn1.x509.AttributeCertificate r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r1.<init>();
        r1.f27925a = r2;
        r0 = r2.m40244a();	 Catch:{ ParseException -> 0x002a }
        r0 = r0.m40250d();	 Catch:{ ParseException -> 0x002a }
        r0 = r0.m40238b();	 Catch:{ ParseException -> 0x002a }
        r0 = r0.m42961c();	 Catch:{ ParseException -> 0x002a }
        r1.f27927c = r0;	 Catch:{ ParseException -> 0x002a }
        r2 = r2.m40244a();	 Catch:{ ParseException -> 0x002a }
        r2 = r2.m40250d();	 Catch:{ ParseException -> 0x002a }
        r2 = r2.m40237a();	 Catch:{ ParseException -> 0x002a }
        r2 = r2.m42961c();	 Catch:{ ParseException -> 0x002a }
        r1.f27926b = r2;	 Catch:{ ParseException -> 0x002a }
        return;
    L_0x002a:
        r2 = new java.io.IOException;
        r0 = "invalid data structure in certificate!";
        r2.<init>(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.X509V2AttributeCertificate.<init>(org.spongycastle.asn1.x509.AttributeCertificate):void");
    }

    /* renamed from: a */
    public BigInteger mo5942a() {
        return this.f27925a.m40244a().m40249c().m42968b();
    }

    /* renamed from: c */
    public AttributeCertificateHolder mo5946c() {
        return new AttributeCertificateHolder((ASN1Sequence) this.f27925a.m40244a().m40247a().mo5709e());
    }

    /* renamed from: d */
    public AttributeCertificateIssuer mo5947d() {
        return new AttributeCertificateIssuer(this.f27925a.m40244a().m40248b());
    }

    /* renamed from: f */
    public Date m36651f() {
        return this.f27926b;
    }

    /* renamed from: b */
    public Date mo5945b() {
        return this.f27927c;
    }

    /* renamed from: a */
    public void mo5943a(Date date) {
        StringBuilder stringBuilder;
        if (date.after(mo5945b())) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("certificate expired on ");
            stringBuilder.append(mo5945b());
            throw new CertificateExpiredException(stringBuilder.toString());
        } else if (date.before(m36651f()) != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("certificate not valid till ");
            stringBuilder.append(m36651f());
            throw new CertificateNotYetValidException(stringBuilder.toString());
        }
    }

    /* renamed from: e */
    public byte[] mo5948e() {
        return this.f27925a.mo6822f();
    }

    public byte[] getExtensionValue(String str) {
        Extensions h = this.f27925a.m40244a().m40253h();
        if (h != null) {
            str = h.m40332a(new ASN1ObjectIdentifier(str));
            if (str != null) {
                try {
                    return str.m40327c().m34596a("DER");
                } catch (String str2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("error encoding ");
                    stringBuilder.append(str2.toString());
                    throw new RuntimeException(stringBuilder.toString());
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private Set m36642a(boolean z) {
        Extensions h = this.f27925a.m40244a().m40253h();
        if (h == null) {
            return false;
        }
        Set hashSet = new HashSet();
        Enumeration a = h.m40331a();
        while (a.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) a.nextElement();
            if (h.m40332a(aSN1ObjectIdentifier).m40326b() == z) {
                hashSet.add(aSN1ObjectIdentifier.m42986b());
            }
        }
        return hashSet;
    }

    public Set getNonCriticalExtensionOIDs() {
        return m36642a(false);
    }

    public Set getCriticalExtensionOIDs() {
        return m36642a(true);
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        return (criticalExtensionOIDs == null || criticalExtensionOIDs.isEmpty()) ? false : true;
    }

    /* renamed from: a */
    public X509Attribute[] mo5944a(String str) {
        ASN1Sequence g = this.f27925a.m40244a().m40252g();
        List arrayList = new ArrayList();
        for (int i = 0; i != g.mo6862g(); i++) {
            X509Attribute x509Attribute = new X509Attribute(g.mo6860a(i));
            if (x509Attribute.m42151a().equals(str)) {
                arrayList.add(x509Attribute);
            }
        }
        if (arrayList.size() == null) {
            return null;
        }
        return (X509Attribute[]) arrayList.toArray(new X509Attribute[arrayList.size()]);
    }

    public boolean equals(java.lang.Object r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        if (r3 != r2) goto L_0x0004;
    L_0x0002:
        r3 = 1;
        return r3;
    L_0x0004:
        r0 = r3 instanceof org.spongycastle.x509.X509AttributeCertificate;
        r1 = 0;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r3 = (org.spongycastle.x509.X509AttributeCertificate) r3;
        r0 = r2.mo5948e();	 Catch:{ IOException -> 0x0019 }
        r3 = r3.mo5948e();	 Catch:{ IOException -> 0x0019 }
        r3 = org.spongycastle.util.Arrays.m29353a(r0, r3);	 Catch:{ IOException -> 0x0019 }
        return r3;
    L_0x0019:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.X509V2AttributeCertificate.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mo5948e();	 Catch:{ IOException -> 0x0009 }
        r0 = org.spongycastle.util.Arrays.m29342a(r0);	 Catch:{ IOException -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.X509V2AttributeCertificate.hashCode():int");
    }
}
