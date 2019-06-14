package org.spongycastle.asn1.dvcs;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.cmp.PKIStatusInfo;
import org.spongycastle.asn1.x509.GeneralName;

public class DVCSErrorNotice extends ASN1Object {
    /* renamed from: a */
    private PKIStatusInfo f30731a;
    /* renamed from: b */
    private GeneralName f30732b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30731a);
        if (this.f30732b != null) {
            aSN1EncodableVector.m27141a(this.f30732b);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("DVCSErrorNotice {\ntransactionStatus: ");
        stringBuilder2.append(this.f30731a);
        stringBuilder2.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        if (this.f30732b != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("transactionIdentifier: ");
            stringBuilder3.append(this.f30732b);
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
