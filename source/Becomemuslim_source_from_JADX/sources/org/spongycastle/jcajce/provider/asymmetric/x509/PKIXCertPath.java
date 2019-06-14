package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;

public class PKIXCertPath extends CertPath {
    /* renamed from: a */
    static final List f22839a;
    /* renamed from: b */
    private final JcaJceHelper f22840b = new BCJcaJceHelper();
    /* renamed from: c */
    private List f22841c;

    static {
        List arrayList = new ArrayList();
        arrayList.add("PkiPath");
        arrayList.add("PEM");
        arrayList.add("PKCS7");
        f22839a = Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    private List m28030a(List list) {
        if (list.size() < 2) {
            return list;
        }
        Object obj;
        X500Principal issuerX500Principal = ((X509Certificate) list.get(0)).getIssuerX500Principal();
        for (int i = 1; i != list.size(); i++) {
            if (!issuerX500Principal.equals(((X509Certificate) list.get(i)).getSubjectX500Principal())) {
                obj = null;
                break;
            }
            issuerX500Principal = ((X509Certificate) list.get(i)).getIssuerX500Principal();
        }
        obj = 1;
        if (obj != null) {
            return list;
        }
        List arrayList = new ArrayList(list.size());
        List arrayList2 = new ArrayList(list);
        for (int i2 = 0; i2 < list.size(); i2++) {
            Object obj2;
            X509Certificate x509Certificate = (X509Certificate) list.get(i2);
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            for (int i3 = 0; i3 != list.size(); i3++) {
                if (((X509Certificate) list.get(i3)).getIssuerX500Principal().equals(subjectX500Principal)) {
                    obj2 = 1;
                    break;
                }
            }
            obj2 = null;
            if (obj2 == null) {
                arrayList.add(x509Certificate);
                list.remove(i2);
            }
        }
        if (arrayList.size() > 1) {
            return arrayList2;
        }
        for (int i4 = 0; i4 != arrayList.size(); i4++) {
            X500Principal issuerX500Principal2 = ((X509Certificate) arrayList.get(i4)).getIssuerX500Principal();
            for (int i5 = 0; i5 < list.size(); i5++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i5);
                if (issuerX500Principal2.equals(x509Certificate2.getSubjectX500Principal())) {
                    arrayList.add(x509Certificate2);
                    list.remove(i5);
                    break;
                }
            }
        }
        return list.size() > null ? arrayList2 : arrayList;
    }

    PKIXCertPath(List list) {
        super("X.509");
        this.f22841c = m28030a(new ArrayList(list));
    }

    PKIXCertPath(InputStream inputStream, String str) {
        StringBuilder stringBuilder;
        super("X.509");
        try {
            if (!str.equalsIgnoreCase("PkiPath")) {
                if (!str.equalsIgnoreCase("PKCS7")) {
                    if (!str.equalsIgnoreCase("PEM")) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("unsupported encoding: ");
                        stringBuilder.append(str);
                        throw new CertificateException(stringBuilder.toString());
                    }
                }
                str = new BufferedInputStream(inputStream);
                this.f22841c = new ArrayList();
                inputStream = this.f22840b.mo5882g("X.509");
                while (true) {
                    Certificate generateCertificate = inputStream.generateCertificate(str);
                    if (generateCertificate == null) {
                        break;
                    }
                    this.f22841c.add(generateCertificate);
                }
            } else {
                inputStream = new ASN1InputStream(inputStream).m34595d();
                if ((inputStream instanceof ASN1Sequence) != null) {
                    inputStream = ((ASN1Sequence) inputStream).mo6861c();
                    this.f22841c = new ArrayList();
                    str = this.f22840b.mo5882g("X.509");
                    while (inputStream.hasMoreElements()) {
                        this.f22841c.add(0, str.generateCertificate(new ByteArrayInputStream(((ASN1Encodable) inputStream.nextElement()).mo5709e().m34596a("DER"))));
                    }
                } else {
                    throw new CertificateException("input stream does not contain a ASN1 SEQUENCE while reading PkiPath encoded data to load CertPath");
                }
            }
            this.f22841c = m28030a(this.f22841c);
        } catch (InputStream inputStream2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("IOException throw while decoding CertPath:\n");
            stringBuilder.append(inputStream2.toString());
            throw new CertificateException(stringBuilder.toString());
        } catch (InputStream inputStream22) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("BouncyCastle provider not found while trying to get a CertificateFactory:\n");
            stringBuilder.append(inputStream22.toString());
            throw new CertificateException(stringBuilder.toString());
        }
    }

    public Iterator getEncodings() {
        return f22839a.iterator();
    }

    public byte[] getEncoded() {
        Iterator encodings = getEncodings();
        if (encodings.hasNext()) {
            Object next = encodings.next();
            if (next instanceof String) {
                return getEncoded((String) next);
            }
        }
        return null;
    }

    public byte[] getEncoded(java.lang.String r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = "PkiPath";
        r0 = r10.equalsIgnoreCase(r0);
        if (r0 == 0) goto L_0x0037;
    L_0x0008:
        r10 = new org.spongycastle.asn1.ASN1EncodableVector;
        r10.<init>();
        r0 = r9.f22841c;
        r1 = r9.f22841c;
        r1 = r1.size();
        r0 = r0.listIterator(r1);
    L_0x0019:
        r1 = r0.hasPrevious();
        if (r1 == 0) goto L_0x002d;
    L_0x001f:
        r1 = r0.previous();
        r1 = (java.security.cert.X509Certificate) r1;
        r1 = r9.m28031a(r1);
        r10.m27141a(r1);
        goto L_0x0019;
    L_0x002d:
        r0 = new org.spongycastle.asn1.DERSequence;
        r0.<init>(r10);
        r10 = r9.m28032a(r0);
        return r10;
    L_0x0037:
        r0 = "PKCS7";
        r0 = r10.equalsIgnoreCase(r0);
        r1 = 0;
        if (r0 == 0) goto L_0x0090;
    L_0x0040:
        r5 = new org.spongycastle.asn1.pkcs.ContentInfo;
        r10 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.f21848O;
        r0 = 0;
        r5.<init>(r10, r0);
        r10 = new org.spongycastle.asn1.ASN1EncodableVector;
        r10.<init>();
    L_0x004d:
        r0 = r9.f22841c;
        r0 = r0.size();
        if (r1 == r0) goto L_0x0067;
    L_0x0055:
        r0 = r9.f22841c;
        r0 = r0.get(r1);
        r0 = (java.security.cert.X509Certificate) r0;
        r0 = r9.m28031a(r0);
        r10.m27141a(r0);
        r1 = r1 + 1;
        goto L_0x004d;
    L_0x0067:
        r0 = new org.spongycastle.asn1.pkcs.SignedData;
        r3 = new org.spongycastle.asn1.ASN1Integer;
        r1 = 1;
        r3.<init>(r1);
        r4 = new org.spongycastle.asn1.DERSet;
        r4.<init>();
        r6 = new org.spongycastle.asn1.DERSet;
        r6.<init>(r10);
        r7 = 0;
        r8 = new org.spongycastle.asn1.DERSet;
        r8.<init>();
        r2 = r0;
        r2.<init>(r3, r4, r5, r6, r7, r8);
        r10 = new org.spongycastle.asn1.pkcs.ContentInfo;
        r1 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.f21849P;
        r10.<init>(r1, r0);
        r10 = r9.m28032a(r10);
        return r10;
    L_0x0090:
        r0 = "PEM";
        r0 = r10.equalsIgnoreCase(r0);
        if (r0 == 0) goto L_0x00d8;
    L_0x0098:
        r10 = new java.io.ByteArrayOutputStream;
        r10.<init>();
        r0 = new org.spongycastle.util.io.pem.PemWriter;
        r2 = new java.io.OutputStreamWriter;
        r2.<init>(r10);
        r0.<init>(r2);
    L_0x00a7:
        r2 = r9.f22841c;	 Catch:{ Exception -> 0x00d0 }
        r2 = r2.size();	 Catch:{ Exception -> 0x00d0 }
        if (r1 == r2) goto L_0x00c8;	 Catch:{ Exception -> 0x00d0 }
    L_0x00af:
        r2 = new org.spongycastle.util.io.pem.PemObject;	 Catch:{ Exception -> 0x00d0 }
        r3 = "CERTIFICATE";	 Catch:{ Exception -> 0x00d0 }
        r4 = r9.f22841c;	 Catch:{ Exception -> 0x00d0 }
        r4 = r4.get(r1);	 Catch:{ Exception -> 0x00d0 }
        r4 = (java.security.cert.X509Certificate) r4;	 Catch:{ Exception -> 0x00d0 }
        r4 = r4.getEncoded();	 Catch:{ Exception -> 0x00d0 }
        r2.<init>(r3, r4);	 Catch:{ Exception -> 0x00d0 }
        r0.m29451a(r2);	 Catch:{ Exception -> 0x00d0 }
        r1 = r1 + 1;	 Catch:{ Exception -> 0x00d0 }
        goto L_0x00a7;	 Catch:{ Exception -> 0x00d0 }
    L_0x00c8:
        r0.close();	 Catch:{ Exception -> 0x00d0 }
        r10 = r10.toByteArray();
        return r10;
    L_0x00d0:
        r10 = new java.security.cert.CertificateEncodingException;
        r0 = "can't encode certificate for PEM encoded path";
        r10.<init>(r0);
        throw r10;
    L_0x00d8:
        r0 = new java.security.cert.CertificateEncodingException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "unsupported encoding: ";
        r1.append(r2);
        r1.append(r10);
        r10 = r1.toString();
        r0.<init>(r10);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.x509.PKIXCertPath.getEncoded(java.lang.String):byte[]");
    }

    public List getCertificates() {
        return Collections.unmodifiableList(new ArrayList(this.f22841c));
    }

    /* renamed from: a */
    private ASN1Primitive m28031a(X509Certificate x509Certificate) {
        try {
            return new ASN1InputStream(x509Certificate.getEncoded()).m34595d();
        } catch (X509Certificate x509Certificate2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception while encoding certificate: ");
            stringBuilder.append(x509Certificate2.toString());
            throw new CertificateEncodingException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private byte[] m28032a(ASN1Encodable aSN1Encodable) {
        try {
            return aSN1Encodable.mo5709e().m34596a("DER");
        } catch (ASN1Encodable aSN1Encodable2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception thrown: ");
            stringBuilder.append(aSN1Encodable2);
            throw new CertificateEncodingException(stringBuilder.toString());
        }
    }
}
