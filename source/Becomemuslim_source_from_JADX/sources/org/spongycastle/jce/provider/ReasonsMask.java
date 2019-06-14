package org.spongycastle.jce.provider;

import org.spongycastle.asn1.x509.ReasonFlags;

class ReasonsMask {
    /* renamed from: a */
    static final ReasonsMask f23028a = new ReasonsMask(33023);
    /* renamed from: b */
    private int f23029b;

    ReasonsMask(ReasonFlags reasonFlags) {
        this.f23029b = reasonFlags.m43062j();
    }

    private ReasonsMask(int i) {
        this.f23029b = i;
    }

    ReasonsMask() {
        this(0);
    }

    /* renamed from: a */
    void m28287a(ReasonsMask reasonsMask) {
        this.f23029b = reasonsMask.m28289b() | this.f23029b;
    }

    /* renamed from: a */
    boolean m28288a() {
        return this.f23029b == f23028a.f23029b;
    }

    /* renamed from: b */
    ReasonsMask m28290b(ReasonsMask reasonsMask) {
        ReasonsMask reasonsMask2 = new ReasonsMask();
        reasonsMask2.m28287a(new ReasonsMask(reasonsMask.m28289b() & this.f23029b));
        return reasonsMask2;
    }

    /* renamed from: c */
    boolean m28291c(ReasonsMask reasonsMask) {
        return ((reasonsMask.m28289b() ^ this.f23029b) | this.f23029b) != null ? true : null;
    }

    /* renamed from: b */
    int m28289b() {
        return this.f23029b;
    }
}
