package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPrivateKeySpec;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class BCDSAPrivateKey implements DSAPrivateKey, PKCS12BagAttributeCarrier {
    private static final long serialVersionUID = -4677259546958385734L;
    /* renamed from: a */
    private BigInteger f27387a;
    /* renamed from: b */
    private transient DSAParams f27388b;
    /* renamed from: c */
    private transient PKCS12BagAttributeCarrierImpl f27389c = new PKCS12BagAttributeCarrierImpl();

    public String getAlgorithm() {
        return "DSA";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    protected BCDSAPrivateKey() {
    }

    BCDSAPrivateKey(DSAPrivateKey dSAPrivateKey) {
        this.f27387a = dSAPrivateKey.getX();
        this.f27388b = dSAPrivateKey.getParams();
    }

    BCDSAPrivateKey(DSAPrivateKeySpec dSAPrivateKeySpec) {
        this.f27387a = dSAPrivateKeySpec.getX();
        this.f27388b = new DSAParameterSpec(dSAPrivateKeySpec.getP(), dSAPrivateKeySpec.getQ(), dSAPrivateKeySpec.getG());
    }

    public BCDSAPrivateKey(PrivateKeyInfo privateKeyInfo) {
        DSAParameter a = DSAParameter.m40300a(privateKeyInfo.m40112a().m40231b());
        this.f27387a = ((ASN1Integer) privateKeyInfo.m40114c()).m42968b();
        this.f27388b = new DSAParameterSpec(a.m40301a(), a.m40302b(), a.m40303c());
    }

    BCDSAPrivateKey(DSAPrivateKeyParameters dSAPrivateKeyParameters) {
        this.f27387a = dSAPrivateKeyParameters.m43367c();
        this.f27388b = new DSAParameterSpec(dSAPrivateKeyParameters.m40791b().m35644a(), dSAPrivateKeyParameters.m40791b().m35645b(), dSAPrivateKeyParameters.m40791b().m35646c());
    }

    public byte[] getEncoded() {
        return KeyUtil.m28020b(new AlgorithmIdentifier(X9ObjectIdentifiers.f22154U, new DSAParameter(this.f27388b.getP(), this.f27388b.getQ(), this.f27388b.getG()).mo5709e()), new ASN1Integer(getX()));
    }

    public DSAParams getParams() {
        return this.f27388b;
    }

    public BigInteger getX() {
        return this.f27387a;
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
        this.f27389c.mo5851a(aSN1ObjectIdentifier, aSN1Encodable);
    }

    /* renamed from: a */
    public ASN1Encodable mo5850a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f27389c.mo5850a(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public Enumeration mo5849a() {
        return this.f27389c.mo5849a();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f27388b = new DSAParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        this.f27389c = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f27388b.getP());
        objectOutputStream.writeObject(this.f27388b.getQ());
        objectOutputStream.writeObject(this.f27388b.getG());
    }
}
