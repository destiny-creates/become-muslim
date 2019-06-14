package org.spongycastle.asn1.dvcs;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.PolicyInformation;

public class PathProcInput extends ASN1Object {
    /* renamed from: a */
    private PolicyInformation[] f30752a;
    /* renamed from: b */
    private boolean f30753b;
    /* renamed from: c */
    private boolean f30754c;
    /* renamed from: d */
    private boolean f30755d;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (int i = 0; i != this.f30752a.length; i++) {
            aSN1EncodableVector2.m27141a(this.f30752a[i]);
        }
        aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        if (this.f30753b) {
            aSN1EncodableVector.m27141a(new ASN1Boolean(this.f30753b));
        }
        if (this.f30754c) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, new ASN1Boolean(this.f30754c)));
        }
        if (this.f30755d) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, new ASN1Boolean(this.f30755d)));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PathProcInput: {\nacceptablePolicySet: ");
        stringBuilder.append(this.f30752a);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder.append("inhibitPolicyMapping: ");
        stringBuilder.append(this.f30753b);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder.append("explicitPolicyReqd: ");
        stringBuilder.append(this.f30754c);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder.append("inhibitAnyPolicy: ");
        stringBuilder.append(this.f30755d);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}
