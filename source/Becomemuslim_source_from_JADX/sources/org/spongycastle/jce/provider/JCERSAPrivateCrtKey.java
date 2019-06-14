package org.spongycastle.jce.provider;

import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSAPrivateKey;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.util.Strings;

public class JCERSAPrivateCrtKey extends JCERSAPrivateKey implements RSAPrivateCrtKey {
    static final long serialVersionUID = 7834723820638524718L;
    /* renamed from: c */
    private BigInteger f32012c;
    /* renamed from: d */
    private BigInteger f32013d;
    /* renamed from: e */
    private BigInteger f32014e;
    /* renamed from: f */
    private BigInteger f32015f;
    /* renamed from: g */
    private BigInteger f32016g;
    /* renamed from: h */
    private BigInteger f32017h;

    public String getFormat() {
        return "PKCS#8";
    }

    public byte[] getEncoded() {
        return KeyUtil.m28020b(new AlgorithmIdentifier(PKCSObjectIdentifiers.h_, DERNull.f32850a), new RSAPrivateKey(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient()));
    }

    public BigInteger getPublicExponent() {
        return this.f32012c;
    }

    public BigInteger getPrimeP() {
        return this.f32013d;
    }

    public BigInteger getPrimeQ() {
        return this.f32014e;
    }

    public BigInteger getPrimeExponentP() {
        return this.f32015f;
    }

    public BigInteger getPrimeExponentQ() {
        return this.f32016g;
    }

    public BigInteger getCrtCoefficient() {
        return this.f32017h;
    }

    public int hashCode() {
        return (getModulus().hashCode() ^ getPublicExponent().hashCode()) ^ getPrivateExponent().hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RSAPrivateCrtKey)) {
            return false;
        }
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) obj;
        if (!getModulus().equals(rSAPrivateCrtKey.getModulus()) || !getPublicExponent().equals(rSAPrivateCrtKey.getPublicExponent()) || !getPrivateExponent().equals(rSAPrivateCrtKey.getPrivateExponent()) || !getPrimeP().equals(rSAPrivateCrtKey.getPrimeP()) || !getPrimeQ().equals(rSAPrivateCrtKey.getPrimeQ()) || !getPrimeExponentP().equals(rSAPrivateCrtKey.getPrimeExponentP()) || !getPrimeExponentQ().equals(rSAPrivateCrtKey.getPrimeExponentQ()) || getCrtCoefficient().equals(rSAPrivateCrtKey.getCrtCoefficient()) == null) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String a = Strings.m29418a();
        stringBuffer.append("RSA Private CRT Key");
        stringBuffer.append(a);
        stringBuffer.append("            modulus: ");
        stringBuffer.append(getModulus().toString(16));
        stringBuffer.append(a);
        stringBuffer.append("    public exponent: ");
        stringBuffer.append(getPublicExponent().toString(16));
        stringBuffer.append(a);
        stringBuffer.append("   private exponent: ");
        stringBuffer.append(getPrivateExponent().toString(16));
        stringBuffer.append(a);
        stringBuffer.append("             primeP: ");
        stringBuffer.append(getPrimeP().toString(16));
        stringBuffer.append(a);
        stringBuffer.append("             primeQ: ");
        stringBuffer.append(getPrimeQ().toString(16));
        stringBuffer.append(a);
        stringBuffer.append("     primeExponentP: ");
        stringBuffer.append(getPrimeExponentP().toString(16));
        stringBuffer.append(a);
        stringBuffer.append("     primeExponentQ: ");
        stringBuffer.append(getPrimeExponentQ().toString(16));
        stringBuffer.append(a);
        stringBuffer.append("     crtCoefficient: ");
        stringBuffer.append(getCrtCoefficient().toString(16));
        stringBuffer.append(a);
        return stringBuffer.toString();
    }
}
