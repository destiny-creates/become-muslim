package org.spongycastle.jce;

import java.io.IOException;
import java.security.Principal;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.X509Name;

public class X509Principal extends X509Name implements Principal {
    /* renamed from: a */
    private static ASN1Sequence m43429a(ASN1InputStream aSN1InputStream) {
        try {
            return ASN1Sequence.m43000a(aSN1InputStream.m34595d());
        } catch (ASN1InputStream aSN1InputStream2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("not an ASN.1 Sequence: ");
            stringBuilder.append(aSN1InputStream2);
            throw new IOException(stringBuilder.toString());
        }
    }

    public X509Principal(byte[] bArr) {
        super(m43429a(new ASN1InputStream(bArr)));
    }

    public X509Principal(X509Name x509Name) {
        super((ASN1Sequence) x509Name.mo5709e());
    }

    public X509Principal(X500Name x500Name) {
        super((ASN1Sequence) x500Name.mo5709e());
    }

    public String getName() {
        return toString();
    }

    /* renamed from: f */
    public byte[] mo6822f() {
        try {
            return m34596a("DER");
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }
}
