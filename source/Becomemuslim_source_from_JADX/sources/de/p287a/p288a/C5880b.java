package de.p287a.p288a;

import android.util.Log;

/* compiled from: BackgroundPoster */
/* renamed from: de.a.a.b */
final class C5880b implements Runnable {
    /* renamed from: a */
    private final C5890i f19551a = new C5890i();
    /* renamed from: b */
    private final C5884c f19552b;
    /* renamed from: c */
    private volatile boolean f19553c;

    C5880b(C5884c c5884c) {
        this.f19552b = c5884c;
    }

    /* renamed from: a */
    public void m24751a(C5894m c5894m, Object obj) {
        C5889h a = C5889h.m24772a(c5894m, obj);
        synchronized (this) {
            this.f19551a.m24776a(a);
            if (this.f19553c == null) {
                this.f19553c = true;
                this.f19552b.m24766b().execute(this);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                C5889h a = this.f19551a.m24775a(1000);
                if (a == null) {
                    synchronized (this) {
                        a = this.f19551a.m24774a();
                        if (a == null) {
                            this.f19553c = false;
                            this.f19553c = false;
                            return;
                        }
                    }
                }
                this.f19552b.m24763a(a);
            } catch (Throwable e) {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(Thread.currentThread().getName());
                    stringBuilder.append(" was interruppted");
                    Log.w("Event", stringBuilder.toString(), e);
                    return;
                } finally {
                    this.f19553c = false;
                }
            }
        }
    }
}
