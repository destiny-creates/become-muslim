package org.spongycastle.jce.provider;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class JCERSAPrivateKey implements RSAPrivateKey, PKCS12BagAttributeCarrier {
    /* renamed from: c */
    private static BigInteger f27584c = BigInteger.valueOf(0);
    static final long serialVersionUID = 5110188922551353628L;
    /* renamed from: a */
    protected BigInteger f27585a;
    /* renamed from: b */
    protected BigInteger f27586b;
    /* renamed from: d */
    private PKCS12BagAttributeCarrierImpl f27587d = new PKCS12BagAttributeCarrierImpl();

    public String getAlgorithm() {
        return "RSA";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    protected JCERSAPrivateKey() {
    }

    public BigInteger getModulus() {
        return this.f27585a;
    }

    public BigInteger getPrivateExponent() {
        return this.f27586b;
    }

    public byte[] getEncoded() {
        return KeyUtil.m28020b(new AlgorithmIdentifier(PKCSObjectIdentifiers.h_, DERNull.f32850a), new org.spongycastle.asn1.pkcs.RSAPrivateKey(getModulus(), f27584c, getPrivateExponent(), f27584c, f27584c, f27584c, f27584c, f27584c));
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
        this.f27587d.mo5851a(aSN1ObjectIdentifier, aSN1Encodable);
    }

    /* renamed from: a */
    public ASN1Encodable mo5850a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f27587d.mo5850a(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public Enumeration mo5849a() {
        return this.f27587d.mo5849a();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f27585a = (BigInteger) objectInputStream.readObject();
        this.f27587d = new PKCS12BagAttributeCarrierImpl();
        this.f27587d.m36021a(objectInputStream);
        this.f27586b = (BigInteger) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(this.f27585a);
        this.f27587d.m36022a(objectOutputStream);
        objectOutputStream.writeObject(this.f27586b);
    }
}
