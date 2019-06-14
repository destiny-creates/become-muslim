package org.spongycastle.jcajce.provider.symmetric.util;

import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class BCPBEKey implements PBEKey {
    /* renamed from: a */
    String f22870a;
    /* renamed from: b */
    ASN1ObjectIdentifier f22871b;
    /* renamed from: c */
    int f22872c;
    /* renamed from: d */
    int f22873d;
    /* renamed from: e */
    int f22874e;
    /* renamed from: f */
    int f22875f;
    /* renamed from: g */
    CipherParameters f22876g;
    /* renamed from: h */
    PBEKeySpec f22877h;
    /* renamed from: i */
    boolean f22878i = false;

    public String getFormat() {
        return "RAW";
    }

    public BCPBEKey(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, int i2, int i3, int i4, PBEKeySpec pBEKeySpec, CipherParameters cipherParameters) {
        this.f22870a = str;
        this.f22871b = aSN1ObjectIdentifier;
        this.f22872c = i;
        this.f22873d = i2;
        this.f22874e = i3;
        this.f22875f = i4;
        this.f22877h = pBEKeySpec;
        this.f22876g = cipherParameters;
    }

    public String getAlgorithm() {
        return this.f22870a;
    }

    public byte[] getEncoded() {
        if (this.f22876g != null) {
            KeyParameter keyParameter;
            if (this.f22876g instanceof ParametersWithIV) {
                keyParameter = (KeyParameter) ((ParametersWithIV) this.f22876g).m35696b();
            } else {
                keyParameter = (KeyParameter) this.f22876g;
            }
            return keyParameter.m35685a();
        } else if (this.f22872c == 2) {
            return PBEParametersGenerator.m27336c(this.f22877h.getPassword());
        } else {
            if (this.f22872c == 5) {
                return PBEParametersGenerator.m27335b(this.f22877h.getPassword());
            }
            return PBEParametersGenerator.m27334a(this.f22877h.getPassword());
        }
    }

    /* renamed from: a */
    int m28069a() {
        return this.f22872c;
    }

    /* renamed from: b */
    int m28070b() {
        return this.f22873d;
    }

    /* renamed from: c */
    int m28071c() {
        return this.f22874e;
    }

    /* renamed from: d */
    public int m28072d() {
        return this.f22875f;
    }

    /* renamed from: e */
    public CipherParameters m28073e() {
        return this.f22876g;
    }

    public char[] getPassword() {
        return this.f22877h.getPassword();
    }

    public byte[] getSalt() {
        return this.f22877h.getSalt();
    }

    public int getIterationCount() {
        return this.f22877h.getIterationCount();
    }

    /* renamed from: f */
    public ASN1ObjectIdentifier m28074f() {
        return this.f22871b;
    }

    /* renamed from: g */
    boolean m28075g() {
        return this.f22878i;
    }
}
