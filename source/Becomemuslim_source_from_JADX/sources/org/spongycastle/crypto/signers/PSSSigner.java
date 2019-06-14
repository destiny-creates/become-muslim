package org.spongycastle.crypto.signers;

import com.facebook.imageutils.JfifUtil;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSABlindingParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;

public class PSSSigner implements Signer {
    /* renamed from: a */
    private Digest f27266a;
    /* renamed from: b */
    private Digest f27267b;
    /* renamed from: c */
    private AsymmetricBlockCipher f27268c;
    /* renamed from: d */
    private SecureRandom f27269d;
    /* renamed from: e */
    private int f27270e;
    /* renamed from: f */
    private int f27271f;
    /* renamed from: g */
    private int f27272g;
    /* renamed from: h */
    private int f27273h;
    /* renamed from: i */
    private byte[] f27274i;
    /* renamed from: j */
    private byte[] f27275j;
    /* renamed from: k */
    private byte[] f27276k;
    /* renamed from: l */
    private byte f27277l;

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, int i, byte b) {
        this.f27268c = asymmetricBlockCipher;
        this.f27266a = digest;
        this.f27267b = digest2;
        this.f27270e = digest.mo5732b();
        this.f27271f = digest2.mo5732b();
        this.f27272g = i;
        this.f27274i = new byte[i];
        this.f27275j = new byte[((i + 8) + this.f27270e)];
        this.f27277l = b;
    }

    /* renamed from: a */
    public void mo5796a(boolean z, CipherParameters cipherParameters) {
        CipherParameters b;
        RSAKeyParameters a;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            b = parametersWithRandom.m35698b();
            this.f27269d = parametersWithRandom.m35697a();
        } else {
            if (z) {
                this.f27269d = new SecureRandom();
            }
            b = cipherParameters;
        }
        if (b instanceof RSABlindingParameters) {
            a = ((RSABlindingParameters) b).m35705a();
            this.f27268c.mo5737a(z, cipherParameters);
        } else {
            a = (RSAKeyParameters) b;
            this.f27268c.mo5737a(z, b);
        }
        this.f27273h = a.m40800b().bitLength() - 1;
        if (this.f27273h >= ((this.f27270e * 8) + (this.f27272g * 8)) + 9) {
            this.f27276k = new byte[((this.f27273h + 7) / 8)];
            m35825b();
            return;
        }
        throw new IllegalArgumentException("key too small for specified hash and salt lengths");
    }

    /* renamed from: b */
    private void m35819b(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = (byte) 0;
        }
    }

    /* renamed from: a */
    public void mo5795a(byte b) {
        this.f27266a.mo5730a(b);
    }

    /* renamed from: a */
    public void mo5797a(byte[] bArr, int i, int i2) {
        this.f27266a.mo5731a(bArr, i, i2);
    }

    /* renamed from: b */
    public void m35825b() {
        this.f27266a.mo5733c();
    }

    /* renamed from: a */
    public byte[] mo5799a() {
        this.f27266a.mo5728a(this.f27275j, (this.f27275j.length - this.f27270e) - this.f27272g);
        if (this.f27272g != 0) {
            this.f27269d.nextBytes(this.f27274i);
            System.arraycopy(this.f27274i, 0, this.f27275j, this.f27275j.length - this.f27272g, this.f27272g);
        }
        Object obj = new byte[this.f27270e];
        this.f27266a.mo5731a(this.f27275j, 0, this.f27275j.length);
        this.f27266a.mo5728a(obj, 0);
        this.f27276k[(((this.f27276k.length - this.f27272g) - 1) - this.f27270e) - 1] = (byte) 1;
        System.arraycopy(this.f27274i, 0, this.f27276k, ((this.f27276k.length - this.f27272g) - this.f27270e) - 1, this.f27272g);
        byte[] a = m35818a(obj, 0, obj.length, (this.f27276k.length - this.f27270e) - 1);
        for (int i = 0; i != a.length; i++) {
            byte[] bArr = this.f27276k;
            bArr[i] = (byte) (bArr[i] ^ a[i]);
        }
        a = this.f27276k;
        a[0] = (byte) (a[0] & (JfifUtil.MARKER_FIRST_BYTE >> ((this.f27276k.length * 8) - this.f27273h)));
        System.arraycopy(obj, 0, this.f27276k, (this.f27276k.length - this.f27270e) - 1, this.f27270e);
        this.f27276k[this.f27276k.length - 1] = this.f27277l;
        byte[] a2 = this.f27268c.mo5738a(this.f27276k, 0, this.f27276k.length);
        m35819b(this.f27276k);
        return a2;
    }

    /* renamed from: a */
    public boolean mo5798a(byte[] r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r6.f27266a;
        r1 = r6.f27275j;
        r2 = r6.f27275j;
        r2 = r2.length;
        r3 = r6.f27270e;
        r2 = r2 - r3;
        r3 = r6.f27272g;
        r2 = r2 - r3;
        r0.mo5728a(r1, r2);
        r0 = 0;
        r1 = r6.f27268c;	 Catch:{ Exception -> 0x010c }
        r2 = r7.length;	 Catch:{ Exception -> 0x010c }
        r7 = r1.mo5738a(r7, r0, r2);	 Catch:{ Exception -> 0x010c }
        r1 = r6.f27276k;	 Catch:{ Exception -> 0x010c }
        r2 = r6.f27276k;	 Catch:{ Exception -> 0x010c }
        r2 = r2.length;	 Catch:{ Exception -> 0x010c }
        r3 = r7.length;	 Catch:{ Exception -> 0x010c }
        r2 = r2 - r3;	 Catch:{ Exception -> 0x010c }
        r3 = r7.length;	 Catch:{ Exception -> 0x010c }
        java.lang.System.arraycopy(r7, r0, r1, r2, r3);	 Catch:{ Exception -> 0x010c }
        r7 = r6.f27276k;
        r1 = r6.f27276k;
        r1 = r1.length;
        r2 = 1;
        r1 = r1 - r2;
        r7 = r7[r1];
        r1 = r6.f27277l;
        if (r7 == r1) goto L_0x0036;
    L_0x0030:
        r7 = r6.f27276k;
        r6.m35819b(r7);
        return r0;
    L_0x0036:
        r7 = r6.f27276k;
        r1 = r6.f27276k;
        r1 = r1.length;
        r3 = r6.f27270e;
        r1 = r1 - r3;
        r1 = r1 - r2;
        r3 = r6.f27270e;
        r4 = r6.f27276k;
        r4 = r4.length;
        r5 = r6.f27270e;
        r4 = r4 - r5;
        r4 = r4 - r2;
        r7 = r6.m35818a(r7, r1, r3, r4);
        r1 = 0;
    L_0x004d:
        r3 = r7.length;
        if (r1 == r3) goto L_0x005d;
    L_0x0050:
        r3 = r6.f27276k;
        r4 = r3[r1];
        r5 = r7[r1];
        r4 = r4 ^ r5;
        r4 = (byte) r4;
        r3[r1] = r4;
        r1 = r1 + 1;
        goto L_0x004d;
    L_0x005d:
        r7 = r6.f27276k;
        r1 = r7[r0];
        r3 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r4 = r6.f27276k;
        r4 = r4.length;
        r4 = r4 * 8;
        r5 = r6.f27273h;
        r4 = r4 - r5;
        r3 = r3 >> r4;
        r1 = r1 & r3;
        r1 = (byte) r1;
        r7[r0] = r1;
        r7 = 0;
    L_0x0071:
        r1 = r6.f27276k;
        r1 = r1.length;
        r3 = r6.f27270e;
        r1 = r1 - r3;
        r3 = r6.f27272g;
        r1 = r1 - r3;
        r1 = r1 + -2;
        if (r7 == r1) goto L_0x008d;
    L_0x007e:
        r1 = r6.f27276k;
        r1 = r1[r7];
        if (r1 == 0) goto L_0x008a;
    L_0x0084:
        r7 = r6.f27276k;
        r6.m35819b(r7);
        return r0;
    L_0x008a:
        r7 = r7 + 1;
        goto L_0x0071;
    L_0x008d:
        r7 = r6.f27276k;
        r1 = r6.f27276k;
        r1 = r1.length;
        r3 = r6.f27270e;
        r1 = r1 - r3;
        r3 = r6.f27272g;
        r1 = r1 - r3;
        r1 = r1 + -2;
        r7 = r7[r1];
        if (r7 == r2) goto L_0x00a4;
    L_0x009e:
        r7 = r6.f27276k;
        r6.m35819b(r7);
        return r0;
    L_0x00a4:
        r7 = r6.f27276k;
        r1 = r6.f27276k;
        r1 = r1.length;
        r3 = r6.f27272g;
        r1 = r1 - r3;
        r3 = r6.f27270e;
        r1 = r1 - r3;
        r1 = r1 - r2;
        r3 = r6.f27275j;
        r4 = r6.f27275j;
        r4 = r4.length;
        r5 = r6.f27272g;
        r4 = r4 - r5;
        r5 = r6.f27272g;
        java.lang.System.arraycopy(r7, r1, r3, r4, r5);
        r7 = r6.f27266a;
        r1 = r6.f27275j;
        r3 = r6.f27275j;
        r3 = r3.length;
        r7.mo5731a(r1, r0, r3);
        r7 = r6.f27266a;
        r1 = r6.f27275j;
        r3 = r6.f27275j;
        r3 = r3.length;
        r4 = r6.f27270e;
        r3 = r3 - r4;
        r7.mo5728a(r1, r3);
        r7 = r6.f27276k;
        r7 = r7.length;
        r1 = r6.f27270e;
        r7 = r7 - r1;
        r7 = r7 - r2;
        r1 = r6.f27275j;
        r1 = r1.length;
        r3 = r6.f27270e;
        r1 = r1 - r3;
    L_0x00e1:
        r3 = r6.f27275j;
        r3 = r3.length;
        if (r1 == r3) goto L_0x0101;
    L_0x00e6:
        r3 = r6.f27276k;
        r3 = r3[r7];
        r4 = r6.f27275j;
        r4 = r4[r1];
        r3 = r3 ^ r4;
        if (r3 == 0) goto L_0x00fc;
    L_0x00f1:
        r7 = r6.f27275j;
        r6.m35819b(r7);
        r7 = r6.f27276k;
        r6.m35819b(r7);
        return r0;
    L_0x00fc:
        r7 = r7 + 1;
        r1 = r1 + 1;
        goto L_0x00e1;
    L_0x0101:
        r7 = r6.f27275j;
        r6.m35819b(r7);
        r7 = r6.f27276k;
        r6.m35819b(r7);
        return r2;
    L_0x010c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.signers.PSSSigner.a(byte[]):boolean");
    }

    /* renamed from: a */
    private void m35817a(int i, byte[] bArr) {
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) (i >>> 0);
    }

    /* renamed from: a */
    private byte[] m35818a(byte[] bArr, int i, int i2, int i3) {
        Object obj = new byte[i3];
        Object obj2 = new byte[this.f27271f];
        byte[] bArr2 = new byte[4];
        this.f27267b.mo5733c();
        int i4 = 0;
        while (i4 < i3 / this.f27271f) {
            m35817a(i4, bArr2);
            this.f27267b.mo5731a(bArr, i, i2);
            this.f27267b.mo5731a(bArr2, 0, bArr2.length);
            this.f27267b.mo5728a(obj2, 0);
            System.arraycopy(obj2, 0, obj, this.f27271f * i4, this.f27271f);
            i4++;
        }
        if (this.f27271f * i4 < i3) {
            m35817a(i4, bArr2);
            this.f27267b.mo5731a(bArr, i, i2);
            this.f27267b.mo5731a(bArr2, 0, bArr2.length);
            this.f27267b.mo5728a(obj2, 0);
            System.arraycopy(obj2, 0, obj, this.f27271f * i4, obj.length - (i4 * this.f27271f));
        }
        return obj;
    }
}
