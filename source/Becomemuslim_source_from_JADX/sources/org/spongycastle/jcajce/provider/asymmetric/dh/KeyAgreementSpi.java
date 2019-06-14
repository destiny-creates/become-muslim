package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;

public class KeyAgreementSpi extends BaseAgreementSpi {
    /* renamed from: a */
    private BigInteger f27380a;
    /* renamed from: b */
    private BigInteger f27381b;
    /* renamed from: c */
    private BigInteger f27382c;
    /* renamed from: d */
    private BigInteger f27383d;

    /* renamed from: a */
    private byte[] m35985a(BigInteger bigInteger) {
        int bitLength = (this.f27381b.bitLength() + 7) / 8;
        bigInteger = bigInteger.toByteArray();
        if (bigInteger.length == bitLength) {
            return bigInteger;
        }
        if (bigInteger[0] == (byte) 0 && bigInteger.length == bitLength + 1) {
            Object obj = new byte[(bigInteger.length - 1)];
            System.arraycopy(bigInteger, 1, obj, 0, obj.length);
            return obj;
        }
        obj = new byte[bitLength];
        System.arraycopy(bigInteger, 0, obj, obj.length - bigInteger.length, bigInteger.length);
        return obj;
    }

    protected Key engineDoPhase(Key key, boolean z) {
        if (this.f27380a == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        } else if (key instanceof DHPublicKey) {
            DHPublicKey dHPublicKey = (DHPublicKey) key;
            if (!dHPublicKey.getParams().getG().equals(this.f27382c) || !dHPublicKey.getParams().getP().equals(this.f27381b)) {
                throw new InvalidKeyException("DHPublicKey not for this KeyAgreement!");
            } else if (z) {
                this.f27383d = dHPublicKey.getY().modPow(this.f27380a, this.f27381b);
                return null;
            } else {
                this.f27383d = dHPublicKey.getY().modPow(this.f27380a, this.f27381b);
                return new BCDHPublicKey(this.f27383d, dHPublicKey.getParams());
            }
        } else {
            throw new InvalidKeyException("DHKeyAgreement doPhase requires DHPublicKey");
        }
    }

    protected byte[] engineGenerateSecret() {
        if (this.f27380a != null) {
            return m35985a(this.f27383d);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    protected int engineGenerateSecret(byte[] bArr, int i) {
        if (this.f27380a != null) {
            Object a = m35985a(this.f27383d);
            if (bArr.length - i >= a.length) {
                System.arraycopy(a, 0, bArr, i, a.length);
                return a.length;
            }
            throw new ShortBufferException("DHKeyAgreement - buffer too short");
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    protected SecretKey engineGenerateSecret(String str) {
        if (this.f27380a != null) {
            String a = BaseAgreementSpi.m27987a(str);
            Object a2 = m35985a(this.f27383d);
            str = BaseAgreementSpi.m27988b(str);
            if (str <= null) {
                return new SecretKeySpec(a2, a);
            }
            str = new byte[(str / 8)];
            System.arraycopy(a2, 0, str, 0, str.length);
            if (a.startsWith("DES")) {
                DESParameters.m40788a(str);
            }
            return new SecretKeySpec(str, a);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    protected void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if ((key instanceof DHPrivateKey) != null) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            if (algorithmParameterSpec == null) {
                this.f27381b = dHPrivateKey.getParams().getP();
                this.f27382c = dHPrivateKey.getParams().getG();
            } else if ((algorithmParameterSpec instanceof DHParameterSpec) != null) {
                DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                this.f27381b = dHParameterSpec.getP();
                this.f27382c = dHParameterSpec.getG();
            } else {
                throw new InvalidAlgorithmParameterException("DHKeyAgreement only accepts DHParameterSpec");
            }
            key = dHPrivateKey.getX();
            this.f27383d = key;
            this.f27380a = key;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey for initialisation");
    }

    protected void engineInit(Key key, SecureRandom secureRandom) {
        if ((key instanceof DHPrivateKey) != null) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            this.f27381b = dHPrivateKey.getParams().getP();
            this.f27382c = dHPrivateKey.getParams().getG();
            key = dHPrivateKey.getX();
            this.f27383d = key;
            this.f27380a = key;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey");
    }
}
