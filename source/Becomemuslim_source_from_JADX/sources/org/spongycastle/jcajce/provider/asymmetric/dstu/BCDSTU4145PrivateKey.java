package org.spongycastle.jcajce.provider.asymmetric.dstu;

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
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.ua.DSTU4145NamedCurves;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.jce.spec.ECPrivateKeySpec;
import org.spongycastle.util.Strings;

public class BCDSTU4145PrivateKey implements ECPrivateKey, ECPointEncoder, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 7245981689601667138L;
    /* renamed from: a */
    private String f31873a = "DSTU4145";
    /* renamed from: b */
    private boolean f31874b;
    /* renamed from: c */
    private transient BigInteger f31875c;
    /* renamed from: d */
    private transient ECParameterSpec f31876d;
    /* renamed from: e */
    private transient DERBitString f31877e;
    /* renamed from: f */
    private transient PKCS12BagAttributeCarrierImpl f31878f = new PKCS12BagAttributeCarrierImpl();

    public String getFormat() {
        return "PKCS#8";
    }

    protected BCDSTU4145PrivateKey() {
    }

    public BCDSTU4145PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.f31875c = eCPrivateKeySpec.m36251b();
        if (eCPrivateKeySpec.m28309a() != null) {
            this.f31876d = EC5Util.m27996a(EC5Util.m27999a(eCPrivateKeySpec.m28309a().m28315b(), eCPrivateKeySpec.m28309a().m28319f()), eCPrivateKeySpec.m28309a());
        } else {
            this.f31876d = null;
        }
    }

    public BCDSTU4145PrivateKey(java.security.spec.ECPrivateKeySpec eCPrivateKeySpec) {
        this.f31875c = eCPrivateKeySpec.getS();
        this.f31876d = eCPrivateKeySpec.getParams();
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCDSTU4145PublicKey bCDSTU4145PublicKey, ECParameterSpec eCParameterSpec) {
        ECDomainParameters b = eCPrivateKeyParameters.m40792b();
        this.f31873a = str;
        this.f31875c = eCPrivateKeyParameters.m43369c();
        if (eCParameterSpec == null) {
            this.f31876d = new ECParameterSpec(EC5Util.m27999a(b.m35647a(), b.m35651e()), new ECPoint(b.m35648b().m28409g().mo6549a(), b.m35648b().m28410h().mo6549a()), b.m35649c(), b.m35650d().intValue());
        } else {
            this.f31876d = eCParameterSpec;
        }
        this.f31877e = m41005a(bCDSTU4145PublicKey);
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCDSTU4145PublicKey bCDSTU4145PublicKey, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECDomainParameters b = eCPrivateKeyParameters.m40792b();
        this.f31873a = str;
        this.f31875c = eCPrivateKeyParameters.m43369c();
        if (eCParameterSpec == null) {
            this.f31876d = new ECParameterSpec(EC5Util.m27999a(b.m35647a(), b.m35651e()), new ECPoint(b.m35648b().m28409g().mo6549a(), b.m35648b().m28410h().mo6549a()), b.m35649c(), b.m35650d().intValue());
        } else {
            this.f31876d = new ECParameterSpec(EC5Util.m27999a(eCParameterSpec.m28315b(), eCParameterSpec.m28319f()), new ECPoint(eCParameterSpec.m28316c().m28409g().mo6549a(), eCParameterSpec.m28316c().m28410h().mo6549a()), eCParameterSpec.m28317d(), eCParameterSpec.m28318e().intValue());
        }
        this.f31877e = m41005a(bCDSTU4145PublicKey);
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters) {
        this.f31873a = str;
        this.f31875c = eCPrivateKeyParameters.m43369c();
        this.f31876d = null;
    }

    BCDSTU4145PrivateKey(PrivateKeyInfo privateKeyInfo) {
        m41006a(privateKeyInfo);
    }

    /* renamed from: a */
    private void m41006a(PrivateKeyInfo privateKeyInfo) {
        X962Parameters x962Parameters = new X962Parameters((ASN1Primitive) privateKeyInfo.m40112a().m40231b());
        if (x962Parameters.m40507a()) {
            ASN1ObjectIdentifier a = ASN1ObjectIdentifier.m42973a(x962Parameters.m40509c());
            X9ECParameters a2 = ECUtil.m28008a(a);
            if (a2 == null) {
                ECDomainParameters a3 = DSTU4145NamedCurves.m27212a(a);
                this.f31876d = new ECNamedCurveSpec(a.m42986b(), EC5Util.m27999a(a3.m35647a(), a3.m35651e()), new ECPoint(a3.m35648b().m28409g().mo6549a(), a3.m35648b().m28410h().mo6549a()), a3.m35649c(), a3.m35650d());
            } else {
                this.f31876d = new ECNamedCurveSpec(ECUtil.m28012b(a), EC5Util.m27999a(a2.m40516a(), a2.m40521g()), new ECPoint(a2.m40517b().m28409g().mo6549a(), a2.m40517b().m28410h().mo6549a()), a2.m40518c(), a2.m40519d());
            }
        } else if (x962Parameters.m40508b()) {
            this.f31876d = null;
        } else {
            X9ECParameters a4 = X9ECParameters.m40515a(x962Parameters.m40509c());
            this.f31876d = new ECParameterSpec(EC5Util.m27999a(a4.m40516a(), a4.m40521g()), new ECPoint(a4.m40517b().m28409g().mo6549a(), a4.m40517b().m28410h().mo6549a()), a4.m40518c(), a4.m40519d().intValue());
        }
        Object c = privateKeyInfo.m40114c();
        if (c instanceof ASN1Integer) {
            this.f31875c = ASN1Integer.m42963a(c).m42968b();
            return;
        }
        privateKeyInfo = org.spongycastle.asn1.sec.ECPrivateKey.m40165a(c);
        this.f31875c = privateKeyInfo.m40166a();
        this.f31877e = privateKeyInfo.m40167b();
    }

    public String getAlgorithm() {
        return this.f31873a;
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.f31876d;
        r0 = r0 instanceof org.spongycastle.jce.spec.ECNamedCurveSpec;
        r1 = 0;
        if (r0 == 0) goto L_0x0036;
    L_0x0007:
        r0 = r8.f31876d;
        r0 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r0;
        r0 = r0.m28314a();
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28006a(r0);
        if (r0 != 0) goto L_0x0022;
    L_0x0015:
        r0 = new org.spongycastle.asn1.ASN1ObjectIdentifier;
        r2 = r8.f31876d;
        r2 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r2;
        r2 = r2.m28314a();
        r0.<init>(r2);
    L_0x0022:
        r2 = new org.spongycastle.asn1.x9.X962Parameters;
        r2.<init>(r0);
        r0 = r8.f31876d;
        r0 = r0.getOrder();
        r3 = r8.getS();
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28005a(r0, r3);
        goto L_0x0094;
    L_0x0036:
        r0 = r8.f31876d;
        if (r0 != 0) goto L_0x004a;
    L_0x003a:
        r2 = new org.spongycastle.asn1.x9.X962Parameters;
        r0 = org.spongycastle.asn1.DERNull.f32850a;
        r2.<init>(r0);
        r0 = r8.getS();
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28005a(r1, r0);
        goto L_0x0094;
    L_0x004a:
        r0 = r8.f31876d;
        r0 = r0.getCurve();
        r3 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28001a(r0);
        r0 = new org.spongycastle.asn1.x9.X9ECParameters;
        r2 = r8.f31876d;
        r2 = r2.getGenerator();
        r4 = r8.f31874b;
        r4 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28004a(r3, r2, r4);
        r2 = r8.f31876d;
        r5 = r2.getOrder();
        r2 = r8.f31876d;
        r2 = r2.getCofactor();
        r6 = (long) r2;
        r6 = java.math.BigInteger.valueOf(r6);
        r2 = r8.f31876d;
        r2 = r2.getCurve();
        r7 = r2.getSeed();
        r2 = r0;
        r2.<init>(r3, r4, r5, r6, r7);
        r2 = new org.spongycastle.asn1.x9.X962Parameters;
        r2.<init>(r0);
        r0 = r8.f31876d;
        r0 = r0.getOrder();
        r3 = r8.getS();
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28005a(r0, r3);
    L_0x0094:
        r3 = r8.f31877e;
        if (r3 == 0) goto L_0x00a4;
    L_0x0098:
        r3 = new org.spongycastle.asn1.sec.ECPrivateKey;
        r4 = r8.getS();
        r5 = r8.f31877e;
        r3.<init>(r0, r4, r5, r2);
        goto L_0x00ad;
    L_0x00a4:
        r3 = new org.spongycastle.asn1.sec.ECPrivateKey;
        r4 = r8.getS();
        r3.<init>(r0, r4, r2);
    L_0x00ad:
        r0 = r8.f31873a;	 Catch:{ IOException -> 0x00e7 }
        r4 = "DSTU4145";	 Catch:{ IOException -> 0x00e7 }
        r0 = r0.equals(r4);	 Catch:{ IOException -> 0x00e7 }
        if (r0 == 0) goto L_0x00cc;	 Catch:{ IOException -> 0x00e7 }
    L_0x00b7:
        r0 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo;	 Catch:{ IOException -> 0x00e7 }
        r4 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x00e7 }
        r5 = org.spongycastle.asn1.ua.UAObjectIdentifiers.f22014c;	 Catch:{ IOException -> 0x00e7 }
        r2 = r2.mo5709e();	 Catch:{ IOException -> 0x00e7 }
        r4.<init>(r5, r2);	 Catch:{ IOException -> 0x00e7 }
        r2 = r3.mo5709e();	 Catch:{ IOException -> 0x00e7 }
        r0.<init>(r4, r2);	 Catch:{ IOException -> 0x00e7 }
        goto L_0x00e0;	 Catch:{ IOException -> 0x00e7 }
    L_0x00cc:
        r0 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo;	 Catch:{ IOException -> 0x00e7 }
        r4 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x00e7 }
        r5 = org.spongycastle.asn1.x9.X9ObjectIdentifiers.f22170k;	 Catch:{ IOException -> 0x00e7 }
        r2 = r2.mo5709e();	 Catch:{ IOException -> 0x00e7 }
        r4.<init>(r5, r2);	 Catch:{ IOException -> 0x00e7 }
        r2 = r3.mo5709e();	 Catch:{ IOException -> 0x00e7 }
        r0.<init>(r4, r2);	 Catch:{ IOException -> 0x00e7 }
    L_0x00e0:
        r2 = "DER";	 Catch:{ IOException -> 0x00e7 }
        r0 = r0.m34596a(r2);	 Catch:{ IOException -> 0x00e7 }
        return r0;
    L_0x00e7:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PrivateKey.getEncoded():byte[]");
    }

    public ECParameterSpec getParams() {
        return this.f31876d;
    }

    /* renamed from: b */
    public org.spongycastle.jce.spec.ECParameterSpec mo6501b() {
        if (this.f31876d == null) {
            return null;
        }
        return EC5Util.m28000a(this.f31876d, this.f31874b);
    }

    /* renamed from: c */
    org.spongycastle.jce.spec.ECParameterSpec m41011c() {
        if (this.f31876d != null) {
            return EC5Util.m28000a(this.f31876d, this.f31874b);
        }
        return BouncyCastleProvider.f27551a.mo5888a();
    }

    public BigInteger getS() {
        return this.f31875c;
    }

    /* renamed from: d */
    public BigInteger mo6502d() {
        return this.f31875c;
    }

    /* renamed from: a */
    public void mo5851a(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f31878f.mo5851a(aSN1ObjectIdentifier, aSN1Encodable);
    }

    /* renamed from: a */
    public ASN1Encodable mo5850a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f31878f.mo5850a(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public Enumeration mo5849a() {
        return this.f31878f.mo5849a();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof BCDSTU4145PrivateKey)) {
            return false;
        }
        BCDSTU4145PrivateKey bCDSTU4145PrivateKey = (BCDSTU4145PrivateKey) obj;
        if (mo6502d().equals(bCDSTU4145PrivateKey.mo6502d()) && m41011c().equals(bCDSTU4145PrivateKey.m41011c()) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return mo6502d().hashCode() ^ m41011c().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String a = Strings.m29418a();
        stringBuffer.append("EC Private Key");
        stringBuffer.append(a);
        stringBuffer.append("             S: ");
        stringBuffer.append(this.f31875c.toString(16));
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private org.spongycastle.asn1.DERBitString m41005a(org.spongycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PublicKey r1) {
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
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PrivateKey.a(org.spongycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PublicKey):org.spongycastle.asn1.DERBitString");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        m41006a(PrivateKeyInfo.m40111a(ASN1Primitive.m39798b((byte[]) objectInputStream.readObject())));
        this.f31878f = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }
}
