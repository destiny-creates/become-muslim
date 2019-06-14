package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;

public class BERApplicationSpecific extends ASN1ApplicationSpecific {
    public BERApplicationSpecific(int i, ASN1EncodableVector aSN1EncodableVector) {
        super(true, i, m44356a(aSN1EncodableVector));
    }

    /* renamed from: a */
    private static byte[] m44356a(ASN1EncodableVector aSN1EncodableVector) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i != aSN1EncodableVector.m27139a()) {
            try {
                byteArrayOutputStream.write(((ASN1Object) aSN1EncodableVector.m27140a(i)).m34596a("BER"));
                i++;
            } catch (ASN1EncodableVector aSN1EncodableVector2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("malformed object: ");
                stringBuilder.append(aSN1EncodableVector2);
                throw new ASN1ParsingException(stringBuilder.toString(), aSN1EncodableVector2);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.m27144a(this.a ? 96 : 64, this.b);
        aSN1OutputStream.mo5710b(128);
        aSN1OutputStream.m27149a(this.c);
        aSN1OutputStream.mo5710b(0);
        aSN1OutputStream.mo5710b(0);
    }
}
