package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class PBES2Parameters extends ASN1Object implements PKCSObjectIdentifiers {
    private KeyDerivationFunc bF;
    private EncryptionScheme bG;

    /* renamed from: a */
    public static PBES2Parameters m40093a(Object obj) {
        if (obj instanceof PBES2Parameters) {
            return (PBES2Parameters) obj;
        }
        return obj != null ? new PBES2Parameters(ASN1Sequence.m43000a(obj)) : null;
    }

    private PBES2Parameters(ASN1Sequence aSN1Sequence) {
        aSN1Sequence = aSN1Sequence.mo6861c();
        ASN1Sequence a = ASN1Sequence.m43000a(((ASN1Encodable) aSN1Sequence.nextElement()).mo5709e());
        if (a.mo6860a(0).equals(z)) {
            this.bF = new KeyDerivationFunc(z, PBKDF2Params.m40097a(a.mo6860a(1)));
        } else {
            this.bF = KeyDerivationFunc.m40083a(a);
        }
        this.bG = EncryptionScheme.m40078a(aSN1Sequence.nextElement());
    }

    /* renamed from: a */
    public KeyDerivationFunc m40094a() {
        return this.bF;
    }

    /* renamed from: b */
    public EncryptionScheme m40095b() {
        return this.bG;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.bF);
        aSN1EncodableVector.m27141a(this.bG);
        return new DERSequence(aSN1EncodableVector);
    }
}
