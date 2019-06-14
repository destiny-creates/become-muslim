package android.arch.lifecycle;

import android.arch.lifecycle.C0074c.C0072a;

class FullLifecycleObserverAdapter implements GenericLifecycleObserver {
    /* renamed from: a */
    private final FullLifecycleObserver f11812a;

    FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver) {
        this.f11812a = fullLifecycleObserver;
    }

    /* renamed from: a */
    public void mo2620a(C0076e c0076e, C0072a c0072a) {
        switch (c0072a) {
            case ON_CREATE:
                this.f11812a.m9113a(c0076e);
                return;
            case ON_START:
                this.f11812a.m9114b(c0076e);
                return;
            case ON_RESUME:
                this.f11812a.m9115c(c0076e);
                return;
            case ON_PAUSE:
                this.f11812a.m9116d(c0076e);
                return;
            case ON_STOP:
                this.f11812a.m9117e(c0076e);
                return;
            case ON_DESTROY:
                this.f11812a.m9118f(c0076e);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
