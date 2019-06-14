package org.spongycastle.jcajce.provider.asymmetric.util;

import java.util.HashSet;
import java.util.Set;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;

public class DESUtil {
    /* renamed from: a */
    private static final Set<String> f22820a = new HashSet();

    static {
        f22820a.add("DES");
        f22820a.add("DESEDE");
        f22820a.add(OIWObjectIdentifiers.f21826e.m42986b());
        f22820a.add(PKCSObjectIdentifiers.f21835B.m42986b());
        f22820a.add(PKCSObjectIdentifiers.f21835B.m42986b());
        f22820a.add(PKCSObjectIdentifiers.bD.m42986b());
    }
}
