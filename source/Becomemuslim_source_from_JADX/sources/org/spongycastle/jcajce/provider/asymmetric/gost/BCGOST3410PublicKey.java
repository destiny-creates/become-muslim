package org.spongycastle.jcajce.provider.asymmetric.gost;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import org.spongycastle.crypto.params.GOST3410PublicKeyParameters;
import org.spongycastle.jce.interfaces.GOST3410Params;
import org.spongycastle.jce.interfaces.GOST3410PublicKey;
import org.spongycastle.jce.spec.GOST3410ParameterSpec;
import org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;
import org.spongycastle.jce.spec.GOST3410PublicKeySpec;
import org.spongycastle.util.Strings;

public class BCGOST3410PublicKey implements GOST3410PublicKey {
    static final long serialVersionUID = -6251023343619275990L;
    /* renamed from: a */
    private BigInteger f31918a;
    /* renamed from: b */
    private transient GOST3410Params f31919b;

    public String getAlgorithm() {
        return "GOST3410";
    }

    public String getFormat() {
        return "X.509";
    }

    BCGOST3410PublicKey(GOST3410PublicKeySpec gOST3410PublicKeySpec) {
        this.f31918a = gOST3410PublicKeySpec.m28330a();
        this.f31919b = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(gOST3410PublicKeySpec.m28331b(), gOST3410PublicKeySpec.m28332c(), gOST3410PublicKeySpec.m28333d()));
    }

    BCGOST3410PublicKey(GOST3410PublicKey gOST3410PublicKey) {
        this.f31918a = gOST3410PublicKey.mo6511a();
        this.f31919b = gOST3410PublicKey.mo6509b();
    }

    BCGOST3410PublicKey(GOST3410PublicKeyParameters gOST3410PublicKeyParameters, GOST3410ParameterSpec gOST3410ParameterSpec) {
        this.f31918a = gOST3410PublicKeyParameters.m43374c();
        this.f31919b = gOST3410ParameterSpec;
    }

    BCGOST3410PublicKey(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r5.<init>();
        r0 = new org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
        r1 = r6.m40411b();
        r1 = r1.m40231b();
        r1 = (org.spongycastle.asn1.ASN1Sequence) r1;
        r0.<init>(r1);
        r6 = r6.m40412c();	 Catch:{ IOException -> 0x003c }
        r6 = (org.spongycastle.asn1.DEROctetString) r6;	 Catch:{ IOException -> 0x003c }
        r6 = r6.mo6859c();	 Catch:{ IOException -> 0x003c }
        r1 = r6.length;	 Catch:{ IOException -> 0x003c }
        r1 = new byte[r1];	 Catch:{ IOException -> 0x003c }
        r2 = 0;	 Catch:{ IOException -> 0x003c }
    L_0x0020:
        r3 = r6.length;	 Catch:{ IOException -> 0x003c }
        r4 = 1;	 Catch:{ IOException -> 0x003c }
        if (r2 == r3) goto L_0x002e;	 Catch:{ IOException -> 0x003c }
    L_0x0024:
        r3 = r6.length;	 Catch:{ IOException -> 0x003c }
        r3 = r3 - r4;	 Catch:{ IOException -> 0x003c }
        r3 = r3 - r2;	 Catch:{ IOException -> 0x003c }
        r3 = r6[r3];	 Catch:{ IOException -> 0x003c }
        r1[r2] = r3;	 Catch:{ IOException -> 0x003c }
        r2 = r2 + 1;	 Catch:{ IOException -> 0x003c }
        goto L_0x0020;	 Catch:{ IOException -> 0x003c }
    L_0x002e:
        r6 = new java.math.BigInteger;	 Catch:{ IOException -> 0x003c }
        r6.<init>(r4, r1);	 Catch:{ IOException -> 0x003c }
        r5.f31918a = r6;	 Catch:{ IOException -> 0x003c }
        r6 = org.spongycastle.jce.spec.GOST3410ParameterSpec.m36255a(r0);
        r5.f31919b = r6;
        return;
    L_0x003c:
        r6 = new java.lang.IllegalArgumentException;
        r0 = "invalid info structure in GOST3410 public key";
        r6.<init>(r0);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.gost.BCGOST3410PublicKey.<init>(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = r9.mo6511a();
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
        r0 = r9.f31919b;	 Catch:{ IOException -> 0x00ad }
        r0 = r0 instanceof org.spongycastle.jce.spec.GOST3410ParameterSpec;	 Catch:{ IOException -> 0x00ad }
        if (r0 == 0) goto L_0x0097;	 Catch:{ IOException -> 0x00ad }
    L_0x002a:
        r0 = r9.f31919b;	 Catch:{ IOException -> 0x00ad }
        r0 = r0.mo5892c();	 Catch:{ IOException -> 0x00ad }
        if (r0 == 0) goto L_0x006a;	 Catch:{ IOException -> 0x00ad }
    L_0x0032:
        r0 = new org.spongycastle.asn1.x509.SubjectPublicKeyInfo;	 Catch:{ IOException -> 0x00ad }
        r1 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x00ad }
        r3 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.f21563i;	 Catch:{ IOException -> 0x00ad }
        r4 = new org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;	 Catch:{ IOException -> 0x00ad }
        r5 = new org.spongycastle.asn1.ASN1ObjectIdentifier;	 Catch:{ IOException -> 0x00ad }
        r6 = r9.f31919b;	 Catch:{ IOException -> 0x00ad }
        r6 = r6.mo5890a();	 Catch:{ IOException -> 0x00ad }
        r5.<init>(r6);	 Catch:{ IOException -> 0x00ad }
        r6 = new org.spongycastle.asn1.ASN1ObjectIdentifier;	 Catch:{ IOException -> 0x00ad }
        r7 = r9.f31919b;	 Catch:{ IOException -> 0x00ad }
        r7 = r7.mo5891b();	 Catch:{ IOException -> 0x00ad }
        r6.<init>(r7);	 Catch:{ IOException -> 0x00ad }
        r7 = new org.spongycastle.asn1.ASN1ObjectIdentifier;	 Catch:{ IOException -> 0x00ad }
        r8 = r9.f31919b;	 Catch:{ IOException -> 0x00ad }
        r8 = r8.mo5892c();	 Catch:{ IOException -> 0x00ad }
        r7.<init>(r8);	 Catch:{ IOException -> 0x00ad }
        r4.<init>(r5, r6, r7);	 Catch:{ IOException -> 0x00ad }
        r1.<init>(r3, r4);	 Catch:{ IOException -> 0x00ad }
        r3 = new org.spongycastle.asn1.DEROctetString;	 Catch:{ IOException -> 0x00ad }
        r3.<init>(r2);	 Catch:{ IOException -> 0x00ad }
        r0.<init>(r1, r3);	 Catch:{ IOException -> 0x00ad }
        goto L_0x00a8;	 Catch:{ IOException -> 0x00ad }
    L_0x006a:
        r0 = new org.spongycastle.asn1.x509.SubjectPublicKeyInfo;	 Catch:{ IOException -> 0x00ad }
        r1 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x00ad }
        r3 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.f21563i;	 Catch:{ IOException -> 0x00ad }
        r4 = new org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;	 Catch:{ IOException -> 0x00ad }
        r5 = new org.spongycastle.asn1.ASN1ObjectIdentifier;	 Catch:{ IOException -> 0x00ad }
        r6 = r9.f31919b;	 Catch:{ IOException -> 0x00ad }
        r6 = r6.mo5890a();	 Catch:{ IOException -> 0x00ad }
        r5.<init>(r6);	 Catch:{ IOException -> 0x00ad }
        r6 = new org.spongycastle.asn1.ASN1ObjectIdentifier;	 Catch:{ IOException -> 0x00ad }
        r7 = r9.f31919b;	 Catch:{ IOException -> 0x00ad }
        r7 = r7.mo5891b();	 Catch:{ IOException -> 0x00ad }
        r6.<init>(r7);	 Catch:{ IOException -> 0x00ad }
        r4.<init>(r5, r6);	 Catch:{ IOException -> 0x00ad }
        r1.<init>(r3, r4);	 Catch:{ IOException -> 0x00ad }
        r3 = new org.spongycastle.asn1.DEROctetString;	 Catch:{ IOException -> 0x00ad }
        r3.<init>(r2);	 Catch:{ IOException -> 0x00ad }
        r0.<init>(r1, r3);	 Catch:{ IOException -> 0x00ad }
        goto L_0x00a8;	 Catch:{ IOException -> 0x00ad }
    L_0x0097:
        r0 = new org.spongycastle.asn1.x509.SubjectPublicKeyInfo;	 Catch:{ IOException -> 0x00ad }
        r1 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x00ad }
        r3 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.f21563i;	 Catch:{ IOException -> 0x00ad }
        r1.<init>(r3);	 Catch:{ IOException -> 0x00ad }
        r3 = new org.spongycastle.asn1.DEROctetString;	 Catch:{ IOException -> 0x00ad }
        r3.<init>(r2);	 Catch:{ IOException -> 0x00ad }
        r0.<init>(r1, r3);	 Catch:{ IOException -> 0x00ad }
    L_0x00a8:
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil.m28019a(r0);	 Catch:{ IOException -> 0x00ad }
        return r0;
    L_0x00ad:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.gost.BCGOST3410PublicKey.getEncoded():byte[]");
    }

    /* renamed from: b */
    public GOST3410Params mo6509b() {
        return this.f31919b;
    }

    /* renamed from: a */
    public BigInteger mo6511a() {
        return this.f31918a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String a = Strings.m29418a();
        stringBuffer.append("GOST3410 Public Key");
        stringBuffer.append(a);
        stringBuffer.append("            y: ");
        stringBuffer.append(mo6511a().toString(16));
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof BCGOST3410PublicKey)) {
            return false;
        }
        BCGOST3410PublicKey bCGOST3410PublicKey = (BCGOST3410PublicKey) obj;
        if (this.f31918a.equals(bCGOST3410PublicKey.f31918a) && this.f31919b.equals(bCGOST3410PublicKey.f31919b) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return this.f31918a.hashCode() ^ this.f31919b.hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        String str = (String) objectInputStream.readObject();
        if (str != null) {
            this.f31919b = new GOST3410ParameterSpec(str, (String) objectInputStream.readObject(), (String) objectInputStream.readObject());
            return;
        }
        this.f31919b = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject()));
        objectInputStream.readObject();
        objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        if (this.f31919b.mo5890a() != null) {
            objectOutputStream.writeObject(this.f31919b.mo5890a());
            objectOutputStream.writeObject(this.f31919b.mo5891b());
            objectOutputStream.writeObject(this.f31919b.mo5892c());
            return;
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(this.f31919b.mo5893d().m28327a());
        objectOutputStream.writeObject(this.f31919b.mo5893d().m28328b());
        objectOutputStream.writeObject(this.f31919b.mo5893d().m28329c());
        objectOutputStream.writeObject(this.f31919b.mo5891b());
        objectOutputStream.writeObject(this.f31919b.mo5892c());
    }
}
