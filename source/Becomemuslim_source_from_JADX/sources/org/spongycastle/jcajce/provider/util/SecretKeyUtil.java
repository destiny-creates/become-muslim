package org.spongycastle.jcajce.provider.util;

import com.facebook.imageutils.JfifUtil;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.util.Integers;

public class SecretKeyUtil {
    /* renamed from: a */
    private static Map f22898a = new HashMap();

    static {
        f22898a.put(PKCSObjectIdentifiers.f21835B.m42986b(), Integers.m29396a(JfifUtil.MARKER_SOFn));
        f22898a.put(NISTObjectIdentifiers.f21796q, Integers.m29396a(128));
        f22898a.put(NISTObjectIdentifiers.f21803x, Integers.m29396a(JfifUtil.MARKER_SOFn));
        f22898a.put(NISTObjectIdentifiers.f21769E, Integers.m29396a(256));
        f22898a.put(NTTObjectIdentifiers.f21806a, Integers.m29396a(128));
        f22898a.put(NTTObjectIdentifiers.f21807b, Integers.m29396a(JfifUtil.MARKER_SOFn));
        f22898a.put(NTTObjectIdentifiers.f21808c, Integers.m29396a(256));
    }
}
