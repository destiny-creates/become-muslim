package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedPrivateKeyInfo extends ASN1Object {
    /* renamed from: a */
    private AlgorithmIdentifier f30982a;
    /* renamed from: b */
    private ASN1OctetString f30983b;

    private EncryptedPrivateKeyInfo(ASN1Sequence aSN1Sequence) {
        aSN1Sequence = aSN1Sequence.mo6861c();
        this.f30982a = AlgorithmIdentifier.m40228a(aSN1Sequence.nextElement());
        this.f30983b = ASN1OctetString.m42990a(aSN1Sequence.nextElement());
    }

    public EncryptedPrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.f30982a = algorithmIdentifier;
        this.f30983b = new DEROctetString(bArr);
    }

    /* renamed from: a */
    public static EncryptedPrivateKeyInfo m40074a(Object obj) {
        if (obj instanceof EncryptedPrivateKeyInfo) {
            return (EncryptedPrivateKeyInfo) obj;
        }
        return obj != null ? new EncryptedPrivateKeyInfo(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: a */
    public AlgorithmIdentifier m40075a() {
        return this.f30982a;
    }

    /* renamed from: b */
    public byte[] m40076b() {
        return this.f30983b.mo6859c();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30982a);
        aSN1EncodableVector.m27141a(this.f30983b);
        return new DERSequence(aSN1EncodableVector);
    }
}
