package org.spongycastle.jce.provider;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAParameterSpec;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class JDKDSAPrivateKey implements DSAPrivateKey, PKCS12BagAttributeCarrier {
    private static final long serialVersionUID = -4677259546958385734L;
    /* renamed from: a */
    BigInteger f27588a;
    /* renamed from: b */
    DSAParams f27589b;
    /* renamed from: c */
    private PKCS12BagAttributeCarrierImpl f27590c = new PKCS12BagAttributeCarrierImpl();

    public String getAlgorithm() {
        return "DSA";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    protected JDKDSAPrivateKey() {
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo;	 Catch:{ IOException -> 0x0033 }
        r1 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x0033 }
        r2 = org.spongycastle.asn1.x9.X9ObjectIdentifiers.f22154U;	 Catch:{ IOException -> 0x0033 }
        r3 = new org.spongycastle.asn1.x509.DSAParameter;	 Catch:{ IOException -> 0x0033 }
        r4 = r7.f27589b;	 Catch:{ IOException -> 0x0033 }
        r4 = r4.getP();	 Catch:{ IOException -> 0x0033 }
        r5 = r7.f27589b;	 Catch:{ IOException -> 0x0033 }
        r5 = r5.getQ();	 Catch:{ IOException -> 0x0033 }
        r6 = r7.f27589b;	 Catch:{ IOException -> 0x0033 }
        r6 = r6.getG();	 Catch:{ IOException -> 0x0033 }
        r3.<init>(r4, r5, r6);	 Catch:{ IOException -> 0x0033 }
        r1.<init>(r2, r3);	 Catch:{ IOException -> 0x0033 }
        r2 = new org.spongycastle.asn1.ASN1Integer;	 Catch:{ IOException -> 0x0033 }
        r3 = r7.getX();	 Catch:{ IOException -> 0x0033 }
        r2.<init>(r3);	 Catch:{ IOException -> 0x0033 }
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x0033 }
        r1 = "DER";	 Catch:{ IOException -> 0x0033 }
        r0 = r0.m34596a(r1);	 Catch:{ IOException -> 0x0033 }
        return r0;
    L_0x0033:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.JDKDSAPrivateKey.getEncoded():byte[]");
    }

    public DSAParams getParams() {
        return this.f27589b;
    }

    public BigInteger getX() {
        return this.f27588a;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof DSAPrivateKey)) {
            return false;
        }
        DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) obj;
        if (getX().equals(dSAPrivateKey.getX()) && getParams().getG().equals(dSAPrivateKey.getParams().getG()) && getParams().getP().equals(dSAPrivateKey.getParams().getP()) && getParams().getQ().equals(dSAPrivateKey.getParams().getQ()) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
    }

    /* renamed from: a */
    public void mo5851a(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f27590c.mo5851a(aSN1ObjectIdentifier, aSN1Encodable);
    }

    /* renamed from: a */
    public ASN1Encodable mo5850a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f27590c.mo5850a(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public Enumeration mo5849a() {
        return this.f27590c.mo5849a();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f27588a = (BigInteger) objectInputStream.readObject();
        this.f27589b = new DSAParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        this.f27590c = new PKCS12BagAttributeCarrierImpl();
        this.f27590c.m36021a(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(this.f27588a);
        objectOutputStream.writeObject(this.f27589b.getP());
        objectOutputStream.writeObject(this.f27589b.getQ());
        objectOutputStream.writeObject(this.f27589b.getG());
        this.f27590c.m36022a(objectOutputStream);
    }
}
