package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;

public class X509Extensions extends ASN1Object {
    /* renamed from: A */
    public static final ASN1ObjectIdentifier f31411A = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2");
    /* renamed from: B */
    public static final ASN1ObjectIdentifier f31412B = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3");
    /* renamed from: C */
    public static final ASN1ObjectIdentifier f31413C = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4");
    /* renamed from: D */
    public static final ASN1ObjectIdentifier f31414D = new ASN1ObjectIdentifier("2.5.29.56");
    /* renamed from: E */
    public static final ASN1ObjectIdentifier f31415E = new ASN1ObjectIdentifier("2.5.29.55");
    /* renamed from: a */
    public static final ASN1ObjectIdentifier f31416a = new ASN1ObjectIdentifier("2.5.29.9");
    /* renamed from: b */
    public static final ASN1ObjectIdentifier f31417b = new ASN1ObjectIdentifier("2.5.29.14");
    /* renamed from: c */
    public static final ASN1ObjectIdentifier f31418c = new ASN1ObjectIdentifier("2.5.29.15");
    /* renamed from: d */
    public static final ASN1ObjectIdentifier f31419d = new ASN1ObjectIdentifier("2.5.29.16");
    /* renamed from: e */
    public static final ASN1ObjectIdentifier f31420e = new ASN1ObjectIdentifier("2.5.29.17");
    /* renamed from: f */
    public static final ASN1ObjectIdentifier f31421f = new ASN1ObjectIdentifier("2.5.29.18");
    /* renamed from: g */
    public static final ASN1ObjectIdentifier f31422g = new ASN1ObjectIdentifier("2.5.29.19");
    /* renamed from: h */
    public static final ASN1ObjectIdentifier f31423h = new ASN1ObjectIdentifier("2.5.29.20");
    /* renamed from: i */
    public static final ASN1ObjectIdentifier f31424i = new ASN1ObjectIdentifier("2.5.29.21");
    /* renamed from: j */
    public static final ASN1ObjectIdentifier f31425j = new ASN1ObjectIdentifier("2.5.29.23");
    /* renamed from: k */
    public static final ASN1ObjectIdentifier f31426k = new ASN1ObjectIdentifier("2.5.29.24");
    /* renamed from: l */
    public static final ASN1ObjectIdentifier f31427l = new ASN1ObjectIdentifier("2.5.29.27");
    /* renamed from: m */
    public static final ASN1ObjectIdentifier f31428m = new ASN1ObjectIdentifier("2.5.29.28");
    /* renamed from: n */
    public static final ASN1ObjectIdentifier f31429n = new ASN1ObjectIdentifier("2.5.29.29");
    /* renamed from: o */
    public static final ASN1ObjectIdentifier f31430o = new ASN1ObjectIdentifier("2.5.29.30");
    /* renamed from: p */
    public static final ASN1ObjectIdentifier f31431p = new ASN1ObjectIdentifier("2.5.29.31");
    /* renamed from: q */
    public static final ASN1ObjectIdentifier f31432q = new ASN1ObjectIdentifier("2.5.29.32");
    /* renamed from: r */
    public static final ASN1ObjectIdentifier f31433r = new ASN1ObjectIdentifier("2.5.29.33");
    /* renamed from: s */
    public static final ASN1ObjectIdentifier f31434s = new ASN1ObjectIdentifier("2.5.29.35");
    /* renamed from: t */
    public static final ASN1ObjectIdentifier f31435t = new ASN1ObjectIdentifier("2.5.29.36");
    /* renamed from: u */
    public static final ASN1ObjectIdentifier f31436u = new ASN1ObjectIdentifier("2.5.29.37");
    /* renamed from: v */
    public static final ASN1ObjectIdentifier f31437v = new ASN1ObjectIdentifier("2.5.29.46");
    /* renamed from: w */
    public static final ASN1ObjectIdentifier f31438w = new ASN1ObjectIdentifier("2.5.29.54");
    /* renamed from: x */
    public static final ASN1ObjectIdentifier f31439x = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1");
    /* renamed from: y */
    public static final ASN1ObjectIdentifier f31440y = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11");
    /* renamed from: z */
    public static final ASN1ObjectIdentifier f31441z = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12");
    /* renamed from: F */
    private Hashtable f31442F = new Hashtable();
    /* renamed from: G */
    private Vector f31443G = new Vector();

    /* renamed from: a */
    public static X509Extensions m40468a(Object obj) {
        if (obj != null) {
            if (!(obj instanceof X509Extensions)) {
                if (obj instanceof ASN1Sequence) {
                    return new X509Extensions((ASN1Sequence) obj);
                }
                if (obj instanceof Extensions) {
                    return new X509Extensions((ASN1Sequence) ((Extensions) obj).mo5709e());
                }
                if (obj instanceof ASN1TaggedObject) {
                    return m40468a(((ASN1TaggedObject) obj).m43036k());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("illegal object in getInstance: ");
                stringBuilder.append(obj.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (X509Extensions) obj;
    }

    public X509Extensions(ASN1Sequence aSN1Sequence) {
        aSN1Sequence = aSN1Sequence.mo6861c();
        while (aSN1Sequence.hasMoreElements()) {
            ASN1Sequence a = ASN1Sequence.m43000a(aSN1Sequence.nextElement());
            if (a.mo6862g() == 3) {
                this.f31442F.put(a.mo6860a(0), new X509Extension(ASN1Boolean.m42937a(a.mo6860a(1)), ASN1OctetString.m42990a(a.mo6860a(2))));
            } else if (a.mo6862g() == 2) {
                this.f31442F.put(a.mo6860a(0), new X509Extension(false, ASN1OctetString.m42990a(a.mo6860a(1))));
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Bad sequence size: ");
                stringBuilder.append(a.mo6862g());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.f31443G.addElement(a.mo6860a(0));
        }
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration elements = this.f31443G.elements();
        while (elements.hasMoreElements()) {
            ASN1Encodable aSN1Encodable = (ASN1ObjectIdentifier) elements.nextElement();
            X509Extension x509Extension = (X509Extension) this.f31442F.get(aSN1Encodable);
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.m27141a(aSN1Encodable);
            if (x509Extension.m27256a()) {
                aSN1EncodableVector2.m27141a(ASN1Boolean.f32476b);
            }
            aSN1EncodableVector2.m27141a(x509Extension.m27257b());
            aSN1EncodableVector.m27141a(new DERSequence(aSN1EncodableVector2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
