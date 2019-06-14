package org.spongycastle.jce.provider;

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
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.sec.ECPrivateKeyStructure;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.util.Strings;

public class JCEECPrivateKey implements ECPrivateKey, ECPointEncoder, org.spongycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier {
    /* renamed from: a */
    private String f31996a = "EC";
    /* renamed from: b */
    private BigInteger f31997b;
    /* renamed from: c */
    private ECParameterSpec f31998c;
    /* renamed from: d */
    private boolean f31999d;
    /* renamed from: e */
    private DERBitString f32000e;
    /* renamed from: f */
    private PKCS12BagAttributeCarrierImpl f32001f = new PKCS12BagAttributeCarrierImpl();

    public String getFormat() {
        return "PKCS#8";
    }

    protected JCEECPrivateKey() {
    }

    /* renamed from: a */
    private void m41119a(PrivateKeyInfo privateKeyInfo) {
        X962Parameters x962Parameters = new X962Parameters((ASN1Primitive) privateKeyInfo.m40112a().m40231b());
        if (x962Parameters.m40507a()) {
            ASN1ObjectIdentifier a = ASN1ObjectIdentifier.m42973a(x962Parameters.m40509c());
            X9ECParameters a2 = ECUtil.m28008a(a);
            if (a2 == null) {
                ECDomainParameters a3 = ECGOST3410NamedCurves.m27181a(a);
                this.f31998c = new ECNamedCurveSpec(ECGOST3410NamedCurves.m27182b(a), EC5Util.m27999a(a3.m35647a(), a3.m35651e()), new ECPoint(a3.m35648b().m28409g().mo6549a(), a3.m35648b().m28410h().mo6549a()), a3.m35649c(), a3.m35650d());
            } else {
                this.f31998c = new ECNamedCurveSpec(ECUtil.m28012b(a), EC5Util.m27999a(a2.m40516a(), a2.m40521g()), new ECPoint(a2.m40517b().m28409g().mo6549a(), a2.m40517b().m28410h().mo6549a()), a2.m40518c(), a2.m40519d());
            }
        } else if (x962Parameters.m40508b()) {
            this.f31998c = null;
        } else {
            X9ECParameters a4 = X9ECParameters.m40515a(x962Parameters.m40509c());
            this.f31998c = new ECParameterSpec(EC5Util.m27999a(a4.m40516a(), a4.m40521g()), new ECPoint(a4.m40517b().m28409g().mo6549a(), a4.m40517b().m28410h().mo6549a()), a4.m40518c(), a4.m40519d().intValue());
        }
        Object c = privateKeyInfo.m40114c();
        if (c instanceof ASN1Integer) {
            this.f31997b = ASN1Integer.m42963a(c).m42968b();
            return;
        }
        ECPrivateKeyStructure eCPrivateKeyStructure = new ECPrivateKeyStructure((ASN1Sequence) c);
        this.f31997b = eCPrivateKeyStructure.m40170a();
        this.f32000e = eCPrivateKeyStructure.m40171b();
    }

    public String getAlgorithm() {
        return this.f31996a;
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.f31998c;
        r0 = r0 instanceof org.spongycastle.jce.spec.ECNamedCurveSpec;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r0 = r7.f31998c;
        r0 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r0;
        r0 = r0.m28314a();
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28006a(r0);
        if (r0 != 0) goto L_0x0021;
    L_0x0014:
        r0 = new org.spongycastle.asn1.ASN1ObjectIdentifier;
        r1 = r7.f31998c;
        r1 = (org.spongycastle.jce.spec.ECNamedCurveSpec) r1;
        r1 = r1.m28314a();
        r0.<init>(r1);
    L_0x0021:
        r1 = new org.spongycastle.asn1.x9.X962Parameters;
        r1.<init>(r0);
        goto L_0x006f;
    L_0x0027:
        r0 = r7.f31998c;
        if (r0 != 0) goto L_0x0033;
    L_0x002b:
        r1 = new org.spongycastle.asn1.x9.X962Parameters;
        r0 = org.spongycastle.asn1.DERNull.f32850a;
        r1.<init>(r0);
        goto L_0x006f;
    L_0x0033:
        r0 = r7.f31998c;
        r0 = r0.getCurve();
        r2 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28001a(r0);
        r0 = new org.spongycastle.asn1.x9.X9ECParameters;
        r1 = r7.f31998c;
        r1 = r1.getGenerator();
        r3 = r7.f31999d;
        r3 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28004a(r2, r1, r3);
        r1 = r7.f31998c;
        r4 = r1.getOrder();
        r1 = r7.f31998c;
        r1 = r1.getCofactor();
        r5 = (long) r1;
        r5 = java.math.BigInteger.valueOf(r5);
        r1 = r7.f31998c;
        r1 = r1.getCurve();
        r6 = r1.getSeed();
        r1 = r0;
        r1.<init>(r2, r3, r4, r5, r6);
        r1 = new org.spongycastle.asn1.x9.X962Parameters;
        r1.<init>(r0);
    L_0x006f:
        r0 = r7.f32000e;
        if (r0 == 0) goto L_0x007f;
    L_0x0073:
        r0 = new org.spongycastle.asn1.sec.ECPrivateKeyStructure;
        r2 = r7.getS();
        r3 = r7.f32000e;
        r0.<init>(r2, r3, r1);
        goto L_0x0088;
    L_0x007f:
        r0 = new org.spongycastle.asn1.sec.ECPrivateKeyStructure;
        r2 = r7.getS();
        r0.<init>(r2, r1);
    L_0x0088:
        r2 = r7.f31996a;	 Catch:{ IOException -> 0x00c2 }
        r3 = "ECGOST3410";	 Catch:{ IOException -> 0x00c2 }
        r2 = r2.equals(r3);	 Catch:{ IOException -> 0x00c2 }
        if (r2 == 0) goto L_0x00a7;	 Catch:{ IOException -> 0x00c2 }
    L_0x0092:
        r2 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo;	 Catch:{ IOException -> 0x00c2 }
        r3 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x00c2 }
        r4 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.f21564j;	 Catch:{ IOException -> 0x00c2 }
        r1 = r1.mo5709e();	 Catch:{ IOException -> 0x00c2 }
        r3.<init>(r4, r1);	 Catch:{ IOException -> 0x00c2 }
        r0 = r0.mo5709e();	 Catch:{ IOException -> 0x00c2 }
        r2.<init>(r3, r0);	 Catch:{ IOException -> 0x00c2 }
        goto L_0x00bb;	 Catch:{ IOException -> 0x00c2 }
    L_0x00a7:
        r2 = new org.spongycastle.asn1.pkcs.PrivateKeyInfo;	 Catch:{ IOException -> 0x00c2 }
        r3 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;	 Catch:{ IOException -> 0x00c2 }
        r4 = org.spongycastle.asn1.x9.X9ObjectIdentifiers.f22170k;	 Catch:{ IOException -> 0x00c2 }
        r1 = r1.mo5709e();	 Catch:{ IOException -> 0x00c2 }
        r3.<init>(r4, r1);	 Catch:{ IOException -> 0x00c2 }
        r0 = r0.mo5709e();	 Catch:{ IOException -> 0x00c2 }
        r2.<init>(r3, r0);	 Catch:{ IOException -> 0x00c2 }
    L_0x00bb:
        r0 = "DER";	 Catch:{ IOException -> 0x00c2 }
        r0 = r2.m34596a(r0);	 Catch:{ IOException -> 0x00c2 }
        return r0;
    L_0x00c2:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.JCEECPrivateKey.getEncoded():byte[]");
    }

    public ECParameterSpec getParams() {
        return this.f31998c;
    }

    /* renamed from: b */
    public org.spongycastle.jce.spec.ECParameterSpec mo6501b() {
        if (this.f31998c == null) {
            return null;
        }
        return EC5Util.m28000a(this.f31998c, this.f31999d);
    }

    /* renamed from: c */
    org.spongycastle.jce.spec.ECParameterSpec m41124c() {
        if (this.f31998c != null) {
            return EC5Util.m28000a(this.f31998c, this.f31999d);
        }
        return BouncyCastleProvider.f27551a.mo5888a();
    }

    public BigInteger getS() {
        return this.f31997b;
    }

    /* renamed from: d */
    public BigInteger mo6502d() {
        return this.f31997b;
    }

    /* renamed from: a */
    public void mo5851a(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f32001f.mo5851a(aSN1ObjectIdentifier, aSN1Encodable);
    }

    /* renamed from: a */
    public ASN1Encodable mo5850a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f32001f.mo5850a(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public Enumeration mo5849a() {
        return this.f32001f.mo5849a();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof JCEECPrivateKey)) {
            return false;
        }
        JCEECPrivateKey jCEECPrivateKey = (JCEECPrivateKey) obj;
        if (mo6502d().equals(jCEECPrivateKey.mo6502d()) && m41124c().equals(jCEECPrivateKey.m41124c()) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return mo6502d().hashCode() ^ m41124c().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String a = Strings.m29418a();
        stringBuffer.append("EC Private Key");
        stringBuffer.append(a);
        stringBuffer.append("             S: ");
        stringBuffer.append(this.f31997b.toString(16));
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        m41119a(PrivateKeyInfo.m40111a(ASN1Primitive.m39798b((byte[]) objectInputStream.readObject())));
        this.f31996a = (String) objectInputStream.readObject();
        this.f31999d = objectInputStream.readBoolean();
        this.f32001f = new PKCS12BagAttributeCarrierImpl();
        this.f32001f.m36021a(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(getEncoded());
        objectOutputStream.writeObject(this.f31996a);
        objectOutputStream.writeBoolean(this.f31999d);
        this.f32001f.m36022a(objectOutputStream);
    }
}
