package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.util.Strings;

public class BCDSAPublicKey implements DSAPublicKey {
    private static final long serialVersionUID = 1752452449903495175L;
    /* renamed from: a */
    private BigInteger f22732a;
    /* renamed from: b */
    private transient DSAParams f22733b;

    public String getAlgorithm() {
        return "DSA";
    }

    public String getFormat() {
        return "X.509";
    }

    BCDSAPublicKey(DSAPublicKeySpec dSAPublicKeySpec) {
        this.f22732a = dSAPublicKeySpec.getY();
        this.f22733b = new DSAParameterSpec(dSAPublicKeySpec.getP(), dSAPublicKeySpec.getQ(), dSAPublicKeySpec.getG());
    }

    BCDSAPublicKey(DSAPublicKey dSAPublicKey) {
        this.f22732a = dSAPublicKey.getY();
        this.f22733b = dSAPublicKey.getParams();
    }

    BCDSAPublicKey(DSAPublicKeyParameters dSAPublicKeyParameters) {
        this.f22732a = dSAPublicKeyParameters.m43368c();
        this.f22733b = new DSAParameterSpec(dSAPublicKeyParameters.m40791b().m35644a(), dSAPublicKeyParameters.m40791b().m35645b(), dSAPublicKeyParameters.m40791b().m35646c());
    }

    public BCDSAPublicKey(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.<init>();
        r0 = r4.m40412c();	 Catch:{ IOException -> 0x003d }
        r0 = (org.spongycastle.asn1.ASN1Integer) r0;	 Catch:{ IOException -> 0x003d }
        r0 = r0.m42968b();
        r3.f22732a = r0;
        r0 = r4.m40410a();
        r0 = r0.m40231b();
        r0 = r3.m27963a(r0);
        if (r0 == 0) goto L_0x003c;
    L_0x001d:
        r4 = r4.m40410a();
        r4 = r4.m40231b();
        r4 = org.spongycastle.asn1.x509.DSAParameter.m40300a(r4);
        r0 = new java.security.spec.DSAParameterSpec;
        r1 = r4.m40301a();
        r2 = r4.m40302b();
        r4 = r4.m40303c();
        r0.<init>(r1, r2, r4);
        r3.f22733b = r0;
    L_0x003c:
        return;
    L_0x003d:
        r4 = new java.lang.IllegalArgumentException;
        r0 = "invalid info structure in DSA public key";
        r4.<init>(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dsa.BCDSAPublicKey.<init>(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    /* renamed from: a */
    private boolean m27963a(ASN1Encodable aSN1Encodable) {
        return (aSN1Encodable == null || DERNull.f32850a.equals(aSN1Encodable.mo5709e()) != null) ? null : true;
    }

    public byte[] getEncoded() {
        if (this.f22733b == null) {
            return KeyUtil.m28018a(new AlgorithmIdentifier(X9ObjectIdentifiers.f22154U), new ASN1Integer(this.f22732a));
        }
        return KeyUtil.m28018a(new AlgorithmIdentifier(X9ObjectIdentifiers.f22154U, new DSAParameter(this.f22733b.getP(), this.f22733b.getQ(), this.f22733b.getG()).mo5709e()), new ASN1Integer(this.f22732a));
    }

    public DSAParams getParams() {
        return this.f22733b;
    }

    public BigInteger getY() {
        return this.f22732a;
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
        objectInputStream.defaultReadObject();
        this.f22733b = new DSAParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f22733b.getP());
        objectOutputStream.writeObject(this.f22733b.getQ());
        objectOutputStream.writeObject(this.f22733b.getG());
    }
}
