package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.prng.DigestRandomGenerator;
import org.spongycastle.pqc.crypto.MessageEncryptor;
import org.spongycastle.pqc.math.linearalgebra.ByteUtils;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;

public class McEliecePointchevalCipher implements MessageEncryptor {
    /* renamed from: a */
    McElieceCCA2KeyParameters f27720a;
    /* renamed from: b */
    private Digest f27721b;
    /* renamed from: c */
    private SecureRandom f27722c;
    /* renamed from: d */
    private int f27723d;
    /* renamed from: e */
    private int f27724e;
    /* renamed from: f */
    private int f27725f;

    /* renamed from: a */
    public void m36375a(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.f27720a = (McElieceCCA2PrivateKeyParameters) cipherParameters;
            m36373a((McElieceCCA2PrivateKeyParameters) this.f27720a);
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f27722c = parametersWithRandom.m35697a();
            this.f27720a = (McElieceCCA2PublicKeyParameters) parametersWithRandom.m35698b();
            m36374a((McElieceCCA2PublicKeyParameters) this.f27720a);
        } else {
            this.f27722c = new SecureRandom();
            this.f27720a = (McElieceCCA2PublicKeyParameters) cipherParameters;
            m36374a((McElieceCCA2PublicKeyParameters) this.f27720a);
        }
    }

    /* renamed from: a */
    public int m36372a(McElieceCCA2KeyParameters mcElieceCCA2KeyParameters) {
        if (mcElieceCCA2KeyParameters instanceof McElieceCCA2PublicKeyParameters) {
            return ((McElieceCCA2PublicKeyParameters) mcElieceCCA2KeyParameters).m43452c();
        }
        if (mcElieceCCA2KeyParameters instanceof McElieceCCA2PrivateKeyParameters) {
            return ((McElieceCCA2PrivateKeyParameters) mcElieceCCA2KeyParameters).m43443c();
        }
        throw new IllegalArgumentException("unsupported type");
    }

    /* renamed from: a */
    public void m36374a(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters) {
        this.f27722c = this.f27722c != null ? this.f27722c : new SecureRandom();
        this.f27721b = mcElieceCCA2PublicKeyParameters.m42094b().m42095a();
        this.f27723d = mcElieceCCA2PublicKeyParameters.m43452c();
        this.f27724e = mcElieceCCA2PublicKeyParameters.m43455f();
        this.f27725f = mcElieceCCA2PublicKeyParameters.m43453d();
    }

    /* renamed from: a */
    public void m36373a(McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters) {
        this.f27721b = mcElieceCCA2PrivateKeyParameters.m42094b().m42095a();
        this.f27723d = mcElieceCCA2PrivateKeyParameters.m43443c();
        this.f27724e = mcElieceCCA2PrivateKeyParameters.m43444d();
        this.f27725f = mcElieceCCA2PrivateKeyParameters.m43445e();
    }

    /* renamed from: a */
    public byte[] m36376a(byte[] bArr) {
        int i;
        int i2 = this.f27724e >> 3;
        byte[] bArr2 = new byte[i2];
        this.f27722c.nextBytes(bArr2);
        GF2Vector gF2Vector = new GF2Vector(this.f27724e, this.f27722c);
        byte[] a = gF2Vector.m36523a();
        byte[] b = ByteUtils.m29185b(bArr, bArr2);
        int i3 = 0;
        this.f27721b.mo5731a(b, 0, b.length);
        b = new byte[this.f27721b.mo5732b()];
        this.f27721b.mo5728a(b, 0);
        byte[] a2 = McElieceCCA2Primitives.m29090a((McElieceCCA2PublicKeyParameters) this.f27720a, gF2Vector, Conversions.m29088a(this.f27723d, this.f27725f, b)).m36523a();
        DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
        digestRandomGenerator.m35723a(a);
        a = new byte[(bArr.length + i2)];
        digestRandomGenerator.mo5791b(a);
        for (i = 0; i < bArr.length; i++) {
            a[i] = (byte) (a[i] ^ bArr[i]);
        }
        while (i3 < i2) {
            i = bArr.length + i3;
            a[i] = (byte) (a[i] ^ bArr2[i3]);
            i3++;
        }
        return ByteUtils.m29185b(a2, a);
    }

    /* renamed from: b */
    public byte[] m36377b(byte[] bArr) {
        int i = (this.f27723d + 7) >> 3;
        int length = bArr.length - i;
        bArr = ByteUtils.m29184a(bArr, i);
        byte[] bArr2 = bArr[0];
        bArr = bArr[1];
        GF2Vector[] a = McElieceCCA2Primitives.m29091a((McElieceCCA2PrivateKeyParameters) this.f27720a, GF2Vector.m36518a(this.f27723d, bArr2));
        byte[] a2 = a[0].m36523a();
        Object obj = a[1];
        DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
        digestRandomGenerator.m35723a(a2);
        a2 = new byte[length];
        digestRandomGenerator.mo5791b(a2);
        for (int i2 = 0; i2 < length; i2++) {
            a2[i2] = (byte) (a2[i2] ^ bArr[i2]);
        }
        this.f27721b.mo5731a(a2, 0, a2.length);
        bArr = new byte[this.f27721b.mo5732b()];
        this.f27721b.mo5728a(bArr, 0);
        if (Conversions.m29088a(this.f27723d, this.f27725f, bArr).equals(obj) != null) {
            return ByteUtils.m29184a(a2, length - (this.f27724e >> 3))[0];
        }
        throw new Exception("Bad Padding: Invalid ciphertext.");
    }
}
