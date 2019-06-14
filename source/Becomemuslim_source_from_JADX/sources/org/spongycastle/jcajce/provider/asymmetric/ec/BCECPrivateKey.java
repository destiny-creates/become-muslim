package org.spongycastle.jcajce.provider.asymmetric.ec;

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
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECPrivateKeySpec;
import org.spongycastle.util.Strings;

public class BCECPrivateKey implements ECPrivateKey, ECPointEncoder, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 994553197664784084L;
    /* renamed from: a */
    private String f31884a = "EC";
    /* renamed from: b */
    private boolean f31885b;
    /* renamed from: c */
    private transient BigInteger f31886c;
    /* renamed from: d */
    private transient ECParameterSpec f31887d;
    /* renamed from: e */
    private transient ProviderConfiguration f31888e;
    /* renamed from: f */
    private transient DERBitString f31889f;
    /* renamed from: g */
    private transient PKCS12BagAttributeCarrierImpl f31890g = new PKCS12BagAttributeCarrierImpl();

    public String getFormat() {
        return "PKCS#8";
    }

    protected BCECPrivateKey() {
    }

    public BCECPrivateKey(ECPrivateKey eCPrivateKey, ProviderConfiguration providerConfiguration) {
        this.f31886c = eCPrivateKey.getS();
        this.f31884a = eCPrivateKey.getAlgorithm();
        this.f31887d = eCPrivateKey.getParams();
        this.f31888e = providerConfiguration;
    }

    public BCECPrivateKey(String str, ECPrivateKeySpec eCPrivateKeySpec, ProviderConfiguration providerConfiguration) {
        this.f31884a = str;
        this.f31886c = eCPrivateKeySpec.m36251b();
        if (eCPrivateKeySpec.m28309a() != null) {
            this.f31887d = EC5Util.m27996a(EC5Util.m27999a(eCPrivateKeySpec.m28309a().m28315b(), eCPrivateKeySpec.m28309a().m28319f()), eCPrivateKeySpec.m28309a());
        } else {
            this.f31887d = null;
        }
        this.f31888e = providerConfiguration;
    }

    public BCECPrivateKey(String str, java.security.spec.ECPrivateKeySpec eCPrivateKeySpec, ProviderConfiguration providerConfiguration) {
        this.f31884a = str;
        this.f31886c = eCPrivateKeySpec.getS();
        this.f31887d = eCPrivateKeySpec.getParams();
        this.f31888e = providerConfiguration;
    }

    public BCECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECPublicKey bCECPublicKey, ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        ECDomainParameters b = eCPrivateKeyParameters.m40792b();
        this.f31884a = str;
        this.f31886c = eCPrivateKeyParameters.m43369c();
        this.f31888e = providerConfiguration;
        if (eCParameterSpec == null) {
            this.f31887d = new ECParameterSpec(EC5Util.m27999a(b.m35647a(), b.m35651e()), new ECPoint(b.m35648b().m28409g().mo6549a(), b.m35648b().m28410h().mo6549a()), b.m35649c(), b.m35650d().intValue());
        } else {
            this.f31887d = eCParameterSpec;
        }
        this.f31889f = m41024a(bCECPublicKey);
    }

    public BCECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCECPublicKey bCECPublicKey, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        ECDomainParameters b = eCPrivateKeyParameters.m40792b();
        this.f31884a = str;
        this.f31886c = eCPrivateKeyParameters.m43369c();
        this.f31888e = providerConfiguration;
        if (eCParameterSpec == null) {
            this.f31887d = new ECParameterSpec(EC5Util.m27999a(b.m35647a(), b.m35651e()), new ECPoint(b.m35648b().m28409g().mo6549a(), b.m35648b().m28410h().mo6549a()), b.m35649c(), b.m35650d().intValue());
        } else {
            this.f31887d = EC5Util.m27996a(EC5Util.m27999a(eCParameterSpec.m28315b(), eCParameterSpec.m28319f()), eCParameterSpec);
        }
        this.f31889f = m41024a(bCECPublicKey);
    }

    public BCECPrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, ProviderConfiguration providerConfiguration) {
        this.f31884a = str;
        this.f31886c = eCPrivateKeyParameters.m43369c();
        this.f31887d = null;
        this.f31888e = providerConfiguration;
    }

    BCECPrivateKey(String str, PrivateKeyInfo privateKeyInfo, ProviderConfiguration providerConfiguration) {
        this.f31884a = str;
        this.f31888e = providerConfiguration;
        m41025a(privateKeyInfo);
    }

    /* renamed from: a */
    private void m41025a(PrivateKeyInfo privateKeyInfo) {
        X962Parameters a = X962Parameters.m40506a(privateKeyInfo.m40112a().m40231b());
        this.f31887d = EC5Util.m27997a(a, EC5Util.m28002a(this.f31888e, a));
        Object c = privateKeyInfo.m40114c();
        if (c instanceof ASN1Integer) {
            this.f31886c = ASN1Integer.m42963a(c).m42968b();
            return;
        }
        privateKeyInfo = org.spongycastle.asn1.sec.ECPrivateKey.m40165a(c);
        this.f31886c = privateKeyInfo.m40166a();
        this.f31889f = privateKeyInfo.m40167b();
    }

    public String getAlgorithm() {
        return this.f31884a;
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.f31887d;
        r0 = r0 instanceof org.spongycastle.jce.spec.ECNamedCurveSpec;
        r1 = 0;
        if (r0 == 0) goto L_0x0036;
    L_0x0007:
        r0 = r8.f31887d;
        r0 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r0;
        r0 = r0.m28314a();
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28006a(r0);
        if (r0 != 0) goto L_0x0022;
    L_0x0015:
        r0 = new org.spongycastle.asn1.ASN1ObjectIdentifier;
        r2 = r8.f31887d;
        r2 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r2;
        r2 = r2.m28314a();
        r0.<init>(r2);
    L_0x0022:
        r2 = new org.spongycastle.asn1.x9.X962Parameters;
        r2.<init>(r0);
        r0 = r8.f31887d;
        r0 = r0.getOrder();
        r3 = r8.getS();
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28005a(r0, r3);
        goto L_0x0094;
    L_0x0036:
        r0 = r8.f31887d;
        if (r0 != 0) goto L_0x004a;
    L_0x003a:
        r2 = new org.spongycastle.asn1.x9.X962Parameters;
        r0 = org.spongycastle.asn1.DERNull.f32850a;
        r2.<init>(r0);
        r0 = r8.getS();
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28005a(r1, r0);
        goto L_0x0094;
    L_0x004a:
        r0 = r8.f31887d;
        r0 = r0.getCurve();
        r3 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28001a(r0);
        r0 = new org.spongycastle.asn1.x9.X9ECParameters;
        r2 = r8.f31887d;
        r2 = r2.getGenerator();
        r4 = r8.f31885b;
        r4 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28004a(r3, r2, r4);
        r2 = r8.f31887d;
        r5 = r2.getOrder();
        r2 = r8.f31887d;
        r2 = r2.getCofactor();
        r6 = (long) r2;
        r6 = java.math.BigInteger.valueOf(r6);
        r2 = r8.f31887d;
        r2 = r2.getCurve();
        r7 = r2.getSeed();
        r2 = r0;
        r2.<init>(r3, r4, r5, r6, r7);
        r2 = new org.spongycastle.asn1.x9.X962Parameters;
        r2.<init>(r0);
        r0 = r8.f31887d;
        r0 = r0.getOrder();
        r3 = r8.getS();
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28005a(r0, r3);
    L_0x0094:
        r3 = r8.f31889f;
        if (r3 == 0) goto L_0x00a4;
    L_0x0098:
        r3 = new org.spongycastle.asn1.sec.ECPrivateKey;
        r4 = r8.getS();
        r5 = r8.f31889f;
        r3.<init>(r0, r4, r5, r2);
        goto L_0x00ad;
    L_0x00a4:
        r3 = new org.spongycastle.asn1.sec.ECPrivateKey;
        r4 = r8.getS();
        r3.<init>(r0, r4, r2);
    L_0x00ad:
        r0 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo;	 Catch:{ IOException -> 0x00c0 }
        r4 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x00c0 }
        r5 = org.spongycastle.asn1.x9.X9ObjectIdentifiers.f22170k;	 Catch:{ IOException -> 0x00c0 }
        r4.<init>(r5, r2);	 Catch:{ IOException -> 0x00c0 }
        r0.<init>(r4, r3);	 Catch:{ IOException -> 0x00c0 }
        r2 = "DER";	 Catch:{ IOException -> 0x00c0 }
        r0 = r0.m34596a(r2);	 Catch:{ IOException -> 0x00c0 }
        return r0;
    L_0x00c0:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey.getEncoded():byte[]");
    }

    public ECParameterSpec getParams() {
        return this.f31887d;
    }

    /* renamed from: b */
    public org.spongycastle.jce.spec.ECParameterSpec mo6501b() {
        if (this.f31887d == null) {
            return null;
        }
        return EC5Util.m28000a(this.f31887d, this.f31885b);
    }

    /* renamed from: c */
    org.spongycastle.jce.spec.ECParameterSpec m41030c() {
        if (this.f31887d != null) {
            return EC5Util.m28000a(this.f31887d, this.f31885b);
        }
        return this.f31888e.mo5888a();
    }

    public BigInteger getS() {
        return this.f31886c;
    }

    /* renamed from: d */
    public BigInteger mo6502d() {
        return this.f31886c;
    }

    /* renamed from: a */
    public void mo5851a(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f31890g.mo5851a(aSN1ObjectIdentifier, aSN1Encodable);
    }

    /* renamed from: a */
    public ASN1Encodable mo5850a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f31890g.mo5850a(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public Enumeration mo5849a() {
        return this.f31890g.mo5849a();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof BCECPrivateKey)) {
            return false;
        }
        BCECPrivateKey bCECPrivateKey = (BCECPrivateKey) obj;
        if (mo6502d().equals(bCECPrivateKey.mo6502d()) && m41030c().equals(bCECPrivateKey.m41030c()) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return mo6502d().hashCode() ^ m41030c().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String a = Strings.m29418a();
        stringBuffer.append("EC Private Key");
        stringBuffer.append(a);
        stringBuffer.append("             S: ");
        stringBuffer.append(this.f31886c.toString(16));
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private org.spongycastle.asn1.DERBitString m41024a(org.spongycastle.jcajce.provider.asymmetric.ec.BCECPublicKey r1) {
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
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey.a(org.spongycastle.jcajce.provider.asymmetric.ec.BCECPublicKey):org.spongycastle.asn1.DERBitString");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        m41025a(PrivateKeyInfo.m40111a(ASN1Primitive.m39798b((byte[]) objectInputStream.readObject())));
        this.f31888e = BouncyCastleProvider.f27551a;
        this.f31890g = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }
}
