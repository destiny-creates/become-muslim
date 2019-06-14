package org.spongycastle.jcajce.provider.asymmetric.ecgost;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.ECKeyPairGenerator;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveGenParameterSpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.math.ec.ECCurve;

public class KeyPairGeneratorSpi extends KeyPairGenerator {
    /* renamed from: a */
    Object f22760a = null;
    /* renamed from: b */
    ECKeyPairGenerator f22761b = new ECKeyPairGenerator();
    /* renamed from: c */
    String f22762c = "ECGOST3410";
    /* renamed from: d */
    ECKeyGenerationParameters f22763d;
    /* renamed from: e */
    int f22764e = 239;
    /* renamed from: f */
    SecureRandom f22765f = null;
    /* renamed from: g */
    boolean f22766g = false;

    public KeyPairGeneratorSpi() {
        super("ECGOST3410");
    }

    public void initialize(int r1, java.security.SecureRandom r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r0.f22764e = r1;
        r0.f22765f = r2;
        r1 = r0.f22760a;
        if (r1 == 0) goto L_0x0018;
    L_0x0008:
        r1 = r0.f22760a;	 Catch:{ InvalidAlgorithmParameterException -> 0x0010 }
        r1 = (java.security.spec.ECGenParameterSpec) r1;	 Catch:{ InvalidAlgorithmParameterException -> 0x0010 }
        r0.initialize(r1, r2);	 Catch:{ InvalidAlgorithmParameterException -> 0x0010 }
        return;
    L_0x0010:
        r1 = new java.security.InvalidParameterException;
        r2 = "key size not configurable.";
        r1.<init>(r2);
        throw r1;
    L_0x0018:
        r1 = new java.security.InvalidParameterException;
        r2 = "unknown key size.";
        r1.<init>(r2);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ecgost.KeyPairGeneratorSpi.initialize(int, java.security.SecureRandom):void");
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        ECParameterSpec eCParameterSpec;
        if (algorithmParameterSpec instanceof ECParameterSpec) {
            eCParameterSpec = (ECParameterSpec) algorithmParameterSpec;
            this.f22760a = algorithmParameterSpec;
            this.f22763d = new ECKeyGenerationParameters(new ECDomainParameters(eCParameterSpec.m28315b(), eCParameterSpec.m28316c(), eCParameterSpec.m28317d()), secureRandom);
            this.f22761b.m35332a(this.f22763d);
            this.f22766g = true;
        } else if (algorithmParameterSpec instanceof java.security.spec.ECParameterSpec) {
            java.security.spec.ECParameterSpec eCParameterSpec2 = (java.security.spec.ECParameterSpec) algorithmParameterSpec;
            this.f22760a = algorithmParameterSpec;
            ECCurve a = EC5Util.m28001a(eCParameterSpec2.getCurve());
            this.f22763d = new ECKeyGenerationParameters(new ECDomainParameters(a, EC5Util.m28004a(a, eCParameterSpec2.getGenerator(), false), eCParameterSpec2.getOrder(), BigInteger.valueOf((long) eCParameterSpec2.getCofactor())), secureRandom);
            this.f22761b.m35332a(this.f22763d);
            this.f22766g = true;
        } else {
            boolean z = algorithmParameterSpec instanceof ECGenParameterSpec;
            if (!z) {
                if (!(algorithmParameterSpec instanceof ECNamedCurveGenParameterSpec)) {
                    if (algorithmParameterSpec == null && BouncyCastleProvider.f27551a.mo5888a() != null) {
                        eCParameterSpec = BouncyCastleProvider.f27551a.mo5888a();
                        this.f22760a = algorithmParameterSpec;
                        this.f22763d = new ECKeyGenerationParameters(new ECDomainParameters(eCParameterSpec.m28315b(), eCParameterSpec.m28316c(), eCParameterSpec.m28317d()), secureRandom);
                        this.f22761b.m35332a(this.f22763d);
                        this.f22766g = true;
                        return;
                    } else if (algorithmParameterSpec == null && BouncyCastleProvider.f27551a.mo5888a() == null) {
                        throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("parameter object not a ECParameterSpec: ");
                        stringBuilder.append(algorithmParameterSpec.getClass().getName());
                        throw new InvalidAlgorithmParameterException(stringBuilder.toString());
                    }
                }
            }
            if (z) {
                algorithmParameterSpec = ((ECGenParameterSpec) algorithmParameterSpec).getName();
            } else {
                algorithmParameterSpec = ((ECNamedCurveGenParameterSpec) algorithmParameterSpec).m28310a();
            }
            String str = algorithmParameterSpec;
            algorithmParameterSpec = ECGOST3410NamedCurves.m27180a(str);
            if (algorithmParameterSpec != null) {
                this.f22760a = new ECNamedCurveSpec(str, algorithmParameterSpec.m35647a(), algorithmParameterSpec.m35648b(), algorithmParameterSpec.m35649c(), algorithmParameterSpec.m35650d(), algorithmParameterSpec.m35651e());
                java.security.spec.ECParameterSpec eCParameterSpec3 = (java.security.spec.ECParameterSpec) this.f22760a;
                ECCurve a2 = EC5Util.m28001a(eCParameterSpec3.getCurve());
                this.f22763d = new ECKeyGenerationParameters(new ECDomainParameters(a2, EC5Util.m28004a(a2, eCParameterSpec3.getGenerator(), false), eCParameterSpec3.getOrder(), BigInteger.valueOf((long) eCParameterSpec3.getCofactor())), secureRandom);
                this.f22761b.m35332a(this.f22763d);
                this.f22766g = true;
                return;
            }
            secureRandom = new StringBuilder();
            secureRandom.append("unknown curve name: ");
            secureRandom.append(str);
            throw new InvalidAlgorithmParameterException(secureRandom.toString());
        }
    }

    public KeyPair generateKeyPair() {
        if (this.f22766g) {
            AsymmetricCipherKeyPair a = this.f22761b.mo5755a();
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) a.m27281a();
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) a.m27282b();
            BCECGOST3410PublicKey bCECGOST3410PublicKey;
            if (this.f22760a instanceof ECParameterSpec) {
                ECParameterSpec eCParameterSpec = (ECParameterSpec) this.f22760a;
                bCECGOST3410PublicKey = new BCECGOST3410PublicKey(this.f22762c, eCPublicKeyParameters, eCParameterSpec);
                return new KeyPair(bCECGOST3410PublicKey, new BCECGOST3410PrivateKey(this.f22762c, eCPrivateKeyParameters, bCECGOST3410PublicKey, eCParameterSpec));
            } else if (this.f22760a == null) {
                return new KeyPair(new BCECGOST3410PublicKey(this.f22762c, eCPublicKeyParameters), new BCECGOST3410PrivateKey(this.f22762c, eCPrivateKeyParameters));
            } else {
                java.security.spec.ECParameterSpec eCParameterSpec2 = (java.security.spec.ECParameterSpec) this.f22760a;
                bCECGOST3410PublicKey = new BCECGOST3410PublicKey(this.f22762c, eCPublicKeyParameters, eCParameterSpec2);
                return new KeyPair(bCECGOST3410PublicKey, new BCECGOST3410PrivateKey(this.f22762c, eCPrivateKeyParameters, bCECGOST3410PublicKey, eCParameterSpec2));
            }
        }
        throw new IllegalStateException("EC Key Pair Generator not initialised");
    }
}
