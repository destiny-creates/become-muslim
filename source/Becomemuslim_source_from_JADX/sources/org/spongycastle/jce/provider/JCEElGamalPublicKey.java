package org.spongycastle.jce.provider;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.oiw.ElGamalParameter;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jce.interfaces.ElGamalPublicKey;
import org.spongycastle.jce.spec.ElGamalParameterSpec;

public class JCEElGamalPublicKey implements DHPublicKey, ElGamalPublicKey {
    static final long serialVersionUID = 8712728417091216948L;
    /* renamed from: a */
    private BigInteger f32010a;
    /* renamed from: b */
    private ElGamalParameterSpec f32011b;

    public String getAlgorithm() {
        return "ElGamal";
    }

    public String getFormat() {
        return "X.509";
    }

    public byte[] getEncoded() {
        return KeyUtil.m28018a(new AlgorithmIdentifier(OIWObjectIdentifiers.f21833l, new ElGamalParameter(this.f32011b.m28321a(), this.f32011b.m28322b())), new ASN1Integer(this.f32010a));
    }

    /* renamed from: b */
    public ElGamalParameterSpec mo6506b() {
        return this.f32011b;
    }

    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.f32011b.m28321a(), this.f32011b.m28322b());
    }

    public BigInteger getY() {
        return this.f32010a;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f32010a = (BigInteger) objectInputStream.readObject();
        this.f32011b = new ElGamalParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(getY());
        objectOutputStream.writeObject(this.f32011b.m28321a());
        objectOutputStream.writeObject(this.f32011b.m28322b());
    }
}
