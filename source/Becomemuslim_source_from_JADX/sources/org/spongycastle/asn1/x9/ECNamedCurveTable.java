package org.spongycastle.asn1.x9;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.anssi.ANSSINamedCurves;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.nist.NISTNamedCurves;
import org.spongycastle.asn1.sec.SECNamedCurves;
import org.spongycastle.asn1.teletrust.TeleTrusTNamedCurves;

public class ECNamedCurveTable {
    /* renamed from: a */
    public static X9ECParameters m27262a(String str) {
        X9ECParameters a = X962NamedCurves.m27267a(str);
        if (a == null) {
            a = SECNamedCurves.m27193a(str);
        }
        if (a == null) {
            a = NISTNamedCurves.m27187a(str);
        }
        if (a == null) {
            a = TeleTrusTNamedCurves.m27205a(str);
        }
        return a == null ? ANSSINamedCurves.m27172a(str) : a;
    }

    /* renamed from: b */
    public static ASN1ObjectIdentifier m27264b(String str) {
        ASN1ObjectIdentifier b = X962NamedCurves.m27271b(str);
        if (b == null) {
            b = SECNamedCurves.m27199b(str);
        }
        if (b == null) {
            b = NISTNamedCurves.m27191b(str);
        }
        if (b == null) {
            b = TeleTrusTNamedCurves.m27210b(str);
        }
        return b == null ? ANSSINamedCurves.m27176b(str) : b;
    }

    /* renamed from: a */
    public static String m27260a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String b = NISTNamedCurves.m27190b(aSN1ObjectIdentifier);
        if (b == null) {
            b = SECNamedCurves.m27198b(aSN1ObjectIdentifier);
        }
        if (b == null) {
            b = TeleTrusTNamedCurves.m27209b(aSN1ObjectIdentifier);
        }
        if (b == null) {
            b = X962NamedCurves.m27270b(aSN1ObjectIdentifier);
        }
        return b == null ? ECGOST3410NamedCurves.m27182b(aSN1ObjectIdentifier) : b;
    }

    /* renamed from: b */
    public static X9ECParameters m27265b(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParameters a = X962NamedCurves.m27268a(aSN1ObjectIdentifier);
        if (a == null) {
            a = SECNamedCurves.m27194a(aSN1ObjectIdentifier);
        }
        if (a == null) {
            a = TeleTrusTNamedCurves.m27206a(aSN1ObjectIdentifier);
        }
        return a == null ? ANSSINamedCurves.m27173a(aSN1ObjectIdentifier) : a;
    }

    /* renamed from: a */
    public static Enumeration m27261a() {
        Vector vector = new Vector();
        m27263a(vector, X962NamedCurves.m27266a());
        m27263a(vector, SECNamedCurves.m27192a());
        m27263a(vector, NISTNamedCurves.m27186a());
        m27263a(vector, TeleTrusTNamedCurves.m27204a());
        m27263a(vector, ANSSINamedCurves.m27171a());
        return vector.elements();
    }

    /* renamed from: a */
    private static void m27263a(Vector vector, Enumeration enumeration) {
        while (enumeration.hasMoreElements()) {
            vector.addElement(enumeration.nextElement());
        }
    }
}
