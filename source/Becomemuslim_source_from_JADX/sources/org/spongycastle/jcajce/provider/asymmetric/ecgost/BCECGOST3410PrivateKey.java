package org.spongycastle.jcajce.provider.asymmetric.ecgost;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.ECGOST3410NamedCurveTable;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveParameterSpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.jce.spec.ECPrivateKeySpec;
import org.spongycastle.util.Strings;

public class BCECGOST3410PrivateKey implements ECPrivateKey, ECPointEncoder, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 7245981689601667138L;
    /* renamed from: a */
    private String f31898a = "ECGOST3410";
    /* renamed from: b */
    private boolean f31899b;
    /* renamed from: c */
    private transient GOST3410PublicKeyAlgParameters f31900c;
    /* renamed from: d */
    private transient BigInteger f31901d;
    /* renamed from: e */
    private transient ECParameterSpec f31902e;
    /* renamed from: f */
    private transient DERBitString f31903f;
    /* renamed from: g */
    private transient PKCS12BagAttributeCarrierImpl f31904g = new PKCS12BagAttributeCarrierImpl();

    public String getFormat() {
        return "PKCS#8";
    }

    protected BCECGOST3410PrivateKey() {
    }

    public BCECGOST3410PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.f31901d = eCPrivateKeySpec.m36251b();
        if (eCPrivateKeySpec.m28309a() != null) {
            this.f31902e = EC5Util.m27996a(EC5Util.m27999a(eCPrivateKeySpec.m28309a().m28315b(), eCPrivateKeySpec.m28309a().m28319f()), eCPrivateKeySpec.m28309a());
        } else {
            this.f31902e = null;
        }
    }

    public BCECGOST3410PrivateKey(java.security.spec.ECPrivateKeySpec eCPrivateKeySpec) {
        this.f31901d = eCPrivateKeySpec.getS();
        this.f31902e = eCPrivateKeySpec.getParams();
    }

    public BCECGOST3410PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECGOST3410PublicKey bCECGOST3410PublicKey, ECParameterSpec eCParameterSpec) {
        ECDomainParameters b = eCPrivateKeyParameters.m40792b();
        this.f31898a = str;
        this.f31901d = eCPrivateKeyParameters.m43369c();
        if (eCParameterSpec == null) {
            this.f31902e = new ECParameterSpec(EC5Util.m27999a(b.m35647a(), b.m35651e()), new ECPoint(b.m35648b().m28409g().mo6549a(), b.m35648b().m28410h().mo6549a()), b.m35649c(), b.m35650d().intValue());
        } else {
            this.f31902e = eCParameterSpec;
        }
        this.f31900c = bCECGOST3410PublicKey.m41056e();
        this.f31903f = m41040a(bCECGOST3410PublicKey);
    }

    public BCECGOST3410PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECGOST3410PublicKey bCECGOST3410PublicKey, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECDomainParameters b = eCPrivateKeyParameters.m40792b();
        this.f31898a = str;
        this.f31901d = eCPrivateKeyParameters.m43369c();
        if (eCParameterSpec == null) {
            this.f31902e = new ECParameterSpec(EC5Util.m27999a(b.m35647a(), b.m35651e()), new ECPoint(b.m35648b().m28409g().mo6549a(), b.m35648b().m28410h().mo6549a()), b.m35649c(), b.m35650d().intValue());
        } else {
            this.f31902e = new ECParameterSpec(EC5Util.m27999a(eCParameterSpec.m28315b(), eCParameterSpec.m28319f()), new ECPoint(eCParameterSpec.m28316c().m28409g().mo6549a(), eCParameterSpec.m28316c().m28410h().mo6549a()), eCParameterSpec.m28317d(), eCParameterSpec.m28318e().intValue());
        }
        this.f31900c = bCECGOST3410PublicKey.m41056e();
        this.f31903f = m41040a(bCECGOST3410PublicKey);
    }

    public BCECGOST3410PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters) {
        this.f31898a = str;
        this.f31901d = eCPrivateKeyParameters.m43369c();
        this.f31902e = null;
    }

    BCECGOST3410PrivateKey(PrivateKeyInfo privateKeyInfo) {
        m41041a(privateKeyInfo);
    }

    /* renamed from: a */
    private void m41041a(PrivateKeyInfo privateKeyInfo) {
        Object e = privateKeyInfo.m40112a().m40231b().mo5709e();
        Object c;
        if ((e instanceof ASN1Sequence) && (ASN1Sequence.m43000a(e).mo6862g() == 2 || ASN1Sequence.m43000a(e).mo6862g() == 3)) {
            this.f31900c = GOST3410PublicKeyAlgParameters.m39948a(privateKeyInfo.m40112a().m40231b());
            ECNamedCurveParameterSpec a = ECGOST3410NamedCurveTable.m28120a(ECGOST3410NamedCurves.m27182b(this.f31900c.m39949a()));
            this.f31902e = new ECNamedCurveSpec(ECGOST3410NamedCurves.m27182b(this.f31900c.m39949a()), EC5Util.m27999a(a.m28315b(), a.m28319f()), new ECPoint(a.m28316c().m28409g().mo6549a(), a.m28316c().m28410h().mo6549a()), a.m28317d(), a.m28318e());
            c = privateKeyInfo.m40114c();
            if (c instanceof ASN1Integer) {
                this.f31901d = ASN1Integer.m42963a(c).m42969c();
                return;
            }
            privateKeyInfo = ASN1OctetString.m42990a(c).mo6859c();
            byte[] bArr = new byte[privateKeyInfo.length];
            for (int i = 0; i != privateKeyInfo.length; i++) {
                bArr[i] = privateKeyInfo[(privateKeyInfo.length - 1) - i];
            }
            this.f31901d = new BigInteger(1, bArr);
            return;
        }
        X962Parameters a2 = X962Parameters.m40506a(privateKeyInfo.m40112a().m40231b());
        if (a2.m40507a()) {
            ASN1ObjectIdentifier a3 = ASN1ObjectIdentifier.m42973a(a2.m40509c());
            X9ECParameters a4 = ECUtil.m28008a(a3);
            if (a4 == null) {
                ECDomainParameters a5 = ECGOST3410NamedCurves.m27181a(a3);
                this.f31902e = new ECNamedCurveSpec(ECGOST3410NamedCurves.m27182b(a3), EC5Util.m27999a(a5.m35647a(), a5.m35651e()), new ECPoint(a5.m35648b().m28409g().mo6549a(), a5.m35648b().m28410h().mo6549a()), a5.m35649c(), a5.m35650d());
            } else {
                this.f31902e = new ECNamedCurveSpec(ECUtil.m28012b(a3), EC5Util.m27999a(a4.m40516a(), a4.m40521g()), new ECPoint(a4.m40517b().m28409g().mo6549a(), a4.m40517b().m28410h().mo6549a()), a4.m40518c(), a4.m40519d());
            }
        } else if (a2.m40508b()) {
            this.f31902e = null;
        } else {
            X9ECParameters a6 = X9ECParameters.m40515a(a2.m40509c());
            this.f31902e = new ECParameterSpec(EC5Util.m27999a(a6.m40516a(), a6.m40521g()), new ECPoint(a6.m40517b().m28409g().mo6549a(), a6.m40517b().m28410h().mo6549a()), a6.m40518c(), a6.m40519d().intValue());
        }
        c = privateKeyInfo.m40114c();
        if (c instanceof ASN1Integer) {
            this.f31901d = ASN1Integer.m42963a(c).m42968b();
            return;
        }
        privateKeyInfo = org.spongycastle.asn1.sec.ECPrivateKey.m40165a(c);
        this.f31901d = privateKeyInfo.m40166a();
        this.f31903f = privateKeyInfo.m40167b();
    }

    public String getAlgorithm() {
        return this.f31898a;
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.f31900c;
        r1 = 0;
        if (r0 == 0) goto L_0x002c;
    L_0x0005:
        r0 = 32;
        r0 = new byte[r0];
        r2 = 0;
        r3 = r8.getS();
        r8.m41042a(r0, r2, r3);
        r2 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo;	 Catch:{ IOException -> 0x002b }
        r3 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x002b }
        r4 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.f21564j;	 Catch:{ IOException -> 0x002b }
        r5 = r8.f31900c;	 Catch:{ IOException -> 0x002b }
        r3.<init>(r4, r5);	 Catch:{ IOException -> 0x002b }
        r4 = new org.spongycastle.asn1.DEROctetString;	 Catch:{ IOException -> 0x002b }
        r4.<init>(r0);	 Catch:{ IOException -> 0x002b }
        r2.<init>(r3, r4);	 Catch:{ IOException -> 0x002b }
        r0 = "DER";	 Catch:{ IOException -> 0x002b }
        r0 = r2.m34596a(r0);	 Catch:{ IOException -> 0x002b }
        return r0;
    L_0x002b:
        return r1;
    L_0x002c:
        r0 = r8.f31902e;
        r0 = r0 instanceof org.spongycastle.jce.spec.ECNamedCurveSpec;
        if (r0 == 0) goto L_0x0061;
    L_0x0032:
        r0 = r8.f31902e;
        r0 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r0;
        r0 = r0.m28314a();
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28006a(r0);
        if (r0 != 0) goto L_0x004d;
    L_0x0040:
        r0 = new org.spongycastle.asn1.ASN1ObjectIdentifier;
        r2 = r8.f31902e;
        r2 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r2;
        r2 = r2.m28314a();
        r0.<init>(r2);
    L_0x004d:
        r2 = new org.spongycastle.asn1.x9.X962Parameters;
        r2.<init>(r0);
        r0 = r8.f31902e;
        r0 = r0.getOrder();
        r3 = r8.getS();
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28005a(r0, r3);
        goto L_0x00bf;
    L_0x0061:
        r0 = r8.f31902e;
        if (r0 != 0) goto L_0x0075;
    L_0x0065:
        r2 = new org.spongycastle.asn1.x9.X962Parameters;
        r0 = org.spongycastle.asn1.DERNull.f32850a;
        r2.<init>(r0);
        r0 = r8.getS();
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28005a(r1, r0);
        goto L_0x00bf;
    L_0x0075:
        r0 = r8.f31902e;
        r0 = r0.getCurve();
        r3 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28001a(r0);
        r0 = new org.spongycastle.asn1.x9.X9ECParameters;
        r2 = r8.f31902e;
        r2 = r2.getGenerator();
        r4 = r8.f31899b;
        r4 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28004a(r3, r2, r4);
        r2 = r8.f31902e;
        r5 = r2.getOrder();
        r2 = r8.f31902e;
        r2 = r2.getCofactor();
        r6 = (long) r2;
        r6 = java.math.BigInteger.valueOf(r6);
        r2 = r8.f31902e;
        r2 = r2.getCurve();
        r7 = r2.getSeed();
        r2 = r0;
        r2.<init>(r3, r4, r5, r6, r7);
        r2 = new org.spongycastle.asn1.x9.X962Parameters;
        r2.<init>(r0);
        r0 = r8.f31902e;
        r0 = r0.getOrder();
        r3 = r8.getS();
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28005a(r0, r3);
    L_0x00bf:
        r3 = r8.f31903f;
        if (r3 == 0) goto L_0x00cf;
    L_0x00c3:
        r3 = new org.spongycastle.asn1.sec.ECPrivateKey;
        r4 = r8.getS();
        r5 = r8.f31903f;
        r3.<init>(r0, r4, r5, r2);
        goto L_0x00d8;
    L_0x00cf:
        r3 = new org.spongycastle.asn1.sec.ECPrivateKey;
        r4 = r8.getS();
        r3.<init>(r0, r4, r2);
    L_0x00d8:
        r0 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo;	 Catch:{ IOException -> 0x00f3 }
        r4 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x00f3 }
        r5 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.f21564j;	 Catch:{ IOException -> 0x00f3 }
        r2 = r2.mo5709e();	 Catch:{ IOException -> 0x00f3 }
        r4.<init>(r5, r2);	 Catch:{ IOException -> 0x00f3 }
        r2 = r3.mo5709e();	 Catch:{ IOException -> 0x00f3 }
        r0.<init>(r4, r2);	 Catch:{ IOException -> 0x00f3 }
        r2 = "DER";	 Catch:{ IOException -> 0x00f3 }
        r0 = r0.m34596a(r2);	 Catch:{ IOException -> 0x00f3 }
        return r0;
    L_0x00f3:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ecgost.BCECGOST3410PrivateKey.getEncoded():byte[]");
    }

    /* renamed from: a */
    private void m41042a(byte[] bArr, int i, BigInteger bigInteger) {
        bigInteger = bigInteger.toByteArray();
        int i2 = 0;
        if (bigInteger.length < 32) {
            BigInteger bigInteger2 = new byte[32];
            System.arraycopy(bigInteger, 0, bigInteger2, bigInteger2.length - bigInteger.length, bigInteger.length);
            bigInteger = bigInteger2;
        }
        while (i2 != 32) {
            bArr[i + i2] = bigInteger[(bigInteger.length - 1) - i2];
            i2++;
        }
    }

    public ECParameterSpec getParams() {
        return this.f31902e;
    }

    /* renamed from: b */
    public org.spongycastle.jce.spec.ECParameterSpec mo6501b() {
        if (this.f31902e == null) {
            return null;
        }
        return EC5Util.m28000a(this.f31902e, this.f31899b);
    }

    /* renamed from: c */
    org.spongycastle.jce.spec.ECParameterSpec m41047c() {
        if (this.f31902e != null) {
            return EC5Util.m28000a(this.f31902e, this.f31899b);
        }
        return BouncyCastleProvider.f27551a.mo5888a();
    }

    public BigInteger getS() {
        return this.f31901d;
    }

    /* renamed from: d */
    public BigInteger mo6502d() {
        return this.f31901d;
    }

    /* renamed from: a */
    public void mo5851a(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f31904g.mo5851a(aSN1ObjectIdentifier, aSN1Encodable);
    }

    /* renamed from: a */
    public ASN1Encodable mo5850a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f31904g.mo5850a(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public Enumeration mo5849a() {
        return this.f31904g.mo5849a();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof BCECGOST3410PrivateKey)) {
            return false;
        }
        BCECGOST3410PrivateKey bCECGOST3410PrivateKey = (BCECGOST3410PrivateKey) obj;
        if (mo6502d().equals(bCECGOST3410PrivateKey.mo6502d()) && m41047c().equals(bCECGOST3410PrivateKey.m41047c()) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return mo6502d().hashCode() ^ m41047c().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String a = Strings.m29418a();
        stringBuffer.append("EC Private Key");
        stringBuffer.append(a);
        stringBuffer.append("             S: ");
        stringBuffer.append(this.f31901d.toString(16));
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private org.spongycastle.asn1.DERBitString m41040a(org.spongycastle.jcajce.provider.asymmetric.ecgost.BCECGOST3410PublicKey r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r1 = r1.getEncoded();	 Catch:{ IOException -> 0x0011 }
        r1 = org.spongycastle.asn1.ASN1Primitive.m39798b(r1);	 Catch:{ IOException -> 0x0011 }
        r1 = org.spongycastle.asn1.x509.SubjectPublicKeyInfo.m40409a(r1);	 Catch:{ IOException -> 0x0011 }
        r1 = r1.m40413d();	 Catch:{ IOException -> 0x0011 }
        return r1;
    L_0x0011:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ecgost.BCECGOST3410PrivateKey.a(org.spongycastle.jcajce.provider.asymmetric.ecgost.BCECGOST3410PublicKey):org.spongycastle.asn1.DERBitString");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        m41041a(PrivateKeyInfo.m40111a(ASN1Primitive.m39798b((byte[]) objectInputStream.readObject())));
        this.f31904g = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }
}
