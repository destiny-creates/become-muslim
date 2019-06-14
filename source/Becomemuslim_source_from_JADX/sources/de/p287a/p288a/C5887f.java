package de.p287a.p288a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: HandlerPoster */
/* renamed from: de.a.a.f */
final class C5887f extends Handler {
    /* renamed from: a */
    private final C5890i f19590a = new C5890i();
    /* renamed from: b */
    private final int f19591b;
    /* renamed from: c */
    private final C5884c f19592c;
    /* renamed from: d */
    private boolean f19593d;

    C5887f(C5884c c5884c, Looper looper, int i) {
        super(looper);
        this.f19592c = c5884c;
        this.f19591b = i;
    }

    /* renamed from: a */
    void m24771a(C5894m c5894m, Object obj) {
        C5889h a = C5889h.m24772a(c5894m, obj);
        synchronized (this) {
            this.f19590a.m24776a(a);
            if (this.f19593d == null) {
                this.f19593d = true;
                if (sendMessage(obtainMessage()) == null) {
                    throw new C5886e("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                C5889h a = this.f19590a.m24774a();
                if (a == null) {
                    synchronized (this) {
                        a = this.f19590a.m24774a();
                        if (a == null) {
                            this.f19593d = false;
                            this.f19593d = false;
                            return;
                        }
                    }
                }
                this.f19592c.m24763a(a);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f19591b));
            if (sendMessage(obtainMessage())) {
                this.f19593d = true;
                return;
            }
            throw new C5886e("Could not send handler message");
        } catch (Throwable th) {
            this.f19593d = false;
        }
    }
}
