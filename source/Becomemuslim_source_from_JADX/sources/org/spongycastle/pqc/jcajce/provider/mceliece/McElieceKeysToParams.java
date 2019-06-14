package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;

public class McElieceKeysToParams {
    /* renamed from: a */
    public static AsymmetricKeyParameter m29142a(PublicKey publicKey) {
        if (publicKey instanceof BCMcEliecePublicKey) {
            BCMcEliecePublicKey bCMcEliecePublicKey = (BCMcEliecePublicKey) publicKey;
            return new McEliecePublicKeyParameters(bCMcEliecePublicKey.m36465d(), bCMcEliecePublicKey.m36462a(), bCMcEliecePublicKey.m36463b(), bCMcEliecePublicKey.m36464c(), bCMcEliecePublicKey.m36467f());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("can't identify McEliece public key: ");
        stringBuilder.append(publicKey.getClass().getName());
        throw new InvalidKeyException(stringBuilder.toString());
    }

    /* renamed from: a */
    public static AsymmetricKeyParameter m29141a(PrivateKey privateKey) {
        if (privateKey instanceof BCMcEliecePrivateKey) {
            BCMcEliecePrivateKey bCMcEliecePrivateKey = (BCMcEliecePrivateKey) privateKey;
            return new McEliecePrivateKeyParameters(bCMcEliecePrivateKey.m36459j(), bCMcEliecePrivateKey.m36450a(), bCMcEliecePrivateKey.m36451b(), bCMcEliecePrivateKey.m36452c(), bCMcEliecePrivateKey.m36453d(), bCMcEliecePrivateKey.m36454e(), bCMcEliecePrivateKey.m36455f(), bCMcEliecePrivateKey.m36456g(), bCMcEliecePrivateKey.m36457h(), bCMcEliecePrivateKey.m36458i(), bCMcEliecePrivateKey.m36461l());
        }
        throw new InvalidKeyException("can't identify McEliece private key.");
    }
}
