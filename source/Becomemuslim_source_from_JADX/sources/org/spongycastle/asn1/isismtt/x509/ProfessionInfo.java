package org.spongycastle.asn1.isismtt.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class ProfessionInfo extends ASN1Object {
    /* renamed from: a */
    public static final ASN1ObjectIdentifier f30883a;
    /* renamed from: b */
    public static final ASN1ObjectIdentifier f30884b;
    /* renamed from: c */
    public static final ASN1ObjectIdentifier f30885c;
    /* renamed from: d */
    public static final ASN1ObjectIdentifier f30886d;
    /* renamed from: e */
    public static final ASN1ObjectIdentifier f30887e;
    /* renamed from: f */
    public static final ASN1ObjectIdentifier f30888f;
    /* renamed from: g */
    public static final ASN1ObjectIdentifier f30889g;
    /* renamed from: h */
    public static final ASN1ObjectIdentifier f30890h;
    /* renamed from: i */
    public static final ASN1ObjectIdentifier f30891i;
    /* renamed from: j */
    public static final ASN1ObjectIdentifier f30892j;
    /* renamed from: k */
    public static final ASN1ObjectIdentifier f30893k;
    /* renamed from: l */
    public static final ASN1ObjectIdentifier f30894l;
    /* renamed from: m */
    public static final ASN1ObjectIdentifier f30895m;
    /* renamed from: n */
    public static final ASN1ObjectIdentifier f30896n;
    /* renamed from: o */
    public static final ASN1ObjectIdentifier f30897o;
    /* renamed from: p */
    public static final ASN1ObjectIdentifier f30898p;
    /* renamed from: q */
    public static final ASN1ObjectIdentifier f30899q;
    /* renamed from: r */
    public static final ASN1ObjectIdentifier f30900r;
    /* renamed from: s */
    public static final ASN1ObjectIdentifier f30901s;
    /* renamed from: t */
    private NamingAuthority f30902t;
    /* renamed from: u */
    private ASN1Sequence f30903u;
    /* renamed from: v */
    private ASN1Sequence f30904v;
    /* renamed from: w */
    private String f30905w;
    /* renamed from: x */
    private ASN1OctetString f30906x;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".1");
        f30883a = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".2");
        f30884b = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".3");
        f30885c = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".4");
        f30886d = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".5");
        f30887e = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".6");
        f30888f = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".7");
        f30889g = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".8");
        f30890h = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".9");
        f30891i = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".10");
        f30892j = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".11");
        f30893k = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".12");
        f30894l = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".13");
        f30895m = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".14");
        f30896n = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".15");
        f30897o = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".16");
        f30898p = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".17");
        f30899q = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".18");
        f30900r = new ASN1ObjectIdentifier(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(NamingAuthority.f30875a);
        stringBuilder.append(".19");
        f30901s = new ASN1ObjectIdentifier(stringBuilder.toString());
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f30902t != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f30902t));
        }
        aSN1EncodableVector.m27141a(this.f30903u);
        if (this.f30904v != null) {
            aSN1EncodableVector.m27141a(this.f30904v);
        }
        if (this.f30905w != null) {
            aSN1EncodableVector.m27141a(new DERPrintableString(this.f30905w, true));
        }
        if (this.f30906x != null) {
            aSN1EncodableVector.m27141a(this.f30906x);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
