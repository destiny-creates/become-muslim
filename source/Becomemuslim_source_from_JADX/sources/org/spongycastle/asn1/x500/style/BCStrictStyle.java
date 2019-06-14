package org.spongycastle.asn1.x500.style;

import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.X500NameStyle;

public class BCStrictStyle extends BCStyle {
    /* renamed from: a */
    public static final X500NameStyle f32529a = new BCStrictStyle();

    /* renamed from: a */
    public boolean mo5719a(X500Name x500Name, X500Name x500Name2) {
        x500Name = x500Name.m40215a();
        x500Name2 = x500Name2.m40215a();
        if (x500Name.length != x500Name2.length) {
            return false;
        }
        for (int i = 0; i != x500Name.length; i++) {
            if (!m34665a(x500Name[i], x500Name2[i])) {
                return false;
            }
        }
        return true;
    }
}
