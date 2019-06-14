package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;

public class DERApplicationSpecific extends ASN1ApplicationSpecific {
    DERApplicationSpecific(boolean z, int i, byte[] bArr) {
        super(z, i, bArr);
    }

    public DERApplicationSpecific(boolean z, int i, ASN1Encodable aSN1Encodable) {
        boolean z2;
        if (!z) {
            if (!aSN1Encodable.mo5709e().mo6788a()) {
                z2 = false;
                super(z2, i, m44375a(z, aSN1Encodable));
            }
        }
        z2 = true;
        super(z2, i, m44375a(z, aSN1Encodable));
    }

    /* renamed from: a */
    private static byte[] m44375a(boolean z, ASN1Encodable aSN1Encodable) {
        aSN1Encodable = aSN1Encodable.mo5709e().m34596a("DER");
        if (z) {
            return aSN1Encodable;
        }
        z = ASN1ApplicationSpecific.m42928a((byte[]) aSN1Encodable);
        Object obj = new byte[(aSN1Encodable.length - z)];
        System.arraycopy(aSN1Encodable, z, obj, 0, obj.length);
        return obj;
    }

    public DERApplicationSpecific(int i, ASN1EncodableVector aSN1EncodableVector) {
        super(true, i, m44374a(aSN1EncodableVector));
    }

    /* renamed from: a */
    private static byte[] m44374a(ASN1EncodableVector aSN1EncodableVector) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i != aSN1EncodableVector.m27139a()) {
            try {
                byteArrayOutputStream.write(((ASN1Object) aSN1EncodableVector.m27140a(i)).m34596a("DER"));
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
        aSN1OutputStream.m27145a(this.a ? 96 : 64, this.b, this.c);
    }
}
