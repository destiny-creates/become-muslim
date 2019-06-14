package com.google.firebase.components;

import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
/* renamed from: com.google.firebase.components.n */
final class C5347n {
    /* renamed from: a */
    private final C5340a<?> f18022a;
    /* renamed from: b */
    private final Set<C5347n> f18023b = new HashSet();
    /* renamed from: c */
    private final Set<C5347n> f18024c = new HashSet();

    C5347n(C5340a<?> c5340a) {
        this.f18022a = c5340a;
    }

    /* renamed from: a */
    final void m22654a(C5347n c5347n) {
        this.f18023b.add(c5347n);
    }

    /* renamed from: b */
    final void m22656b(C5347n c5347n) {
        this.f18024c.add(c5347n);
    }

    /* renamed from: a */
    final Set<C5347n> m22653a() {
        return this.f18023b;
    }

    /* renamed from: c */
    final void m22657c(C5347n c5347n) {
        this.f18024c.remove(c5347n);
    }

    /* renamed from: b */
    final C5340a<?> m22655b() {
        return this.f18022a;
    }

    /* renamed from: c */
    final boolean m22658c() {
        return this.f18024c.isEmpty();
    }

    /* renamed from: d */
    final boolean m22659d() {
        return this.f18023b.isEmpty();
    }
}
