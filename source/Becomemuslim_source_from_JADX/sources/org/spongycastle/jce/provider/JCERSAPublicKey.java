package org.spongycastle.jce.provider;

import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.util.Strings;

public class JCERSAPublicKey implements RSAPublicKey {
    static final long serialVersionUID = 2675817738516720772L;
    /* renamed from: a */
    private BigInteger f22975a;
    /* renamed from: b */
    private BigInteger f22976b;

    public String getAlgorithm() {
        return "RSA";
    }

    public String getFormat() {
        return "X.509";
    }

    public BigInteger getModulus() {
        return this.f22975a;
    }

    public BigInteger getPublicExponent() {
        return this.f22976b;
    }

    public byte[] getEncoded() {
        return KeyUtil.m28018a(new AlgorithmIdentifier(PKCSObjectIdentifiers.h_, DERNull.f32850a), new org.spongycastle.asn1.pkcs.RSAPublicKey(getModulus(), getPublicExponent()));
    }

    public int hashCode() {
        return getModulus().hashCode() ^ getPublicExponent().hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RSAPublicKey)) {
            return false;
        }
        RSAPublicKey rSAPublicKey = (RSAPublicKey) obj;
        if (!getModulus().equals(rSAPublicKey.getModulus()) || getPublicExponent().equals(rSAPublicKey.getPublicExponent()) == null) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String a = Strings.m29418a();
        stringBuffer.append("RSA Public Key");
        stringBuffer.append(a);
        stringBuffer.append("            modulus: ");
        stringBuffer.append(getModulus().toString(16));
        stringBuffer.append(a);
        stringBuffer.append("    public exponent: ");
        stringBuffer.append(getPublicExponent().toString(16));
        stringBuffer.append(a);
        return stringBuffer.toString();
    }
}
