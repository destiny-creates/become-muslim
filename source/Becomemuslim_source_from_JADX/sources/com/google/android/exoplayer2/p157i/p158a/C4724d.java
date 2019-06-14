package com.google.android.exoplayer2.p157i.p158a;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.p157i.C2464e;
import com.google.android.exoplayer2.p157i.C4230f;
import com.google.android.exoplayer2.p157i.C4726i;
import com.google.android.exoplayer2.p157i.C4727j;
import com.google.android.exoplayer2.p164l.C2516a;
import java.util.LinkedList;
import java.util.PriorityQueue;

/* compiled from: CeaDecoder */
/* renamed from: com.google.android.exoplayer2.i.a.d */
abstract class C4724d implements C4230f {
    /* renamed from: a */
    private final LinkedList<C4726i> f12865a = new LinkedList();
    /* renamed from: b */
    private final LinkedList<C4727j> f12866b;
    /* renamed from: c */
    private final PriorityQueue<C4726i> f12867c;
    /* renamed from: d */
    private C4726i f12868d;
    /* renamed from: e */
    private long f12869e;

    /* renamed from: a */
    protected abstract void mo3424a(C4726i c4726i);

    /* renamed from: d */
    public void mo2150d() {
    }

    /* renamed from: e */
    protected abstract boolean mo3426e();

    /* renamed from: f */
    protected abstract C2464e mo3427f();

    /* renamed from: a */
    public /* synthetic */ Object mo2146a() {
        return mo3429h();
    }

    /* renamed from: a */
    public /* synthetic */ void mo2147a(Object obj) {
        mo3425b((C4726i) obj);
    }

    /* renamed from: b */
    public /* synthetic */ Object mo2148b() {
        return mo3428g();
    }

    public C4724d() {
        for (int i = 0; i < 10; i++) {
            this.f12865a.add(new C4726i());
        }
        this.f12866b = new LinkedList();
        for (int i2 = 0; i2 < 2; i2++) {
            this.f12866b.add(new C4859e(this));
        }
        this.f12867c = new PriorityQueue();
    }

    /* renamed from: a */
    public void mo3242a(long j) {
        this.f12869e = j;
    }

    /* renamed from: h */
    public C4726i mo3429h() {
        C2516a.m7019b(this.f12868d == null);
        if (this.f12865a.isEmpty()) {
            return null;
        }
        this.f12868d = (C4726i) this.f12865a.pollFirst();
        return this.f12868d;
    }

    /* renamed from: b */
    public void mo3425b(C4726i c4726i) {
        C2516a.m7017a(c4726i == this.f12868d);
        if (c4726i.g_()) {
            m16239c(c4726i);
        } else {
            this.f12867c.add(c4726i);
        }
        this.f12868d = null;
    }

    /* renamed from: g */
    public C4727j mo3428g() {
        if (this.f12866b.isEmpty()) {
            return null;
        }
        while (!this.f12867c.isEmpty() && ((C4726i) this.f12867c.peek()).c <= this.f12869e) {
            C4726i c4726i = (C4726i) this.f12867c.poll();
            if (c4726i.m6206c()) {
                C4727j c4727j = (C4727j) this.f12866b.pollFirst();
                c4727j.m6204b(4);
                m16239c(c4726i);
                return c4727j;
            }
            mo3424a(c4726i);
            if (mo3426e()) {
                C2464e f = mo3427f();
                if (!c4726i.g_()) {
                    c4727j = (C4727j) this.f12866b.pollFirst();
                    c4727j.m16267a(c4726i.c, f, Clock.MAX_TIME);
                    m16239c(c4726i);
                    return c4727j;
                }
            }
            m16239c(c4726i);
        }
        return null;
    }

    /* renamed from: c */
    private void m16239c(C4726i c4726i) {
        c4726i.mo2145a();
        this.f12865a.add(c4726i);
    }

    /* renamed from: a */
    protected void m16243a(C4727j c4727j) {
        c4727j.mo2145a();
        this.f12866b.add(c4727j);
    }

    /* renamed from: c */
    public void mo2149c() {
        this.f12869e = 0;
        while (!this.f12867c.isEmpty()) {
            m16239c((C4726i) this.f12867c.poll());
        }
        if (this.f12868d != null) {
            m16239c(this.f12868d);
            this.f12868d = null;
        }
    }
}
