package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptionScheme extends ASN1Object {
    /* renamed from: a */
    private AlgorithmIdentifier f30984a;

    private EncryptionScheme(ASN1Sequence aSN1Sequence) {
        this.f30984a = AlgorithmIdentifier.m40228a(aSN1Sequence);
    }

    /* renamed from: a */
    public static EncryptionScheme m40078a(Object obj) {
        if (obj instanceof EncryptionScheme) {
            return (EncryptionScheme) obj;
        }
        return obj != null ? new EncryptionScheme(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: a */
    public ASN1ObjectIdentifier m40079a() {
        return this.f30984a.m40230a();
    }

    /* renamed from: b */
    public ASN1Encodable m40080b() {
        return this.f30984a.m40231b();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f30984a.mo5709e();
    }
}
