package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class V2TBSCertListGenerator {
    /* renamed from: e */
    private static final ASN1Sequence[] f22030e = new ASN1Sequence[11];
    /* renamed from: a */
    private ASN1Integer f22031a = new ASN1Integer(1);
    /* renamed from: b */
    private Time f22032b = null;
    /* renamed from: c */
    private Extensions f22033c = null;
    /* renamed from: d */
    private ASN1EncodableVector f22034d = new ASN1EncodableVector();

    static {
        f22030e[0] = m27254a(0);
        f22030e[1] = m27254a(1);
        f22030e[2] = m27254a(2);
        f22030e[3] = m27254a(3);
        f22030e[4] = m27254a(4);
        f22030e[5] = m27254a(5);
        f22030e[6] = m27254a(6);
        f22030e[7] = m27254a(7);
        f22030e[8] = m27254a(8);
        f22030e[9] = m27254a(9);
        f22030e[10] = m27254a(10);
    }

    /* renamed from: a */
    private static ASN1Sequence m27254a(int i) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        i = CRLReason.m40267a(i);
        try {
            aSN1EncodableVector.m27141a(Extension.f31285i);
            aSN1EncodableVector.m27141a(new DEROctetString(i.mo6822f()));
            return new DERSequence(aSN1EncodableVector);
        } catch (int i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("error encoding reason: ");
            stringBuilder.append(i2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
