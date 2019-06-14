package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public abstract class LongDigest implements ExtendedDigest, EncodableDigest, Memoable {
    /* renamed from: i */
    static final long[] f31598i = new long[]{4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
    /* renamed from: a */
    protected long f31599a;
    /* renamed from: b */
    protected long f31600b;
    /* renamed from: c */
    protected long f31601c;
    /* renamed from: d */
    protected long f31602d;
    /* renamed from: e */
    protected long f31603e;
    /* renamed from: f */
    protected long f31604f;
    /* renamed from: g */
    protected long f31605g;
    /* renamed from: h */
    protected long f31606h;
    /* renamed from: j */
    private byte[] f31607j;
    /* renamed from: k */
    private int f31608k;
    /* renamed from: l */
    private long f31609l;
    /* renamed from: m */
    private long f31610m;
    /* renamed from: n */
    private long[] f31611n;
    /* renamed from: o */
    private int f31612o;

    /* renamed from: a */
    private long m40603a(long j) {
        return ((j >>> 39) | (j << 25)) ^ (((j << 36) | (j >>> 28)) ^ ((j << 30) | (j >>> 34)));
    }

    /* renamed from: a */
    private long m40604a(long j, long j2, long j3) {
        return ((~j) & j3) ^ (j2 & j);
    }

    /* renamed from: b */
    private long m40605b(long j) {
        return ((j >>> 41) | (j << 23)) ^ (((j << 50) | (j >>> 14)) ^ ((j << 46) | (j >>> 18)));
    }

    /* renamed from: b */
    private long m40606b(long j, long j2, long j3) {
        return ((j & j3) ^ (j & j2)) ^ (j2 & j3);
    }

    /* renamed from: c */
    private long m40607c(long j) {
        return (j >>> 7) ^ (((j << 63) | (j >>> 1)) ^ ((j << 56) | (j >>> 8)));
    }

    /* renamed from: d */
    private long m40608d(long j) {
        return (j >>> 6) ^ (((j << 45) | (j >>> 19)) ^ ((j << 3) | (j >>> 61)));
    }

    /* renamed from: d */
    public int mo6445d() {
        return 128;
    }

    protected LongDigest() {
        this.f31607j = new byte[8];
        this.f31611n = new long[80];
        this.f31608k = 0;
        mo5733c();
    }

    protected LongDigest(LongDigest longDigest) {
        this.f31607j = new byte[8];
        this.f31611n = new long[80];
        m40612a(longDigest);
    }

    /* renamed from: a */
    protected void m40612a(LongDigest longDigest) {
        System.arraycopy(longDigest.f31607j, 0, this.f31607j, 0, longDigest.f31607j.length);
        this.f31608k = longDigest.f31608k;
        this.f31609l = longDigest.f31609l;
        this.f31610m = longDigest.f31610m;
        this.f31599a = longDigest.f31599a;
        this.f31600b = longDigest.f31600b;
        this.f31601c = longDigest.f31601c;
        this.f31602d = longDigest.f31602d;
        this.f31603e = longDigest.f31603e;
        this.f31604f = longDigest.f31604f;
        this.f31605g = longDigest.f31605g;
        this.f31606h = longDigest.f31606h;
        System.arraycopy(longDigest.f31611n, 0, this.f31611n, 0, longDigest.f31611n.length);
        this.f31612o = longDigest.f31612o;
    }

    /* renamed from: a */
    public void mo5730a(byte b) {
        byte[] bArr = this.f31607j;
        int i = this.f31608k;
        this.f31608k = i + 1;
        bArr[i] = b;
        if (this.f31608k == this.f31607j.length) {
            m40614b(this.f31607j, 0);
            this.f31608k = 0;
        }
        this.f31609l++;
    }

    /* renamed from: a */
    public void mo5731a(byte[] bArr, int i, int i2) {
        while (this.f31608k != 0 && i2 > 0) {
            mo5730a(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > this.f31607j.length) {
            m40614b(bArr, i);
            i += this.f31607j.length;
            i2 -= this.f31607j.length;
            this.f31609l += (long) this.f31607j.length;
        }
        while (i2 > 0) {
            mo5730a(bArr[i]);
            i++;
            i2--;
        }
    }

    /* renamed from: f */
    public void m40617f() {
        m40609h();
        long j = this.f31609l << 3;
        long j2 = this.f31610m;
        mo5730a(Byte.MIN_VALUE);
        while (this.f31608k != 0) {
            mo5730a((byte) 0);
        }
        m40611a(j, j2);
        m40618g();
    }

    /* renamed from: c */
    public void mo5733c() {
        this.f31609l = 0;
        this.f31610m = 0;
        int i = 0;
        this.f31608k = 0;
        for (int i2 = 0; i2 < this.f31607j.length; i2++) {
            this.f31607j[i2] = (byte) 0;
        }
        this.f31612o = 0;
        while (i != this.f31611n.length) {
            this.f31611n[i] = 0;
            i++;
        }
    }

    /* renamed from: b */
    protected void m40614b(byte[] bArr, int i) {
        this.f31611n[this.f31612o] = Pack.m29407b(bArr, i);
        bArr = this.f31612o + 1;
        this.f31612o = bArr;
        if (bArr == 16) {
            m40618g();
        }
    }

    /* renamed from: h */
    private void m40609h() {
        if (this.f31609l > 2305843009213693951L) {
            this.f31610m += this.f31609l >>> 61;
            this.f31609l &= 2305843009213693951L;
        }
    }

    /* renamed from: a */
    protected void m40611a(long j, long j2) {
        if (this.f31612o > 14) {
            m40618g();
        }
        this.f31611n[14] = j2;
        this.f31611n[15] = j;
    }

    /* renamed from: g */
    protected void m40618g() {
        int i;
        LongDigest longDigest = this;
        m40609h();
        for (i = 16; i <= 79; i++) {
            longDigest.f31611n[i] = ((m40608d(longDigest.f31611n[i - 2]) + longDigest.f31611n[i - 7]) + m40607c(longDigest.f31611n[i - 15])) + longDigest.f31611n[i - 16];
        }
        long j = longDigest.f31599a;
        long j2 = longDigest.f31600b;
        long j3 = longDigest.f31601c;
        long j4 = longDigest.f31602d;
        long j5 = longDigest.f31603e;
        long j6 = longDigest.f31604f;
        long j7 = j4;
        long j8 = j2;
        long j9 = j3;
        long j10 = j7;
        long j11 = j;
        long j12 = longDigest.f31605g;
        j7 = j6;
        int i2 = 0;
        int i3 = 0;
        j6 = j5;
        j5 = longDigest.f31606h;
        while (i2 < 10) {
            long j13 = j11;
            int i4 = i3 + 1;
            j5 += ((m40605b(j6) + m40604a(j6, j7, j12)) + f31598i[i3]) + longDigest.f31611n[i3];
            long j14 = j13;
            long j15 = j14;
            j5 += m40603a(j14) + m40606b(j14, j8, j9);
            j11 = j10 + j5;
            j13 = j11;
            i3 = i4 + 1;
            j12 += ((m40605b(j11) + m40604a(j11, j6, j7)) + f31598i[i4]) + longDigest.f31611n[i4];
            long j16 = j5;
            long j17 = j9 + j12;
            j11 = j12 + (m40603a(j5) + m40606b(j5, j15, j8));
            j12 = m40605b(j17);
            long j18 = j17;
            j17 = j11;
            int i5 = i3 + 1;
            j7 += ((j12 + m40604a(j17, j13, j6)) + f31598i[i3]) + longDigest.f31611n[i3];
            int i6 = i2;
            long j19 = j8 + j7;
            j11 = j7 + (m40603a(j17) + m40606b(j17, j16, j15));
            j7 = m40605b(j19);
            long j20 = j19;
            j19 = j11;
            int i7 = i5 + 1;
            j6 += ((j7 + m40604a(j19, j18, j13)) + f31598i[i5]) + longDigest.f31611n[i5];
            j14 = j17;
            long j21 = j17;
            j17 = j15 + j6;
            long a = j6 + (m40603a(j19) + m40606b(j19, j14, j16));
            int i8 = i7 + 1;
            j7 = j13 + (((m40605b(j17) + m40604a(j17, j20, j18)) + f31598i[i7]) + longDigest.f31611n[i7]);
            j14 = j19;
            long j22 = j19;
            j19 = j16 + j7;
            j11 = j7 + (m40603a(a) + m40606b(a, j14, j21));
            j14 = j17;
            long j23 = j17;
            j17 = j11;
            i7 = i8 + 1;
            j7 = j18 + (((m40605b(j19) + m40604a(j19, j14, j20)) + f31598i[i8]) + longDigest.f31611n[i8]);
            long j24 = j21 + j7;
            j14 = j19;
            long j25 = j19;
            j19 = j7 + (m40603a(j17) + m40606b(j17, a, j22));
            int i9 = i7 + 1;
            j7 = j20 + (((m40605b(j24) + m40604a(j24, j14, j23)) + f31598i[i7]) + longDigest.f31611n[i7]);
            j14 = j17;
            long j26 = j17;
            j17 = j22 + j7;
            j11 = j7 + (m40603a(j19) + m40606b(j19, j14, a));
            j7 = m40605b(j17);
            long j27 = j17;
            j17 = j11;
            j7 = j23 + (((j7 + m40604a(j17, j24, j25)) + f31598i[i9]) + longDigest.f31611n[i9]);
            a += j7;
            j11 = j7 + (m40603a(j17) + m40606b(j17, j19, j26));
            j9 = j19;
            j8 = j17;
            i3 = i9 + 1;
            j10 = j26;
            j7 = j27;
            i2 = i6 + 1;
            j12 = j24;
            j6 = a;
            j5 = j25;
        }
        longDigest.f31599a += j11;
        longDigest.f31600b += j8;
        longDigest.f31601c += j9;
        longDigest.f31602d += j10;
        longDigest.f31603e += j6;
        longDigest.f31604f += j7;
        longDigest.f31605g += j12;
        longDigest.f31606h += j5;
        i = 0;
        longDigest.f31612o = 0;
        while (i < 16) {
            longDigest.f31611n[i] = 0;
            i++;
        }
    }
}
