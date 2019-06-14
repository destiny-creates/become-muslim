package org.spongycastle.pqc.jcajce.provider.mceliece;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.io.IOException;
import java.security.PrivateKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.McElieceCCA2PrivateKey;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2Parameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class BCMcElieceCCA2PrivateKey implements PrivateKey, CipherParameters {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private String f27827a;
    /* renamed from: b */
    private int f27828b;
    /* renamed from: c */
    private int f27829c;
    /* renamed from: d */
    private GF2mField f27830d;
    /* renamed from: e */
    private PolynomialGF2mSmallM f27831e;
    /* renamed from: f */
    private Permutation f27832f;
    /* renamed from: g */
    private GF2Matrix f27833g;
    /* renamed from: h */
    private PolynomialGF2mSmallM[] f27834h;
    /* renamed from: i */
    private McElieceCCA2Parameters f27835i;

    public String getAlgorithm() {
        return "McEliece";
    }

    public String getFormat() {
        return null;
    }

    public BCMcElieceCCA2PrivateKey(String str, int i, int i2, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, GF2Matrix gF2Matrix, PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        this.f27827a = str;
        this.f27828b = i;
        this.f27829c = i2;
        this.f27830d = gF2mField;
        this.f27831e = polynomialGF2mSmallM;
        this.f27832f = permutation;
        this.f27833g = gF2Matrix;
        this.f27834h = polynomialGF2mSmallMArr;
    }

    public BCMcElieceCCA2PrivateKey(McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters) {
        this(mcElieceCCA2PrivateKeyParameters.m43451k(), mcElieceCCA2PrivateKeyParameters.m43443c(), mcElieceCCA2PrivateKeyParameters.m43444d(), mcElieceCCA2PrivateKeyParameters.m43446f(), mcElieceCCA2PrivateKeyParameters.m43447g(), mcElieceCCA2PrivateKeyParameters.m43448h(), mcElieceCCA2PrivateKeyParameters.m43449i(), mcElieceCCA2PrivateKeyParameters.m43450j());
        this.f27835i = mcElieceCCA2PrivateKeyParameters.m42094b();
    }

    /* renamed from: a */
    public int m36434a() {
        return this.f27828b;
    }

    /* renamed from: b */
    public int m36435b() {
        return this.f27829c;
    }

    /* renamed from: c */
    public GF2mField m36436c() {
        return this.f27830d;
    }

    /* renamed from: d */
    public PolynomialGF2mSmallM m36437d() {
        return this.f27831e;
    }

    /* renamed from: e */
    public Permutation m36438e() {
        return this.f27832f;
    }

    /* renamed from: f */
    public GF2Matrix m36439f() {
        return this.f27833g;
    }

    /* renamed from: g */
    public PolynomialGF2mSmallM[] m36440g() {
        return this.f27834h;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(" extension degree of the field      : ");
        stringBuilder.append(this.f27828b);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        String stringBuilder2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append(" dimension of the code              : ");
        stringBuilder.append(this.f27829c);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append(" irreducible Goppa polynomial       : ");
        stringBuilder.append(this.f27831e);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            if (obj instanceof BCMcElieceCCA2PrivateKey) {
                BCMcElieceCCA2PrivateKey bCMcElieceCCA2PrivateKey = (BCMcElieceCCA2PrivateKey) obj;
                if (this.f27828b == bCMcElieceCCA2PrivateKey.f27828b && this.f27829c == bCMcElieceCCA2PrivateKey.f27829c && this.f27830d.equals(bCMcElieceCCA2PrivateKey.f27830d) && this.f27831e.equals(bCMcElieceCCA2PrivateKey.f27831e) && this.f27832f.equals(bCMcElieceCCA2PrivateKey.f27832f) && this.f27833g.equals(bCMcElieceCCA2PrivateKey.f27833g) != null) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f27829c + this.f27828b) + this.f27830d.hashCode()) + this.f27831e.hashCode()) + this.f27832f.hashCode()) + this.f27833g.hashCode();
    }

    /* renamed from: h */
    public String m36441h() {
        return this.f27827a;
    }

    /* renamed from: i */
    protected ASN1ObjectIdentifier m36442i() {
        return new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2");
    }

    public byte[] getEncoded() {
        try {
            try {
                return new PrivateKeyInfo(new AlgorithmIdentifier(m36442i(), DERNull.f32850a), new McElieceCCA2PrivateKey(new ASN1ObjectIdentifier(this.f27827a), this.f27828b, this.f27829c, this.f27830d, this.f27831e, this.f27832f, this.f27833g, this.f27834h)).mo6822f();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: j */
    public McElieceCCA2Parameters m36443j() {
        return this.f27835i;
    }
}
