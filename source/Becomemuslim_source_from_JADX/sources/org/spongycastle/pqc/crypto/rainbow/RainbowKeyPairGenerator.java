package org.spongycastle.pqc.crypto.rainbow;

import com.facebook.imageutils.JfifUtil;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.spongycastle.pqc.crypto.rainbow.util.GF2Field;

public class RainbowKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    /* renamed from: a */
    private boolean f27798a = false;
    /* renamed from: b */
    private SecureRandom f27799b;
    /* renamed from: c */
    private RainbowKeyGenerationParameters f27800c;
    /* renamed from: d */
    private short[][] f27801d;
    /* renamed from: e */
    private short[][] f27802e;
    /* renamed from: f */
    private short[] f27803f;
    /* renamed from: g */
    private short[][] f27804g;
    /* renamed from: h */
    private short[][] f27805h;
    /* renamed from: i */
    private short[] f27806i;
    /* renamed from: j */
    private int f27807j;
    /* renamed from: k */
    private Layer[] f27808k;
    /* renamed from: l */
    private int[] f27809l;
    /* renamed from: m */
    private short[][] f27810m;
    /* renamed from: n */
    private short[][] f27811n;
    /* renamed from: o */
    private short[] f27812o;

    /* renamed from: b */
    public AsymmetricCipherKeyPair m36416b() {
        if (!this.f27798a) {
            m36408c();
        }
        m36409d();
        return new AsymmetricCipherKeyPair(new RainbowPublicKeyParameters(this.f27809l[this.f27809l.length - 1] - this.f27809l[0], this.f27810m, this.f27811n, this.f27812o), new RainbowPrivateKeyParameters(this.f27802e, this.f27803f, this.f27805h, this.f27806i, this.f27809l, this.f27808k));
    }

    /* renamed from: a */
    public void m36415a(KeyGenerationParameters keyGenerationParameters) {
        this.f27800c = (RainbowKeyGenerationParameters) keyGenerationParameters;
        this.f27799b = new SecureRandom();
        this.f27809l = this.f27800c.m36406c().m36420b();
        this.f27807j = this.f27800c.m36406c().m36419a();
        this.f27798a = true;
    }

    /* renamed from: c */
    private void m36408c() {
        m36415a(new RainbowKeyGenerationParameters(new SecureRandom(), new RainbowParameters()));
    }

    /* renamed from: d */
    private void m36409d() {
        m36410e();
        m36411f();
        m36412g();
        m36413h();
    }

    /* renamed from: e */
    private void m36410e() {
        int i = 0;
        int i2 = this.f27809l[this.f27809l.length - 1] - this.f27809l[0];
        this.f27801d = (short[][]) Array.newInstance(short.class, new int[]{i2, i2});
        this.f27802e = (short[][]) null;
        ComputeInField computeInField = new ComputeInField();
        while (this.f27802e == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < i2; i4++) {
                    this.f27801d[i3][i4] = (short) (this.f27799b.nextInt() & JfifUtil.MARKER_FIRST_BYTE);
                }
            }
            this.f27802e = computeInField.m29121a(this.f27801d);
        }
        this.f27803f = new short[i2];
        while (i < i2) {
            this.f27803f[i] = (short) (this.f27799b.nextInt() & JfifUtil.MARKER_FIRST_BYTE);
            i++;
        }
    }

    /* renamed from: f */
    private void m36411f() {
        int i = this.f27809l[this.f27809l.length - 1];
        this.f27804g = (short[][]) Array.newInstance(short.class, new int[]{i, i});
        this.f27805h = (short[][]) null;
        ComputeInField computeInField = new ComputeInField();
        while (true) {
            if (this.f27805h != null) {
                break;
            }
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < i; i3++) {
                    this.f27804g[i2][i3] = (short) (this.f27799b.nextInt() & JfifUtil.MARKER_FIRST_BYTE);
                }
            }
            this.f27805h = computeInField.m29121a(this.f27804g);
        }
        this.f27806i = new short[i];
        for (int i4 = 0; i4 < i; i4++) {
            this.f27806i[i4] = (short) (this.f27799b.nextInt() & JfifUtil.MARKER_FIRST_BYTE);
        }
    }

    /* renamed from: g */
    private void m36412g() {
        this.f27808k = new Layer[this.f27807j];
        int i = 0;
        while (i < this.f27807j) {
            int i2 = i + 1;
            this.f27808k[i] = new Layer(this.f27809l[i], this.f27809l[i2], this.f27799b);
            i = i2;
        }
    }

    /* renamed from: h */
    private void m36413h() {
        ComputeInField computeInField = new ComputeInField();
        int i = 0;
        int i2 = this.f27809l[this.f27809l.length - 1] - this.f27809l[0];
        int i3 = this.f27809l[this.f27809l.length - 1];
        short[][][] sArr = (short[][][]) Array.newInstance(short.class, new int[]{i2, i3, i3});
        this.f27811n = (short[][]) Array.newInstance(short.class, new int[]{i2, i3});
        this.f27812o = new short[i2];
        short[] sArr2 = new short[i3];
        int i4 = 0;
        int i5 = 0;
        while (i4 < r0.f27808k.length) {
            int i6;
            int i7;
            short[][][] d = r0.f27808k[i4].m29110d();
            short[][][] e = r0.f27808k[i4].m29111e();
            short[][] f = r0.f27808k[i4].m29112f();
            short[] g = r0.f27808k[i4].m29113g();
            int length = d[i].length;
            int length2 = e[i].length;
            int i8 = 0;
            while (i8 < length) {
                int i9;
                short[] sArr3;
                short[][][] sArr4;
                int i10 = 0;
                while (i10 < length) {
                    while (i < length2) {
                        i6 = i2;
                        i7 = i3;
                        int i11 = i10 + length2;
                        short[] a = computeInField.m29117a(d[i8][i10][i], r0.f27804g[i11]);
                        i3 = i5 + i8;
                        i9 = i4;
                        sArr3 = g;
                        sArr[i3] = computeInField.m29122a(sArr[i3], computeInField.m29124b(a, r0.f27804g[i]));
                        r0.f27811n[i3] = computeInField.m29118a(computeInField.m29117a(r0.f27806i[i], a), r0.f27811n[i3]);
                        r0.f27811n[i3] = computeInField.m29118a(computeInField.m29117a(r0.f27806i[i11], computeInField.m29117a(d[i8][i10][i], r0.f27804g[i])), r0.f27811n[i3]);
                        sArr4 = d;
                        r0.f27812o[i3] = GF2Field.m29126a(r0.f27812o[i3], GF2Field.m29127b(GF2Field.m29127b(d[i8][i10][i], r0.f27806i[i11]), r0.f27806i[i]));
                        i++;
                        i2 = i6;
                        i3 = i7;
                        i4 = i9;
                        g = sArr3;
                        d = sArr4;
                    }
                    i6 = i2;
                    i7 = i3;
                    i9 = i4;
                    sArr4 = d;
                    sArr3 = g;
                    i10++;
                    i = 0;
                }
                i6 = i2;
                i7 = i3;
                i9 = i4;
                sArr4 = d;
                sArr3 = g;
                for (i2 = 0; i2 < length2; i2++) {
                    for (i3 = 0; i3 < length2; i3++) {
                        short[] a2 = computeInField.m29117a(e[i8][i2][i3], r0.f27804g[i2]);
                        i4 = i5 + i8;
                        sArr[i4] = computeInField.m29122a(sArr[i4], computeInField.m29124b(a2, r0.f27804g[i3]));
                        r0.f27811n[i4] = computeInField.m29118a(computeInField.m29117a(r0.f27806i[i3], a2), r0.f27811n[i4]);
                        r0.f27811n[i4] = computeInField.m29118a(computeInField.m29117a(r0.f27806i[i2], computeInField.m29117a(e[i8][i2][i3], r0.f27804g[i3])), r0.f27811n[i4]);
                        r0.f27812o[i4] = GF2Field.m29126a(r0.f27812o[i4], GF2Field.m29127b(GF2Field.m29127b(e[i8][i2][i3], r0.f27806i[i2]), r0.f27806i[i3]));
                    }
                }
                for (i2 = 0; i2 < length2 + length; i2++) {
                    i4 = i5 + i8;
                    r0.f27811n[i4] = computeInField.m29118a(computeInField.m29117a(f[i8][i2], r0.f27804g[i2]), r0.f27811n[i4]);
                    r0.f27812o[i4] = GF2Field.m29126a(r0.f27812o[i4], GF2Field.m29127b(f[i8][i2], r0.f27806i[i2]));
                }
                i3 = i5 + i8;
                r0.f27812o[i3] = GF2Field.m29126a(r0.f27812o[i3], sArr3[i8]);
                i8++;
                i2 = i6;
                i3 = i7;
                i4 = i9;
                g = sArr3;
                d = sArr4;
                i = 0;
            }
            i6 = i2;
            i7 = i3;
            i5 += length;
            i4++;
            i = 0;
        }
        short[][][] sArr5 = (short[][][]) Array.newInstance(short.class, new int[]{i2, i3, i3});
        short[][] sArr6 = (short[][]) Array.newInstance(short.class, new int[]{i2, i3});
        sArr2 = new short[i2];
        for (i5 = 0; i5 < i2; i5++) {
            for (int i12 = 0; i12 < r0.f27801d.length; i12++) {
                sArr5[i5] = computeInField.m29122a(sArr5[i5], computeInField.m29120a(r0.f27801d[i5][i12], sArr[i12]));
                sArr6[i5] = computeInField.m29118a(sArr6[i5], computeInField.m29117a(r0.f27801d[i5][i12], r0.f27811n[i12]));
                sArr2[i5] = GF2Field.m29126a(sArr2[i5], GF2Field.m29127b(r0.f27801d[i5][i12], r0.f27812o[i12]));
            }
            sArr2[i5] = GF2Field.m29126a(sArr2[i5], r0.f27803f[i5]);
        }
        r0.f27811n = sArr6;
        r0.f27812o = sArr2;
        m36407a(sArr5);
    }

    /* renamed from: a */
    private void m36407a(short[][][] sArr) {
        int length = sArr.length;
        int length2 = sArr[0].length;
        this.f27810m = (short[][]) Array.newInstance(short.class, new int[]{length, ((length2 + 1) * length2) / 2});
        for (int i = 0; i < length; i++) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < length2) {
                int i4 = i3;
                for (i3 = i2; i3 < length2; i3++) {
                    if (i3 == i2) {
                        this.f27810m[i][i4] = sArr[i][i2][i3];
                    } else {
                        this.f27810m[i][i4] = GF2Field.m29126a(sArr[i][i2][i3], sArr[i][i3][i2]);
                    }
                    i4++;
                }
                i2++;
                i3 = i4;
            }
        }
    }

    /* renamed from: b */
    public void m36417b(KeyGenerationParameters keyGenerationParameters) {
        m36415a(keyGenerationParameters);
    }

    /* renamed from: a */
    public AsymmetricCipherKeyPair mo5755a() {
        return m36416b();
    }
}
