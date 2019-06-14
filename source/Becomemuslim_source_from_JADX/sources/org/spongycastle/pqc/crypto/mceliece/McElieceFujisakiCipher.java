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

public class McElieceFujisakiCipher implements MessageEncryptor {
    /* renamed from: a */
    McElieceCCA2KeyParameters f27688a;
    /* renamed from: b */
    private Digest f27689b;
    /* renamed from: c */
    private SecureRandom f27690c;
    /* renamed from: d */
    private int f27691d;
    /* renamed from: e */
    private int f27692e;
    /* renamed from: f */
    private int f27693f;

    /* renamed from: a */
    public void m36345a(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.f27688a = (McElieceCCA2PrivateKeyParameters) cipherParameters;
            m36344a((McElieceCCA2PrivateKeyParameters) this.f27688a);
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f27690c = parametersWithRandom.m35697a();
            this.f27688a = (McElieceCCA2PublicKeyParameters) parametersWithRandom.m35698b();
            m36342a((McElieceCCA2PublicKeyParameters) this.f27688a);
        } else {
            this.f27690c = new SecureRandom();
            this.f27688a = (McElieceCCA2PublicKeyParameters) cipherParameters;
            m36342a((McElieceCCA2PublicKeyParameters) this.f27688a);
        }
    }

    /* renamed from: a */
    public int m36343a(McElieceCCA2KeyParameters mcElieceCCA2KeyParameters) {
        if (mcElieceCCA2KeyParameters instanceof McElieceCCA2PublicKeyParameters) {
            return ((McElieceCCA2PublicKeyParameters) mcElieceCCA2KeyParameters).m43452c();
        }
        if (mcElieceCCA2KeyParameters instanceof McElieceCCA2PrivateKeyParameters) {
            return ((McElieceCCA2PrivateKeyParameters) mcElieceCCA2KeyParameters).m43443c();
        }
        throw new IllegalArgumentException("unsupported type");
    }

    /* renamed from: a */
    private void m36342a(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters) {
        this.f27690c = this.f27690c != null ? this.f27690c : new SecureRandom();
        this.f27689b = mcElieceCCA2PublicKeyParameters.m42094b().m42095a();
        this.f27691d = mcElieceCCA2PublicKeyParameters.m43452c();
        this.f27692e = mcElieceCCA2PublicKeyParameters.m43455f();
        this.f27693f = mcElieceCCA2PublicKeyParameters.m43453d();
    }

    /* renamed from: a */
    public void m36344a(McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters) {
        this.f27689b = mcElieceCCA2PrivateKeyParameters.m42094b().m42095a();
        this.f27691d = mcElieceCCA2PrivateKeyParameters.m43443c();
        this.f27693f = mcElieceCCA2PrivateKeyParameters.m43445e();
    }

    /* renamed from: a */
    public byte[] m36346a(byte[] bArr) {
        GF2Vector gF2Vector = new GF2Vector(this.f27692e, this.f27690c);
        byte[] a = gF2Vector.m36523a();
        byte[] b = ByteUtils.m29185b(a, bArr);
        int i = 0;
        this.f27689b.mo5731a(b, 0, b.length);
        b = new byte[this.f27689b.mo5732b()];
        this.f27689b.mo5728a(b, 0);
        byte[] a2 = McElieceCCA2Primitives.m29090a((McElieceCCA2PublicKeyParameters) this.f27688a, gF2Vector, Conversions.m29088a(this.f27691d, this.f27693f, b)).m36523a();
        DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
        digestRandomGenerator.m35723a(a);
        a = new byte[bArr.length];
        digestRandomGenerator.mo5791b(a);
        while (i < bArr.length) {
            a[i] = (byte) (a[i] ^ bArr[i]);
            i++;
        }
        return ByteUtils.m29185b(a2, a);
    }

    /* renamed from: b */
    public byte[] m36347b(byte[] bArr) {
        int i = (this.f27691d + 7) >> 3;
        int length = bArr.length - i;
        bArr = ByteUtils.m29184a(bArr, i);
        byte[] bArr2 = bArr[0];
        bArr = bArr[1];
        GF2Vector[] a = McElieceCCA2Primitives.m29091a((McElieceCCA2PrivateKeyParameters) this.f27688a, GF2Vector.m36518a(this.f27691d, bArr2));
        byte[] a2 = a[0].m36523a();
        Object obj = a[1];
        DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
        digestRandomGenerator.m35723a(a2);
        byte[] bArr3 = new byte[length];
        digestRandomGenerator.mo5791b(bArr3);
        for (int i2 = 0; i2 < length; i2++) {
            bArr3[i2] = (byte) (bArr3[i2] ^ bArr[i2]);
        }
        bArr = ByteUtils.m29185b(a2, bArr3);
        byte[] bArr4 = new byte[this.f27689b.mo5732b()];
        this.f27689b.mo5731a(bArr, 0, bArr.length);
        this.f27689b.mo5728a(bArr4, 0);
        if (Conversions.m29088a(this.f27691d, this.f27693f, bArr4).equals(obj) != null) {
            return bArr3;
        }
        throw new Exception("Bad Padding: invalid ciphertext");
    }
}
