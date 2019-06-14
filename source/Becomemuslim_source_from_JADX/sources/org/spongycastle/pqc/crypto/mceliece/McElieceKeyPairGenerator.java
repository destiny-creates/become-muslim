package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode.MaMaPe;
import org.spongycastle.pqc.math.linearalgebra.Matrix;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

public class McElieceKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    /* renamed from: a */
    private McElieceKeyGenerationParameters f27695a;
    /* renamed from: b */
    private int f27696b;
    /* renamed from: c */
    private int f27697c;
    /* renamed from: d */
    private int f27698d;
    /* renamed from: e */
    private int f27699e;
    /* renamed from: f */
    private SecureRandom f27700f;
    /* renamed from: g */
    private boolean f27701g = false;

    /* renamed from: b */
    private void m36349b() {
        m36350b(new McElieceKeyGenerationParameters(new SecureRandom(), new McElieceParameters()));
    }

    /* renamed from: b */
    private void m36350b(KeyGenerationParameters keyGenerationParameters) {
        this.f27695a = (McElieceKeyGenerationParameters) keyGenerationParameters;
        this.f27700f = new SecureRandom();
        this.f27696b = this.f27695a.m36348c().m36368b();
        this.f27697c = this.f27695a.m36348c().m36369c();
        this.f27698d = this.f27695a.m36348c().m36370d();
        this.f27699e = this.f27695a.m36348c().m36371e();
        this.f27701g = true;
    }

    /* renamed from: c */
    private AsymmetricCipherKeyPair m36351c() {
        if (!this.f27701g) {
            m36349b();
        }
        GF2mField gF2mField = new GF2mField(r0.f27696b, r0.f27699e);
        PolynomialGF2mSmallM polynomialGF2mSmallM = new PolynomialGF2mSmallM(gF2mField, r0.f27698d, 'I', r0.f27700f);
        PolynomialGF2mSmallM[] a = new PolynomialRingGF2m(gF2mField, polynomialGF2mSmallM).m29291a();
        GF2Matrix a2 = GoppaCode.m29230a(gF2mField, polynomialGF2mSmallM);
        MaMaPe a3 = GoppaCode.m29232a(a2, r0.f27700f);
        GF2Matrix a4 = a3.m29228a();
        Permutation b = a3.m29229b();
        GF2Matrix gF2Matrix = (GF2Matrix) a4.m36516e();
        Matrix c = gF2Matrix.m36513c();
        int g = gF2Matrix.m29244g();
        GF2Matrix[] a5 = GF2Matrix.m36503a(g, r0.f27700f);
        Permutation permutation = new Permutation(r0.f27697c, r0.f27700f);
        GF2Matrix gF2Matrix2 = (GF2Matrix) ((GF2Matrix) a5[0].m36507a(c)).m36508a(permutation);
        return new AsymmetricCipherKeyPair(new McEliecePublicKeyParameters("1.3.6.1.4.1.8301.3.1.3.4.1", r0.f27697c, r0.f27698d, gF2Matrix2, r0.f27695a.m36348c()), new McEliecePrivateKeyParameters("1.3.6.1.4.1.8301.3.1.3.4.1", r0.f27697c, g, gF2mField, polynomialGF2mSmallM, a5[1], b, permutation, a2, a, r0.f27695a.m36348c()));
    }

    /* renamed from: a */
    public void m36353a(KeyGenerationParameters keyGenerationParameters) {
        m36350b(keyGenerationParameters);
    }

    /* renamed from: a */
    public AsymmetricCipherKeyPair mo5755a() {
        return m36351c();
    }
}
