package org.spongycastle.jcajce.util;

import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.gnu.GNUObjectIdentifiers;
import org.spongycastle.asn1.iso.ISOIECObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;

public class MessageDigestUtils {
    /* renamed from: a */
    private static Map<ASN1ObjectIdentifier, String> f22911a = new HashMap();

    static {
        f22911a.put(PKCSObjectIdentifiers.f21839F, "MD2");
        f22911a.put(PKCSObjectIdentifiers.f21840G, "MD4");
        f22911a.put(PKCSObjectIdentifiers.f21841H, "MD5");
        f22911a.put(OIWObjectIdentifiers.f21830i, "SHA-1");
        f22911a.put(NISTObjectIdentifiers.f21785f, "SHA-224");
        f22911a.put(NISTObjectIdentifiers.f21782c, "SHA-256");
        f22911a.put(NISTObjectIdentifiers.f21783d, "SHA-384");
        f22911a.put(NISTObjectIdentifiers.f21784e, "SHA-512");
        f22911a.put(TeleTrusTObjectIdentifiers.f21983c, "RIPEMD-128");
        f22911a.put(TeleTrusTObjectIdentifiers.f21982b, "RIPEMD-160");
        f22911a.put(TeleTrusTObjectIdentifiers.f21984d, "RIPEMD-128");
        f22911a.put(ISOIECObjectIdentifiers.f21718d, "RIPEMD-128");
        f22911a.put(ISOIECObjectIdentifiers.f21717c, "RIPEMD-160");
        f22911a.put(CryptoProObjectIdentifiers.f21556b, "GOST3411");
        f22911a.put(GNUObjectIdentifiers.f21651g, "Tiger");
        f22911a.put(ISOIECObjectIdentifiers.f21719e, "Whirlpool");
    }
}
