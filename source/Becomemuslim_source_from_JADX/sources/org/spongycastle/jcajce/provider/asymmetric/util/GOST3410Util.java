package org.spongycastle.jcajce.provider.asymmetric.util;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.GOST3410Parameters;
import org.spongycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.spongycastle.crypto.params.GOST3410PublicKeyParameters;
import org.spongycastle.jce.interfaces.GOST3410PrivateKey;
import org.spongycastle.jce.interfaces.GOST3410PublicKey;
import org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public class GOST3410Util {
    /* renamed from: a */
    public static AsymmetricKeyParameter m28015a(PublicKey publicKey) {
        if (publicKey instanceof GOST3410PublicKey) {
            GOST3410PublicKey gOST3410PublicKey = (GOST3410PublicKey) publicKey;
            GOST3410PublicKeyParameterSetSpec d = gOST3410PublicKey.mo6509b().mo5893d();
            return new GOST3410PublicKeyParameters(gOST3410PublicKey.mo6511a(), new GOST3410Parameters(d.m28327a(), d.m28328b(), d.m28329c()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("can't identify GOST3410 public key: ");
        stringBuilder.append(publicKey.getClass().getName());
        throw new InvalidKeyException(stringBuilder.toString());
    }

    /* renamed from: a */
    public static AsymmetricKeyParameter m28014a(PrivateKey privateKey) {
        if (privateKey instanceof GOST3410PrivateKey) {
            GOST3410PrivateKey gOST3410PrivateKey = (GOST3410PrivateKey) privateKey;
            GOST3410PublicKeyParameterSetSpec d = gOST3410PrivateKey.mo6509b().mo5893d();
            return new GOST3410PrivateKeyParameters(gOST3410PrivateKey.mo6510c(), new GOST3410Parameters(d.m28327a(), d.m28328b(), d.m28329c()));
        }
        throw new InvalidKeyException("can't identify GOST3410 private key.");
    }
}
