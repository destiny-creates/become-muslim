package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2KeyGenerationParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2KeyPairGenerator;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2Parameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceKeyGenerationParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceKeyPairGenerator;
import org.spongycastle.pqc.crypto.mceliece.McElieceParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.ECCKeyGenParameterSpec;

public abstract class McElieceKeyPairGeneratorSpi extends KeyPairGenerator {

    public static class McEliece extends McElieceKeyPairGeneratorSpi {
        /* renamed from: a */
        McElieceKeyPairGenerator f27857a;

        public McEliece() {
            super("McEliece");
        }

        public void initialize(AlgorithmParameterSpec algorithmParameterSpec) {
            this.f27857a = new McElieceKeyPairGenerator();
            super.initialize(algorithmParameterSpec);
            ECCKeyGenParameterSpec eCCKeyGenParameterSpec = (ECCKeyGenParameterSpec) algorithmParameterSpec;
            this.f27857a.m36353a(new McElieceKeyGenerationParameters(new SecureRandom(), new McElieceParameters(eCCKeyGenParameterSpec.m29168a(), eCCKeyGenParameterSpec.m29169b())));
        }

        public void initialize(int r1, java.security.SecureRandom r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = this;
            r1 = new org.spongycastle.pqc.jcajce.spec.ECCKeyGenParameterSpec;
            r1.<init>();
            r0.initialize(r1);	 Catch:{ InvalidAlgorithmParameterException -> 0x0008 }
        L_0x0008:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi.McEliece.initialize(int, java.security.SecureRandom):void");
        }

        public KeyPair generateKeyPair() {
            AsymmetricCipherKeyPair a = this.f27857a.mo5755a();
            return new KeyPair(new BCMcEliecePublicKey((McEliecePublicKeyParameters) a.m27281a()), new BCMcEliecePrivateKey((McEliecePrivateKeyParameters) a.m27282b()));
        }
    }

    public static class McElieceCCA2 extends McElieceKeyPairGeneratorSpi {
        /* renamed from: a */
        McElieceCCA2KeyPairGenerator f27858a;

        public McElieceCCA2() {
            super("McElieceCCA-2");
        }

        public void initialize(AlgorithmParameterSpec algorithmParameterSpec) {
            this.f27858a = new McElieceCCA2KeyPairGenerator();
            super.initialize(algorithmParameterSpec);
            ECCKeyGenParameterSpec eCCKeyGenParameterSpec = (ECCKeyGenParameterSpec) algorithmParameterSpec;
            this.f27858a.m36341a(new McElieceCCA2KeyGenerationParameters(new SecureRandom(), new McElieceCCA2Parameters(eCCKeyGenParameterSpec.m29168a(), eCCKeyGenParameterSpec.m29169b())));
        }

        public void initialize(int r1, java.security.SecureRandom r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = this;
            r1 = new org.spongycastle.pqc.jcajce.spec.McElieceCCA2ParameterSpec;
            r1.<init>();
            r0.initialize(r1);	 Catch:{ InvalidAlgorithmParameterException -> 0x0008 }
        L_0x0008:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi.McElieceCCA2.initialize(int, java.security.SecureRandom):void");
        }

        public KeyPair generateKeyPair() {
            AsymmetricCipherKeyPair a = this.f27858a.mo5755a();
            return new KeyPair(new BCMcElieceCCA2PublicKey((McElieceCCA2PublicKeyParameters) a.m27281a()), new BCMcElieceCCA2PrivateKey((McElieceCCA2PrivateKeyParameters) a.m27282b()));
        }
    }

    public McElieceKeyPairGeneratorSpi(String str) {
        super(str);
    }
}
