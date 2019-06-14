package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECPoint;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Strings;

public class BCECPublicKey implements ECPublicKey, ECPointEncoder, org.spongycastle.jce.interfaces.ECPublicKey {
    static final long serialVersionUID = 2422789860422731812L;
    /* renamed from: a */
    private String f31891a = "EC";
    /* renamed from: b */
    private boolean f31892b;
    /* renamed from: c */
    private transient ECPoint f31893c;
    /* renamed from: d */
    private transient ECParameterSpec f31894d;
    /* renamed from: e */
    private transient ProviderConfiguration f31895e;

    public String getFormat() {
        return "X.509";
    }

    public BCECPublicKey(String str, ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.f31891a = str;
        this.f31894d = eCPublicKeySpec.getParams();
        this.f31893c = EC5Util.m28003a(this.f31894d, eCPublicKeySpec.getW(), false);
        this.f31895e = providerConfiguration;
    }

    public BCECPublicKey(String str, org.spongycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.f31891a = str;
        this.f31893c = eCPublicKeySpec.m36252b();
        if (eCPublicKeySpec.m28309a() != null) {
            EllipticCurve a = EC5Util.m27999a(eCPublicKeySpec.m28309a().m28315b(), eCPublicKeySpec.m28309a().m28319f());
            this.f31893c = EC5Util.m28001a(a).m28376b(eCPublicKeySpec.m36252b().m28409g().mo6549a(), eCPublicKeySpec.m36252b().m28410h().mo6549a());
            this.f31894d = EC5Util.m27996a(a, eCPublicKeySpec.m28309a());
        } else {
            if (this.f31893c.m28406d() == null) {
                this.f31893c = providerConfiguration.mo5888a().m28315b().mo5902b(this.f31893c.m28411i().mo6549a(), this.f31893c.mo6571j().mo6549a(), false);
            }
            this.f31894d = null;
        }
        this.f31895e = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        ECDomainParameters b = eCPublicKeyParameters.m40792b();
        this.f31891a = str;
        this.f31893c = eCPublicKeyParameters.m43370c();
        if (eCParameterSpec == null) {
            this.f31894d = m41032a(EC5Util.m27999a(b.m35647a(), b.m35651e()), b);
        } else {
            this.f31894d = eCParameterSpec;
        }
        this.f31895e = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        ECDomainParameters b = eCPublicKeyParameters.m40792b();
        this.f31891a = str;
        if (eCParameterSpec == null) {
            this.f31894d = m41032a(EC5Util.m27999a(b.m35647a(), b.m35651e()), b);
        } else {
            this.f31894d = EC5Util.m27996a(EC5Util.m27999a(eCParameterSpec.m28315b(), eCParameterSpec.m28319f()), eCParameterSpec);
        }
        this.f31893c = EC5Util.m28001a(this.f31894d.getCurve()).m28376b(eCPublicKeyParameters.m43370c().m28409g().mo6549a(), eCPublicKeyParameters.m43370c().m28410h().mo6549a());
        this.f31895e = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ProviderConfiguration providerConfiguration) {
        this.f31891a = str;
        this.f31893c = eCPublicKeyParameters.m43370c();
        this.f31894d = null;
        this.f31895e = providerConfiguration;
    }

    public BCECPublicKey(ECPublicKey eCPublicKey, ProviderConfiguration providerConfiguration) {
        this.f31891a = eCPublicKey.getAlgorithm();
        this.f31894d = eCPublicKey.getParams();
        this.f31893c = EC5Util.m28003a(this.f31894d, eCPublicKey.getW(), false);
    }

    BCECPublicKey(String str, SubjectPublicKeyInfo subjectPublicKeyInfo, ProviderConfiguration providerConfiguration) {
        this.f31891a = str;
        this.f31895e = providerConfiguration;
        m41033a(subjectPublicKeyInfo);
    }

    /* renamed from: a */
    private ECParameterSpec m41032a(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, new java.security.spec.ECPoint(eCDomainParameters.m35648b().m28409g().mo6549a(), eCDomainParameters.m35648b().m28410h().mo6549a()), eCDomainParameters.m35649c(), eCDomainParameters.m35650d().intValue());
    }

    /* renamed from: a */
    private void m41033a(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = new org.spongycastle.asn1.x9.X962Parameters;
        r1 = r6.m40410a();
        r1 = r1.m40231b();
        r1 = (org.spongycastle.asn1.ASN1Primitive) r1;
        r0.<init>(r1);
        r1 = r5.f31895e;
        r1 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m28002a(r1, r0);
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.m27997a(r0, r1);
        r5.f31894d = r0;
        r6 = r6.m40413d();
        r6 = r6.m43059c();
        r0 = new org.spongycastle.asn1.DEROctetString;
        r0.<init>(r6);
        r2 = 0;
        r2 = r6[r2];
        r3 = 4;
        if (r2 != r3) goto L_0x005c;
    L_0x002e:
        r2 = 1;
        r2 = r6[r2];
        r3 = r6.length;
        r4 = 2;
        r3 = r3 - r4;
        if (r2 != r3) goto L_0x005c;
    L_0x0036:
        r2 = r6[r4];
        r3 = 3;
        if (r2 == r4) goto L_0x003f;
    L_0x003b:
        r2 = r6[r4];
        if (r2 != r3) goto L_0x005c;
    L_0x003f:
        r2 = new org.spongycastle.asn1.x9.X9IntegerConverter;
        r2.<init>();
        r2 = r2.m27274a(r1);
        r4 = r6.length;
        r4 = r4 - r3;
        if (r2 < r4) goto L_0x005c;
    L_0x004c:
        r6 = org.spongycastle.asn1.ASN1Primitive.m39798b(r6);	 Catch:{ IOException -> 0x0054 }
        r0 = r6;	 Catch:{ IOException -> 0x0054 }
        r0 = (org.spongycastle.asn1.ASN1OctetString) r0;	 Catch:{ IOException -> 0x0054 }
        goto L_0x005c;
    L_0x0054:
        r6 = new java.lang.IllegalArgumentException;
        r0 = "error recovering public key";
        r6.<init>(r0);
        throw r6;
    L_0x005c:
        r6 = new org.spongycastle.asn1.x9.X9ECPoint;
        r6.<init>(r1, r0);
        r6 = r6.m40522a();
        r5.f31893c = r6;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ec.BCECPublicKey.a(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    public String getAlgorithm() {
        return this.f31891a;
    }

    public byte[] getEncoded() {
        ASN1Encodable x962Parameters;
        ASN1OctetString aSN1OctetString;
        if (this.f31894d instanceof ECNamedCurveSpec) {
            ASN1ObjectIdentifier a = ECUtil.m28006a(((ECNamedCurveSpec) this.f31894d).m28314a());
            if (a == null) {
                a = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.f31894d).m28314a());
            }
            x962Parameters = new X962Parameters(a);
        } else if (this.f31894d == null) {
            x962Parameters = new X962Parameters(DERNull.f32850a);
        } else {
            ECCurve a2 = EC5Util.m28001a(this.f31894d.getCurve());
            x962Parameters = new X962Parameters(new X9ECParameters(a2, EC5Util.m28004a(a2, this.f31894d.getGenerator(), this.f31892b), this.f31894d.getOrder(), BigInteger.valueOf((long) this.f31894d.getCofactor()), this.f31894d.getCurve().getSeed()));
        }
        ECCurve d = m41034a().m28406d();
        if (this.f31894d == null) {
            aSN1OctetString = (ASN1OctetString) new X9ECPoint(d.mo5902b(mo6503c().m28411i().mo6549a(), mo6503c().mo6571j().mo6549a(), this.f31892b)).mo5709e();
        } else {
            aSN1OctetString = (ASN1OctetString) new X9ECPoint(d.mo5902b(mo6503c().m28409g().mo6549a(), mo6503c().m28410h().mo6549a(), this.f31892b)).mo5709e();
        }
        return KeyUtil.m28019a(new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.f22170k, x962Parameters), aSN1OctetString.mo6859c()));
    }

    public ECParameterSpec getParams() {
        return this.f31894d;
    }

    /* renamed from: b */
    public org.spongycastle.jce.spec.ECParameterSpec mo6501b() {
        if (this.f31894d == null) {
            return null;
        }
        return EC5Util.m28000a(this.f31894d, this.f31892b);
    }

    public java.security.spec.ECPoint getW() {
        return new java.security.spec.ECPoint(this.f31893c.m28409g().mo6549a(), this.f31893c.m28410h().mo6549a());
    }

    /* renamed from: c */
    public ECPoint mo6503c() {
        if (this.f31894d == null) {
            return this.f31893c.m28403c();
        }
        return this.f31893c;
    }

    /* renamed from: a */
    public ECPoint m41034a() {
        return this.f31893c;
    }

    /* renamed from: d */
    org.spongycastle.jce.spec.ECParameterSpec m41037d() {
        if (this.f31894d != null) {
            return EC5Util.m28000a(this.f31894d, this.f31892b);
        }
        return this.f31895e.mo5888a();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String a = Strings.m29418a();
        stringBuffer.append("EC Public Key");
        stringBuffer.append(a);
        stringBuffer.append("            X: ");
        stringBuffer.append(this.f31893c.m28409g().mo6549a().toString(16));
        stringBuffer.append(a);
        stringBuffer.append("            Y: ");
        stringBuffer.append(this.f31893c.m28410h().mo6549a().toString(16));
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof BCECPublicKey)) {
            return false;
        }
        BCECPublicKey bCECPublicKey = (BCECPublicKey) obj;
        if (m41034a().m28397a(bCECPublicKey.m41034a()) && m41037d().equals(bCECPublicKey.m41037d()) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return m41034a().hashCode() ^ m41037d().hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        m41033a(SubjectPublicKeyInfo.m40409a(ASN1Primitive.m39798b((byte[]) objectInputStream.readObject())));
        this.f31895e = BouncyCastleProvider.f27551a;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }
}
