package com.google.android.gms.internal.p209h;

/* renamed from: com.google.android.gms.internal.h.q */
final class C6786q extends C4988n {
    /* renamed from: a */
    private final C4989o f24427a = new C4989o();

    C6786q() {
    }

    /* renamed from: a */
    public final void mo4411a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.f24427a.m20275a(th, true).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
