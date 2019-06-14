package android.arch.lifecycle;

import android.arch.lifecycle.C0070a.C0068a;
import android.arch.lifecycle.C0074c.C0072a;

class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {
    /* renamed from: a */
    private final Object f11815a;
    /* renamed from: b */
    private final C0068a f11816b = C0070a.f197a.m176b(this.f11815a.getClass());

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f11815a = obj;
    }

    /* renamed from: a */
    public void mo2620a(C0076e c0076e, C0072a c0072a) {
        this.f11816b.m170a(c0076e, c0072a, this.f11815a);
    }
}
