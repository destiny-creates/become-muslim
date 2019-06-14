package org.spongycastle.jcajce.provider.asymmetric.ec;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.util.Hashtable;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.ECKeyPairGenerator;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveGenParameterSpec;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.util.Integers;

public abstract class KeyPairGeneratorSpi extends KeyPairGenerator {

    public static class EC extends KeyPairGeneratorSpi {
        /* renamed from: j */
        private static Hashtable f27402j = new Hashtable();
        /* renamed from: a */
        ECKeyGenerationParameters f27403a;
        /* renamed from: b */
        ECKeyPairGenerator f27404b;
        /* renamed from: c */
        Object f27405c;
        /* renamed from: d */
        int f27406d;
        /* renamed from: e */
        int f27407e;
        /* renamed from: f */
        SecureRandom f27408f;
        /* renamed from: g */
        boolean f27409g;
        /* renamed from: h */
        String f27410h;
        /* renamed from: i */
        ProviderConfiguration f27411i;

        static {
            f27402j.put(Integers.m29396a(JfifUtil.MARKER_SOFn), new ECGenParameterSpec("prime192v1"));
            f27402j.put(Integers.m29396a(239), new ECGenParameterSpec("prime239v1"));
            f27402j.put(Integers.m29396a(256), new ECGenParameterSpec("prime256v1"));
            f27402j.put(Integers.m29396a(224), new ECGenParameterSpec("P-224"));
            f27402j.put(Integers.m29396a(BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT), new ECGenParameterSpec("P-384"));
            f27402j.put(Integers.m29396a(521), new ECGenParameterSpec("P-521"));
        }

        public EC() {
            super("EC");
            this.f27404b = new ECKeyPairGenerator();
            this.f27405c = null;
            this.f27406d = 239;
            this.f27407e = 50;
            this.f27408f = new SecureRandom();
            this.f27409g = false;
            this.f27410h = "EC";
            this.f27411i = BouncyCastleProvider.f27551a;
        }

        public EC(String str, ProviderConfiguration providerConfiguration) {
            super(str);
            this.f27404b = new ECKeyPairGenerator();
            this.f27405c = null;
            this.f27406d = 239;
            this.f27407e = 50;
            this.f27408f = new SecureRandom();
            this.f27409g = false;
            this.f27410h = str;
            this.f27411i = providerConfiguration;
        }

        public void initialize(int r2, java.security.SecureRandom r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r1.f27406d = r2;
            r1.f27408f = r3;
            r0 = f27402j;
            r2 = org.spongycastle.util.Integers.m29396a(r2);
            r2 = r0.get(r2);
            r2 = (java.security.spec.ECGenParameterSpec) r2;
            if (r2 == 0) goto L_0x001e;
        L_0x0012:
            r1.initialize(r2, r3);	 Catch:{ InvalidAlgorithmParameterException -> 0x0016 }
            return;
        L_0x0016:
            r2 = new java.security.InvalidParameterException;
            r3 = "key size not configurable.";
            r2.<init>(r3);
            throw r2;
        L_0x001e:
            r2 = new java.security.InvalidParameterException;
            r3 = "unknown key size.";
            r2.<init>(r3);
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi.EC.initialize(int, java.security.SecureRandom):void");
        }

        public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            if (algorithmParameterSpec == null) {
                ECParameterSpec a = this.f27411i.mo5888a();
                if (a != null) {
                    this.f27405c = null;
                    this.f27403a = m35997a(a, secureRandom);
                } else {
                    throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
                }
            } else if (algorithmParameterSpec instanceof ECParameterSpec) {
                this.f27405c = algorithmParameterSpec;
                this.f27403a = m35997a((ECParameterSpec) algorithmParameterSpec, secureRandom);
            } else if (algorithmParameterSpec instanceof java.security.spec.ECParameterSpec) {
                this.f27405c = algorithmParameterSpec;
                this.f27403a = m35996a((java.security.spec.ECParameterSpec) algorithmParameterSpec, secureRandom);
            } else if (algorithmParameterSpec instanceof ECGenParameterSpec) {
                m35999a(((ECGenParameterSpec) algorithmParameterSpec).getName(), secureRandom);
            } else if (algorithmParameterSpec instanceof ECNamedCurveGenParameterSpec) {
                m35999a(((ECNamedCurveGenParameterSpec) algorithmParameterSpec).m28310a(), secureRandom);
            } else {
                throw new InvalidAlgorithmParameterException("parameter object not a ECParameterSpec");
            }
            this.f27404b.m35332a(this.f27403a);
            this.f27409g = true;
        }

        public KeyPair generateKeyPair() {
            if (!this.f27409g) {
                initialize(this.f27406d, new SecureRandom());
            }
            AsymmetricCipherKeyPair a = this.f27404b.mo5755a();
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) a.m27281a();
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) a.m27282b();
            PublicKey bCECPublicKey;
            if (this.f27405c instanceof ECParameterSpec) {
                ECParameterSpec eCParameterSpec = (ECParameterSpec) this.f27405c;
                bCECPublicKey = new BCECPublicKey(this.f27410h, eCPublicKeyParameters, eCParameterSpec, this.f27411i);
                return new KeyPair(bCECPublicKey, new BCECPrivateKey(this.f27410h, eCPrivateKeyParameters, (BCECPublicKey) bCECPublicKey, eCParameterSpec, this.f27411i));
            } else if (this.f27405c == null) {
                return new KeyPair(new BCECPublicKey(this.f27410h, eCPublicKeyParameters, this.f27411i), new BCECPrivateKey(this.f27410h, eCPrivateKeyParameters, this.f27411i));
            } else {
                java.security.spec.ECParameterSpec eCParameterSpec2 = (java.security.spec.ECParameterSpec) this.f27405c;
                bCECPublicKey = new BCECPublicKey(this.f27410h, eCPublicKeyParameters, eCParameterSpec2, this.f27411i);
                return new KeyPair(bCECPublicKey, new BCECPrivateKey(this.f27410h, eCPrivateKeyParameters, (BCECPublicKey) bCECPublicKey, eCParameterSpec2, this.f27411i));
            }
        }

        /* renamed from: a */
        protected ECKeyGenerationParameters m35997a(ECParameterSpec eCParameterSpec, SecureRandom secureRandom) {
            return new ECKeyGenerationParameters(new ECDomainParameters(eCParameterSpec.m28315b(), eCParameterSpec.m28316c(), eCParameterSpec.m28317d()), secureRandom);
        }

        /* renamed from: a */
        protected ECKeyGenerationParameters m35996a(java.security.spec.ECParameterSpec eCParameterSpec, SecureRandom secureRandom) {
            ECCurve a = EC5Util.m28001a(eCParameterSpec.getCurve());
            return new ECKeyGenerationParameters(new ECDomainParameters(a, EC5Util.m28004a(a, eCParameterSpec.getGenerator(), false), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor())), secureRandom);
        }

        /* renamed from: a */
        protected org.spongycastle.jce.spec.ECNamedCurveSpec m35998a(java.lang.String r10) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r9 = this;
            r0 = org.spongycastle.jcajce.provider.asymmetric.ec.ECUtils.m27968a(r10);
            if (r0 != 0) goto L_0x0040;
        L_0x0006:
            r0 = new org.spongycastle.asn1.ASN1ObjectIdentifier;	 Catch:{ IllegalArgumentException -> 0x0029 }
            r0.<init>(r10);	 Catch:{ IllegalArgumentException -> 0x0029 }
            r0 = org.spongycastle.asn1.x9.ECNamedCurveTable.m27265b(r0);	 Catch:{ IllegalArgumentException -> 0x0029 }
            if (r0 == 0) goto L_0x0012;	 Catch:{ IllegalArgumentException -> 0x0029 }
        L_0x0011:
            goto L_0x0040;	 Catch:{ IllegalArgumentException -> 0x0029 }
        L_0x0012:
            r0 = new java.security.InvalidAlgorithmParameterException;	 Catch:{ IllegalArgumentException -> 0x0029 }
            r1 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0029 }
            r1.<init>();	 Catch:{ IllegalArgumentException -> 0x0029 }
            r2 = "unknown curve OID: ";	 Catch:{ IllegalArgumentException -> 0x0029 }
            r1.append(r2);	 Catch:{ IllegalArgumentException -> 0x0029 }
            r1.append(r10);	 Catch:{ IllegalArgumentException -> 0x0029 }
            r1 = r1.toString();	 Catch:{ IllegalArgumentException -> 0x0029 }
            r0.<init>(r1);	 Catch:{ IllegalArgumentException -> 0x0029 }
            throw r0;	 Catch:{ IllegalArgumentException -> 0x0029 }
        L_0x0029:
            r0 = new java.security.InvalidAlgorithmParameterException;
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "unknown curve name: ";
            r1.append(r2);
            r1.append(r10);
            r10 = r1.toString();
            r0.<init>(r10);
            throw r0;
        L_0x0040:
            r7 = 0;
            r8 = new org.spongycastle.jce.spec.ECNamedCurveSpec;
            r3 = r0.m40516a();
            r4 = r0.m40517b();
            r5 = r0.m40518c();
            r6 = r0.m40519d();
            r1 = r8;
            r2 = r10;
            r1.<init>(r2, r3, r4, r5, r6, r7);
            return r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi.EC.a(java.lang.String):org.spongycastle.jce.spec.ECNamedCurveSpec");
        }

        /* renamed from: a */
        protected void m35999a(String str, SecureRandom secureRandom) {
            java.security.spec.ECParameterSpec a = m35998a(str);
            this.f27405c = a;
            this.f27403a = m35996a(a, secureRandom);
        }
    }

    public static class ECDH extends EC {
        public ECDH() {
            super("ECDH", BouncyCastleProvider.f27551a);
        }
    }

    public static class ECDHC extends EC {
        public ECDHC() {
            super("ECDHC", BouncyCastleProvider.f27551a);
        }
    }

    public static class ECDSA extends EC {
        public ECDSA() {
            super("ECDSA", BouncyCastleProvider.f27551a);
        }
    }

    public static class ECMQV extends EC {
        public ECMQV() {
            super("ECMQV", BouncyCastleProvider.f27551a);
        }
    }

    public KeyPairGeneratorSpi(String str) {
        super(str);
    }
}
