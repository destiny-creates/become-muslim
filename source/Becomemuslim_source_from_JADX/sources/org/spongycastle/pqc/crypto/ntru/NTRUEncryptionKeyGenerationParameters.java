package org.spongycastle.pqc.crypto.ntru;

import java.security.SecureRandom;
import java.util.Arrays;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;

public class NTRUEncryptionKeyGenerationParameters extends KeyGenerationParameters implements Cloneable {
    /* renamed from: a */
    public static final NTRUEncryptionKeyGenerationParameters f27726a = new NTRUEncryptionKeyGenerationParameters(1087, 2048, 120, 120, 256, 13, 25, 14, true, new byte[]{(byte) 0, (byte) 6, (byte) 3}, true, false, new SHA512Digest());
    /* renamed from: b */
    public static final NTRUEncryptionKeyGenerationParameters f27727b = new NTRUEncryptionKeyGenerationParameters(1171, 2048, 106, 106, 256, 13, 20, 15, true, new byte[]{(byte) 0, (byte) 6, (byte) 4}, true, false, new SHA512Digest());
    /* renamed from: c */
    public static final NTRUEncryptionKeyGenerationParameters f27728c = new NTRUEncryptionKeyGenerationParameters(1499, 2048, 79, 79, 256, 13, 17, 19, true, new byte[]{(byte) 0, (byte) 6, (byte) 5}, true, false, new SHA512Digest());
    /* renamed from: d */
    public static final NTRUEncryptionKeyGenerationParameters f27729d = new NTRUEncryptionKeyGenerationParameters(439, 2048, 146, 130, 128, 9, 32, 9, true, new byte[]{(byte) 0, (byte) 7, (byte) 101}, true, false, new SHA256Digest());
    /* renamed from: e */
    public static final NTRUEncryptionKeyGenerationParameters f27730e = new NTRUEncryptionKeyGenerationParameters(439, 2048, 9, 8, 5, 130, 128, 9, 32, 9, true, new byte[]{(byte) 0, (byte) 7, (byte) 101}, true, true, new SHA256Digest());
    /* renamed from: f */
    public static final NTRUEncryptionKeyGenerationParameters f27731f = new NTRUEncryptionKeyGenerationParameters(743, 2048, 248, 220, 256, 10, 27, 14, true, new byte[]{(byte) 0, (byte) 7, (byte) 105}, false, false, new SHA512Digest());
    /* renamed from: g */
    public static final NTRUEncryptionKeyGenerationParameters f27732g = new NTRUEncryptionKeyGenerationParameters(743, 2048, 11, 11, 15, 220, 256, 10, 27, 14, true, new byte[]{(byte) 0, (byte) 7, (byte) 105}, false, true, new SHA512Digest());
    /* renamed from: A */
    public int f27733A;
    /* renamed from: B */
    public int f27734B;
    /* renamed from: C */
    public boolean f27735C;
    /* renamed from: D */
    public byte[] f27736D;
    /* renamed from: E */
    public boolean f27737E;
    /* renamed from: F */
    public boolean f27738F;
    /* renamed from: G */
    public int f27739G = 1;
    /* renamed from: H */
    public Digest f27740H;
    /* renamed from: h */
    public int f27741h;
    /* renamed from: i */
    public int f27742i;
    /* renamed from: j */
    public int f27743j;
    /* renamed from: k */
    public int f27744k;
    /* renamed from: l */
    public int f27745l;
    /* renamed from: m */
    public int f27746m;
    /* renamed from: n */
    public int f27747n;
    /* renamed from: o */
    public int f27748o;
    /* renamed from: p */
    public int f27749p;
    /* renamed from: q */
    public int f27750q;
    /* renamed from: r */
    public int f27751r;
    /* renamed from: s */
    int f27752s;
    /* renamed from: t */
    public int f27753t;
    /* renamed from: u */
    public int f27754u;
    /* renamed from: v */
    public int f27755v;
    /* renamed from: w */
    int f27756w;
    /* renamed from: x */
    public int f27757x;
    /* renamed from: y */
    public int f27758y;
    /* renamed from: z */
    public int f27759z;

    public /* synthetic */ Object clone() {
        return m36380d();
    }

    public NTRUEncryptionKeyGenerationParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        super(new SecureRandom(), i5);
        this.f27741h = i;
        this.f27742i = i2;
        this.f27743j = i3;
        this.f27754u = i5;
        this.f27757x = i4;
        this.f27759z = i6;
        this.f27733A = i7;
        this.f27734B = i8;
        this.f27735C = z;
        this.f27736D = bArr;
        this.f27737E = z2;
        this.f27738F = z3;
        this.f27740H = digest;
        m36378e();
    }

    public NTRUEncryptionKeyGenerationParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        int i11 = i7;
        super(new SecureRandom(), i7);
        this.f27741h = i;
        this.f27742i = i2;
        this.f27744k = i3;
        this.f27745l = i4;
        this.f27746m = i5;
        this.f27754u = i11;
        this.f27757x = i6;
        this.f27759z = i8;
        this.f27733A = i9;
        this.f27734B = i10;
        this.f27735C = z;
        this.f27736D = bArr;
        this.f27737E = z2;
        this.f27738F = z3;
        this.f27740H = digest;
        m36378e();
    }

    /* renamed from: e */
    private void m36378e() {
        this.f27747n = this.f27743j;
        this.f27748o = this.f27744k;
        this.f27749p = this.f27745l;
        this.f27750q = this.f27746m;
        this.f27751r = this.f27741h / 3;
        this.f27752s = 1;
        this.f27753t = (((((this.f27741h * 3) / 2) / 8) - this.f27752s) - (this.f27754u / 8)) - 1;
        this.f27755v = (((((this.f27741h * 3) / 2) + 7) / 8) * 8) + 1;
        this.f27756w = this.f27741h - 1;
        this.f27758y = this.f27754u;
    }

    /* renamed from: c */
    public NTRUEncryptionParameters m36379c() {
        if (this.f27739G == 0) {
            return new NTRUEncryptionParameters(r0.f27741h, r0.f27742i, r0.f27743j, r0.f27757x, r0.f27754u, r0.f27759z, r0.f27733A, r0.f27734B, r0.f27735C, r0.f27736D, r0.f27737E, r0.f27738F, r0.f27740H);
        }
        return new NTRUEncryptionParameters(r0.f27741h, r0.f27742i, r0.f27744k, r0.f27745l, r0.f27746m, r0.f27757x, r0.f27754u, r0.f27759z, r0.f27733A, r0.f27734B, r0.f27735C, r0.f27736D, r0.f27737E, r0.f27738F, r0.f27740H);
    }

    /* renamed from: d */
    public NTRUEncryptionKeyGenerationParameters m36380d() {
        if (this.f27739G == 0) {
            return new NTRUEncryptionKeyGenerationParameters(r0.f27741h, r0.f27742i, r0.f27743j, r0.f27757x, r0.f27754u, r0.f27759z, r0.f27733A, r0.f27734B, r0.f27735C, r0.f27736D, r0.f27737E, r0.f27738F, r0.f27740H);
        }
        return new NTRUEncryptionKeyGenerationParameters(r0.f27741h, r0.f27742i, r0.f27744k, r0.f27745l, r0.f27746m, r0.f27757x, r0.f27754u, r0.f27759z, r0.f27733A, r0.f27734B, r0.f27735C, r0.f27736D, r0.f27737E, r0.f27738F, r0.f27740H);
    }

    public int hashCode() {
        int i = 1237;
        int hashCode = (((((((((((((((((((((((((((((((((((((((((((((((((((this.f27741h + 31) * 31) + this.f27755v) * 31) + this.f27756w) * 31) + this.f27759z) * 31) + this.f27754u) * 31) + this.f27743j) * 31) + this.f27744k) * 31) + this.f27745l) * 31) + this.f27746m) * 31) + this.f27751r) * 31) + this.f27757x) * 31) + this.f27747n) * 31) + this.f27748o) * 31) + this.f27749p) * 31) + this.f27750q) * 31) + (this.f27738F ? 1231 : 1237)) * 31) + (this.f27740H == null ? 0 : this.f27740H.mo5729a().hashCode())) * 31) + (this.f27735C ? 1231 : 1237)) * 31) + this.f27752s) * 31) + this.f27753t) * 31) + this.f27734B) * 31) + this.f27733A) * 31) + Arrays.hashCode(this.f27736D)) * 31) + this.f27758y) * 31) + this.f27739G) * 31) + this.f27742i) * 31;
        if (this.f27737E) {
            i = 1231;
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NTRUEncryptionKeyGenerationParameters nTRUEncryptionKeyGenerationParameters = (NTRUEncryptionKeyGenerationParameters) obj;
        if (this.f27741h != nTRUEncryptionKeyGenerationParameters.f27741h || this.f27755v != nTRUEncryptionKeyGenerationParameters.f27755v || this.f27756w != nTRUEncryptionKeyGenerationParameters.f27756w || this.f27759z != nTRUEncryptionKeyGenerationParameters.f27759z || this.f27754u != nTRUEncryptionKeyGenerationParameters.f27754u || this.f27743j != nTRUEncryptionKeyGenerationParameters.f27743j || this.f27744k != nTRUEncryptionKeyGenerationParameters.f27744k || this.f27745l != nTRUEncryptionKeyGenerationParameters.f27745l || this.f27746m != nTRUEncryptionKeyGenerationParameters.f27746m || this.f27751r != nTRUEncryptionKeyGenerationParameters.f27751r || this.f27757x != nTRUEncryptionKeyGenerationParameters.f27757x || this.f27747n != nTRUEncryptionKeyGenerationParameters.f27747n || this.f27748o != nTRUEncryptionKeyGenerationParameters.f27748o || this.f27749p != nTRUEncryptionKeyGenerationParameters.f27749p || this.f27750q != nTRUEncryptionKeyGenerationParameters.f27750q || this.f27738F != nTRUEncryptionKeyGenerationParameters.f27738F) {
            return false;
        }
        if (this.f27740H == null) {
            if (nTRUEncryptionKeyGenerationParameters.f27740H != null) {
                return false;
            }
        } else if (!this.f27740H.mo5729a().equals(nTRUEncryptionKeyGenerationParameters.f27740H.mo5729a())) {
            return false;
        }
        return this.f27735C == nTRUEncryptionKeyGenerationParameters.f27735C && this.f27752s == nTRUEncryptionKeyGenerationParameters.f27752s && this.f27753t == nTRUEncryptionKeyGenerationParameters.f27753t && this.f27734B == nTRUEncryptionKeyGenerationParameters.f27734B && this.f27733A == nTRUEncryptionKeyGenerationParameters.f27733A && Arrays.equals(this.f27736D, nTRUEncryptionKeyGenerationParameters.f27736D) && this.f27758y == nTRUEncryptionKeyGenerationParameters.f27758y && this.f27739G == nTRUEncryptionKeyGenerationParameters.f27739G && this.f27742i == nTRUEncryptionKeyGenerationParameters.f27742i && this.f27737E == nTRUEncryptionKeyGenerationParameters.f27737E;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EncryptionParameters(N=");
        stringBuilder.append(this.f27741h);
        stringBuilder.append(" q=");
        stringBuilder.append(this.f27742i);
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.toString());
        if (this.f27739G == 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" polyType=SIMPLE df=");
            stringBuilder.append(this.f27743j);
            stringBuilder2.append(stringBuilder.toString());
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" polyType=PRODUCT df1=");
            stringBuilder.append(this.f27744k);
            stringBuilder.append(" df2=");
            stringBuilder.append(this.f27745l);
            stringBuilder.append(" df3=");
            stringBuilder.append(this.f27746m);
            stringBuilder2.append(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(" dm0=");
        stringBuilder.append(this.f27757x);
        stringBuilder.append(" db=");
        stringBuilder.append(this.f27754u);
        stringBuilder.append(" c=");
        stringBuilder.append(this.f27759z);
        stringBuilder.append(" minCallsR=");
        stringBuilder.append(this.f27733A);
        stringBuilder.append(" minCallsMask=");
        stringBuilder.append(this.f27734B);
        stringBuilder.append(" hashSeed=");
        stringBuilder.append(this.f27735C);
        stringBuilder.append(" hashAlg=");
        stringBuilder.append(this.f27740H);
        stringBuilder.append(" oid=");
        stringBuilder.append(Arrays.toString(this.f27736D));
        stringBuilder.append(" sparse=");
        stringBuilder.append(this.f27737E);
        stringBuilder.append(")");
        stringBuilder2.append(stringBuilder.toString());
        return stringBuilder2.toString();
    }
}
