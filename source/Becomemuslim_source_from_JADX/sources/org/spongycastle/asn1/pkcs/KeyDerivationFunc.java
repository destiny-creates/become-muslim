package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class KeyDerivationFunc extends ASN1Object {
    /* renamed from: a */
    private AlgorithmIdentifier f30987a;

    public KeyDerivationFunc(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f30987a = new AlgorithmIdentifier(aSN1ObjectIdentifier, aSN1Encodable);
    }

    private KeyDerivationFunc(ASN1Sequence aSN1Sequence) {
        this.f30987a = AlgorithmIdentifier.m40228a(aSN1Sequence);
    }

    /* renamed from: a */
    public static KeyDerivationFunc m40083a(Object obj) {
        if (obj instanceof KeyDerivationFunc) {
            return (KeyDerivationFunc) obj;
        }
        return obj != null ? new KeyDerivationFunc(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: a */
    public ASN1ObjectIdentifier m40084a() {
        return this.f30987a.m40230a();
    }

    /* renamed from: b */
    public ASN1Encodable m40085b() {
        return this.f30987a.m40231b();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f30987a.mo5709e();
    }
}
