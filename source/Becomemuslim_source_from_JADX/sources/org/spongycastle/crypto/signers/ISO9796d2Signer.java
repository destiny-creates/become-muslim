package org.spongycastle.crypto.signers;

import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.SignerWithRecovery;
import org.spongycastle.crypto.params.RSAKeyParameters;

public class ISO9796d2Signer implements SignerWithRecovery {
    /* renamed from: a */
    private Digest f31777a;
    /* renamed from: b */
    private AsymmetricBlockCipher f31778b;
    /* renamed from: c */
    private int f31779c;
    /* renamed from: d */
    private int f31780d;
    /* renamed from: e */
    private byte[] f31781e;
    /* renamed from: f */
    private byte[] f31782f;
    /* renamed from: g */
    private int f31783g;
    /* renamed from: h */
    private boolean f31784h;
    /* renamed from: i */
    private byte[] f31785i;
    /* renamed from: j */
    private byte[] f31786j;
    /* renamed from: k */
    private byte[] f31787k;

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, boolean z) {
        this.f31778b = asymmetricBlockCipher;
        this.f31777a = digest;
        if (z) {
            this.f31779c = 188;
            return;
        }
        asymmetricBlockCipher = ISOTrailers.m27532a(digest);
        if (asymmetricBlockCipher != null) {
            this.f31779c = asymmetricBlockCipher.intValue();
            return;
        }
        z = new StringBuilder();
        z.append("no valid trailer for digest: ");
        z.append(digest.mo5729a());
        throw new IllegalArgumentException(z.toString());
    }

    /* renamed from: a */
    public void mo5796a(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.f31778b.mo5737a(z, rSAKeyParameters);
        this.f31780d = rSAKeyParameters.m40800b().bitLength();
        this.f31781e = new byte[((this.f31780d + 7) / 8)];
        if (this.f31779c) {
            this.f31782f = new byte[((this.f31781e.length - this.f31777a.mo5732b()) - 2)];
        } else {
            this.f31782f = new byte[((this.f31781e.length - this.f31777a.mo5732b()) - 3)];
        }
        m40822b();
    }

    /* renamed from: a */
    private boolean m40814a(byte[] bArr, byte[] bArr2) {
        boolean z = true;
        int i;
        if (this.f31783g > this.f31782f.length) {
            if (this.f31782f.length > bArr2.length) {
                z = false;
            }
            for (i = 0; i != this.f31782f.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    z = false;
                }
            }
        } else {
            if (this.f31783g != bArr2.length) {
                z = false;
            }
            for (i = 0; i != bArr2.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    z = false;
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    private void m40815b(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = (byte) 0;
        }
    }

    /* renamed from: a */
    public void mo5795a(byte b) {
        this.f31777a.mo5730a(b);
        if (this.f31783g < this.f31782f.length) {
            this.f31782f[this.f31783g] = b;
        }
        this.f31783g++;
    }

    /* renamed from: a */
    public void mo5797a(byte[] bArr, int i, int i2) {
        while (i2 > 0 && this.f31783g < this.f31782f.length) {
            mo5795a(bArr[i]);
            i++;
            i2--;
        }
        this.f31777a.mo5731a(bArr, i, i2);
        this.f31783g += i2;
    }

    /* renamed from: b */
    public void m40822b() {
        this.f31777a.mo5733c();
        this.f31783g = 0;
        m40815b(this.f31782f);
        if (this.f31785i != null) {
            m40815b(this.f31785i);
        }
        this.f31785i = null;
        this.f31784h = false;
        if (this.f31786j != null) {
            this.f31786j = null;
            m40815b(this.f31787k);
            this.f31787k = null;
        }
    }

    /* renamed from: a */
    public byte[] mo5799a() {
        int length;
        int i;
        byte[] bArr;
        int b = this.f31777a.mo5732b();
        boolean z = true;
        if (this.f31779c == 188) {
            length = (this.f31781e.length - b) - 1;
            this.f31777a.mo5728a(this.f31781e, length);
            this.f31781e[this.f31781e.length - 1] = (byte) -68;
            i = length;
            length = 8;
        } else {
            length = 16;
            i = (this.f31781e.length - b) - 2;
            this.f31777a.mo5728a(this.f31781e, i);
            this.f31781e[this.f31781e.length - 2] = (byte) (this.f31779c >>> 8);
            this.f31781e[this.f31781e.length - 1] = (byte) this.f31779c;
        }
        b = ((((b + this.f31783g) * 8) + length) + 4) - this.f31780d;
        if (b > 0) {
            int i2 = this.f31783g - ((b + 7) / 8);
            b = 96;
            i -= i2;
            System.arraycopy(this.f31782f, 0, this.f31781e, i, i2);
            this.f31785i = new byte[i2];
        } else {
            b = 64;
            i -= this.f31783g;
            System.arraycopy(this.f31782f, 0, this.f31781e, i, this.f31783g);
            this.f31785i = new byte[this.f31783g];
        }
        i--;
        if (i > 0) {
            for (int i3 = i; i3 != 0; i3--) {
                this.f31781e[i3] = (byte) -69;
            }
            bArr = this.f31781e;
            bArr[i] = (byte) (bArr[i] ^ 1);
            this.f31781e[0] = (byte) 11;
            bArr = this.f31781e;
            bArr[0] = (byte) (bArr[0] | b);
        } else {
            this.f31781e[0] = (byte) 10;
            bArr = this.f31781e;
            bArr[0] = (byte) (bArr[0] | b);
        }
        bArr = this.f31778b.mo5738a(this.f31781e, 0, this.f31781e.length);
        if ((b & 32) != 0) {
            z = false;
        }
        this.f31784h = z;
        System.arraycopy(this.f31782f, 0, this.f31785i, 0, this.f31785i.length);
        m40815b(this.f31782f);
        m40815b(this.f31781e);
        return bArr;
    }

    /* renamed from: a */
    public boolean mo5798a(byte[] r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = r11.f31786j;
        r1 = 0;
        if (r0 != 0) goto L_0x000e;
    L_0x0005:
        r0 = r11.f31778b;	 Catch:{ Exception -> 0x000d }
        r2 = r12.length;	 Catch:{ Exception -> 0x000d }
        r12 = r0.mo5738a(r12, r1, r2);	 Catch:{ Exception -> 0x000d }
        goto L_0x001d;
    L_0x000d:
        return r1;
    L_0x000e:
        r0 = r11.f31786j;
        r12 = org.spongycastle.util.Arrays.m29353a(r0, r12);
        if (r12 == 0) goto L_0x0141;
    L_0x0016:
        r12 = r11.f31787k;
        r0 = 0;
        r11.f31786j = r0;
        r11.f31787k = r0;
    L_0x001d:
        r0 = r12[r1];
        r0 = r0 & 192;
        r0 = r0 ^ 64;
        if (r0 == 0) goto L_0x002a;
    L_0x0025:
        r12 = r11.m40816c(r12);
        return r12;
    L_0x002a:
        r0 = r12.length;
        r2 = 1;
        r0 = r0 - r2;
        r0 = r12[r0];
        r0 = r0 & 15;
        r0 = r0 ^ 12;
        if (r0 == 0) goto L_0x003a;
    L_0x0035:
        r12 = r11.m40816c(r12);
        return r12;
    L_0x003a:
        r0 = r12.length;
        r0 = r0 - r2;
        r0 = r12[r0];
        r0 = r0 & 255;
        r0 = r0 ^ 188;
        r3 = 2;
        if (r0 != 0) goto L_0x0047;
    L_0x0045:
        r3 = 1;
        goto L_0x0064;
    L_0x0047:
        r0 = r12.length;
        r0 = r0 - r3;
        r0 = r12[r0];
        r0 = r0 & 255;
        r0 = r0 << 8;
        r4 = r12.length;
        r4 = r4 - r2;
        r4 = r12[r4];
        r4 = r4 & 255;
        r0 = r0 | r4;
        r4 = r11.f31777a;
        r4 = org.spongycastle.crypto.signers.ISOTrailers.m27532a(r4);
        if (r4 == 0) goto L_0x0139;
    L_0x005e:
        r4 = r4.intValue();
        if (r0 != r4) goto L_0x0122;
    L_0x0064:
        r0 = 0;
    L_0x0065:
        r4 = r12.length;
        if (r0 == r4) goto L_0x0074;
    L_0x0068:
        r4 = r12[r0];
        r4 = r4 & 15;
        r4 = r4 ^ 10;
        if (r4 != 0) goto L_0x0071;
    L_0x0070:
        goto L_0x0074;
    L_0x0071:
        r0 = r0 + 1;
        goto L_0x0065;
    L_0x0074:
        r0 = r0 + r2;
        r4 = r11.f31777a;
        r4 = r4.mo5732b();
        r4 = new byte[r4];
        r5 = r12.length;
        r5 = r5 - r3;
        r3 = r4.length;
        r5 = r5 - r3;
        r3 = r5 - r0;
        if (r3 > 0) goto L_0x008a;
    L_0x0085:
        r12 = r11.m40816c(r12);
        return r12;
    L_0x008a:
        r6 = r12[r1];
        r6 = r6 & 32;
        if (r6 != 0) goto L_0x00d5;
    L_0x0090:
        r11.f31784h = r2;
        r6 = r11.f31783g;
        if (r6 <= r3) goto L_0x009b;
    L_0x0096:
        r12 = r11.m40816c(r12);
        return r12;
    L_0x009b:
        r6 = r11.f31777a;
        r6.mo5733c();
        r6 = r11.f31777a;
        r6.mo5731a(r12, r0, r3);
        r6 = r11.f31777a;
        r6.mo5728a(r4, r1);
        r6 = 0;
        r7 = 1;
    L_0x00ac:
        r8 = r4.length;
        if (r6 == r8) goto L_0x00c1;
    L_0x00af:
        r8 = r5 + r6;
        r9 = r12[r8];
        r10 = r4[r6];
        r9 = r9 ^ r10;
        r9 = (byte) r9;
        r12[r8] = r9;
        r8 = r12[r8];
        if (r8 == 0) goto L_0x00be;
    L_0x00bd:
        r7 = 0;
    L_0x00be:
        r6 = r6 + 1;
        goto L_0x00ac;
    L_0x00c1:
        if (r7 != 0) goto L_0x00c8;
    L_0x00c3:
        r12 = r11.m40816c(r12);
        return r12;
    L_0x00c8:
        r3 = new byte[r3];
        r11.f31785i = r3;
        r3 = r11.f31785i;
        r4 = r11.f31785i;
        r4 = r4.length;
        java.lang.System.arraycopy(r12, r0, r3, r1, r4);
        goto L_0x0106;
    L_0x00d5:
        r11.f31784h = r1;
        r6 = r11.f31777a;
        r6.mo5728a(r4, r1);
        r6 = 0;
        r7 = 1;
    L_0x00de:
        r8 = r4.length;
        if (r6 == r8) goto L_0x00f3;
    L_0x00e1:
        r8 = r5 + r6;
        r9 = r12[r8];
        r10 = r4[r6];
        r9 = r9 ^ r10;
        r9 = (byte) r9;
        r12[r8] = r9;
        r8 = r12[r8];
        if (r8 == 0) goto L_0x00f0;
    L_0x00ef:
        r7 = 0;
    L_0x00f0:
        r6 = r6 + 1;
        goto L_0x00de;
    L_0x00f3:
        if (r7 != 0) goto L_0x00fa;
    L_0x00f5:
        r12 = r11.m40816c(r12);
        return r12;
    L_0x00fa:
        r3 = new byte[r3];
        r11.f31785i = r3;
        r3 = r11.f31785i;
        r4 = r11.f31785i;
        r4 = r4.length;
        java.lang.System.arraycopy(r12, r0, r3, r1, r4);
    L_0x0106:
        r0 = r11.f31783g;
        if (r0 == 0) goto L_0x0119;
    L_0x010a:
        r0 = r11.f31782f;
        r1 = r11.f31785i;
        r0 = r11.m40814a(r0, r1);
        if (r0 != 0) goto L_0x0119;
    L_0x0114:
        r12 = r11.m40816c(r12);
        return r12;
    L_0x0119:
        r0 = r11.f31782f;
        r11.m40815b(r0);
        r11.m40815b(r12);
        return r2;
    L_0x0122:
        r12 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "signer initialised with wrong digest for trailer ";
        r1.append(r2);
        r1.append(r0);
        r0 = r1.toString();
        r12.<init>(r0);
        throw r12;
    L_0x0139:
        r12 = new java.lang.IllegalArgumentException;
        r0 = "unrecognised hash in signature";
        r12.<init>(r0);
        throw r12;
    L_0x0141:
        r12 = new java.lang.IllegalStateException;
        r0 = "updateWithRecoveredMessage called on different signature";
        r12.<init>(r0);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.signers.ISO9796d2Signer.a(byte[]):boolean");
    }

    /* renamed from: c */
    private boolean m40816c(byte[] bArr) {
        m40815b(this.f31782f);
        m40815b(bArr);
        return null;
    }
}
