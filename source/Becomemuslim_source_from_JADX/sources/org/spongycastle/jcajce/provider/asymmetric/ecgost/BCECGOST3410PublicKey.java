package org.spongycastle.jcajce.provider.asymmetric.ecgost;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Strings;

public class BCECGOST3410PublicKey implements ECPublicKey, ECPointEncoder, org.spongycastle.jce.interfaces.ECPublicKey {
    static final long serialVersionUID = 7026240464295649314L;
    /* renamed from: a */
    private String f31905a = "ECGOST3410";
    /* renamed from: b */
    private boolean f31906b;
    /* renamed from: c */
    private transient ECPoint f31907c;
    /* renamed from: d */
    private transient ECParameterSpec f31908d;
    /* renamed from: e */
    private transient GOST3410PublicKeyAlgParameters f31909e;

    public String getFormat() {
        return "X.509";
    }

    public BCECGOST3410PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        this.f31908d = eCPublicKeySpec.getParams();
        this.f31907c = EC5Util.m28003a(this.f31908d, eCPublicKeySpec.getW(), false);
    }

    public BCECGOST3410PublicKey(org.spongycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec) {
        this.f31907c = eCPublicKeySpec.m36252b();
        if (eCPublicKeySpec.m28309a() != null) {
            this.f31908d = EC5Util.m27996a(EC5Util.m27999a(eCPublicKeySpec.m28309a().m28315b(), eCPublicKeySpec.m28309a().m28319f()), eCPublicKeySpec.m28309a());
            return;
        }
        if (this.f31907c.m28406d() == null) {
            this.f31907c = BouncyCastleProvider.f27551a.mo5888a().m28315b().m28376b(this.f31907c.m28409g().mo6549a(), this.f31907c.m28410h().mo6549a());
        }
        this.f31908d = null;
    }

    public BCECGOST3410PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        ECDomainParameters b = eCPublicKeyParameters.m40792b();
        this.f31905a = str;
        this.f31907c = eCPublicKeyParameters.m43370c();
        if (eCParameterSpec == null) {
            this.f31908d = m41049a(EC5Util.m27999a(b.m35647a(), b.m35651e()), b);
        } else {
            this.f31908d = eCParameterSpec;
        }
    }

    public BCECGOST3410PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECDomainParameters b = eCPublicKeyParameters.m40792b();
        this.f31905a = str;
        this.f31907c = eCPublicKeyParameters.m43370c();
        if (eCParameterSpec == null) {
            this.f31908d = m41049a(EC5Util.m27999a(b.m35647a(), b.m35651e()), b);
        } else {
            this.f31908d = EC5Util.m27996a(EC5Util.m27999a(eCParameterSpec.m28315b(), eCParameterSpec.m28319f()), eCParameterSpec);
        }
    }

    public BCECGOST3410PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters) {
        this.f31905a = str;
        this.f31907c = eCPublicKeyParameters.m43370c();
        this.f31908d = null;
    }

    /* renamed from: a */
    private ECParameterSpec m41049a(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, new java.security.spec.ECPoint(eCDomainParameters.m35648b().m28409g().mo6549a(), eCDomainParameters.m35648b().m28410h().mo6549a()), eCDomainParameters.m35649c(), eCDomainParameters.m35650d().intValue());
    }

    BCECGOST3410PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m41050a(subjectPublicKeyInfo);
    }

    /* renamed from: a */
    private void m41050a(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = r11.m40413d();
        r1 = "ECGOST3410";
        r10.f31905a = r1;
        r0 = r0.m43059c();	 Catch:{ IOException -> 0x00a7 }
        r0 = org.spongycastle.asn1.ASN1Primitive.m39798b(r0);	 Catch:{ IOException -> 0x00a7 }
        r0 = (org.spongycastle.asn1.ASN1OctetString) r0;	 Catch:{ IOException -> 0x00a7 }
        r0 = r0.mo6859c();
        r1 = 32;
        r2 = new byte[r1];
        r1 = new byte[r1];
        r3 = 0;
        r4 = 0;
    L_0x001e:
        r5 = r2.length;
        if (r4 == r5) goto L_0x002a;
    L_0x0021:
        r5 = 31 - r4;
        r5 = r0[r5];
        r2[r4] = r5;
        r4 = r4 + 1;
        goto L_0x001e;
    L_0x002a:
        r4 = r1.length;
        if (r3 == r4) goto L_0x0036;
    L_0x002d:
        r4 = 63 - r3;
        r4 = r0[r4];
        r1[r3] = r4;
        r3 = r3 + 1;
        goto L_0x002a;
    L_0x0036:
        r11 = r11.m40410a();
        r11 = r11.m40231b();
        r11 = org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters.m39948a(r11);
        r10.f31909e = r11;
        r11 = r10.f31909e;
        r11 = r11.m39949a();
        r11 = org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves.m27182b(r11);
        r11 = org.spongycastle.jce.ECGOST3410NamedCurveTable.m28120a(r11);
        r0 = r11.m28315b();
        r3 = r11.m28319f();
        r6 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m27999a(r0, r3);
        r3 = new java.math.BigInteger;
        r4 = 1;
        r3.<init>(r4, r2);
        r2 = new java.math.BigInteger;
        r2.<init>(r4, r1);
        r0 = r0.m28376b(r3, r2);
        r10.f31907c = r0;
        r0 = new org.spongycastle.jce.spec.ECNamedCurveSpec;
        r1 = r10.f31909e;
        r1 = r1.m39949a();
        r5 = org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves.m27182b(r1);
        r7 = new java.security.spec.ECPoint;
        r1 = r11.m28316c();
        r1 = r1.m28409g();
        r1 = r1.mo6549a();
        r2 = r11.m28316c();
        r2 = r2.m28410h();
        r2 = r2.mo6549a();
        r7.<init>(r1, r2);
        r8 = r11.m28317d();
        r9 = r11.m28318e();
        r4 = r0;
        r4.<init>(r5, r6, r7, r8, r9);
        r10.f31908d = r0;
        return;
    L_0x00a7:
        r11 = new java.lang.IllegalArgumentException;
        r0 = "error recovering public key";
        r11.<init>(r0);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ecgost.BCECGOST3410PublicKey.a(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    public String getAlgorithm() {
        return this.f31905a;
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.f31909e;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r0 = r7.f31909e;
        goto L_0x005e;
    L_0x0007:
        r0 = r7.f31908d;
        r0 = r0 instanceof org.spongycastle.jce.spec.ECNamedCurveSpec;
        if (r0 == 0) goto L_0x0021;
    L_0x000d:
        r0 = new org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
        r1 = r7.f31908d;
        r1 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r1;
        r1 = r1.m28314a();
        r1 = org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves.m27183b(r1);
        r2 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.f21567m;
        r0.<init>(r1, r2);
        goto L_0x005e;
    L_0x0021:
        r0 = r7.f31908d;
        r0 = r0.getCurve();
        r2 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28001a(r0);
        r0 = new org.spongycastle.asn1.x9.X9ECParameters;
        r1 = r7.f31908d;
        r1 = r1.getGenerator();
        r3 = r7.f31906b;
        r3 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28004a(r2, r1, r3);
        r1 = r7.f31908d;
        r4 = r1.getOrder();
        r1 = r7.f31908d;
        r1 = r1.getCofactor();
        r5 = (long) r1;
        r5 = java.math.BigInteger.valueOf(r5);
        r1 = r7.f31908d;
        r1 = r1.getCurve();
        r6 = r1.getSeed();
        r1 = r0;
        r1.<init>(r2, r3, r4, r5, r6);
        r1 = new org.spongycastle.asn1.x9.X962Parameters;
        r1.<init>(r0);
        r0 = r1;
    L_0x005e:
        r1 = r7.f31907c;
        r1 = r1.m28409g();
        r1 = r1.mo6549a();
        r2 = r7.f31907c;
        r2 = r2.m28410h();
        r2 = r2.mo6549a();
        r3 = 64;
        r3 = new byte[r3];
        r4 = 0;
        r7.m41051a(r3, r4, r1);
        r1 = 32;
        r7.m41051a(r3, r1, r2);
        r1 = new org.spongycastle.asn1.x509.SubjectPublicKeyInfo;	 Catch:{ IOException -> 0x0095 }
        r2 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x0095 }
        r4 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.f21564j;	 Catch:{ IOException -> 0x0095 }
        r2.<init>(r4, r0);	 Catch:{ IOException -> 0x0095 }
        r0 = new org.spongycastle.asn1.DEROctetString;	 Catch:{ IOException -> 0x0095 }
        r0.<init>(r3);	 Catch:{ IOException -> 0x0095 }
        r1.<init>(r2, r0);	 Catch:{ IOException -> 0x0095 }
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil.m28019a(r1);
        return r0;
    L_0x0095:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ecgost.BCECGOST3410PublicKey.getEncoded():byte[]");
    }

    /* renamed from: a */
    private void m41051a(byte[] bArr, int i, BigInteger bigInteger) {
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
        return this.f31908d;
    }

    /* renamed from: b */
    public org.spongycastle.jce.spec.ECParameterSpec mo6501b() {
        if (this.f31908d == null) {
            return null;
        }
        return EC5Util.m28000a(this.f31908d, this.f31906b);
    }

    public java.security.spec.ECPoint getW() {
        return new java.security.spec.ECPoint(this.f31907c.m28409g().mo6549a(), this.f31907c.m28410h().mo6549a());
    }

    /* renamed from: c */
    public ECPoint mo6503c() {
        if (this.f31908d == null) {
            return this.f31907c.m28403c();
        }
        return this.f31907c;
    }

    /* renamed from: a */
    public ECPoint m41052a() {
        return this.f31907c;
    }

    /* renamed from: d */
    org.spongycastle.jce.spec.ECParameterSpec m41055d() {
        if (this.f31908d != null) {
            return EC5Util.m28000a(this.f31908d, this.f31906b);
        }
        return BouncyCastleProvider.f27551a.mo5888a();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String a = Strings.m29418a();
        stringBuffer.append("EC Public Key");
        stringBuffer.append(a);
        stringBuffer.append("            X: ");
        stringBuffer.append(this.f31907c.m28409g().mo6549a().toString(16));
        stringBuffer.append(a);
        stringBuffer.append("            Y: ");
        stringBuffer.append(this.f31907c.m28410h().mo6549a().toString(16));
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof BCECGOST3410PublicKey)) {
            return false;
        }
        BCECGOST3410PublicKey bCECGOST3410PublicKey = (BCECGOST3410PublicKey) obj;
        if (m41052a().m28397a(bCECGOST3410PublicKey.m41052a()) && m41055d().equals(bCECGOST3410PublicKey.m41055d()) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return m41052a().hashCode() ^ m41055d().hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        m41050a(SubjectPublicKeyInfo.m40409a(ASN1Primitive.m39798b((byte[]) objectInputStream.readObject())));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: e */
    public GOST3410PublicKeyAlgParameters m41056e() {
        return this.f31909e;
    }
}
