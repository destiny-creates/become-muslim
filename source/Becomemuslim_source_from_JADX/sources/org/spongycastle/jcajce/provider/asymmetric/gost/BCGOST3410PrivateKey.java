package org.spongycastle.jcajce.provider.asymmetric.gost;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.GOST3410Params;
import org.spongycastle.jce.interfaces.GOST3410PrivateKey;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.spec.GOST3410ParameterSpec;
import org.spongycastle.jce.spec.GOST3410PrivateKeySpec;
import org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public class BCGOST3410PrivateKey implements GOST3410PrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 8581661527592305464L;
    /* renamed from: a */
    private BigInteger f31915a;
    /* renamed from: b */
    private transient GOST3410Params f31916b;
    /* renamed from: c */
    private transient PKCS12BagAttributeCarrier f31917c = new PKCS12BagAttributeCarrierImpl();

    public String getAlgorithm() {
        return "GOST3410";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    protected BCGOST3410PrivateKey() {
    }

    BCGOST3410PrivateKey(GOST3410PrivateKey gOST3410PrivateKey) {
        this.f31915a = gOST3410PrivateKey.mo6510c();
        this.f31916b = gOST3410PrivateKey.mo6509b();
    }

    BCGOST3410PrivateKey(GOST3410PrivateKeySpec gOST3410PrivateKeySpec) {
        this.f31915a = gOST3410PrivateKeySpec.m28323a();
        this.f31916b = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(gOST3410PrivateKeySpec.m28324b(), gOST3410PrivateKeySpec.m28325c(), gOST3410PrivateKeySpec.m28326d()));
    }

    BCGOST3410PrivateKey(PrivateKeyInfo privateKeyInfo) {
        GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = new GOST3410PublicKeyAlgParameters((ASN1Sequence) privateKeyInfo.m40113b().m40231b());
        privateKeyInfo = ASN1OctetString.m42990a(privateKeyInfo.m40114c()).mo6859c();
        byte[] bArr = new byte[privateKeyInfo.length];
        for (int i = 0; i != privateKeyInfo.length; i++) {
            bArr[i] = privateKeyInfo[(privateKeyInfo.length - 1) - i];
        }
        this.f31915a = new BigInteger(1, bArr);
        this.f31916b = GOST3410ParameterSpec.m36255a(gOST3410PublicKeyAlgParameters);
    }

    BCGOST3410PrivateKey(GOST3410PrivateKeyParameters gOST3410PrivateKeyParameters, GOST3410ParameterSpec gOST3410ParameterSpec) {
        this.f31915a = gOST3410PrivateKeyParameters.m43373c();
        this.f31916b = gOST3410ParameterSpec;
        if (gOST3410ParameterSpec == null) {
            throw new IllegalArgumentException("spec is null");
        }
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.mo6510c();
        r0 = r0.toByteArray();
        r1 = 0;
        r2 = r0[r1];
        if (r2 != 0) goto L_0x0013;
    L_0x000d:
        r2 = r0.length;
        r2 = r2 + -1;
        r2 = new byte[r2];
        goto L_0x0016;
    L_0x0013:
        r2 = r0.length;
        r2 = new byte[r2];
    L_0x0016:
        r3 = r2.length;
        if (r1 == r3) goto L_0x0024;
    L_0x0019:
        r3 = r0.length;
        r3 = r3 + -1;
        r3 = r3 - r1;
        r3 = r0[r3];
        r2[r1] = r3;
        r1 = r1 + 1;
        goto L_0x0016;
    L_0x0024:
        r0 = r8.f31916b;	 Catch:{ IOException -> 0x006f }
        r0 = r0 instanceof org.spongycastle.jce.spec.GOST3410ParameterSpec;	 Catch:{ IOException -> 0x006f }
        if (r0 == 0) goto L_0x0057;	 Catch:{ IOException -> 0x006f }
    L_0x002a:
        r0 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo;	 Catch:{ IOException -> 0x006f }
        r1 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x006f }
        r3 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.f21563i;	 Catch:{ IOException -> 0x006f }
        r4 = new org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;	 Catch:{ IOException -> 0x006f }
        r5 = new org.spongycastle.asn1.ASN1ObjectIdentifier;	 Catch:{ IOException -> 0x006f }
        r6 = r8.f31916b;	 Catch:{ IOException -> 0x006f }
        r6 = r6.mo5890a();	 Catch:{ IOException -> 0x006f }
        r5.<init>(r6);	 Catch:{ IOException -> 0x006f }
        r6 = new org.spongycastle.asn1.ASN1ObjectIdentifier;	 Catch:{ IOException -> 0x006f }
        r7 = r8.f31916b;	 Catch:{ IOException -> 0x006f }
        r7 = r7.mo5891b();	 Catch:{ IOException -> 0x006f }
        r6.<init>(r7);	 Catch:{ IOException -> 0x006f }
        r4.<init>(r5, r6);	 Catch:{ IOException -> 0x006f }
        r1.<init>(r3, r4);	 Catch:{ IOException -> 0x006f }
        r3 = new org.spongycastle.asn1.DEROctetString;	 Catch:{ IOException -> 0x006f }
        r3.<init>(r2);	 Catch:{ IOException -> 0x006f }
        r0.<init>(r1, r3);	 Catch:{ IOException -> 0x006f }
        goto L_0x0068;	 Catch:{ IOException -> 0x006f }
    L_0x0057:
        r0 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo;	 Catch:{ IOException -> 0x006f }
        r1 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x006f }
        r3 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.f21563i;	 Catch:{ IOException -> 0x006f }
        r1.<init>(r3);	 Catch:{ IOException -> 0x006f }
        r3 = new org.spongycastle.asn1.DEROctetString;	 Catch:{ IOException -> 0x006f }
        r3.<init>(r2);	 Catch:{ IOException -> 0x006f }
        r0.<init>(r1, r3);	 Catch:{ IOException -> 0x006f }
    L_0x0068:
        r1 = "DER";	 Catch:{ IOException -> 0x006f }
        r0 = r0.m34596a(r1);	 Catch:{ IOException -> 0x006f }
        return r0;
    L_0x006f:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.gost.BCGOST3410PrivateKey.getEncoded():byte[]");
    }

    /* renamed from: b */
    public GOST3410Params mo6509b() {
        return this.f31916b;
    }

    /* renamed from: c */
    public BigInteger mo6510c() {
        return this.f31915a;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof GOST3410PrivateKey)) {
            return false;
        }
        GOST3410PrivateKey gOST3410PrivateKey = (GOST3410PrivateKey) obj;
        if (mo6510c().equals(gOST3410PrivateKey.mo6510c()) && mo6509b().mo5893d().equals(gOST3410PrivateKey.mo6509b().mo5893d()) && mo6509b().mo5891b().equals(gOST3410PrivateKey.mo6509b().mo5891b()) && m41066a(mo6509b().mo5892c(), gOST3410PrivateKey.mo6509b().mo5892c()) != null) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private boolean m41066a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        return obj == null ? null : obj.equals(obj2);
    }

    public int hashCode() {
        return mo6510c().hashCode() ^ this.f31916b.hashCode();
    }

    /* renamed from: a */
    public void mo5851a(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f31917c.mo5851a(aSN1ObjectIdentifier, aSN1Encodable);
    }

    /* renamed from: a */
    public ASN1Encodable mo5850a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f31917c.mo5850a(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public Enumeration mo5849a() {
        return this.f31917c.mo5849a();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        String str = (String) objectInputStream.readObject();
        if (str != null) {
            this.f31916b = new GOST3410ParameterSpec(str, (String) objectInputStream.readObject(), (String) objectInputStream.readObject());
        } else {
            this.f31916b = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject()));
            objectInputStream.readObject();
            objectInputStream.readObject();
        }
        this.f31917c = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        if (this.f31916b.mo5890a() != null) {
            objectOutputStream.writeObject(this.f31916b.mo5890a());
            objectOutputStream.writeObject(this.f31916b.mo5891b());
            objectOutputStream.writeObject(this.f31916b.mo5892c());
            return;
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(this.f31916b.mo5893d().m28327a());
        objectOutputStream.writeObject(this.f31916b.mo5893d().m28328b());
        objectOutputStream.writeObject(this.f31916b.mo5893d().m28329c());
        objectOutputStream.writeObject(this.f31916b.mo5891b());
        objectOutputStream.writeObject(this.f31916b.mo5892c());
    }
}
