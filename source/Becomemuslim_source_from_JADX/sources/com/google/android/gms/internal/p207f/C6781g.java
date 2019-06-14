package com.google.android.gms.internal.p207f;

/* renamed from: com.google.android.gms.internal.f.g */
final class C6781g extends C4967d {
    /* renamed from: a */
    private final C4968e f24425a = new C4968e();

    C6781g() {
    }

    /* renamed from: a */
    public final void mo4397a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.f24425a.m20247a(th, true).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
