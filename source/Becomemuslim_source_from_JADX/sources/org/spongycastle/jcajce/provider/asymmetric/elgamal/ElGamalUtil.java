package org.spongycastle.jcajce.provider.asymmetric.elgamal;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;
import org.spongycastle.jce.interfaces.ElGamalPrivateKey;
import org.spongycastle.jce.interfaces.ElGamalPublicKey;

public class ElGamalUtil {
    /* renamed from: a */
    public static AsymmetricKeyParameter m27971a(PublicKey publicKey) {
        if (publicKey instanceof ElGamalPublicKey) {
            ElGamalPublicKey elGamalPublicKey = (ElGamalPublicKey) publicKey;
            return new ElGamalPublicKeyParameters(elGamalPublicKey.getY(), new ElGamalParameters(elGamalPublicKey.mo6506b().m28321a(), elGamalPublicKey.mo6506b().m28322b()));
        } else if (publicKey instanceof DHPublicKey) {
            DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
            return new ElGamalPublicKeyParameters(dHPublicKey.getY(), new ElGamalParameters(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG()));
        } else {
            throw new InvalidKeyException("can't identify public key for El Gamal.");
        }
    }

    /* renamed from: a */
    public static AsymmetricKeyParameter m27970a(PrivateKey privateKey) {
        if (privateKey instanceof ElGamalPrivateKey) {
            ElGamalPrivateKey elGamalPrivateKey = (ElGamalPrivateKey) privateKey;
            return new ElGamalPrivateKeyParameters(elGamalPrivateKey.getX(), new ElGamalParameters(elGamalPrivateKey.mo6506b().m28321a(), elGamalPrivateKey.mo6506b().m28322b()));
        } else if (privateKey instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) privateKey;
            return new ElGamalPrivateKeyParameters(dHPrivateKey.getX(), new ElGamalParameters(dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG()));
        } else {
            throw new InvalidKeyException("can't identify private key for El Gamal.");
        }
    }
}
