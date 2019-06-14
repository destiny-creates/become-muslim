package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.util.BigIntegers;

public class X931Signer implements Signer {
    /* renamed from: a */
    private Digest f27286a;
    /* renamed from: b */
    private AsymmetricBlockCipher f27287b;
    /* renamed from: c */
    private RSAKeyParameters f27288c;
    /* renamed from: d */
    private int f27289d;
    /* renamed from: e */
    private int f27290e;
    /* renamed from: f */
    private byte[] f27291f;

    public X931Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, boolean z) {
        this.f27287b = asymmetricBlockCipher;
        this.f27286a = digest;
        if (z) {
            this.f27289d = 188;
            return;
        }
        asymmetricBlockCipher = ISOTrailers.m27532a(digest);
        if (asymmetricBlockCipher != null) {
            this.f27289d = asymmetricBlockCipher.intValue();
            return;
        }
        z = new StringBuilder();
        z.append("no valid trailer for digest: ");
        z.append(digest.mo5729a());
        throw new IllegalArgumentException(z.toString());
    }

    public X931Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this(asymmetricBlockCipher, digest, false);
    }

    /* renamed from: a */
    public void mo5796a(boolean z, CipherParameters cipherParameters) {
        this.f27288c = (RSAKeyParameters) cipherParameters;
        this.f27287b.mo5737a(z, this.f27288c);
        this.f27290e = this.f27288c.m40800b().bitLength();
        this.f27291f = new byte[((this.f27290e + 7) / 8)];
        m35844b();
    }

    /* renamed from: b */
    private void m35837b(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = (byte) 0;
        }
    }

    /* renamed from: a */
    public void mo5795a(byte b) {
        this.f27286a.mo5730a(b);
    }

    /* renamed from: a */
    public void mo5797a(byte[] bArr, int i, int i2) {
        this.f27286a.mo5731a(bArr, i, i2);
    }

    /* renamed from: b */
    public void m35844b() {
        this.f27286a.mo5733c();
    }

    /* renamed from: a */
    public byte[] mo5799a() {
        m35838c();
        BigInteger bigInteger = new BigInteger(1, this.f27287b.mo5738a(this.f27291f, 0, this.f27291f.length));
        m35837b(this.f27291f);
        return BigIntegers.m29388a((this.f27288c.m40800b().bitLength() + 7) / 8, bigInteger.min(this.f27288c.m40800b().subtract(bigInteger)));
    }

    /* renamed from: c */
    private void m35838c() {
        int length;
        int b = this.f27286a.mo5732b();
        if (this.f27289d == 188) {
            length = (this.f27291f.length - b) - 1;
            this.f27286a.mo5728a(this.f27291f, length);
            this.f27291f[this.f27291f.length - 1] = (byte) -68;
        } else {
            length = (this.f27291f.length - b) - 2;
            this.f27286a.mo5728a(this.f27291f, length);
            this.f27291f[this.f27291f.length - 2] = (byte) (this.f27289d >>> 8);
            this.f27291f[this.f27291f.length - 1] = (byte) this.f27289d;
        }
        this.f27291f[0] = (byte) 107;
        for (b = length - 2; b != 0; b--) {
            this.f27291f[b] = (byte) -69;
        }
        this.f27291f[length - 1] = (byte) -70;
    }

    /* renamed from: a */
    public boolean mo5798a(byte[] r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = r3.f27287b;	 Catch:{ Exception -> 0x0049 }
        r2 = r4.length;	 Catch:{ Exception -> 0x0049 }
        r4 = r1.mo5738a(r4, r0, r2);	 Catch:{ Exception -> 0x0049 }
        r3.f27291f = r4;	 Catch:{ Exception -> 0x0049 }
        r4 = new java.math.BigInteger;
        r1 = 1;
        r2 = r3.f27291f;
        r4.<init>(r1, r2);
        r1 = r4.intValue();
        r1 = r1 & 15;
        r2 = 12;
        if (r1 != r2) goto L_0x001d;
    L_0x001c:
        goto L_0x002f;
    L_0x001d:
        r1 = r3.f27288c;
        r1 = r1.m40800b();
        r4 = r1.subtract(r4);
        r1 = r4.intValue();
        r1 = r1 & 15;
        if (r1 != r2) goto L_0x0048;
    L_0x002f:
        r3.m35838c();
        r0 = r3.f27291f;
        r0 = r0.length;
        r4 = org.spongycastle.util.BigIntegers.m29388a(r0, r4);
        r0 = r3.f27291f;
        r0 = org.spongycastle.util.Arrays.m29372b(r0, r4);
        r1 = r3.f27291f;
        r3.m35837b(r1);
        r3.m35837b(r4);
        return r0;
    L_0x0048:
        return r0;
    L_0x0049:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.signers.X931Signer.a(byte[]):boolean");
    }
}
