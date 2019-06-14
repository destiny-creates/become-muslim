package org.spongycastle.asn1;

import java.util.Enumeration;

public class BERTaggedObject extends ASN1TaggedObject {
    public BERTaggedObject(int i, ASN1Encodable aSN1Encodable) {
        super(true, i, aSN1Encodable);
    }

    public BERTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    /* renamed from: a */
    boolean mo6788a() {
        if (this.b || this.c) {
            return true;
        }
        return this.d.mo5709e().mo6791h().mo6788a();
    }

    /* renamed from: d */
    int mo6790d() {
        if (this.b) {
            return StreamUtil.m27170b(this.a) + 1;
        }
        int d = this.d.mo5709e().mo6790d();
        if (this.c) {
            return (StreamUtil.m27170b(this.a) + StreamUtil.m27168a(d)) + d;
        }
        return StreamUtil.m27170b(this.a) + (d - 1);
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.m27144a(160, this.a);
        aSN1OutputStream.mo5710b(128);
        if (!this.b) {
            if (this.c) {
                aSN1OutputStream.mo5713a(this.d);
            } else {
                Enumeration j;
                if (this.d instanceof ASN1OctetString) {
                    if (this.d instanceof BEROctetString) {
                        j = ((BEROctetString) this.d).mo6872j();
                    } else {
                        j = new BEROctetString(((ASN1OctetString) this.d).mo6859c()).mo6872j();
                    }
                } else if (this.d instanceof ASN1Sequence) {
                    j = ((ASN1Sequence) this.d).mo6861c();
                } else if (this.d instanceof ASN1Set) {
                    j = ((ASN1Set) this.d).m43020b();
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("not implemented: ");
                    stringBuilder.append(this.d.getClass().getName());
                    throw new RuntimeException(stringBuilder.toString());
                }
                while (j.hasMoreElements()) {
                    aSN1OutputStream.mo5713a((ASN1Encodable) j.nextElement());
                }
            }
        }
        aSN1OutputStream.mo5710b(0);
        aSN1OutputStream.mo5710b(0);
    }
}
