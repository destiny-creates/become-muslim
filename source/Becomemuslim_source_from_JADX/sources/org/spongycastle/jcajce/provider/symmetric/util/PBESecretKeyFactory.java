package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.symmetric.util.PBE.Util;

public class PBESecretKeyFactory extends BaseSecretKeyFactory implements PBE {
    /* renamed from: c */
    private boolean f31986c;
    /* renamed from: d */
    private int f31987d;
    /* renamed from: e */
    private int f31988e;
    /* renamed from: f */
    private int f31989f;
    /* renamed from: g */
    private int f31990g;

    public PBESecretKeyFactory(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, int i, int i2, int i3, int i4) {
        super(str, aSN1ObjectIdentifier);
        this.f31986c = z;
        this.f31987d = i;
        this.f31988e = i2;
        this.f31989f = i3;
        this.f31990g = i4;
    }

    protected SecretKey engineGenerateSecret(KeySpec keySpec) {
        if (keySpec instanceof PBEKeySpec) {
            PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
            if (pBEKeySpec.getSalt() == null) {
                return new BCPBEKey(this.a, this.b, this.f31987d, this.f31988e, this.f31989f, this.f31990g, pBEKeySpec, null);
            }
            if (this.f31986c != null) {
                keySpec = Util.m28091a(pBEKeySpec, this.f31987d, this.f31988e, this.f31989f, this.f31990g);
            } else {
                keySpec = Util.m28090a(pBEKeySpec, this.f31987d, this.f31988e, this.f31989f);
            }
            return new BCPBEKey(this.a, this.b, this.f31987d, this.f31988e, this.f31989f, this.f31990g, pBEKeySpec, keySpec);
        }
        throw new InvalidKeySpecException("Invalid KeySpec");
    }
}
