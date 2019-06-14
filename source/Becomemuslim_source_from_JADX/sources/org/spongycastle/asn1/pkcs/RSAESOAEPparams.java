package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class RSAESOAEPparams extends ASN1Object {
    /* renamed from: a */
    public static final AlgorithmIdentifier f31006a = new AlgorithmIdentifier(OIWObjectIdentifiers.f21830i, DERNull.f32850a);
    /* renamed from: b */
    public static final AlgorithmIdentifier f31007b = new AlgorithmIdentifier(PKCSObjectIdentifiers.l_, f31006a);
    /* renamed from: c */
    public static final AlgorithmIdentifier f31008c = new AlgorithmIdentifier(PKCSObjectIdentifiers.f21863j, new DEROctetString(new byte[0]));
    /* renamed from: d */
    private AlgorithmIdentifier f31009d;
    /* renamed from: e */
    private AlgorithmIdentifier f31010e;
    /* renamed from: f */
    private AlgorithmIdentifier f31011f;

    /* renamed from: a */
    public static RSAESOAEPparams m40120a(Object obj) {
        if (obj instanceof RSAESOAEPparams) {
            return (RSAESOAEPparams) obj;
        }
        return obj != null ? new RSAESOAEPparams(ASN1Sequence.m43000a(obj)) : null;
    }

    public RSAESOAEPparams() {
        this.f31009d = f31006a;
        this.f31010e = f31007b;
        this.f31011f = f31008c;
    }

    public RSAESOAEPparams(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, AlgorithmIdentifier algorithmIdentifier3) {
        this.f31009d = algorithmIdentifier;
        this.f31010e = algorithmIdentifier2;
        this.f31011f = algorithmIdentifier3;
    }

    public RSAESOAEPparams(ASN1Sequence aSN1Sequence) {
        this.f31009d = f31006a;
        this.f31010e = f31007b;
        this.f31011f = f31008c;
        for (int i = 0; i != aSN1Sequence.mo6862g(); i++) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.mo6860a(i);
            switch (aSN1TaggedObject.m43030b()) {
                case 0:
                    this.f31009d = AlgorithmIdentifier.m40229a(aSN1TaggedObject, true);
                    break;
                case 1:
                    this.f31010e = AlgorithmIdentifier.m40229a(aSN1TaggedObject, true);
                    break;
                case 2:
                    this.f31011f = AlgorithmIdentifier.m40229a(aSN1TaggedObject, true);
                    break;
                default:
                    throw new IllegalArgumentException("unknown tag");
            }
        }
    }

    /* renamed from: a */
    public AlgorithmIdentifier m40121a() {
        return this.f31009d;
    }

    /* renamed from: b */
    public AlgorithmIdentifier m40122b() {
        return this.f31010e;
    }

    /* renamed from: c */
    public AlgorithmIdentifier m40123c() {
        return this.f31011f;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (!this.f31009d.equals(f31006a)) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f31009d));
        }
        if (!this.f31010e.equals(f31007b)) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, this.f31010e));
        }
        if (!this.f31011f.equals(f31008c)) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 2, this.f31011f));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
