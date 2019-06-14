package org.spongycastle.asn1.dvcs;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class TargetEtcChain extends ASN1Object {
    /* renamed from: a */
    private CertEtcToken f30761a;
    /* renamed from: b */
    private ASN1Sequence f30762b;
    /* renamed from: c */
    private PathProcInput f30763c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30761a);
        if (this.f30762b != null) {
            aSN1EncodableVector.m27141a(this.f30762b);
        }
        if (this.f30763c != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f30763c));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TargetEtcChain {\n");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("target: ");
        stringBuilder.append(this.f30761a);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuffer.append(stringBuilder.toString());
        if (this.f30762b != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("chain: ");
            stringBuilder.append(this.f30762b);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuffer.append(stringBuilder.toString());
        }
        if (this.f30763c != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("pathProcInput: ");
            stringBuilder.append(this.f30763c);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuffer.append(stringBuilder.toString());
        }
        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }
}
