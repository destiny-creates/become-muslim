package org.spongycastle.jcajce.provider.asymmetric.dstu;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ua.DSTU4145Params;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Strings;

public class BCDSTU4145PublicKey implements ECPublicKey, ECPointEncoder, org.spongycastle.jce.interfaces.ECPublicKey {
    static final long serialVersionUID = 7026240464295649314L;
    /* renamed from: a */
    private String f31879a = "DSTU4145";
    /* renamed from: b */
    private boolean f31880b;
    /* renamed from: c */
    private transient ECPoint f31881c;
    /* renamed from: d */
    private transient ECParameterSpec f31882d;
    /* renamed from: e */
    private transient DSTU4145Params f31883e;

    public String getFormat() {
        return "X.509";
    }

    public BCDSTU4145PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        this.f31882d = eCPublicKeySpec.getParams();
        this.f31881c = EC5Util.m28003a(this.f31882d, eCPublicKeySpec.getW(), false);
    }

    public BCDSTU4145PublicKey(org.spongycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec) {
        this.f31881c = eCPublicKeySpec.m36252b();
        if (eCPublicKeySpec.m28309a() != null) {
            this.f31882d = EC5Util.m27996a(EC5Util.m27999a(eCPublicKeySpec.m28309a().m28315b(), eCPublicKeySpec.m28309a().m28319f()), eCPublicKeySpec.m28309a());
            return;
        }
        if (this.f31881c.m28406d() == null) {
            this.f31881c = BouncyCastleProvider.f27551a.mo5888a().m28315b().m28376b(this.f31881c.m28409g().mo6549a(), this.f31881c.m28410h().mo6549a());
        }
        this.f31882d = null;
    }

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        ECDomainParameters b = eCPublicKeyParameters.m40792b();
        this.f31879a = str;
        this.f31881c = eCPublicKeyParameters.m43370c();
        if (eCParameterSpec == null) {
            this.f31882d = m41013a(EC5Util.m27999a(b.m35647a(), b.m35651e()), b);
        } else {
            this.f31882d = eCParameterSpec;
        }
    }

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECDomainParameters b = eCPublicKeyParameters.m40792b();
        this.f31879a = str;
        this.f31881c = eCPublicKeyParameters.m43370c();
        if (eCParameterSpec == null) {
            this.f31882d = m41013a(EC5Util.m27999a(b.m35647a(), b.m35651e()), b);
        } else {
            this.f31882d = EC5Util.m27996a(EC5Util.m27999a(eCParameterSpec.m28315b(), eCParameterSpec.m28319f()), eCParameterSpec);
        }
    }

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters) {
        this.f31879a = str;
        this.f31881c = eCPublicKeyParameters.m43370c();
        this.f31882d = null;
    }

    /* renamed from: a */
    private ECParameterSpec m41013a(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, new java.security.spec.ECPoint(eCDomainParameters.m35648b().m28409g().mo6549a(), eCDomainParameters.m35648b().m28410h().mo6549a()), eCDomainParameters.m35649c(), eCDomainParameters.m35650d().intValue());
    }

    BCDSTU4145PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m41014a(subjectPublicKeyInfo);
    }

    /* renamed from: a */
    private void m41015a(byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b = bArr[i];
            bArr[i] = bArr[(bArr.length - 1) - i];
            bArr[(bArr.length - 1) - i] = b;
        }
    }

    /* renamed from: a */
    private void m41014a(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r12 = this;
        r0 = r13.m40413d();
        r1 = "DSTU4145";
        r12.f31879a = r1;
        r0 = r0.m43059c();	 Catch:{ IOException -> 0x0152 }
        r0 = org.spongycastle.asn1.ASN1Primitive.m39798b(r0);	 Catch:{ IOException -> 0x0152 }
        r0 = (org.spongycastle.asn1.ASN1OctetString) r0;	 Catch:{ IOException -> 0x0152 }
        r0 = r0.mo6859c();
        r1 = r13.m40410a();
        r1 = r1.m40230a();
        r2 = org.spongycastle.asn1.ua.UAObjectIdentifiers.f22013b;
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0029;
    L_0x0026:
        r12.m41015a(r0);
    L_0x0029:
        r1 = r13.m40410a();
        r1 = r1.m40231b();
        r1 = (org.spongycastle.asn1.ASN1Sequence) r1;
        r1 = org.spongycastle.asn1.ua.DSTU4145Params.m40193a(r1);
        r12.f31883e = r1;
        r1 = r12.f31883e;
        r1 = r1.m40195a();
        if (r1 == 0) goto L_0x006a;
    L_0x0041:
        r13 = r12.f31883e;
        r13 = r13.m40199g();
        r1 = org.spongycastle.asn1.ua.DSTU4145NamedCurves.m27212a(r13);
        r9 = new org.spongycastle.jce.spec.ECNamedCurveParameterSpec;
        r3 = r13.m42986b();
        r4 = r1.m35647a();
        r5 = r1.m35648b();
        r6 = r1.m35649c();
        r7 = r1.m35650d();
        r8 = r1.m35651e();
        r2 = r9;
        r2.<init>(r3, r4, r5, r6, r7, r8);
        goto L_0x00cf;
    L_0x006a:
        r1 = r12.f31883e;
        r1 = r1.m40196b();
        r2 = r1.m40189c();
        r3 = r13.m40410a();
        r3 = r3.m40230a();
        r4 = org.spongycastle.asn1.ua.UAObjectIdentifiers.f22013b;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0087;
    L_0x0084:
        r12.m41015a(r2);
    L_0x0087:
        r3 = r1.m40187a();
        r11 = new org.spongycastle.math.ec.ECCurve$F2m;
        r5 = r3.m40181a();
        r6 = r3.m40182b();
        r7 = r3.m40183c();
        r8 = r3.m40184d();
        r9 = r1.m40188b();
        r10 = new java.math.BigInteger;
        r3 = 1;
        r10.<init>(r3, r2);
        r4 = r11;
        r4.<init>(r5, r6, r7, r8, r9, r10);
        r2 = r1.m40192g();
        r13 = r13.m40410a();
        r13 = r13.m40230a();
        r3 = org.spongycastle.asn1.ua.UAObjectIdentifiers.f22013b;
        r13 = r13.equals(r3);
        if (r13 == 0) goto L_0x00c2;
    L_0x00bf:
        r12.m41015a(r2);
    L_0x00c2:
        r9 = new org.spongycastle.jce.spec.ECParameterSpec;
        r13 = org.spongycastle.asn1.ua.DSTU4145PointEncoder.m27215a(r11, r2);
        r1 = r1.m40190d();
        r9.<init>(r11, r13, r1);
    L_0x00cf:
        r13 = r9.m28315b();
        r1 = r9.m28319f();
        r4 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m27999a(r13, r1);
        r13 = org.spongycastle.asn1.ua.DSTU4145PointEncoder.m27215a(r13, r0);
        r12.f31881c = r13;
        r13 = r12.f31883e;
        r13 = r13.m40195a();
        if (r13 == 0) goto L_0x0121;
    L_0x00e9:
        r13 = new org.spongycastle.jce.spec.ECNamedCurveSpec;
        r0 = r12.f31883e;
        r0 = r0.m40199g();
        r3 = r0.m42986b();
        r5 = new java.security.spec.ECPoint;
        r0 = r9.m28316c();
        r0 = r0.m28409g();
        r0 = r0.mo6549a();
        r1 = r9.m28316c();
        r1 = r1.m28410h();
        r1 = r1.mo6549a();
        r5.<init>(r0, r1);
        r6 = r9.m28317d();
        r7 = r9.m28318e();
        r2 = r13;
        r2.<init>(r3, r4, r5, r6, r7);
        r12.f31882d = r13;
        goto L_0x0151;
    L_0x0121:
        r13 = new java.security.spec.ECParameterSpec;
        r0 = new java.security.spec.ECPoint;
        r1 = r9.m28316c();
        r1 = r1.m28409g();
        r1 = r1.mo6549a();
        r2 = r9.m28316c();
        r2 = r2.m28410h();
        r2 = r2.mo6549a();
        r0.<init>(r1, r2);
        r1 = r9.m28317d();
        r2 = r9.m28318e();
        r2 = r2.intValue();
        r13.<init>(r4, r0, r1, r2);
        r12.f31882d = r13;
    L_0x0151:
        return;
    L_0x0152:
        r13 = new java.lang.IllegalArgumentException;
        r0 = "error recovering public key";
        r13.<init>(r0);
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PublicKey.a(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    /* renamed from: a */
    public byte[] m41016a() {
        if (this.f31883e != null) {
            return this.f31883e.m40197c();
        }
        return DSTU4145Params.m40194d();
    }

    public String getAlgorithm() {
        return this.f31879a;
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.f31883e;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r0 = r7.f31883e;
        goto L_0x005d;
    L_0x0007:
        r0 = r7.f31882d;
        r0 = r0 instanceof org.spongycastle.jce.spec.ECNamedCurveSpec;
        if (r0 == 0) goto L_0x0020;
    L_0x000d:
        r0 = new org.spongycastle.asn1.ua.DSTU4145Params;
        r1 = new org.spongycastle.asn1.ASN1ObjectIdentifier;
        r2 = r7.f31882d;
        r2 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r2;
        r2 = r2.m28314a();
        r1.<init>(r2);
        r0.<init>(r1);
        goto L_0x005d;
    L_0x0020:
        r0 = r7.f31882d;
        r0 = r0.getCurve();
        r2 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28001a(r0);
        r0 = new org.spongycastle.asn1.x9.X9ECParameters;
        r1 = r7.f31882d;
        r1 = r1.getGenerator();
        r3 = r7.f31880b;
        r3 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28004a(r2, r1, r3);
        r1 = r7.f31882d;
        r4 = r1.getOrder();
        r1 = r7.f31882d;
        r1 = r1.getCofactor();
        r5 = (long) r1;
        r5 = java.math.BigInteger.valueOf(r5);
        r1 = r7.f31882d;
        r1 = r1.getCurve();
        r6 = r1.getSeed();
        r1 = r0;
        r1.<init>(r2, r3, r4, r5, r6);
        r1 = new org.spongycastle.asn1.x9.X962Parameters;
        r1.<init>(r0);
        r0 = r1;
    L_0x005d:
        r1 = r7.f31881c;
        r1 = org.spongycastle.asn1.ua.DSTU4145PointEncoder.m27216a(r1);
        r2 = new org.spongycastle.asn1.x509.SubjectPublicKeyInfo;	 Catch:{ IOException -> 0x0079 }
        r3 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x0079 }
        r4 = org.spongycastle.asn1.ua.UAObjectIdentifiers.f22014c;	 Catch:{ IOException -> 0x0079 }
        r3.<init>(r4, r0);	 Catch:{ IOException -> 0x0079 }
        r0 = new org.spongycastle.asn1.DEROctetString;	 Catch:{ IOException -> 0x0079 }
        r0.<init>(r1);	 Catch:{ IOException -> 0x0079 }
        r2.<init>(r3, r0);	 Catch:{ IOException -> 0x0079 }
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil.m28019a(r2);
        return r0;
    L_0x0079:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PublicKey.getEncoded():byte[]");
    }

    public ECParameterSpec getParams() {
        return this.f31882d;
    }

    /* renamed from: b */
    public org.spongycastle.jce.spec.ECParameterSpec mo6501b() {
        if (this.f31882d == null) {
            return null;
        }
        return EC5Util.m28000a(this.f31882d, this.f31880b);
    }

    public java.security.spec.ECPoint getW() {
        return new java.security.spec.ECPoint(this.f31881c.m28409g().mo6549a(), this.f31881c.m28410h().mo6549a());
    }

    /* renamed from: c */
    public ECPoint mo6503c() {
        if (this.f31882d == null) {
            return this.f31881c.m28403c();
        }
        return this.f31881c;
    }

    /* renamed from: d */
    public ECPoint m41019d() {
        return this.f31881c;
    }

    /* renamed from: e */
    org.spongycastle.jce.spec.ECParameterSpec m41020e() {
        if (this.f31882d != null) {
            return EC5Util.m28000a(this.f31882d, this.f31880b);
        }
        return BouncyCastleProvider.f27551a.mo5888a();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String a = Strings.m29418a();
        stringBuffer.append("EC Public Key");
        stringBuffer.append(a);
        stringBuffer.append("            X: ");
        stringBuffer.append(this.f31881c.m28409g().mo6549a().toString(16));
        stringBuffer.append(a);
        stringBuffer.append("            Y: ");
        stringBuffer.append(this.f31881c.m28410h().mo6549a().toString(16));
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof BCDSTU4145PublicKey)) {
            return false;
        }
        BCDSTU4145PublicKey bCDSTU4145PublicKey = (BCDSTU4145PublicKey) obj;
        if (m41019d().m28397a(bCDSTU4145PublicKey.m41019d()) && m41020e().equals(bCDSTU4145PublicKey.m41020e()) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return m41019d().hashCode() ^ m41020e().hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        m41014a(SubjectPublicKeyInfo.m40409a(ASN1Primitive.m39798b((byte[]) objectInputStream.readObject())));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }
}
