package org.spongycastle.pqc.jcajce.provider.mceliece;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2Parameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class BCMcElieceCCA2PublicKey implements PublicKey, CipherParameters {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private String f27836a;
    /* renamed from: b */
    private int f27837b;
    /* renamed from: c */
    private int f27838c;
    /* renamed from: d */
    private GF2Matrix f27839d;
    /* renamed from: e */
    private McElieceCCA2Parameters f27840e;

    public String getAlgorithm() {
        return "McEliece";
    }

    public String getFormat() {
        return null;
    }

    public BCMcElieceCCA2PublicKey(String str, int i, int i2, GF2Matrix gF2Matrix) {
        this.f27836a = str;
        this.f27837b = i;
        this.f27838c = i2;
        this.f27839d = gF2Matrix;
    }

    public BCMcElieceCCA2PublicKey(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters) {
        this(mcElieceCCA2PublicKeyParameters.m43456g(), mcElieceCCA2PublicKeyParameters.m43452c(), mcElieceCCA2PublicKeyParameters.m43453d(), mcElieceCCA2PublicKeyParameters.m43454e());
        this.f27840e = mcElieceCCA2PublicKeyParameters.m42094b();
    }

    /* renamed from: a */
    public int m36444a() {
        return this.f27837b;
    }

    /* renamed from: b */
    public int m36445b() {
        return this.f27838c;
    }

    /* renamed from: c */
    public GF2Matrix m36446c() {
        return this.f27839d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("McEliecePublicKey:\n");
        stringBuilder.append(" length of the code         : ");
        stringBuilder.append(this.f27837b);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        String stringBuilder2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append(" error correction capability: ");
        stringBuilder.append(this.f27838c);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append(" generator matrix           : ");
        stringBuilder.append(this.f27839d.toString());
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            if (obj instanceof BCMcElieceCCA2PublicKey) {
                BCMcElieceCCA2PublicKey bCMcElieceCCA2PublicKey = (BCMcElieceCCA2PublicKey) obj;
                if (this.f27837b == bCMcElieceCCA2PublicKey.f27837b && this.f27838c == bCMcElieceCCA2PublicKey.f27838c && this.f27839d.equals(bCMcElieceCCA2PublicKey.f27839d) != null) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f27837b + this.f27838c) + this.f27839d.hashCode();
    }

    /* renamed from: d */
    public String m36447d() {
        return this.f27836a;
    }

    /* renamed from: e */
    protected ASN1ObjectIdentifier m36448e() {
        return new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2");
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = new org.spongycastle.pqc.asn1.McElieceCCA2PublicKey;
        r1 = new org.spongycastle.asn1.ASN1ObjectIdentifier;
        r2 = r5.f27836a;
        r1.<init>(r2);
        r2 = r5.f27837b;
        r3 = r5.f27838c;
        r4 = r5.f27839d;
        r0.<init>(r1, r2, r3, r4);
        r1 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;
        r2 = r5.m36448e();
        r3 = org.spongycastle.asn1.DERNull.f32850a;
        r1.<init>(r2, r3);
        r2 = new org.spongycastle.asn1.x509.SubjectPublicKeyInfo;	 Catch:{ IOException -> 0x0027 }
        r2.<init>(r1, r0);	 Catch:{ IOException -> 0x0027 }
        r0 = r2.mo6822f();	 Catch:{ IOException -> 0x0027 }
        return r0;
    L_0x0027:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.jcajce.provider.mceliece.BCMcElieceCCA2PublicKey.getEncoded():byte[]");
    }

    /* renamed from: f */
    public McElieceCCA2Parameters m36449f() {
        return this.f27840e;
    }
}
