package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode.MaMaPe;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

public class McElieceCCA2KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    /* renamed from: a */
    private McElieceCCA2KeyGenerationParameters f27681a;
    /* renamed from: b */
    private int f27682b;
    /* renamed from: c */
    private int f27683c;
    /* renamed from: d */
    private int f27684d;
    /* renamed from: e */
    private int f27685e;
    /* renamed from: f */
    private SecureRandom f27686f;
    /* renamed from: g */
    private boolean f27687g = false;

    /* renamed from: b */
    private void m36339b() {
        m36341a(new McElieceCCA2KeyGenerationParameters(new SecureRandom(), new McElieceCCA2Parameters()));
    }

    /* renamed from: a */
    public void m36341a(KeyGenerationParameters keyGenerationParameters) {
        this.f27681a = (McElieceCCA2KeyGenerationParameters) keyGenerationParameters;
        this.f27686f = new SecureRandom();
        this.f27682b = this.f27681a.m36338c().m36368b();
        this.f27683c = this.f27681a.m36338c().m36369c();
        this.f27684d = this.f27681a.m36338c().m36370d();
        this.f27685e = this.f27681a.m36338c().m36371e();
        this.f27687g = true;
    }

    /* renamed from: a */
    public AsymmetricCipherKeyPair mo5755a() {
        if (!this.f27687g) {
            m36339b();
        }
        GF2mField gF2mField = new GF2mField(r0.f27682b, r0.f27685e);
        PolynomialGF2mSmallM polynomialGF2mSmallM = new PolynomialGF2mSmallM(gF2mField, r0.f27684d, 'I', r0.f27686f);
        PolynomialGF2mSmallM[] a = new PolynomialRingGF2m(gF2mField, polynomialGF2mSmallM).m29291a();
        GF2Matrix a2 = GoppaCode.m29230a(gF2mField, polynomialGF2mSmallM);
        MaMaPe a3 = GoppaCode.m29232a(a2, r0.f27686f);
        GF2Matrix a4 = a3.m29228a();
        Permutation b = a3.m29229b();
        GF2Matrix gF2Matrix = (GF2Matrix) a4.m36516e();
        return new AsymmetricCipherKeyPair(new McElieceCCA2PublicKeyParameters("1.3.6.1.4.1.8301.3.1.3.4.2", r0.f27683c, r0.f27684d, gF2Matrix, r0.f27681a.m36338c()), new McElieceCCA2PrivateKeyParameters("1.3.6.1.4.1.8301.3.1.3.4.2", r0.f27683c, gF2Matrix.m29244g(), gF2mField, polynomialGF2mSmallM, b, a2, a, r0.f27681a.m36338c()));
    }
}
