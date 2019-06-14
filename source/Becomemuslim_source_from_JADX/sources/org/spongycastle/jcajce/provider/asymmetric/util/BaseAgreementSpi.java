package org.spongycastle.jcajce.provider.asymmetric.util;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.KeyAgreementSpi;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.gnu.GNUObjectIdentifiers;
import org.spongycastle.asn1.kisa.KISAObjectIdentifiers;
import org.spongycastle.asn1.misc.MiscObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Strings;

public abstract class BaseAgreementSpi extends KeyAgreementSpi {
    /* renamed from: a */
    private static final Map<String, ASN1ObjectIdentifier> f22812a = new HashMap();
    /* renamed from: b */
    private static final Map<String, Integer> f22813b = new HashMap();
    /* renamed from: c */
    private static final Map<String, String> f22814c = new HashMap();

    static {
        Integer a = Integers.m29396a(64);
        Integer a2 = Integers.m29396a(128);
        Integer a3 = Integers.m29396a(JfifUtil.MARKER_SOFn);
        Integer a4 = Integers.m29396a(256);
        f22813b.put("DES", a);
        f22813b.put("DESEDE", a3);
        f22813b.put("BLOWFISH", a2);
        f22813b.put("AES", a4);
        f22813b.put(NISTObjectIdentifiers.f21795p.m42986b(), a2);
        f22813b.put(NISTObjectIdentifiers.f21802w.m42986b(), a3);
        f22813b.put(NISTObjectIdentifiers.f21768D.m42986b(), a4);
        f22813b.put(NISTObjectIdentifiers.f21796q.m42986b(), a2);
        f22813b.put(NISTObjectIdentifiers.f21803x.m42986b(), a3);
        f22813b.put(NISTObjectIdentifiers.f21769E.m42986b(), a4);
        f22813b.put(NISTObjectIdentifiers.f21798s.m42986b(), a2);
        f22813b.put(NISTObjectIdentifiers.f21805z.m42986b(), a3);
        f22813b.put(NISTObjectIdentifiers.f21771G.m42986b(), a4);
        f22813b.put(NISTObjectIdentifiers.f21797r.m42986b(), a2);
        f22813b.put(NISTObjectIdentifiers.f21804y.m42986b(), a3);
        f22813b.put(NISTObjectIdentifiers.f21770F.m42986b(), a4);
        f22813b.put(NISTObjectIdentifiers.f21799t.m42986b(), a2);
        f22813b.put(NISTObjectIdentifiers.f21765A.m42986b(), a3);
        f22813b.put(NISTObjectIdentifiers.f21772H.m42986b(), a4);
        f22813b.put(NISTObjectIdentifiers.f21801v.m42986b(), a2);
        f22813b.put(NISTObjectIdentifiers.f21767C.m42986b(), a3);
        f22813b.put(NISTObjectIdentifiers.f21774J.m42986b(), a4);
        f22813b.put(NISTObjectIdentifiers.f21800u.m42986b(), a2);
        f22813b.put(NISTObjectIdentifiers.f21766B.m42986b(), a3);
        f22813b.put(NISTObjectIdentifiers.f21773I.m42986b(), a4);
        f22813b.put(PKCSObjectIdentifiers.bD.m42986b(), a3);
        f22813b.put(PKCSObjectIdentifiers.f21835B.m42986b(), a3);
        f22813b.put(OIWObjectIdentifiers.f21826e.m42986b(), a);
        f22813b.put(PKCSObjectIdentifiers.f21842I.m42986b(), Integers.m29396a(160));
        f22813b.put(PKCSObjectIdentifiers.f21844K.m42986b(), a4);
        f22813b.put(PKCSObjectIdentifiers.f21845L.m42986b(), Integers.m29396a(BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT));
        f22813b.put(PKCSObjectIdentifiers.f21846M.m42986b(), Integers.m29396a(512));
        f22812a.put("DESEDE", PKCSObjectIdentifiers.f21835B);
        f22812a.put("AES", NISTObjectIdentifiers.f21769E);
        f22812a.put("CAMELLIA", NTTObjectIdentifiers.f21808c);
        f22812a.put("SEED", KISAObjectIdentifiers.f21723a);
        f22812a.put("DES", OIWObjectIdentifiers.f21826e);
        f22814c.put(MiscObjectIdentifiers.f21757u.m42986b(), "CAST5");
        f22814c.put(MiscObjectIdentifiers.f21758v.m42986b(), "IDEA");
        f22814c.put(MiscObjectIdentifiers.f21761y.m42986b(), "Blowfish");
        f22814c.put(MiscObjectIdentifiers.f21762z.m42986b(), "Blowfish");
        f22814c.put(MiscObjectIdentifiers.f21735A.m42986b(), "Blowfish");
        f22814c.put(MiscObjectIdentifiers.f21736B.m42986b(), "Blowfish");
        f22814c.put(OIWObjectIdentifiers.f21825d.m42986b(), "DES");
        f22814c.put(OIWObjectIdentifiers.f21826e.m42986b(), "DES");
        f22814c.put(OIWObjectIdentifiers.f21828g.m42986b(), "DES");
        f22814c.put(OIWObjectIdentifiers.f21827f.m42986b(), "DES");
        f22814c.put(OIWObjectIdentifiers.f21829h.m42986b(), "DESede");
        f22814c.put(PKCSObjectIdentifiers.f21835B.m42986b(), "DESede");
        f22814c.put(PKCSObjectIdentifiers.bD.m42986b(), "DESede");
        f22814c.put(PKCSObjectIdentifiers.bE.m42986b(), "RC2");
        f22814c.put(PKCSObjectIdentifiers.f21842I.m42986b(), "HmacSHA1");
        f22814c.put(PKCSObjectIdentifiers.f21843J.m42986b(), "HmacSHA224");
        f22814c.put(PKCSObjectIdentifiers.f21844K.m42986b(), "HmacSHA256");
        f22814c.put(PKCSObjectIdentifiers.f21845L.m42986b(), "HmacSHA384");
        f22814c.put(PKCSObjectIdentifiers.f21846M.m42986b(), "HmacSHA512");
        f22814c.put(NTTObjectIdentifiers.f21806a.m42986b(), "Camellia");
        f22814c.put(NTTObjectIdentifiers.f21807b.m42986b(), "Camellia");
        f22814c.put(NTTObjectIdentifiers.f21808c.m42986b(), "Camellia");
        f22814c.put(NTTObjectIdentifiers.f21809d.m42986b(), "Camellia");
        f22814c.put(NTTObjectIdentifiers.f21810e.m42986b(), "Camellia");
        f22814c.put(NTTObjectIdentifiers.f21811f.m42986b(), "Camellia");
        f22814c.put(KISAObjectIdentifiers.f21726d.m42986b(), "SEED");
        f22814c.put(KISAObjectIdentifiers.f21723a.m42986b(), "SEED");
        f22814c.put(KISAObjectIdentifiers.f21724b.m42986b(), "SEED");
        f22814c.put(CryptoProObjectIdentifiers.f21558d.m42986b(), "GOST28147");
        f22814c.put(NISTObjectIdentifiers.f21799t.m42986b(), "AES");
        f22814c.put(NISTObjectIdentifiers.f21801v.m42986b(), "AES");
        f22814c.put(NISTObjectIdentifiers.f21801v.m42986b(), "AES");
    }

    /* renamed from: a */
    protected static String m27987a(String str) {
        if (str.indexOf(91) > 0) {
            return str.substring(0, str.indexOf(91));
        }
        if (str.startsWith(NISTObjectIdentifiers.f21794o.m42986b())) {
            return "AES";
        }
        if (str.startsWith(GNUObjectIdentifiers.f21653i.m42986b())) {
            return "Serpent";
        }
        String str2 = (String) f22814c.get(Strings.m29424b(str));
        return str2 != null ? str2 : str;
    }

    /* renamed from: b */
    protected static int m27988b(String str) {
        if (str.indexOf(91) > 0) {
            return (Integer.parseInt(str.substring(str.indexOf(91) + 1, str.indexOf(93))) + 7) / 8;
        }
        str = Strings.m29424b(str);
        if (f22813b.containsKey(str)) {
            return ((Integer) f22813b.get(str)).intValue();
        }
        return -1;
    }
}
