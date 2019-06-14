package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class BCRSAPrivateKey implements RSAPrivateKey, PKCS12BagAttributeCarrier {
    /* renamed from: c */
    private static BigInteger f27422c = BigInteger.valueOf(0);
    static final long serialVersionUID = 5110188922551353628L;
    /* renamed from: a */
    protected BigInteger f27423a;
    /* renamed from: b */
    protected BigInteger f27424b;
    /* renamed from: d */
    private transient PKCS12BagAttributeCarrierImpl f27425d = new PKCS12BagAttributeCarrierImpl();

    public String getAlgorithm() {
        return "RSA";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    protected BCRSAPrivateKey() {
    }

    BCRSAPrivateKey(RSAKeyParameters rSAKeyParameters) {
        this.f27423a = rSAKeyParameters.m40800b();
        this.f27424b = rSAKeyParameters.m40801c();
    }

    BCRSAPrivateKey(RSAPrivateKeySpec rSAPrivateKeySpec) {
        this.f27423a = rSAPrivateKeySpec.getModulus();
        this.f27424b = rSAPrivateKeySpec.getPrivateExponent();
    }

    BCRSAPrivateKey(RSAPrivateKey rSAPrivateKey) {
        this.f27423a = rSAPrivateKey.getModulus();
        this.f27424b = rSAPrivateKey.getPrivateExponent();
    }

    BCRSAPrivateKey(org.spongycastle.asn1.pkcs.RSAPrivateKey rSAPrivateKey) {
        this.f27423a = rSAPrivateKey.m40126a();
        this.f27424b = rSAPrivateKey.m40128c();
    }

    public BigInteger getModulus() {
        return this.f27423a;
    }

    public BigInteger getPrivateExponent() {
        return this.f27424b;
    }

    public byte[] getEncoded() {
        return KeyUtil.m28020b(new AlgorithmIdentifier(PKCSObjectIdentifiers.h_, DERNull.f32850a), new org.spongycastle.asn1.pkcs.RSAPrivateKey(getModulus(), f27422c, getPrivateExponent(), f27422c, f27422c, f27422c, f27422c, f27422c));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RSAPrivateKey)) {
            return false;
        }
        boolean z = true;
        if (obj == this) {
            return true;
        }
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) obj;
        if (!getModulus().equals(rSAPrivateKey.getModulus()) || getPrivateExponent().equals(rSAPrivateKey.getPrivateExponent()) == null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return getModulus().hashCode() ^ getPrivateExponent().hashCode();
    }

    /* renamed from: a */
    public void mo5851a(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f27425d.mo5851a(aSN1ObjectIdentifier, aSN1Encodable);
    }

    /* renamed from: a */
    public ASN1Encodable mo5850a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f27425d.mo5850a(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public Enumeration mo5849a() {
        return this.f27425d.mo5849a();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f27425d = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }
}
