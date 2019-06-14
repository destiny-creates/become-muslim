package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.DLSequence;

public class AuthenticatedSafe extends ASN1Object {
    /* renamed from: a */
    private ContentInfo[] f30965a;
    /* renamed from: b */
    private boolean f30966b = true;

    private AuthenticatedSafe(ASN1Sequence aSN1Sequence) {
        this.f30965a = new ContentInfo[aSN1Sequence.mo6862g()];
        for (int i = 0; i != this.f30965a.length; i++) {
            this.f30965a[i] = ContentInfo.m40061a(aSN1Sequence.mo6860a(i));
        }
        this.f30966b = aSN1Sequence instanceof BERSequence;
    }

    /* renamed from: a */
    public static AuthenticatedSafe m40051a(Object obj) {
        if (obj instanceof AuthenticatedSafe) {
            return (AuthenticatedSafe) obj;
        }
        return obj != null ? new AuthenticatedSafe(ASN1Sequence.m43000a(obj)) : null;
    }

    public AuthenticatedSafe(ContentInfo[] contentInfoArr) {
        this.f30965a = contentInfoArr;
    }

    /* renamed from: a */
    public ContentInfo[] m40052a() {
        return this.f30965a;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (int i = 0; i != this.f30965a.length; i++) {
            aSN1EncodableVector.m27141a(this.f30965a[i]);
        }
        if (this.f30966b) {
            return new BERSequence(aSN1EncodableVector);
        }
        return new DLSequence(aSN1EncodableVector);
    }
}
