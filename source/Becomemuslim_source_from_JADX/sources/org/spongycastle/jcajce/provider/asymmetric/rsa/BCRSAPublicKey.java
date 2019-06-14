package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.util.Strings;

public class BCRSAPublicKey implements RSAPublicKey {
    /* renamed from: a */
    private static final AlgorithmIdentifier f22788a = new AlgorithmIdentifier(PKCSObjectIdentifiers.h_, DERNull.f32850a);
    static final long serialVersionUID = 2675817738516720772L;
    /* renamed from: b */
    private BigInteger f22789b;
    /* renamed from: c */
    private BigInteger f22790c;
    /* renamed from: d */
    private transient AlgorithmIdentifier f22791d;

    public String getAlgorithm() {
        return "RSA";
    }

    public String getFormat() {
        return "X.509";
    }

    BCRSAPublicKey(RSAKeyParameters rSAKeyParameters) {
        this.f22791d = f22788a;
        this.f22789b = rSAKeyParameters.m40800b();
        this.f22790c = rSAKeyParameters.m40801c();
    }

    BCRSAPublicKey(RSAPublicKeySpec rSAPublicKeySpec) {
        this.f22791d = f22788a;
        this.f22789b = rSAPublicKeySpec.getModulus();
        this.f22790c = rSAPublicKeySpec.getPublicExponent();
    }

    BCRSAPublicKey(RSAPublicKey rSAPublicKey) {
        this.f22791d = f22788a;
        this.f22789b = rSAPublicKey.getModulus();
        this.f22790c = rSAPublicKey.getPublicExponent();
    }

    BCRSAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m27979a(subjectPublicKeyInfo);
    }

    /* renamed from: a */
    private void m27979a(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r2.m40412c();	 Catch:{ IOException -> 0x001b }
        r0 = org.spongycastle.asn1.pkcs.RSAPublicKey.m40144a(r0);	 Catch:{ IOException -> 0x001b }
        r2 = r2.m40410a();	 Catch:{ IOException -> 0x001b }
        r1.f22791d = r2;	 Catch:{ IOException -> 0x001b }
        r2 = r0.m40145a();	 Catch:{ IOException -> 0x001b }
        r1.f22789b = r2;	 Catch:{ IOException -> 0x001b }
        r2 = r0.m40146b();	 Catch:{ IOException -> 0x001b }
        r1.f22790c = r2;	 Catch:{ IOException -> 0x001b }
        return;
    L_0x001b:
        r2 = new java.lang.IllegalArgumentException;
        r0 = "invalid info structure in RSA public key";
        r2.<init>(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.rsa.BCRSAPublicKey.a(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    public BigInteger getModulus() {
        return this.f22789b;
    }

    public BigInteger getPublicExponent() {
        return this.f22790c;
    }

    public byte[] getEncoded() {
        return KeyUtil.m28018a(this.f22791d, new org.spongycastle.asn1.pkcs.RSAPublicKey(getModulus(), getPublicExponent()));
    }

    public int hashCode() {
        return getModulus().hashCode() ^ getPublicExponent().hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RSAPublicKey)) {
            return false;
        }
        RSAPublicKey rSAPublicKey = (RSAPublicKey) obj;
        if (!getModulus().equals(rSAPublicKey.getModulus()) || getPublicExponent().equals(rSAPublicKey.getPublicExponent()) == null) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String a = Strings.m29418a();
        stringBuffer.append("RSA Public Key");
        stringBuffer.append(a);
        stringBuffer.append("            modulus: ");
        stringBuffer.append(getModulus().toString(16));
        stringBuffer.append(a);
        stringBuffer.append("    public exponent: ");
        stringBuffer.append(getPublicExponent().toString(16));
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    private void readObject(java.io.ObjectInputStream r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r1.defaultReadObject();
        r1 = r1.readObject();	 Catch:{ Exception -> 0x000e }
        r1 = org.spongycastle.asn1.x509.AlgorithmIdentifier.m40228a(r1);	 Catch:{ Exception -> 0x000e }
        r0.f22791d = r1;	 Catch:{ Exception -> 0x000e }
        goto L_0x0012;
    L_0x000e:
        r1 = f22788a;
        r0.f22791d = r1;
    L_0x0012:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.rsa.BCRSAPublicKey.readObject(java.io.ObjectInputStream):void");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        if (!this.f22791d.equals(f22788a)) {
            objectOutputStream.writeObject(this.f22791d.mo6822f());
        }
    }
}
