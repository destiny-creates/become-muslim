package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.pkcs.DHParameter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x9.DomainParameters;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class BCDHPrivateKey implements DHPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 311058815616901812L;
    /* renamed from: a */
    private BigInteger f27375a;
    /* renamed from: b */
    private transient DHParameterSpec f27376b;
    /* renamed from: c */
    private transient PrivateKeyInfo f27377c;
    /* renamed from: d */
    private transient PKCS12BagAttributeCarrierImpl f27378d = new PKCS12BagAttributeCarrierImpl();

    public String getAlgorithm() {
        return "DH";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    protected BCDHPrivateKey() {
    }

    BCDHPrivateKey(DHPrivateKey dHPrivateKey) {
        this.f27375a = dHPrivateKey.getX();
        this.f27376b = dHPrivateKey.getParams();
    }

    BCDHPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        this.f27375a = dHPrivateKeySpec.getX();
        this.f27376b = new DHParameterSpec(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
    }

    public BCDHPrivateKey(PrivateKeyInfo privateKeyInfo) {
        Object a = ASN1Sequence.m43000a(privateKeyInfo.m40112a().m40231b());
        ASN1Integer aSN1Integer = (ASN1Integer) privateKeyInfo.m40114c();
        ASN1ObjectIdentifier a2 = privateKeyInfo.m40112a().m40230a();
        this.f27377c = privateKeyInfo;
        this.f27375a = aSN1Integer.m42968b();
        if (a2.equals(PKCSObjectIdentifiers.f21865q) != null) {
            privateKeyInfo = DHParameter.m40065a(a);
            if (privateKeyInfo.m40068c() != null) {
                this.f27376b = new DHParameterSpec(privateKeyInfo.m40066a(), privateKeyInfo.m40067b(), privateKeyInfo.m40068c().intValue());
            } else {
                this.f27376b = new DHParameterSpec(privateKeyInfo.m40066a(), privateKeyInfo.m40067b());
            }
        } else if (a2.equals(X9ObjectIdentifiers.ab) != null) {
            privateKeyInfo = DomainParameters.m40493a(a);
            this.f27376b = new DHParameterSpec(privateKeyInfo.m40494a(), privateKeyInfo.m40495b());
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unknown algorithm type: ");
            stringBuilder.append(a2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    BCDHPrivateKey(DHPrivateKeyParameters dHPrivateKeyParameters) {
        this.f27375a = dHPrivateKeyParameters.m43365c();
        this.f27376b = new DHParameterSpec(dHPrivateKeyParameters.m40790b().m35638a(), dHPrivateKeyParameters.m40790b().m35639b(), dHPrivateKeyParameters.m40790b().m35642e());
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.f27377c;	 Catch:{ Exception -> 0x0044 }
        if (r0 == 0) goto L_0x000d;	 Catch:{ Exception -> 0x0044 }
    L_0x0004:
        r0 = r7.f27377c;	 Catch:{ Exception -> 0x0044 }
        r1 = "DER";	 Catch:{ Exception -> 0x0044 }
        r0 = r0.m34596a(r1);	 Catch:{ Exception -> 0x0044 }
        return r0;	 Catch:{ Exception -> 0x0044 }
    L_0x000d:
        r0 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo;	 Catch:{ Exception -> 0x0044 }
        r1 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ Exception -> 0x0044 }
        r2 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.f21865q;	 Catch:{ Exception -> 0x0044 }
        r3 = new org.spongycastle.asn1.pkcs.DHParameter;	 Catch:{ Exception -> 0x0044 }
        r4 = r7.f27376b;	 Catch:{ Exception -> 0x0044 }
        r4 = r4.getP();	 Catch:{ Exception -> 0x0044 }
        r5 = r7.f27376b;	 Catch:{ Exception -> 0x0044 }
        r5 = r5.getG();	 Catch:{ Exception -> 0x0044 }
        r6 = r7.f27376b;	 Catch:{ Exception -> 0x0044 }
        r6 = r6.getL();	 Catch:{ Exception -> 0x0044 }
        r3.<init>(r4, r5, r6);	 Catch:{ Exception -> 0x0044 }
        r3 = r3.mo5709e();	 Catch:{ Exception -> 0x0044 }
        r1.<init>(r2, r3);	 Catch:{ Exception -> 0x0044 }
        r2 = new org.spongycastle.asn1.ASN1Integer;	 Catch:{ Exception -> 0x0044 }
        r3 = r7.getX();	 Catch:{ Exception -> 0x0044 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0044 }
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x0044 }
        r1 = "DER";	 Catch:{ Exception -> 0x0044 }
        r0 = r0.m34596a(r1);	 Catch:{ Exception -> 0x0044 }
        return r0;
    L_0x0044:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dh.BCDHPrivateKey.getEncoded():byte[]");
    }

    public DHParameterSpec getParams() {
        return this.f27376b;
    }

    public BigInteger getX() {
        return this.f27375a;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof DHPrivateKey)) {
            return false;
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey) obj;
        if (getX().equals(dHPrivateKey.getX()) && getParams().getG().equals(dHPrivateKey.getParams().getG()) && getParams().getP().equals(dHPrivateKey.getParams().getP()) && getParams().getL() == dHPrivateKey.getParams().getL()) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    /* renamed from: a */
    public void mo5851a(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f27378d.mo5851a(aSN1ObjectIdentifier, aSN1Encodable);
    }

    /* renamed from: a */
    public ASN1Encodable mo5850a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f27378d.mo5850a(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public Enumeration mo5849a() {
        return this.f27378d.mo5849a();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f27376b = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
        this.f27377c = null;
        this.f27378d = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f27376b.getP());
        objectOutputStream.writeObject(this.f27376b.getG());
        objectOutputStream.writeInt(this.f27376b.getL());
    }
}
