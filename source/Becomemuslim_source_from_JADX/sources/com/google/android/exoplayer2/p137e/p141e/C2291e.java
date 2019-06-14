package com.google.android.exoplayer2.p137e.p141e;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;
import java.io.EOFException;

/* compiled from: OggPageHeader */
/* renamed from: com.google.android.exoplayer2.e.e.e */
final class C2291e {
    /* renamed from: k */
    private static final int f5619k = C2541v.m7193g("OggS");
    /* renamed from: a */
    public int f5620a;
    /* renamed from: b */
    public int f5621b;
    /* renamed from: c */
    public long f5622c;
    /* renamed from: d */
    public long f5623d;
    /* renamed from: e */
    public long f5624e;
    /* renamed from: f */
    public long f5625f;
    /* renamed from: g */
    public int f5626g;
    /* renamed from: h */
    public int f5627h;
    /* renamed from: i */
    public int f5628i;
    /* renamed from: j */
    public final int[] f5629j = new int[JfifUtil.MARKER_FIRST_BYTE];
    /* renamed from: l */
    private final C2529l f5630l = new C2529l((int) JfifUtil.MARKER_FIRST_BYTE);

    C2291e() {
    }

    /* renamed from: a */
    public void m6339a() {
        this.f5620a = 0;
        this.f5621b = 0;
        this.f5622c = 0;
        this.f5623d = 0;
        this.f5624e = 0;
        this.f5625f = 0;
        this.f5626g = 0;
        this.f5627h = 0;
        this.f5628i = 0;
    }

    /* renamed from: a */
    public boolean m6340a(C2304f c2304f, boolean z) {
        Object obj;
        this.f5630l.m7088a();
        m6339a();
        int i = 0;
        if (c2304f.mo2192d() != -1) {
            if (c2304f.mo2192d() - c2304f.mo2185b() < 27) {
                obj = null;
                if (obj != null) {
                    if (!c2304f.mo2188b(this.f5630l.f6441a, 0, 27, true)) {
                        if (this.f5630l.m7109m() != ((long) f5619k)) {
                            this.f5620a = this.f5630l.m7103g();
                            if (this.f5620a != 0) {
                                this.f5621b = this.f5630l.m7103g();
                                this.f5622c = this.f5630l.m7114r();
                                this.f5623d = this.f5630l.m7110n();
                                this.f5624e = this.f5630l.m7110n();
                                this.f5625f = this.f5630l.m7110n();
                                this.f5626g = this.f5630l.m7103g();
                                this.f5627h = this.f5626g + true;
                                this.f5630l.m7088a();
                                c2304f.mo2191c(this.f5630l.f6441a, 0, this.f5626g);
                                while (i < this.f5626g) {
                                    this.f5629j[i] = this.f5630l.m7103g();
                                    this.f5628i += this.f5629j[i];
                                    i++;
                                }
                                return true;
                            } else if (z) {
                                return false;
                            } else {
                                throw new C2571p("unsupported bit stream revision");
                            }
                        } else if (z) {
                            return false;
                        } else {
                            throw new C2571p("expected OggS capture pattern at begin of page");
                        }
                    }
                }
                if (z) {
                    return false;
                }
                throw new EOFException();
            }
        }
        obj = 1;
        if (obj != null) {
            if (!c2304f.mo2188b(this.f5630l.f6441a, 0, 27, true)) {
                if (this.f5630l.m7109m() != ((long) f5619k)) {
                    this.f5620a = this.f5630l.m7103g();
                    if (this.f5620a != 0) {
                        this.f5621b = this.f5630l.m7103g();
                        this.f5622c = this.f5630l.m7114r();
                        this.f5623d = this.f5630l.m7110n();
                        this.f5624e = this.f5630l.m7110n();
                        this.f5625f = this.f5630l.m7110n();
                        this.f5626g = this.f5630l.m7103g();
                        this.f5627h = this.f5626g + true;
                        this.f5630l.m7088a();
                        c2304f.mo2191c(this.f5630l.f6441a, 0, this.f5626g);
                        while (i < this.f5626g) {
                            this.f5629j[i] = this.f5630l.m7103g();
                            this.f5628i += this.f5629j[i];
                            i++;
                        }
                        return true;
                    } else if (z) {
                        return false;
                    } else {
                        throw new C2571p("unsupported bit stream revision");
                    }
                } else if (z) {
                    return false;
                } else {
                    throw new C2571p("expected OggS capture pattern at begin of page");
                }
            }
        }
        if (z) {
            return false;
        }
        throw new EOFException();
    }
}
