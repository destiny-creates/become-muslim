package org.spongycastle.jce.provider;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import org.spongycastle.util.Strings;

public class JDKDSAPublicKey implements DSAPublicKey {
    private static final long serialVersionUID = 1752452449903495175L;
    /* renamed from: a */
    private BigInteger f22977a;
    /* renamed from: b */
    private DSAParams f22978b;

    public String getAlgorithm() {
        return "DSA";
    }

    public String getFormat() {
        return "X.509";
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.f22978b;	 Catch:{ IOException -> 0x004f }
        if (r0 != 0) goto L_0x001e;	 Catch:{ IOException -> 0x004f }
    L_0x0004:
        r0 = new org.spongycastle.asn1.x509.SubjectPublicKeyInfo;	 Catch:{ IOException -> 0x004f }
        r1 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x004f }
        r2 = org.spongycastle.asn1.x9.X9ObjectIdentifiers.f22154U;	 Catch:{ IOException -> 0x004f }
        r1.<init>(r2);	 Catch:{ IOException -> 0x004f }
        r2 = new org.spongycastle.asn1.ASN1Integer;	 Catch:{ IOException -> 0x004f }
        r3 = r7.f22977a;	 Catch:{ IOException -> 0x004f }
        r2.<init>(r3);	 Catch:{ IOException -> 0x004f }
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x004f }
        r1 = "DER";	 Catch:{ IOException -> 0x004f }
        r0 = r0.m34596a(r1);	 Catch:{ IOException -> 0x004f }
        return r0;	 Catch:{ IOException -> 0x004f }
    L_0x001e:
        r0 = new org.spongycastle.asn1.x509.SubjectPublicKeyInfo;	 Catch:{ IOException -> 0x004f }
        r1 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x004f }
        r2 = org.spongycastle.asn1.x9.X9ObjectIdentifiers.f22154U;	 Catch:{ IOException -> 0x004f }
        r3 = new org.spongycastle.asn1.x509.DSAParameter;	 Catch:{ IOException -> 0x004f }
        r4 = r7.f22978b;	 Catch:{ IOException -> 0x004f }
        r4 = r4.getP();	 Catch:{ IOException -> 0x004f }
        r5 = r7.f22978b;	 Catch:{ IOException -> 0x004f }
        r5 = r5.getQ();	 Catch:{ IOException -> 0x004f }
        r6 = r7.f22978b;	 Catch:{ IOException -> 0x004f }
        r6 = r6.getG();	 Catch:{ IOException -> 0x004f }
        r3.<init>(r4, r5, r6);	 Catch:{ IOException -> 0x004f }
        r1.<init>(r2, r3);	 Catch:{ IOException -> 0x004f }
        r2 = new org.spongycastle.asn1.ASN1Integer;	 Catch:{ IOException -> 0x004f }
        r3 = r7.f22977a;	 Catch:{ IOException -> 0x004f }
        r2.<init>(r3);	 Catch:{ IOException -> 0x004f }
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x004f }
        r1 = "DER";	 Catch:{ IOException -> 0x004f }
        r0 = r0.m34596a(r1);	 Catch:{ IOException -> 0x004f }
        return r0;
    L_0x004f:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.JDKDSAPublicKey.getEncoded():byte[]");
    }

    public DSAParams getParams() {
        return this.f22978b;
    }

    public BigInteger getY() {
        return this.f22977a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String a = Strings.m29418a();
        stringBuffer.append("DSA Public Key");
        stringBuffer.append(a);
        stringBuffer.append("            y: ");
        stringBuffer.append(getY().toString(16));
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof DSAPublicKey)) {
            return false;
        }
        DSAPublicKey dSAPublicKey = (DSAPublicKey) obj;
        if (getY().equals(dSAPublicKey.getY()) && getParams().getG().equals(dSAPublicKey.getParams().getG()) && getParams().getP().equals(dSAPublicKey.getParams().getP()) && getParams().getQ().equals(dSAPublicKey.getParams().getQ()) != null) {
            z = true;
        }
        return z;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f22977a = (BigInteger) objectInputStream.readObject();
        this.f22978b = new DSAParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(this.f22977a);
        objectOutputStream.writeObject(this.f22978b.getP());
        objectOutputStream.writeObject(this.f22978b.getQ());
        objectOutputStream.writeObject(this.f22978b.getG());
    }
}
