package com.google.android.gms.internal.ads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@cm
public class of<T> implements ob<T> {
    /* renamed from: a */
    private final Object f24191a = new Object();
    /* renamed from: b */
    private int f24192b = 0;
    /* renamed from: c */
    private final BlockingQueue<og> f24193c = new LinkedBlockingQueue();
    /* renamed from: d */
    private T f24194d;

    /* renamed from: a */
    public final void m30917a() {
        synchronized (this.f24191a) {
            if (this.f24192b == 0) {
                this.f24192b = -1;
                for (og ogVar : this.f24193c) {
                    ogVar.f15852b.mo3840a();
                }
                this.f24193c.clear();
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    /* renamed from: a */
    public final void mo4320a(oe<T> oeVar, oc ocVar) {
        synchronized (this.f24191a) {
            if (this.f24192b == 1) {
                oeVar.mo3839a(this.f24194d);
            } else if (this.f24192b == -1) {
                ocVar.mo3840a();
            } else if (this.f24192b == 0) {
                this.f24193c.add(new og(this, oeVar, ocVar));
            }
        }
    }

    /* renamed from: a */
    public final void mo4321a(T t) {
        synchronized (this.f24191a) {
            if (this.f24192b == 0) {
                this.f24194d = t;
                this.f24192b = 1;
                for (og ogVar : this.f24193c) {
                    ogVar.f15851a.mo3839a(t);
                }
                this.f24193c.clear();
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    /* renamed from: b */
    public final int m30920b() {
        return this.f24192b;
    }
}
