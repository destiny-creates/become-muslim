package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;

public class McElieceCCA2KeysToParams {
    /* renamed from: a */
    public static AsymmetricKeyParameter m29140a(PublicKey publicKey) {
        if (publicKey instanceof BCMcElieceCCA2PublicKey) {
            BCMcElieceCCA2PublicKey bCMcElieceCCA2PublicKey = (BCMcElieceCCA2PublicKey) publicKey;
            return new McElieceCCA2PublicKeyParameters(bCMcElieceCCA2PublicKey.m36447d(), bCMcElieceCCA2PublicKey.m36444a(), bCMcElieceCCA2PublicKey.m36445b(), bCMcElieceCCA2PublicKey.m36446c(), bCMcElieceCCA2PublicKey.m36449f());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("can't identify McElieceCCA2 public key: ");
        stringBuilder.append(publicKey.getClass().getName());
        throw new InvalidKeyException(stringBuilder.toString());
    }

    /* renamed from: a */
    public static AsymmetricKeyParameter m29139a(PrivateKey privateKey) {
        if (privateKey instanceof BCMcElieceCCA2PrivateKey) {
            BCMcElieceCCA2PrivateKey bCMcElieceCCA2PrivateKey = (BCMcElieceCCA2PrivateKey) privateKey;
            return new McElieceCCA2PrivateKeyParameters(bCMcElieceCCA2PrivateKey.m36441h(), bCMcElieceCCA2PrivateKey.m36434a(), bCMcElieceCCA2PrivateKey.m36435b(), bCMcElieceCCA2PrivateKey.m36436c(), bCMcElieceCCA2PrivateKey.m36437d(), bCMcElieceCCA2PrivateKey.m36438e(), bCMcElieceCCA2PrivateKey.m36439f(), bCMcElieceCCA2PrivateKey.m36440g(), bCMcElieceCCA2PrivateKey.m36443j());
        }
        throw new InvalidKeyException("can't identify McElieceCCA2 private key.");
    }
}
