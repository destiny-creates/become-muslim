package org.spongycastle.jce.provider;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.oiw.ElGamalParameter;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.ElGamalPrivateKey;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.spec.ElGamalParameterSpec;

public class JCEElGamalPrivateKey implements DHPrivateKey, ElGamalPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 4819350091141529678L;
    /* renamed from: a */
    BigInteger f32007a;
    /* renamed from: b */
    ElGamalParameterSpec f32008b;
    /* renamed from: c */
    private PKCS12BagAttributeCarrierImpl f32009c = new PKCS12BagAttributeCarrierImpl();

    public String getAlgorithm() {
        return "ElGamal";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    protected JCEElGamalPrivateKey() {
    }

    public byte[] getEncoded() {
        return KeyUtil.m28020b(new AlgorithmIdentifier(OIWObjectIdentifiers.f21833l, new ElGamalParameter(this.f32008b.m28321a(), this.f32008b.m28322b())), new ASN1Integer(getX()));
    }

    /* renamed from: b */
    public ElGamalParameterSpec mo6506b() {
        return this.f32008b;
    }

    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.f32008b.m28321a(), this.f32008b.m28322b());
    }

    public BigInteger getX() {
        return this.f32007a;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f32007a = (BigInteger) objectInputStream.readObject();
        this.f32008b = new ElGamalParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(getX());
        objectOutputStream.writeObject(this.f32008b.m28321a());
        objectOutputStream.writeObject(this.f32008b.m28322b());
    }

    /* renamed from: a */
    public void mo5851a(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f32009c.mo5851a(aSN1ObjectIdentifier, aSN1Encodable);
    }

    /* renamed from: a */
    public ASN1Encodable mo5850a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f32009c.mo5850a(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public Enumeration mo5849a() {
        return this.f32009c.mo5849a();
    }
}
