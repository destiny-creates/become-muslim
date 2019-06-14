package org.spongycastle.jcajce.provider.asymmetric.elgamal;

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
import org.spongycastle.asn1.oiw.ElGamalParameter;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.ElGamalPrivateKey;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.spec.ElGamalParameterSpec;
import org.spongycastle.jce.spec.ElGamalPrivateKeySpec;

public class BCElGamalPrivateKey implements DHPrivateKey, ElGamalPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 4819350091141529678L;
    /* renamed from: a */
    private BigInteger f31910a;
    /* renamed from: b */
    private transient ElGamalParameterSpec f31911b;
    /* renamed from: c */
    private transient PKCS12BagAttributeCarrierImpl f31912c = new PKCS12BagAttributeCarrierImpl();

    public String getAlgorithm() {
        return "ElGamal";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    protected BCElGamalPrivateKey() {
    }

    BCElGamalPrivateKey(ElGamalPrivateKey elGamalPrivateKey) {
        this.f31910a = elGamalPrivateKey.getX();
        this.f31911b = elGamalPrivateKey.mo6506b();
    }

    BCElGamalPrivateKey(DHPrivateKey dHPrivateKey) {
        this.f31910a = dHPrivateKey.getX();
        this.f31911b = new ElGamalParameterSpec(dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG());
    }

    BCElGamalPrivateKey(ElGamalPrivateKeySpec elGamalPrivateKeySpec) {
        this.f31910a = elGamalPrivateKeySpec.m36253b();
        this.f31911b = new ElGamalParameterSpec(elGamalPrivateKeySpec.m28320a().m28321a(), elGamalPrivateKeySpec.m28320a().m28322b());
    }

    BCElGamalPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        this.f31910a = dHPrivateKeySpec.getX();
        this.f31911b = new ElGamalParameterSpec(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
    }

    BCElGamalPrivateKey(PrivateKeyInfo privateKeyInfo) {
        ElGamalParameter a = ElGamalParameter.m40046a(privateKeyInfo.m40112a().m40231b());
        this.f31910a = ASN1Integer.m42963a(privateKeyInfo.m40114c()).m42968b();
        this.f31911b = new ElGamalParameterSpec(a.m40047a(), a.m40048b());
    }

    BCElGamalPrivateKey(ElGamalPrivateKeyParameters elGamalPrivateKeyParameters) {
        this.f31910a = elGamalPrivateKeyParameters.m43371c();
        this.f31911b = new ElGamalParameterSpec(elGamalPrivateKeyParameters.m40793b().m35655a(), elGamalPrivateKeyParameters.m40793b().m35656b());
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo;	 Catch:{ IOException -> 0x002d }
        r1 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x002d }
        r2 = org.spongycastle.asn1.oiw.OIWObjectIdentifiers.f21833l;	 Catch:{ IOException -> 0x002d }
        r3 = new org.spongycastle.asn1.oiw.ElGamalParameter;	 Catch:{ IOException -> 0x002d }
        r4 = r6.f31911b;	 Catch:{ IOException -> 0x002d }
        r4 = r4.m28321a();	 Catch:{ IOException -> 0x002d }
        r5 = r6.f31911b;	 Catch:{ IOException -> 0x002d }
        r5 = r5.m28322b();	 Catch:{ IOException -> 0x002d }
        r3.<init>(r4, r5);	 Catch:{ IOException -> 0x002d }
        r1.<init>(r2, r3);	 Catch:{ IOException -> 0x002d }
        r2 = new org.spongycastle.asn1.ASN1Integer;	 Catch:{ IOException -> 0x002d }
        r3 = r6.getX();	 Catch:{ IOException -> 0x002d }
        r2.<init>(r3);	 Catch:{ IOException -> 0x002d }
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x002d }
        r1 = "DER";	 Catch:{ IOException -> 0x002d }
        r0 = r0.m34596a(r1);	 Catch:{ IOException -> 0x002d }
        return r0;
    L_0x002d:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.elgamal.BCElGamalPrivateKey.getEncoded():byte[]");
    }

    /* renamed from: b */
    public ElGamalParameterSpec mo6506b() {
        return this.f31911b;
    }

    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.f31911b.m28321a(), this.f31911b.m28322b());
    }

    public BigInteger getX() {
        return this.f31910a;
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

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f31911b = new ElGamalParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        this.f31912c = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f31911b.m28321a());
        objectOutputStream.writeObject(this.f31911b.m28322b());
    }

    /* renamed from: a */
    public void mo5851a(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f31912c.mo5851a(aSN1ObjectIdentifier, aSN1Encodable);
    }

    /* renamed from: a */
    public ASN1Encodable mo5850a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f31912c.mo5850a(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public Enumeration mo5849a() {
        return this.f31912c.mo5849a();
    }
}
