package com.google.android.exoplayer2.p137e.p141e;

import com.amplitude.api.Constants;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2327l;
import com.google.android.exoplayer2.p164l.C2516a;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: DefaultOggSeeker */
/* renamed from: com.google.android.exoplayer2.e.e.a */
final class C4117a implements C2292f {
    /* renamed from: a */
    private final C2291e f10539a = new C2291e();
    /* renamed from: b */
    private final long f10540b;
    /* renamed from: c */
    private final long f10541c;
    /* renamed from: d */
    private final C2295h f10542d;
    /* renamed from: e */
    private int f10543e;
    /* renamed from: f */
    private long f10544f;
    /* renamed from: g */
    private long f10545g;
    /* renamed from: h */
    private long f10546h;
    /* renamed from: i */
    private long f10547i;
    /* renamed from: j */
    private long f10548j;
    /* renamed from: k */
    private long f10549k;
    /* renamed from: l */
    private long f10550l;

    /* compiled from: DefaultOggSeeker */
    /* renamed from: com.google.android.exoplayer2.e.e.a$a */
    private class C4116a implements C2327l {
        /* renamed from: a */
        final /* synthetic */ C4117a f10538a;

        /* renamed from: a */
        public boolean mo2167a() {
            return true;
        }

        private C4116a(C4117a c4117a) {
            this.f10538a = c4117a;
        }

        /* renamed from: b */
        public long mo2169b(long j) {
            if (j == 0) {
                return this.f10538a.f10540b;
            }
            return this.f10538a.m12983a(this.f10538a.f10540b, this.f10538a.f10542d.m6352b(j), (long) Constants.EVENT_UPLOAD_PERIOD_MILLIS);
        }

        /* renamed from: b */
        public long mo2168b() {
            return this.f10538a.f10542d.m6347a(this.f10538a.f10544f);
        }
    }

    /* renamed from: c */
    public /* synthetic */ C2327l mo2203c() {
        return m12992a();
    }

    public C4117a(long j, long j2, C2295h c2295h, int i, long j3) {
        boolean z = j >= 0 && j2 > j;
        C2516a.m7017a(z);
        this.f10542d = c2295h;
        this.f10540b = j;
        this.f10541c = j2;
        if (((long) i) == j2 - j) {
            this.f10544f = j3;
            this.f10543e = 3;
            return;
        }
        this.f10543e = 0;
    }

    /* renamed from: a */
    public long mo2202a(C2304f c2304f) {
        long j;
        switch (this.f10543e) {
            case 0:
                this.f10545g = c2304f.mo2189c();
                this.f10543e = 1;
                j = this.f10541c - 65307;
                if (j > this.f10545g) {
                    return j;
                }
                break;
            case 1:
                break;
            case 2:
                long j2 = 0;
                if (this.f10546h != 0) {
                    j = m12989a(this.f10546h, c2304f);
                    if (j >= 0) {
                        return j;
                    }
                    j2 = m12991a(c2304f, this.f10546h, -(j + 2));
                }
                this.f10543e = 3;
                return -(j2 + 2);
            case 3:
                return -1;
            default:
                throw new IllegalStateException();
        }
        this.f10544f = m12996c(c2304f);
        this.f10543e = 3;
        return this.f10545g;
    }

    /* renamed from: a */
    public long mo2201a(long j) {
        boolean z;
        long j2;
        if (this.f10543e != 3) {
            if (this.f10543e != 2) {
                z = false;
                C2516a.m7017a(z);
                j2 = 0;
                if (j == 0) {
                    j2 = this.f10542d.m6352b(j);
                }
                this.f10546h = j2;
                this.f10543e = 2;
                m12994b();
                return this.f10546h;
            }
        }
        z = true;
        C2516a.m7017a(z);
        j2 = 0;
        if (j == 0) {
            j2 = this.f10542d.m6352b(j);
        }
        this.f10546h = j2;
        this.f10543e = 2;
        m12994b();
        return this.f10546h;
    }

    /* renamed from: a */
    public C4116a m12992a() {
        return this.f10544f != 0 ? new C4116a() : null;
    }

    /* renamed from: b */
    public void m12994b() {
        this.f10547i = this.f10540b;
        this.f10548j = this.f10541c;
        this.f10549k = 0;
        this.f10550l = this.f10544f;
    }

    /* renamed from: a */
    public long m12989a(long j, C2304f c2304f) {
        long j2 = 2;
        if (this.f10547i == this.f10548j) {
            return -(this.f10549k + 2);
        }
        long c = c2304f.mo2189c();
        if (m12993a(c2304f, this.f10548j)) {
            this.f10539a.m6340a(c2304f, false);
            c2304f.mo2183a();
            j -= this.f10539a.f5622c;
            int i = this.f10539a.f5627h + this.f10539a.f5628i;
            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i2 >= 0) {
                if (j <= 72000) {
                    c2304f.mo2186b(i);
                    return -(this.f10539a.f5622c + 2);
                }
            }
            if (i2 < 0) {
                this.f10548j = c;
                this.f10550l = this.f10539a.f5622c;
            } else {
                long j3 = (long) i;
                this.f10547i = c2304f.mo2189c() + j3;
                this.f10549k = this.f10539a.f5622c;
                if ((this.f10548j - this.f10547i) + j3 < 100000) {
                    c2304f.mo2186b(i);
                    return -(this.f10549k + 2);
                }
            }
            if (this.f10548j - this.f10547i < 100000) {
                this.f10548j = this.f10547i;
                return this.f10547i;
            }
            c = (long) i;
            if (i2 > 0) {
                j2 = 1;
            }
            return Math.min(Math.max((c2304f.mo2189c() - (c * j2)) + ((j * (this.f10548j - this.f10547i)) / (this.f10550l - this.f10549k)), this.f10547i), this.f10548j - 1);
        } else if (this.f10547i != c) {
            return this.f10547i;
        } else {
            throw new IOException("No ogg page can be found.");
        }
    }

    /* renamed from: a */
    private long m12983a(long j, long j2, long j3) {
        j += ((j2 * (this.f10541c - this.f10540b)) / this.f10544f) - j3;
        if (j < this.f10540b) {
            j = this.f10540b;
        }
        return j >= this.f10541c ? this.f10541c - 1 : j;
    }

    /* renamed from: b */
    void m12995b(C2304f c2304f) {
        if (m12993a(c2304f, this.f10541c) == null) {
            throw new EOFException();
        }
    }

    /* renamed from: a */
    boolean m12993a(C2304f c2304f, long j) {
        j = Math.min(j + 3, this.f10541c);
        byte[] bArr = new byte[2048];
        int length = bArr.length;
        while (true) {
            int i;
            int i2 = 0;
            if (c2304f.mo2189c() + ((long) length) > j) {
                length = (int) (j - c2304f.mo2189c());
                if (length < 4) {
                    return false;
                }
            }
            c2304f.mo2188b(bArr, 0, length, false);
            while (true) {
                i = length - 3;
                if (i2 >= i) {
                    break;
                } else if (bArr[i2] == (byte) 79 && bArr[i2 + 1] == (byte) 103 && bArr[i2 + 2] == (byte) 103 && bArr[i2 + 3] == (byte) 83) {
                    c2304f.mo2186b(i2);
                    return true;
                } else {
                    i2++;
                }
            }
            c2304f.mo2186b(i);
        }
    }

    /* renamed from: c */
    long m12996c(C2304f c2304f) {
        m12995b(c2304f);
        this.f10539a.m6339a();
        while ((this.f10539a.f5621b & 4) != 4 && c2304f.mo2189c() < this.f10541c) {
            this.f10539a.m6340a(c2304f, false);
            c2304f.mo2186b(this.f10539a.f5627h + this.f10539a.f5628i);
        }
        return this.f10539a.f5622c;
    }

    /* renamed from: a */
    long m12991a(C2304f c2304f, long j, long j2) {
        this.f10539a.m6340a(c2304f, false);
        while (this.f10539a.f5622c < j) {
            c2304f.mo2186b(this.f10539a.f5627h + this.f10539a.f5628i);
            j2 = this.f10539a.f5622c;
            this.f10539a.m6340a(c2304f, false);
        }
        c2304f.mo2183a();
        return j2;
    }
}
