package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.security.PublicKey;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.RainbowPublicKey;
import org.spongycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.spongycastle.pqc.jcajce.provider.util.KeyUtil;
import org.spongycastle.pqc.jcajce.spec.RainbowPublicKeySpec;
import org.spongycastle.util.Arrays;

public class BCRainbowPublicKey implements PublicKey {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private short[][] f23334a;
    /* renamed from: b */
    private short[][] f23335b;
    /* renamed from: c */
    private short[] f23336c;
    /* renamed from: d */
    private int f23337d;

    public final String getAlgorithm() {
        return "Rainbow";
    }

    public String getFormat() {
        return "X.509";
    }

    public BCRainbowPublicKey(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f23337d = i;
        this.f23334a = sArr;
        this.f23335b = sArr2;
        this.f23336c = sArr3;
    }

    public BCRainbowPublicKey(RainbowPublicKeySpec rainbowPublicKeySpec) {
        this(rainbowPublicKeySpec.m29177a(), rainbowPublicKeySpec.m29178b(), rainbowPublicKeySpec.m29179c(), rainbowPublicKeySpec.m29180d());
    }

    public BCRainbowPublicKey(RainbowPublicKeyParameters rainbowPublicKeyParameters) {
        this(rainbowPublicKeyParameters.m42098b(), rainbowPublicKeyParameters.m43478c(), rainbowPublicKeyParameters.m43479d(), rainbowPublicKeyParameters.m43480e());
    }

    /* renamed from: a */
    public int m29149a() {
        return this.f23337d;
    }

    /* renamed from: b */
    public short[][] m29150b() {
        return this.f23334a;
    }

    /* renamed from: c */
    public short[][] m29151c() {
        short[][] sArr = new short[this.f23335b.length][];
        for (int i = 0; i != this.f23335b.length; i++) {
            sArr[i] = Arrays.m29380b(this.f23335b[i]);
        }
        return sArr;
    }

    /* renamed from: d */
    public short[] m29152d() {
        return Arrays.m29380b(this.f23336c);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            if (obj instanceof BCRainbowPublicKey) {
                BCRainbowPublicKey bCRainbowPublicKey = (BCRainbowPublicKey) obj;
                if (this.f23337d == bCRainbowPublicKey.m29149a() && RainbowUtil.m29129a(this.f23334a, bCRainbowPublicKey.m29150b()) && RainbowUtil.m29129a(this.f23335b, bCRainbowPublicKey.m29151c()) && RainbowUtil.m29128a(this.f23336c, bCRainbowPublicKey.m29152d()) != null) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f23337d * 37) + Arrays.m29349a(this.f23334a)) * 37) + Arrays.m29349a(this.f23335b)) * 37) + Arrays.m29348a(this.f23336c);
    }

    public byte[] getEncoded() {
        return KeyUtil.m29166a(new AlgorithmIdentifier(PQCObjectIdentifiers.f23164a, DERNull.f32850a), new RainbowPublicKey(this.f23337d, this.f23334a, this.f23335b, this.f23336c));
    }
}
