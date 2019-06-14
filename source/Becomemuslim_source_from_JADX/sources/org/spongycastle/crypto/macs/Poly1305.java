package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;

public class Poly1305 implements Mac {
    /* renamed from: a */
    private final BlockCipher f26920a;
    /* renamed from: b */
    private final byte[] f26921b;
    /* renamed from: c */
    private int f26922c;
    /* renamed from: d */
    private int f26923d;
    /* renamed from: e */
    private int f26924e;
    /* renamed from: f */
    private int f26925f;
    /* renamed from: g */
    private int f26926g;
    /* renamed from: h */
    private int f26927h;
    /* renamed from: i */
    private int f26928i;
    /* renamed from: j */
    private int f26929j;
    /* renamed from: k */
    private int f26930k;
    /* renamed from: l */
    private int f26931l;
    /* renamed from: m */
    private int f26932m;
    /* renamed from: n */
    private int f26933n;
    /* renamed from: o */
    private int f26934o;
    /* renamed from: p */
    private final byte[] f26935p;
    /* renamed from: q */
    private int f26936q;
    /* renamed from: r */
    private int f26937r;
    /* renamed from: s */
    private int f26938s;
    /* renamed from: t */
    private int f26939t;
    /* renamed from: u */
    private int f26940u;
    /* renamed from: v */
    private int f26941v;

    /* renamed from: a */
    private static final long m35452a(int i, int i2) {
        return ((long) i) * ((long) i2);
    }

    /* renamed from: b */
    public int mo5766b() {
        return 16;
    }

    public Poly1305() {
        this.f26921b = new byte[1];
        this.f26935p = new byte[16];
        this.f26936q = 0;
        this.f26920a = null;
    }

    public Poly1305(BlockCipher blockCipher) {
        this.f26921b = new byte[1];
        this.f26935p = new byte[16];
        this.f26936q = 0;
        if (blockCipher.mo5743b() == 16) {
            this.f26920a = blockCipher;
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
    }

    /* renamed from: a */
    public void mo5764a(CipherParameters cipherParameters) {
        byte[] bArr;
        if (this.f26920a == null) {
            bArr = null;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.m35695a();
            cipherParameters = parametersWithIV.m35696b();
        } else {
            throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
        }
        if (cipherParameters instanceof KeyParameter) {
            m35453a(((KeyParameter) cipherParameters).m35685a(), bArr);
            mo5767c();
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a key.");
    }

    /* renamed from: a */
    private void m35453a(byte[] bArr, byte[] bArr2) {
        if (this.f26920a != null) {
            if (bArr2 == null || bArr2.length != 16) {
                throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
            }
        }
        Poly1305KeyGenerator.m35371b(bArr);
        int c = Pack.m29411c(bArr, 16);
        int c2 = Pack.m29411c(bArr, 20);
        int c3 = Pack.m29411c(bArr, 24);
        int c4 = Pack.m29411c(bArr, 28);
        this.f26922c = 67108863 & c;
        this.f26923d = ((c >>> 26) | (c2 << 6)) & 67108611;
        this.f26924e = ((c2 >>> 20) | (c3 << 12)) & 67092735;
        this.f26925f = ((c3 >>> 14) | (c4 << 18)) & 66076671;
        this.f26926g = (c4 >>> 8) & 1048575;
        this.f26927h = this.f26923d * 5;
        this.f26928i = this.f26924e * 5;
        this.f26929j = this.f26925f * 5;
        this.f26930k = this.f26926g * 5;
        if (this.f26920a != null) {
            byte[] bArr3 = new byte[16];
            this.f26920a.mo5742a(true, new KeyParameter(bArr, 0, 16));
            this.f26920a.mo5740a(bArr2, 0, bArr3, 0);
            bArr = bArr3;
        }
        this.f26931l = Pack.m29411c(bArr, 0);
        this.f26932m = Pack.m29411c(bArr, 4);
        this.f26933n = Pack.m29411c(bArr, 8);
        this.f26934o = Pack.m29411c(bArr, 12);
    }

    /* renamed from: a */
    public String mo5762a() {
        if (this.f26920a == null) {
            return "Poly1305";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Poly1305-");
        stringBuilder.append(this.f26920a.mo5741a());
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public void mo5763a(byte b) {
        this.f26921b[0] = b;
        mo5765a(this.f26921b, 0, 1);
    }

    /* renamed from: a */
    public void mo5765a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i2 > i3) {
            if (this.f26936q == 16) {
                m35454d();
                this.f26936q = 0;
            }
            int min = Math.min(i2 - i3, 16 - this.f26936q);
            System.arraycopy(bArr, i3 + i, this.f26935p, this.f26936q, min);
            i3 += min;
            this.f26936q += min;
        }
    }

    /* renamed from: d */
    private void m35454d() {
        if (this.f26936q < 16) {
            r0.f26935p[r0.f26936q] = (byte) 1;
            for (int i = r0.f26936q + 1; i < 16; i++) {
                r0.f26935p[i] = (byte) 0;
            }
        }
        long c = ((long) Pack.m29411c(r0.f26935p, 0)) & 4294967295L;
        long c2 = ((long) Pack.m29411c(r0.f26935p, 4)) & 4294967295L;
        long c3 = ((long) Pack.m29411c(r0.f26935p, 8)) & 4294967295L;
        long c4 = 4294967295L & ((long) Pack.m29411c(r0.f26935p, 12));
        r0.f26937r = (int) (((long) r0.f26937r) + (c & 67108863));
        r0.f26938s = (int) (((long) r0.f26938s) + ((((c2 << 32) | c) >>> 26) & 67108863));
        r0.f26939t = (int) (((long) r0.f26939t) + (((c2 | (c3 << 32)) >>> 20) & 67108863));
        r0.f26940u = (int) (((long) r0.f26940u) + ((((c4 << 32) | c3) >>> 14) & 67108863));
        r0.f26941v = (int) (((long) r0.f26941v) + (c4 >>> 8));
        if (r0.f26936q == 16) {
            r0.f26941v += 16777216;
        }
        c = (((m35452a(r0.f26937r, r0.f26922c) + m35452a(r0.f26938s, r0.f26930k)) + m35452a(r0.f26939t, r0.f26929j)) + m35452a(r0.f26940u, r0.f26928i)) + m35452a(r0.f26941v, r0.f26927h);
        long a = (((m35452a(r0.f26937r, r0.f26923d) + m35452a(r0.f26938s, r0.f26922c)) + m35452a(r0.f26939t, r0.f26930k)) + m35452a(r0.f26940u, r0.f26929j)) + m35452a(r0.f26941v, r0.f26928i);
        long a2 = (((m35452a(r0.f26937r, r0.f26924e) + m35452a(r0.f26938s, r0.f26923d)) + m35452a(r0.f26939t, r0.f26922c)) + m35452a(r0.f26940u, r0.f26930k)) + m35452a(r0.f26941v, r0.f26929j);
        long a3 = (((m35452a(r0.f26937r, r0.f26925f) + m35452a(r0.f26938s, r0.f26924e)) + m35452a(r0.f26939t, r0.f26923d)) + m35452a(r0.f26940u, r0.f26922c)) + m35452a(r0.f26941v, r0.f26930k);
        long a4 = (((m35452a(r0.f26937r, r0.f26926g) + m35452a(r0.f26938s, r0.f26925f)) + m35452a(r0.f26939t, r0.f26924e)) + m35452a(r0.f26940u, r0.f26923d)) + m35452a(r0.f26941v, r0.f26922c);
        r0.f26937r = ((int) c) & 67108863;
        a += c >>> 26;
        r0.f26938s = ((int) a) & 67108863;
        a2 += (a >>> 26) & -1;
        r0.f26939t = ((int) a2) & 67108863;
        a3 += (a2 >>> 26) & -1;
        r0.f26940u = ((int) a3) & 67108863;
        a4 += a3 >>> 26;
        r0.f26941v = ((int) a4) & 67108863;
        r0.f26937r = (int) (((long) r0.f26937r) + ((a4 >>> 26) * 5));
    }

    /* renamed from: a */
    public int mo5761a(byte[] bArr, int i) {
        if (i + 16 <= bArr.length) {
            if (this.f26936q > 0) {
                m35454d();
            }
            int i2 = this.f26937r >>> 26;
            this.f26937r &= 67108863;
            this.f26938s += i2;
            i2 = this.f26938s >>> 26;
            this.f26938s &= 67108863;
            this.f26939t += i2;
            i2 = this.f26939t >>> 26;
            this.f26939t &= 67108863;
            this.f26940u += i2;
            i2 = this.f26940u >>> 26;
            this.f26940u &= 67108863;
            this.f26941v += i2;
            i2 = this.f26941v >>> 26;
            this.f26941v &= 67108863;
            this.f26937r += i2 * 5;
            i2 = this.f26937r + 5;
            int i3 = i2 >>> 26;
            i2 &= 67108863;
            int i4 = this.f26938s + i3;
            i3 = i4 >>> 26;
            i4 &= 67108863;
            int i5 = this.f26939t + i3;
            i3 = i5 >>> 26;
            i5 &= 67108863;
            int i6 = this.f26940u + i3;
            int i7 = 67108863 & i6;
            i6 = (this.f26941v + (i6 >>> 26)) - 67108864;
            i3 = (i6 >>> 31) - 1;
            int i8 = ~i3;
            this.f26937r = (i2 & i3) | (this.f26937r & i8);
            this.f26938s = (this.f26938s & i8) | (i4 & i3);
            this.f26939t = (this.f26939t & i8) | (i5 & i3);
            this.f26940u = (this.f26940u & i8) | (i7 & i3);
            this.f26941v = (this.f26941v & i8) | (i3 & i6);
            long j = (((long) (this.f26937r | (this.f26938s << 26))) & 4294967295L) + (((long) this.f26931l) & 4294967295L);
            long j2 = (((long) ((this.f26938s >>> 6) | (this.f26939t << 20))) & 4294967295L) + (((long) this.f26932m) & 4294967295L);
            long j3 = (((long) ((this.f26939t >>> 12) | (this.f26940u << 14))) & 4294967295L) + (((long) this.f26933n) & 4294967295L);
            long j4 = (((long) ((this.f26940u >>> 18) | (this.f26941v << 8))) & 4294967295L) + (4294967295L & ((long) this.f26934o));
            Pack.m29408b((int) j, bArr, i);
            j2 += j >>> 32;
            Pack.m29408b((int) j2, bArr, i + 4);
            j3 += j2 >>> 32;
            Pack.m29408b((int) j3, bArr, i + 8);
            Pack.m29408b((int) (j4 + (j3 >>> 32)), bArr, i + 12);
            mo5767c();
            return 16;
        }
        throw new DataLengthException("Output buffer is too short.");
    }

    /* renamed from: c */
    public void mo5767c() {
        this.f26936q = 0;
        this.f26941v = 0;
        this.f26940u = 0;
        this.f26939t = 0;
        this.f26938s = 0;
        this.f26937r = 0;
    }
}
