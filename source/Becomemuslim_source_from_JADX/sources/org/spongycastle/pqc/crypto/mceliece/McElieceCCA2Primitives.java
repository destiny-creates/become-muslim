package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.spongycastle.pqc.math.linearalgebra.Vector;

public final class McElieceCCA2Primitives {
    private McElieceCCA2Primitives() {
    }

    /* renamed from: a */
    public static GF2Vector m29090a(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters, GF2Vector gF2Vector, GF2Vector gF2Vector2) {
        return (GF2Vector) mcElieceCCA2PublicKeyParameters.m43454e().m36512b(gF2Vector).mo5929a(gF2Vector2);
    }

    /* renamed from: a */
    public static GF2Vector[] m29091a(McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters, GF2Vector gF2Vector) {
        int d = mcElieceCCA2PrivateKeyParameters.m43444d();
        Permutation h = mcElieceCCA2PrivateKeyParameters.m43448h();
        GF2mField f = mcElieceCCA2PrivateKeyParameters.m43446f();
        PolynomialGF2mSmallM g = mcElieceCCA2PrivateKeyParameters.m43447g();
        GF2Matrix i = mcElieceCCA2PrivateKeyParameters.m43449i();
        gF2Vector = (GF2Vector) gF2Vector.m36520a(h.m29249c());
        Vector a = GoppaCode.m29231a((GF2Vector) i.m36514c(gF2Vector), f, g, mcElieceCCA2PrivateKeyParameters.m43450j());
        gF2Vector = (GF2Vector) ((GF2Vector) gF2Vector.mo5929a(a)).m36520a(h);
        GF2Vector gF2Vector2 = (GF2Vector) a.m36520a(h);
        gF2Vector = gF2Vector.m36524b(d);
        return new GF2Vector[]{gF2Vector, gF2Vector2};
    }
}
