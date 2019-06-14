package org.spongycastle.jcajce.provider.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHA512tDigest;
import org.spongycastle.util.Strings;

public class DigestFactory {
    /* renamed from: a */
    private static Set f22889a = new HashSet();
    /* renamed from: b */
    private static Set f22890b = new HashSet();
    /* renamed from: c */
    private static Set f22891c = new HashSet();
    /* renamed from: d */
    private static Set f22892d = new HashSet();
    /* renamed from: e */
    private static Set f22893e = new HashSet();
    /* renamed from: f */
    private static Set f22894f = new HashSet();
    /* renamed from: g */
    private static Set f22895g = new HashSet();
    /* renamed from: h */
    private static Set f22896h = new HashSet();
    /* renamed from: i */
    private static Map f22897i = new HashMap();

    static {
        f22889a.add("MD5");
        f22889a.add(PKCSObjectIdentifiers.f21841H.m42986b());
        f22890b.add("SHA1");
        f22890b.add("SHA-1");
        f22890b.add(OIWObjectIdentifiers.f21830i.m42986b());
        f22891c.add("SHA224");
        f22891c.add("SHA-224");
        f22891c.add(NISTObjectIdentifiers.f21785f.m42986b());
        f22892d.add("SHA256");
        f22892d.add("SHA-256");
        f22892d.add(NISTObjectIdentifiers.f21782c.m42986b());
        f22893e.add("SHA384");
        f22893e.add("SHA-384");
        f22893e.add(NISTObjectIdentifiers.f21783d.m42986b());
        f22894f.add("SHA512");
        f22894f.add("SHA-512");
        f22894f.add(NISTObjectIdentifiers.f21784e.m42986b());
        f22895g.add("SHA512(224)");
        f22895g.add("SHA-512(224)");
        f22895g.add(NISTObjectIdentifiers.f21786g.m42986b());
        f22896h.add("SHA512(256)");
        f22896h.add("SHA-512(256)");
        f22896h.add(NISTObjectIdentifiers.f21787h.m42986b());
        f22897i.put("MD5", PKCSObjectIdentifiers.f21841H);
        f22897i.put(PKCSObjectIdentifiers.f21841H.m42986b(), PKCSObjectIdentifiers.f21841H);
        f22897i.put("SHA1", OIWObjectIdentifiers.f21830i);
        f22897i.put("SHA-1", OIWObjectIdentifiers.f21830i);
        f22897i.put(OIWObjectIdentifiers.f21830i.m42986b(), OIWObjectIdentifiers.f21830i);
        f22897i.put("SHA224", NISTObjectIdentifiers.f21785f);
        f22897i.put("SHA-224", NISTObjectIdentifiers.f21785f);
        f22897i.put(NISTObjectIdentifiers.f21785f.m42986b(), NISTObjectIdentifiers.f21785f);
        f22897i.put("SHA256", NISTObjectIdentifiers.f21782c);
        f22897i.put("SHA-256", NISTObjectIdentifiers.f21782c);
        f22897i.put(NISTObjectIdentifiers.f21782c.m42986b(), NISTObjectIdentifiers.f21782c);
        f22897i.put("SHA384", NISTObjectIdentifiers.f21783d);
        f22897i.put("SHA-384", NISTObjectIdentifiers.f21783d);
        f22897i.put(NISTObjectIdentifiers.f21783d.m42986b(), NISTObjectIdentifiers.f21783d);
        f22897i.put("SHA512", NISTObjectIdentifiers.f21784e);
        f22897i.put("SHA-512", NISTObjectIdentifiers.f21784e);
        f22897i.put(NISTObjectIdentifiers.f21784e.m42986b(), NISTObjectIdentifiers.f21784e);
        f22897i.put("SHA512(224)", NISTObjectIdentifiers.f21786g);
        f22897i.put("SHA-512(224)", NISTObjectIdentifiers.f21786g);
        f22897i.put(NISTObjectIdentifiers.f21786g.m42986b(), NISTObjectIdentifiers.f21786g);
        f22897i.put("SHA512(256)", NISTObjectIdentifiers.f21787h);
        f22897i.put("SHA-512(256)", NISTObjectIdentifiers.f21787h);
        f22897i.put(NISTObjectIdentifiers.f21787h.m42986b(), NISTObjectIdentifiers.f21787h);
    }

    /* renamed from: a */
    public static Digest m28100a(String str) {
        str = Strings.m29424b(str);
        if (f22890b.contains(str)) {
            return new SHA1Digest();
        }
        if (f22889a.contains(str)) {
            return new MD5Digest();
        }
        if (f22891c.contains(str)) {
            return new SHA224Digest();
        }
        if (f22892d.contains(str)) {
            return new SHA256Digest();
        }
        if (f22893e.contains(str)) {
            return new SHA384Digest();
        }
        if (f22894f.contains(str)) {
            return new SHA512Digest();
        }
        if (f22895g.contains(str)) {
            return new SHA512tDigest(224);
        }
        return f22896h.contains(str) != null ? new SHA512tDigest(256) : null;
    }

    /* renamed from: a */
    public static boolean m28101a(String str, String str2) {
        return (!(f22890b.contains(str) && f22890b.contains(str2)) && (!(f22891c.contains(str) && f22891c.contains(str2)) && (!(f22892d.contains(str) && f22892d.contains(str2)) && (!(f22893e.contains(str) && f22893e.contains(str2)) && (!(f22894f.contains(str) && f22894f.contains(str2)) && (!(f22895g.contains(str) && f22895g.contains(str2)) && (!(f22896h.contains(str) && f22896h.contains(str2)) && (f22889a.contains(str) == null || f22889a.contains(str2) == null)))))))) ? null : true;
    }

    /* renamed from: b */
    public static ASN1ObjectIdentifier m28102b(String str) {
        return (ASN1ObjectIdentifier) f22897i.get(str);
    }
}
