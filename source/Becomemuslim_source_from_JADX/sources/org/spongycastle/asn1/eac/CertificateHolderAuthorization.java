package org.spongycastle.asn1.eac;

import com.facebook.imageutils.JfifUtil;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERApplicationSpecific;
import org.spongycastle.util.Integers;

public class CertificateHolderAuthorization extends ASN1Object {
    /* renamed from: c */
    public static final ASN1ObjectIdentifier f30781c = EACObjectIdentifiers.f21598a.m42987b("3.1.2.1");
    /* renamed from: d */
    static Hashtable f30782d = new Hashtable();
    /* renamed from: e */
    static BidirectionalMap f30783e = new BidirectionalMap();
    /* renamed from: f */
    static Hashtable f30784f = new Hashtable();
    /* renamed from: a */
    ASN1ObjectIdentifier f30785a;
    /* renamed from: b */
    DERApplicationSpecific f30786b;

    static {
        f30782d.put(Integers.m29396a(2), "RADG4");
        f30782d.put(Integers.m29396a(1), "RADG3");
        f30783e.put(Integers.m29396a(JfifUtil.MARKER_SOFn), "CVCA");
        f30783e.put(Integers.m29396a(128), "DV_DOMESTIC");
        f30783e.put(Integers.m29396a(64), "DV_FOREIGN");
        f30783e.put(Integers.m29396a(0), "IS");
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30785a);
        aSN1EncodableVector.m27141a(this.f30786b);
        return new DERApplicationSpecific(76, aSN1EncodableVector);
    }
}
