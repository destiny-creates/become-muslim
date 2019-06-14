package p289e.p292c.p294c;

import p289e.C5986h.C7353a;
import p289e.p290a.C5903b;
import p289e.p291b.C5913a;

/* compiled from: SleepingAction */
/* renamed from: e.c.c.l */
class C7303l implements C5913a {
    /* renamed from: a */
    private final C5913a f25690a;
    /* renamed from: b */
    private final C7353a f25691b;
    /* renamed from: c */
    private final long f25692c;

    public C7303l(C5913a c5913a, C7353a c7353a, long j) {
        this.f25690a = c5913a;
        this.f25691b = c7353a;
        this.f25692c = j;
    }

    /* renamed from: a */
    public void mo4985a() {
        if (!this.f25691b.mo5121b()) {
            long T_ = this.f25692c - this.f25691b.T_();
            if (T_ > 0) {
                try {
                    Thread.sleep(T_);
                } catch (Throwable e) {
                    Thread.currentThread().interrupt();
                    C5903b.m24788a(e);
                }
            }
            if (!this.f25691b.mo5121b()) {
                this.f25690a.mo4985a();
            }
        }
    }
}
