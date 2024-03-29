package org.spongycastle.asn1.sec;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.util.BigIntegers;

public class ECPrivateKey extends ASN1Object {
    /* renamed from: a */
    private ASN1Sequence f31052a;

    private ECPrivateKey(ASN1Sequence aSN1Sequence) {
        this.f31052a = aSN1Sequence;
    }

    /* renamed from: a */
    public static ECPrivateKey m40165a(Object obj) {
        if (obj instanceof ECPrivateKey) {
            return (ECPrivateKey) obj;
        }
        return obj != null ? new ECPrivateKey(ASN1Sequence.m43000a(obj)) : null;
    }

    public ECPrivateKey(int i, BigInteger bigInteger, ASN1Encodable aSN1Encodable) {
        this(i, bigInteger, null, aSN1Encodable);
    }

    public ECPrivateKey(int i, BigInteger bigInteger, DERBitString dERBitString, ASN1Encodable aSN1Encodable) {
        i = BigIntegers.m29388a((i + 7) / 8, bigInteger);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(new ASN1Integer(1));
        aSN1EncodableVector.m27141a(new DEROctetString(i));
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, aSN1Encodable));
        }
        if (dERBitString != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, dERBitString));
        }
        this.f31052a = new DERSequence(aSN1EncodableVector);
    }

    /* renamed from: a */
    public BigInteger m40166a() {
        return new BigInteger(1, ((ASN1OctetString) this.f31052a.mo6860a(1)).mo6859c());
    }

    /* renamed from: b */
    public DERBitString m40167b() {
        return (DERBitString) m40164a(1);
    }

    /* renamed from: a */
    private ASN1Primitive m40164a(int i) {
        Enumeration c = this.f31052a.mo6861c();
        while (c.hasMoreElements()) {
            ASN1Encodable aSN1Encodable = (ASN1Encodable) c.nextElement();
            if (aSN1Encodable instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Encodable;
                if (aSN1TaggedObject.m43030b() == i) {
                    return aSN1TaggedObject.m43036k().mo5709e();
                }
            }
        }
        return 0;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31052a;
    }
}
