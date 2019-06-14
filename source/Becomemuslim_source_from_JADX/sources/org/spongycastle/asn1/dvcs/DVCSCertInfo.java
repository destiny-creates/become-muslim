package org.spongycastle.asn1.dvcs;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.cmp.PKIStatusInfo;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.PolicyInformation;

public class DVCSCertInfo extends ASN1Object {
    /* renamed from: a */
    private int f30721a;
    /* renamed from: b */
    private DVCSRequestInformation f30722b;
    /* renamed from: c */
    private DigestInfo f30723c;
    /* renamed from: d */
    private ASN1Integer f30724d;
    /* renamed from: e */
    private DVCSTime f30725e;
    /* renamed from: f */
    private PKIStatusInfo f30726f;
    /* renamed from: g */
    private PolicyInformation f30727g;
    /* renamed from: h */
    private ASN1Set f30728h;
    /* renamed from: i */
    private ASN1Sequence f30729i;
    /* renamed from: j */
    private Extensions f30730j;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30721a != 1) {
            aSN1EncodableVector.m27141a(new ASN1Integer((long) this.f30721a));
        }
        aSN1EncodableVector.m27141a(this.f30722b);
        aSN1EncodableVector.m27141a(this.f30723c);
        aSN1EncodableVector.m27141a(this.f30724d);
        aSN1EncodableVector.m27141a(this.f30725e);
        if (this.f30726f != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f30726f));
        }
        if (this.f30727g != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f30727g));
        }
        if (this.f30728h != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 2, this.f30728h));
        }
        if (this.f30729i != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 3, this.f30729i));
        }
        if (this.f30730j != null) {
            aSN1EncodableVector.m27141a(this.f30730j);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder stringBuilder;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DVCSCertInfo {\n");
        if (this.f30721a != 1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("version: ");
            stringBuilder.append(this.f30721a);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuffer.append(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("dvReqInfo: ");
        stringBuilder.append(this.f30722b);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("messageImprint: ");
        stringBuilder.append(this.f30723c);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("serialNumber: ");
        stringBuilder.append(this.f30724d);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("responseTime: ");
        stringBuilder.append(this.f30725e);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuffer.append(stringBuilder.toString());
        if (this.f30726f != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("dvStatus: ");
            stringBuilder.append(this.f30726f);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuffer.append(stringBuilder.toString());
        }
        if (this.f30727g != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("policy: ");
            stringBuilder.append(this.f30727g);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuffer.append(stringBuilder.toString());
        }
        if (this.f30728h != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("reqSignature: ");
            stringBuilder.append(this.f30728h);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuffer.append(stringBuilder.toString());
        }
        if (this.f30729i != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("certs: ");
            stringBuilder.append(this.f30729i);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuffer.append(stringBuilder.toString());
        }
        if (this.f30730j != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("extensions: ");
            stringBuilder.append(this.f30730j);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuffer.append(stringBuilder.toString());
        }
        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }
}
