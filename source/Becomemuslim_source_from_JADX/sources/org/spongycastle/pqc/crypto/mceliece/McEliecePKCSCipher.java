package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.MessageEncryptor;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.spongycastle.pqc.math.linearalgebra.Vector;

public class McEliecePKCSCipher implements MessageEncryptor {
    /* renamed from: a */
    public int f27709a;
    /* renamed from: b */
    public int f27710b;
    /* renamed from: c */
    McElieceKeyParameters f27711c;
    /* renamed from: d */
    private SecureRandom f27712d;
    /* renamed from: e */
    private int f27713e;
    /* renamed from: f */
    private int f27714f;
    /* renamed from: g */
    private int f27715g;

    /* renamed from: a */
    public void m36365a(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.f27711c = (McEliecePrivateKeyParameters) cipherParameters;
            m36363a((McEliecePrivateKeyParameters) this.f27711c);
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f27712d = parametersWithRandom.m35697a();
            this.f27711c = (McEliecePublicKeyParameters) parametersWithRandom.m35698b();
            m36364a((McEliecePublicKeyParameters) this.f27711c);
        } else {
            this.f27712d = new SecureRandom();
            this.f27711c = (McEliecePublicKeyParameters) cipherParameters;
            m36364a((McEliecePublicKeyParameters) this.f27711c);
        }
    }

    /* renamed from: a */
    public int m36362a(McElieceKeyParameters mcElieceKeyParameters) {
        if (mcElieceKeyParameters instanceof McEliecePublicKeyParameters) {
            return ((McEliecePublicKeyParameters) mcElieceKeyParameters).m43467c();
        }
        if (mcElieceKeyParameters instanceof McEliecePrivateKeyParameters) {
            return ((McEliecePrivateKeyParameters) mcElieceKeyParameters).m43457c();
        }
        throw new IllegalArgumentException("unsupported type");
    }

    /* renamed from: a */
    public void m36364a(McEliecePublicKeyParameters mcEliecePublicKeyParameters) {
        this.f27712d = this.f27712d != null ? this.f27712d : new SecureRandom();
        this.f27713e = mcEliecePublicKeyParameters.m43467c();
        this.f27714f = mcEliecePublicKeyParameters.m43471g();
        this.f27715g = mcEliecePublicKeyParameters.m43468d();
        this.f27710b = this.f27713e >> 3;
        this.f27709a = this.f27714f >> 3;
    }

    /* renamed from: a */
    public void m36363a(McEliecePrivateKeyParameters mcEliecePrivateKeyParameters) {
        this.f27713e = mcEliecePrivateKeyParameters.m43457c();
        this.f27714f = mcEliecePrivateKeyParameters.m43458d();
        this.f27709a = this.f27714f >> 3;
        this.f27710b = this.f27713e >> 3;
    }

    /* renamed from: a */
    public byte[] m36366a(byte[] bArr) {
        Vector c = m36361c(bArr);
        return ((GF2Vector) ((McEliecePublicKeyParameters) this.f27711c).m43469e().m36509a(c).mo5929a(new GF2Vector(this.f27713e, this.f27715g, this.f27712d))).m36523a();
    }

    /* renamed from: c */
    private GF2Vector m36361c(byte[] bArr) {
        Object obj = new byte[(this.f27709a + ((this.f27714f & 7) != 0 ? 1 : 0))];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        obj[bArr.length] = (byte) 1;
        return GF2Vector.m36518a(this.f27714f, obj);
    }

    /* renamed from: b */
    public byte[] m36367b(byte[] bArr) {
        bArr = GF2Vector.m36518a(this.f27713e, bArr);
        McEliecePrivateKeyParameters mcEliecePrivateKeyParameters = (McEliecePrivateKeyParameters) this.f27711c;
        GF2mField e = mcEliecePrivateKeyParameters.m43459e();
        PolynomialGF2mSmallM f = mcEliecePrivateKeyParameters.m43460f();
        GF2Matrix g = mcEliecePrivateKeyParameters.m43461g();
        Permutation h = mcEliecePrivateKeyParameters.m43462h();
        Permutation i = mcEliecePrivateKeyParameters.m43463i();
        GF2Matrix j = mcEliecePrivateKeyParameters.m43464j();
        PolynomialGF2mSmallM[] k = mcEliecePrivateKeyParameters.m43465k();
        i = h.m29246a(i);
        GF2Vector gF2Vector = (GF2Vector) bArr.m36520a(i.m29249c());
        Vector a = GoppaCode.m29231a((GF2Vector) j.m36514c(gF2Vector), e, f, k);
        gF2Vector = (GF2Vector) ((GF2Vector) gF2Vector.mo5929a(a)).m36520a(h);
        GF2Vector gF2Vector2 = (GF2Vector) a.m36520a(i);
        return m36360a((GF2Vector) g.m36509a(gF2Vector.m36524b(this.f27714f)));
    }

    /* renamed from: a */
    private byte[] m36360a(GF2Vector gF2Vector) {
        gF2Vector = gF2Vector.m36523a();
        int length = gF2Vector.length - 1;
        while (length >= 0 && gF2Vector[length] == (byte) 0) {
            length--;
        }
        if (length < 0 || gF2Vector[length] != (byte) 1) {
            throw new Exception("Bad Padding: invalid ciphertext");
        }
        Object obj = new byte[length];
        System.arraycopy(gF2Vector, 0, obj, 0, length);
        return obj;
    }
}
