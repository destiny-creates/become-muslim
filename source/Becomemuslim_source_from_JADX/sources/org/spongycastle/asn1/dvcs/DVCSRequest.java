package org.spongycastle.asn1.dvcs;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.GeneralName;

public class DVCSRequest extends ASN1Object {
    /* renamed from: a */
    private DVCSRequestInformation f30733a;
    /* renamed from: b */
    private Data f30734b;
    /* renamed from: c */
    private GeneralName f30735c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30733a);
        aSN1EncodableVector.m27141a(this.f30734b);
        if (this.f30735c != null) {
            aSN1EncodableVector.m27141a(this.f30735c);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("DVCSRequest {\nrequestInformation: ");
        stringBuilder2.append(this.f30733a);
        stringBuilder2.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder2.append("data: ");
        stringBuilder2.append(this.f30734b);
        stringBuilder2.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        if (this.f30735c != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("transactionIdentifier: ");
            stringBuilder3.append(this.f30735c);
            stringBuilder3.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder2.append(stringBuilder);
        stringBuilder2.append("}\n");
        return stringBuilder2.toString();
    }
}
