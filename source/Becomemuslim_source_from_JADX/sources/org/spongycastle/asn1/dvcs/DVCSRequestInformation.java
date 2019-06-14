package org.spongycastle.asn1.dvcs;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.PolicyInformation;

public class DVCSRequestInformation extends ASN1Object {
    /* renamed from: a */
    private int f30736a;
    /* renamed from: b */
    private ServiceType f30737b;
    /* renamed from: c */
    private BigInteger f30738c;
    /* renamed from: d */
    private DVCSTime f30739d;
    /* renamed from: e */
    private GeneralNames f30740e;
    /* renamed from: f */
    private PolicyInformation f30741f;
    /* renamed from: g */
    private GeneralNames f30742g;
    /* renamed from: h */
    private GeneralNames f30743h;
    /* renamed from: i */
    private Extensions f30744i;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30736a != 1) {
            aSN1EncodableVector.m27141a(new ASN1Integer((long) this.f30736a));
        }
        aSN1EncodableVector.m27141a(this.f30737b);
        if (this.f30738c != null) {
            aSN1EncodableVector.m27141a(new ASN1Integer(this.f30738c));
        }
        if (this.f30739d != null) {
            aSN1EncodableVector.m27141a(this.f30739d);
        }
        int[] iArr = new int[]{0, 1, 2, 3, 4};
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[]{this.f30740e, this.f30741f, this.f30742g, this.f30743h, this.f30744i};
        for (int i = 0; i < iArr.length; i++) {
            int i2 = iArr[i];
            ASN1Encodable aSN1Encodable = aSN1EncodableArr[i];
            if (aSN1Encodable != null) {
                aSN1EncodableVector.m27141a(new DERTaggedObject(false, i2, aSN1Encodable));
            }
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder stringBuilder;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DVCSRequestInformation {\n");
        if (this.f30736a != 1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("version: ");
            stringBuilder.append(this.f30736a);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuffer.append(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("service: ");
        stringBuilder.append(this.f30737b);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuffer.append(stringBuilder.toString());
        if (this.f30738c != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("nonce: ");
            stringBuilder.append(this.f30738c);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuffer.append(stringBuilder.toString());
        }
        if (this.f30739d != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("requestTime: ");
            stringBuilder.append(this.f30739d);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuffer.append(stringBuilder.toString());
        }
        if (this.f30740e != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("requester: ");
            stringBuilder.append(this.f30740e);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuffer.append(stringBuilder.toString());
        }
        if (this.f30741f != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("requestPolicy: ");
            stringBuilder.append(this.f30741f);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuffer.append(stringBuilder.toString());
        }
        if (this.f30742g != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("dvcs: ");
            stringBuilder.append(this.f30742g);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuffer.append(stringBuilder.toString());
        }
        if (this.f30743h != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("dataLocations: ");
            stringBuilder.append(this.f30743h);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuffer.append(stringBuilder.toString());
        }
        if (this.f30744i != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("extensions: ");
            stringBuilder.append(this.f30744i);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuffer.append(stringBuilder.toString());
        }
        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }
}
