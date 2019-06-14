package org.spongycastle.pqc.crypto.rainbow;

import com.facebook.imageutils.JfifUtil;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.MessageSigner;
import org.spongycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.spongycastle.pqc.crypto.rainbow.util.GF2Field;

public class RainbowSigner implements MessageSigner {
    /* renamed from: a */
    int f27815a;
    /* renamed from: b */
    RainbowKeyParameters f27816b;
    /* renamed from: c */
    private SecureRandom f27817c;
    /* renamed from: d */
    private short[] f27818d;
    /* renamed from: e */
    private ComputeInField f27819e = new ComputeInField();

    /* renamed from: a */
    public void mo5913a(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.f27816b = (RainbowPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f27817c = parametersWithRandom.m35697a();
            this.f27816b = (RainbowPrivateKeyParameters) parametersWithRandom.m35698b();
        } else {
            this.f27817c = new SecureRandom();
            this.f27816b = (RainbowPrivateKeyParameters) cipherParameters;
        }
        this.f27815a = this.f27816b.m42098b();
    }

    /* renamed from: a */
    private short[] m36421a(Layer[] layerArr, short[] sArr) {
        short[] sArr2 = new short[sArr.length];
        sArr = this.f27819e.m29123b(((RainbowPrivateKeyParameters) this.f27816b).m43473d(), this.f27819e.m29118a(((RainbowPrivateKeyParameters) this.f27816b).m43472c(), sArr));
        for (int i = 0; i < layerArr[0].m29106a(); i++) {
            this.f27818d[i] = (short) this.f27817c.nextInt();
            this.f27818d[i] = (short) (this.f27818d[i] & JfifUtil.MARKER_FIRST_BYTE);
        }
        return sArr;
    }

    /* renamed from: a */
    public byte[] mo5915a(byte[] r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r12 = this;
        r0 = r12.f27816b;
        r0 = (org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters) r0;
        r0 = r0.m43476g();
        r1 = r0.length;
        r2 = r12.f27816b;
        r2 = (org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters) r2;
        r2 = r2.m43475f();
        r2 = r2.length;
        r2 = new short[r2];
        r12.f27818d = r2;
        r2 = r1 + -1;
        r2 = r0[r2];
        r2 = r2.m29108b();
        r2 = new byte[r2];
        r13 = r12.m36423b(r13);
    L_0x0024:
        r3 = 0;
        r4 = r12.m36421a(r0, r13);	 Catch:{ Exception -> 0x00ab }
        r5 = 0;	 Catch:{ Exception -> 0x00ab }
        r6 = 0;	 Catch:{ Exception -> 0x00ab }
    L_0x002b:
        if (r5 >= r1) goto L_0x0080;	 Catch:{ Exception -> 0x00ab }
    L_0x002d:
        r7 = r0[r5];	 Catch:{ Exception -> 0x00ab }
        r7 = r7.m29109c();	 Catch:{ Exception -> 0x00ab }
        r7 = new short[r7];	 Catch:{ Exception -> 0x00ab }
        r8 = r0[r5];	 Catch:{ Exception -> 0x00ab }
        r8 = r8.m29109c();	 Catch:{ Exception -> 0x00ab }
        r8 = new short[r8];	 Catch:{ Exception -> 0x00ab }
        r8 = r6;	 Catch:{ Exception -> 0x00ab }
        r6 = 0;	 Catch:{ Exception -> 0x00ab }
    L_0x003f:
        r9 = r0[r5];	 Catch:{ Exception -> 0x00ab }
        r9 = r9.m29109c();	 Catch:{ Exception -> 0x00ab }
        if (r6 >= r9) goto L_0x0050;	 Catch:{ Exception -> 0x00ab }
    L_0x0047:
        r9 = r4[r8];	 Catch:{ Exception -> 0x00ab }
        r7[r6] = r9;	 Catch:{ Exception -> 0x00ab }
        r8 = r8 + 1;	 Catch:{ Exception -> 0x00ab }
        r6 = r6 + 1;	 Catch:{ Exception -> 0x00ab }
        goto L_0x003f;	 Catch:{ Exception -> 0x00ab }
    L_0x0050:
        r6 = r12.f27819e;	 Catch:{ Exception -> 0x00ab }
        r9 = r0[r5];	 Catch:{ Exception -> 0x00ab }
        r10 = r12.f27818d;	 Catch:{ Exception -> 0x00ab }
        r9 = r9.m29107a(r10);	 Catch:{ Exception -> 0x00ab }
        r6 = r6.m29119a(r9, r7);	 Catch:{ Exception -> 0x00ab }
        if (r6 == 0) goto L_0x0078;	 Catch:{ Exception -> 0x00ab }
    L_0x0060:
        r7 = 0;	 Catch:{ Exception -> 0x00ab }
    L_0x0061:
        r9 = r6.length;	 Catch:{ Exception -> 0x00ab }
        if (r7 >= r9) goto L_0x0074;	 Catch:{ Exception -> 0x00ab }
    L_0x0064:
        r9 = r12.f27818d;	 Catch:{ Exception -> 0x00ab }
        r10 = r0[r5];	 Catch:{ Exception -> 0x00ab }
        r10 = r10.m29106a();	 Catch:{ Exception -> 0x00ab }
        r10 = r10 + r7;	 Catch:{ Exception -> 0x00ab }
        r11 = r6[r7];	 Catch:{ Exception -> 0x00ab }
        r9[r10] = r11;	 Catch:{ Exception -> 0x00ab }
        r7 = r7 + 1;	 Catch:{ Exception -> 0x00ab }
        goto L_0x0061;	 Catch:{ Exception -> 0x00ab }
    L_0x0074:
        r5 = r5 + 1;	 Catch:{ Exception -> 0x00ab }
        r6 = r8;	 Catch:{ Exception -> 0x00ab }
        goto L_0x002b;	 Catch:{ Exception -> 0x00ab }
    L_0x0078:
        r4 = new java.lang.Exception;	 Catch:{ Exception -> 0x00ab }
        r5 = "LES is not solveable!";	 Catch:{ Exception -> 0x00ab }
        r4.<init>(r5);	 Catch:{ Exception -> 0x00ab }
        throw r4;	 Catch:{ Exception -> 0x00ab }
    L_0x0080:
        r4 = r12.f27819e;	 Catch:{ Exception -> 0x00ab }
        r5 = r12.f27816b;	 Catch:{ Exception -> 0x00ab }
        r5 = (org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters) r5;	 Catch:{ Exception -> 0x00ab }
        r5 = r5.m43474e();	 Catch:{ Exception -> 0x00ab }
        r6 = r12.f27818d;	 Catch:{ Exception -> 0x00ab }
        r4 = r4.m29118a(r5, r6);	 Catch:{ Exception -> 0x00ab }
        r5 = r12.f27819e;	 Catch:{ Exception -> 0x00ab }
        r6 = r12.f27816b;	 Catch:{ Exception -> 0x00ab }
        r6 = (org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters) r6;	 Catch:{ Exception -> 0x00ab }
        r6 = r6.m43475f();	 Catch:{ Exception -> 0x00ab }
        r4 = r5.m29123b(r6, r4);	 Catch:{ Exception -> 0x00ab }
        r5 = 0;	 Catch:{ Exception -> 0x00ab }
    L_0x009f:
        r6 = r2.length;	 Catch:{ Exception -> 0x00ab }
        if (r5 >= r6) goto L_0x00aa;	 Catch:{ Exception -> 0x00ab }
    L_0x00a2:
        r6 = r4[r5];	 Catch:{ Exception -> 0x00ab }
        r6 = (byte) r6;	 Catch:{ Exception -> 0x00ab }
        r2[r5] = r6;	 Catch:{ Exception -> 0x00ab }
        r5 = r5 + 1;
        goto L_0x009f;
    L_0x00aa:
        r3 = 1;
    L_0x00ab:
        if (r3 == 0) goto L_0x0024;
    L_0x00ad:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.crypto.rainbow.RainbowSigner.a(byte[]):byte[]");
    }

    /* renamed from: a */
    public boolean mo5914a(byte[] bArr, byte[] bArr2) {
        int i;
        short[] sArr = new short[bArr2.length];
        for (i = 0; i < bArr2.length; i++) {
            sArr[i] = (short) (((short) bArr2[i]) & JfifUtil.MARKER_FIRST_BYTE);
        }
        bArr = m36423b(bArr);
        bArr2 = m36422a(sArr);
        if (bArr.length != bArr2.length) {
            return false;
        }
        boolean z = true;
        for (i = 0; i < bArr.length; i++) {
            z = z && bArr[i] == bArr2[i];
        }
        return z;
    }

    /* renamed from: a */
    private short[] m36422a(short[] sArr) {
        short[][] c = ((RainbowPublicKeyParameters) this.f27816b).m43478c();
        short[][] d = ((RainbowPublicKeyParameters) this.f27816b).m43479d();
        short[] e = ((RainbowPublicKeyParameters) this.f27816b).m43480e();
        short[] sArr2 = new short[c.length];
        int length = d[0].length;
        for (int i = 0; i < c.length; i++) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i3;
                for (i3 = i2; i3 < length; i3++) {
                    sArr2[i] = GF2Field.m29126a(sArr2[i], GF2Field.m29127b(c[i][i4], GF2Field.m29127b(sArr[i2], sArr[i3])));
                    i4++;
                }
                sArr2[i] = GF2Field.m29126a(sArr2[i], GF2Field.m29127b(d[i][i2], sArr[i2]));
                i2++;
                i3 = i4;
            }
            sArr2[i] = GF2Field.m29126a(sArr2[i], e[i]);
        }
        return sArr2;
    }

    /* renamed from: b */
    private short[] m36423b(byte[] bArr) {
        short[] sArr = new short[this.f27815a];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            sArr[i] = (short) bArr[i2];
            sArr[i] = (short) (sArr[i] & JfifUtil.MARKER_FIRST_BYTE);
            i2++;
            i++;
            if (i >= sArr.length) {
                break;
            }
        }
        return sArr;
    }
}
