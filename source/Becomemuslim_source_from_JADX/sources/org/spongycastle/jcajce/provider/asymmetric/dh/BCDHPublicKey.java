package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.pkcs.DHParameter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;

public class BCDHPublicKey implements DHPublicKey {
    static final long serialVersionUID = -216691575254424324L;
    /* renamed from: a */
    private BigInteger f22710a;
    /* renamed from: b */
    private transient DHParameterSpec f22711b;
    /* renamed from: c */
    private transient SubjectPublicKeyInfo f22712c;

    public String getAlgorithm() {
        return "DH";
    }

    public String getFormat() {
        return "X.509";
    }

    BCDHPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.f22710a = dHPublicKeySpec.getY();
        this.f22711b = new DHParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    BCDHPublicKey(DHPublicKey dHPublicKey) {
        this.f22710a = dHPublicKey.getY();
        this.f22711b = dHPublicKey.getParams();
    }

    BCDHPublicKey(DHPublicKeyParameters dHPublicKeyParameters) {
        this.f22710a = dHPublicKeyParameters.m43366c();
        this.f22711b = new DHParameterSpec(dHPublicKeyParameters.m40790b().m35638a(), dHPublicKeyParameters.m40790b().m35639b(), dHPublicKeyParameters.m40790b().m35642e());
    }

    BCDHPublicKey(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        this.f22710a = bigInteger;
        this.f22711b = dHParameterSpec;
    }

    public BCDHPublicKey(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.<init>();
        r3.f22712c = r4;
        r0 = r4.m40412c();	 Catch:{ IOException -> 0x0099 }
        r0 = (org.spongycastle.asn1.ASN1Integer) r0;	 Catch:{ IOException -> 0x0099 }
        r0 = r0.m42968b();
        r3.f22710a = r0;
        r0 = r4.m40410a();
        r0 = r0.m40231b();
        r0 = org.spongycastle.asn1.ASN1Sequence.m43000a(r0);
        r4 = r4.m40410a();
        r4 = r4.m40230a();
        r1 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.f21865q;
        r1 = r4.equals(r1);
        if (r1 != 0) goto L_0x0067;
    L_0x002d:
        r1 = r3.m27960a(r0);
        if (r1 == 0) goto L_0x0034;
    L_0x0033:
        goto L_0x0067;
    L_0x0034:
        r1 = org.spongycastle.asn1.x9.X9ObjectIdentifiers.ab;
        r1 = r4.equals(r1);
        if (r1 == 0) goto L_0x0050;
    L_0x003c:
        r4 = org.spongycastle.asn1.x9.DomainParameters.m40493a(r0);
        r0 = new javax.crypto.spec.DHParameterSpec;
        r1 = r4.m40494a();
        r4 = r4.m40495b();
        r0.<init>(r1, r4);
        r3.f22711b = r0;
        goto L_0x0098;
    L_0x0050:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "unknown algorithm type: ";
        r1.append(r2);
        r1.append(r4);
        r4 = r1.toString();
        r0.<init>(r4);
        throw r0;
    L_0x0067:
        r4 = org.spongycastle.asn1.pkcs.DHParameter.m40065a(r0);
        r0 = r4.m40068c();
        if (r0 == 0) goto L_0x0089;
    L_0x0071:
        r0 = new javax.crypto.spec.DHParameterSpec;
        r1 = r4.m40066a();
        r2 = r4.m40067b();
        r4 = r4.m40068c();
        r4 = r4.intValue();
        r0.<init>(r1, r2, r4);
        r3.f22711b = r0;
        goto L_0x0098;
    L_0x0089:
        r0 = new javax.crypto.spec.DHParameterSpec;
        r1 = r4.m40066a();
        r4 = r4.m40067b();
        r0.<init>(r1, r4);
        r3.f22711b = r0;
    L_0x0098:
        return;
    L_0x0099:
        r4 = new java.lang.IllegalArgumentException;
        r0 = "invalid info structure in DH public key";
        r4.<init>(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dh.BCDHPublicKey.<init>(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    public byte[] getEncoded() {
        if (this.f22712c != null) {
            return KeyUtil.m28019a(this.f22712c);
        }
        return KeyUtil.m28018a(new AlgorithmIdentifier(PKCSObjectIdentifiers.f21865q, new DHParameter(this.f22711b.getP(), this.f22711b.getG(), this.f22711b.getL()).mo5709e()), new ASN1Integer(this.f22710a));
    }

    public DHParameterSpec getParams() {
        return this.f22711b;
    }

    public BigInteger getY() {
        return this.f22710a;
    }

    /* renamed from: a */
    private boolean m27960a(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() == 2) {
            return true;
        }
        if (aSN1Sequence.mo6862g() > 3) {
            return false;
        }
        if (ASN1Integer.m42963a(aSN1Sequence.mo6860a(2)).m42968b().compareTo(BigInteger.valueOf((long) ASN1Integer.m42963a(aSN1Sequence.mo6860a(0)).m42968b().bitLength())) > null) {
            return false;
        }
        return true;
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
        this.f22711b = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
        this.f22712c = null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f22711b.getP());
        objectOutputStream.writeObject(this.f22711b.getG());
        objectOutputStream.writeInt(this.f22711b.getL());
    }
}
