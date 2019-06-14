package org.spongycastle.asn1.nist;

import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.sec.SECNamedCurves;
import org.spongycastle.asn1.sec.SECObjectIdentifiers;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.util.Strings;

public class NISTNamedCurves {
    /* renamed from: a */
    static final Hashtable f21763a = new Hashtable();
    /* renamed from: b */
    static final Hashtable f21764b = new Hashtable();

    static {
        m27189a("B-163", SECObjectIdentifiers.f21944l);
        m27189a("B-233", SECObjectIdentifiers.f21952t);
        m27189a("B-283", SECObjectIdentifiers.f21946n);
        m27189a("B-409", SECObjectIdentifiers.f21911D);
        m27189a("B-571", SECObjectIdentifiers.f21913F);
        m27189a("K-163", SECObjectIdentifiers.f21934b);
        m27189a("K-233", SECObjectIdentifiers.f21951s);
        m27189a("K-283", SECObjectIdentifiers.f21945m);
        m27189a("K-409", SECObjectIdentifiers.f21910C);
        m27189a("K-571", SECObjectIdentifiers.f21912E);
        m27189a("P-192", SECObjectIdentifiers.f21914G);
        m27189a("P-224", SECObjectIdentifiers.f21958z);
        m27189a("P-256", SECObjectIdentifiers.f21915H);
        m27189a("P-384", SECObjectIdentifiers.f21908A);
        m27189a("P-521", SECObjectIdentifiers.f21909B);
    }

    /* renamed from: a */
    static void m27189a(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        f21763a.put(str.toUpperCase(), aSN1ObjectIdentifier);
        f21764b.put(aSN1ObjectIdentifier, str);
    }

    /* renamed from: a */
    public static X9ECParameters m27187a(String str) {
        ASN1ObjectIdentifier b = m27191b(str);
        if (b == null) {
            return null;
        }
        return m27188a(b);
    }

    /* renamed from: a */
    public static X9ECParameters m27188a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return SECNamedCurves.m27194a(aSN1ObjectIdentifier);
    }

    /* renamed from: b */
    public static ASN1ObjectIdentifier m27191b(String str) {
        return (ASN1ObjectIdentifier) f21763a.get(Strings.m29424b(str));
    }

    /* renamed from: b */
    public static String m27190b(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) f21764b.get(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public static Enumeration m27186a() {
        return f21764b.elements();
    }
}
