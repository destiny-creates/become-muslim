package org.spongycastle.jce.provider;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.pkcs.DHParameter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;

public class JCEDHPublicKey implements DHPublicKey {
    static final long serialVersionUID = -216691575254424324L;
    /* renamed from: a */
    private BigInteger f22972a;
    /* renamed from: b */
    private DHParameterSpec f22973b;
    /* renamed from: c */
    private SubjectPublicKeyInfo f22974c;

    public String getAlgorithm() {
        return "DH";
    }

    public String getFormat() {
        return "X.509";
    }

    public byte[] getEncoded() {
        if (this.f22974c != null) {
            return KeyUtil.m28019a(this.f22974c);
        }
        return KeyUtil.m28018a(new AlgorithmIdentifier(PKCSObjectIdentifiers.f21865q, new DHParameter(this.f22973b.getP(), this.f22973b.getG(), this.f22973b.getL())), new ASN1Integer(this.f22972a));
    }

    public DHParameterSpec getParams() {
        return this.f22973b;
    }

    public BigInteger getY() {
        return this.f22972a;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f22972a = (BigInteger) objectInputStream.readObject();
        this.f22973b = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(getY());
        objectOutputStream.writeObject(this.f22973b.getP());
        objectOutputStream.writeObject(this.f22973b.getG());
        objectOutputStream.writeInt(this.f22973b.getL());
    }
}
