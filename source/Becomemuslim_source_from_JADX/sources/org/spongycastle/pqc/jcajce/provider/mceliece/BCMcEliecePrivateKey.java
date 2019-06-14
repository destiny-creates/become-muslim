package org.spongycastle.pqc.jcajce.provider.mceliece;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.io.IOException;
import java.security.PrivateKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.McEliecePrivateKey;
import org.spongycastle.pqc.crypto.mceliece.McElieceParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class BCMcEliecePrivateKey implements PrivateKey, CipherParameters {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private String f27841a;
    /* renamed from: b */
    private int f27842b;
    /* renamed from: c */
    private int f27843c;
    /* renamed from: d */
    private GF2mField f27844d;
    /* renamed from: e */
    private PolynomialGF2mSmallM f27845e;
    /* renamed from: f */
    private GF2Matrix f27846f;
    /* renamed from: g */
    private Permutation f27847g;
    /* renamed from: h */
    private Permutation f27848h;
    /* renamed from: i */
    private GF2Matrix f27849i;
    /* renamed from: j */
    private PolynomialGF2mSmallM[] f27850j;
    /* renamed from: k */
    private McElieceParameters f27851k;

    public String getAlgorithm() {
        return "McEliece";
    }

    public String getFormat() {
        return null;
    }

    public BCMcEliecePrivateKey(String str, int i, int i2, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, GF2Matrix gF2Matrix, Permutation permutation, Permutation permutation2, GF2Matrix gF2Matrix2, PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        this.f27841a = str;
        this.f27842b = i;
        this.f27843c = i2;
        this.f27844d = gF2mField;
        this.f27845e = polynomialGF2mSmallM;
        this.f27846f = gF2Matrix;
        this.f27847g = permutation;
        this.f27848h = permutation2;
        this.f27849i = gF2Matrix2;
        this.f27850j = polynomialGF2mSmallMArr;
    }

    public BCMcEliecePrivateKey(McEliecePrivateKeyParameters mcEliecePrivateKeyParameters) {
        this(mcEliecePrivateKeyParameters.m43466l(), mcEliecePrivateKeyParameters.m43457c(), mcEliecePrivateKeyParameters.m43458d(), mcEliecePrivateKeyParameters.m43459e(), mcEliecePrivateKeyParameters.m43460f(), mcEliecePrivateKeyParameters.m43461g(), mcEliecePrivateKeyParameters.m43462h(), mcEliecePrivateKeyParameters.m43463i(), mcEliecePrivateKeyParameters.m43464j(), mcEliecePrivateKeyParameters.m43465k());
        this.f27851k = mcEliecePrivateKeyParameters.m42096b();
    }

    /* renamed from: a */
    public int m36450a() {
        return this.f27842b;
    }

    /* renamed from: b */
    public int m36451b() {
        return this.f27843c;
    }

    /* renamed from: c */
    public GF2mField m36452c() {
        return this.f27844d;
    }

    /* renamed from: d */
    public PolynomialGF2mSmallM m36453d() {
        return this.f27845e;
    }

    /* renamed from: e */
    public GF2Matrix m36454e() {
        return this.f27846f;
    }

    /* renamed from: f */
    public Permutation m36455f() {
        return this.f27847g;
    }

    /* renamed from: g */
    public Permutation m36456g() {
        return this.f27848h;
    }

    /* renamed from: h */
    public GF2Matrix m36457h() {
        return this.f27849i;
    }

    /* renamed from: i */
    public PolynomialGF2mSmallM[] m36458i() {
        return this.f27850j;
    }

    /* renamed from: j */
    public String m36459j() {
        return this.f27841a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" length of the code          : ");
        stringBuilder.append(this.f27842b);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(" dimension of the code       : ");
        stringBuilder3.append(this.f27843c);
        stringBuilder3.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder2 = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(" irreducible Goppa polynomial: ");
        stringBuilder3.append(this.f27845e);
        stringBuilder3.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder2 = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(" (k x k)-matrix S^-1         : ");
        stringBuilder3.append(this.f27846f);
        stringBuilder3.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder2 = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(" permutation P1              : ");
        stringBuilder3.append(this.f27847g);
        stringBuilder3.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder2 = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(" permutation P2              : ");
        stringBuilder3.append(this.f27848h);
        return stringBuilder3.toString();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof BCMcEliecePrivateKey)) {
            return false;
        }
        BCMcEliecePrivateKey bCMcEliecePrivateKey = (BCMcEliecePrivateKey) obj;
        if (this.f27842b == bCMcEliecePrivateKey.f27842b && this.f27843c == bCMcEliecePrivateKey.f27843c && this.f27844d.equals(bCMcEliecePrivateKey.f27844d) && this.f27845e.equals(bCMcEliecePrivateKey.f27845e) && this.f27846f.equals(bCMcEliecePrivateKey.f27846f) && this.f27847g.equals(bCMcEliecePrivateKey.f27847g) && this.f27848h.equals(bCMcEliecePrivateKey.f27848h) && this.f27849i.equals(bCMcEliecePrivateKey.f27849i) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((((((this.f27843c + this.f27842b) + this.f27844d.hashCode()) + this.f27845e.hashCode()) + this.f27846f.hashCode()) + this.f27847g.hashCode()) + this.f27848h.hashCode()) + this.f27849i.hashCode();
    }

    /* renamed from: k */
    protected ASN1ObjectIdentifier m36460k() {
        return new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.1");
    }

    public byte[] getEncoded() {
        try {
            try {
                return new PrivateKeyInfo(new AlgorithmIdentifier(m36460k(), DERNull.f32850a), new McEliecePrivateKey(new ASN1ObjectIdentifier(this.f27841a), this.f27842b, this.f27843c, this.f27844d, this.f27845e, this.f27846f, this.f27847g, this.f27848h, this.f27849i, this.f27850j)).mo6822f();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: l */
    public McElieceParameters m36461l() {
        return this.f27851k;
    }
}
