package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.pkcs.RSAPrivateKey;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.util.Strings;

public class BCRSAPrivateCrtKey extends BCRSAPrivateKey implements RSAPrivateCrtKey {
    static final long serialVersionUID = 7834723820638524718L;
    /* renamed from: c */
    private BigInteger f31920c;
    /* renamed from: d */
    private BigInteger f31921d;
    /* renamed from: e */
    private BigInteger f31922e;
    /* renamed from: f */
    private BigInteger f31923f;
    /* renamed from: g */
    private BigInteger f31924g;
    /* renamed from: h */
    private BigInteger f31925h;

    public String getFormat() {
        return "PKCS#8";
    }

    BCRSAPrivateCrtKey(RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters) {
        super((RSAKeyParameters) rSAPrivateCrtKeyParameters);
        this.f31920c = rSAPrivateCrtKeyParameters.m43377d();
        this.f31921d = rSAPrivateCrtKeyParameters.m43378e();
        this.f31922e = rSAPrivateCrtKeyParameters.m43379f();
        this.f31923f = rSAPrivateCrtKeyParameters.m43380g();
        this.f31924g = rSAPrivateCrtKeyParameters.m43381h();
        this.f31925h = rSAPrivateCrtKeyParameters.m43382i();
    }

    BCRSAPrivateCrtKey(RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec) {
        this.a = rSAPrivateCrtKeySpec.getModulus();
        this.f31920c = rSAPrivateCrtKeySpec.getPublicExponent();
        this.b = rSAPrivateCrtKeySpec.getPrivateExponent();
        this.f31921d = rSAPrivateCrtKeySpec.getPrimeP();
        this.f31922e = rSAPrivateCrtKeySpec.getPrimeQ();
        this.f31923f = rSAPrivateCrtKeySpec.getPrimeExponentP();
        this.f31924g = rSAPrivateCrtKeySpec.getPrimeExponentQ();
        this.f31925h = rSAPrivateCrtKeySpec.getCrtCoefficient();
    }

    BCRSAPrivateCrtKey(RSAPrivateCrtKey rSAPrivateCrtKey) {
        this.a = rSAPrivateCrtKey.getModulus();
        this.f31920c = rSAPrivateCrtKey.getPublicExponent();
        this.b = rSAPrivateCrtKey.getPrivateExponent();
        this.f31921d = rSAPrivateCrtKey.getPrimeP();
        this.f31922e = rSAPrivateCrtKey.getPrimeQ();
        this.f31923f = rSAPrivateCrtKey.getPrimeExponentP();
        this.f31924g = rSAPrivateCrtKey.getPrimeExponentQ();
        this.f31925h = rSAPrivateCrtKey.getCrtCoefficient();
    }

    BCRSAPrivateCrtKey(PrivateKeyInfo privateKeyInfo) {
        this(RSAPrivateKey.m40125a(privateKeyInfo.m40114c()));
    }

    BCRSAPrivateCrtKey(RSAPrivateKey rSAPrivateKey) {
        this.a = rSAPrivateKey.m40126a();
        this.f31920c = rSAPrivateKey.m40127b();
        this.b = rSAPrivateKey.m40128c();
        this.f31921d = rSAPrivateKey.m40129d();
        this.f31922e = rSAPrivateKey.m40131g();
        this.f31923f = rSAPrivateKey.m40132h();
        this.f31924g = rSAPrivateKey.m40133i();
        this.f31925h = rSAPrivateKey.m40134j();
    }

    public byte[] getEncoded() {
        return KeyUtil.m28020b(new AlgorithmIdentifier(PKCSObjectIdentifiers.h_, DERNull.f32850a), new RSAPrivateKey(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient()));
    }

    public BigInteger getPublicExponent() {
        return this.f31920c;
    }

    public BigInteger getPrimeP() {
        return this.f31921d;
    }

    public BigInteger getPrimeQ() {
        return this.f31922e;
    }

    public BigInteger getPrimeExponentP() {
        return this.f31923f;
    }

    public BigInteger getPrimeExponentQ() {
        return this.f31924g;
    }

    public BigInteger getCrtCoefficient() {
        return this.f31925h;
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
