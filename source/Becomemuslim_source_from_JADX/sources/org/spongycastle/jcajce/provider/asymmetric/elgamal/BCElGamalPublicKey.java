package org.spongycastle.jcajce.provider.asymmetric.elgamal;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;
import org.spongycastle.jce.interfaces.ElGamalPublicKey;
import org.spongycastle.jce.spec.ElGamalParameterSpec;
import org.spongycastle.jce.spec.ElGamalPublicKeySpec;

public class BCElGamalPublicKey implements DHPublicKey, ElGamalPublicKey {
    static final long serialVersionUID = 8712728417091216948L;
    /* renamed from: a */
    private BigInteger f31913a;
    /* renamed from: b */
    private transient ElGamalParameterSpec f31914b;

    public String getAlgorithm() {
        return "ElGamal";
    }

    public String getFormat() {
        return "X.509";
    }

    BCElGamalPublicKey(ElGamalPublicKeySpec elGamalPublicKeySpec) {
        this.f31913a = elGamalPublicKeySpec.m36254b();
        this.f31914b = new ElGamalParameterSpec(elGamalPublicKeySpec.m28320a().m28321a(), elGamalPublicKeySpec.m28320a().m28322b());
    }

    BCElGamalPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.f31913a = dHPublicKeySpec.getY();
        this.f31914b = new ElGamalParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    BCElGamalPublicKey(ElGamalPublicKey elGamalPublicKey) {
        this.f31913a = elGamalPublicKey.getY();
        this.f31914b = elGamalPublicKey.mo6506b();
    }

    BCElGamalPublicKey(DHPublicKey dHPublicKey) {
        this.f31913a = dHPublicKey.getY();
        this.f31914b = new ElGamalParameterSpec(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
    }

    BCElGamalPublicKey(ElGamalPublicKeyParameters elGamalPublicKeyParameters) {
        this.f31913a = elGamalPublicKeyParameters.m43372c();
        this.f31914b = new ElGamalParameterSpec(elGamalPublicKeyParameters.m40793b().m35655a(), elGamalPublicKeyParameters.m40793b().m35656b());
    }

    BCElGamalPublicKey(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r2.<init>();
        r0 = r3.m40410a();
        r0 = r0.m40231b();
        r0 = org.spongycastle.asn1.oiw.ElGamalParameter.m40046a(r0);
        r3 = r3.m40412c();	 Catch:{ IOException -> 0x002b }
        r3 = (org.spongycastle.asn1.ASN1Integer) r3;	 Catch:{ IOException -> 0x002b }
        r3 = r3.m42968b();
        r2.f31913a = r3;
        r3 = new org.spongycastle.jce.spec.ElGamalParameterSpec;
        r1 = r0.m40047a();
        r0 = r0.m40048b();
        r3.<init>(r1, r0);
        r2.f31914b = r3;
        return;
    L_0x002b:
        r3 = new java.lang.IllegalArgumentException;
        r0 = "invalid info structure in DSA public key";
        r3.<init>(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.elgamal.BCElGamalPublicKey.<init>(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = new org.spongycastle.asn1.x509.SubjectPublicKeyInfo;	 Catch:{ IOException -> 0x002b }
        r1 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x002b }
        r2 = org.spongycastle.asn1.oiw.OIWObjectIdentifiers.f21833l;	 Catch:{ IOException -> 0x002b }
        r3 = new org.spongycastle.asn1.oiw.ElGamalParameter;	 Catch:{ IOException -> 0x002b }
        r4 = r6.f31914b;	 Catch:{ IOException -> 0x002b }
        r4 = r4.m28321a();	 Catch:{ IOException -> 0x002b }
        r5 = r6.f31914b;	 Catch:{ IOException -> 0x002b }
        r5 = r5.m28322b();	 Catch:{ IOException -> 0x002b }
        r3.<init>(r4, r5);	 Catch:{ IOException -> 0x002b }
        r1.<init>(r2, r3);	 Catch:{ IOException -> 0x002b }
        r2 = new org.spongycastle.asn1.ASN1Integer;	 Catch:{ IOException -> 0x002b }
        r3 = r6.f31913a;	 Catch:{ IOException -> 0x002b }
        r2.<init>(r3);	 Catch:{ IOException -> 0x002b }
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x002b }
        r1 = "DER";	 Catch:{ IOException -> 0x002b }
        r0 = r0.m34596a(r1);	 Catch:{ IOException -> 0x002b }
        return r0;
    L_0x002b:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.elgamal.BCElGamalPublicKey.getEncoded():byte[]");
    }

    /* renamed from: b */
    public ElGamalParameterSpec mo6506b() {
        return this.f31914b;
    }

    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.f31914b.m28321a(), this.f31914b.m28322b());
    }

    public BigInteger getY() {
        return this.f31913a;
    }

    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof DHPublicKey)) {
            return false;
        }
        DHPublicKey dHPublicKey = (DHPublicKey) obj;
        if (getY().equals(dHPublicKey.getY()) && getParams().getG().equals(dHPublicKey.getParams().getG()) && getParams().getP().equals(dHPublicKey.getParams().getP()) && getParams().getL() == dHPublicKey.getParams().getL()) {
            z = true;
        }
        return z;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f31914b = new ElGamalParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f31914b.m28321a());
        objectOutputStream.writeObject(this.f31914b.m28322b());
    }
}
