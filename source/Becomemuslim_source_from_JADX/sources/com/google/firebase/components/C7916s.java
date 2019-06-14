package com.google.firebase.components;

import com.google.firebase.p244a.C5322c;
import com.google.firebase.p245b.C5334a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
/* renamed from: com.google.firebase.components.s */
final class C7916s extends C6903i {
    /* renamed from: a */
    private final Set<Class<?>> f29532a;
    /* renamed from: b */
    private final Set<Class<?>> f29533b;
    /* renamed from: c */
    private final Set<Class<?>> f29534c;
    /* renamed from: d */
    private final C5341b f29535d;

    /* compiled from: com.google.firebase:firebase-common@@16.0.2 */
    /* renamed from: com.google.firebase.components.s$a */
    static class C6909a implements C5322c {
        /* renamed from: a */
        private final Set<Class<?>> f24729a;
        /* renamed from: b */
        private final C5322c f24730b;

        public C6909a(Set<Class<?>> set, C5322c c5322c) {
            this.f24729a = set;
            this.f24730b = c5322c;
        }
    }

    C7916s(C5340a<?> c5340a, C5341b c5341b) {
        Set hashSet = new HashSet();
        Set hashSet2 = new HashSet();
        for (C5344e c5344e : c5340a.m22640b()) {
            if (c5344e.m22651c()) {
                hashSet.add(c5344e.m22649a());
            } else {
                hashSet2.add(c5344e.m22649a());
            }
        }
        if (!c5340a.m22642d().isEmpty()) {
            hashSet.add(C5322c.class);
        }
        this.f29532a = Collections.unmodifiableSet(hashSet);
        this.f29533b = Collections.unmodifiableSet(hashSet2);
        this.f29534c = c5340a.m22642d();
        this.f29535d = c5341b;
    }

    /* renamed from: a */
    public final <T> T mo4878a(Class<T> cls) {
        if (this.f29532a.contains(cls)) {
            T a = this.f29535d.mo4878a(cls);
            if (cls.equals(C5322c.class) == null) {
                return a;
            }
            return new C6909a(this.f29534c, (C5322c) a);
        }
        throw new IllegalArgumentException(String.format("Requesting %s is not allowed.", new Object[]{cls}));
    }

    /* renamed from: b */
    public final <T> C5334a<T> mo6263b(Class<T> cls) {
        if (this.f29533b.contains(cls)) {
            return this.f29535d.mo6263b(cls);
        }
        throw new IllegalArgumentException(String.format("Requesting Provider<%s> is not allowed.", new Object[]{cls}));
    }
}
