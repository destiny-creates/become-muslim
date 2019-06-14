package org.spongycastle.asn1.anssi;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.asn1.x9.X9ECPoint;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECCurve.Fp;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public class ANSSINamedCurves {
    /* renamed from: a */
    static X9ECParametersHolder f21464a = new C76901();
    /* renamed from: b */
    static final Hashtable f21465b = new Hashtable();
    /* renamed from: c */
    static final Hashtable f21466c = new Hashtable();
    /* renamed from: d */
    static final Hashtable f21467d = new Hashtable();

    /* renamed from: org.spongycastle.asn1.anssi.ANSSINamedCurves$1 */
    static class C76901 extends X9ECParametersHolder {
        C76901() {
        }

        /* renamed from: a */
        protected X9ECParameters mo5716a() {
            BigInteger c = ANSSINamedCurves.m27179d("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C03");
            BigInteger c2 = ANSSINamedCurves.m27179d("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C00");
            BigInteger c3 = ANSSINamedCurves.m27179d("EE353FCA5428A9300D4ABA754A44C00FDFEC0C9AE4B1A1803075ED967B7BB73F");
            BigInteger c4 = ANSSINamedCurves.m27179d("F1FD178C0B3AD58F10126DE8CE42435B53DC67E140D2BF941FFDD459C6D655E1");
            BigInteger valueOf = BigInteger.valueOf(1);
            ECCurve a = ANSSINamedCurves.m27177b(new Fp(c, c2, c3, c4, valueOf));
            return new X9ECParameters(a, new X9ECPoint(a, Hex.m29436a("04B6B3D4C356C139EB31183D4749D423958C27D2DCAF98B70164C97A2DD98F5CFF6142E0F7C8B204911F9271F0F3ECEF8C2701C307E8E4C9E183115A1554062CFB")), c4, valueOf, null);
        }
    }

    /* renamed from: b */
    private static ECCurve m27177b(ECCurve eCCurve) {
        return eCCurve;
    }

    /* renamed from: d */
    private static BigInteger m27179d(String str) {
        return new BigInteger(1, Hex.m29436a(str));
    }

    static {
        m27175a("FRP256v1", ANSSIObjectIdentifiers.f21468a, f21464a);
    }

    /* renamed from: a */
    static void m27175a(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, X9ECParametersHolder x9ECParametersHolder) {
        f21465b.put(str.toLowerCase(), aSN1ObjectIdentifier);
        f21467d.put(aSN1ObjectIdentifier, str);
        f21466c.put(aSN1ObjectIdentifier, x9ECParametersHolder);
    }

    /* renamed from: a */
    public static X9ECParameters m27172a(String str) {
        ASN1ObjectIdentifier b = m27176b(str);
        if (b == null) {
            return null;
        }
        return m27173a(b);
    }

    /* renamed from: a */
    public static X9ECParameters m27173a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParametersHolder x9ECParametersHolder = (X9ECParametersHolder) f21466c.get(aSN1ObjectIdentifier);
        if (x9ECParametersHolder == null) {
            return null;
        }
        return x9ECParametersHolder.m27273b();
    }

    /* renamed from: b */
    public static ASN1ObjectIdentifier m27176b(String str) {
        return (ASN1ObjectIdentifier) f21465b.get(Strings.m29427c(str));
    }

    /* renamed from: a */
    public static Enumeration m27171a() {
        return f21467d.elements();
    }
}
