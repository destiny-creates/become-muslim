package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.RainbowPrivateKey;
import org.spongycastle.pqc.crypto.rainbow.Layer;
import org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.spongycastle.pqc.jcajce.spec.RainbowPrivateKeySpec;

public class BCRainbowPrivateKey implements PrivateKey {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private short[][] f23328a;
    /* renamed from: b */
    private short[] f23329b;
    /* renamed from: c */
    private short[][] f23330c;
    /* renamed from: d */
    private short[] f23331d;
    /* renamed from: e */
    private Layer[] f23332e;
    /* renamed from: f */
    private int[] f23333f;

    public final String getAlgorithm() {
        return "Rainbow";
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public BCRainbowPrivateKey(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, Layer[] layerArr) {
        this.f23328a = sArr;
        this.f23329b = sArr2;
        this.f23330c = sArr3;
        this.f23331d = sArr4;
        this.f23333f = iArr;
        this.f23332e = layerArr;
    }

    public BCRainbowPrivateKey(RainbowPrivateKeySpec rainbowPrivateKeySpec) {
        this(rainbowPrivateKeySpec.m29172b(), rainbowPrivateKeySpec.m29171a(), rainbowPrivateKeySpec.m29174d(), rainbowPrivateKeySpec.m29173c(), rainbowPrivateKeySpec.m29176f(), rainbowPrivateKeySpec.m29175e());
    }

    public BCRainbowPrivateKey(RainbowPrivateKeyParameters rainbowPrivateKeyParameters) {
        this(rainbowPrivateKeyParameters.m43473d(), rainbowPrivateKeyParameters.m43472c(), rainbowPrivateKeyParameters.m43475f(), rainbowPrivateKeyParameters.m43474e(), rainbowPrivateKeyParameters.m43477h(), rainbowPrivateKeyParameters.m43476g());
    }

    /* renamed from: a */
    public short[][] m29143a() {
        return this.f23328a;
    }

    /* renamed from: b */
    public short[] m29144b() {
        return this.f23329b;
    }

    /* renamed from: c */
    public short[] m29145c() {
        return this.f23331d;
    }

    /* renamed from: d */
    public short[][] m29146d() {
        return this.f23330c;
    }

    /* renamed from: e */
    public Layer[] m29147e() {
        return this.f23332e;
    }

    /* renamed from: f */
    public int[] m29148f() {
        return this.f23333f;
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof BCRainbowPrivateKey) {
                BCRainbowPrivateKey bCRainbowPrivateKey = (BCRainbowPrivateKey) obj;
                Object obj2 = ((RainbowUtil.m29129a(this.f23328a, bCRainbowPrivateKey.m29143a()) ? 1 : null) == null || !RainbowUtil.m29129a(this.f23330c, bCRainbowPrivateKey.m29146d())) ? null : 1;
                obj2 = (obj2 == null || !RainbowUtil.m29128a(this.f23329b, bCRainbowPrivateKey.m29144b())) ? null : 1;
                obj2 = (obj2 == null || !RainbowUtil.m29128a(this.f23331d, bCRainbowPrivateKey.m29145c())) ? null : 1;
                boolean z = obj2 != null && Arrays.equals(this.f23333f, bCRainbowPrivateKey.m29148f());
                if (this.f23332e.length != bCRainbowPrivateKey.m29147e().length) {
                    return false;
                }
                for (int length = this.f23332e.length - 1; length >= 0; length--) {
                    z &= this.f23332e[length].equals(bCRainbowPrivateKey.m29147e()[length]);
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        int length = (((((((((this.f23332e.length * 37) + org.spongycastle.util.Arrays.m29349a(this.f23328a)) * 37) + org.spongycastle.util.Arrays.m29348a(this.f23329b)) * 37) + org.spongycastle.util.Arrays.m29349a(this.f23330c)) * 37) + org.spongycastle.util.Arrays.m29348a(this.f23331d)) * 37) + org.spongycastle.util.Arrays.m29344a(this.f23333f);
        for (int length2 = this.f23332e.length - 1; length2 >= 0; length2--) {
            length = (length * 37) + this.f23332e[length2].hashCode();
        }
        return length;
    }

    public byte[] getEncoded() {
        try {
            try {
                return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.f23164a, DERNull.f32850a), new RainbowPrivateKey(this.f23328a, this.f23329b, this.f23330c, this.f23331d, this.f23333f, this.f23332e)).mo6822f();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
