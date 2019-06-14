package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class Extension extends ASN1Object {
    /* renamed from: A */
    public static final ASN1ObjectIdentifier f31272A = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2").m42988c();
    /* renamed from: B */
    public static final ASN1ObjectIdentifier f31273B = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3").m42988c();
    /* renamed from: C */
    public static final ASN1ObjectIdentifier f31274C = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4").m42988c();
    /* renamed from: D */
    public static final ASN1ObjectIdentifier f31275D = new ASN1ObjectIdentifier("2.5.29.56").m42988c();
    /* renamed from: E */
    public static final ASN1ObjectIdentifier f31276E = new ASN1ObjectIdentifier("2.5.29.55").m42988c();
    /* renamed from: a */
    public static final ASN1ObjectIdentifier f31277a = new ASN1ObjectIdentifier("2.5.29.9").m42988c();
    /* renamed from: b */
    public static final ASN1ObjectIdentifier f31278b = new ASN1ObjectIdentifier("2.5.29.14").m42988c();
    /* renamed from: c */
    public static final ASN1ObjectIdentifier f31279c = new ASN1ObjectIdentifier("2.5.29.15").m42988c();
    /* renamed from: d */
    public static final ASN1ObjectIdentifier f31280d = new ASN1ObjectIdentifier("2.5.29.16").m42988c();
    /* renamed from: e */
    public static final ASN1ObjectIdentifier f31281e = new ASN1ObjectIdentifier("2.5.29.17").m42988c();
    /* renamed from: f */
    public static final ASN1ObjectIdentifier f31282f = new ASN1ObjectIdentifier("2.5.29.18").m42988c();
    /* renamed from: g */
    public static final ASN1ObjectIdentifier f31283g = new ASN1ObjectIdentifier("2.5.29.19").m42988c();
    /* renamed from: h */
    public static final ASN1ObjectIdentifier f31284h = new ASN1ObjectIdentifier("2.5.29.20").m42988c();
    /* renamed from: i */
    public static final ASN1ObjectIdentifier f31285i = new ASN1ObjectIdentifier("2.5.29.21").m42988c();
    /* renamed from: j */
    public static final ASN1ObjectIdentifier f31286j = new ASN1ObjectIdentifier("2.5.29.23").m42988c();
    /* renamed from: k */
    public static final ASN1ObjectIdentifier f31287k = new ASN1ObjectIdentifier("2.5.29.24").m42988c();
    /* renamed from: l */
    public static final ASN1ObjectIdentifier f31288l = new ASN1ObjectIdentifier("2.5.29.27").m42988c();
    /* renamed from: m */
    public static final ASN1ObjectIdentifier f31289m = new ASN1ObjectIdentifier("2.5.29.28").m42988c();
    /* renamed from: n */
    public static final ASN1ObjectIdentifier f31290n = new ASN1ObjectIdentifier("2.5.29.29").m42988c();
    /* renamed from: o */
    public static final ASN1ObjectIdentifier f31291o = new ASN1ObjectIdentifier("2.5.29.30").m42988c();
    /* renamed from: p */
    public static final ASN1ObjectIdentifier f31292p = new ASN1ObjectIdentifier("2.5.29.31").m42988c();
    /* renamed from: q */
    public static final ASN1ObjectIdentifier f31293q = new ASN1ObjectIdentifier("2.5.29.32").m42988c();
    /* renamed from: r */
    public static final ASN1ObjectIdentifier f31294r = new ASN1ObjectIdentifier("2.5.29.33").m42988c();
    /* renamed from: s */
    public static final ASN1ObjectIdentifier f31295s = new ASN1ObjectIdentifier("2.5.29.35").m42988c();
    /* renamed from: t */
    public static final ASN1ObjectIdentifier f31296t = new ASN1ObjectIdentifier("2.5.29.36").m42988c();
    /* renamed from: u */
    public static final ASN1ObjectIdentifier f31297u = new ASN1ObjectIdentifier("2.5.29.37").m42988c();
    /* renamed from: v */
    public static final ASN1ObjectIdentifier f31298v = new ASN1ObjectIdentifier("2.5.29.46").m42988c();
    /* renamed from: w */
    public static final ASN1ObjectIdentifier f31299w = new ASN1ObjectIdentifier("2.5.29.54").m42988c();
    /* renamed from: x */
    public static final ASN1ObjectIdentifier f31300x = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1").m42988c();
    /* renamed from: y */
    public static final ASN1ObjectIdentifier f31301y = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11").m42988c();
    /* renamed from: z */
    public static final ASN1ObjectIdentifier f31302z = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12").m42988c();
    /* renamed from: F */
    private ASN1ObjectIdentifier f31303F;
    /* renamed from: G */
    private boolean f31304G;
    /* renamed from: H */
    private ASN1OctetString f31305H;

    private Extension(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() == 2) {
            this.f31303F = ASN1ObjectIdentifier.m42973a(aSN1Sequence.mo6860a(0));
            this.f31304G = false;
            this.f31305H = ASN1OctetString.m42990a(aSN1Sequence.mo6860a(1));
        } else if (aSN1Sequence.mo6862g() == 3) {
            this.f31303F = ASN1ObjectIdentifier.m42973a(aSN1Sequence.mo6860a(0));
            this.f31304G = ASN1Boolean.m42937a(aSN1Sequence.mo6860a(1)).m42944b();
            this.f31305H = ASN1OctetString.m42990a(aSN1Sequence.mo6860a(2));
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bad sequence size: ");
            stringBuilder.append(aSN1Sequence.mo6862g());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public static Extension m40324a(Object obj) {
        if (obj instanceof Extension) {
            return (Extension) obj;
        }
        return obj != null ? new Extension(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: a */
    public ASN1ObjectIdentifier m40325a() {
        return this.f31303F;
    }

    /* renamed from: b */
    public boolean m40326b() {
        return this.f31304G;
    }

    /* renamed from: c */
    public ASN1OctetString m40327c() {
        return this.f31305H;
    }

    /* renamed from: d */
    public ASN1Encodable m40328d() {
        return m40323a(this);
    }

    public int hashCode() {
        if (m40326b()) {
            return m40327c().hashCode() ^ m40325a().hashCode();
        }
        return ~(m40327c().hashCode() ^ m40325a().hashCode());
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Extension)) {
            return false;
        }
        Extension extension = (Extension) obj;
        if (extension.m40325a().equals(m40325a()) && extension.m40327c().equals(m40327c()) && extension.m40326b() == m40326b()) {
            z = true;
        }
        return z;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31303F);
        if (this.f31304G) {
            aSN1EncodableVector.m27141a(ASN1Boolean.m42939a(true));
        }
        aSN1EncodableVector.m27141a(this.f31305H);
        return new DERSequence(aSN1EncodableVector);
    }

    /* renamed from: a */
    private static ASN1Primitive m40323a(Extension extension) {
        try {
            return ASN1Primitive.m39798b(extension.m40327c().mo6859c());
        } catch (Extension extension2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("can't convert extension: ");
            stringBuilder.append(extension2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
