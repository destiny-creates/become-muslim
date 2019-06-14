package org.spongycastle.asn1.crmf;

import com.facebook.appevents.AppEventsConstants;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;

public interface CRMFObjectIdentifiers {
    /* renamed from: a */
    public static final ASN1ObjectIdentifier f21546a = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
    /* renamed from: b */
    public static final ASN1ObjectIdentifier f21547b = f21546a.m42987b("5");
    /* renamed from: c */
    public static final ASN1ObjectIdentifier f21548c = f21547b.m42987b(AppEventsConstants.EVENT_PARAM_VALUE_YES);
    /* renamed from: d */
    public static final ASN1ObjectIdentifier f21549d = f21548c.m42987b(AppEventsConstants.EVENT_PARAM_VALUE_YES);
    /* renamed from: e */
    public static final ASN1ObjectIdentifier f21550e = f21548c.m42987b("2");
    /* renamed from: f */
    public static final ASN1ObjectIdentifier f21551f = f21548c.m42987b("3");
    /* renamed from: g */
    public static final ASN1ObjectIdentifier f21552g = f21548c.m42987b("4");
    /* renamed from: h */
    public static final ASN1ObjectIdentifier f21553h = PKCSObjectIdentifiers.au.m42987b("21");
}
