package org.spongycastle.asn1.x509;

import com.facebook.appevents.AppEventsConstants;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;

public class KeyPurposeId extends ASN1Object {
    /* renamed from: a */
    public static final KeyPurposeId f31331a = new KeyPurposeId(Extension.f31297u.m42987b(AppEventsConstants.EVENT_PARAM_VALUE_NO));
    /* renamed from: b */
    public static final KeyPurposeId f31332b = new KeyPurposeId(f31352v.m42987b(AppEventsConstants.EVENT_PARAM_VALUE_YES));
    /* renamed from: c */
    public static final KeyPurposeId f31333c = new KeyPurposeId(f31352v.m42987b("2"));
    /* renamed from: d */
    public static final KeyPurposeId f31334d = new KeyPurposeId(f31352v.m42987b("3"));
    /* renamed from: e */
    public static final KeyPurposeId f31335e = new KeyPurposeId(f31352v.m42987b("4"));
    /* renamed from: f */
    public static final KeyPurposeId f31336f = new KeyPurposeId(f31352v.m42987b("5"));
    /* renamed from: g */
    public static final KeyPurposeId f31337g = new KeyPurposeId(f31352v.m42987b("6"));
    /* renamed from: h */
    public static final KeyPurposeId f31338h = new KeyPurposeId(f31352v.m42987b("7"));
    /* renamed from: i */
    public static final KeyPurposeId f31339i = new KeyPurposeId(f31352v.m42987b("8"));
    /* renamed from: j */
    public static final KeyPurposeId f31340j = new KeyPurposeId(f31352v.m42987b("9"));
    /* renamed from: k */
    public static final KeyPurposeId f31341k = new KeyPurposeId(f31352v.m42987b("10"));
    /* renamed from: l */
    public static final KeyPurposeId f31342l = new KeyPurposeId(f31352v.m42987b("11"));
    /* renamed from: m */
    public static final KeyPurposeId f31343m = new KeyPurposeId(f31352v.m42987b("12"));
    /* renamed from: n */
    public static final KeyPurposeId f31344n = new KeyPurposeId(f31352v.m42987b("13"));
    /* renamed from: o */
    public static final KeyPurposeId f31345o = new KeyPurposeId(f31352v.m42987b("14"));
    /* renamed from: p */
    public static final KeyPurposeId f31346p = new KeyPurposeId(f31352v.m42987b("15"));
    /* renamed from: q */
    public static final KeyPurposeId f31347q = new KeyPurposeId(f31352v.m42987b("16"));
    /* renamed from: r */
    public static final KeyPurposeId f31348r = new KeyPurposeId(f31352v.m42987b("17"));
    /* renamed from: s */
    public static final KeyPurposeId f31349s = new KeyPurposeId(f31352v.m42987b("18"));
    /* renamed from: t */
    public static final KeyPurposeId f31350t = new KeyPurposeId(f31352v.m42987b("19"));
    /* renamed from: u */
    public static final KeyPurposeId f31351u = new KeyPurposeId(new ASN1ObjectIdentifier("1.3.6.1.4.1.311.20.2.2"));
    /* renamed from: v */
    private static final ASN1ObjectIdentifier f31352v = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.3");
    /* renamed from: w */
    private ASN1ObjectIdentifier f31353w;

    private KeyPurposeId(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f31353w = aSN1ObjectIdentifier;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31353w;
    }
}
