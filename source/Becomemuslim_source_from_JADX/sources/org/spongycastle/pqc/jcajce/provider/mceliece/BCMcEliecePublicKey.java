package org.spongycastle.pqc.jcajce.provider.mceliece;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class BCMcEliecePublicKey implements PublicKey, CipherParameters {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private String f27852a;
    /* renamed from: b */
    private int f27853b;
    /* renamed from: c */
    private int f27854c;
    /* renamed from: d */
    private GF2Matrix f27855d;
    /* renamed from: e */
    private McElieceParameters f27856e;

    public String getAlgorithm() {
        return "McEliece";
    }

    public String getFormat() {
        return null;
    }

    public BCMcEliecePublicKey(String str, int i, int i2, GF2Matrix gF2Matrix) {
        this.f27852a = str;
        this.f27853b = i;
        this.f27854c = i2;
        this.f27855d = gF2Matrix;
    }

    public BCMcEliecePublicKey(McEliecePublicKeyParameters mcEliecePublicKeyParameters) {
        this(mcEliecePublicKeyParameters.m43470f(), mcEliecePublicKeyParameters.m43467c(), mcEliecePublicKeyParameters.m43468d(), mcEliecePublicKeyParameters.m43469e());
        this.f27856e = mcEliecePublicKeyParameters.m42096b();
    }

    /* renamed from: a */
    public int m36462a() {
        return this.f27853b;
    }

    /* renamed from: b */
    public int m36463b() {
        return this.f27854c;
    }

    /* renamed from: c */
    public GF2Matrix m36464c() {
        return this.f27855d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("McEliecePublicKey:\n");
        stringBuilder.append(" length of the code         : ");
        stringBuilder.append(this.f27853b);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        String stringBuilder2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append(" error correction capability: ");
        stringBuilder.append(this.f27854c);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append(" generator matrix           : ");
        stringBuilder.append(this.f27855d.toString());
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof BCMcEliecePublicKey)) {
            return false;
        }
        BCMcEliecePublicKey bCMcEliecePublicKey = (BCMcEliecePublicKey) obj;
        if (this.f27853b == bCMcEliecePublicKey.f27853b && this.f27854c == bCMcEliecePublicKey.f27854c && this.f27855d.equals(bCMcEliecePublicKey.f27855d) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (this.f27853b + this.f27854c) + this.f27855d.hashCode();
    }

    /* renamed from: d */
    public String m36465d() {
        return this.f27852a;
    }

    /* renamed from: e */
    protected ASN1ObjectIdentifier m36466e() {
        return new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.1");
    }

    public byte[] getEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = new org.spongycastle.pqc.asn1.McEliecePublicKey;
        r1 = new org.spongycastle.asn1.ASN1ObjectIdentifier;
        r2 = r5.f27852a;
        r1.<init>(r2);
        r2 = r5.f27853b;
        r3 = r5.f27854c;
        r4 = r5.f27855d;
        r0.<init>(r1, r2, r3, r4);
        r1 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;
        r2 = r5.m36466e();
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
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.jcajce.provider.mceliece.BCMcEliecePublicKey.getEncoded():byte[]");
    }

    /* renamed from: f */
    public McElieceParameters m36467f() {
        return this.f27856e;
    }
}
