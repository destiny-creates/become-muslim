package org.spongycastle.crypto.signers;

import com.facebook.imageutils.JfifUtil;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.SignerWithRecovery;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.ParametersWithSalt;
import org.spongycastle.crypto.params.RSAKeyParameters;

public class ISO9796d2PSSSigner implements SignerWithRecovery {
    /* renamed from: a */
    private Digest f31760a;
    /* renamed from: b */
    private AsymmetricBlockCipher f31761b;
    /* renamed from: c */
    private SecureRandom f31762c;
    /* renamed from: d */
    private byte[] f31763d;
    /* renamed from: e */
    private int f31764e;
    /* renamed from: f */
    private int f31765f;
    /* renamed from: g */
    private int f31766g;
    /* renamed from: h */
    private byte[] f31767h;
    /* renamed from: i */
    private byte[] f31768i;
    /* renamed from: j */
    private int f31769j;
    /* renamed from: k */
    private int f31770k;
    /* renamed from: l */
    private boolean f31771l;
    /* renamed from: m */
    private byte[] f31772m;
    /* renamed from: n */
    private byte[] f31773n;
    /* renamed from: o */
    private byte[] f31774o;
    /* renamed from: p */
    private int f31775p;
    /* renamed from: q */
    private int f31776q;

    /* renamed from: a */
    public void mo5796a(boolean z, CipherParameters cipherParameters) {
        Object obj;
        int i = this.f31770k;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            obj = (RSAKeyParameters) parametersWithRandom.m35698b();
            if (z) {
                this.f31762c = parametersWithRandom.m35697a();
            }
        } else if (cipherParameters instanceof ParametersWithSalt) {
            ParametersWithSalt parametersWithSalt = (ParametersWithSalt) cipherParameters;
            obj = (RSAKeyParameters) parametersWithSalt.m35702b();
            this.f31763d = parametersWithSalt.m35701a();
            i = this.f31763d.length;
            if (this.f31763d.length != this.f31770k) {
                throw new IllegalArgumentException("Fixed salt is of wrong length");
            }
        } else {
            obj = (RSAKeyParameters) cipherParameters;
            if (z) {
                this.f31762c = new SecureRandom();
            }
        }
        this.f31761b.mo5737a(z, obj);
        this.f31766g = obj.m40800b().bitLength();
        this.f31767h = new byte[((this.f31766g + 7) / 8)];
        if (this.f31765f) {
            this.f31768i = new byte[((((this.f31767h.length - this.f31760a.mo5732b()) - i) - 1) - 1)];
        } else {
            this.f31768i = new byte[((((this.f31767h.length - this.f31760a.mo5732b()) - i) - 1) - 2)];
        }
        m40812b();
    }

    /* renamed from: a */
    private boolean m40804a(byte[] bArr, byte[] bArr2) {
        boolean z = this.f31769j == bArr2.length;
        for (int i = 0; i != bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: c */
    private void m40806c(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = (byte) 0;
        }
    }

    /* renamed from: b */
    public void m40813b(byte[] bArr) {
        int i;
        Object a = this.f31761b.mo5738a(bArr, 0, bArr.length);
        if (a.length < (this.f31766g + 7) / 8) {
            Object obj = new byte[((this.f31766g + 7) / 8)];
            System.arraycopy(a, 0, obj, obj.length - a.length, a.length);
            m40806c(a);
            a = obj;
        }
        boolean z = true;
        int i2 = 2;
        if (((a[a.length - 1] & JfifUtil.MARKER_FIRST_BYTE) ^ 188) == 0) {
            i2 = 1;
        } else {
            int i3 = ((a[a.length - 2] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (a[a.length - 1] & JfifUtil.MARKER_FIRST_BYTE);
            Integer a2 = ISOTrailers.m27532a(this.f31760a);
            if (a2 == null) {
                throw new IllegalArgumentException("unrecognised hash in signature");
            } else if (i3 != a2.intValue()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("signer initialised with wrong digest for trailer ");
                stringBuilder.append(i3);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        this.f31760a.mo5728a(new byte[this.f31764e], 0);
        byte[] a3 = m40805a(a, (a.length - this.f31764e) - i2, this.f31764e, (a.length - this.f31764e) - i2);
        for (i = 0; i != a3.length; i++) {
            a[i] = (byte) (a[i] ^ a3[i]);
        }
        a[0] = (byte) (a[0] & 127);
        i = 0;
        while (i != a.length) {
            if (a[i] == (byte) 1) {
                break;
            }
            i++;
        }
        i++;
        if (i >= a.length) {
            m40806c(a);
        }
        if (i <= 1) {
            z = false;
        }
        this.f31771l = z;
        this.f31772m = new byte[((a3.length - i) - this.f31770k)];
        System.arraycopy(a, i, this.f31772m, 0, this.f31772m.length);
        System.arraycopy(this.f31772m, 0, this.f31768i, 0, this.f31772m.length);
        this.f31773n = bArr;
        this.f31774o = a;
        this.f31775p = i;
        this.f31776q = i2;
    }

    /* renamed from: a */
    public void mo5795a(byte b) {
        if (this.f31773n != null || this.f31769j >= this.f31768i.length) {
            this.f31760a.mo5730a(b);
            return;
        }
        byte[] bArr = this.f31768i;
        int i = this.f31769j;
        this.f31769j = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a */
    public void mo5797a(byte[] bArr, int i, int i2) {
        if (this.f31773n == null) {
            while (i2 > 0 && this.f31769j < this.f31768i.length) {
                mo5795a(bArr[i]);
                i++;
                i2--;
            }
        }
        if (i2 > 0) {
            this.f31760a.mo5731a(bArr, i, i2);
        }
    }

    /* renamed from: b */
    public void m40812b() {
        this.f31760a.mo5733c();
        this.f31769j = 0;
        if (this.f31768i != null) {
            m40806c(this.f31768i);
        }
        if (this.f31772m != null) {
            m40806c(this.f31772m);
            this.f31772m = null;
        }
        this.f31771l = false;
        if (this.f31773n != null) {
            this.f31773n = null;
            m40806c(this.f31774o);
            this.f31774o = null;
        }
    }

    /* renamed from: a */
    public byte[] mo5799a() {
        Object obj;
        byte[] bArr = new byte[this.f31760a.mo5732b()];
        this.f31760a.mo5728a(bArr, 0);
        byte[] bArr2 = new byte[8];
        m40803a((long) (this.f31769j * 8), bArr2);
        this.f31760a.mo5731a(bArr2, 0, bArr2.length);
        this.f31760a.mo5731a(this.f31768i, 0, this.f31769j);
        this.f31760a.mo5731a(bArr, 0, bArr.length);
        if (this.f31763d != null) {
            obj = this.f31763d;
        } else {
            obj = new byte[this.f31770k];
            this.f31762c.nextBytes(obj);
        }
        this.f31760a.mo5731a(obj, 0, obj.length);
        Object obj2 = new byte[this.f31760a.mo5732b()];
        this.f31760a.mo5728a(obj2, 0);
        boolean z = true;
        int i = this.f31765f == 188 ? 1 : 2;
        int length = ((((this.f31767h.length - this.f31769j) - obj.length) - this.f31764e) - i) - 1;
        this.f31767h[length] = (byte) 1;
        length++;
        System.arraycopy(this.f31768i, 0, this.f31767h, length, this.f31769j);
        System.arraycopy(obj, 0, this.f31767h, length + this.f31769j, obj.length);
        bArr = m40805a(obj2, 0, obj2.length, (this.f31767h.length - this.f31764e) - i);
        for (length = 0; length != bArr.length; length++) {
            byte[] bArr3 = this.f31767h;
            bArr3[length] = (byte) (bArr3[length] ^ bArr[length]);
        }
        System.arraycopy(obj2, 0, this.f31767h, (this.f31767h.length - this.f31764e) - i, this.f31764e);
        if (this.f31765f == 188) {
            this.f31767h[this.f31767h.length - 1] = (byte) -68;
        } else {
            this.f31767h[this.f31767h.length - 2] = (byte) (this.f31765f >>> 8);
            this.f31767h[this.f31767h.length - 1] = (byte) this.f31765f;
        }
        bArr = this.f31767h;
        bArr[0] = (byte) (bArr[0] & 127);
        bArr = this.f31761b.mo5738a(this.f31767h, 0, this.f31767h.length);
        this.f31772m = new byte[this.f31769j];
        if (this.f31769j > this.f31768i.length) {
            z = false;
        }
        this.f31771l = z;
        System.arraycopy(this.f31768i, 0, this.f31772m, 0, this.f31772m.length);
        m40806c(this.f31768i);
        m40806c(this.f31767h);
        this.f31769j = 0;
        return bArr;
    }

    /* renamed from: a */
    public boolean mo5798a(byte[] r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.f31764e;
        r0 = new byte[r0];
        r1 = r8.f31760a;
        r2 = 0;
        r1.mo5728a(r0, r2);
        r1 = r8.f31773n;
        if (r1 != 0) goto L_0x0013;
    L_0x000e:
        r8.m40813b(r9);	 Catch:{ Exception -> 0x0012 }
        goto L_0x001b;
    L_0x0012:
        return r2;
    L_0x0013:
        r1 = r8.f31773n;
        r9 = org.spongycastle.util.Arrays.m29353a(r1, r9);
        if (r9 == 0) goto L_0x00a8;
    L_0x001b:
        r9 = r8.f31774o;
        r1 = r8.f31775p;
        r3 = r8.f31776q;
        r4 = 0;
        r8.f31773n = r4;
        r8.f31774o = r4;
        r4 = 8;
        r5 = new byte[r4];
        r6 = r8.f31772m;
        r6 = r6.length;
        r6 = r6 * 8;
        r6 = (long) r6;
        r8.m40803a(r6, r5);
        r4 = r8.f31760a;
        r6 = r5.length;
        r4.mo5731a(r5, r2, r6);
        r4 = r8.f31772m;
        r4 = r4.length;
        if (r4 == 0) goto L_0x0048;
    L_0x003e:
        r4 = r8.f31760a;
        r5 = r8.f31772m;
        r6 = r8.f31772m;
        r6 = r6.length;
        r4.mo5731a(r5, r2, r6);
    L_0x0048:
        r4 = r8.f31760a;
        r5 = r0.length;
        r4.mo5731a(r0, r2, r5);
        r0 = r8.f31760a;
        r4 = r8.f31772m;
        r4 = r4.length;
        r1 = r1 + r4;
        r4 = r8.f31770k;
        r0.mo5731a(r9, r1, r4);
        r0 = r8.f31760a;
        r0 = r0.mo5732b();
        r0 = new byte[r0];
        r1 = r8.f31760a;
        r1.mo5728a(r0, r2);
        r1 = r9.length;
        r1 = r1 - r3;
        r3 = r0.length;
        r1 = r1 - r3;
        r3 = 1;
        r4 = 0;
        r5 = 1;
    L_0x006d:
        r6 = r0.length;
        if (r4 == r6) goto L_0x007c;
    L_0x0070:
        r6 = r0[r4];
        r7 = r1 + r4;
        r7 = r9[r7];
        if (r6 == r7) goto L_0x0079;
    L_0x0078:
        r5 = 0;
    L_0x0079:
        r4 = r4 + 1;
        goto L_0x006d;
    L_0x007c:
        r8.m40806c(r9);
        r8.m40806c(r0);
        if (r5 != 0) goto L_0x008c;
    L_0x0084:
        r8.f31771l = r2;
        r9 = r8.f31772m;
        r8.m40806c(r9);
        return r2;
    L_0x008c:
        r9 = r8.f31769j;
        if (r9 == 0) goto L_0x00a2;
    L_0x0090:
        r9 = r8.f31768i;
        r0 = r8.f31772m;
        r9 = r8.m40804a(r9, r0);
        if (r9 != 0) goto L_0x00a0;
    L_0x009a:
        r9 = r8.f31768i;
        r8.m40806c(r9);
        return r2;
    L_0x00a0:
        r8.f31769j = r2;
    L_0x00a2:
        r9 = r8.f31768i;
        r8.m40806c(r9);
        return r3;
    L_0x00a8:
        r9 = new java.lang.IllegalStateException;
        r0 = "updateWithRecoveredMessage called on different signature";
        r9.<init>(r0);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.signers.ISO9796d2PSSSigner.a(byte[]):boolean");
    }

    /* renamed from: a */
    private void m40802a(int i, byte[] bArr) {
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) (i >>> 0);
    }

    /* renamed from: a */
    private void m40803a(long j, byte[] bArr) {
        bArr[0] = (byte) ((int) (j >>> 56));
        bArr[1] = (byte) ((int) (j >>> 48));
        bArr[2] = (byte) ((int) (j >>> 40));
        bArr[3] = (byte) ((int) (j >>> 32));
        bArr[4] = (byte) ((int) (j >>> 24));
        bArr[5] = (byte) ((int) (j >>> 16));
        bArr[6] = (byte) ((int) (j >>> 8));
        bArr[7] = (byte) ((int) (j >>> 0));
    }

    /* renamed from: a */
    private byte[] m40805a(byte[] bArr, int i, int i2, int i3) {
        Object obj = new byte[i3];
        Object obj2 = new byte[this.f31764e];
        byte[] bArr2 = new byte[4];
        this.f31760a.mo5733c();
        int i4 = 0;
        while (i4 < i3 / this.f31764e) {
            m40802a(i4, bArr2);
            this.f31760a.mo5731a(bArr, i, i2);
            this.f31760a.mo5731a(bArr2, 0, bArr2.length);
            this.f31760a.mo5728a(obj2, 0);
            System.arraycopy(obj2, 0, obj, this.f31764e * i4, this.f31764e);
            i4++;
        }
        if (this.f31764e * i4 < i3) {
            m40802a(i4, bArr2);
            this.f31760a.mo5731a(bArr, i, i2);
            this.f31760a.mo5731a(bArr2, 0, bArr2.length);
            this.f31760a.mo5728a(obj2, 0);
            System.arraycopy(obj2, 0, obj, this.f31764e * i4, obj.length - (i4 * this.f31764e));
        }
        return obj;
    }
}
