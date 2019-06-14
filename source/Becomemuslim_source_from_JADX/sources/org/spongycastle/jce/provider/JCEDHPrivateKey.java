package org.spongycastle.jce.provider;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class JCEDHPrivateKey implements DHPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 311058815616901812L;
    /* renamed from: a */
    BigInteger f27580a;
    /* renamed from: b */
    private DHParameterSpec f27581b;
    /* renamed from: c */
    private PrivateKeyInfo f27582c;
    /* renamed from: d */
    private PKCS12BagAttributeCarrier f27583d = new PKCS12BagAttributeCarrierImpl();

    public String getAlgorithm() {
        return "DH";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    protected JCEDHPrivateKey() {
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.f27582c;	 Catch:{ IOException -> 0x0040 }
        if (r0 == 0) goto L_0x000d;	 Catch:{ IOException -> 0x0040 }
    L_0x0004:
        r0 = r7.f27582c;	 Catch:{ IOException -> 0x0040 }
        r1 = "DER";	 Catch:{ IOException -> 0x0040 }
        r0 = r0.m34596a(r1);	 Catch:{ IOException -> 0x0040 }
        return r0;	 Catch:{ IOException -> 0x0040 }
    L_0x000d:
        r0 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo;	 Catch:{ IOException -> 0x0040 }
        r1 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x0040 }
        r2 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.f21865q;	 Catch:{ IOException -> 0x0040 }
        r3 = new org.spongycastle.asn1.pkcs.DHParameter;	 Catch:{ IOException -> 0x0040 }
        r4 = r7.f27581b;	 Catch:{ IOException -> 0x0040 }
        r4 = r4.getP();	 Catch:{ IOException -> 0x0040 }
        r5 = r7.f27581b;	 Catch:{ IOException -> 0x0040 }
        r5 = r5.getG();	 Catch:{ IOException -> 0x0040 }
        r6 = r7.f27581b;	 Catch:{ IOException -> 0x0040 }
        r6 = r6.getL();	 Catch:{ IOException -> 0x0040 }
        r3.<init>(r4, r5, r6);	 Catch:{ IOException -> 0x0040 }
        r1.<init>(r2, r3);	 Catch:{ IOException -> 0x0040 }
        r2 = new org.spongycastle.asn1.ASN1Integer;	 Catch:{ IOException -> 0x0040 }
        r3 = r7.getX();	 Catch:{ IOException -> 0x0040 }
        r2.<init>(r3);	 Catch:{ IOException -> 0x0040 }
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x0040 }
        r1 = "DER";	 Catch:{ IOException -> 0x0040 }
        r0 = r0.m34596a(r1);	 Catch:{ IOException -> 0x0040 }
        return r0;
    L_0x0040:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.JCEDHPrivateKey.getEncoded():byte[]");
    }

    public DHParameterSpec getParams() {
        return this.f27581b;
    }

    public BigInteger getX() {
        return this.f27580a;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f27580a = (BigInteger) objectInputStream.readObject();
        this.f27581b = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(getX());
        objectOutputStream.writeObject(this.f27581b.getP());
        objectOutputStream.writeObject(this.f27581b.getG());
        objectOutputStream.writeInt(this.f27581b.getL());
    }

    /* renamed from: a */
    public void mo5851a(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f27583d.mo5851a(aSN1ObjectIdentifier, aSN1Encodable);
    }

    /* renamed from: a */
    public ASN1Encodable mo5850a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f27583d.mo5850a(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public Enumeration mo5849a() {
        return this.f27583d.mo5849a();
    }
}
