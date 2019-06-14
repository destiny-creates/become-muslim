package com.polidea.p254a.p256b.p262f;

import com.polidea.p254a.p256b.p261e.C5598i;
import java.util.concurrent.atomic.AtomicBoolean;
import p289e.C5982f;
import p289e.C7332c;
import p289e.p291b.C5917e;

/* compiled from: QueueReleasingEmitterWrapper */
/* renamed from: com.polidea.a.b.f.v */
public class C7082v<T> implements C5917e, C5982f<T> {
    /* renamed from: a */
    private final AtomicBoolean f25061a = new AtomicBoolean(false);
    /* renamed from: b */
    private final C7332c<T> f25062b;
    /* renamed from: c */
    private final C5598i f25063c;

    public C7082v(C7332c<T> c7332c, C5598i c5598i) {
        this.f25062b = c7332c;
        this.f25063c = c5598i;
        c7332c.mo6330a((C5917e) this);
    }

    public void L_() {
        this.f25063c.mo5017a();
        this.f25062b.L_();
    }

    /* renamed from: a */
    public void mo5001a(Throwable th) {
        this.f25063c.mo5017a();
        this.f25062b.mo5001a(th);
    }

    /* renamed from: a */
    public void mo5000a(T t) {
        this.f25062b.mo5000a((Object) t);
    }

    /* renamed from: a */
    public synchronized void mo4973a() {
        this.f25061a.set(true);
    }
}
