package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import org.spongycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;

public class RainbowKeysToParams {
    /* renamed from: a */
    public static AsymmetricKeyParameter m29154a(PublicKey publicKey) {
        if (publicKey instanceof BCRainbowPublicKey) {
            BCRainbowPublicKey bCRainbowPublicKey = (BCRainbowPublicKey) publicKey;
            return new RainbowPublicKeyParameters(bCRainbowPublicKey.m29149a(), bCRainbowPublicKey.m29150b(), bCRainbowPublicKey.m29151c(), bCRainbowPublicKey.m29152d());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("can't identify Rainbow public key: ");
        stringBuilder.append(publicKey.getClass().getName());
        throw new InvalidKeyException(stringBuilder.toString());
    }

    /* renamed from: a */
    public static AsymmetricKeyParameter m29153a(PrivateKey privateKey) {
        if (privateKey instanceof BCRainbowPrivateKey) {
            BCRainbowPrivateKey bCRainbowPrivateKey = (BCRainbowPrivateKey) privateKey;
            return new RainbowPrivateKeyParameters(bCRainbowPrivateKey.m29143a(), bCRainbowPrivateKey.m29144b(), bCRainbowPrivateKey.m29146d(), bCRainbowPrivateKey.m29145c(), bCRainbowPrivateKey.m29148f(), bCRainbowPrivateKey.m29147e());
        }
        throw new InvalidKeyException("can't identify Rainbow private key.");
    }
}
