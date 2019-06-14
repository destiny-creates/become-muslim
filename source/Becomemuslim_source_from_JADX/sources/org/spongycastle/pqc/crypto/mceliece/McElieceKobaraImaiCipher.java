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
import org.spongycastle.pqc.math.linearalgebra.IntegerFunctions;

public class McElieceKobaraImaiCipher implements MessageEncryptor {
    /* renamed from: a */
    public static final byte[] f27702a = "a predetermined public constant".getBytes();
    /* renamed from: b */
    McElieceCCA2KeyParameters f27703b;
    /* renamed from: c */
    private Digest f27704c;
    /* renamed from: d */
    private SecureRandom f27705d;
    /* renamed from: e */
    private int f27706e;
    /* renamed from: f */
    private int f27707f;
    /* renamed from: g */
    private int f27708g;

    /* renamed from: a */
    public void m36357a(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.f27703b = (McElieceCCA2PrivateKeyParameters) cipherParameters;
            m36356a((McElieceCCA2PrivateKeyParameters) this.f27703b);
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f27705d = parametersWithRandom.m35697a();
            this.f27703b = (McElieceCCA2PublicKeyParameters) parametersWithRandom.m35698b();
            m36354a((McElieceCCA2PublicKeyParameters) this.f27703b);
        } else {
            this.f27705d = new SecureRandom();
            this.f27703b = (McElieceCCA2PublicKeyParameters) cipherParameters;
            m36354a((McElieceCCA2PublicKeyParameters) this.f27703b);
        }
    }

    /* renamed from: a */
    public int m36355a(McElieceCCA2KeyParameters mcElieceCCA2KeyParameters) {
        if (mcElieceCCA2KeyParameters instanceof McElieceCCA2PublicKeyParameters) {
            return ((McElieceCCA2PublicKeyParameters) mcElieceCCA2KeyParameters).m43452c();
        }
        if (mcElieceCCA2KeyParameters instanceof McElieceCCA2PrivateKeyParameters) {
            return ((McElieceCCA2PrivateKeyParameters) mcElieceCCA2KeyParameters).m43443c();
        }
        throw new IllegalArgumentException("unsupported type");
    }

    /* renamed from: a */
    private void m36354a(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters) {
        this.f27704c = mcElieceCCA2PublicKeyParameters.m42094b().m42095a();
        this.f27706e = mcElieceCCA2PublicKeyParameters.m43452c();
        this.f27707f = mcElieceCCA2PublicKeyParameters.m43455f();
        this.f27708g = mcElieceCCA2PublicKeyParameters.m43453d();
    }

    /* renamed from: a */
    public void m36356a(McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters) {
        this.f27704c = mcElieceCCA2PrivateKeyParameters.m42094b().m42095a();
        this.f27706e = mcElieceCCA2PrivateKeyParameters.m43443c();
        this.f27707f = mcElieceCCA2PrivateKeyParameters.m43444d();
        this.f27708g = mcElieceCCA2PrivateKeyParameters.m43445e();
    }

    /* renamed from: a */
    public byte[] m36358a(byte[] bArr) {
        int b = this.f27704c.mo5732b();
        int i = this.f27707f >> 3;
        int bitLength = (IntegerFunctions.m29236a(this.f27706e, this.f27708g).bitLength() - 1) >> 3;
        int length = ((i + bitLength) - b) - f27702a.length;
        if (bArr.length > length) {
            length = bArr.length;
        }
        int length2 = f27702a.length + length;
        int i2 = ((length2 + b) - i) - bitLength;
        Object obj = new byte[length2];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        System.arraycopy(f27702a, 0, obj, length, f27702a.length);
        bArr = new byte[b];
        this.f27705d.nextBytes(bArr);
        DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
        digestRandomGenerator.m35723a(bArr);
        byte[] bArr2 = new byte[length2];
        digestRandomGenerator.mo5791b(bArr2);
        for (length2--; length2 >= 0; length2--) {
            bArr2[length2] = (byte) (bArr2[length2] ^ obj[length2]);
        }
        byte[] bArr3 = new byte[this.f27704c.mo5732b()];
        this.f27704c.mo5731a(bArr2, 0, bArr2.length);
        this.f27704c.mo5728a(bArr3, 0);
        for (b--; b >= 0; b--) {
            bArr3[b] = (byte) (bArr3[b] ^ bArr[b]);
        }
        bArr = ByteUtils.m29185b(bArr3, bArr2);
        byte[] bArr4 = new byte[0];
        if (i2 > 0) {
            bArr4 = new byte[i2];
            System.arraycopy(bArr, 0, bArr4, 0, i2);
        }
        bArr3 = new byte[bitLength];
        System.arraycopy(bArr, i2, bArr3, 0, bitLength);
        Object obj2 = new byte[i];
        System.arraycopy(bArr, bitLength + i2, obj2, 0, i);
        bArr = McElieceCCA2Primitives.m29090a((McElieceCCA2PublicKeyParameters) this.f27703b, GF2Vector.m36518a(this.f27707f, obj2), Conversions.m29088a(this.f27706e, this.f27708g, bArr3)).m36523a();
        return i2 > 0 ? ByteUtils.m29185b(bArr4, bArr) : bArr;
    }

    /* renamed from: b */
    public byte[] m36359b(byte[] bArr) {
        int i = this.f27706e >> 3;
        if (bArr.length >= i) {
            byte[] bArr2;
            int b = this.f27704c.mo5732b();
            int i2 = this.f27707f >> 3;
            int length = bArr.length - i;
            if (length > 0) {
                bArr = ByteUtils.m29184a(bArr, length);
                bArr2 = bArr[0];
                bArr = bArr[1];
            } else {
                bArr2 = new byte[0];
            }
            bArr = McElieceCCA2Primitives.m29091a((McElieceCCA2PrivateKeyParameters) this.f27703b, GF2Vector.m36518a(this.f27706e, bArr));
            byte[] a = bArr[0].m36523a();
            GF2Vector gF2Vector = bArr[1];
            if (a.length > i2) {
                a = ByteUtils.m29183a(a, 0, i2);
            }
            bArr = ByteUtils.m29185b(ByteUtils.m29185b(bArr2, Conversions.m29089a(this.f27706e, this.f27708g, gF2Vector)), a);
            i2 = bArr.length - b;
            bArr = ByteUtils.m29184a(bArr, b);
            bArr2 = bArr[0];
            bArr = bArr[1];
            a = new byte[this.f27704c.mo5732b()];
            this.f27704c.mo5731a(bArr, 0, bArr.length);
            this.f27704c.mo5728a(a, 0);
            for (b--; b >= 0; b--) {
                a[b] = (byte) (a[b] ^ bArr2[b]);
            }
            DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
            digestRandomGenerator.m35723a(a);
            bArr2 = new byte[i2];
            digestRandomGenerator.mo5791b(bArr2);
            for (b = i2 - 1; b >= 0; b--) {
                bArr2[b] = (byte) (bArr2[b] ^ bArr[b]);
            }
            if (bArr2.length >= i2) {
                bArr = ByteUtils.m29184a(bArr2, i2 - f27702a.length);
                byte[] bArr3 = bArr[0];
                if (ByteUtils.m29182a(bArr[1], f27702a) != null) {
                    return bArr3;
                }
                throw new Exception("Bad Padding: invalid ciphertext");
            }
            throw new Exception("Bad Padding: invalid ciphertext");
        }
        throw new Exception("Bad Padding: Ciphertext too short.");
    }
}
