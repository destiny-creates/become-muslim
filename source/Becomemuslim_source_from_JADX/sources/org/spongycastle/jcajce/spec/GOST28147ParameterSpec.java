package org.spongycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.crypto.engines.GOST28147Engine;
import org.spongycastle.util.Arrays;

public class GOST28147ParameterSpec implements AlgorithmParameterSpec {
    /* renamed from: c */
    private static Map f22899c = new HashMap();
    /* renamed from: a */
    private byte[] f22900a;
    /* renamed from: b */
    private byte[] f22901b;

    public GOST28147ParameterSpec(String str) {
        this.f22900a = null;
        this.f22901b = null;
        this.f22901b = GOST28147Engine.m34944a(str);
    }

    public GOST28147ParameterSpec(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr) {
        this(m28103a(aSN1ObjectIdentifier));
        this.f22900a = Arrays.m29373b(bArr);
    }

    /* renamed from: a */
    public byte[] m28104a() {
        return Arrays.m29373b(this.f22901b);
    }

    /* renamed from: b */
    public byte[] m28105b() {
        return Arrays.m29373b(this.f22900a);
    }

    static {
        f22899c.put(CryptoProObjectIdentifiers.f21559e, "E-A");
        f22899c.put(CryptoProObjectIdentifiers.f21560f, "E-B");
        f22899c.put(CryptoProObjectIdentifiers.f21561g, "E-C");
        f22899c.put(CryptoProObjectIdentifiers.f21562h, "E-D");
    }

    /* renamed from: a */
    private static String m28103a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) f22899c.get(aSN1ObjectIdentifier);
        if (str != null) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unknown OID: ");
        stringBuilder.append(aSN1ObjectIdentifier);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
