package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;

public class X509Extension {
    /* renamed from: A */
    public static final ASN1ObjectIdentifier f22049A = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2");
    /* renamed from: B */
    public static final ASN1ObjectIdentifier f22050B = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3");
    /* renamed from: C */
    public static final ASN1ObjectIdentifier f22051C = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4");
    /* renamed from: D */
    public static final ASN1ObjectIdentifier f22052D = new ASN1ObjectIdentifier("2.5.29.56");
    /* renamed from: E */
    public static final ASN1ObjectIdentifier f22053E = new ASN1ObjectIdentifier("2.5.29.55");
    /* renamed from: a */
    public static final ASN1ObjectIdentifier f22054a = new ASN1ObjectIdentifier("2.5.29.9");
    /* renamed from: b */
    public static final ASN1ObjectIdentifier f22055b = new ASN1ObjectIdentifier("2.5.29.14");
    /* renamed from: c */
    public static final ASN1ObjectIdentifier f22056c = new ASN1ObjectIdentifier("2.5.29.15");
    /* renamed from: d */
    public static final ASN1ObjectIdentifier f22057d = new ASN1ObjectIdentifier("2.5.29.16");
    /* renamed from: e */
    public static final ASN1ObjectIdentifier f22058e = new ASN1ObjectIdentifier("2.5.29.17");
    /* renamed from: f */
    public static final ASN1ObjectIdentifier f22059f = new ASN1ObjectIdentifier("2.5.29.18");
    /* renamed from: g */
    public static final ASN1ObjectIdentifier f22060g = new ASN1ObjectIdentifier("2.5.29.19");
    /* renamed from: h */
    public static final ASN1ObjectIdentifier f22061h = new ASN1ObjectIdentifier("2.5.29.20");
    /* renamed from: i */
    public static final ASN1ObjectIdentifier f22062i = new ASN1ObjectIdentifier("2.5.29.21");
    /* renamed from: j */
    public static final ASN1ObjectIdentifier f22063j = new ASN1ObjectIdentifier("2.5.29.23");
    /* renamed from: k */
    public static final ASN1ObjectIdentifier f22064k = new ASN1ObjectIdentifier("2.5.29.24");
    /* renamed from: l */
    public static final ASN1ObjectIdentifier f22065l = new ASN1ObjectIdentifier("2.5.29.27");
    /* renamed from: m */
    public static final ASN1ObjectIdentifier f22066m = new ASN1ObjectIdentifier("2.5.29.28");
    /* renamed from: n */
    public static final ASN1ObjectIdentifier f22067n = new ASN1ObjectIdentifier("2.5.29.29");
    /* renamed from: o */
    public static final ASN1ObjectIdentifier f22068o = new ASN1ObjectIdentifier("2.5.29.30");
    /* renamed from: p */
    public static final ASN1ObjectIdentifier f22069p = new ASN1ObjectIdentifier("2.5.29.31");
    /* renamed from: q */
    public static final ASN1ObjectIdentifier f22070q = new ASN1ObjectIdentifier("2.5.29.32");
    /* renamed from: r */
    public static final ASN1ObjectIdentifier f22071r = new ASN1ObjectIdentifier("2.5.29.33");
    /* renamed from: s */
    public static final ASN1ObjectIdentifier f22072s = new ASN1ObjectIdentifier("2.5.29.35");
    /* renamed from: t */
    public static final ASN1ObjectIdentifier f22073t = new ASN1ObjectIdentifier("2.5.29.36");
    /* renamed from: u */
    public static final ASN1ObjectIdentifier f22074u = new ASN1ObjectIdentifier("2.5.29.37");
    /* renamed from: v */
    public static final ASN1ObjectIdentifier f22075v = new ASN1ObjectIdentifier("2.5.29.46");
    /* renamed from: w */
    public static final ASN1ObjectIdentifier f22076w = new ASN1ObjectIdentifier("2.5.29.54");
    /* renamed from: x */
    public static final ASN1ObjectIdentifier f22077x = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1");
    /* renamed from: y */
    public static final ASN1ObjectIdentifier f22078y = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11");
    /* renamed from: z */
    public static final ASN1ObjectIdentifier f22079z = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12");
    /* renamed from: F */
    boolean f22080F;
    /* renamed from: G */
    ASN1OctetString f22081G;

    public X509Extension(ASN1Boolean aSN1Boolean, ASN1OctetString aSN1OctetString) {
        this.f22080F = aSN1Boolean.m42944b();
        this.f22081G = aSN1OctetString;
    }

    public X509Extension(boolean z, ASN1OctetString aSN1OctetString) {
        this.f22080F = z;
        this.f22081G = aSN1OctetString;
    }

    /* renamed from: a */
    public boolean m27256a() {
        return this.f22080F;
    }

    /* renamed from: b */
    public ASN1OctetString m27257b() {
        return this.f22081G;
    }

    public int hashCode() {
        if (m27256a()) {
            return m27257b().hashCode();
        }
        return ~m27257b().hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof X509Extension)) {
            return false;
        }
        X509Extension x509Extension = (X509Extension) obj;
        if (x509Extension.m27257b().equals(m27257b()) && x509Extension.m27256a() == m27256a()) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static ASN1Primitive m27255a(X509Extension x509Extension) {
        try {
            return ASN1Primitive.m39798b(x509Extension.m27257b().mo6859c());
        } catch (X509Extension x509Extension2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("can't convert extension: ");
            stringBuilder.append(x509Extension2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
