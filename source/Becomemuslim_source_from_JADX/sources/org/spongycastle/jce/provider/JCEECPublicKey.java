package org.spongycastle.jce.provider;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Strings;

public class JCEECPublicKey implements ECPublicKey, ECPointEncoder, org.spongycastle.jce.interfaces.ECPublicKey {
    /* renamed from: a */
    private String f32002a;
    /* renamed from: b */
    private ECPoint f32003b;
    /* renamed from: c */
    private ECParameterSpec f32004c;
    /* renamed from: d */
    private boolean f32005d;
    /* renamed from: e */
    private GOST3410PublicKeyAlgParameters f32006e;

    public String getFormat() {
        return "X.509";
    }

    /* renamed from: a */
    private void m41126a(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r12 = this;
        r0 = r13.m40411b();
        r0 = r0.m40230a();
        r1 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.f21564j;
        r0 = r0.equals(r1);
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x00c4;
    L_0x0012:
        r0 = r13.m40413d();
        r3 = "ECGOST3410";
        r12.f32002a = r3;
        r0 = r0.m43059c();	 Catch:{ IOException -> 0x00bc }
        r0 = org.spongycastle.asn1.ASN1Primitive.m39798b(r0);	 Catch:{ IOException -> 0x00bc }
        r0 = (org.spongycastle.asn1.ASN1OctetString) r0;	 Catch:{ IOException -> 0x00bc }
        r0 = r0.mo6859c();
        r3 = 32;
        r4 = new byte[r3];
        r3 = new byte[r3];
        r5 = 0;
    L_0x002f:
        r6 = r4.length;
        if (r5 == r6) goto L_0x003b;
    L_0x0032:
        r6 = 31 - r5;
        r6 = r0[r6];
        r4[r5] = r6;
        r5 = r5 + 1;
        goto L_0x002f;
    L_0x003b:
        r5 = 0;
    L_0x003c:
        r6 = r3.length;
        if (r5 == r6) goto L_0x0048;
    L_0x003f:
        r6 = 63 - r5;
        r6 = r0[r6];
        r3[r5] = r6;
        r5 = r5 + 1;
        goto L_0x003c;
    L_0x0048:
        r0 = new org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
        r13 = r13.m40411b();
        r13 = r13.m40231b();
        r13 = (org.spongycastle.asn1.ASN1Sequence) r13;
        r0.<init>(r13);
        r12.f32006e = r0;
        r13 = r12.f32006e;
        r13 = r13.m39949a();
        r13 = org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves.m27182b(r13);
        r13 = org.spongycastle.jce.ECGOST3410NamedCurveTable.m28120a(r13);
        r0 = r13.m28315b();
        r5 = r13.m28319f();
        r8 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m27999a(r0, r5);
        r5 = new java.math.BigInteger;
        r5.<init>(r2, r4);
        r4 = new java.math.BigInteger;
        r4.<init>(r2, r3);
        r0 = r0.mo5902b(r5, r4, r1);
        r12.f32003b = r0;
        r0 = new org.spongycastle.jce.spec.ECNamedCurveSpec;
        r1 = r12.f32006e;
        r1 = r1.m39949a();
        r7 = org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves.m27182b(r1);
        r9 = new java.security.spec.ECPoint;
        r1 = r13.m28316c();
        r1 = r1.m28409g();
        r1 = r1.mo6549a();
        r2 = r13.m28316c();
        r2 = r2.m28410h();
        r2 = r2.mo6549a();
        r9.<init>(r1, r2);
        r10 = r13.m28317d();
        r11 = r13.m28318e();
        r6 = r0;
        r6.<init>(r7, r8, r9, r10, r11);
        r12.f32004c = r0;
        goto L_0x01c3;
    L_0x00bc:
        r13 = new java.lang.IllegalArgumentException;
        r0 = "error recovering public key";
        r13.<init>(r0);
        throw r13;
    L_0x00c4:
        r0 = new org.spongycastle.asn1.x9.X962Parameters;
        r3 = r13.m40411b();
        r3 = r3.m40231b();
        r3 = (org.spongycastle.asn1.ASN1Primitive) r3;
        r0.<init>(r3);
        r3 = r0.m40507a();
        if (r3 == 0) goto L_0x0121;
    L_0x00d9:
        r0 = r0.m40509c();
        r0 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r0;
        r3 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28008a(r0);
        r4 = r3.m40516a();
        r5 = r3.m40521g();
        r8 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m27999a(r4, r5);
        r5 = new org.spongycastle.jce.spec.ECNamedCurveSpec;
        r7 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28012b(r0);
        r9 = new java.security.spec.ECPoint;
        r0 = r3.m40517b();
        r0 = r0.m28409g();
        r0 = r0.mo6549a();
        r6 = r3.m40517b();
        r6 = r6.m28410h();
        r6 = r6.mo6549a();
        r9.<init>(r0, r6);
        r10 = r3.m40518c();
        r11 = r3.m40519d();
        r6 = r5;
        r6.<init>(r7, r8, r9, r10, r11);
        r12.f32004c = r5;
        goto L_0x0179;
    L_0x0121:
        r3 = r0.m40508b();
        if (r3 == 0) goto L_0x0135;
    L_0x0127:
        r0 = 0;
        r12.f32004c = r0;
        r0 = org.spongycastle.jce.provider.BouncyCastleProvider.f27551a;
        r0 = r0.mo5888a();
        r4 = r0.m28315b();
        goto L_0x0179;
    L_0x0135:
        r0 = r0.m40509c();
        r0 = org.spongycastle.asn1.x9.X9ECParameters.m40515a(r0);
        r4 = r0.m40516a();
        r3 = r0.m40521g();
        r3 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m27999a(r4, r3);
        r5 = new java.security.spec.ECParameterSpec;
        r6 = new java.security.spec.ECPoint;
        r7 = r0.m40517b();
        r7 = r7.m28409g();
        r7 = r7.mo6549a();
        r8 = r0.m40517b();
        r8 = r8.m28410h();
        r8 = r8.mo6549a();
        r6.<init>(r7, r8);
        r7 = r0.m40518c();
        r0 = r0.m40519d();
        r0 = r0.intValue();
        r5.<init>(r3, r6, r7, r0);
        r12.f32004c = r5;
    L_0x0179:
        r13 = r13.m40413d();
        r13 = r13.m43059c();
        r0 = new org.spongycastle.asn1.DEROctetString;
        r0.<init>(r13);
        r1 = r13[r1];
        r3 = 4;
        if (r1 != r3) goto L_0x01b8;
    L_0x018b:
        r1 = r13[r2];
        r2 = r13.length;
        r3 = 2;
        r2 = r2 - r3;
        if (r1 != r2) goto L_0x01b8;
    L_0x0192:
        r1 = r13[r3];
        r2 = 3;
        if (r1 == r3) goto L_0x019b;
    L_0x0197:
        r1 = r13[r3];
        if (r1 != r2) goto L_0x01b8;
    L_0x019b:
        r1 = new org.spongycastle.asn1.x9.X9IntegerConverter;
        r1.<init>();
        r1 = r1.m27274a(r4);
        r3 = r13.length;
        r3 = r3 - r2;
        if (r1 < r3) goto L_0x01b8;
    L_0x01a8:
        r13 = org.spongycastle.asn1.ASN1Primitive.m39798b(r13);	 Catch:{ IOException -> 0x01b0 }
        r0 = r13;	 Catch:{ IOException -> 0x01b0 }
        r0 = (org.spongycastle.asn1.ASN1OctetString) r0;	 Catch:{ IOException -> 0x01b0 }
        goto L_0x01b8;
    L_0x01b0:
        r13 = new java.lang.IllegalArgumentException;
        r0 = "error recovering public key";
        r13.<init>(r0);
        throw r13;
    L_0x01b8:
        r13 = new org.spongycastle.asn1.x9.X9ECPoint;
        r13.<init>(r4, r0);
        r13 = r13.m40522a();
        r12.f32003b = r13;
    L_0x01c3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.JCEECPublicKey.a(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    public String getAlgorithm() {
        return this.f32002a;
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.f32002a;
        r1 = "ECGOST3410";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x009e;
    L_0x000a:
        r0 = r7.f32006e;
        if (r0 == 0) goto L_0x0011;
    L_0x000e:
        r0 = r7.f32006e;
        goto L_0x0068;
    L_0x0011:
        r0 = r7.f32004c;
        r0 = r0 instanceof org.spongycastle.jce.spec.ECNamedCurveSpec;
        if (r0 == 0) goto L_0x002b;
    L_0x0017:
        r0 = new org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
        r1 = r7.f32004c;
        r1 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r1;
        r1 = r1.m28314a();
        r1 = org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves.m27183b(r1);
        r2 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.f21567m;
        r0.<init>(r1, r2);
        goto L_0x0068;
    L_0x002b:
        r0 = r7.f32004c;
        r0 = r0.getCurve();
        r2 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28001a(r0);
        r0 = new org.spongycastle.asn1.x9.X9ECParameters;
        r1 = r7.f32004c;
        r1 = r1.getGenerator();
        r3 = r7.f32005d;
        r3 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28004a(r2, r1, r3);
        r1 = r7.f32004c;
        r4 = r1.getOrder();
        r1 = r7.f32004c;
        r1 = r1.getCofactor();
        r5 = (long) r1;
        r5 = java.math.BigInteger.valueOf(r5);
        r1 = r7.f32004c;
        r1 = r1.getCurve();
        r6 = r1.getSeed();
        r1 = r0;
        r1.<init>(r2, r3, r4, r5, r6);
        r1 = new org.spongycastle.asn1.x9.X962Parameters;
        r1.<init>(r0);
        r0 = r1;
    L_0x0068:
        r1 = r7.f32003b;
        r1 = r1.m28409g();
        r1 = r1.mo6549a();
        r2 = r7.f32003b;
        r2 = r2.m28410h();
        r2 = r2.mo6549a();
        r3 = 64;
        r3 = new byte[r3];
        r4 = 0;
        r7.m41127a(r3, r4, r1);
        r1 = 32;
        r7.m41127a(r3, r1, r2);
        r1 = new org.spongycastle.asn1.x509.SubjectPublicKeyInfo;	 Catch:{ IOException -> 0x009c }
        r2 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x009c }
        r4 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.f21564j;	 Catch:{ IOException -> 0x009c }
        r2.<init>(r4, r0);	 Catch:{ IOException -> 0x009c }
        r0 = new org.spongycastle.asn1.DEROctetString;	 Catch:{ IOException -> 0x009c }
        r0.<init>(r3);	 Catch:{ IOException -> 0x009c }
        r1.<init>(r2, r0);	 Catch:{ IOException -> 0x009c }
        goto L_0x014f;
    L_0x009c:
        r0 = 0;
        return r0;
    L_0x009e:
        r0 = r7.f32004c;
        r0 = r0 instanceof org.spongycastle.jce.spec.ECNamedCurveSpec;
        if (r0 == 0) goto L_0x00c5;
    L_0x00a4:
        r0 = r7.f32004c;
        r0 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r0;
        r0 = r0.m28314a();
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28006a(r0);
        if (r0 != 0) goto L_0x00bf;
    L_0x00b2:
        r0 = new org.spongycastle.asn1.ASN1ObjectIdentifier;
        r1 = r7.f32004c;
        r1 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r1;
        r1 = r1.m28314a();
        r0.<init>(r1);
    L_0x00bf:
        r1 = new org.spongycastle.asn1.x9.X962Parameters;
        r1.<init>(r0);
        goto L_0x010d;
    L_0x00c5:
        r0 = r7.f32004c;
        if (r0 != 0) goto L_0x00d1;
    L_0x00c9:
        r1 = new org.spongycastle.asn1.x9.X962Parameters;
        r0 = org.spongycastle.asn1.DERNull.f32850a;
        r1.<init>(r0);
        goto L_0x010d;
    L_0x00d1:
        r0 = r7.f32004c;
        r0 = r0.getCurve();
        r2 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28001a(r0);
        r0 = new org.spongycastle.asn1.x9.X9ECParameters;
        r1 = r7.f32004c;
        r1 = r1.getGenerator();
        r3 = r7.f32005d;
        r3 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28004a(r2, r1, r3);
        r1 = r7.f32004c;
        r4 = r1.getOrder();
        r1 = r7.f32004c;
        r1 = r1.getCofactor();
        r5 = (long) r1;
        r5 = java.math.BigInteger.valueOf(r5);
        r1 = r7.f32004c;
        r1 = r1.getCurve();
        r6 = r1.getSeed();
        r1 = r0;
        r1.<init>(r2, r3, r4, r5, r6);
        r1 = new org.spongycastle.asn1.x9.X962Parameters;
        r1.<init>(r0);
    L_0x010d:
        r0 = r7.m41128a();
        r0 = r0.m28406d();
        r2 = new org.spongycastle.asn1.x9.X9ECPoint;
        r3 = r7.mo6503c();
        r3 = r3.m28409g();
        r3 = r3.mo6549a();
        r4 = r7.mo6503c();
        r4 = r4.m28410h();
        r4 = r4.mo6549a();
        r5 = r7.f32005d;
        r0 = r0.mo5902b(r3, r4, r5);
        r2.<init>(r0);
        r0 = r2.mo5709e();
        r0 = (org.spongycastle.asn1.ASN1OctetString) r0;
        r2 = new org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
        r3 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;
        r4 = org.spongycastle.asn1.x9.X9ObjectIdentifiers.f22170k;
        r3.<init>(r4, r1);
        r0 = r0.mo6859c();
        r2.<init>(r3, r0);
        r1 = r2;
    L_0x014f:
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil.m28019a(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.JCEECPublicKey.getEncoded():byte[]");
    }

    /* renamed from: a */
    private void m41127a(byte[] bArr, int i, BigInteger bigInteger) {
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
        return this.f32004c;
    }

    /* renamed from: b */
    public org.spongycastle.jce.spec.ECParameterSpec mo6501b() {
        if (this.f32004c == null) {
            return null;
        }
        return EC5Util.m28000a(this.f32004c, this.f32005d);
    }

    public java.security.spec.ECPoint getW() {
        return new java.security.spec.ECPoint(this.f32003b.m28409g().mo6549a(), this.f32003b.m28410h().mo6549a());
    }

    /* renamed from: c */
    public ECPoint mo6503c() {
        if (this.f32004c == null) {
            return this.f32003b.m28403c();
        }
        return this.f32003b;
    }

    /* renamed from: a */
    public ECPoint m41128a() {
        return this.f32003b;
    }

    /* renamed from: d */
    org.spongycastle.jce.spec.ECParameterSpec m41131d() {
        if (this.f32004c != null) {
            return EC5Util.m28000a(this.f32004c, this.f32005d);
        }
        return BouncyCastleProvider.f27551a.mo5888a();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String a = Strings.m29418a();
        stringBuffer.append("EC Public Key");
        stringBuffer.append(a);
        stringBuffer.append("            X: ");
        stringBuffer.append(this.f32003b.m28409g().mo6549a().toString(16));
        stringBuffer.append(a);
        stringBuffer.append("            Y: ");
        stringBuffer.append(this.f32003b.m28410h().mo6549a().toString(16));
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof JCEECPublicKey)) {
            return false;
        }
        JCEECPublicKey jCEECPublicKey = (JCEECPublicKey) obj;
        if (m41128a().m28397a(jCEECPublicKey.m41128a()) && m41131d().equals(jCEECPublicKey.m41131d()) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return m41128a().hashCode() ^ m41131d().hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        m41126a(SubjectPublicKeyInfo.m40409a(ASN1Primitive.m39798b((byte[]) objectInputStream.readObject())));
        this.f32002a = (String) objectInputStream.readObject();
        this.f32005d = objectInputStream.readBoolean();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(getEncoded());
        objectOutputStream.writeObject(this.f32002a);
        objectOutputStream.writeBoolean(this.f32005d);
    }
}
